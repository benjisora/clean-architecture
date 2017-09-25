package amiltone.bsaugues.td_niveau1.data.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import amiltone.bsaugues.td_niveau1.data.entity.CreatorEntity;
import amiltone.bsaugues.td_niveau1.data.entity.db.CreatorDBEntity;

/**
 * Created by amiltonedev_dt013 on 22/09/2017.
 */

public class CreatorDBEntityDataMapper {

    public CreatorDBEntityDataMapper() {

    }

    public List<CreatorDBEntity> transformToDB(List<CreatorEntity> creatorEntities, int comicId) {

        List<CreatorDBEntity> entities = new ArrayList<>();
        for (CreatorEntity entity : creatorEntities) {
            entities.add(transformToDB(entity, comicId));
        }
        return entities;
    }

    private CreatorDBEntity transformToDB(CreatorEntity creatorEntity, int comicId) {

        CreatorDBEntity entity = new CreatorDBEntity();
        entity.setName(creatorEntity.getName());
        entity.setRole(creatorEntity.getRole());
        entity.setComicId(comicId);

        return entity;
    }

    public List<CreatorEntity> transformToEntity(List<CreatorDBEntity> creatorEntities) {

        List<CreatorEntity> entities = new ArrayList<>();
        for (CreatorDBEntity entity : creatorEntities) {
            entities.add(transformToEntity(entity));
        }
        return entities;

    }

    private CreatorEntity transformToEntity(CreatorDBEntity creatorRemoteEntity) {

        CreatorEntity entity = new CreatorEntity();
        entity.setName(creatorRemoteEntity.getName());
        entity.setRole(creatorRemoteEntity.getRole());

        return entity;
    }

}
