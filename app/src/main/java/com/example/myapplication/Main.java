package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager.widget.ViewPager;

import com.example.myapplication.databinding.ActivityMainBinding;
import com.example.myapplication.frmanager.Paginador;

public class Main extends AppCompatActivity {


    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());


        Paginador paginador = new Paginador(this,getSupportFragmentManager());

        ViewPager viewPager = binding.aplicacionViewPager;
        viewPager.setAdapter(paginador);


        TextView textoMain = findViewById(R.id.encabezado2);


        Bundle bundle = getIntent().getExtras();

        String tiempoTranscurrido = String.valueOf(bundle.getLong("tiempoinvertido"));

        textoMain.setText("Tiempo Login: " + tiempoTranscurrido + " ms");




        TextView texto2Main = findViewById(R.id.encabezado);


        Bundle bundle2 = getIntent().getExtras();

        String saludo = bundle2.getString("nombreFinal");

        texto2Main.setText("Bienvenido " + saludo);




















    }
}