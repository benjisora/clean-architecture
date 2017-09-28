package amiltone.bsaugues.td_niveau1;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowConfig;
import com.raizlabs.android.dbflow.config.FlowManager;

import amiltone.bsaugues.td_niveau1.data.manager.api.MarvelApiManagerImpl;
import amiltone.bsaugues.td_niveau1.data.manager.cache.CacheManagerImpl;
import amiltone.bsaugues.td_niveau1.data.manager.database.DatabaseManagerImpl;
import amiltone.bsaugues.td_niveau1.data.repository.ContentRepository;
import amiltone.bsaugues.td_niveau1.presentation.navigator.Navigator;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public class TdApplication {

    private ContentRepository contentRepository;
    private Navigator navigator;

    private static TdApplication ourInstance = new TdApplication();

    private TdApplication(){
        contentRepository = new ContentRepository(new MarvelApiManagerImpl(), new CacheManagerImpl(), new DatabaseManagerImpl());
    }

    public static TdApplication getInstance() {
        return ourInstance;
    }

    public void setNavigator(Navigator navigator) {
        this.navigator = navigator;
    }

    public Navigator getNavigator() {
        return navigator;
    }

    public ContentRepository getContentRepository() {
        return contentRepository;
    }

}