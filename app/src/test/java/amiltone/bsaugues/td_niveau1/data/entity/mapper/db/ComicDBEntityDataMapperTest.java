package amiltone.bsaugues.td_niveau1.data.entity.mapper.db;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import amiltone.bsaugues.td_niveau1.data.entity.ComicEntity;
import amiltone.bsaugues.td_niveau1.data.entity.CreatorEntity;
import amiltone.bsaugues.td_niveau1.data.entity.CreatorsEnveloppeEntity;
import amiltone.bsaugues.td_niveau1.data.entity.ImageEntity;
import amiltone.bsaugues.td_niveau1.data.entity.SpecifiedDateEntity;
import amiltone.bsaugues.td_niveau1.data.entity.SpecifiedUrlEntity;
import amiltone.bsaugues.td_niveau1.data.entity.db.ComicDBEntity;
import amiltone.bsaugues.td_niveau1.data.entity.db.CreatorDBEntity;
import amiltone.bsaugues.td_niveau1.data.entity.db.ImageDBEntity;
import amiltone.bsaugues.td_niveau1.data.entity.db.SpecifiedDateDBEntity;
import amiltone.bsaugues.td_niveau1.data.entity.db.SpecifiedUrlDBEntity;
import amiltone.bsaugues.td_niveau1.data.exception.NullParameterException;

import static junit.framework.Assert.fail;
import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by amiltonedev_dt013 on 27/09/2017.
 */
public class ComicDBEntityDataMapperTest {

    private List<ComicEntity> comicEntities;
    private List<ComicDBEntity> comicDBEntities;

    private ComicDBEntityDataMapper comicDBEntityDataMapper;

    @Before
    public void setUp() throws Exception {
        comicEntities = new ArrayList<>();
        comicDBEntities = new ArrayList<>();
        comicDBEntityDataMapper = new ComicDBEntityDataMapper();

        generateComicDBEntities();
        generateComicEntities();
    }

    private void generateComicEntities() {
        for (int i = 0; i < 5; i++) {
            comicEntities.add(createComicEntityWithId(i));
        }
    }

    private void generateComicDBEntities() {
        for (int i = 0; i < 5; i++) {
            comicDBEntities.add(createComicDBEntityWithId(i));
        }
    }

    private ComicEntity createComicEntityWithId(int id) {

        ComicEntity comicEntity = new ComicEntity();
        comicEntity.setId(id);
        comicEntity.setTitle("someTitle " + id);
        comicEntity.setDiamondCode("someDiamondCode " + id);

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

        SpecifiedUrlEntity specifiedUrlEntity = new SpecifiedUrlEntity();
        specifiedUrlEntity.setUrl("someUrl " + id);
        specifiedUrlEntity.setType("someType " + id);
        List<SpecifiedUrlEntity> specifiedUrlEntities = new ArrayList<>();
        specifiedUrlEntities.add(specifiedUrlEntity);
        comicEntity.setUrls(specifiedUrlEntities);

        CreatorsEnveloppeEntity creatorsEnveloppeEntity = new CreatorsEnveloppeEntity();
        CreatorEntity creatorEntity = new CreatorEntity();
        creatorEntity.setRole("someRole " + id);
        creatorEntity.setName("someName " + id);
        creatorEntity.setResourceURI("someURI " + id);
        List<CreatorEntity> creatorEntities = new ArrayList<>();
        creatorEntities.add(creatorEntity);
        creatorsEnveloppeEntity.setCreators(creatorEntities);
        comicEntity.setCreators(creatorsEnveloppeEntity);

        return comicEntity;
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
        specifiedDateDBEntity.setComicId(comicDBEntity.getId());
        List<SpecifiedDateDBEntity> specifiedDateDBEntities = new ArrayList<>();
        specifiedDateDBEntities.add(specifiedDateDBEntity);
        comicDBEntity.setDates(specifiedDateDBEntities);

        SpecifiedUrlDBEntity specifiedUrlDBEntity = new SpecifiedUrlDBEntity();
        specifiedUrlDBEntity.setUrl("someUrl " + id);
        specifiedUrlDBEntity.setType("someType " + id);
        specifiedUrlDBEntity.setComicId(comicDBEntity.getId());
        List<SpecifiedUrlDBEntity> specifiedUrlDBEntities = new ArrayList<>();
        specifiedUrlDBEntities.add(specifiedUrlDBEntity);
        comicDBEntity.setUrls(specifiedUrlDBEntities);

        CreatorDBEntity creatorDBEntity = new CreatorDBEntity();
        creatorDBEntity.setRole("someRole " + id);
        creatorDBEntity.setName("someName " + id);
        creatorDBEntity.setResourceURI("someURI " + id);
        creatorDBEntity.setComicId(comicDBEntity.getId());
        List<CreatorDBEntity> creatorDBEntities = new ArrayList<>();
        creatorDBEntities.add(creatorDBEntity);
        comicDBEntity.setCreators(creatorDBEntities);


        return comicDBEntity;
    }


    @Test
    public void transformToDBSuccess() {
        assertThat(comicDBEntityDataMapper.transformToDB(comicEntities))
                .isEqualTo(comicDBEntities);
    }

    @Test
    public void transformToEntitiesSuccess() {
        assertThat(comicDBEntityDataMapper.transformToEntity(comicDBEntities))
                .isEqualTo(comicEntities);
    }

    @Test
    public void transformToEntity1Success() {
        assertThat(comicDBEntityDataMapper.transformToEntity(comicDBEntities.get(0)))
                .isEqualTo(comicEntities.get(0));
    }

}