package amiltone.bsaugues.td_niveau1.data.repository;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import amiltone.bsaugues.td_niveau1.data.entity.ComicEntity;
import amiltone.bsaugues.td_niveau1.data.entity.db.ComicDBEntity;
import amiltone.bsaugues.td_niveau1.data.entity.remote.ComicRemoteEntity;
import amiltone.bsaugues.td_niveau1.data.exception.NoComicInCacheException;
import amiltone.bsaugues.td_niveau1.data.exception.NoComicInDatabaseException;
import amiltone.bsaugues.td_niveau1.data.manager.api.MarvelApiManager;
import amiltone.bsaugues.td_niveau1.data.manager.api.MarvelApiManagerImpl;
import amiltone.bsaugues.td_niveau1.data.manager.cache.CacheManager;
import amiltone.bsaugues.td_niveau1.data.manager.cache.CacheManagerImpl;
import amiltone.bsaugues.td_niveau1.data.manager.database.DatabaseManager;
import amiltone.bsaugues.td_niveau1.data.manager.database.DatabaseManagerImpl;
import rx.Observable;
import rx.Subscriber;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.fail;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * Created by amiltonedev_dt013 on 27/09/2017.
 */
public class ContentRepositoryTest {

    @Mock
    MarvelApiManager marvelApiManager;

    @Mock
    CacheManager cacheManager;

    @Mock
    DatabaseManager databaseManager;

    //@Rule
    //public MockitoRule mockitoRule = MockitoJUnit.rule();

    private ContentRepositoryImpl contentRepository;

    @Before
    public void setUp() throws Exception {

        marvelApiManager = Mockito.mock(MarvelApiManagerImpl.class);
        cacheManager = Mockito.mock(CacheManagerImpl.class);
        databaseManager = Mockito.mock(DatabaseManagerImpl.class);

        contentRepository = Mockito.spy(new ContentRepositoryImpl(marvelApiManager, cacheManager, databaseManager));
    }

    @Test
    public void getComicsListFromApiSuccess() {

        List<ComicRemoteEntity> list = new ArrayList<>();
        final ComicRemoteEntity comicRemoteEntity = new ComicRemoteEntity();
        int id = 1;
        comicRemoteEntity.setId(id);
        list.add(comicRemoteEntity);

        when(cacheManager.getCachedList()).thenThrow(NoComicInCacheException.class);
        when(databaseManager.getDatabaseList()).thenThrow(NoComicInDatabaseException.class);
        when(marvelApiManager.getComicsListFromApi()).thenReturn(Observable.just(list));

        contentRepository.getComicsList().subscribe(new Subscriber<List<ComicEntity>>() {
            @Override
            public void onCompleted() {
                verify(marvelApiManager, times(1)).getComicsListFromApi();
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(List<ComicEntity> comicEntities) {
                assertThat(comicEntities).isNotEmpty().isEqualTo(comicEntities);
            }
        });


    }

    @Test
    public void getComicsListFromDatabaseSuccess() {

        List<ComicDBEntity> comicDBEntities = new ArrayList<>();
        ComicDBEntity comicDBEntity = new ComicDBEntity();
        int id = 8;
        comicDBEntity.setId(id);
        comicDBEntities.add(comicDBEntity);

        when(cacheManager.getCachedList()).thenThrow(NoComicInCacheException.class);
        when(databaseManager.getDatabaseList()).thenReturn(comicDBEntities);

        contentRepository.getComicsList().subscribe(new Subscriber<List<ComicEntity>>() {
            @Override
            public void onCompleted() {
                verify(databaseManager, times(1)).getDatabaseList();
                verify(marvelApiManager, never()).getComicsListFromApi();
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(List<ComicEntity> comicEntities) {
                assertThat(comicEntities).isNotNull();

            }
        });

    }

    @Test
    public void getComicsListFromCacheSuccess() throws Exception {

        when(cacheManager.getCachedList()).thenReturn(new ArrayList<ComicEntity>());

        contentRepository.getComicsList().subscribe(new Subscriber<List<ComicEntity>>() {
            @Override
            public void onCompleted() {
                verify(databaseManager, never()).getDatabaseList();
                verify(marvelApiManager, never()).getComicsListFromApi();
            }

            @Override
            public void onError(Throwable e) {
                e.printStackTrace();
            }

            @Override
            public void onNext(List<ComicEntity> comicEntities) {
                assertThat(comicEntities).isNotNull().isEmpty();
            }
        });
    }


}