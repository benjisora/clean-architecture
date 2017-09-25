package amiltone.bsaugues.td_niveau1.data.entity.mapper.db;

import java.util.ArrayList;
import java.util.List;

import amiltone.bsaugues.td_niveau1.data.entity.SpecifiedUrlEntity;
import amiltone.bsaugues.td_niveau1.data.entity.db.SpecifiedUrlDBEntity;

/**
 * Created by amiltonedev_dt013 on 22/09/2017.
 */

public class SpecifiedUrlDBEntityDataMapper {

    public SpecifiedUrlDBEntityDataMapper() {

    }

    public List<SpecifiedUrlDBEntity> transformToDB(List<SpecifiedUrlEntity> specifiedUrlEntities, int comicId) {

        List<SpecifiedUrlDBEntity> entities = new ArrayList<>();
        for (SpecifiedUrlEntity entity : specifiedUrlEntities) {
            entities.add(transformToDB(entity, comicId));
        }
        return entities;

    }

    private SpecifiedUrlDBEntity transformToDB(SpecifiedUrlEntity specifiedUrlEntity, int comicId) {
        SpecifiedUrlDBEntity entity = new SpecifiedUrlDBEntity();
        entity.setType(specifiedUrlEntity.getType());
        entity.setUrl(specifiedUrlEntity.getUrl());
        entity.setComicId(comicId);
        return entity;
    }

    public List<SpecifiedUrlEntity> transformToEntity(List<SpecifiedUrlDBEntity> specifiedUrlDBEntities) {

        List<SpecifiedUrlEntity> entities = new ArrayList<>();
        for (SpecifiedUrlDBEntity entity : specifiedUrlDBEntities) {
            entities.add(transformToEntity(entity));
        }
        return entities;

    }

    private SpecifiedUrlEntity transformToEntity(SpecifiedUrlDBEntity specifiedUrlDBEntity) {
        SpecifiedUrlEntity entity = new SpecifiedUrlEntity();
        entity.setType(specifiedUrlDBEntity.getType());
        entity.setUrl(specifiedUrlDBEntity.getUrl());
        return entity;
    }

}
