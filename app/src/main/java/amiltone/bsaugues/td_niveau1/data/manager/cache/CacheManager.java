package amiltone.bsaugues.td_niveau1.data.manager.cache;

import java.util.List;

import amiltone.bsaugues.td_niveau1.data.model.Comic;
import rx.Observable;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public interface CacheManager {

    Observable<Comic> getComicById(int id);

    //TODO : fonction saveComicList (enregistre la liste de l'API)

}