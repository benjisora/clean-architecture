package amiltone.bsaugues.td_niveau1.data.manager.api;

import java.util.List;

import amiltone.bsaugues.td_niveau1.data.model.Comic;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;
import rx.Observable;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public interface MarvelApiManager {

    String BASE_URL = "http://gateway.marvel.com/v1/public/";

    Observable<List<Comic>> getComicsListFromApi();

    Observable<Comic> getComicFromApi();

}