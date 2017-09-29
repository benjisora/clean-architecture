package amiltone.bsaugues.td_niveau1.presentation.di.module;


import android.support.v4.app.FragmentManager;

import amiltone.bsaugues.td_niveau1.presentation.di.PerActivity;
import amiltone.bsaugues.td_niveau1.presentation.navigator.Navigator;
import amiltone.bsaugues.td_niveau1.presentation.navigator.listener.NavigatorListener;
import dagger.Module;
import dagger.Provides;

/**
 * Created by amiltonedev_dt013 on 28/09/2017.
 */
@Module
public class ActivityModule {

    private NavigatorListener navigatorListener;
    private FragmentManager fragmentManager;

    public ActivityModule(NavigatorListener navigatorListener, FragmentManager fragmentManager) {
        this.navigatorListener = navigatorListener;
        this.fragmentManager = fragmentManager;
    }

    @Provides
    @PerActivity
    NavigatorListener provideNavigatorListener() {
        return navigatorListener;
    }

    @Provides
    @PerActivity
    Navigator provideNavigator() {
        return new Navigator(fragmentManager);
    }


}
