package amiltone.bsaugues.td_niveau1.data.repository;

import android.util.Log;

import java.util.List;

import amiltone.bsaugues.td_niveau1.data.manager.api.MarvelApiManager;
import amiltone.bsaugues.td_niveau1.data.manager.cache.CacheManager;
import amiltone.bsaugues.td_niveau1.data.manager.database.DatabaseManager;
import amiltone.bsaugues.td_niveau1.data.model.Comic;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func0;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public class ContentRepository {

    private MarvelApiManager marvelApiManager;
    private CacheManager cacheManager;
    private DatabaseManager databaseManager;

    public ContentRepository(MarvelApiManager apiManager, CacheManager cacheManager, DatabaseManager databaseManager) {
        this.marvelApiManager = apiManager;
        this.cacheManager = cacheManager;
        this.databaseManager = databaseManager;
    }

    public Observable<List<Comic>> getComicsList() {

        if (cacheManager.isCacheEmpty()) {

            if (databaseManager.isDatabaseEmpty()) {
                return Observable.defer(new Func0<Observable<List<Comic>>>() {
                    @Override
                    public Observable<List<Comic>> call() {
                        Log.d("ContentRepository", "Gotten from cache");
                        return Observable.just(databaseManager.getDatabaseList());
                    }
                });
            } else {
                return marvelApiManager.getComicsListFromApi().doOnNext(new Action1<List<Comic>>() {
                    @Override
                    public void call(List<Comic> comics) {
                        Log.d("ContentRepository", "Saved in cache");
                        cacheManager.saveComicList(comics);
                        databaseManager.saveComicList(comics);
                    }
                });
            }
        } else {
            return Observable.defer(new Func0<Observable<List<Comic>>>() {
                @Override
                public Observable<List<Comic>> call() {
                    Log.d("ContentRepository", "Gotten from cache");
                    return Observable.just(cacheManager.getCachedList());
                }
            });
        }

    }

    public Observable<Comic> getComicById(final int id) {

        return Observable.defer(new Func0<Observable<Comic>>() {
            @Override
            public Observable<Comic> call() {
                return Observable.just(cacheManager.getComicById(id));
            }
        });
    }


}
