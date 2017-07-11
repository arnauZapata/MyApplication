package com.arnauzapata.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class perfil extends AppCompatActivity {

    private static final String TAG = "perfil";
    String user;
    private BaseDatosRanking BaseDatosRanking;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        Intent i=getIntent();
        user=i.getStringExtra("user");
        Log.v(TAG,user);
        TextView textViewNom = (TextView) findViewById(R.id.textViewPerfilNom);
        TextView textViewRecord = (TextView) findViewById(R.id.textViewPerfilRecord);

        textViewNom.setText(user);
        BaseDatosRanking= new BaseDatosRanking(this);
        BaseDatosRanking.getInstance(this);
        String puntuation = BaseDatosRanking.queryRow(user);
        textViewRecord.setText(puntuation);
    }
}
