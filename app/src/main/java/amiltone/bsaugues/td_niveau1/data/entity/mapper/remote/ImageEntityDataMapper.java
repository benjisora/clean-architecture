package amiltone.bsaugues.td_niveau1.data.entity.mapper.remote;

import amiltone.bsaugues.td_niveau1.data.entity.ImageEntity;
import amiltone.bsaugues.td_niveau1.data.entity.remote.ImageRemoteEntity;

/**
 * Created by amiltonedev_dt013 on 22/09/2017.
 */

public class ImageEntityDataMapper {

    public ImageEntityDataMapper(){

    }

    public ImageEntity transformToEntity(ImageRemoteEntity imageRemoteEntity){
        ImageEntity entity = new ImageEntity();
        entity.setPath(imageRemoteEntity.getPath());
        entity.setExtension(imageRemoteEntity.getExtension());

        return entity;
    }

}
