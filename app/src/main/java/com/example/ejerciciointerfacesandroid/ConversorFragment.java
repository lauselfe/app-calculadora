package com.example.ejerciciointerfacesandroid;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TableRow;


public class ConversorFragment extends Fragment implements View.OnClickListener {

    View main;



    ImageView btnTemperatura, btnDinero, btnBascula;
    TableRow temperaturagrid, dinerogrid, pesogrid;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        main =  inflater.inflate(R.layout.fragment_conversor, container, false);
        pesogrid = (TableRow) main.findViewById(R.id.pesogrid);
        temperaturagrid = (TableRow) main.findViewById(R.id.temperaturagrid);
        dinerogrid = (TableRow) main.findViewById(R.id.dinerogrid);

        pesogrid.setOnClickListener(this);
        temperaturagrid.setOnClickListener(this);
        dinerogrid.setOnClickListener(this);
        return main;
    }

    public void clickear(View view){

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.temperaturagrid:
                Intent temperatura = new Intent (getActivity(), TemperaturaActivity.class);
                startActivity(temperatura);
                break;
            case R.id.dinerogrid:
                Intent euros = new Intent(getActivity(), DineroActivity.class);
                startActivity(euros);
                break;
            case R.id.pesogrid:
                Intent peso = new Intent(getActivity(), ImcActivity.class);
                startActivity(peso);


        }
    }


    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }


}
