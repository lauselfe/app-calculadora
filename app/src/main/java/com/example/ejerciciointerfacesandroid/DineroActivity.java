package com.example.ejerciciointerfacesandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class DineroActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn;
    EditText dolares, euros;
    ImageView perfil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ///Orientacion landscape y full width
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_dinero);

       ///actionbar edit
       getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.mipmap.calculadorapequenya);
        getSupportActionBar().setTitle("");


        perfil = (ImageView) findViewById(R.id.perfil);
        btn = (Button) findViewById(R.id.btn);
        dolares = (EditText) findViewById(R.id.dolares);
        euros = (EditText) findViewById(R.id.euros);
        btn.setOnClickListener(this);
        perfil.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case (R.id.btn):
                String contenidoDolares = dolares.getText().toString().trim();
                String contenidoEuros = euros.getText().toString().trim();
                dolares.setText("");
                euros.setText("");
                if(contenidoDolares.isEmpty() == true && contenidoEuros.isEmpty() == false){
                    double resEuroToDolar = Double.parseDouble(contenidoEuros) * 1.11;
                    dolares.setText(String.valueOf(resEuroToDolar),  TextView.BufferType.EDITABLE);

                }else{
                    Toast.makeText(this, "Introduce una cantidad", Toast.LENGTH_LONG).show();

                }
                if(contenidoDolares.isEmpty() == false && contenidoEuros.isEmpty() == true){
                    double resDolarToEuro = Double.parseDouble(contenidoDolares) * 0.9;
                    euros.setText(String.valueOf(resDolarToEuro),  TextView.BufferType.EDITABLE);


                }else{
                    Toast.makeText(this, "Introduce una cantidad", Toast.LENGTH_LONG).show();

                }

                if(contenidoDolares.isEmpty() == false && contenidoEuros.isEmpty() == false){
                    dolares.getText().clear();
                    euros.getText().clear();
                }




               /* if(TextUtils.isEmpty(contenidoEuros)){
                    Toast.makeText(this, "Introduce una cantidad", Toast.LENGTH_LONG).show();

                }else{
                    double resEuroToDolar = Double.parseDouble(contenidoEuros) * 1.11;
                    dolares.setText(String.valueOf(resEuroToDolar),  TextView.BufferType.EDITABLE);

                }*/

               /* double resDolarToEuro = Double.parseDouble(contenidoDolares) * 0.9;
                    euros.setText(String.valueOf(resDolarToEuro),  TextView.BufferType.EDITABLE);
                    double resEuroToDolar = Double.parseDouble(contenidoEuros) * 1.11;
                    dolares.setText(String.valueOf(resEuroToDolar),  TextView.BufferType.EDITABLE);*/
                break;

                case (R.id.perfil):
                //intent perfil
                Intent perfil = new Intent(DineroActivity.this, PerfilActivity.class);
                startActivity(perfil);
                break;
        }



 }
/*try {
    if(contenidoDolares != null){
        double resDolarToEuro = Double.parseDouble(contenidoDolares) * 0.9;
        //String resultadoEuros = String.valueOf(resDolarToEuro);
        euros.setText(String.valueOf(resDolarToEuro),  TextView.BufferType.EDITABLE);
    }

    if(contenidoEuros != null){
        double resEuroToDolar = Double.parseDouble(contenidoEuros) * 1.11;
        //String resultadoDolares = String.valueOf(resEuroToDolar);
        dolares.setText(String.valueOf(resEuroToDolar),  TextView.BufferType.EDITABLE);

    }
}catch(Exception e){
    Toast.makeText(this, "Ha habido un error", Toast.LENGTH_LONG).show();

}*/
}


