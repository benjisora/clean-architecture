package amiltone.bsaugues.td_niveau1.presentation.di;

import android.content.Context;

import javax.inject.Singleton;

import amiltone.bsaugues.td_niveau1.data.manager.api.MarvelApiManager;
import amiltone.bsaugues.td_niveau1.data.manager.api.MarvelApiManagerImpl;
import amiltone.bsaugues.td_niveau1.data.manager.cache.CacheManager;
import amiltone.bsaugues.td_niveau1.data.manager.cache.CacheManagerImpl;
import amiltone.bsaugues.td_niveau1.data.manager.database.DatabaseManager;
import amiltone.bsaugues.td_niveau1.data.manager.database.DatabaseManagerImpl;
import amiltone.bsaugues.td_niveau1.data.repository.ContentRepository;
import amiltone.bsaugues.td_niveau1.data.repository.ContentRepositoryImpl;
import dagger.Module;
import dagger.Provides;

/**
 * Created by amiltonedev_dt013 on 28/09/2017.
 */
@Module
public class ApplicationModule {

    private Context context;

    public ApplicationModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    MarvelApiManager provideApiManager(MarvelApiManagerImpl marvelApiManager) {
        return marvelApiManager;
    }

    @Provides
    @Singleton
    CacheManager provideCacheManager(CacheManagerImpl cacheManager) {
        return cacheManager;
    }

    @Provides
    @Singleton
    DatabaseManager provideDatabaseManager(DatabaseManagerImpl databaseManager) {
        return databaseManager;
    }


    @Provides
    @Singleton
    ContentRepository provideContentRepository(ContentRepositoryImpl contentRepository) {
        return contentRepository;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return context;
    }


}
