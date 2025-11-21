package com.example.app.frmanager;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.app.mainfr.Corales;
import com.example.app.mainfr.Peces;

public class Paginador  extends FragmentPagerAdapter {
    private final Context mcontext;

    public Paginador(Context context, FragmentManager fm){


        super(fm);
        mcontext = context;
    }


    @NonNull
    @Override

    public Fragment getItem(int position){
        switch (position) {

            case 0:
                return  new Corales();

            case 1:
                return  new Peces();
        }
        return null;

    }


    @Override // INdica número de paginas que hay en el la aplicación
    public int getCount() {
        return 2;
    }
}
