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
import android.widget.Toast;

public class TemperaturaActivity extends AppCompatActivity implements View.OnClickListener {

    EditText grados, fahrenheit;
    Button btn;
    ImageView perfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_temperatura);

        ///actionbar edit
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.calculadorapequenya);
        getSupportActionBar().setTitle("");

        grados = (EditText) findViewById(R.id.grados);
        fahrenheit = (EditText) findViewById(R.id.fahrenheit);
        btn = (Button) findViewById(R.id.btn);
        perfil = (ImageView) findViewById(R.id.perfil);

        btn.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case(R.id.btn):
                String contenidoGrados = grados.getText().toString().trim();
                String contenidoFahrenheit = fahrenheit.getText().toString().trim();

                if(contenidoFahrenheit.isEmpty() == true && contenidoGrados.isEmpty() == true){
                    Toast.makeText(this, "Introduce una temperatura", Toast.LENGTH_LONG).show();
                }

               if(contenidoFahrenheit.isEmpty() == true && contenidoGrados.isEmpty() == false){
                    double resGradestoFahrenheit = (Double.parseDouble(contenidoGrados) * 1.8) + 32;
                    fahrenheit.setText(String.valueOf(resGradestoFahrenheit),  TextView.BufferType.EDITABLE);
                    grados.getText().clear();

                }else{
                    Toast.makeText(this, "Introduce una cantidad1", Toast.LENGTH_LONG).show();

                }
                if(contenidoGrados.isEmpty() == true && contenidoFahrenheit.isEmpty() == false){

                    double a = Double.parseDouble(contenidoFahrenheit) -32;
                    double b = a *5/9;
                    grados.setText(String.valueOf(b), TextView.BufferType.EDITABLE);
                    fahrenheit.getText().clear();
                   /* double resFahrenheitToGrades = Double.parseDouble(contenidoGrados) - 32 ;
                    grados.setText(String.valueOf(resFahrenheitToGrades),  TextView.BufferType.EDITABLE);
                    fahrenheit.getText().clear();*/

                }else{
                    Toast.makeText(this, "Introduce una cantidad2", Toast.LENGTH_LONG).show();

                }

                if(contenidoFahrenheit.isEmpty() == false && contenidoGrados.isEmpty() == false){
                    fahrenheit.getText().clear();
                    grados.getText().clear();
                }
                break;


            case (R.id.perfil):
                //intent perfil
                Intent perfil = new Intent(TemperaturaActivity.this, PerfilActivity.class);
                startActivity(perfil);
                break;
        }
    }
}
