package com.example.app.mainfr;

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

import com.example.app.R;

public class Peces extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        // Inflamos la vista del fragment
        View rootView = inflater.inflate(R.layout.fragment_peces, container, false);

        // Encontramos las CardViews dentro de la vista raíz
        CardView cardView1 = rootView.findViewById(R.id.cardview1);
        CardView cardView2 = rootView.findViewById(R.id.cardwiew2);
        CardView cardView3 = rootView.findViewById(R.id.cardwiew3);

        // Asignamos listeners
        cardView1.setOnClickListener(v -> {
            mostrarDialogoAlerta();
        });

        cardView2.setOnClickListener(v -> {
            mostrarDialogoAlerta();
        });

        cardView3.setOnClickListener(v -> {
            mostrarDialogoAlerta();
        });

        return rootView; // Muy importante
    }
    public void mostrarDialogoAlerta() {


        new AlertDialog.Builder(getContext())
                .setTitle("Primera alerta del mundo")
                .setMessage("Esto es una alerta")
                .setPositiveButton("Aceptar", (dialog, which) -> {
                    Toast.makeText(getContext(), "Botón positivo", Toast.LENGTH_SHORT).show();
                })
                .setNegativeButton("Cancelar", (dialog, which) -> {
                    Toast.makeText(getContext(), "Botón negativo", Toast.LENGTH_SHORT).show();
                })
                .show();


    }


}






