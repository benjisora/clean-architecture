package amiltone.bsaugues.td_niveau1.data.repository;

import android.util.Log;

import java.util.List;

import amiltone.bsaugues.td_niveau1.data.entity.ComicEntity;
import amiltone.bsaugues.td_niveau1.data.entity.mapper.ComicDBEntityDataMapper;
import amiltone.bsaugues.td_niveau1.data.entity.mapper.ComicEntityDataMapper;
import amiltone.bsaugues.td_niveau1.data.entity.remote.ComicRemoteEntity;
import amiltone.bsaugues.td_niveau1.data.manager.api.MarvelApiManager;
import amiltone.bsaugues.td_niveau1.data.manager.cache.CacheManager;
import amiltone.bsaugues.td_niveau1.data.manager.database.DatabaseManager;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public class ContentRepository {

    private MarvelApiManager marvelApiManager;
    private CacheManager cacheManager;
    private DatabaseManager databaseManager;

    private ComicEntityDataMapper comicEntityDataMapper;
    private ComicDBEntityDataMapper comicDBEntityDataMapper;


    public ContentRepository(MarvelApiManager apiManager, CacheManager cacheManager, DatabaseManager databaseManager) {
        this.marvelApiManager = apiManager;
        this.cacheManager = cacheManager;
        this.databaseManager = databaseManager;
        comicEntityDataMapper = new ComicEntityDataMapper();
        comicDBEntityDataMapper = new ComicDBEntityDataMapper();
    }

    public Observable<List<ComicEntity>> getComicsList() {

        if (cacheManager.isCacheEmpty()) {

            if (databaseManager.isDatabaseEmpty()) {


                return marvelApiManager.getComicsListFromApi().map(new Func1<List<ComicRemoteEntity>, List<ComicEntity>>() {
                    @Override
                    public List<ComicEntity> call(List<ComicRemoteEntity> comicRemoteEntities) {
                        return comicEntityDataMapper.transformToEntity(comicRemoteEntities);
                    }
                }).doOnNext(new Action1<List<ComicEntity>>() {
                    @Override
                    public void call(List<ComicEntity> comicEntities) {
                        Log.d("ContentRepository", "Saved in cache");
                        //cacheManager.saveComicList(comicRemoteEntities);
                        cacheManager.saveComicList(comicEntities);
                    }
                });

            } else {
                return Observable.defer(new Func0<Observable<List<ComicEntity>>>() {
                    @Override
                    public Observable<List<ComicEntity>> call() {
                        Log.d("ContentRepository", "Gotten from cache");
                        return Observable.just(comicDBEntityDataMapper.transformToEntity(databaseManager.getDatabaseList()));
                    }
                });
            }
        } else {
            return Observable.defer(new Func0<Observable<List<ComicEntity>>>() {
                @Override
                public Observable<List<ComicEntity>> call() {
                    Log.d("ContentRepository", "Gotten from cache");
                    return Observable.just(cacheManager.getCachedList());
                }
            });
        }

    }

    public Observable<ComicEntity> getComicById(final int id) {

        return Observable.defer(new Func0<Observable<ComicEntity>>() {
            @Override
            public Observable<ComicEntity> call() {
                return Observable.just(cacheManager.getComicById(id));
            }
        });
    }


}
