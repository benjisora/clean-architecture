package amiltone.bsaugues.td_niveau1.interactor;

import javax.inject.Inject;

import amiltone.bsaugues.td_niveau1.data.repository.ContentRepository;
import rx.Observable;

/**
 * Created by amiltonedev_dt013 on 29/09/2017.
 */

public class RetrieveComicsById extends UseCase {

    private ContentRepository contentRepository;
    private int id;

    @Inject
    public RetrieveComicsById(ContentRepository contentRepository, int id) {
        this.contentRepository = contentRepository;
        this.id = id;
    }


    @Override
    protected Observable buildUseCaseObservable() {
        return contentRepository.retrieveComicsById(id);
    }

}
