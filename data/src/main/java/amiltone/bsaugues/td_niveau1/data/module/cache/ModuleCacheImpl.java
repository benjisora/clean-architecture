package amiltone.bsaugues.td_niveau1.data.module.cache;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import amiltone.bsaugues.td_niveau1.data.entity.ComicEntity;

/**
 * Created by amiltonedev_dt013 on 29/09/2017.
 */
@Singleton
public class ModuleCacheImpl implements ModuleCache {

    private List<ComicEntity> comicList;

    @Inject
    public ModuleCacheImpl() {
        comicList = new ArrayList<>();
    }

    @Override
    public void insertComicsList(List<ComicEntity> comics) {
        comicList.addAll(comics);
    }

    @Override
    public void insertComics(ComicEntity comicEntity) {
        comicList.add(comicEntity);
    }

    @Override
    public List<ComicEntity> getComicsList() {
        return comicList;
    }

    @Override
    public ComicEntity getComicsById(int id) {
        for (ComicEntity comic : comicList) {
            if (comic.getId() == id) {
                return comic;
            }
        }
        return null;
    }

    @Override
    public boolean isCacheEmpty() {
        return comicList == null || comicList.isEmpty();
    }

    @Override
    public void clearCache() {
        comicList.clear();
    }


}
