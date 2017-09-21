package amiltone.bsaugues.td_niveau1.presentation;


import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import amiltone.bsaugues.td_niveau1.TdApplication;
import amiltone.bsaugues.td_niveau1.data.ApiRepository;
import amiltone.bsaugues.td_niveau1.data.model.Comic;
import amiltone.bsaugues.td_niveau1.presentation.viewmodel.ComicViewModel;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public class ComicFragmentPresenter {

    private ComicListView comicListView;
    private ComicDetailView comicDetailView;
    private Navigator navigator;

    private ApiRepository apiRepository;

    public ComicFragmentPresenter() {
        this.apiRepository = TdApplication.getInstance().getApiRepository();
        this.navigator = TdApplication.getInstance().getNavigator();
    }

    public void setComicListView(ComicListView comicListView) {
        this.comicListView = comicListView;
    }

    public void setComicDetailView(ComicDetailView comicDetailView) {
        this.comicDetailView = comicDetailView;
    }

    public void retrieveData() {
        Observable<List<Comic>> comics = this.apiRepository.getComicsList();
        comics.observeOn(AndroidSchedulers.mainThread())
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

                        comicListView.displayComics(getComicsViewModel(comics));
                    }
                });
    }

    public List<ComicViewModel> getComicsViewModel(List<Comic> comics){
        List<ComicViewModel> comicsViewModel = new ArrayList<>();
        for(Comic comic : comics){
            comicsViewModel.add(new ComicViewModel(comic));
        }
        return comicsViewModel;
    }

    public void displayComicDetails(Comic comic){
        comicDetailView.displayComicDetails(comic);
    }

    public void loadDetails(Comic comic){
        navigator.launchDetailsScreen(comic);
    }

}
