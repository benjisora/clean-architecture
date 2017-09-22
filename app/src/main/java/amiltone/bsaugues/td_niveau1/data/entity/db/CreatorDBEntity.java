package amiltone.bsaugues.td_niveau1.data.entity.db;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.OneToMany;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.io.Serializable;

import amiltone.bsaugues.td_niveau1.data.manager.database.DatabaseManagerImpl;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */
@Table(database = DatabaseManagerImpl.class)
public class CreatorDBEntity extends BaseModel implements Serializable {

    @Column
    private int enveloppeId;

    @Column
    private String name;

    @Column
    private String role;

    @PrimaryKey
    private String resourceURI;

    public int getEnveloppeId() {
        return enveloppeId;
    }

    public void setEnveloppeId(int enveloppeId) {
        this.enveloppeId = enveloppeId;
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
        return "CreatorRemoteEntity{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", resourceURI='" + resourceURI + '\'' +
                '}';
    }

}
