package amiltone.bsaugues.td_niveau1.presentation.ui.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import javax.inject.Inject;

import amiltone.bsaugues.td_niveau1.TdApplication;
import amiltone.bsaugues.td_niveau1.R;
import amiltone.bsaugues.td_niveau1.presentation.di.module.ActivityModule;
import amiltone.bsaugues.td_niveau1.presentation.di.PerActivity;
import amiltone.bsaugues.td_niveau1.presentation.di.component.ActivityComponent;
import amiltone.bsaugues.td_niveau1.presentation.di.component.DaggerActivityComponent;
import amiltone.bsaugues.td_niveau1.presentation.navigator.Navigator;
import amiltone.bsaugues.td_niveau1.presentation.navigator.listener.NavigatorListener;
import butterknife.BindView;
import butterknife.ButterKnife;

@PerActivity
public class ComicListActivity extends AppCompatActivity implements NavigatorListener {

    @BindView(R.id.toolbar)
    public Toolbar toolbar;

    @Inject
    Navigator navigator;

    private ActivityComponent activityComponent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comic_list);
        ButterKnife.bind(this);

        activityComponent = DaggerActivityComponent.builder().activityModule(new ActivityModule(this, getSupportFragmentManager()))
                .applicationComponent(((TdApplication) getApplication()).getApplicationComponent()).build();

        setSupportActionBar(toolbar);

        navigator = activityComponent.getNavigator();
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
