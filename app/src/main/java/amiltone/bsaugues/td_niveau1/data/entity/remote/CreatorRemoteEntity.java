package amiltone.bsaugues.td_niveau1.data.entity.remote;

import java.io.Serializable;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public class CreatorRemoteEntity implements Serializable{

    private String name;
    private String role;
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
        return "CreatorRemoteEntity{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
