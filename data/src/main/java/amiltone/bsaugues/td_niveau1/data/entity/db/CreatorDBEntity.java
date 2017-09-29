package amiltone.bsaugues.td_niveau1.data.entity.db;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.io.Serializable;

import amiltone.bsaugues.td_niveau1.data.module.db.ModuleDBFlowImpl;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */
@Table(database = ModuleDBFlowImpl.class)
public class CreatorDBEntity extends BaseModel implements Serializable {

    @PrimaryKey
    private int comicId;

    @PrimaryKey
    private String name;

    @PrimaryKey
    private String role;

    @Column
    private String resourceURI;

    public int getComicId() {
        return comicId;
    }

    public void setComicId(int comicId) {
        this.comicId = comicId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }


    @Override
    public String toString() {
        return "CreatorDBEntity{" +
                "comicId=" + comicId +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", resourceURI='" + resourceURI + '\'' +
                '}';
    }
}
