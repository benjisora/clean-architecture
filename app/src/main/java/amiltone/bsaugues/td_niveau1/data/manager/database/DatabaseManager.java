package amiltone.bsaugues.td_niveau1.data.manager.database;

import java.util.List;

import amiltone.bsaugues.td_niveau1.data.entity.db.ComicDBEntity;
import amiltone.bsaugues.td_niveau1.data.exception.NoComicInCacheException;
import amiltone.bsaugues.td_niveau1.data.entity.ComicEntity;
import amiltone.bsaugues.td_niveau1.data.exception.NoComicInDatabaseException;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public interface DatabaseManager {

    String NAME = "AppDatabase";

    int VERSION = 1;

    ComicDBEntity getComicById(int id);

    void saveComicList(List<ComicDBEntity> comics);

    List<ComicDBEntity> getDatabaseList() throws NoComicInDatabaseException;

    boolean isDatabaseEmpty();
}