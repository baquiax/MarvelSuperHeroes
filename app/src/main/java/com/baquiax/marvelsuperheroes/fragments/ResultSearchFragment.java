package com.baquiax.marvelsuperheroes.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baquiax.marvelsuperheroes.R;

public class ResultSearchFragment extends Fragment {
    private static final String ARG_PARAM1 = "characterName";
    private String characterName;

    private OnSlectedCharacterListener mListener;

    public ResultSearchFragment() {
        // Required empty public constructor
    }

    public static ResultSearchFragment newInstance(String characterName) {
        ResultSearchFragment fragment = new ResultSearchFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, characterName);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            characterName = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result_search, container, false);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnSlectedCharacterListener) {
            mListener = (OnSlectedCharacterListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnSlectedCharacterListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnSlectedCharacterListener {
        void onSelectCharacter(String character);
    }
}
