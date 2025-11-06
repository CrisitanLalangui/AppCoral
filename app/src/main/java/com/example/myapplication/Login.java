package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions;
import com.google.android.material.textfield.TextInputLayout;

import org.mindrot.jbcrypt.BCrypt;


public class Login extends AppCompatActivity {
    long iniitalTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Cuando se pasa al login.
        iniitalTime= System.currentTimeMillis();
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        TextView  textViewlogin;
        Button botónInicioSesion;


        TextInputLayout nombreUsario;
        TextInputLayout password;


        textViewlogin = findViewById(R.id.accederLogin);

        botónInicioSesion = findViewById(R.id.BotónInicioSesion);


        nombreUsario = findViewById(R.id.usuario);

        password = findViewById(R.id.password);


        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);

        String hashedPassword = sharedPreferences.getString("password", "");




        botónInicioSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {





                boolean continuar = true;

                // Toast:  Funciona como un print


                String  usuario = nombreUsario.getEditText().getText().toString();
                String contraseña = password.getEditText().getText().toString();


                if(campoVacio(usuario)){

                    nombreUsario.setErrorEnabled(true);
                    nombreUsario.setError("Usuario incorrecto");
                    Toast.makeText(Login.this, "El nombre no puede estar vacío", Toast.LENGTH_SHORT).show();
                    continuar = false;
                }

                if(campoVacio(contraseña)){

                    Toast.makeText(Login.this, "La contraseña no puede estar vacía", Toast.LENGTH_SHORT).show();
                    continuar = false;

                    password.setErrorEnabled(true);
                    password.setError("Contraseña no válida");

                }

                if (!campoVacio(contraseña)){

                    if (!checkPassword(password.getEditText().getText().toString(),hashedPassword)){

                        password.setErrorEnabled(true);
                        password.setError("La contraseña introducida es incorrecta");
                        continuar = false;
                    }
                }


                if (continuar){

                    long tiempoFinal =System.currentTimeMillis();


                    Intent intent = new Intent(Login.this,Main.class);
                    intent.putExtra("tiempoinvertido",(tiempoFinal-iniitalTime)/1000);

                    intent.putExtra("nombreFinal",usuario);
                    startActivity(intent);



                }

 // intente builder.

            }

            public  boolean campoVacio(String campo){

                boolean estaVacio = false;

                if ( campo.isBlank()){

                    estaVacio = true;

                }

                if ( campo.isEmpty() ){
                    estaVacio = true;
                }



                return estaVacio;

            }

            public  boolean checkPassword(String candidate, String hashed) {
                return BCrypt.checkpw(candidate, hashed);
            }
        });



        textViewlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(Login.this, Register.class);
                startActivity(intent2);
            }



        });














    }
}