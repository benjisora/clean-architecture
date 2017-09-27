package amiltone.bsaugues.td_niveau1.data.manager.cache;

import java.util.List;

import amiltone.bsaugues.td_niveau1.data.exception.NoComicInCacheException;
import amiltone.bsaugues.td_niveau1.data.entity.ComicEntity;
import amiltone.bsaugues.td_niveau1.data.exception.NullParameterException;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public interface CacheManager {

    ComicEntity getComicById(int id) throws NoComicInCacheException;

    void saveComicList(List<ComicEntity> comics) throws NullParameterException;

    void saveComic(ComicEntity comicEntity) throws NullParameterException;

    List<ComicEntity> getCachedList() throws NoComicInCacheException;

    boolean isCacheEmpty();
}