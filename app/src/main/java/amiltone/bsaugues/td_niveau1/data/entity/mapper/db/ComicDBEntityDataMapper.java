package amiltone.bsaugues.td_niveau1.data.entity.mapper.db;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import amiltone.bsaugues.td_niveau1.data.entity.ComicEntity;
import amiltone.bsaugues.td_niveau1.data.entity.CreatorsEnveloppeEntity;
import amiltone.bsaugues.td_niveau1.data.entity.db.ComicDBEntity;

/**
 * Created by amiltonedev_dt013 on 22/09/2017.
 */
@Singleton
public class ComicDBEntityDataMapper {

    private SpecifiedUrlDBEntityDataMapper specifiedUrlDBEntityDataMapper;
    private SpecifiedDateDBEntityDataMapper specifiedDateDBEntityDataMapper;
    private ImageDBEntityDataMapper imageDBEntityDataMapper;
    private CreatorDBEntityDataMapper creatorDBEntityDataMapper;

    @Inject
    public ComicDBEntityDataMapper(SpecifiedUrlDBEntityDataMapper specifiedUrlDBEntityDataMapper, SpecifiedDateDBEntityDataMapper specifiedDateDBEntityDataMapper, ImageDBEntityDataMapper imageDBEntityDataMapper, CreatorDBEntityDataMapper creatorDBEntityDataMapper) {
        this.specifiedUrlDBEntityDataMapper = specifiedUrlDBEntityDataMapper;
        this.specifiedDateDBEntityDataMapper = specifiedDateDBEntityDataMapper;
        this.imageDBEntityDataMapper = imageDBEntityDataMapper;
        this.creatorDBEntityDataMapper = creatorDBEntityDataMapper;
    }

    public List<ComicDBEntity> transformToDB(List<ComicEntity> comicEntities) {
        List<ComicDBEntity> entities = new ArrayList<>();

        if (comicEntities == null) {
            return entities;
        }

        for (ComicEntity comic : comicEntities) {
            entities.add(transformToDB(comic));
        }
        return entities;
    }

    private ComicDBEntity transformToDB(ComicEntity comic) {

        ComicDBEntity entity = new ComicDBEntity();

        if (comic == null) {
            return entity;
        }

        entity.setId(comic.getId());
        entity.setTitle(comic.getTitle());
        entity.setDiamondCode(comic.getDiamondCode());
        entity.setUrls(specifiedUrlDBEntityDataMapper.transformToDB(comic.getUrls(), comic.getId()));
        entity.setDates(specifiedDateDBEntityDataMapper.transformToDB(comic.getDates(), comic.getId()));
        entity.setImage(imageDBEntityDataMapper.transformToDB(comic.getImage()));
        entity.setCreators(creatorDBEntityDataMapper.transformToDB(comic.getCreators().getCreators(), comic.getId()));

        return entity;
    }

    public List<ComicEntity> transformToEntity(List<ComicDBEntity> comicDBEntities) {

        List<ComicEntity> entities = new ArrayList<>();

        if (comicDBEntities == null) {
            return entities;
        }

        for (int i = 0; i < comicDBEntities.size(); i++) {
            entities.add(transformToEntity(comicDBEntities.get(i)));
        }
        return entities;
    }

    public ComicEntity transformToEntity(ComicDBEntity comic) {

        ComicEntity entity = new ComicEntity();

        if (comic == null) {
            return entity;
        }

        entity.setId(comic.getId());
        entity.setTitle(comic.getTitle());
        entity.setDiamondCode(comic.getDiamondCode());
        entity.setUrls(specifiedUrlDBEntityDataMapper.transformToEntity(comic.getUrls()));
        entity.setDates(specifiedDateDBEntityDataMapper.transformToEntity(comic.getDates()));
        entity.setImage(imageDBEntityDataMapper.transformToEntity(comic.getImage()));
        CreatorsEnveloppeEntity creatorsEnveloppeEntity = new CreatorsEnveloppeEntity();
        creatorsEnveloppeEntity.setCreators(creatorDBEntityDataMapper.transformToEntity(comic.getCreators()));
        entity.setCreators(creatorsEnveloppeEntity);

        return entity;
    }

}
