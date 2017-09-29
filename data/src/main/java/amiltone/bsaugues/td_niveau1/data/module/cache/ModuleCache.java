package amiltone.bsaugues.td_niveau1.data.module.cache;

import java.util.List;

import amiltone.bsaugues.td_niveau1.data.entity.ComicEntity;

/**
 * Created by amiltonedev_dt013 on 29/09/2017.
 */

public interface ModuleCache {

    void insertComicsList(List<ComicEntity> comics);

    void insertComics(ComicEntity comicEntity);

    List<ComicEntity> getComicsList();

    ComicEntity getComicsById(int id);

    boolean isCacheEmpty();

    void clearCache();

}
