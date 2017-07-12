package com.arnauzapata.myapplication;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class calculadora extends Fragment implements View.OnClickListener {
    String auxText="";
    int numero;
    boolean firstButton=true;
    boolean validOperator=false;
    double resultat=0;
    double decimal= 1.0;
    int lastNumber=0;
    View v;
    Context context;

    private static final String TAG = "Calculadora";

    Button button7; Button button8; Button button9;
    Button button4; Button button5; Button button6;
    Button button1; Button button2; Button button3;
    Button buttonSuma, buttonResta, buttonMultiplicacio, buttonDivision;
    Button buttonPunto, buttonIgual, button0, buttonDelete, buttonDeleteAll;
    TextView textResultat;
    double num1; double num2; double num3;
    String op1; String op2;
    boolean decimalValid=true;

    String calcul ="";
    private boolean destruccionUniverso=false;

    public calculadora(Context context) {
        num1=num2=num3=-1;
        op1=op2="";
        this.context=context;
    }

    public calculadora(DataCalculadora data,Context context) {
        calcul=data.calcul;
        Log.v(TAG,calcul);
        decimal=data.decimal;
        firstButton=data.firstButton;
        lastNumber=data.lastNumber;
        num1=data.num1;
        Log.v(TAG,String.valueOf(num1));
        num2=data.num2;
        Log.v(TAG,String.valueOf(num2));
        num3=data.num3;
        Log.v(TAG,String.valueOf(num3));
        numero=data.numero;
        Log.v(TAG,String.valueOf(numero));
        op1=data.op1;
        Log.v(TAG,op1);
        op2=data.op2;
        Log.v(TAG,op2);
        resultat=data.resultat;
        Log.v(TAG,String.valueOf(resultat));
         auxText = data.textResultat;
        Log.v(TAG,auxText);
        validOperator=data.validOperator;
        destruccionUniverso=data.destruccionUniverso;
        this.context=context;
    }

    private void inicializarObjetos() {
        button0 = (Button) v.findViewById(R.id.buttonCalculadora0);
        button1 = (Button) v.findViewById(R.id.buttonCalculadora1);
        button2 = (Button) v.findViewById(R.id.buttonCalculadora2);
        button3 = (Button) v.findViewById(R.id.buttonCalculadora3);
        button4 = (Button) v.findViewById(R.id.buttonCalculadora4);
        button5 = (Button) v.findViewById(R.id.buttonCalculadora5);
        button6 = (Button) v.findViewById(R.id.buttonCalculadora6);
        button7 = (Button) v.findViewById(R.id.buttonCalculadora7);
        button8 = (Button) v.findViewById(R.id.buttonCalculadora8);
        button9 = (Button) v.findViewById(R.id.buttonCalculadora9);
        buttonSuma = (Button) v.findViewById(R.id.buttonCalculadoraSuma);
        buttonResta = (Button) v.findViewById(R.id.buttonCalculadoraResta);
        buttonMultiplicacio = (Button) v.findViewById(R.id.buttonCalculadoraMultiplicacion);
        buttonDivision = (Button) v.findViewById(R.id.buttonCalculadoraDivision);
        buttonPunto = (Button) v.findViewById(R.id.buttonCalculadoraPunto);
        buttonIgual = (Button) v.findViewById(R.id.buttonCalculadoraIgual);
        buttonDelete = (Button) v.findViewById(R.id.buttonCalculadoraDelete);
        buttonDeleteAll = (Button) v.findViewById(R.id.buttonCalculadoraDeleteAll);
        textResultat = (TextView) v.findViewById(R.id.TextViewResultat);

    }

    private void asignarOnClickListener() {
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
        buttonDelete.setOnClickListener(this);
        buttonDeleteAll.setOnClickListener(this);
    }

    private void asignarValoresObjetos() {

     //   Log.v(TAG,auxText);
        textResultat.setText(auxText);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         v=inflater.inflate(R.layout.activity_calculadora, container, false);
        numero = 1;
        inicializarObjetos();
        asignarValoresObjetos();
        asignarOnClickListener();
        return v;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonCalculadora0:
                firstButton=false;
                resultat*=10;
                if(decimal<1.0) decimal/=10;
                setNum(0);
                break;
            case R.id.buttonCalculadora1:
                firstButton=false;
                if(decimal>=1.0){resultat*=10;resultat+=1;}
                else{resultat+= 1.0*decimal;decimal/=10;}
                setNum(1);
                break;
            case R.id.buttonCalculadora2:
                firstButton=false;
                if(decimal>=1.0){resultat*=10;resultat+=2;}
                else{resultat+= 2.0*decimal;decimal/=10;}
                setNum(2);
                break;
            case R.id.buttonCalculadora3:
                firstButton=false;
                if(decimal>=1.0){resultat*=10;resultat+=3;}
                else{resultat+= 3.0*decimal;decimal/=10;}
                setNum(3);
                break;
            case R.id.buttonCalculadora4:
                firstButton=false;
                if(decimal>=1.0){resultat*=10;resultat+=4;}
                else{resultat+= 4.0*decimal;decimal/=10;}
                setNum(4);
                break;
            case R.id.buttonCalculadora5:
                firstButton=false;
                if(decimal>=1.0){resultat*=10;resultat+=5;}
                else{resultat+= 5.0*decimal;decimal/=10;}
                setNum(5);
                break;
            case R.id.buttonCalculadora6:
                firstButton=false;
                if(decimal>=1.0){resultat*=10;resultat+=6;}
                else{resultat+= 6.0*decimal;decimal/=10;}
                setNum(6);
                break;
            case R.id.buttonCalculadora7:
                firstButton=false;
                if(decimal>=1.0){resultat*=10;resultat+=7;}
                else{resultat+= 7.0*decimal;decimal/=10;}
                setNum(7);
                break;
            case R.id.buttonCalculadora8:
                firstButton=false;
                if(decimal>=1.0){resultat*=10;resultat+=8;}
                else{resultat+= 8.0*decimal;decimal/=10;}
                setNum(8);
                break;
            case R.id.buttonCalculadora9:
                firstButton=false;
                if(decimal>=1.0){resultat*=10;resultat+=9;}
                else{resultat+= 9.0*decimal;decimal/=10;}
                setNum(9);
                break;
            case R.id.buttonCalculadoraSuma:
                if(! firstButton)addCalcul("+");
                break;
            case R.id.buttonCalculadoraResta:
                if(! firstButton)addCalcul("-");
                break;
            case R.id.buttonCalculadoraMultiplicacion:
                if(! firstButton)addCalcul("*");
                break;
            case R.id.buttonCalculadoraDivision:
                if(! firstButton)addCalcul("/");
                break;
            case R.id.buttonCalculadoraPunto:
                if(decimalValid && !firstButton){
                    decimalValid=false;
                    decimal/=10;
                    calcul+=".";
                    textResultat.setText(calcul);
                }
                break;
            case R.id.buttonCalculadoraIgual:
                firstButton=true;
                validOperator=false;
                decimalValid=true;
                decimal=1.0;
                if(num1==-1)num1=resultat;
                if(num2==-1)num2=resultat;
                if(num3==-1)num3=resultat;
                if(op2=="*") num2*=num3;
                if(op2=="/") {
                    num2/=num3;
                    if(num3==0)destruccionUniverso=true;
                }
                if(op1=="*") num1*=num2;
                if(op1=="/") {
                    num1/=num2;
                    if(num2==0)destruccionUniverso=true;
                }
                if(op1=="+") num1+=num2;
                if(op1=="-") num1-=num2;
                num2=-1;num3=-1;op1="";op2="";
                textResultat.setText(String.valueOf(num1));
                num1=-1;
                calcul="";
                resultat=0;
                if(destruccionUniverso){
                    int duration = Toast.LENGTH_LONG;
                    Toast.makeText(context,"ERROR por dividir entre 0 tu imprudencia de dividir entre 0 a destruido un universo digital, billones de procesos han muerto por tu culpa. ¡¡Eres un monstruo!!" ,duration).show();
                }
                destruccionUniverso=false;

                break;
            case R.id.buttonCalculadoraDelete:
                if(calcul=="") break;
                if(calcul.endsWith("0") || calcul.endsWith("1") || calcul.endsWith("2")|| calcul.endsWith("3")||
                        calcul.endsWith("4")|| calcul.endsWith("5")|| calcul.endsWith("6") || calcul.endsWith("7")||
                        calcul.endsWith("8")|| calcul.endsWith("9")){
                    if(decimal>=1.0) resultat=(int)resultat/10;
                    else{
                        decimal*=10;
                        resultat= resultat - Double.valueOf(lastNumber)*decimal;
                    }
                }
                else if(calcul.endsWith(".")){decimal=1.0;decimalValid=true;}
                else break;
                calcul=calcul.substring(0,calcul.length()-1);
                textResultat.setText(calcul);
                actualizarLastNumber();
                break;
            case R.id.buttonCalculadoraDeleteAll:
                calcul="";
                decimal=1.0;
                firstButton=true;
                validOperator=false;
                decimalValid=true;
                destruccionUniverso=false;
                textResultat.setText(calcul);
                lastNumber=0;
                num1=-1;num2=-1;num3=-1;op1="";op2="";
                break;
        }

    }

    private void actualizarLastNumber() {
        for(int i=0; i<10;i++) if(calcul.endsWith(String.valueOf(i))) lastNumber=i;
    }



    private void addCalcul(String s) {
        String aux = String.valueOf(textResultat.getText());
        if (!aux.endsWith(".") && validOperator) {
            validOperator=false;
            decimalValid=true;
            decimal = 1.0;
            calcul = String.valueOf(textResultat.getText());
            calcul += s;
            textResultat.setText(calcul);
            realizar_calculo(resultat, s);
            resultat = 0;
        }
    }

    private void realizar_calculo(double resultat,String s) {
        if(num1==-1){
            num1=resultat; op1=s;
        }
        else if(num2==-1 && (op1=="*" || op1 =="/")){
            num2=resultat;
            if(op1=="*")num1*=num2;
            else if(num2==0){
                num1/=num2;
                destruccionUniverso=true;
            }
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
            else if(num3==0){
                num2/=num3;
                destruccionUniverso=true;
            }
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

    public void setNum(int num) {
        validOperator=true;
        calcul+=String.valueOf(num);
        lastNumber=num;
        textResultat.setText(calcul);
    }

    public void getBorrarMemoria() {
        textResultat.setText("");
    }

    public  DataCalculadora getResultat() {
        DataCalculadora data= new DataCalculadora();
        data.destruccionUniverso=destruccionUniverso;
        data.calcul=calcul;
        data.decimal=decimal;
        data.firstButton=firstButton;
        data.lastNumber=lastNumber;
        data.num1=num1;
        data.num2=num2;
        data.num3=num3;
        data.numero=numero;
        data.op1=op1;
        data.op2=op2;
        data.resultat=resultat;
        String aux  =textResultat.getText().toString();
        data.textResultat =aux;
        data.validOperator=validOperator;
        return data;
    }

    /*@Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState( savedInstanceState);
        Log.v(TAG,"se ha llamado onRestore");
        String aux = savedInstanceState.getString("text");
        op1=savedInstanceState.getString("op1");
        op2=savedInstanceState.getString("op2");
        calcul=savedInstanceState.getString("calcul");
        resultat=savedInstanceState.getDouble("resultat");
        decimal=savedInstanceState.getDouble("decimal");
        num1=savedInstanceState.getDouble("num1");
        num2=savedInstanceState.getDouble("num2");
        num3=savedInstanceState.getDouble("num3");
        firstButton=savedInstanceState.getBoolean("firstButton");
        validOperator=savedInstanceState.getBoolean("validOperator");
        decimalValid=savedInstanceState.getBoolean("decimalValid");
        textResultat.setText(aux);
    }
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString("text", String.valueOf(textResultat.getText()));
        outState.putBoolean("firstButton",firstButton);
        outState.putBoolean("validOperator",validOperator);
        outState.putBoolean("decimalValid",decimalValid);
        outState.putDouble("resultat",resultat);
        outState.putDouble("decimal",decimal);
        outState.putDouble("num1",num1);
        outState.putDouble("num2",num2);
        outState.putDouble("num3",num3);
        outState.putString("op1",op1);
        outState.putString("op2",op2);
        outState.putString("calcul",calcul);


        Log.v(TAG,"se ha llamado onSaveInstanceState");

    }*/

}
