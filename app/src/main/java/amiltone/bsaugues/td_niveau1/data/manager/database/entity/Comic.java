package amiltone.bsaugues.td_niveau1.data.manager.database.entity;

import com.google.gson.annotations.SerializedName;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.OneToMany;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.io.Serializable;
import java.util.List;

import amiltone.bsaugues.td_niveau1.data.manager.database.DatabaseManager;
import amiltone.bsaugues.td_niveau1.data.manager.database.DatabaseManagerImpl;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */
@Table(database = DatabaseManagerImpl.class)
public class Comic implements Serializable {

    @PrimaryKey
    private int id;

    @Column
    private String title;

    @Column
    private String diamondCode;

    private List<SpecifiedUrl> urls;

    private List<SpecifiedDate> dates;

    @ForeignKey(stubbedRelationship = true)
    private Image image;

    @ForeignKey(stubbedRelationship = true)
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
