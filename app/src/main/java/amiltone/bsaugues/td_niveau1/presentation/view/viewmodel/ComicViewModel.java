package amiltone.bsaugues.td_niveau1.presentation.view.viewmodel;

import java.util.List;

import amiltone.bsaugues.td_niveau1.data.model.Comic;
import amiltone.bsaugues.td_niveau1.data.model.Creator;
import amiltone.bsaugues.td_niveau1.data.model.SpecifiedDate;
import amiltone.bsaugues.td_niveau1.data.model.SpecifiedUrl;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public class ComicViewModel {

    private Comic comic;

    public ComicViewModel(Comic comic){
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

    public Comic getComic() {
        return this.comic;
    }

    public String getDetailsUrl(){
        for(SpecifiedUrl url : this.comic.getUrls()){
            if(url.getType().equals("detail"))
                return url.getUrl();
        }
        return null;
    }

    public String getOnSaleDate(){
        for(SpecifiedDate date : this.comic.getDates()){
            if(date.getType().equals("onsaleDate"))
                return date.getDate();
        }
        return null;
    }

    public List<Creator> getCreators(){
        return this.comic.getCreators().getCreators();
    }

    private String getThumbnailUrl(){
        return this.comic.getImage().getPath() + "." + this.comic.getImage().getExtension();
    }

}
