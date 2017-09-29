package amiltone.bsaugues.td_niveau1.data.repository;

import java.util.List;
import java.util.concurrent.Callable;

import javax.inject.Inject;
import javax.inject.Singleton;

import amiltone.bsaugues.td_niveau1.data.entity.ComicEntity;
import amiltone.bsaugues.td_niveau1.data.entity.mapper.remote.ComicEntityDataMapper;
import amiltone.bsaugues.td_niveau1.data.entity.remote.ComicRemoteEntity;
import amiltone.bsaugues.td_niveau1.data.repository.client.ContentClient;
import rx.Observable;
import rx.functions.Action1;
import rx.functions.Func0;
import rx.functions.Func1;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */
@Singleton
public class ContentRepositoryImpl implements ContentRepository {

    private ComicEntityDataMapper comicEntityDataMapper;
    private ContentClient contentClient;

    @Inject
    public ContentRepositoryImpl(ContentClient contentClient, ComicEntityDataMapper comicEntityDataMapper) {
        this.contentClient = contentClient;
        this.comicEntityDataMapper = comicEntityDataMapper;
    }

    @Override
    public Observable<List<ComicEntity>> retrieveComicsList() {

        return Observable.defer(new Func0<Observable<List<ComicEntity>>>() {
            @Override
            public Observable<List<ComicEntity>> call() {
                return Observable.fromCallable(new Callable<List<ComicEntity>>() {
                    @Override
                    public List<ComicEntity> call() throws Exception {
                        return contentClient.getComicsListFromCache();
                    }
                }).onErrorResumeNext(new Func1<Throwable, Observable<? extends List<ComicEntity>>>() {
                    @Override
                    public Observable<? extends List<ComicEntity>> call(Throwable throwable) {
                        return Observable.fromCallable(new Callable<List<ComicEntity>>() {
                            @Override
                            public List<ComicEntity> call() throws Exception {
                                return contentClient.getComicsListFromDB();
                            }
                        }).doOnNext(new Action1<List<ComicEntity>>() {
                            @Override
                            public void call(List<ComicEntity> comicEntities) {
                                contentClient.insertComicsListInCache(comicEntities);
                            }
                        });
                    }
                }).onErrorResumeNext(new Func1<Throwable, Observable<? extends List<ComicEntity>>>() {
                    @Override
                    public Observable<? extends List<ComicEntity>> call(Throwable throwable) {
                        return contentClient.getComicsListFromApi().map(new Func1<List<ComicEntity>, List<ComicEntity>>() {
                            @Override
                            public List<ComicEntity> call(List<ComicEntity> comicEntities) {
                                return comicEntities;
                            }
                        }).doOnNext(new Action1<List<ComicEntity>>() {
                            @Override
                            public void call(List<ComicEntity> comicEntities) {
                                contentClient.insertComicsListInCache(comicEntities);
                                contentClient.insertComicsListInDB(comicEntities);
                            }
                        });
                    }
                });
            }
        });
    }

    @Override
    public Observable<ComicEntity> retrieveComicsById(final int id) {

        return Observable.defer(new Func0<Observable<ComicEntity>>() {
            @Override
            public Observable<ComicEntity> call() {
                return Observable.fromCallable(new Callable<ComicEntity>() {
                    @Override
                    public ComicEntity call() throws Exception {
                        return contentClient.getComicsFromCache(id);
                    }
                }).onErrorResumeNext(new Func1<Throwable, Observable<? extends ComicEntity>>() {
                    @Override
                    public Observable<? extends ComicEntity> call(Throwable throwable) {
                        return Observable.fromCallable(new Callable<ComicEntity>() {
                            @Override
                            public ComicEntity call() throws Exception {
                                return contentClient.getComicsFromDB(id);
                            }
                        });
                    }
                });
            }
        });
    }
}
