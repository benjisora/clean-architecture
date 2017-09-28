package amiltone.bsaugues.td_niveau1.data.entity.mapper.remote;

import java.util.ArrayList;
import java.util.List;

import amiltone.bsaugues.td_niveau1.data.entity.SpecifiedUrlEntity;
import amiltone.bsaugues.td_niveau1.data.entity.db.SpecifiedUrlDBEntity;
import amiltone.bsaugues.td_niveau1.data.entity.remote.SpecifiedUrlRemoteEntity;

/**
 * Created by amiltonedev_dt013 on 22/09/2017.
 */

public class SpecifiedUrlEntityDataMapper {

    public SpecifiedUrlEntityDataMapper() {

    }

    public List<SpecifiedUrlEntity> transformToEntity(List<SpecifiedUrlRemoteEntity> specifiedUrlRemoteEntities) {

        List<SpecifiedUrlEntity> entities = new ArrayList<>();

        if(specifiedUrlRemoteEntities == null){
            return entities;
        }

        for (SpecifiedUrlRemoteEntity remoteEntity : specifiedUrlRemoteEntities) {
            entities.add(transformToEntity(remoteEntity));
        }
        return entities;

    }

    private SpecifiedUrlEntity transformToEntity(SpecifiedUrlRemoteEntity specifiedUrlRemoteEntity) {
        SpecifiedUrlEntity entity = new SpecifiedUrlEntity();

        if(specifiedUrlRemoteEntity == null){
            return entity;
        }

        entity.setType(specifiedUrlRemoteEntity.getType());
        entity.setUrl(specifiedUrlRemoteEntity.getUrl());
        return entity;
    }


}
