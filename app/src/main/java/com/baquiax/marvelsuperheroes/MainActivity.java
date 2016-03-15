package com.baquiax.marvelsuperheroes;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.baquiax.marvelsuperheroes.activities.CharacterDetailActivity;
import com.baquiax.marvelsuperheroes.fragments.CharacterDetailFragment;
import com.baquiax.marvelsuperheroes.fragments.OnSearchListener;
import com.baquiax.marvelsuperheroes.fragments.ResultSearchFragment;
import com.baquiax.marvelsuperheroes.fragments.OnSelectCharacterListener;
import com.baquiax.marvelsuperheroes.models.Character;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements OnSearchListener, OnSelectCharacterListener {
    ResultSearchFragment searchFragment;
    CharacterDetailFragment detailFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle(R.string.app_name);
        setContentView(R.layout.activity_main);
        this.searchFragment = (ResultSearchFragment) this.getSupportFragmentManager().findFragmentById(R.id.resultSearchContainer);
        this.detailFragment = (CharacterDetailFragment) this.getSupportFragmentManager().findFragmentById(R.id.characterDetail);
    }

    @Override
    public void onSearchCharacters(String character) {
        Log.d(this.getLocalClassName(), "Search: " + character);
        if (this.searchFragment != null)  {
            this.searchFragment.searchCharactersByName(character);
        }
    }

    @Override
    public void onSelectCharacter(Character c) {
        if (this.detailFragment!= null && this.detailFragment.isVisible()) {
            this.detailFragment.updateData(c);
        } else {
            Intent detailIntent = new Intent(this, CharacterDetailActivity.class);
            detailIntent.putExtra(CharacterDetailActivity.NAME, c.getName());
            detailIntent.putExtra(CharacterDetailActivity.IMAGE_URL, c.getThumbnail());
            startActivity(detailIntent);
        }
    }

}
