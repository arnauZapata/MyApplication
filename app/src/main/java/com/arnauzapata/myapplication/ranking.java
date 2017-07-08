package com.arnauzapata.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ranking extends AppCompatActivity {

    TextView text1;
    private BaseDatosRanking BaseDatosRanking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        BaseDatosRanking= new BaseDatosRanking(this);
        setContentView(R.layout.activity_ranking);
         text1=(TextView) findViewById(R.id.textViewRanking);
         String puntuation = BaseDatosRanking.queryRow("hola");
        text1.setText(puntuation);
    }
}
