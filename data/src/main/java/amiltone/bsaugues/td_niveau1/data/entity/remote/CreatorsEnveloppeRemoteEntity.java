package amiltone.bsaugues.td_niveau1.data.entity.remote;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by amiltonedev_dt013 on 21/09/2017.
 */

public class CreatorsEnveloppeRemoteEntity implements Serializable {

    @SerializedName("items")
    private List<CreatorRemoteEntity> creators;

    public List<CreatorRemoteEntity> getCreators() {
        return creators;
    }

    public void setCreators(List<CreatorRemoteEntity> creators) {
        this.creators = creators;
    }

}
