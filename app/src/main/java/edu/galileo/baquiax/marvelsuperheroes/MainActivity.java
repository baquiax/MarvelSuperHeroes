package edu.galileo.baquiax.marvelsuperheroes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnEditorAction;
import butterknife.OnItemClick;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class MainActivity extends AppCompatActivity implements View.OnKeyListener{
    private static final String BASE_URL = "http://gateway.marvel.com";
    private static final String API_KEY= "1c81b0b4fb5e156d15bbe829e1a49279";
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    @Bind(R.id.characterName) EditText characterName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        characterName.setOnKeyListener(this);
    }

    public String joinHashMapAsParams(HashMap<String, String> params) {
        String joinedString = "";
        for (Entry<String, String> e : params.entrySet()) {
            joinedString += e.getKey()+"="+e.getValue() + "&";

        }
        return joinedString;
    }

    public void poblateCharacterList() {
        HashMap<String, String> parameters = new HashMap<String, String>();
        parameters.put("apikey", MainActivity.API_KEY);
        parameters.put("nameStartsWith", characterName.getText().toString());
        String charactersUrl = this.joinHashMapAsParams(parameters);
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_ENTER) {
            System.out.println("Code > " + keyCode);
        }
        return false;
    }
}
