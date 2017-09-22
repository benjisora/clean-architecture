package amiltone.bsaugues.td_niveau1.data.entity.mapper;

import amiltone.bsaugues.td_niveau1.data.entity.CreatorsEnveloppeEntity;
import amiltone.bsaugues.td_niveau1.data.entity.db.CreatorsEnveloppeDBEntity;

/**
 * Created by amiltonedev_dt013 on 22/09/2017.
 */

public class CreatorsEnveloppeDBEntityDataMapper {

    private CreatorDBEntityDataMapper creatorDBEntityDataMapper;

    public CreatorsEnveloppeDBEntityDataMapper() {
        creatorDBEntityDataMapper = new CreatorDBEntityDataMapper();
    }

    public CreatorsEnveloppeDBEntity transformToDB(CreatorsEnveloppeEntity creatorsEnveloppeEntities) {

        CreatorsEnveloppeDBEntity transformedComics = new CreatorsEnveloppeDBEntity();
        transformedComics.setCreators(creatorDBEntityDataMapper.transformToDB(creatorsEnveloppeEntities.getCreators()));
        return transformedComics;
    }

    public CreatorsEnveloppeEntity transformToEntity(CreatorsEnveloppeDBEntity creatorsEnveloppeDBEntities) {

        CreatorsEnveloppeEntity transformedComics = new CreatorsEnveloppeEntity();
        transformedComics.setCreators(creatorDBEntityDataMapper.transformToEntity(creatorsEnveloppeDBEntities.getCreators()));
        return transformedComics;
    }

}
