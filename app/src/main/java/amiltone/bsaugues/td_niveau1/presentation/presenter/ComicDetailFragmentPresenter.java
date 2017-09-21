package amiltone.bsaugues.td_niveau1.presentation.presenter;


import java.util.List;

import amiltone.bsaugues.td_niveau1.TdApplication;
import amiltone.bsaugues.td_niveau1.data.repository.ContentRepository;
import amiltone.bsaugues.td_niveau1.data.model.Comic;
import amiltone.bsaugues.td_niveau1.presentation.view.viewinterface.ComicDetailView;
import amiltone.bsaugues.td_niveau1.presentation.navigator.listener.NavigatorListener;
import amiltone.bsaugues.td_niveau1.presentation.view.viewmodel.ComicViewModel;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public class ComicDetailFragmentPresenter {

    private ComicDetailView comicDetailView;
    private NavigatorListener navigatorListener;


    private ContentRepository contentRepository;

    public ComicDetailFragmentPresenter(NavigatorListener navigatorListener) {
        this.navigatorListener = navigatorListener;
        this.contentRepository = TdApplication.getInstance().getContentRepository();
    }

    public void setComicDetailView(ComicDetailView comicDetailView) {
        this.comicDetailView = comicDetailView;
    }

    public void retrieveData() {

        //TODO : get data from cache

        Observable<Comic> comic = this.contentRepository.getComicById()



        Observable<List<Comic>> comics = this.contentRepository.getComicsList();
        comics.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Comic>>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(List<Comic> comics) {

                        comicDetailView.displayComicDetails(new ComicViewModel(comic));
                    }
                });
    }

    public void displayComicDetails(ComicViewModel comicViewModel){
        comicDetailView.displayComicDetails(comicViewModel);
    }

}
