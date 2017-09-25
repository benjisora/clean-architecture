package amiltone.bsaugues.td_niveau1.data.entity.mapper.remote;

import java.util.ArrayList;
import java.util.List;

import amiltone.bsaugues.td_niveau1.data.entity.ImageEntity;
import amiltone.bsaugues.td_niveau1.data.entity.SpecifiedDateEntity;
import amiltone.bsaugues.td_niveau1.data.entity.remote.ImageRemoteEntity;
import amiltone.bsaugues.td_niveau1.data.entity.remote.SpecifiedDateRemoteEntity;

/**
 * Created by amiltonedev_dt013 on 22/09/2017.
 */

public class SpecifiedDateEntityDataMapper {

    public SpecifiedDateEntityDataMapper(){

    }

    public List<SpecifiedDateEntity> transformToEntity (List<SpecifiedDateRemoteEntity> creatorRemoteEntities){

        List<SpecifiedDateEntity> entities = new ArrayList<>();
        for(SpecifiedDateRemoteEntity remoteEntity : creatorRemoteEntities){
            entities.add(transformToEntity(remoteEntity));
        }
        return entities;

    }

    private SpecifiedDateEntity transformToEntity(SpecifiedDateRemoteEntity specifiedDateRemoteEntity){
        SpecifiedDateEntity entity = new SpecifiedDateEntity();
        entity.setType(specifiedDateRemoteEntity.getType());
        entity.setDate(specifiedDateRemoteEntity.getDate());
        return entity;
    }

}
