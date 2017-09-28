package amiltone.bsaugues.td_niveau1.presentation.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import amiltone.bsaugues.td_niveau1.R;
import amiltone.bsaugues.td_niveau1.presentation.di.ActivityModule;
import amiltone.bsaugues.td_niveau1.presentation.di.component.ActivityComponent;
import amiltone.bsaugues.td_niveau1.presentation.di.component.DaggerActivityComponent;
import amiltone.bsaugues.td_niveau1.presentation.navigator.Navigator;
import amiltone.bsaugues.td_niveau1.presentation.navigator.listener.NavigatorListener;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ComicListActivity extends AppCompatActivity implements NavigatorListener {

    @BindView(R.id.toolbar)
    public Toolbar toolbar;

    private Navigator navigator;

    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_list);
        ButterKnife.bind(this);

        activityComponent = DaggerActivityComponent.builder().activityModule(new ActivityModule(this)).build();

        setSupportActionBar(toolbar);


        navigator = new Navigator(getSupportFragmentManager());
        navigator.displayComicList();

    }



    @Override
    public void requestDisplayDetailFragment(int id) {
        navigator.displayDetailFragment(id);
    }

    public ActivityComponent getActivityComponent() {
        return activityComponent;
    }
}
