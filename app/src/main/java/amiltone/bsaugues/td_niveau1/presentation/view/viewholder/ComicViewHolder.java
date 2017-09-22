package amiltone.bsaugues.td_niveau1.presentation.view.viewholder;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import amiltone.bsaugues.td_niveau1.R;
import amiltone.bsaugues.td_niveau1.presentation.view.viewmodel.ComicViewModel;
import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by amiltonedev_dt013 on 21/09/2017.
 */

public class ComicViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.comic_row_title)
    public TextView mTitle;

    @BindView(R.id.comic_row_date)
    public TextView mDate;

    @BindView(R.id.comic_row_thumbnail)
    public ImageView mThumbnail;

    private Context context;

    private final View mView;

    public interface OnComicClickedListener {
        void onComicSelected(int position);
    }

    public ComicViewHolder(View view, Context context) {
        super(view);
        mView = view;
        this.context = context;
        ButterKnife.bind(this, mView);
    }

    public void bind(ComicViewModel comicViewModel){

        mTitle.setText(comicViewModel.getComicTitle());
        mDate.setText(comicViewModel.getComicDate());

        Picasso.with(context).load(comicViewModel.getComicImageUrl()).fit().centerCrop().into(mThumbnail);

    }

    public void bind(final OnComicClickedListener onComicClickedListener){

        mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onComicClickedListener != null) {
                    onComicClickedListener.onComicSelected(getAdapterPosition());
                }
            }
        });
    }


}