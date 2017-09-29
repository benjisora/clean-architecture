package amiltone.bsaugues.td_niveau1.data.module.db;

import java.util.List;

import amiltone.bsaugues.td_niveau1.data.entity.db.ComicDBEntity;

/**
 * Created by amiltonedev_dt013 on 29/09/2017.
 */

public interface ModuleDB {

    String DB_NAME = "AppDatabase";

    int DB_VERSION = 1;

    ComicDBEntity getComicsById(int id);

    void insertComicsList(List<ComicDBEntity> comicsList);
    void insertComics(ComicDBEntity comics);

    List<ComicDBEntity> getComicsList();

    boolean isDatabaseEmpty();

    void clearComicsTable();
}
