package amiltone.bsaugues.td_niveau1.data.manager.database;

import com.raizlabs.android.dbflow.annotation.Database;
import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.Method;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.Select;
import com.raizlabs.android.dbflow.structure.database.DatabaseWrapper;
import com.raizlabs.android.dbflow.structure.database.transaction.ITransaction;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Singleton;

import amiltone.bsaugues.td_niveau1.data.entity.db.ComicDBEntity;
import amiltone.bsaugues.td_niveau1.data.entity.db.ComicDBEntity_Table;
import amiltone.bsaugues.td_niveau1.data.exception.ComicNotFoundException;
import amiltone.bsaugues.td_niveau1.data.exception.NoComicInDatabaseException;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */
@Singleton
@Database(name = DatabaseManager.NAME, version = DatabaseManager.VERSION)
public class DatabaseManagerImpl implements DatabaseManager {

    @Inject
    public DatabaseManagerImpl() {
    }

    @Override
    public ComicDBEntity getComicById(int id) {

        ComicDBEntity comicDBEntity = SQLite.select()
                .from(ComicDBEntity.class)
                .where(ComicDBEntity_Table.id.eq(id))
                .querySingle();

        if (comicDBEntity == null) {
            throw new ComicNotFoundException();
        } else {
            return comicDBEntity;
        }


    }

    @Override
    public void saveComicList(final List<ComicDBEntity> comics) {

        FlowManager.getDatabase(DatabaseManagerImpl.class).executeTransaction(new ITransaction() {
            @Override
            public void execute(DatabaseWrapper databaseWrapper) {
                // something here
                for (ComicDBEntity comic : comics) {
                    comic.save();
                }
            }
        });
    }

    @Override
    public List<ComicDBEntity> getDatabaseList() {

        List<ComicDBEntity> comics = SQLite.select()
                .from(ComicDBEntity.class)
                .queryList();

        if (comics.isEmpty()) {
            throw new NoComicInDatabaseException();
        } else {
            return comics;
        }

    }

    @Override
    public boolean isDatabaseEmpty() {
        return new Select(Method.count()).from(ComicDBEntity.class).count() == 0;
    }


}
