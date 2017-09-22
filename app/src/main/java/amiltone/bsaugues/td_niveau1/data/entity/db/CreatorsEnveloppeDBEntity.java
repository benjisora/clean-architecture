package amiltone.bsaugues.td_niveau1.data.entity.db;

import com.google.gson.annotations.SerializedName;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.OneToMany;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.io.Serializable;
import java.util.List;

import amiltone.bsaugues.td_niveau1.data.manager.database.DatabaseManagerImpl;

/**
 * Created by amiltonedev_dt013 on 21/09/2017.
 */
@Table(database = DatabaseManagerImpl.class)
public class CreatorsEnveloppeDBEntity extends BaseModel implements Serializable {

    @PrimaryKey
    private int id;

    @Column
    private int comicId;

    @SerializedName("items")
    private List<CreatorDBEntity> creators;

    public List<CreatorDBEntity> getCreators() {
        return creators;
    }

    public void setCreators(List<CreatorDBEntity> creators) {
        this.creators = creators;
    }

    public int getComicId() {
        return comicId;
    }

    public void setComicId(int comicId) {
        this.comicId = comicId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToMany(methods = {OneToMany.Method.ALL}, variableName = "creators")
    public List<CreatorDBEntity> getMyCreators() {
        if (creators == null || creators.isEmpty()) {
            creators = SQLite.select()
                    .from(CreatorDBEntity.class)
                    .where(CreatorDBEntity_Table.enveloppeId.eq(id))
                    .queryList();
        }
        return creators;
    }

}
