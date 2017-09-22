package amiltone.bsaugues.td_niveau1.data.entity.mapper;

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

    public List<SpecifiedUrlDBEntity> transformToDB(List<SpecifiedUrlEntity> specifiedUrlEntities) {

        List<SpecifiedUrlDBEntity> entities = new ArrayList<>();
        for (SpecifiedUrlEntity entity : specifiedUrlEntities) {
            entities.add(transformToDB(entity));
        }
        return entities;

    }

    private SpecifiedUrlDBEntity transformToDB(SpecifiedUrlEntity specifiedUrlEntity) {
        SpecifiedUrlDBEntity entity = new SpecifiedUrlDBEntity();
        entity.setType(specifiedUrlEntity.getType());
        entity.setUrl(specifiedUrlEntity.getUrl());
        return entity;
    }

}
