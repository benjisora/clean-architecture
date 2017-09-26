package amiltone.bsaugues.td_niveau1.data.manager.database;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import amiltone.bsaugues.td_niveau1.data.entity.db.ComicDBEntity;
import amiltone.bsaugues.td_niveau1.data.entity.db.CreatorDBEntity;
import amiltone.bsaugues.td_niveau1.data.entity.db.ImageDBEntity;
import amiltone.bsaugues.td_niveau1.data.entity.db.SpecifiedDateDBEntity;
import amiltone.bsaugues.td_niveau1.data.entity.db.SpecifiedUrlDBEntity;

import static org.junit.Assert.*;

/**
 * Created by amiltonedev_dt013 on 26/09/2017.
 */
public class DatabaseManagerImplTest {

    public DatabaseManager databaseManager;

    @Before
    public void setUp() throws Exception {

        this.databaseManager = new DatabaseManagerImpl();


    }

    private ComicDBEntity createComicDBEntityWithId(int id) {

        ComicDBEntity comicDBEntity = new ComicDBEntity();
        comicDBEntity.setId(id);
        comicDBEntity.setTitle("someTitle " + id);
        comicDBEntity.setDiamondCode("someDiamondCode " + id);

        ImageDBEntity imageDBEntity = new ImageDBEntity();
        imageDBEntity.setExtension("someExtension " + id);
        imageDBEntity.setPath("somePath " + id);
        comicDBEntity.setImage(imageDBEntity);

        SpecifiedDateDBEntity specifiedDateDBEntity = new SpecifiedDateDBEntity();
        specifiedDateDBEntity.setDate("someDate " + id);
        specifiedDateDBEntity.setType("someType " + id);
        List<SpecifiedDateDBEntity> specifiedDateDBEntities = new ArrayList<>();
        specifiedDateDBEntities.add(specifiedDateDBEntity);
        comicDBEntity.setDates(specifiedDateDBEntities);

        SpecifiedUrlDBEntity specifiedUrlDBEntity = new SpecifiedUrlDBEntity();
        specifiedUrlDBEntity.setUrl("someUrl " + id);
        specifiedUrlDBEntity.setType("someType " + id);
        List<SpecifiedUrlDBEntity> specifiedUrlDBEntities = new ArrayList<>();
        specifiedUrlDBEntities.add(specifiedUrlDBEntity);
        comicDBEntity.setUrls(specifiedUrlDBEntities);

        CreatorDBEntity creatorDBEntity = new CreatorDBEntity();
        creatorDBEntity.setRole("someRole " + id);
        creatorDBEntity.setName("someName " + id);
        creatorDBEntity.setResourceURI("someURI " + id);
        List<CreatorDBEntity> creatorDBEntities = new ArrayList<>();
        creatorDBEntities.add(creatorDBEntity);
        comicDBEntity.setCreators(creatorDBEntities);


        return comicDBEntity;
    }

    @Test
    public void getComicById() throws Exception {

    }

    @Test
    public void saveComicList() throws Exception {

    }

    @Test
    public void getDatabaseList() throws Exception {

    }

    @Test
    public void isDatabaseEmpty() throws Exception {

    }

}