package amiltone.bsaugues.td_niveau1.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by amiltonedev_dt013 on 21/09/2017.
 */

public class CreatorsEnveloppe implements Serializable {

    @SerializedName("items")
    private List<Creator> creators;

    public List<Creator> getCreators() {
        return creators;
    }

    public void setCreators(List<Creator> creators) {
        this.creators = creators;
    }

}
