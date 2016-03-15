package com.baquiax.marvelsuperheroes.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.baquiax.marvelsuperheroes.R;
import com.baquiax.marvelsuperheroes.models.Character;
import com.bumptech.glide.Glide;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CharacterDetailFragment extends Fragment {
    @Bind(R.id.characterName)
    TextView characterName;
    @Bind(R.id.characterImage)
    ImageView characterImage;

    public CharacterDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View inflatedView = inflater.inflate(R.layout.fragment_character_detail, container, false);
        ButterKnife.bind(this, inflatedView);

        return inflatedView;
    }

    public void updateData(Character c) {
        this.characterName.setText(c.getName());
        Glide.with(this).load(c.getImageUrl()).into(this.characterImage);
    }
}
