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

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.atLeastOnce;
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

    private ContentRepository contentRepository;

    @Before
    public void setUp() throws Exception {

        marvelApiManager = Mockito.mock(MarvelApiManagerImpl.class);
        cacheManager = Mockito.mock(CacheManagerImpl.class);
        databaseManager = Mockito.mock(DatabaseManagerImpl.class);

        contentRepository = Mockito.spy(new ContentRepository(marvelApiManager, cacheManager, databaseManager));
    }

    @Test
    public void getComicsListFromApiSuccess() {

        when(cacheManager.getCachedList()).thenThrow(NoComicInCacheException.class);
        when(databaseManager.getDatabaseList()).thenThrow(NoComicInDatabaseException.class);

        List<ComicRemoteEntity> list = new ArrayList<>();
        when(marvelApiManager.getComicsListFromApi()).thenReturn(Observable.just(list));

        contentRepository.getComicsList();

        verify(marvelApiManager, atLeastOnce()).getComicsListFromApi();
    }

    @Test
    public void getComicsListFromDatabaseSuccess() throws Exception {
        when(cacheManager.getCachedList()).thenThrow(NoComicInCacheException.class);

        when(databaseManager.getDatabaseList()).thenReturn(new ArrayList<ComicDBEntity>());

        assertThat(contentRepository.getComicsList()).isNotNull();
        verify(databaseManager, times(1)).getDatabaseList();
        verify(marvelApiManager, never()).getComicsListFromApi();
    }

    @Test
    public void getComicsListFromCacheSuccess() throws Exception {

        when(cacheManager.getCachedList()).thenReturn(new ArrayList<ComicEntity>());

        assertThat(contentRepository.getComicsList()).isNotNull();
        verify(databaseManager, never()).getDatabaseList();
        verify(marvelApiManager, never()).getComicsListFromApi();
    }

    @Test
    public void getComicById() throws Exception {

    }

}