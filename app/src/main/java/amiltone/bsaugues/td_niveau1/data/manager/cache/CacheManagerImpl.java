package amiltone.bsaugues.td_niveau1.data.manager.cache;

import java.util.List;

import amiltone.bsaugues.td_niveau1.data.model.Comic;
import amiltone.bsaugues.td_niveau1.data.model.RootEnveloppe;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import rx.schedulers.Schedulers;

import static amiltone.bsaugues.td_niveau1.data.manager.api.MarvelApiManager.BASE_URL;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public class CacheManagerImpl implements CacheManager {

    private List<Comic> comicList;

    public CacheManagerImpl() {

    }

    @Override
    public Observable<Comic> getComicById(int id) {
        //TODO: if(id dans la liste, return
        return null;
    }
}
