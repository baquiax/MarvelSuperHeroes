package com.baquiax.marvelsuperheroes;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.graphics.drawable.AnimationDrawable;
import android.widget.ImageView;
import com.baquiax.marvelsuperheroes.R;
import butterknife.Bind;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {
    @Bind(R.id.marvelImage) ImageView marvelImage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        ButterKnife.bind(this);
        this.marvelImage.setBackgroundResource(R.drawable.splash_animation);
        AnimationDrawable splashAnimation = (AnimationDrawable) this.marvelImage.getBackground();
        splashAnimation.start();
        this.marvelImage.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent("android.intent.action.SPLASH");
                startActivity(intent);
                finish();
            }
        }, 2000 );
    }
}
