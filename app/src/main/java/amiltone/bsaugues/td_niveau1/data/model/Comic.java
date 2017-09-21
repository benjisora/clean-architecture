package amiltone.bsaugues.td_niveau1.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public class Comic implements Serializable {

    private int id;
    private String title;

    private String diamondCode;

    private List<SpecifiedUrl> urls;

    private List<SpecifiedDate> dates;

    @SerializedName("thumbnail")
    private Image image;

    private CreatorsEnveloppe creators;

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

    public List<SpecifiedUrl> getUrls() {
        return urls;
    }

    public void setUrls(List<SpecifiedUrl> urls) {
        this.urls = urls;
    }

    public List<SpecifiedDate> getDates() {
        return dates;
    }

    public void setDates(List<SpecifiedDate> dates) {
        this.dates = dates;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public void setCreators(CreatorsEnveloppe creators) {
        this.creators = creators;
    }

    public CreatorsEnveloppe getCreators() {
        return creators;
    }

    //endregion


}
