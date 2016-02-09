package edu.galileo.baquiax.marvelsuperheroes;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnEditorAction;
import butterknife.OnItemClick;

public class MainActivity extends AppCompatActivity implements View.OnKeyListener{
    @Bind(R.id.characterName) EditText characterName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        characterName.setOnKeyListener(this);
    }

    @Override
    public boolean onKey(View v, int keyCode, KeyEvent event) {
        if (event.getAction() == KeyEvent.ACTION_UP && keyCode == KeyEvent.KEYCODE_ENTER) {
            System.out.println("Code > " + keyCode);
        }
        return false;
    }
}
