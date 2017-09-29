package amiltone.bsaugues.td_niveau1.data.entity.db;

import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.io.Serializable;

import amiltone.bsaugues.td_niveau1.data.module.db.ModuleDBFlowImpl;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */
@Table(database = ModuleDBFlowImpl.class)
public class ImageDBEntity extends BaseModel implements Serializable {

    @PrimaryKey
    private String path;

    @PrimaryKey
    private String extension;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getExtension() {
        return extension;
    }

    public void setExtension(String extension) {
        this.extension = extension;
    }

    @Override
    public String toString() {
        return "ImageDBEntity{" +
                "path='" + path + '\'' +
                ", extension='" + extension + '\'' +
                '}';
    }
}
