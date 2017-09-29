package amiltone.bsaugues.td_niveau1.data.entity.mapper.remote;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import amiltone.bsaugues.td_niveau1.data.entity.CreatorEntity;
import amiltone.bsaugues.td_niveau1.data.entity.remote.CreatorRemoteEntity;

/**
 * Created by amiltonedev_dt013 on 22/09/2017.
 */
@Singleton
public class CreatorEntityDataMapper {

    @Inject
    public CreatorEntityDataMapper() {

    }

    public List<CreatorEntity> transformToEntity(List<CreatorRemoteEntity> creatorRemoteEntities) {

        List<CreatorEntity> entities = new ArrayList<>();
        if (creatorRemoteEntities == null) {
            return entities;
        }

        for (CreatorRemoteEntity remoteEntity : creatorRemoteEntities) {
            entities.add(transformToEntity(remoteEntity));
        }
        return entities;

    }

    private CreatorEntity transformToEntity(CreatorRemoteEntity creatorRemoteEntity) {

        CreatorEntity entity = new CreatorEntity();

        if (creatorRemoteEntity == null) {
            return entity;
        }

        entity.setName(creatorRemoteEntity.getName());
        entity.setRole(creatorRemoteEntity.getRole());

        return entity;
    }

}
