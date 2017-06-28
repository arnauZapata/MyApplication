package com.arnauzapata.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Bandera extends AppCompatActivity {
    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bandera);
       // Intent i = new Intent(context,Bandera.class);
       // startActivity(i);
    }
}
