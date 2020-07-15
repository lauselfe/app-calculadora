package com.example.ejerciciointerfacesandroid;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class GasolinaFragment extends Fragment implements View.OnClickListener {

    EditText litros, kilometros, euroslitros;
    TextView consumo, viaje;
    Button btn;
    View main;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        main = inflater.inflate(R.layout.fragment_gasolina, container, false);
        litros = (EditText) main.findViewById(R.id.litros);
        kilometros = (EditText) main.findViewById(R.id.kilometros);
        euroslitros = (EditText) main.findViewById(R.id.euroslitros);
        consumo = (TextView) main.findViewById(R.id.consumo);
        viaje = (TextView) main.findViewById(R.id.viaje);
        btn = (Button) main.findViewById(R.id.btn);

        euroslitros.setOnKeyListener(null);
        btn.setOnClickListener(this);

        return main;
    }

    @Override
    public void onClick(View v) {
        String contenidoLitros = litros.getText().toString();
        String contenidoKilometros = kilometros.getText().toString();
        String contenidoEuroLitros = euroslitros.getText().toString();

        if(contenidoKilometros.isEmpty() == false && contenidoLitros.isEmpty() == false){
            double resConsumo = (Double.parseDouble(contenidoLitros) / Double.parseDouble(contenidoKilometros)) * 100;
            consumo.setText(String.valueOf(resConsumo));
            double resViaje = Double.parseDouble(contenidoEuroLitros)* Double.parseDouble(contenidoLitros);
            viaje.setText(String.valueOf(resViaje));
        }else{
            Toast.makeText(getContext(), "Introduce los datos",Toast.LENGTH_LONG).show();
        }
    }

    public interface OnFragmentInteractionListener {

        void onFragmentInteraction(Uri uri);
    }
}
