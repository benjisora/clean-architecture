package amiltone.bsaugues.td_niveau1.data.manager.cache;

import java.util.ArrayList;
import java.util.List;

import amiltone.bsaugues.td_niveau1.data.exception.ComicNotFoundException;
import amiltone.bsaugues.td_niveau1.data.exception.NoComicInCacheException;
import amiltone.bsaugues.td_niveau1.data.model.Comic;
import rx.Observable;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public class CacheManagerImpl implements CacheManager {

    private List<Comic> comicList;

    public CacheManagerImpl() {
        comicList = new ArrayList<>();
    }

    @Override
    public Comic getComicById(int id) {

        for(Comic comic : comicList){
            if(comic.getId() == id){
                return comic;
            }
        }
        throw new ComicNotFoundException();
    }

    @Override
    public void saveComicList(List<Comic> comics) {
        comicList.clear();
        comicList.addAll(comics);
    }

    @Override
    public List<Comic> getCachedList() {
        if(isCacheEmpty()){
            throw null;
        } else {
            return comicList;
        }

    }

    @Override
    public boolean isCacheEmpty() {
        return comicList == null || comicList.isEmpty();
    }


}
