package amiltone.bsaugues.td_niveau1.data.module.db;

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
import amiltone.bsaugues.td_niveau1.data.entity.db.CreatorDBEntity;
import amiltone.bsaugues.td_niveau1.data.entity.db.ImageDBEntity;
import amiltone.bsaugues.td_niveau1.data.entity.db.SpecifiedDateDBEntity;
import amiltone.bsaugues.td_niveau1.data.entity.db.SpecifiedUrlDBEntity;

/**
 * Created by amiltonedev_dt013 on 29/09/2017.
 */
@Database(name = ModuleDB.DB_NAME, version = ModuleDB.DB_VERSION)
@Singleton
public class ModuleDBFlowImpl implements ModuleDB {

    @Inject
    public ModuleDBFlowImpl() {
    }


    @Override
    public void insertComicsList(final List<ComicDBEntity> comicsList) {

        FlowManager.getDatabase(this.getClass()).executeTransaction(new ITransaction() {
            @Override
            public void execute(DatabaseWrapper databaseWrapper) {
                // something here
                for (ComicDBEntity comic : comicsList) {
                    comic.save();
                }
            }
        });
    }

    @Override
    public void insertComics(ComicDBEntity comics) {
        comics.save();
    }

    @Override
    public List<ComicDBEntity> getComicsList() {

        return SQLite.select()
                .from(ComicDBEntity.class)
                .queryList();

    }

    @Override
    public ComicDBEntity getComicsById(int id) {
        return SQLite.select()
                .from(ComicDBEntity.class)
                .where(ComicDBEntity_Table.id.eq(id))
                .querySingle();
    }

    @Override
    public boolean isDatabaseEmpty() {
        return new Select(Method.count()).from(ComicDBEntity.class).count() == 0;
    }

    @Override
    public void clearComicsTable() {
        SQLite.delete().from(ComicDBEntity.class).execute();
        SQLite.delete().from(CreatorDBEntity.class).execute();
        SQLite.delete().from(ImageDBEntity.class).execute();
        SQLite.delete().from(SpecifiedDateDBEntity.class).execute();
        SQLite.delete().from(SpecifiedUrlDBEntity.class).execute();
    }
}
