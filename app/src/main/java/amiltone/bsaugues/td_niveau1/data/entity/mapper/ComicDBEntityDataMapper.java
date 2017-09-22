package amiltone.bsaugues.td_niveau1.data.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import amiltone.bsaugues.td_niveau1.data.entity.ComicEntity;
import amiltone.bsaugues.td_niveau1.data.entity.db.ComicDBEntity;

/**
 * Created by amiltonedev_dt013 on 22/09/2017.
 */

public class ComicDBEntityDataMapper {

    private SpecifiedUrlDBEntityDataMapper specifiedUrlDBEntityDataMapper;
    private SpecifiedDateDBEntityDataMapper specifiedDateDBEntityDataMapper;
    private ImageDBEntityDataMapper imageDBEntityDataMapper;
    private CreatorsEnveloppeDBEntityDataMapper creatorsEnveloppeDBEntityDataMapper;

    public ComicDBEntityDataMapper() {
        this.specifiedUrlDBEntityDataMapper = new SpecifiedUrlDBEntityDataMapper();
        this.specifiedDateDBEntityDataMapper = new SpecifiedDateDBEntityDataMapper();
        this.imageDBEntityDataMapper = new ImageDBEntityDataMapper();
        this.creatorsEnveloppeDBEntityDataMapper = new CreatorsEnveloppeDBEntityDataMapper();
    }

    public List<ComicDBEntity> transformToDB(List<ComicEntity> comicEntities) {
        List<ComicDBEntity> entities = new ArrayList<>();
        for (ComicEntity entity : comicEntities) {
            entities.add(transformToDB(entity));
        }
        return entities;
    }

    private ComicDBEntity transformToDB(ComicEntity comic) {

        ComicDBEntity entity = new ComicDBEntity();
        entity.setId(comic.getId());
        entity.setTitle(comic.getTitle());
        entity.setDiamondCode(comic.getDiamondCode());
        entity.setUrls(specifiedUrlDBEntityDataMapper.transformToDB(comic.getUrls()));
        entity.setDates(specifiedDateDBEntityDataMapper.transformToDB(comic.getDates()));
        entity.setImage(imageDBEntityDataMapper.transformToDB(comic.getImage()));
        entity.setCreators(creatorsEnveloppeDBEntityDataMapper.transformToDB(comic.getCreators()));

        return entity;
    }

    public List<ComicEntity> transformToEntity(List<ComicDBEntity> comicDBEntities){
        List<ComicEntity> entities = new ArrayList<>();
        for (ComicDBEntity entity : comicDBEntities) {
            entities.add(transformToEntity(entity));
        }
        return entities;
    }

    private ComicEntity transformToEntity(ComicDBEntity comic) {

        ComicEntity entity = new ComicEntity();
        entity.setId(comic.getId());
        entity.setTitle(comic.getTitle());
        entity.setDiamondCode(comic.getDiamondCode());
        entity.setUrls(specifiedUrlDBEntityDataMapper.transformToEntity(comic.getUrls()));
        entity.setDates(specifiedDateDBEntityDataMapper.transformToEntity(comic.getDates()));
        entity.setImage(imageDBEntityDataMapper.transformToEntity(comic.getImage()));
        entity.setCreators(creatorsEnveloppeDBEntityDataMapper.transformToEntity(comic.getCreators()));

        return entity;
    }

}
