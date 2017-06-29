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
    double resultat=0;
    double decimal= 1.0;
    private static final String TAG = "Calculadora";

    Button button7; Button button8; Button button9;
    Button button4; Button button5; Button button6;
    Button button1; Button button2; Button button3;
    Button buttonSuma, buttonResta, buttonMultiplicacio, buttonDivision;
    Button buttonPunto, buttonIgual, button0;
    TextView textResultat;
    double num1; double num2; double num3;
    String op1; String op2;
    boolean decimalValid=true;

    String calcul ="";
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
        textResultat = (TextView) findViewById(R.id.TextViewResultat);
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
        buttonSuma.setOnClickListener(this);
        buttonResta.setOnClickListener(this);
        buttonMultiplicacio.setOnClickListener(this);
        buttonDivision.setOnClickListener(this);
        buttonIgual.setOnClickListener(this);
        buttonPunto.setOnClickListener(this);
        //button9.setOnClickListener(this);
    }

    private void asignarValoresObjetos() {
        num1=num2=num3=-1;
        op1=op2="";
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
                resultat*=10;
                setNum(resultat);
                break;
            case R.id.buttonCalculadora1:
                Log.v(TAG, "Soy el boton 1");
                if(decimal>=1.0){resultat*=10;resultat+=1;}
                else{resultat+= 1.0*decimal;decimal/=10;}
                setNum(resultat);
                break;
            case R.id.buttonCalculadora2:
                Log.v(TAG, "Soy el boton 2");
                if(decimal>=1.0){resultat*=10;resultat+=2;}
                else{resultat+= 2.0*decimal;decimal/=10;}
                setNum(resultat);
                break;
            case R.id.buttonCalculadora3:
                Log.v(TAG, "Soy el boton 3");
                if(decimal>=1.0){resultat*=10;resultat+=3;}
                else{resultat+= 3.0*decimal;decimal/=10;}
                setNum(resultat);
                break;
            case R.id.buttonCalculadora4:
                Log.v(TAG, "Soy el boton 4");
                if(decimal>=1.0){resultat*=10;resultat+=4;}
                else{resultat+= 4.0*decimal;decimal/=10;}
               setNum(resultat);
                break;
            case R.id.buttonCalculadora5:
                Log.v(TAG, "Soy el boton 5");
                if(decimal>=1.0){resultat*=10;resultat+=5;}
                else{resultat+= 5.0*decimal;decimal/=10;}
                setNum(resultat);
                break;
            case R.id.buttonCalculadora6:
                Log.v(TAG, "Soy el boton 6");
                if(decimal>=1.0){resultat*=10;resultat+=6;}
                else{resultat+= 6.0*decimal;decimal/=10;}
                setNum(resultat);
                break;
            case R.id.buttonCalculadora7:
                Log.v(TAG, "Soy el boton 7");
                if(decimal>=1.0){resultat*=10;resultat+=7;}
                else{resultat+= 7.0*decimal;decimal/=10;}
                setNum(resultat);
                break;
            case R.id.buttonCalculadora8:
                Log.v(TAG, "Soy el boton 8");
                if(decimal>=1.0){resultat*=10;resultat+=8;}
                else{resultat+= 8.0*decimal;decimal/=10;}
                setNum(resultat);
                break;
            case R.id.buttonCalculadora9:
                Log.v(TAG, "Soy el boton 9");
                if(decimal>=1.0){resultat*=10;resultat+=9;}
                else{resultat+= 9.0*decimal;decimal/=10;}
                setNum(resultat);
                break;
            case R.id.buttonCalculadoraSuma:
                Log.v(TAG, "Soy el boton Suma");
                addCalcul("+");
                break;
            case R.id.buttonCalculadoraResta:
                Log.v(TAG, "Soy el boton  Resta ");
                addCalcul("-");
                break;
            case R.id.buttonCalculadoraMultiplicacion:
                Log.v(TAG, "Soy el boton Multiplicacion");
                addCalcul("*");
                break;
            case R.id.buttonCalculadoraDivision:
                Log.v(TAG, "Soy el boton Division");
                addCalcul("/");
                break;
            case R.id.buttonCalculadoraPunto:
                Log.v(TAG, "Soy el boton Punto");
                if(decimalValid){
                    decimalValid=false;
                    decimal/=10;
                    textResultat.setText(String.valueOf(textResultat.getText())+ ".");
                }
                break;
            case R.id.buttonCalculadoraIgual:
                Log.v(TAG, "Soy el boton Igual");
                decimal=1.0;
                if(num1==-1)num1=resultat;
                if(num2==-1)num2=resultat;
                if(num3==-1)num3=resultat;
                Log.v(TAG,String.valueOf(num1) + op1 + String.valueOf(num2) + op2 +String.valueOf(num3));
                if(op2=="*") num2*=num3;
                if(op2=="/") num2/=num3;
                if(op1=="*") num1*=num2;
                if(op1=="/") num1/=num2;
                if(op1=="+") num1+=num2;
                if(op1=="-") num1-=num2;
                num2=-1;num3=-1;op1="";op2="";
                Log.v(TAG,String.valueOf(num1) + op1 + String.valueOf(num2) + op2 +String.valueOf(num3));
                textResultat.setText(String.valueOf(num1));
                num1=-1;
                break;
        }
    }

    private void addCalcul(String s) {
        String aux = String.valueOf(textResultat.getText());
        if(aux.endsWith(".")) return;
        decimal=1.0;
        calcul = String.valueOf(textResultat.getText());
        if(calcul.endsWith("+") || calcul.endsWith("-") || calcul.endsWith("*")|| calcul.endsWith("/")){
            calcul=calcul.substring(0,calcul.length()-1);
        }
        calcul+=s;
        Log.v(TAG,calcul);
        textResultat.setText(calcul);
        realizar_calculo(resultat,s);
        resultat=0;
        Log.v(TAG,String.valueOf(num1) + op1 + String.valueOf(num2) + op2 +String.valueOf(num3));

    }

    private void realizar_calculo(double resultat,String s) {
        if(num1==-1){
            num1=resultat; op1=s;
        }
        else if(num2==-1 && (op1=="*" || op1 =="/")){
            num2=resultat;
            if(op1=="*")num1*=num2;
            else num1/=num2;
            num2=-1;
            op1=s;
            op2="";
        }
        else if(num2==-1 && (op1=="+" || op1 == "-") && (s=="+" || s=="-")){
            num2=resultat;
            if(op1=="+")num1+=num2;
            else num1-=num2;
            num2=-1;
            op1=s;
            op2="";
        }
        else if(num2==-1 && (op1=="+" || op1 == "-") && (s=="*" || s=="/")){
            num2=resultat;
            op2=s;
        }
        else if(num3==-1 && (op1=="+" || op1 == "-") && (op2=="*" || op2=="/")){
            num3=resultat;
            if(op2=="*")num2*=num3;
            else num2/=num3;
            num3=-1;
            op2=s;
            if(op2=="+" || op2=="-"){
                if(op1=="+")num1+=num2;
                else num1-=num2;
                num2=-1;
                op1=s;
                op2="";
            }
        }
    }

    public void setNum(double num) {
        Log.v(TAG, String.valueOf(num));
        if(decimalValid) textResultat.setText(calcul + String.valueOf( (int) num));
        else textResultat.setText(calcul + String.valueOf(num));
    }
}
