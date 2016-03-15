package com.baquiax.marvelsuperheroes.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.baquiax.marvelsuperheroes.R;
import com.baquiax.marvelsuperheroes.adapters.OnCharacterClickListener;
import com.baquiax.marvelsuperheroes.adapters.ResultSearchAdapter;
import com.baquiax.marvelsuperheroes.models.Character;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ResultSearchFragment extends Fragment implements OnCharacterClickListener {
    @Bind(R.id.resultList)
    RecyclerView resultList;
    @Bind(R.id.nameToSearch)
    TextView nameToSearch;

    private OnSelectCharacterListener mListener;
    private ResultSearchAdapter adapter;

    public ResultSearchFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public void initAdapter() {
        if (this.adapter == null) {
            this.adapter = new ResultSearchAdapter(getActivity().getApplicationContext());
            this.adapter.setOnItemClickListener(this);
        }
    }

    public void initRecyclerView() {
        this.resultList.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.resultList.setAdapter(this.adapter);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View inflatedView = inflater.inflate(R.layout.fragment_result_search, container, false);
        ButterKnife.bind(this, inflatedView);
        initAdapter();
        initRecyclerView();
        return inflatedView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnSelectCharacterListener) {
            mListener = (OnSelectCharacterListener) context;
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

    public void searchCharactersByName(String name) {
        Log.d(getClass().toString(), name);
        String formatString = getString(R.string.result_search);
        this.nameToSearch.setText(String.format(formatString, this.adapter.getItemCount()));
        this.adapter.searchCharacters(name);
    }

    @Override
    public void onItemClick(Character character) {
        Log.d(getClass().toString(), String.valueOf(character.getId()));
        if (this.mListener != null) {
            this.mListener.onSelectCharacter(character);
        }
    }
}
