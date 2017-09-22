package amiltone.bsaugues.td_niveau1.data.manager.database;

import com.raizlabs.android.dbflow.annotation.Database;
import com.raizlabs.android.dbflow.config.DatabaseDefinition;
import com.raizlabs.android.dbflow.config.FlowManager;

import java.util.ArrayList;
import java.util.List;

import amiltone.bsaugues.td_niveau1.TdApplication;
import amiltone.bsaugues.td_niveau1.data.exception.ComicNotFoundException;
import amiltone.bsaugues.td_niveau1.data.model.Comic;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */
@Database(name = DatabaseManager.NAME, version = DatabaseManager.VERSION)
public class DatabaseManagerImpl implements DatabaseManager {

    private DatabaseDefinition database;

    private List<Comic> comicList;

    public DatabaseManagerImpl(TdApplication applicationContext) {
        comicList = new ArrayList<>();
        FlowManager.init(applicationContext);
        database = FlowManager.getDatabase(DatabaseManagerImpl.class);
    }

    @Override
    public Comic getComicById(int id) {

        for(Comic comic : comicList){
            if(comic.getId() == id){
                return comic;
            }
        }
        throw new ComicNotFoundException();
    }

    @Override
    public void saveComicList(List<Comic> comics) {
        comicList.clear();
        comicList.addAll(comics);
    }

    @Override
    public List<Comic> getDatabaseList() {
        if(isDatabaseEmpty()){
            throw null;
        } else {
            return comicList;
        }

    }

    @Override
    public boolean isDatabaseEmpty() {
        return comicList == null || comicList.isEmpty();
    }


}
