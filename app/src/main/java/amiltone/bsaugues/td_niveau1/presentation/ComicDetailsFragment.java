package amiltone.bsaugues.td_niveau1.presentation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import amiltone.bsaugues.td_niveau1.R;
import amiltone.bsaugues.td_niveau1.data.model.Comic;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ComicDetailsFragment extends Fragment implements ComicDetailView {

    @BindView(R.id.comic_detail_title)
    public TextView title;

    @BindView(R.id.comic_detail_date)
    public TextView date;

    @BindView(R.id.comic_detail_thumbnail)
    public ImageView thumbnail;

    @BindView(R.id.comic_detail_creators_wrapper)
    public LinearLayout creatorsWrapper;

    @BindView(R.id.comic_detail_diamond_code)
    public TextView diamondCode;

    private Comic comic;
    private ComicFragmentPresenter fragmentPresenter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentPresenter = new ComicFragmentPresenter();
        fragmentPresenter.setComicDetailView(this);
        if(comic==null)
            comic = (Comic) getArguments().getSerializable("comic");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comic_details, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentPresenter.displayComicDetails(comic);
    }

    @Override
    public void displayComicDetails(Comic comic) {
        title.setText(comic.getTitle());
        date.setText(comic.getOnSaleDate());
        Picasso.with(getActivity()).load(comic.getImage().getUrl()).fit().centerInside().into(thumbnail);

        diamondCode.setText(comic.getDiamondCode());

        /*
        for (Creator creator : comic.getCreators()) {
            //TODO: autogenerate layout for each creator
        }
        */
    }
}
