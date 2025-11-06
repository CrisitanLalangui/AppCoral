package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;

public class SplashScreen extends AppCompatActivity {
    ImageView imagenLogo;
    ImageView fondo;
    TextView nombreApp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        imagenLogo = findViewById(R.id.imagenLogoPrinciapl);
        nombreApp = findViewById(R.id.CoralTExto);
        fondo = findViewById(R.id.splash);

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.aparecer);
        imagenLogo.startAnimation(animation);
        nombreApp.startAnimation(animation);

        Glide.with(this)
                .load("https://concepto.de/wp-content/uploads/2018/09/oc%C3%A9ano-e1537912452874.jpg")
                .transition(DrawableTransitionOptions.withCrossFade(1000))
                .centerCrop()
                .into(fondo);

        launchNextActivity(); // Pasa  a la siguiente actividad

    }



    public void launchNextActivity() {


        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent intent = new Intent(SplashScreen.this, Login.class);
                startActivity(intent);
                finish();

            }
        }, 2000);


    }

}