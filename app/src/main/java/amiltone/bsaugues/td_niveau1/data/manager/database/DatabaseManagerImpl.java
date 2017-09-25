package amiltone.bsaugues.td_niveau1.data.manager.database;

import com.raizlabs.android.dbflow.annotation.Database;
import com.raizlabs.android.dbflow.sql.language.Method;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.List;

import amiltone.bsaugues.td_niveau1.data.entity.db.ComicDBEntity;
import amiltone.bsaugues.td_niveau1.data.entity.db.ComicDBEntity_Table;
import amiltone.bsaugues.td_niveau1.data.exception.NoComicInDatabaseException;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */
@Database(name = DatabaseManager.NAME, version = DatabaseManager.VERSION)
public class DatabaseManagerImpl implements DatabaseManager {

    public DatabaseManagerImpl() {
    }

    @Override
    public ComicDBEntity getComicById(int id) {

        return SQLite.select()
                .from(ComicDBEntity.class)
                .where(ComicDBEntity_Table.id.eq(id))
                .querySingle();

    }

    @Override
    public void saveComicList(List<ComicDBEntity> comics) {

        for (ComicDBEntity comic : comics) {
            comic.save();
        }

    }

    @Override
    public List<ComicDBEntity> getDatabaseList() {
        if (isDatabaseEmpty()) {
            throw new NoComicInDatabaseException();
        } else {
            List<ComicDBEntity> comics = SQLite.select()
                    .from(ComicDBEntity.class)
                    .queryList();

            return comics;
        }
    }

    @Override
    public boolean isDatabaseEmpty() {
        return new Select(Method.count()).from(ComicDBEntity.class).count() == 0;
    }


}
