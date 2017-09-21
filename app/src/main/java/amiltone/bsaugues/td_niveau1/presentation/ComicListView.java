package amiltone.bsaugues.td_niveau1.presentation;

import java.util.List;

import amiltone.bsaugues.td_niveau1.data.model.Comic;
import amiltone.bsaugues.td_niveau1.presentation.viewmodel.ComicViewModel;

/**
 * Created by amiltonedev_dt013 on 20/09/2017.
 */

public interface ComicListView {

    void displayComics(List<ComicViewModel> comicList);

}
