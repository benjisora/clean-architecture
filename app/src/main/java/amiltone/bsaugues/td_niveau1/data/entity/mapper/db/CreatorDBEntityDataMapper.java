package amiltone.bsaugues.td_niveau1.data.entity.mapper.db;

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

        if(creatorEntities == null){
            return entities;
        }

        for (int i = 0; i < creatorEntities.size(); i++) {
            entities.add(transformToDB(creatorEntities.get(i), comicId));
        }
        return entities;
    }

    private CreatorDBEntity transformToDB(CreatorEntity creatorEntity, int comicId) {

        CreatorDBEntity entity = new CreatorDBEntity();
        entity.setComicId(comicId);

        if (creatorEntity == null) {
            return entity;
        }

        entity.setName(creatorEntity.getName());
        entity.setRole(creatorEntity.getRole());
        entity.setResourceURI(creatorEntity.getResourceURI());

        return entity;
    }

    public List<CreatorEntity> transformToEntity(List<CreatorDBEntity> creatorDBEntities) {

        List<CreatorEntity> entities = new ArrayList<>();

        if(creatorDBEntities == null){
            return entities;
        }

        for (int i = 0; i < creatorDBEntities.size(); i++) {
            entities.add(transformToEntity(creatorDBEntities.get(i)));
        }
        return entities;

    }

    private CreatorEntity transformToEntity(CreatorDBEntity creatorRemoteDBEntity) {

        CreatorEntity entity = new CreatorEntity();

        if (creatorRemoteDBEntity == null) {
            return entity;
        }
        entity.setName(creatorRemoteDBEntity.getName());
        entity.setRole(creatorRemoteDBEntity.getRole());
        entity.setResourceURI(creatorRemoteDBEntity.getResourceURI());

        return entity;
    }

}
