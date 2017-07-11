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

public class menu extends AppCompatActivity implements View.OnClickListener{
    String user;

    private int numero;
    final Context context = this;
    private static final String TAG = "MyActivity";

    Button buttonOne, buttonTwo, buttonTree;
    TextView textOne;
    Toolbar toolbar;
    EditText editText;


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
                Intent i = new Intent(context,calculadora.class);
                i.putExtra("user",user);
                startActivity(i);
            }
        });
        buttonTwo.setOnClickListener(this);
        buttonTree.setOnClickListener(this);
    }

    private void asignarValoresObjetos() {
        toolbar.setTitle("TOOLBAR");
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        Log.v(TAG,"onCreate");
        Intent intent = getIntent();

        if(intent.getStringExtra("user")!=null) user=intent.getStringExtra("user");
        numero = 1;
        inicializarObjetos();
        asignarValoresObjetos();
        asignarOnClickListener();
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
        Intent i;
        switch (v.getId()){
            case R.id.button1:
                Log.v(TAG, "Soy el boton 1 en THIS");
                break;
            case R.id.button2:
                Log.v(TAG, "Soy el boton 2");
                SharedPreferences settings = getSharedPreferences(constants.PREFS_NAME, Context.MODE_ENABLE_WRITE_AHEAD_LOGGING);
                SharedPreferences.Editor editor = settings.edit();
                editor.putString("text", "Soy el boton 2");
                editor.apply();
                i = new Intent(context,ranking.class);
                i.putExtra("user",user);
                startActivity(i);
                break;
            case R.id.button3:
                Log.v(TAG, "Soy el boton 3");
                Context context = getApplicationContext();
                i = new Intent(context, perfil.class);
                i.putExtra("user",user);
                startActivity(i);
                break;

        }
        Log.v(TAG, "Soy el boton 2");
    }

    public void meHanHechoClick(View v){
        Log.v(TAG, "Soy el boton 4");
        Intent i = new Intent(context,memory.class);
        i.putExtra("user",user);
        startActivity(i);
    }

    public boolean onCreateOptionsMenu(Menu menu){

        getMenuInflater().inflate(R.menu.menu_right2, menu);
        return true;
    }
}
