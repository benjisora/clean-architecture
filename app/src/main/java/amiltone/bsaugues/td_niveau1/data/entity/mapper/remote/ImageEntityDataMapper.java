package amiltone.bsaugues.td_niveau1.data.entity.mapper.remote;

import javax.inject.Inject;
import javax.inject.Singleton;

import amiltone.bsaugues.td_niveau1.data.entity.ImageEntity;
import amiltone.bsaugues.td_niveau1.data.entity.remote.ImageRemoteEntity;

/**
 * Created by amiltonedev_dt013 on 22/09/2017.
 */
@Singleton
public class ImageEntityDataMapper {

    @Inject
    public ImageEntityDataMapper(){

    }

    public ImageEntity transformToEntity(ImageRemoteEntity imageRemoteEntity){
        ImageEntity entity = new ImageEntity();

        if(imageRemoteEntity == null){
            return entity;
        }

        entity.setPath(imageRemoteEntity.getPath());
        entity.setExtension(imageRemoteEntity.getExtension());

        return entity;
    }

}
