package amiltone.bsaugues.td_niveau1.data.entity;

import java.io.Serializable;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public class SpecifiedDateEntity implements Serializable {

    private String type;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
