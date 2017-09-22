package amiltone.bsaugues.td_niveau1.presentation.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import amiltone.bsaugues.td_niveau1.R;
import amiltone.bsaugues.td_niveau1.presentation.view.viewholder.ComicViewHolder;
import amiltone.bsaugues.td_niveau1.presentation.view.viewmodel.ComicViewModel;


public class ComicRecyclerViewAdapter extends RecyclerView.Adapter<ComicViewHolder> {

    private List<ComicViewModel> mValues;
    private final ComicViewHolder.OnComicClickedListener onComicClickedListener;
    private final Context mContext;

    public ComicRecyclerViewAdapter(Context context, ComicViewHolder.OnComicClickedListener listener) {
        onComicClickedListener = listener;
        mContext = context;
        mValues = new ArrayList<>();
    }

    public void setItems(List<ComicViewModel> comicViewModels){
        mValues.clear();
        mValues.addAll(comicViewModels);
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
        holder.bind(mValues.get(position));
        holder.bind(onComicClickedListener);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }


}
