package amiltone.bsaugues.td_niveau1.data.manager.cache;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import amiltone.bsaugues.td_niveau1.data.entity.ComicEntity;
import amiltone.bsaugues.td_niveau1.data.entity.ImageEntity;
import amiltone.bsaugues.td_niveau1.data.entity.SpecifiedDateEntity;

import static org.junit.Assert.*;

/**
 * Created by amiltonedev_dt013 on 25/09/2017.
 */
public class CacheManagerImplTest {

    public List<ComicEntity> comicEntities;

    @Before
    public void setUp() throws Exception {
        comicEntities = new ArrayList<>();

        for(int i = 0; i < 5; i++){
            comicEntities.add(createComicEntityWithId(i));
        }


    }

    public ComicEntity createComicEntityWithId(int id){

        ComicEntity comicEntity = new ComicEntity();
        comicEntity.setId(id);
        comicEntity.setTitle("someTitle " + id);

        ImageEntity imageEntity = new ImageEntity();
        imageEntity.setExtension("someExtension " + id);
        imageEntity.setPath("somePath " + id);

        comicEntity.setImage(imageEntity);

        SpecifiedDateEntity specifiedDateEntity = new SpecifiedDateEntity();
        specifiedDateEntity.setDate("someDate " + id);
        specifiedDateEntity.setType("someType " + id);

        List<SpecifiedDateEntity> specifiedDateEntities = new ArrayList<>();
        specifiedDateEntities.add(specifiedDateEntity);


        comicEntity.setDates(specifiedDateEntities);

        return comicEntity;
    }

    @Test
    public void getComicById() throws Exception {

    }

    @Test
    public void saveComicList() throws Exception {

    }

    @Test
    public void saveComic() throws Exception {

    }

    @Test
    public void getCachedList() throws Exception {

    }

    @Test
    public void isCacheEmpty() throws Exception {

    }

}