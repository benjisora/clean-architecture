package amiltone.bsaugues.td_niveau1.presentation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;

import amiltone.bsaugues.td_niveau1.R;
import amiltone.bsaugues.td_niveau1.presentation.di.PerActivity;
import amiltone.bsaugues.td_niveau1.presentation.view.viewholder.ComicViewHolder;
import amiltone.bsaugues.td_niveau1.presentation.view.viewmodel.ComicViewModel;


@PerActivity
public class ComicRecyclerViewAdapter extends RecyclerView.Adapter<ComicViewHolder> {

    private List<ComicViewModel> mValues;
    private ComicViewHolder.OnComicClickedListener onComicClickedListener;
    private final Context mContext;

    @Inject
    public ComicRecyclerViewAdapter(Context context) {
        mContext = context;
        mValues = new ArrayList<>();
    }

    public void setOnComicClickedListener(ComicViewHolder.OnComicClickedListener onComicClickedListener) {
        this.onComicClickedListener = onComicClickedListener;
    }

    public void setItems(List<ComicViewModel> comicViewModels){
        mValues.clear();
        mValues.addAll(comicViewModels);
        Collections.sort(mValues);
        notifyDataSetChanged();
    }

    public ComicViewModel getItem(int position){
        return mValues.get(position);
    }

    @Override
    public ComicViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_comic_list_item, parent, false);
        return new ComicViewHolder(view, mContext);
    }

    @Override
    public void onBindViewHolder(final ComicViewHolder holder, int position) {
        holder.bindContent(mValues.get(position));

        if(onComicClickedListener != null){
            holder.bindListener(onComicClickedListener);
        }
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }


}
