package amiltone.bsaugues.td_niveau1.presentation.presenter;


import javax.inject.Inject;

import amiltone.bsaugues.td_niveau1.data.entity.ComicEntity;
import amiltone.bsaugues.td_niveau1.data.repository.ContentRepository;
import amiltone.bsaugues.td_niveau1.presentation.di.PerActivity;
import amiltone.bsaugues.td_niveau1.presentation.navigator.listener.NavigatorListener;
import amiltone.bsaugues.td_niveau1.presentation.view.viewinterface.ComicDetailView;
import amiltone.bsaugues.td_niveau1.presentation.view.viewmodel.ComicViewModel;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */
@PerActivity
public class ComicDetailFragmentPresenter {

    private ComicDetailView comicDetailView;
    private NavigatorListener navigatorListener;

    private ContentRepository contentRepository;

    @Inject
    public ComicDetailFragmentPresenter(ContentRepository contentRepository, NavigatorListener navigatorListener) {
        this.navigatorListener = navigatorListener;
        this.contentRepository = contentRepository;
    }

    public void setComicDetailView(ComicDetailView comicDetailView) {
        this.comicDetailView = comicDetailView;
    }

    public void retrieveData(int id) {

        //TODO : get data from cache

        Observable<ComicEntity> comic = this.contentRepository.getComicById(id);
        comic.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<ComicEntity>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(ComicEntity comic) {

                        comicDetailView.displayComicDetails(new ComicViewModel(comic));
                    }
                });

    }

    public void displayComicDetails(ComicViewModel comicViewModel) {
        comicDetailView.displayComicDetails(comicViewModel);
    }

}
