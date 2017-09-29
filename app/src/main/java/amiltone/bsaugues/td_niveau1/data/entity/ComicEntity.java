package amiltone.bsaugues.td_niveau1.data.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

import amiltone.bsaugues.td_niveau1.data.entity.db.ComicDBEntity;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public class ComicEntity implements Serializable {

    private int id;
    private String title;

    private String diamondCode;

    private List<SpecifiedUrlEntity> urls;

    private List<SpecifiedDateEntity> dates;

    @SerializedName("thumbnail")
    private ImageEntity image;

    private CreatorsEnveloppeEntity creators;

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

    public List<SpecifiedUrlEntity> getUrls() {
        return urls;
    }

    public void setUrls(List<SpecifiedUrlEntity> urls) {
        this.urls = urls;
    }

    public List<SpecifiedDateEntity> getDates() {
        return dates;
    }

    public void setDates(List<SpecifiedDateEntity> dates) {
        this.dates = dates;
    }

    public ImageEntity getImage() {
        return image;
    }

    public void setImage(ImageEntity image) {
        this.image = image;
    }

    public void setCreators(CreatorsEnveloppeEntity creators) {
        this.creators = creators;
    }

    public CreatorsEnveloppeEntity getCreators() {
        return creators;
    }

    //endregion

    @Override
    public boolean equals(Object o) {
        return o instanceof ComicEntity && ((ComicEntity) o).getId() == this.getId();
    }

    @Override
    public String toString() {
        return "ComicEntity{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", diamondCode='" + diamondCode + '\'' +
                ", urls=" + urls +
                ", dates=" + dates +
                ", image=" + image +
                ", creators=" + creators +
                '}';
    }
}
