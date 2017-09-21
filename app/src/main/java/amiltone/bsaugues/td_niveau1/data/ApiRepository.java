package amiltone.bsaugues.td_niveau1.data;

import java.util.List;

import amiltone.bsaugues.td_niveau1.data.model.Comic;
import rx.Observable;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public class ApiRepository {

    private MarvelApiManager marvelApiManager;

    public ApiRepository(MarvelApiManager apiManager) {
        this.marvelApiManager = apiManager;
    }

    public Observable<List<Comic>> getComicsList() {
        return marvelApiManager.getComicsListFromApi();
    }

}
