package com.baquiax.marvelsuperheroes.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import com.baquiax.marvelsuperheroes.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.OnTextChanged;

public class SearchFragment extends Fragment {
    @Bind(R.id.searchText)
    EditText searchText;
    private OnSearchListener mListener;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.fragment_search, container, false);
        ButterKnife.bind(this, inflatedView);
        return inflatedView;
    }

    @OnClick(R.id.searchButton)
    public void onSearch(Button b) {
        if (mListener != null && this.searchText.length() > 0) {
            mListener.onSearchCharacters(searchText.toString());
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnSearchListener) {
            mListener = (OnSearchListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnSearchListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
