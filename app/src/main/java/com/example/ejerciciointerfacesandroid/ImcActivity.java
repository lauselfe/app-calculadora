package com.example.ejerciciointerfacesandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class ImcActivity extends AppCompatActivity implements View.OnClickListener {

    EditText kilos, metros;
    Button btn;
    TextView imc;
    ImageView perfil;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_imc);

        ///actionbar edit
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.calculadorapequenya);
        getSupportActionBar().setTitle("");

        kilos = (EditText) findViewById(R.id.kilos);
        metros = (EditText) findViewById(R.id.metros);
        btn = (Button) findViewById(R.id.btn);
        imc= (TextView) findViewById(R.id.imc);
        perfil = (ImageView) findViewById(R.id.perfil);
        btn.setOnClickListener(this);
        perfil.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case(R.id.btn):
                String contenidoKilos = kilos.getText().toString();
                String contenidoMetros = metros.getText().toString();

                if(contenidoKilos.isEmpty() == false && contenidoMetros.isEmpty() == false){
                    double resImc = Double.parseDouble(contenidoKilos) / Double.parseDouble(contenidoMetros);
                    imc.setText(String.valueOf(resImc));
                }

                break;



            case (R.id.perfil):
                //intent perfil
                Intent perfil = new Intent(ImcActivity.this, PerfilActivity.class);
                startActivity(perfil);
                break;
        }
    }
}
