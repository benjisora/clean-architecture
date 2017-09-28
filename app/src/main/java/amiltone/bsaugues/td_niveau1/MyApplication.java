package amiltone.bsaugues.td_niveau1;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowManager;

import amiltone.bsaugues.td_niveau1.presentation.di.ActivityModule;
import amiltone.bsaugues.td_niveau1.presentation.di.ApplicationModule;
import amiltone.bsaugues.td_niveau1.presentation.di.component.ApplicationComponent;
import amiltone.bsaugues.td_niveau1.presentation.di.component.DaggerActivityComponent;
import amiltone.bsaugues.td_niveau1.presentation.di.component.DaggerApplicationComponent;

/**
 * Created by amiltonedev_dt013 on 22/09/2017.
 */

public class MyApplication extends Application {

    ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(this);

        applicationComponent = DaggerApplicationComponent.builder().applicationModule(new ApplicationModule(this)).build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
