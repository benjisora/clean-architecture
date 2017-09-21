package amiltone.bsaugues.td_niveau1.presentation;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import amiltone.bsaugues.td_niveau1.R;
import amiltone.bsaugues.td_niveau1.data.model.Comic;
import amiltone.bsaugues.td_niveau1.presentation.viewcontroler.ComicListFragment;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public class Navigator {

    private FragmentManager fragmentManager;

    public Navigator(FragmentManager fragmentManager){
        this.fragmentManager = fragmentManager;
    }

    public void launchDetailsScreen(Comic comic){

        Fragment fragment = new ComicListFragment();

        fragmentManager.beginTransaction().add(R.id.fragment, fragment).commit();
    }

    public void launchComicsScreen(){

        Fragment fragment = new ComicListFragment();

        fragmentManager.beginTransaction().add(R.id.fragment, fragment).commit();
    }
}
