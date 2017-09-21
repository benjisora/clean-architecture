package amiltone.bsaugues.td_niveau1.presentation;

import android.view.View;

import java.util.List;

import amiltone.bsaugues.td_niveau1.data.model.Comic;
import rx.Subscriber;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public class Presenter {

    private View view;
    //private ApiRepository repository;
    private Subscriber<List<Comic>> subscriber;

    public Presenter() {
        //this.repository = TdApplication.getInstance().getApiRepository();
    }

    public void retrieveData() {
/*
        subscriber = new Subscriber<List<Comic>>() {

            @Override
            public void onCompleted() {
                //ComicListView
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<Comic> comics) {
                //TODO: Save in database...
            }
        };

        Observable<List<Comic>> comics = this.repository.getComicsListFromApi();
        comics.observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
                */
    }

    public Subscriber<List<Comic>> getSubscriber() {
        return subscriber;
    }

}
