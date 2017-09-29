package amiltone.bsaugues.td_niveau1.data.repository.client;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import amiltone.bsaugues.td_niveau1.data.entity.ComicEntity;
import amiltone.bsaugues.td_niveau1.data.entity.mapper.db.ComicDBEntityDataMapper;
import amiltone.bsaugues.td_niveau1.data.entity.mapper.remote.ComicEntityDataMapper;
import amiltone.bsaugues.td_niveau1.data.entity.remote.ComicRemoteEntity;
import amiltone.bsaugues.td_niveau1.data.module.cache.ModuleCache;
import amiltone.bsaugues.td_niveau1.data.module.db.ModuleDB;
import amiltone.bsaugues.td_niveau1.data.module.net.ModuleNet;
import rx.Observable;
import rx.functions.Func1;

/**
 * Created by amiltonedev_dt013 on 29/09/2017.
 */
@Singleton
public class ContentClient {

    private ModuleNet moduleNet;
    private ModuleCache moduleCache;
    private ModuleDB moduleDB;

    private ComicDBEntityDataMapper comicDBEntityDataMapper;
    private ComicEntityDataMapper comicEntityDataMapper;


    @Inject
    public ContentClient(ModuleNet moduleNet, ModuleCache moduleCache, ModuleDB moduleDB, ComicDBEntityDataMapper comicDBEntityDataMapper, ComicEntityDataMapper comicEntityDataMapper) {
        this.moduleNet = moduleNet;
        this.moduleCache = moduleCache;
        this.moduleDB = moduleDB;
        this.comicDBEntityDataMapper = comicDBEntityDataMapper;
        this.comicEntityDataMapper = comicEntityDataMapper;
    }

    /**
     * API
     */

    public Observable<List<ComicEntity>> getComicsListFromApi() {
        return moduleNet.getComicsListFromApi().map(new Func1<List<ComicRemoteEntity>, List<ComicEntity>>() {
            @Override
            public List<ComicEntity> call(List<ComicRemoteEntity> comicRemoteEntities) {
                return comicEntityDataMapper.transformToEntity(comicRemoteEntities);
            }
        });
    }

    /**
     * DB
     */

    public List<ComicEntity> getComicsListFromDB() {
        return comicDBEntityDataMapper.transformToEntity(moduleDB.getComicsList());
    }

    public ComicEntity getComicsFromDB(int id) {
        return comicDBEntityDataMapper.transformToEntity(moduleDB.getComicsById(id));
    }

    public void insertComicsListInDB(List<ComicEntity> comicEntities) {
        moduleDB.clearComicsTable();
        moduleDB.insertComicsList(comicDBEntityDataMapper.transformToDB(comicEntities));
    }

    /**
     * Cache
     */
    public void insertComicsListInCache(List<ComicEntity> comics) {
        moduleCache.clearCache();
        moduleCache.insertComicsList(comics);
    }

    public void insertComicsInCache(ComicEntity comicEntity) {
        moduleCache.insertComics(comicEntity);
    }

    public List<ComicEntity> getComicsListFromCache() {
        return moduleCache.getComicsList();
    }

    public ComicEntity getComicsFromCache(int id) {
        return moduleCache.getComicsById(id);
    }


}
