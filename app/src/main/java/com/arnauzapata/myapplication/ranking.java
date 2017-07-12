package com.arnauzapata.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.util.Pair;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ranking extends android.app.Fragment implements View.OnClickListener {

    String user;
    TextView text1;
    Context context;
    private BaseDatosRanking BaseDatosRanking;
    Button button;
    private View v;

    public ranking(Context context, String user){
        this.user=user;
        this.context=context;
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        user="hola";
        BaseDatosRanking= new BaseDatosRanking(context);
        BaseDatosRanking.getInstance(context);
        v=inflater.inflate(R.layout.activity_ranking, container, false);
        text1=(TextView) v.findViewById(R.id.textViewRanking);
        button = (Button) v.findViewById(R.id.buttonRanking);
        button.setOnClickListener(this);
        mostrarRanking();
        return v;
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
        lista = (ListView)v.findViewById(R.id.listViewRanking);
        adaptador = new ArrayAdapter<String>(context,android.R.layout.simple_list_item_1,listDef);
        lista.setAdapter(adaptador);
        String puntuation = BaseDatosRanking.queryRow(user);
        if(!inRanking)text1.setText("5+) " + user + ": " + puntuation);
    }
}
