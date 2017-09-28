package amiltone.bsaugues.td_niveau1.presentation.di.component;

import amiltone.bsaugues.td_niveau1.presentation.di.ActivityModule;
import amiltone.bsaugues.td_niveau1.presentation.di.PerActivity;
import amiltone.bsaugues.td_niveau1.presentation.ui.ComicDetailsFragment;
import amiltone.bsaugues.td_niveau1.presentation.ui.ComicListFragment;
import dagger.Component;

/**
 * Created by amiltonedev_dt013 on 28/09/2017.
 */
@PerActivity
@Component(modules = {ActivityModule.class}, dependencies = {ApplicationComponent.class})
public interface ActivityComponent {

    void inject(ComicListFragment comicListFragment);

    void inject(ComicDetailsFragment comicDetailsFragment);
}
