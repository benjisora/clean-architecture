package amiltone.bsaugues.td_niveau1.presentation.di.module;

import android.content.Context;

import javax.inject.Singleton;

import amiltone.bsaugues.td_niveau1.data.module.cache.ModuleCache;
import amiltone.bsaugues.td_niveau1.data.module.cache.ModuleCacheImpl;
import amiltone.bsaugues.td_niveau1.data.module.db.ModuleDB;
import amiltone.bsaugues.td_niveau1.data.module.db.ModuleDBFlowImpl;
import amiltone.bsaugues.td_niveau1.data.module.net.ModuleNet;
import amiltone.bsaugues.td_niveau1.data.module.net.ModuleNetRetrofitImpl;
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
    ModuleCache provideModuleCache(ModuleCacheImpl moduleCache) {
        return moduleCache;
    }

    @Provides
    @Singleton
    ModuleDB provideModuleDB(ModuleDBFlowImpl moduleDB) {
        return moduleDB;
    }

    @Provides
    @Singleton
    ModuleNet provideModuleNet(ModuleNetRetrofitImpl moduleNet) {
        return moduleNet;
    }
//
//    @Provides
//    @Singleton
//    ContentClient provideContentClient(ContentClient contentClient) {
//        return contentClient;
//    }

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
