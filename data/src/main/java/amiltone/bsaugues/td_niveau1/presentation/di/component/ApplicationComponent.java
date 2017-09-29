package amiltone.bsaugues.td_niveau1.presentation.di.component;

import android.content.Context;

import javax.inject.Singleton;

import amiltone.bsaugues.td_niveau1.data.repository.ContentRepository;
import amiltone.bsaugues.td_niveau1.presentation.di.module.ApplicationModule;
import dagger.Component;

/**
 * Created by amiltonedev_dt013 on 28/09/2017.
 */
@Singleton
@Component(modules = {ApplicationModule.class})
public interface ApplicationComponent {

    Context getContext();

    ContentRepository getContentRepository();

}
