package amiltone.bsaugues.td_niveau1.data.entity.mapper;

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

    public List<SpecifiedDateDBEntity> transformToDB(List<SpecifiedDateEntity> creatorEntities) {

        List<SpecifiedDateDBEntity> entities = new ArrayList<>();
        for (SpecifiedDateEntity entity : creatorEntities) {
            entities.add(transformToDB(entity));
        }
        return entities;

    }

    private SpecifiedDateDBEntity transformToDB(SpecifiedDateEntity specifiedDateEntity) {
        SpecifiedDateDBEntity entity = new SpecifiedDateDBEntity();
        entity.setType(specifiedDateEntity.getType());
        entity.setDate(specifiedDateEntity.getDate());
        return entity;
    }

    public List<SpecifiedDateEntity> transformToEntity(List<SpecifiedDateDBEntity> creatorDBEntities) {

        List<SpecifiedDateEntity> entities = new ArrayList<>();
        for (SpecifiedDateDBEntity entity : creatorDBEntities) {
            entities.add(transformToEntity(entity));
        }
        return entities;

    }

    private SpecifiedDateEntity transformToEntity(SpecifiedDateDBEntity specifiedDateEntity) {
        SpecifiedDateEntity entity = new SpecifiedDateEntity();
        entity.setType(specifiedDateEntity.getType());
        entity.setDate(specifiedDateEntity.getDate());
        return entity;
    }

}
