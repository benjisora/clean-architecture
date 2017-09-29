package amiltone.bsaugues.td_niveau1.presentation.presenter;


import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import amiltone.bsaugues.td_niveau1.data.repository.ContentRepository;
import amiltone.bsaugues.td_niveau1.data.repository.ContentRepositoryImpl;
import amiltone.bsaugues.td_niveau1.data.entity.ComicEntity;
import amiltone.bsaugues.td_niveau1.presentation.di.PerActivity;
import amiltone.bsaugues.td_niveau1.presentation.view.viewinterface.ComicListView;
import amiltone.bsaugues.td_niveau1.presentation.navigator.listener.NavigatorListener;
import amiltone.bsaugues.td_niveau1.presentation.view.viewmodel.ComicViewModel;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */
@PerActivity
public class ComicListFragmentPresenter {

    public static final String TAG = "ComicListPresenter";

    private ComicListView comicListView;
    private NavigatorListener navigatorListener;
    private ContentRepository contentRepository;

    @Inject
    public ComicListFragmentPresenter(ContentRepository contentRepository, NavigatorListener navigatorListener) {
        this.navigatorListener = navigatorListener;
        this.contentRepository = contentRepository;
    }

    public void setComicListView(ComicListView comicListView) {
        this.comicListView = comicListView;
    }


    public void retrieveData() {

        Observable<List<ComicEntity>> comics = this.contentRepository.getComicsList();
        comics.subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<ComicEntity>>() {

                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                        //gérer pas de data du tout
                        e.printStackTrace();
                    }

                    @Override
                    public void onNext(List<ComicEntity> comics) {
                        if(comics.isEmpty()){
                            Log.d(TAG, "onNext: list empty");
                        } else {
                            comicListView.displayComics(getComicsViewModel(comics));
                        }
                    }
                });
    }

    public void loadDetails(int id){
        navigatorListener.requestDisplayDetailFragment(id);
    }

    private List<ComicViewModel> getComicsViewModel(List<ComicEntity> comics){
        List<ComicViewModel> comicsViewModel = new ArrayList<>();
        for(ComicEntity comic : comics){
            comicsViewModel.add(new ComicViewModel(comic));
        }
        return comicsViewModel;
    }
}
