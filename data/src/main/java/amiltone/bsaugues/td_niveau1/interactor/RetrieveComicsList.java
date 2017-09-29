package amiltone.bsaugues.td_niveau1.interactor;

import javax.inject.Inject;

import amiltone.bsaugues.td_niveau1.data.repository.ContentRepository;
import rx.Observable;

/**
 * Created by amiltonedev_dt013 on 29/09/2017.
 */

public class RetrieveComicsList extends UseCase {

    private ContentRepository contentRepository;

    @Inject
    public RetrieveComicsList(ContentRepository contentRepository) {
        this.contentRepository = contentRepository;
    }


    @Override
    protected Observable buildUseCaseObservable() {
        return contentRepository.retrieveComicsList();
    }

}
