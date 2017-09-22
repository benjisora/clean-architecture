package amiltone.bsaugues.td_niveau1.data.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import amiltone.bsaugues.td_niveau1.data.entity.CreatorEntity;
import amiltone.bsaugues.td_niveau1.data.entity.CreatorsEnveloppeEntity;
import amiltone.bsaugues.td_niveau1.data.entity.remote.CreatorRemoteEntity;
import amiltone.bsaugues.td_niveau1.data.entity.remote.CreatorsEnveloppeRemoteEntity;

/**
 * Created by amiltonedev_dt013 on 22/09/2017.
 */

public class CreatorEntityDataMapper {

    public CreatorEntityDataMapper(){

    }

    public List<CreatorEntity> transformToEntity (List<CreatorRemoteEntity> creatorRemoteEntities){

        List<CreatorEntity> entities = new ArrayList<>();
        for(CreatorRemoteEntity remoteEntity : creatorRemoteEntities){
            entities.add(transformToEntity(remoteEntity));
        }
        return entities;

    }

    private CreatorEntity transformToEntity(CreatorRemoteEntity creatorRemoteEntity){

        CreatorEntity entity = new CreatorEntity();
        entity.setName(creatorRemoteEntity.getName());
        entity.setRole(creatorRemoteEntity.getRole());

        return entity;
    }

}
