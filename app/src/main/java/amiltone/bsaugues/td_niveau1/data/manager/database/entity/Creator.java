package amiltone.bsaugues.td_niveau1.data.manager.database.entity;

import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;

import java.io.Serializable;

import amiltone.bsaugues.td_niveau1.data.manager.database.DatabaseManagerImpl;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */
@Table(database = DatabaseManagerImpl.class)
public class Creator implements Serializable {

    private String name;

    private String role;

    @PrimaryKey
    private String resourceURI;

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
        return "Creator{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", resourceURI='" + resourceURI + '\'' +
                '}';
    }
}
