package amiltone.bsaugues.td_niveau1.data.manager.database.entity;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;

import java.io.Serializable;

import amiltone.bsaugues.td_niveau1.data.manager.database.DatabaseManagerImpl;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */
@Table(database = DatabaseManagerImpl.class)
public class SpecifiedDate implements Serializable {

    @PrimaryKey(autoincrement = true)
    private int id;

    @Column
    private String type;

    @Column
    private String date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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
