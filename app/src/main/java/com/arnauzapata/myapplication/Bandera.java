package com.arnauzapata.myapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Bandera extends AppCompatActivity {
    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bandera);
        SharedPreferences settings = getSharedPreferences(constants.PREFS_NAME, Context.MODE_ENABLE_WRITE_AHEAD_LOGGING);
//Consultamos
        String text = settings.getString("text","hola");
       // Intent i = new Intent(context,Bandera.class);
       // startActivity(i);
    }
}
