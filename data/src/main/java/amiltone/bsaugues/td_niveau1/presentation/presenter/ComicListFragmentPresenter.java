package amiltone.bsaugues.td_niveau1.presentation.presenter;


import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import amiltone.bsaugues.td_niveau1.data.entity.ComicEntity;
import amiltone.bsaugues.td_niveau1.data.repository.ContentRepository;
import amiltone.bsaugues.td_niveau1.interactor.RetrieveComicsList;
import amiltone.bsaugues.td_niveau1.interactor.UseCase;
import amiltone.bsaugues.td_niveau1.presentation.di.PerActivity;
import amiltone.bsaugues.td_niveau1.presentation.navigator.listener.NavigatorListener;
import amiltone.bsaugues.td_niveau1.presentation.ui.view.viewinterface.ComicListView;
import amiltone.bsaugues.td_niveau1.presentation.ui.view.viewmodel.ComicViewModel;
import rx.Subscriber;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */
@PerActivity
public class ComicListFragmentPresenter {

    public static final String TAG = "ComicListPresenter";

    private ComicListView comicListView;
    private NavigatorListener navigatorListener;
    private ContentRepository contentRepository;

    private UseCase comicListUseCase;

    @Inject
    public ComicListFragmentPresenter(ContentRepository contentRepository, NavigatorListener navigatorListener) {
        this.navigatorListener = navigatorListener;
        this.contentRepository = contentRepository;
    }

    public void setComicListView(ComicListView comicListView) {
        this.comicListView = comicListView;
    }


    public void retrieveData() {

        comicListUseCase = new RetrieveComicsList(contentRepository);
        comicListUseCase.execute(new Subscriber<List<ComicEntity>>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(List<ComicEntity> comicEntities) {
                if (comicEntities.isEmpty()) {
                    Log.d(TAG, "onNext: list empty");
                } else {
                    comicListView.displayComics(getComicsViewModel(comicEntities));
                }
            }

        });

    }

    public void loadDetails(int id) {
        navigatorListener.requestDisplayDetailFragment(id);
    }

    private List<ComicViewModel> getComicsViewModel(List<ComicEntity> comics) {
        List<ComicViewModel> comicsViewModel = new ArrayList<>();
        for (ComicEntity comic : comics) {
            comicsViewModel.add(new ComicViewModel(comic));
        }
        return comicsViewModel;
    }
}
