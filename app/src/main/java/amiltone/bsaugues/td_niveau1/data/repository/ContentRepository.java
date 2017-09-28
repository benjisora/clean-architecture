package amiltone.bsaugues.td_niveau1.data.repository;

import android.util.Log;

import java.util.List;

import amiltone.bsaugues.td_niveau1.data.entity.ComicEntity;
import amiltone.bsaugues.td_niveau1.data.entity.db.ComicDBEntity;
import amiltone.bsaugues.td_niveau1.data.entity.mapper.db.ComicDBEntityDataMapper;
import amiltone.bsaugues.td_niveau1.data.entity.mapper.remote.ComicEntityDataMapper;
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

        return Observable.defer(new Func0<Observable<List<ComicEntity>>>() {
            @Override
            public Observable<List<ComicEntity>> call() {
                //Log.d("ContentRepository", "Try to get list from cache");
                return Observable.just(cacheManager.getCachedList());
            }
        }).onErrorResumeNext(new Func1<Throwable, Observable<? extends List<ComicEntity>>>() {
            @Override
            public Observable<? extends List<ComicEntity>> call(Throwable throwable) {
                return Observable.just(databaseManager.getDatabaseList()).map(new Func1<List<ComicDBEntity>, List<ComicEntity>>() {
                    @Override
                    public List<ComicEntity> call(List<ComicDBEntity> comicDBEntities) {
                        //Log.d("ContentRepository", "Gotten list from DB");
                        return comicDBEntityDataMapper.transformToEntity(comicDBEntities);
                    }
                }).doOnNext(new Action1<List<ComicEntity>>() {
                    @Override
                    public void call(List<ComicEntity> comicEntities) {
                        //Log.d("ContentRepository", "Saved list in cache from DB");
                        cacheManager.saveComicList(comicEntities);
                    }
                });
            }
        }).onErrorResumeNext(new Func1<Throwable, Observable<? extends List<ComicEntity>>>() {
            @Override
            public Observable<? extends List<ComicEntity>> call(Throwable throwable) {
                return marvelApiManager.getComicsListFromApi().map(new Func1<List<ComicRemoteEntity>, List<ComicEntity>>() {
                    @Override
                    public List<ComicEntity> call(List<ComicRemoteEntity> comicRemoteEntities) {
                        //Log.d("ContentRepository", "Gotten list from API");
                        return comicEntityDataMapper.transformToEntity(comicRemoteEntities);
                    }
                }).doOnNext(new Action1<List<ComicEntity>>() {
                    @Override
                    public void call(List<ComicEntity> comicEntities) {
                        //Log.d("ContentRepository", "Saved list in cache and DB from API");
                        databaseManager.saveComicList(comicDBEntityDataMapper.transformToDB(comicEntities));
                        cacheManager.saveComicList(comicEntities);
                    }
                });
            }
        });

    }

    public Observable<ComicEntity> getComicById(final int id) {

        if (cacheManager.isCacheEmpty()) {

            if (!databaseManager.isDatabaseEmpty()) {
                Log.d("ContentRepository", "Gotten single comic from DB");
                return Observable.defer(new Func0<Observable<ComicEntity>>() {
                    @Override
                    public Observable<ComicEntity> call() {
                        return Observable.just(comicDBEntityDataMapper.transformToEntity(databaseManager.getComicById(id)));
                    }
                }).doOnNext(new Action1<ComicEntity>() {
                    @Override
                    public void call(ComicEntity comicEntity) {
                        Log.d("ContentRepository", "Saved single comic in cache from DB");
                        cacheManager.saveComic(comicEntity);
                    }
                });
            } else {
                return Observable.empty();
            }

        } else {
            Log.d("ContentRepository", "Gotten single comic from Cache");
            return Observable.defer(new Func0<Observable<ComicEntity>>() {
                @Override
                public Observable<ComicEntity> call() {
                    return Observable.just(cacheManager.getComicById(id));
                }
            });
        }

    }


}
