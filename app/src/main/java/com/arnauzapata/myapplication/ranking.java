package com.arnauzapata.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Pair;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ranking extends AppCompatActivity implements View.OnClickListener {

    String user;

    TextView text1;
    private BaseDatosRanking BaseDatosRanking;
    Button button;

    public ranking(){
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        user="hola";
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        if(intent.getStringExtra("user")!=null) user=intent.getStringExtra("user");
        BaseDatosRanking= new BaseDatosRanking(this);
        BaseDatosRanking.getInstance(this);
        setContentView(R.layout.activity_ranking);
        text1=(TextView) findViewById(R.id.textViewRanking);
        button = (Button) findViewById(R.id.buttonRanking);
        button.setOnClickListener(this);
        mostrarRanking();

    }

    @Override
    public void onClick(View view) {
        BaseDatosRanking.deleteRow(user);
        mostrarRanking();
    }

    void mostrarRanking(){
        boolean inRanking = false;
        ArrayList<Pair<String,String>> list = BaseDatosRanking.selectAllPuntuation();
        ArrayList<String>listDef = new ArrayList<String>();
        for(int i =0;i<5 && i<list.size();i++){
            listDef.add(String.valueOf(i+1)+") "+list.get(i).first + ": "+list.get(i).second + "   paso/s");
            if(list.get(i).first.equals(user)) inRanking=true;
        }
        ListView lista;
        ArrayAdapter<String> adaptador;
        lista = (ListView)findViewById(R.id.listViewRanking);
        adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,listDef);
        lista.setAdapter(adaptador);
        String puntuation = BaseDatosRanking.queryRow(user);
        if(!inRanking)text1.setText("5+) " + user + ": " + puntuation);
    }
}
