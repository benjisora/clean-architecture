package amiltone.bsaugues.td_niveau1;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowManager;

import amiltone.bsaugues.td_niveau1.presentation.di.module.ApplicationModule;
import amiltone.bsaugues.td_niveau1.presentation.di.component.ApplicationComponent;
import amiltone.bsaugues.td_niveau1.presentation.di.component.DaggerApplicationComponent;

/**
 * Created by amiltonedev_dt013 on 22/09/2017.
 */

public class TdApplication extends Application {

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
