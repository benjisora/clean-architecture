package amiltone.bsaugues.td_niveau1.presentation.view.viewmodel;

import android.support.annotation.NonNull;

import java.util.List;

import amiltone.bsaugues.td_niveau1.data.entity.ComicEntity;
import amiltone.bsaugues.td_niveau1.data.entity.CreatorEntity;
import amiltone.bsaugues.td_niveau1.data.entity.SpecifiedDateEntity;
import amiltone.bsaugues.td_niveau1.data.entity.SpecifiedUrlEntity;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public class ComicViewModel implements Comparable<ComicViewModel> {

    private ComicEntity comic;

    public ComicViewModel(ComicEntity comic) {
        this.comic = comic;
    }

    public String getComicTitle() {
        return this.comic.getTitle();
    }

    public String getComicDate() {
        return this.getOnSaleDate();
    }

    public String getComicImageUrl() {
        return this.getThumbnailUrl();
    }

    public ComicEntity getComic() {
        return this.comic;
    }

    public String getDetailsUrl() {
        for (SpecifiedUrlEntity url : this.comic.getUrls()) {
            if (url.getType().equals("detail"))
                return url.getUrl();
        }
        return null;
    }

    public String getOnSaleDate() {
        for (SpecifiedDateEntity date : this.comic.getDates()) {
            if (date.getType().equals("onsaleDate"))
                return date.getDate();
        }
        return null;
    }

    public List<CreatorEntity> getCreators() {
        return this.comic.getCreators().getCreators();
    }

    private String getThumbnailUrl() {
        return this.comic.getImage().getPath() + "." + this.comic.getImage().getExtension();
    }

    @Override
    public String toString() {
        return "ComicViewModel{" +
                "comic=" + comic +
                '}';
    }

    @Override
    public int compareTo(@NonNull ComicViewModel comicViewModel) {
        return this.getComic().getId() - comicViewModel.getComic().getId();
    }
}
