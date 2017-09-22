package amiltone.bsaugues.td_niveau1.presentation.presenter;


import java.util.ArrayList;
import java.util.List;

import amiltone.bsaugues.td_niveau1.TdApplication;
import amiltone.bsaugues.td_niveau1.data.repository.ContentRepository;
import amiltone.bsaugues.td_niveau1.data.entity.ComicEntity;
import amiltone.bsaugues.td_niveau1.presentation.view.viewinterface.ComicListView;
import amiltone.bsaugues.td_niveau1.presentation.navigator.listener.NavigatorListener;
import amiltone.bsaugues.td_niveau1.presentation.view.viewmodel.ComicViewModel;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public class ComicListFragmentPresenter {

    private ComicListView comicListView;
    private NavigatorListener navigatorListener;

    private ContentRepository apiRepository;

    public ComicListFragmentPresenter(NavigatorListener navigatorListener) {
        this.navigatorListener = navigatorListener;
        this.apiRepository = TdApplication.getInstance().getContentRepository();
    }

    public void setComicListView(ComicListView comicListView) {
        this.comicListView = comicListView;
    }


    public void retrieveData() {
        Observable<List<ComicEntity>> comics = this.apiRepository.getComicsList();
        comics.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<ComicEntity>>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(List<ComicEntity> comics) {

                        comicListView.displayComics(getComicsViewModel(comics));
                    }
                });
    }

    public void loadDetails(int id){
        navigatorListener.requestDisplayDetailFragment(id);
    }

    private List<ComicViewModel> getComicsViewModel(List<ComicEntity> comics){
        List<ComicViewModel> comicsViewModel = new ArrayList<>();
        for(ComicEntity comic : comics){
            comicsViewModel.add(new ComicViewModel(comic));
        }
        return comicsViewModel;
    }
}
