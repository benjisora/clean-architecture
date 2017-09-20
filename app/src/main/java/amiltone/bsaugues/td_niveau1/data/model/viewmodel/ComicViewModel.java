package amiltone.bsaugues.td_niveau1.data.model.viewmodel;

import amiltone.bsaugues.td_niveau1.data.model.Comic;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public class ComicViewModel {

    private Comic comic;

    public String getComicTitle() {
        return this.comic.getTitle();
    }

    public String getComicDate() {
        return this.comic.getOnSaleDate().toString();
    }

    public String getComicImageUrl() {
        return this.comic.getCoverUrl().getUrl();
    }

    public Comic getComic() {
        return this.comic;
    }
}
