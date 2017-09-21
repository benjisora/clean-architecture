package amiltone.bsaugues.td_niveau1.presentation;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import amiltone.bsaugues.td_niveau1.R;
import amiltone.bsaugues.td_niveau1.data.model.Comic;
import amiltone.bsaugues.td_niveau1.presentation.viewmodel.ComicViewModel;
import butterknife.BindView;
import butterknife.ButterKnife;


public class ComicRecyclerViewAdapter extends RecyclerView.Adapter<ComicRecyclerViewAdapter.ViewHolder> {

    private final List<ComicViewModel> mValues;
    private final ComicListFragment.OnListFragmentInteractionListener mListener;
    private final Context mContext;

    public ComicRecyclerViewAdapter(Context context, List<ComicViewModel> items, ComicListFragment.OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
        mContext = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_comic_list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);

        holder.mTitle.setText(holder.mItem.getComicTitle());
        holder.mDate.setText(holder.mItem.getComicDate());

        Picasso.with(mContext).load(holder.mItem.getComicImageUrl()).fit().centerCrop().into(holder.mThumbnail);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mListener != null) {
                    mListener.onComicSelected(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;

        @BindView(R.id.comic_row_title)
        public TextView mTitle;

        @BindView(R.id.comic_row_date)
        public TextView mDate;

        @BindView(R.id.comic_row_thumbnail)
        public ImageView mThumbnail;

        public ComicViewModel mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            ButterKnife.bind(this, mView);
        }
    }
}
