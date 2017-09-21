package amiltone.bsaugues.td_niveau1.data.repository;

import java.util.List;

import amiltone.bsaugues.td_niveau1.data.manager.api.MarvelApiManager;
import amiltone.bsaugues.td_niveau1.data.manager.cache.CacheManager;
import amiltone.bsaugues.td_niveau1.data.model.Comic;
import rx.Observable;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public class ContentRepository {

    private MarvelApiManager marvelApiManager;
    private CacheManager cacheManager;

    public ContentRepository(MarvelApiManager apiManager, CacheManager cacheManager) {
        this.marvelApiManager = apiManager;
        this.cacheManager = cacheManager;
    }

    public Observable<List<Comic>> getComicsList() {
        return marvelApiManager.getComicsListFromApi();
    }

    public Observable<Comic> getComicById(int id){
        return cacheManager.getComicById(id);
    }

}
