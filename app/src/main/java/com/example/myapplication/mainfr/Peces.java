package com.example.myapplication.mainfr;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class Peces extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {



        View rootView = inflater.inflate(R.layout.fragment_peces, container, false);


        CardView cardView1 = rootView.findViewById(R.id.cardview1);
        CardView cardView2 = rootView.findViewById(R.id.cardwiew2);
        CardView cardView3 = rootView.findViewById(R.id.cardwiew3);


        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mostrarDialogoAlerta();
            }
        });

        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDialogoAlerta();
            }
        });


        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mostrarDialogoAlerta();
            }
        });
        return rootView; // Muy importante
    }
    public void mostrarDialogoAlerta() {


        new AlertDialog.Builder(getContext())
                .setTitle("Animal")
                .setMessage("Esto es un animal")
                .setPositiveButton("Aceptar", (dialog, which) -> {
                    Toast.makeText(getContext(), "Botón positivo", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("Cancelar", (dialog, which) -> {
                    Toast.makeText(getContext(), "Botón negativo", Toast.LENGTH_SHORT).show();
                })
                .show();


    }


}






