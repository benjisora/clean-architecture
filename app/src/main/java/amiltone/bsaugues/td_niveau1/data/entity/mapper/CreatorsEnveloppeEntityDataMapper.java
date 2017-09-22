package amiltone.bsaugues.td_niveau1.data.entity.mapper;

import java.util.ArrayList;
import java.util.List;

import amiltone.bsaugues.td_niveau1.data.entity.ComicEntity;
import amiltone.bsaugues.td_niveau1.data.entity.CreatorsEnveloppeEntity;
import amiltone.bsaugues.td_niveau1.data.entity.remote.ComicRemoteEntity;
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
