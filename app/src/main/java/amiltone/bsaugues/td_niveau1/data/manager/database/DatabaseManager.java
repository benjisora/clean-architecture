package amiltone.bsaugues.td_niveau1.data.manager.database;

import java.util.List;

import amiltone.bsaugues.td_niveau1.data.exception.NoComicInCacheException;
import amiltone.bsaugues.td_niveau1.data.model.Comic;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public interface DatabaseManager {

    String NAME = "AppDatabase";

    int VERSION = 1;

    Comic getComicById(int id);

    void saveComicList(List<Comic> comics);

    List<Comic> getDatabaseList() throws NoComicInCacheException;

    boolean isDatabaseEmpty();
}