package amiltone.bsaugues.td_niveau1.data.manager.api;

import java.util.List;

import amiltone.bsaugues.td_niveau1.data.entity.ComicEntity;
import amiltone.bsaugues.td_niveau1.data.entity.remote.ComicRemoteEntity;
import rx.Observable;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public interface MarvelApiManager {

    String BASE_URL = "http://gateway.marvel.com/v1/public/";

    Observable<List<ComicRemoteEntity>> getComicsListFromApi();

}