package amiltone.bsaugues.td_niveau1.data.entity.db;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.io.Serializable;

import amiltone.bsaugues.td_niveau1.data.manager.database.DatabaseManagerImpl;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */
@Table(database = DatabaseManagerImpl.class)
public class SpecifiedUrlDBEntity extends BaseModel implements Serializable {

    @Column
    private int comicId;

    @PrimaryKey
    private String type;

    @PrimaryKey
    private String url;

    public int getComicId() {
        return comicId;
    }

    public void setComicId(int comicId) {
        comicId = comicId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

}
