package amiltone.bsaugues.td_niveau1.data;

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
    Observable<List<Comic>> getComicsList();
}