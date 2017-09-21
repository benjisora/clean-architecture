package amiltone.bsaugues.td_niveau1.presentation.viewcontroler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import amiltone.bsaugues.td_niveau1.R;
import amiltone.bsaugues.td_niveau1.TdApplication;
import amiltone.bsaugues.td_niveau1.presentation.ComicListView;
import amiltone.bsaugues.td_niveau1.presentation.Navigator;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ComicListActivity extends AppCompatActivity {

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
        TdApplication.getInstance().setNavigator(navigator);
        navigator.launchComicsScreen();

    }

}
