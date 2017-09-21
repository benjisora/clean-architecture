package amiltone.bsaugues.td_niveau1.presentation.viewcontroler;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import amiltone.bsaugues.td_niveau1.R;
import amiltone.bsaugues.td_niveau1.data.model.Comic;
import amiltone.bsaugues.td_niveau1.presentation.FragmentPresenter;
import butterknife.BindView;
import butterknife.ButterKnife;

public class DetailsFragment extends Fragment {

    private FragmentPresenter fragmentPresenter;

    private OnListFragmentInteractionListener mListener;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_comic_list, container, false);
        ButterKnife.bind(this, view);

        fragmentPresenter = new FragmentPresenter();

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnListFragmentInteractionListener {
        void onComicSelected(Comic comic);
    }
}
