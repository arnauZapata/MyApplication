package com.arnauzapata.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private int numero;
    final Context context = this;
    private static final String TAG = "MyActivity";

    Button buttonOne, buttonTwo, buttonTree;
    TextView textOne;
    Toolbar toolbar;
    EditText editText;

    private void setText(String text){
        textOne.setText(text);

    }

    private void inicializarObjetos() {
        buttonOne = (Button) findViewById(R.id.button1);
        buttonTwo = (Button) findViewById(R.id.button2);
        buttonTree = (Button) findViewById(R.id.button3);
        textOne = (TextView) findViewById(R.id.text1);
        toolbar = (Toolbar) findViewById(R.id.toolBar1);
    }

    private void asignarOnClickListener() {

        buttonOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v(TAG, "Soy el boton 1");
                setText("Soy el boton 1");
                Intent i = new Intent(context,calculadora.class);
                startActivity(i);
            }
        });
        buttonTwo.setOnClickListener(this);
        buttonTree.setOnClickListener(this);
    }

    private void asignarValoresObjetos() {
        toolbar.setTitle("TOOLBAR");
        setSupportActionBar(toolbar);
        setText("Aun no me han escrito nada");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.v(TAG,"onCreate");
        numero = 1;
        inicializarObjetos();
        asignarValoresObjetos();
        asignarOnClickListener();
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState( savedInstanceState);
        Log.v(TAG,"se ha llamado onRestore");
        String aux = savedInstanceState.getString("text");
        setText(aux);
    }
    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putString("text", (String) textOne.getText());
        Log.v(TAG,"se ha llamado onSaveInstanceState");

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v(TAG,"onStart");
        numero =2;
    }

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
                SharedPreferences settings = getSharedPreferences(constants.PREFS_NAME, Context.MODE_ENABLE_WRITE_AHEAD_LOGGING);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("text", "Soy el boton 2");
                editor.apply();
                Intent i = new Intent(context,Bandera.class);
                startActivity(i);
                break;
            case R.id.button3:
                Log.v(TAG, "Soy el boton 3");
                setText("Soy el boton 3");
                Context context = getApplicationContext();
                CharSequence text = "Ha pasado algo bueno!";
                int duration = Toast.LENGTH_SHORT; //También puede ser Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
                Toast.makeText(context, text, duration).show();
                Toast.makeText(getApplicationContext(), "Uff", Toast.LENGTH_LONG).show();
                break;

        }
        Log.v(TAG, "Soy el boton 2");
    }

    public void meHanHechoClick(View v){
        Log.v(TAG, "Soy el boton 4");
        setText("Soy el boton 4");
        Intent i = new Intent(context,login.class);
        startActivity(i);
       // int a= Integer.parseInt(editText.getText().toString());
        //int b= Integer.parseInt(editText.getText().toString());
        //textOne.setText(String.valueOf(a+b));
    }

    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu_right2, menu);
        return true;
    }
}


