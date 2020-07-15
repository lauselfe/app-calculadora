package com.example.ejerciciointerfacesandroid;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class ActivityMenu extends AppCompatActivity implements CalculadoraFragment.OnFragmentInteractionListener, ConversorFragment.OnFragmentInteractionListener, GasolinaFragment.OnFragmentInteractionListener, View.OnClickListener {

    CalculadoraFragment calculadora;
    ConversorFragment conversor;
    GasolinaFragment gasolina;

    ImageView perfil;


    ImageButton btnCalculadora, btnConversor, btnGasolina;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_menu);

        btnCalculadora = (ImageButton) findViewById(R.id.btnCalculadora);
        btnConversor = (ImageButton) findViewById(R.id.btnConversor);
        btnGasolina = (ImageButton) findViewById(R.id.btnGasolina);

        perfil = (ImageView) findViewById(R.id.perfil);

        perfil.setOnClickListener(this);

        btnCalculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaccion1 = getSupportFragmentManager().beginTransaction();

                //meter transiciones manualmente para los cambios de fragments con setCustomAnimations(aqui dentro van los archivos de las animaciones);
                //y despues meter el .replace()
                //y despues hacer el .commit()


                transaccion1.replace(R.id.contenedor, calculadora);

                transaccion1.commit();
            }
        });

        btnConversor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaccion2 = getSupportFragmentManager().beginTransaction();

                //meter transiciones manualmente para los cambios de fragments con setCustomAnimations(aqui dentro van los archivos de las animaciones);
                //y despues meter el .replace()
                //y despues hacer el .commit()


                transaccion2.replace(R.id.contenedor, conversor);

                transaccion2.commit();
            }
        });

        btnGasolina.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaccion3 = getSupportFragmentManager().beginTransaction();

                //meter transiciones manualmente para los cambios de fragments con setCustomAnimations(aqui dentro van los archivos de las animaciones);
                //y despues meter el .replace()
                //y despues hacer el .commit()


                transaccion3.replace(R.id.contenedor, gasolina);

                transaccion3.commit();
            }
        });

        gasolina = new GasolinaFragment();
        calculadora = new CalculadoraFragment();
        conversor = new ConversorFragment();

        getSupportFragmentManager().beginTransaction().add(R.id.contenedor, calculadora).commit();


    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onClick(View v) {
        Intent perfil = new Intent(ActivityMenu.this, PerfilActivity.class);
        startActivity(perfil);
    }
}
