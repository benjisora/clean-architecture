package amiltone.bsaugues.td_niveau1.presentation.viewcontroler;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import amiltone.bsaugues.td_niveau1.R;
import amiltone.bsaugues.td_niveau1.data.model.Comic;
import amiltone.bsaugues.td_niveau1.presentation.ComicListView;
import amiltone.bsaugues.td_niveau1.presentation.FragmentPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class ComicListFragment extends Fragment implements ComicListView {

    @BindView(R.id.recycler_view)
    public RecyclerView recyclerView;

    private FragmentPresenter fragmentPresenter;
    private ComicRecyclerViewAdapter adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentPresenter = new FragmentPresenter();
        fragmentPresenter.setComicListView(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comic_list, container, false);
        ButterKnife.bind(this, view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fragmentPresenter.retrieveData();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    @Override
    public void displayComics(List<Comic> comicList) {



        recyclerView.setAdapter(new ComicRecyclerViewAdapter(getContext(), comicList, new OnListFragmentInteractionListener() {
            @Override
            public void onComicSelected(Comic comic) {
                fragmentPresenter.loadDetails(comic);
            }
        }));

    }

    interface OnListFragmentInteractionListener {
        void onComicSelected(Comic comic);
    }

}
