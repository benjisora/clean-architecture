package amiltone.bsaugues.td_niveau1.data.entity;

import java.io.Serializable;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public class CreatorEntity implements Serializable{

    private String name;
    private String role;

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

    @Override
    public String toString() {
        return "CreatorRemoteEntity{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                '}';
    }
}
