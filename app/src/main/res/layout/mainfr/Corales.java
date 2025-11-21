package com.example.app.mainfr;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.app.R;

public class Corales extends Fragment {

    // Un fragmento es una parte de una clase que se divide en subclasese

    @Nullable
    @Override // NombreFragmento para poder acceder a él
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_corales, container, false);

    }
    }


