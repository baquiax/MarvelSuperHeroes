package com.baquiax.marvelsuperheroes;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.baquiax.marvelsuperheroes.fragments.ResultSearchFragment;
import com.baquiax.marvelsuperheroes.fragments.SearchFragment;

public class MainActivity extends AppCompatActivity implements SearchFragment.OnSearchListener, ResultSearchFragment.OnSlectedCharacterListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.setTitle(R.string.app_name);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onFoundCharacters(String character) {
        Log.d(this.getLocalClassName(), "Search: " + character);
    }

    @Override
    public void onSelectCharacter(String character) {

    }
}
