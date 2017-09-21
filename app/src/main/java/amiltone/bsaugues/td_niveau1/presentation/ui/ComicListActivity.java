package amiltone.bsaugues.td_niveau1.presentation.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import amiltone.bsaugues.td_niveau1.R;
import amiltone.bsaugues.td_niveau1.presentation.navigator.Navigator;
import amiltone.bsaugues.td_niveau1.presentation.navigator.listener.NavigatorListener;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ComicListActivity extends AppCompatActivity implements NavigatorListener {

    @BindView(R.id.toolbar)
    public Toolbar toolbar;

    private Navigator navigator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_list);
        ButterKnife.bind(this);

        setSupportActionBar(toolbar);

        navigator = new Navigator(getSupportFragmentManager());
        navigator.launchComicsScreen();

    }

    @Override
    public void requestDisplayDetailFragment(int id) {
        navigator.displayDetailFragment(id);
        //TODO : display share icon
    }
}
