package amiltone.bsaugues.td_niveau1.data.entity.mapper.db;

import javax.inject.Inject;
import javax.inject.Singleton;

import amiltone.bsaugues.td_niveau1.data.entity.ImageEntity;
import amiltone.bsaugues.td_niveau1.data.entity.db.ImageDBEntity;
import amiltone.bsaugues.td_niveau1.data.entity.remote.ImageRemoteEntity;

/**
 * Created by amiltonedev_dt013 on 22/09/2017.
 */
@Singleton
public class ImageDBEntityDataMapper {

    @Inject
    public ImageDBEntityDataMapper(){

    }

    public ImageDBEntity transformToDB(ImageEntity imageEntity){
        ImageDBEntity entity = new ImageDBEntity();

        if(imageEntity == null){
            return entity;
        }

        entity.setPath(imageEntity.getPath());
        entity.setExtension(imageEntity.getExtension());

        return entity;
    }

    public ImageEntity transformToEntity(ImageDBEntity imageDBEntity){
        ImageEntity entity = new ImageEntity();

        if(imageDBEntity == null){
            return entity;
        }

        entity.setPath(imageDBEntity.getPath());
        entity.setExtension(imageDBEntity.getExtension());

        return entity;
    }

}
