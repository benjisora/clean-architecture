package amiltone.bsaugues.td_niveau1;

import android.app.Application;

import com.raizlabs.android.dbflow.config.FlowManager;

/**
 * Created by amiltonedev_dt013 on 22/09/2017.
 */

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FlowManager.init(this);
    }
}
