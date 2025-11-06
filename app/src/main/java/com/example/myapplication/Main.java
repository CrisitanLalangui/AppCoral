package com.example.myapplication;

import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Main extends AppCompatActivity {

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


        TextView textoMain = findViewById(R.id.tiempoTranscurrido);


        Bundle bundle = getIntent().getExtras();

        String tiempoTranscurrido = String.valueOf(bundle.getLong("tiempoinvertido"));

        textoMain.setText(tiempoTranscurrido + " milisegundos en haber relleanado el login");




        TextView texto2Main = findViewById(R.id.saludoUsuario);


        Bundle bundle2 = getIntent().getExtras();

        String saludo = bundle2.getString("nombreFinal");

        texto2Main.setText("Bienvenido a mi aplicación: " + saludo);










    }
}