package amiltone.bsaugues.td_niveau1.data.entity;

import java.io.Serializable;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public class SpecifiedUrlEntity implements Serializable {

    private String type;
    private String url;

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
