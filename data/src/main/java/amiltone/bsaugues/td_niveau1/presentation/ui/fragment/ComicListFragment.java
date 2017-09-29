package amiltone.bsaugues.td_niveau1.presentation.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import javax.inject.Inject;

import amiltone.bsaugues.td_niveau1.R;
import amiltone.bsaugues.td_niveau1.presentation.di.PerActivity;
import amiltone.bsaugues.td_niveau1.presentation.presenter.ComicListFragmentPresenter;
import amiltone.bsaugues.td_niveau1.presentation.ui.activity.ComicListActivity;
import amiltone.bsaugues.td_niveau1.presentation.ui.adapter.ComicRecyclerViewAdapter;
import amiltone.bsaugues.td_niveau1.presentation.ui.view.viewholder.ComicViewHolder;
import amiltone.bsaugues.td_niveau1.presentation.ui.view.viewinterface.ComicListView;
import amiltone.bsaugues.td_niveau1.presentation.ui.view.viewmodel.ComicViewModel;
import butterknife.BindView;
import butterknife.ButterKnife;

@PerActivity
public class ComicListFragment extends Fragment implements ComicListView, ComicViewHolder.OnComicClickedListener {

    @BindView(R.id.recycler_view)
    public RecyclerView recyclerView;

    @Inject
    ComicListFragmentPresenter comicListFragmentPresenter;

    @Inject
    ComicRecyclerViewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comic_list, container, false);
        ButterKnife.bind(this, view);

        ((ComicListActivity) getActivity()).getActivityComponent().inject(this);
        comicListFragmentPresenter.setComicListView(this);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter.setOnComicClickedListener(this);
        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        comicListFragmentPresenter.retrieveData();
    }

    @Override
    public void onComicSelected(int position) {
        comicListFragmentPresenter.loadDetails(adapter.getItem(position).getComic().getId());
    }

    @Override
    public void displayComics(List<ComicViewModel> comicList) {
        adapter.setItems(comicList);
    }

    public static ComicListFragment newInstance() {

        Bundle args = new Bundle();

        ComicListFragment fragment = new ComicListFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
