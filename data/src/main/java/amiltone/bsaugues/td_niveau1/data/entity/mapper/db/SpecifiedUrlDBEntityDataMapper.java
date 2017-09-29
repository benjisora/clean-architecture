package amiltone.bsaugues.td_niveau1.data.entity.mapper.db;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import amiltone.bsaugues.td_niveau1.data.entity.SpecifiedUrlEntity;
import amiltone.bsaugues.td_niveau1.data.entity.db.SpecifiedUrlDBEntity;

/**
 * Created by amiltonedev_dt013 on 22/09/2017.
 */
@Singleton
public class SpecifiedUrlDBEntityDataMapper {

    @Inject
    public SpecifiedUrlDBEntityDataMapper() {

    }

    public List<SpecifiedUrlDBEntity> transformToDB(List<SpecifiedUrlEntity> specifiedUrlEntities, int comicId) {

        List<SpecifiedUrlDBEntity> entities = new ArrayList<>();

        if (specifiedUrlEntities == null) {
            return entities;
        }

        for (int i = 0; i < specifiedUrlEntities.size(); i++) {
            entities.add(transformToDB(specifiedUrlEntities.get(i), comicId));
        }
        return entities;

    }

    private SpecifiedUrlDBEntity transformToDB(SpecifiedUrlEntity specifiedUrlEntity, int comicId) {
        SpecifiedUrlDBEntity entity = new SpecifiedUrlDBEntity();
        entity.setComicId(comicId);

        if (specifiedUrlEntity == null) {
            return entity;
        }

        entity.setType(specifiedUrlEntity.getType());
        entity.setUrl(specifiedUrlEntity.getUrl());

        return entity;
    }

    public List<SpecifiedUrlEntity> transformToEntity(List<SpecifiedUrlDBEntity> specifiedUrlDBEntities) {

        List<SpecifiedUrlEntity> entities = new ArrayList<>();

        if (specifiedUrlDBEntities == null) {
            return entities;
        }

        for (int i = 0; i < specifiedUrlDBEntities.size(); i++) {
            entities.add(transformToEntity(specifiedUrlDBEntities.get(i)));
        }
        return entities;

    }

    private SpecifiedUrlEntity transformToEntity(SpecifiedUrlDBEntity specifiedUrlDBEntity) {
        SpecifiedUrlEntity entity = new SpecifiedUrlEntity();

        if (specifiedUrlDBEntity == null) {
            return entity;
        }

        entity.setType(specifiedUrlDBEntity.getType());
        entity.setUrl(specifiedUrlDBEntity.getUrl());
        return entity;
    }

}
