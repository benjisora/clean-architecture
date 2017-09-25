package amiltone.bsaugues.td_niveau1.data.entity.db;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.OneToMany;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.io.Serializable;
import java.util.List;

import amiltone.bsaugues.td_niveau1.data.manager.database.DatabaseManagerImpl;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */
@Table(database = DatabaseManagerImpl.class)
public class ComicDBEntity extends BaseModel {

    @PrimaryKey
    private int id;

    @Column
    private String title;

    @Column
    private String diamondCode;

    private List<SpecifiedUrlDBEntity> urls;

    private List<SpecifiedDateDBEntity> dates;

    @ForeignKey(stubbedRelationship = true)
    private ImageDBEntity image;

    private List<CreatorDBEntity> creators;

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

    public List<SpecifiedUrlDBEntity> getUrls() {
        return urls;
    }

    public void setUrls(List<SpecifiedUrlDBEntity> urls) {
        this.urls = urls;
    }

    public List<SpecifiedDateDBEntity> getDates() {
        return dates;
    }

    public void setDates(List<SpecifiedDateDBEntity> dates) {
        this.dates = dates;
    }

    public ImageDBEntity getImage() {
        return image;
    }

    public void setImage(ImageDBEntity image) {
        this.image = image;
    }

    public List<CreatorDBEntity> getCreators() {
        return creators;
    }

    public void setCreators(List<CreatorDBEntity> creators) {
        this.creators = creators;
    }

    //endregion

    @OneToMany(methods = {OneToMany.Method.ALL}, variableName = "urls")
    public List<SpecifiedUrlDBEntity> getMyUrls() {
        if (urls == null || urls.isEmpty()) {
            urls = SQLite.select()
                    .from(SpecifiedUrlDBEntity.class)
                    .where(SpecifiedUrlDBEntity_Table.comicId.eq(id))
                    .queryList();
        }
        return urls;
    }

    @OneToMany(methods = {OneToMany.Method.ALL}, variableName = "dates")
    public List<SpecifiedDateDBEntity> getMyDates() {
        if (dates == null || dates.isEmpty()) {
            dates = SQLite.select()
                    .from(SpecifiedDateDBEntity.class)
                    .where(SpecifiedDateDBEntity_Table.comicId.eq(id))
                    .queryList();
        }
        return dates;
    }

    @OneToMany(methods = {OneToMany.Method.ALL}, variableName = "creators")
    public List<SpecifiedUrlDBEntity> getMyCreators() {
        if (creators == null || creators.isEmpty()) {
            creators = SQLite.select()
                    .from(CreatorDBEntity.class)
                    .where(CreatorDBEntity_Table.comicId.eq(id))
                    .queryList();
        }
        return urls;
    }
}
