package amiltone.bsaugues.td_niveau1.data.model;

import java.util.Date;
import java.util.List;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public class Comic {

    private long id;
    private String title;

    private Date onSaleDate;
    private Image coverUrl;

    private List<Creator> creatorList;

    private String diamondCode;
    private String webUrl;

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

    public Date getOnSaleDate() {
        return onSaleDate;
    }

    public void setOnSaleDate(Date onSaleDate) {
        this.onSaleDate = onSaleDate;
    }

    public Image getCoverUrl() {
        return coverUrl;
    }

    public void setCoverUrl(Image coverUrl) {
        this.coverUrl = coverUrl;
    }

    public List<Creator> getCreatorList() {
        return creatorList;
    }

    public void setCreatorList(List<Creator> creatorList) {
        this.creatorList = creatorList;
    }

    public String getDiamondCode() {
        return diamondCode;
    }

    public void setDiamondCode(String diamondCode) {
        this.diamondCode = diamondCode;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    //endregion

}
