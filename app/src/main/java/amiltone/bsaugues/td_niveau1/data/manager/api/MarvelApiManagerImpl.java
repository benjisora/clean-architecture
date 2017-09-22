package amiltone.bsaugues.td_niveau1.data.manager.api;

import java.util.List;

import amiltone.bsaugues.td_niveau1.data.manager.api.MarvelApiManager;
import amiltone.bsaugues.td_niveau1.data.model.Comic;
import amiltone.bsaugues.td_niveau1.data.model.RootEnveloppe;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public class MarvelApiManagerImpl implements MarvelApiManager {

    interface ApiService {
        @GET("comics")
        Observable<RootEnveloppe> getComicsList(@Query("apikey") String apiKey,
                                                @Query("ts") String timeStamp,
                                                @Query("hash") String hash,
                                                @Query("format") String format,
                                                @Query("dateDescriptor") String dateDescriptor);
    }

    private ApiService apiService;

    public MarvelApiManagerImpl() {
        this.apiService = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build().create(ApiService.class);
    }


    @Override
    public Observable<List<Comic>> getComicsListFromApi() {
        return apiService.getComicsList("3a1d27d3ebfd7097c0b6dd5a067266cf",
                "1473236363",
                "9945a7b9b2b8145a570e619ab7680592",
                "comic",
                "lastWeek")
                .map(new Func1<RootEnveloppe, List<Comic>>() {
                    @Override
                    public List<Comic> call(RootEnveloppe rootEnveloppe) {
                        return rootEnveloppe.data.results;
                    }
                });
    }

    @Override
    public Observable<Comic> getComicFromApi() {
        return null;
    }
}
