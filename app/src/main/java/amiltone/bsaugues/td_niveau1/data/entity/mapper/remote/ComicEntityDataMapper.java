package amiltone.bsaugues.td_niveau1.data.entity.mapper.remote;

import java.util.ArrayList;
import java.util.List;

import amiltone.bsaugues.td_niveau1.data.entity.ComicEntity;
import amiltone.bsaugues.td_niveau1.data.entity.remote.ComicRemoteEntity;

/**
 * Created by amiltonedev_dt013 on 22/09/2017.
 */

public class ComicEntityDataMapper {

    private SpecifiedUrlEntityDataMapper specifiedUrlEntityDataMapper;
    private SpecifiedDateEntityDataMapper specifiedDateEntityDataMapper;
    private ImageEntityDataMapper imageEntityDataMapper;
    private CreatorsEnveloppeEntityDataMapper creatorsEnveloppeEntityDataMapper;

    public ComicEntityDataMapper() {
        this.specifiedUrlEntityDataMapper = new SpecifiedUrlEntityDataMapper();
        this.specifiedDateEntityDataMapper = new SpecifiedDateEntityDataMapper();
        this.imageEntityDataMapper = new ImageEntityDataMapper();
        this.creatorsEnveloppeEntityDataMapper = new CreatorsEnveloppeEntityDataMapper();
    }

    public List<ComicEntity> transformToEntity(List<ComicRemoteEntity> comicRemoteEntities) {
        List<ComicEntity> entities = new ArrayList<>();
        
        if(comicRemoteEntities == null){
            return entities;
        }
        
        for (ComicRemoteEntity remoteEntity : comicRemoteEntities) {
            entities.add(transformToEntity(remoteEntity));
        }
        return entities;
    }

    private ComicEntity transformToEntity(ComicRemoteEntity comic) {

        ComicEntity entity = new ComicEntity();

        if(comic == null){
            return entity;
        }

        entity.setId(comic.getId());
        entity.setTitle(comic.getTitle());
        entity.setDiamondCode(comic.getDiamondCode());
        entity.setCreators(creatorsEnveloppeEntityDataMapper.transformToEntity(comic.getCreators()));
        entity.setDates(specifiedDateEntityDataMapper.transformToEntity(comic.getDates()));
        entity.setImage(imageEntityDataMapper.transformToEntity(comic.getImage()));
        entity.setUrls(specifiedUrlEntityDataMapper.transformToEntity(comic.getUrls()));

        return entity;
    }

}
