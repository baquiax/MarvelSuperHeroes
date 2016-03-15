package com.baquiax.marvelsuperheroes.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.baquiax.marvelsuperheroes.R;
import com.baquiax.marvelsuperheroes.fragments.CharacterDetailFragment;
import com.baquiax.marvelsuperheroes.models.*;
import com.baquiax.marvelsuperheroes.models.Character;
import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CharacterDetailActivity extends AppCompatActivity {
    public final static String ID= "id";
    public final static String NAME = "characterName";
    public final static String IMAGE_URL = "imageUrl";

    private Character character;
    private CharacterDetailFragment detailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        int id = intent.getIntExtra(ID, 0);
        String characterName = intent.getStringExtra(NAME);
        String characterLogo = intent.getStringExtra(IMAGE_URL);
        this.character = new Character(id, characterName, characterLogo);
        this.detailFragment = (CharacterDetailFragment) this.getSupportFragmentManager().findFragmentById(R.id.characterDetail);
        if (this.detailFragment != null) {
            this.detailFragment.updateData(this.character);
        }
    }
}
