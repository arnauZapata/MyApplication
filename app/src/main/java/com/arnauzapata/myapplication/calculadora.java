package com.arnauzapata.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class calculadora extends AppCompatActivity implements View.OnClickListener {
    int numero;
    private static final String TAG = "Calculadora";

    Button button7; Button button8; Button button9;
    Button button4; Button button5; Button button6;
    Button button1; Button button2; Button button3;
    Button buttonSuma, buttonResta, buttonMultiplicacio, buttonDivision;
    Button buttonPunto, buttonIgual, button0;
    TextView TextResultat;

    private void inicializarObjetos() {
        button0 = (Button) findViewById(R.id.buttonCalculadora0);
        button1 = (Button) findViewById(R.id.buttonCalculadora1);
        button2 = (Button) findViewById(R.id.buttonCalculadora2);
        button3 = (Button) findViewById(R.id.buttonCalculadora3);
        button4 = (Button) findViewById(R.id.buttonCalculadora4);
        button5 = (Button) findViewById(R.id.buttonCalculadora5);
        button6 = (Button) findViewById(R.id.buttonCalculadora6);
        button7 = (Button) findViewById(R.id.buttonCalculadora7);
        button8 = (Button) findViewById(R.id.buttonCalculadora8);
        button9 = (Button) findViewById(R.id.buttonCalculadora9);
        buttonSuma = (Button) findViewById(R.id.buttonCalculadoraSuma);
        buttonResta = (Button) findViewById(R.id.buttonCalculadoraResta);
        buttonMultiplicacio = (Button) findViewById(R.id.buttonCalculadoraMultiplicacion);
        buttonDivision = (Button) findViewById(R.id.buttonCalculadoraDivision);
        buttonPunto = (Button) findViewById(R.id.buttonCalculadoraPunto);
        buttonIgual = (Button) findViewById(R.id.buttonCalculadoraIgual);
        TextResultat = (TextView) findViewById(R.id.TextViewResultat);
    }

    private void asignarOnClickListener() {
        final Context context = this;

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
    }

    private void asignarValoresObjetos() {
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculadora);
        Log.v(TAG,"onCreate");
        numero = 1;
        inicializarObjetos();
        asignarValoresObjetos();
        asignarOnClickListener();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonCalculadora0:
                Log.v(TAG, "Soy el boton 0");
                // setText("Soy el boton 1");
                break;
            case R.id.buttonCalculadora1:
                Log.v(TAG, "Soy el boton 1");
                // setText("Soy el boton 2");
                break;
            case R.id.buttonCalculadora2:
                Log.v(TAG, "Soy el boton 2");
                // setText("Soy el boton 3");
                break;
            case R.id.buttonCalculadora3:
                Log.v(TAG, "Soy el boton 3");
                //setText("Soy el boton 1");
                break;
            case R.id.buttonCalculadora4:
                Log.v(TAG, "Soy el boton 4");
                // setText("Soy el boton 2");
                break;
            case R.id.buttonCalculadora5:
                Log.v(TAG, "Soy el boton 5");
                // setText("Soy el boton 3");
                break;
            case R.id.buttonCalculadora6:
                Log.v(TAG, "Soy el boton 6");
                // setText("Soy el boton 1");
                break;
            case R.id.buttonCalculadora7:
                Log.v(TAG, "Soy el boton 7");
                // setText("Soy el boton 2");
                break;
            case R.id.buttonCalculadora8:
                Log.v(TAG, "Soy el boton 8");
                // setText("Soy el boton 3");
                break;
            case R.id.buttonCalculadora9:
                Log.v(TAG, "Soy el boton 9");
                // setText("Soy el boton 2");
                break;
            case R.id.buttonCalculadoraSuma:
                Log.v(TAG, "Soy el boton Suma");
                // setText("Soy el boton 3");
                break;
            case R.id.buttonCalculadoraResta:
                Log.v(TAG, "Soy el boton  Resta ");
                // setText("Soy el boton 1");
                break;
            case R.id.buttonCalculadoraMultiplicacion:
                Log.v(TAG, "Soy el boton Multiplicacion");
                // setText("Soy el boton 2");
                break;
            case R.id.buttonCalculadoraDivision:
                Log.v(TAG, "Soy el boton Division");
                // setText("Soy el boton Division");
                break;
            case R.id.buttonCalculadoraPunto:
                Log.v(TAG, "Soy el boton Punto");
                // setText("Soy el boton 2");
                break;
            case R.id.buttonCalculadoraIgual:
                Log.v(TAG, "Soy el boton Igual");
                // setText("Soy el boton 3");
                break;


        }
        Log.v(TAG, "Soy el boton 2");
    }
}
