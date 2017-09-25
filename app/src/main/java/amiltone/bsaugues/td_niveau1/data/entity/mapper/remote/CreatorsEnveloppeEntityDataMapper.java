package amiltone.bsaugues.td_niveau1.data.entity.mapper.remote;

import amiltone.bsaugues.td_niveau1.data.entity.CreatorsEnveloppeEntity;
import amiltone.bsaugues.td_niveau1.data.entity.remote.CreatorsEnveloppeRemoteEntity;

/**
 * Created by amiltonedev_dt013 on 22/09/2017.
 */

public class CreatorsEnveloppeEntityDataMapper {

    private CreatorEntityDataMapper creatorEntityDataMapper;

    public CreatorsEnveloppeEntityDataMapper(){
        creatorEntityDataMapper = new CreatorEntityDataMapper();
    }

    public CreatorsEnveloppeEntity transformToEntity (CreatorsEnveloppeRemoteEntity creatorsEnveloppeRemoteEntities){

        CreatorsEnveloppeEntity transformedComics = new CreatorsEnveloppeEntity();
        transformedComics.setCreators(creatorEntityDataMapper.transformToEntity(creatorsEnveloppeRemoteEntities.getCreators()));
        return transformedComics;
    }

}
