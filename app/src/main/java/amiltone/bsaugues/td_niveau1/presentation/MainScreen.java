package amiltone.bsaugues.td_niveau1.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import amiltone.bsaugues.td_niveau1.TdApplication;
import amiltone.bsaugues.td_niveau1.R;
import amiltone.bsaugues.td_niveau1.data.model.Comic;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;

public class MainScreen extends AppCompatActivity {

    //private Subscriber<Comic> subscriber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

/*
        subscriber = new Subscriber<Comic>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Comic comic) {

            }
        };

        Observable<Comic> comic = TdApplication.getInstance().getApiService().getComic(11);
        comic.observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
*/
    }

    @Override
    protected void onDestroy() {
        //if (subscriber == null || !subscriber.isUnsubscribed())
        //    subscriber.unsubscribe();
        super.onDestroy();
    }
}
