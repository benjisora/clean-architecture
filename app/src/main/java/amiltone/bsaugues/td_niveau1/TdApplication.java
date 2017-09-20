package amiltone.bsaugues.td_niveau1;

import android.app.Application;

import amiltone.bsaugues.td_niveau1.data.MarvelApiManagerImpl;
import amiltone.bsaugues.td_niveau1.data.Repository;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public class TdApplication extends Application {

    public static final String BASE_URL = "http://gateway.marvel.com/v1/public/";

    private static final TdApplication ourInstance = new TdApplication();

    private Repository repository;

    public static TdApplication getInstance() {
        return ourInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        repository = new Repository(new MarvelApiManagerImpl());
    }
}