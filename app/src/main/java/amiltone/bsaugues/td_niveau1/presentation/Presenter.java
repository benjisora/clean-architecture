package amiltone.bsaugues.td_niveau1.presentation;

import android.view.View;
import android.widget.Toast;

import java.util.List;

import amiltone.bsaugues.td_niveau1.TdApplication;
import amiltone.bsaugues.td_niveau1.data.Repository;
import amiltone.bsaugues.td_niveau1.data.model.Comic;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public class Presenter {

    private View view;
    private Repository repository;
    private Navigator navigator;
    private Subscriber<List<Comic>> subscriber;

    public Presenter() {
        this.repository = TdApplication.getInstance().getRepository();
        this.navigator = TdApplication.getInstance().getNavigator();
    }

    public void retrieveData() {

        subscriber = new Subscriber<List<Comic>>() {

            @Override
            public void onCompleted() {
                //UpdateUI
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<Comic> comics) {
                //TODO: Save in database...
            }
        };

        Observable<List<Comic>> comics = this.repository.getComicsList();
        comics.observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    public Subscriber<List<Comic>> getSubscriber() {
        return subscriber;
    }
}
