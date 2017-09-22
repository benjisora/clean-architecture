package amiltone.bsaugues.td_niveau1.data.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by amiltonedev_dt013 on 21/09/2017.
 */

public class CreatorsEnveloppeEntity implements Serializable {

    @SerializedName("items")
    private List<CreatorEntity> creators;

    public List<CreatorEntity> getCreators() {
        return creators;
    }

    public void setCreators(List<CreatorEntity> creators) {
        this.creators = creators;
    }

}
