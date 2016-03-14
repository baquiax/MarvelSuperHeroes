package com.baquiax.marvelsuperheroes;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.baquiax.marvelsuperheroes.fragments.OnSearchListener;
import com.baquiax.marvelsuperheroes.fragments.ResultSearchFragment;
import com.baquiax.marvelsuperheroes.fragments.OnSelectCharacterListener;
import com.baquiax.marvelsuperheroes.models.Character;

public class MainActivity extends AppCompatActivity implements OnSearchListener, OnSelectCharacterListener {
    ResultSearchFragment searchFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle(R.string.app_name);
        setContentView(R.layout.activity_main);
        this.searchFragment = (ResultSearchFragment) this.getSupportFragmentManager().findFragmentById(R.id.resultSearchContainer);
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

    }
}
