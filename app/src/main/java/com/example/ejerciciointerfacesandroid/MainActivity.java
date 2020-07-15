package com.example.ejerciciointerfacesandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_main);
        //ocultar el action bar
        getSupportActionBar().hide();

        //crear un hilo
        Thread splash = new Thread(){
            //los hilos son objetos con un metodo run
            @Override
            public void run (){
                try{

                    sleep(5000);

                    Intent enlace = new Intent(MainActivity.this, ActivityMenu.class);
                    startActivity(enlace);
                    finish();
                }catch (InterruptedException e){
                    e.printStackTrace();
                };
            }
        };

      splash.start();

    }
}
