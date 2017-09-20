package amiltone.bsaugues.td_niveau1.data.model;

import java.util.List;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public class Comic {

    private long id;
    private String title;

    private String diamondCode;

    private List<SpecifiedUrl> urls;

    private List<SpecifiedDate> dates;

    private Image thumbnail;

    private List<Creator> creators;


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

    public Image getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Image thumbnail) {
        this.thumbnail = thumbnail;
    }

    public List<Creator> getCreators() {
        return creators;
    }

    public void setCreators(List<Creator> creators) {
        this.creators = creators;
    }


    //endregion

}
