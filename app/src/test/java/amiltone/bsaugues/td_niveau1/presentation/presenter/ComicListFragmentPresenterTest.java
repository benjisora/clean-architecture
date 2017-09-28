package amiltone.bsaugues.td_niveau1.presentation.presenter;

import org.junit.Before;
import org.junit.Test;

import amiltone.bsaugues.td_niveau1.data.manager.api.MarvelApiManagerImpl;
import amiltone.bsaugues.td_niveau1.data.manager.cache.CacheManagerImpl;
import amiltone.bsaugues.td_niveau1.data.manager.database.DatabaseManagerImpl;
import amiltone.bsaugues.td_niveau1.data.repository.ContentRepository;

/**
 * Created by amiltonedev_dt013 on 27/09/2017.
 */
public class ComicListFragmentPresenterTest {

    ContentRepository contentRepository = new ContentRepository(
            new MarvelApiManagerImpl(),
            new CacheManagerImpl(),
            new DatabaseManagerImpl()
    );


    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void retrieveData() throws Exception {

    }

    @Test
    public void loadDetails() throws Exception {

    }

}