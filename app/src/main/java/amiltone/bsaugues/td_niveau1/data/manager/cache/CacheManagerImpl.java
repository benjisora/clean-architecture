package amiltone.bsaugues.td_niveau1.data.manager.cache;

import java.util.ArrayList;
import java.util.List;

import amiltone.bsaugues.td_niveau1.data.exception.ComicNotFoundException;
import amiltone.bsaugues.td_niveau1.data.entity.ComicEntity;
import amiltone.bsaugues.td_niveau1.data.exception.NoComicInCacheException;
import amiltone.bsaugues.td_niveau1.data.exception.NullParameterException;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public class CacheManagerImpl implements CacheManager {

    private List<ComicEntity> comicList;

    public CacheManagerImpl() {
        comicList = new ArrayList<>();
    }

    @Override
    public ComicEntity getComicById(int id) {

        for(ComicEntity comic : comicList){
            if(comic.getId() == id){
                return comic;
            }
        }
        throw new ComicNotFoundException();
    }

    @Override
    public void saveComicList(List<ComicEntity> comics) {
        if(comics != null){
            comicList.clear();
            comicList.addAll(comics);
        } else {
            throw new NullParameterException();
        }
    }

    @Override
    public void saveComic(ComicEntity comicEntity) {
        if(comicEntity != null){
            comicList.add(comicEntity);
        } else {
            throw new NullParameterException();
        }

    }

    @Override
    public List<ComicEntity> getCachedList() {
        if(isCacheEmpty()){
            throw new NoComicInCacheException();
        } else {
            return comicList;
        }
    }

    @Override
    public boolean isCacheEmpty() {
        return comicList == null || comicList.isEmpty();
    }


}
