package amiltone.bsaugues.td_niveau1.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public class Comic implements Serializable {

    private long id;
    private String title;

    private String diamondCode;

    private List<SpecifiedUrl> urls;

    private List<SpecifiedDate> dates;

    @SerializedName("thumbnail")
    private Image image;

    private CreatorsEnveloppe creators;

    //region getters/setters

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    @Override
    public String toString() {
        return "Comic{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", diamondCode='" + diamondCode + '\'' +
                ", urls=" + getDetailsUrl() +
                ", dates=" + getOnSaleDate() +
                ", image=" + image.getUrl() +
                ", creators=" + creators +
                '}';
    }

    //endregion

    public String getDetailsUrl(){
        for(SpecifiedUrl url : urls){
            if(url.getType().equals("detail"))
                return url.getUrl();
        }
        return null;
    }

    public String getOnSaleDate(){
        for(SpecifiedDate date : dates){
            if(date.getType().equals("onsaleDate"))
                return date.getDate();
        }
        return null;
    }

    public List<Creator> getCreators(){
        return this.creators.getCreators();
    }



}
