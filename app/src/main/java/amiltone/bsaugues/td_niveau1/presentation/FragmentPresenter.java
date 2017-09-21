package amiltone.bsaugues.td_niveau1.presentation;


import android.util.Log;

import java.util.List;

import amiltone.bsaugues.td_niveau1.TdApplication;
import amiltone.bsaugues.td_niveau1.data.ApiRepository;
import amiltone.bsaugues.td_niveau1.data.model.Comic;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public class FragmentPresenter {

    private ComicListView comicListView;
    private Navigator navigator;

    private ApiRepository apiRepository;


    public FragmentPresenter() {
        this.apiRepository = TdApplication.getInstance().getApiRepository();
        this.navigator = TdApplication.getInstance().getNavigator();
    }

    public void setComicListView(ComicListView comicListView) {
        this.comicListView = comicListView;
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
                        //TODO: Save in database...
                        comicListView.displayComics(comics);
                    }
                });
    }

    public void loadDetails(Comic comic){
        navigator.launchDetailsScreen(comic);
    }

}
