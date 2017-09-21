package amiltone.bsaugues.td_niveau1;

import android.app.Application;

import amiltone.bsaugues.td_niveau1.data.ApiRepository;
import amiltone.bsaugues.td_niveau1.data.MarvelApiManagerImpl;
import amiltone.bsaugues.td_niveau1.presentation.Navigator;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public class TdApplication extends Application {

    public static final String BASE_URL = "http://gateway.marvel.com/v1/public/";

    private ApiRepository apiRepository = new ApiRepository(new MarvelApiManagerImpl());
    private Navigator navigator;

    private static final TdApplication ourInstance = new TdApplication();

    public static TdApplication getInstance() {
        return ourInstance;
    }

    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    public Navigator getNavigator() {
        return navigator;
    }

    public ApiRepository getApiRepository() {
        return apiRepository;
    }

}