package amiltone.bsaugues.td_niveau1.data.repository;

import java.util.List;

import amiltone.bsaugues.td_niveau1.data.entity.ComicEntity;
import rx.Observable;

/**
 * Created by amiltonedev_dt013 on 28/09/2017.
 */

public interface ContentRepository {

    Observable<List<ComicEntity>> retrieveComicsList();
    Observable<ComicEntity> retrieveComicsById(int id);

}
