package com.arnauzapata.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private int numero;

    private static final String TAG = "MyActivity";

    Button buttonOne, buttonTwo, buttonTree;
    TextView textOne;

    private void setText(String text){
        textOne.setText(text);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG,"onCreate");
        numero = 1;
        buttonOne = (Button) findViewById(R.id.button1);
        buttonTwo = (Button) findViewById(R.id.button2);
        buttonTree = (Button) findViewById(R.id.button3);
        textOne = (TextView) findViewById(R.id.text1);
        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v(TAG, "Soy el boton 1");
                setText("Soy el boton 1");
            }
        });
        buttonTwo.setOnClickListener(this);
        buttonTree.setOnClickListener(this);
        setText("Aun no me han escrito nada");
        /*View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v(TAG, "Soy el boton 1 en variable");
                setText("Soy el boton 1  en variable");
            }
        };
        buttonOne.setOnClickListener(listener);*/

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG,"onStart");
        numero =2;
    }


    //hola



    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG,"onDestroy");
        numero = 3;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button1:
                Log.v(TAG, "Soy el boton 1 en THIS");
                setText("Soy el boton 1  en THIS");
                break;
            case R.id.button2:
                Log.v(TAG, "Soy el boton 2");
                setText("Soy el boton 2");
                break;
            case R.id.button3:
                Log.v(TAG, "Soy el boton 3");
                setText("Soy el boton 3");
                break;

        }
        Log.v(TAG, "Soy el boton 2");
    }

    public void meHanHechoClick(View v){
        Log.v(TAG, "Soy el boton 4");
        setText("Soy el boton 4");
    }
}


