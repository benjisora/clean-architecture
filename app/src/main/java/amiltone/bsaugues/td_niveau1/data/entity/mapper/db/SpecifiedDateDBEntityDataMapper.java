package amiltone.bsaugues.td_niveau1.data.entity.mapper.db;

import java.util.ArrayList;
import java.util.List;

import amiltone.bsaugues.td_niveau1.data.entity.SpecifiedDateEntity;
import amiltone.bsaugues.td_niveau1.data.entity.db.SpecifiedDateDBEntity;

/**
 * Created by amiltonedev_dt013 on 22/09/2017.
 */

public class SpecifiedDateDBEntityDataMapper {

    public SpecifiedDateDBEntityDataMapper() {

    }

    public List<SpecifiedDateDBEntity> transformToDB(List<SpecifiedDateEntity> creatorEntities, int comicId) {

        List<SpecifiedDateDBEntity> entities = new ArrayList<>();

        if(creatorEntities == null){
            return entities;
        }

        for (int i = 0; i < creatorEntities.size(); i++) {
            entities.add(transformToDB(creatorEntities.get(i), comicId));
        }
        return entities;

    }

    private SpecifiedDateDBEntity transformToDB(SpecifiedDateEntity specifiedDateEntity, int comicId) {
        SpecifiedDateDBEntity entity = new SpecifiedDateDBEntity();
        entity.setComicId(comicId);

        if(specifiedDateEntity == null){
            return entity;
        }

        entity.setType(specifiedDateEntity.getType());
        entity.setDate(specifiedDateEntity.getDate());

        return entity;
    }

    public List<SpecifiedDateEntity> transformToEntity(List<SpecifiedDateDBEntity> specifiedDateDBEntities) {

        List<SpecifiedDateEntity> entities = new ArrayList<>();

        if(specifiedDateDBEntities == null){
            return entities;
        }

        for (int i = 0; i < specifiedDateDBEntities.size(); i++) {
            entities.add(transformToEntity(specifiedDateDBEntities.get(i)));
        }
        return entities;

    }

    private SpecifiedDateEntity transformToEntity(SpecifiedDateDBEntity specifiedDateDBEntity) {
        SpecifiedDateEntity entity = new SpecifiedDateEntity();

        if(specifiedDateDBEntity == null){
            return entity;
        }

        entity.setType(specifiedDateDBEntity.getType());
        entity.setDate(specifiedDateDBEntity.getDate());
        return entity;
    }

}
