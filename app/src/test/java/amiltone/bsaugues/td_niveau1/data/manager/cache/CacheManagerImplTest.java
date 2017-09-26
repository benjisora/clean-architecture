package amiltone.bsaugues.td_niveau1.data.manager.cache;

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
import amiltone.bsaugues.td_niveau1.data.exception.ComicNotFoundException;
import amiltone.bsaugues.td_niveau1.data.exception.NoComicInCacheException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by amiltonedev_dt013 on 25/09/2017.
 */
public class CacheManagerImplTest {

    private List<ComicEntity> comicEntities;

    private ComicEntity comicEntity;

    private CacheManager cacheManager;

    private int index;

    @Before
    public void setUp() throws Exception {

        cacheManager = new CacheManagerImpl();

        comicEntities = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            comicEntities.add(createComicEntityWithId(i));
        }

        comicEntity = comicEntities.get(0);
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

    @Test
    public void getComicByIdSuccess() throws Exception {
        index = 1;
        cacheManager.saveComicList(comicEntities);
        assertThat(cacheManager.getComicById(index)).isEqualTo(comicEntities.get(index));
    }

    @Test
    public void getComicByIdNotFound() throws Exception {
        index = 1;
        try {
            cacheManager.getComicById(index);
        } catch (Exception e) {
            assertThat(e).isInstanceOf(ComicNotFoundException.class);
        }
    }


    @Test
    public void saveComicList() throws Exception {
        cacheManager.saveComicList(comicEntities);
        assertThat(cacheManager.getCachedList()).isNotNull();
    }

    @Test
    public void saveComic() throws Exception {
        cacheManager.saveComic(comicEntity);
        assertThat(cacheManager.getCachedList()).isNotNull();
    }

    @Test
    public void getCachedListSuccess() throws Exception {
        cacheManager.saveComicList(comicEntities);
        assertThat(cacheManager.getCachedList()).isEqualTo(comicEntities);
    }

    @Test
    public void getCachedListNoComicInCache() throws Exception {
        try {
            cacheManager.getCachedList();
        } catch (Exception e) {
            assertThat(e).isInstanceOf(NoComicInCacheException.class);
        }
    }


    @Test
    public void isCacheEmpty() throws Exception {
        assertThat(cacheManager.isCacheEmpty()).isEqualTo(true);

        cacheManager.saveComicList(comicEntities);
        assertThat(cacheManager.isCacheEmpty()).isEqualTo(false);
    }

}