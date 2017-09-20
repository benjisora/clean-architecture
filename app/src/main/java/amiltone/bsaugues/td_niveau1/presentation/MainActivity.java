package amiltone.bsaugues.td_niveau1.presentation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import amiltone.bsaugues.td_niveau1.R;
import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements UpdateUI {

    @BindView(R.id.comic_row_title)
    TextView rowTitle;

    @BindView(R.id.comic_row_date)
    TextView rowDate;

    @BindView(R.id.comic_row_thumbnail)
    ImageView rowThumbnail;

    private Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        presenter = new Presenter();
        updateUI();

    }

    public void receivedEventFromClick() {

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        if (presenter.getSubscriber() == null || !presenter.getSubscriber().isUnsubscribed())
            presenter.getSubscriber().unsubscribe();
        super.onDestroy();
    }

    @Override
    public void updateUI() {
        presenter.retrieveData();
    }
}
