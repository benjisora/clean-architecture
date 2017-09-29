package amiltone.bsaugues.td_niveau1.presentation.di.component;

import amiltone.bsaugues.td_niveau1.presentation.di.module.ActivityModule;
import amiltone.bsaugues.td_niveau1.presentation.di.PerActivity;
import amiltone.bsaugues.td_niveau1.presentation.navigator.Navigator;
import amiltone.bsaugues.td_niveau1.presentation.ui.fragment.ComicDetailsFragment;
import amiltone.bsaugues.td_niveau1.presentation.ui.fragment.ComicListFragment;
import dagger.Component;

/**
 * Created by amiltonedev_dt013 on 28/09/2017.
 */
@PerActivity
@Component(modules = {ActivityModule.class}, dependencies = {ApplicationComponent.class})
public interface ActivityComponent {

    void inject(ComicListFragment comicListFragment);

    void inject(ComicDetailsFragment comicDetailsFragment);

    Navigator getNavigator();

}
