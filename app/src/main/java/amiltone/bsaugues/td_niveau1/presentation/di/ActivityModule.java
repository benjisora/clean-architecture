package amiltone.bsaugues.td_niveau1.presentation.di;

import amiltone.bsaugues.td_niveau1.presentation.navigator.listener.NavigatorListener;
import dagger.Module;
import dagger.Provides;

/**
 * Created by amiltonedev_dt013 on 28/09/2017.
 */
@Module
public class ActivityModule {
    private NavigatorListener navigatorListener;

    public ActivityModule(NavigatorListener navigatorListener) {
        this.navigatorListener = navigatorListener;
    }

    @Provides
    @PerActivity
    NavigatorListener provideNavigatorListener() {
        return navigatorListener;
    }
}
