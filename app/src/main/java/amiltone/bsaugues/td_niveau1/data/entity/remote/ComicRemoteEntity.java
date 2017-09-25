package amiltone.bsaugues.td_niveau1.data.entity.remote;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public class ComicRemoteEntity implements Serializable {

    private int id;
    private String title;

    private String diamondCode;

    private List<SpecifiedUrlRemoteEntity> urls;

    private List<SpecifiedDateRemoteEntity> dates;

    @SerializedName("thumbnail")
    private ImageRemoteEntity image;

    private CreatorsEnveloppeRemoteEntity creators;

    //region getters/setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiamondCode() {
        return diamondCode;
    }

    public void setDiamondCode(String diamondCode) {
        this.diamondCode = diamondCode;
    }

    public List<SpecifiedUrlRemoteEntity> getUrls() {
        return urls;
    }

    public void setUrls(List<SpecifiedUrlRemoteEntity> urls) {
        this.urls = urls;
    }

    public List<SpecifiedDateRemoteEntity> getDates() {
        return dates;
    }

    public void setDates(List<SpecifiedDateRemoteEntity> dates) {
        this.dates = dates;
    }

    public ImageRemoteEntity getImage() {
        return image;
    }

    public void setImage(ImageRemoteEntity image) {
        this.image = image;
    }

    public void setCreators(CreatorsEnveloppeRemoteEntity creators) {
        this.creators = creators;
    }

    public CreatorsEnveloppeRemoteEntity getCreators() {
        return creators;
    }

    //endregion


}
