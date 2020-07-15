package com.example.ejerciciointerfacesandroid;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static java.lang.Double.NaN;


public class CalculadoraFragment extends Fragment {

    Button sumar, restar, multiplicar, dividir, limpiar, igual, uno, dos, tres, cuatro, cinco, seis, siete, ocho, nueve, cero, punto;
    /*variables que recogen los operadores introducidos a traves de los botones de los numeros*/
    double operador1, operador2, res;
    /*caja donde se muestra los numeros introducidos y el resultado*/
    EditText display;
    /*variable que recoge las operaciones que se pueden realizar con la calculadora*/
    String operacion;
    View main;
    String nada = "";


    public CalculadoraFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         main =  inflater.inflate(R.layout.fragment_calculadora, container, false);

        sumar=(Button) main.findViewById(R.id.sumar);
        restar=(Button)  main.findViewById(R.id.restar);
        multiplicar=(Button)  main.findViewById(R.id.multiplicar);
        dividir=(Button)  main.findViewById(R.id.dividir);

        igual=(Button)  main.findViewById(R.id.igual);


        uno=(Button)  main.findViewById(R.id.uno);
        dos=(Button)  main.findViewById(R.id.dos);
        tres=(Button)  main.findViewById(R.id.tres);
        cuatro=(Button)  main.findViewById(R.id.cuatro);
        cinco=(Button)  main.findViewById(R.id.cinco);
        seis=(Button)  main.findViewById(R.id.seis);
        siete=(Button)  main.findViewById(R.id.siete);
        ocho=(Button)  main.findViewById(R.id.ocho);
        nueve=(Button)  main.findViewById(R.id.nueve);
        cero=(Button)  main.findViewById(R.id.cero);
        punto=(Button)  main.findViewById(R.id.punto);

        display=(EditText)  main.findViewById(R.id.display);



        ///numero 1///

        uno.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText().toString()+ "1");
            }
        });
        ////numero 2 ////
        dos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText().toString()+ "2");
            }
        });
        /// numero 3 ///
        tres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText().toString()+ "3");
            }
        });
        /// numero 4 ///
        cuatro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText().toString()+ "4");
            }
        });
        /// numero 5///
        cinco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText().toString()+ "5");
            }
        });
        /// numero 6///
        seis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText().toString()+ "6");
            }
        });
        ///numero 7///
        siete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText().toString()+ "7");
            }
        });
        ///numero 8///
        ocho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText().toString()+ "8");
            }
        });
        ///numero 9///
        nueve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText().toString()+ "9");
            }
        });
        /// numero 0///
        cero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText().toString()+ "0");
            }
        });
        ///decimal///
        punto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                display.setText(display.getText().toString()+ ".");
            }
        });
        ///sumar///
        sumar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacion = "+";
                operador1 = Double.parseDouble(display.getText().toString());
                display.setText("");
            }
        });
        ///restar ////
        restar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacion = "-";
                operador1 = Double.parseDouble(display.getText().toString());
                display.setText("");
            }
        });
        /// multiplicar////
        multiplicar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacion = "*";
                operador1 = Double.parseDouble(display.getText().toString());
                display.setText("");
            }
        });
        /// dividir ///
        dividir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                operacion = "/";
                operador1 = Double.parseDouble(display.getText().toString());
                display.setText("");
            }
        });

        /// resultado ///
        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String error = "Error";

                ///intentos de que no crashee cuando se le da al = sin ningun valor marcado TODO


                if(operacion == null){
                    display.setText(nada);

                }

                if (operador1 == NaN || operador2 == NaN ){
                    display.setText(nada);
                }


                operador2 = Double.parseDouble(display.getText().toString());

                if(operacion.equals("+")){
                    res = operador1+operador2;
                }
                if(operacion.equals("-")){
                    res = operador1-operador2;
                }
                if(operacion.equals("*")){
                    res = operador1*operador2;
                }
                if(operacion.equals("/")){

                    res = operador1/operador2;
                }
                if(operacion.equals("/") && operador2 == 0){
                    display.setText("error");
                }

                display.setText(String.valueOf(res));


               /* if(!operacion.equals(null)){
                    if(operador2 != 0){
                        if(operacion.equals("+")){
                            res = operador1+operador2;
                            display.setText(String.valueOf(res));
                        }else if(operacion.equals("-")){
                            res = operador1-operador2;
                            display.setText(String.valueOf(res));
                        }else if(operacion.equals("*")){
                            res = operador1-operador2;
                            display.setText(String.valueOf(res));
                        }else if(operacion.equals("/")){
                            res = operador1-operador2;
                            display.setText(String.valueOf(res));
                        }
                    }
                }else{
                    display.setText(error);
                }*/

            }
        });





        return main;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}




