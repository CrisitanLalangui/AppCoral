package com.example.myapplication;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputLayout;

import org.mindrot.jbcrypt.BCrypt;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        TextInputLayout nombreUsuario;
        TextInputLayout passwordregister;
        TextInputLayout confirmPasswordregister;
        TextInputLayout mail;
        TextView accedeRegistro;
        Button botonregistro;



        nombreUsuario = findViewById(R.id.usuario);
        passwordregister = findViewById(R.id.password);
        confirmPasswordregister = findViewById(R.id.confirmPassword);
        botonregistro = findViewById(R.id.BotónRegistro);
        mail = findViewById(R.id.mail);
        accedeRegistro = findViewById(R.id.accederRegistro);


        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);// Clase para guardar los datos en un archivo

        SharedPreferences.Editor editor = sharedPref.edit();





        accedeRegistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentRegister = new Intent(Register.this, Login.class);

                startActivity(intentRegister);
            }
        });



        botonregistro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean continuar= true;

                String password1 = passwordregister.getEditText().getText().toString();
                String passworrd2 = confirmPasswordregister.getEditText().getText().toString();
                String usuario = nombreUsuario.getEditText().getText().toString();
                String email = mail.getEditText().getText().toString();


                if (campoVacio(password1) || campoVacio(passworrd2)){

                    confirmPasswordregister.setErrorEnabled(true);
                    passwordregister.setErrorEnabled(true);
                    passwordregister.setError("la contraseña no puede estar vacía");
                    passwordregister.setError("la contraseña no puede estar vacía");

                    continuar = false;

                }

                if (!campoVacio(password1) && !campoVacio(passworrd2)){


                    if (!passwordIguales(password1,passworrd2)){

                        confirmPasswordregister.setEnabled(true);
                        confirmPasswordregister.setError("Las contraseñas no coinciden");

                        passwordregister.setErrorEnabled(true);
                        continuar = false;
                    }


                }

                if (campoVacio(usuario)){
                    nombreUsuario.setErrorEnabled(true);
                    nombreUsuario.setError("el nombre de usuario no puede estar vacío");
                    continuar = false;
                }

                if (campoVacio(email)){
                    mail.setErrorEnabled(true);
                    mail.setError("el  email no puede  estar vacío");
                    continuar = false;
                }

                if (!campoVacio(email)){

                    if(!comprobarMail(email)){

                        mail.setErrorEnabled(true);
                        mail.setError("el formato del email es incorrecto");
                        continuar = false;

                    }

                }

                if (continuar){

                    Intent intentregister = new Intent(Register.this, Login.class);
                    startActivity(intentregister);

                    editor.putString("userName", String.valueOf(nombreUsuario.getEditText().getText()));// Guardar los cambios
                    editor.putString("email", String.valueOf(mail.getEditText().getText()));
                    editor.putString("password",generateHashedPassword(password1)); // Método para cifrar la contraseña
                    editor.apply(); // Aplicar los cambios
                    Intent intentMain = new Intent(Register.this, Login.class);
                    startActivity(intentMain);
                }

            }

            public boolean passwordIguales(String password1,String password2){

                boolean iguales= true;
                if (!password1.equals(password2)){

                    iguales = false;
                }



                return iguales;



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
            public  String generateHashedPassword(String password) {
                return BCrypt.hashpw(password, BCrypt.gensalt());
            }

            public boolean comprobarMail(String mail){

                boolean mailCorrecto = true;

                if( !mail.contains("@")){


                    mailCorrecto = false;
                }
                return mailCorrecto;
            }
        });










    }
}