package amiltone.bsaugues.td_niveau1.data;

import java.util.ArrayList;
import java.util.List;

import amiltone.bsaugues.td_niveau1.data.model.Comic;
import rx.Observable;
import rx.functions.Func0;
import rx.functions.Func1;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public class Repository {

    private MarvelApiManager marvelApiManager;

    public Repository(MarvelApiManager apiManager) {
        this.marvelApiManager = apiManager;
    }

    public Observable<List<Comic>> getComicsList() {
        return marvelApiManager.getComicsList();
    }

}
