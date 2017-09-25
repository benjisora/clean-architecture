package amiltone.bsaugues.td_niveau1.data.manager.cache;

import java.util.List;

import amiltone.bsaugues.td_niveau1.data.exception.NoComicInCacheException;
import amiltone.bsaugues.td_niveau1.data.entity.ComicEntity;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public interface CacheManager {

    ComicEntity getComicById(int id);

    void saveComicList(List<ComicEntity> comics);

    void saveComic(ComicEntity comicEntity);

    List<ComicEntity> getCachedList();

    boolean isCacheEmpty();
}