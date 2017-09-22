package amiltone.bsaugues.td_niveau1.data.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import amiltone.bsaugues.td_niveau1.data.entity.SpecifiedUrlEntity;

/**
 * Created by amiltonedev_dt013 on 22/09/2017.
 */

public class SpecifiedUrlEntityDataMapper {

    public SpecifiedUrlEntityDataMapper() {

    }

    public List<SpecifiedUrlEntity> transformToEntity(List<amiltone.bsaugues.td_niveau1.data.entity.remote.SpecifiedUrlEntity> specifiedUrlRemoteEntities) {

        List<SpecifiedUrlEntity> entities = new ArrayList<>();
        for (amiltone.bsaugues.td_niveau1.data.entity.remote.SpecifiedUrlEntity remoteEntity : specifiedUrlRemoteEntities) {
            entities.add(transformToEntity(remoteEntity));
        }
        return entities;

    }

    private SpecifiedUrlEntity transformToEntity(amiltone.bsaugues.td_niveau1.data.entity.remote.SpecifiedUrlEntity specifiedUrlRemoteEntity) {
        SpecifiedUrlEntity entity = new SpecifiedUrlEntity();
        entity.setType(specifiedUrlRemoteEntity.getType());
        entity.setUrl(specifiedUrlRemoteEntity.getUrl());
        return entity;
    }

}
