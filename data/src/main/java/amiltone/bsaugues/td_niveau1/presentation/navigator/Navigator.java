package amiltone.bsaugues.td_niveau1.presentation.navigator;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import javax.inject.Inject;

import amiltone.bsaugues.td_niveau1.R;
import amiltone.bsaugues.td_niveau1.presentation.di.PerActivity;
import amiltone.bsaugues.td_niveau1.presentation.ui.fragment.ComicDetailsFragment;
import amiltone.bsaugues.td_niveau1.presentation.ui.fragment.ComicListFragment;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */
@PerActivity
public class Navigator {

    private FragmentManager fragmentManager;

    @Inject
    public Navigator(FragmentManager fragmentManager){
        this.fragmentManager = fragmentManager;
    }

    public void displayDetailFragment(int comicId){

        ComicDetailsFragment fragment = ComicDetailsFragment.newInstance(comicId);
        loadFragment(fragment,true);
    }

    public void displayComicList(){
        ComicListFragment fragment = ComicListFragment.newInstance();
        loadFragment(fragment,false);

    }

    private void loadFragment(Fragment fragmentToLoad, boolean addToBackStack){

        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment, fragmentToLoad);

        if(addToBackStack){
            transaction.addToBackStack(null);
        }

        transaction.commit();
    }
}
