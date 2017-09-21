package amiltone.bsaugues.td_niveau1.presentation.ui;

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
import amiltone.bsaugues.td_niveau1.presentation.presenter.ComicDetailFragmentPresenter;
import amiltone.bsaugues.td_niveau1.presentation.view.viewinterface.ComicDetailView;
import amiltone.bsaugues.td_niveau1.presentation.navigator.listener.NavigatorListener;
import amiltone.bsaugues.td_niveau1.presentation.view.viewmodel.ComicViewModel;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ComicDetailsFragment extends Fragment implements ComicDetailView {

    private static final String COMIC_KEY = "amiltone.bsaugues.td_niveau1.presentation.ui.ComicDetailsFragment.COMIC_KEY";

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

    private ComicDetailFragmentPresenter comicDetailFragmentPresenter;

    public static ComicDetailsFragment newInstance(int id) {

        Bundle args = new Bundle();

        ComicDetailsFragment fragment = new ComicDetailsFragment();
        args.putInt(COMIC_KEY, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        comicDetailFragmentPresenter = new ComicDetailFragmentPresenter((NavigatorListener) getActivity());
        comicDetailFragmentPresenter.setComicDetailView(this);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comic_details, container, false);
        ButterKnife.bind(this, view);

        //getArguments().getInt(COMIC_KEY);
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        comicDetailFragmentPresenter.displayComicDetails();
    }

    @Override
    public void displayComicDetails(ComicViewModel comicViewModel) {
        title.setText(comicViewModel.getComic().getTitle());
        date.setText(comicViewModel.getOnSaleDate());
        Picasso.with(getActivity()).load(comicViewModel.getComicImageUrl()).fit().centerInside().into(thumbnail);

        diamondCode.setText(comicViewModel.getComic().getDiamondCode());

        /*
        for (Creator creator : comic.getCreators()) {
            //TODO: autogenerate layout for each creator
        }
        */
    }
}
