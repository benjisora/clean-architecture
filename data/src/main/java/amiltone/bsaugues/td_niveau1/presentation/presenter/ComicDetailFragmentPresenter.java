package amiltone.bsaugues.td_niveau1.presentation.presenter;


import javax.inject.Inject;

import amiltone.bsaugues.td_niveau1.data.entity.ComicEntity;
import amiltone.bsaugues.td_niveau1.data.repository.ContentRepository;
import amiltone.bsaugues.td_niveau1.interactor.RetrieveComicsById;
import amiltone.bsaugues.td_niveau1.interactor.UseCase;
import amiltone.bsaugues.td_niveau1.presentation.di.PerActivity;
import amiltone.bsaugues.td_niveau1.presentation.navigator.listener.NavigatorListener;
import amiltone.bsaugues.td_niveau1.presentation.ui.view.viewinterface.ComicDetailView;
import amiltone.bsaugues.td_niveau1.presentation.ui.view.viewmodel.ComicViewModel;
import rx.Subscriber;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */
@PerActivity
public class ComicDetailFragmentPresenter {

    private ComicDetailView comicDetailView;
    private NavigatorListener navigatorListener;

    private ContentRepository contentRepository;

    private UseCase comicsDetailUseCase;

    @Inject
    public ComicDetailFragmentPresenter(ContentRepository contentRepository, NavigatorListener navigatorListener) {
        this.navigatorListener = navigatorListener;
        this.contentRepository = contentRepository;
    }

    public void setComicDetailView(ComicDetailView comicDetailView) {
        this.comicDetailView = comicDetailView;
    }

    public void retrieveData(int id) {

        comicsDetailUseCase = new RetrieveComicsById(contentRepository, id);
        comicsDetailUseCase.execute(new Subscriber<ComicEntity>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(ComicEntity comicEntity) {
                comicDetailView.displayComicDetails(new ComicViewModel(comicEntity));
            }

        });

    }

}
