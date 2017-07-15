package com.arnauzapata.myapplication;

import android.app.FragmentTransaction;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TabHost;

public class menu extends AppCompatActivity implements Comunicador{
    String user;
    private String TAG="menu";
    Context context=this;
    private ranking fragmentRanking=null;
    private calculadora fragmentCalculadora=null;
    private perfil fragmentPerfil=null;
    private music fragmentMusic=null;
    private jocMemory Memory=null;
    private int position=0;
    private boolean musicPlayed=false;
    private boolean memoryPlayed=false;
    private DataMemory data=null;
    private boolean CalculadoraPlayed=false;
    String textCalculadora="";
    private DataCalculadora dataCalculadora=null;
    private String idtab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        user=getIntent().getStringExtra("user");
        Log.v(TAG,user);
        Resources res = getResources();
        TabHost tabs=(TabHost)findViewById(android.R.id.tabhost);
        tabs.setup();
        TabHost.TabSpec spec=tabs.newTabSpec("Memory");
        spec.setContent(R.id.tab1);
        spec.setIndicator("Memory", null);
        tabs.addTab(spec);
        spec=tabs.newTabSpec("Ranking");
        spec.setContent(R.id.tab2);
        spec.setIndicator("Ranking",null);
        tabs.addTab(spec);
        spec=tabs.newTabSpec("Music");
        spec.setContent(R.id.tab3);
        spec.setIndicator("Music", null);
        tabs.addTab(spec);
        spec=tabs.newTabSpec("Perfil");
        spec.setContent(R.id.tab4);
        spec.setIndicator("Perfil", null);
        tabs.addTab(spec);
        spec=tabs.newTabSpec("Calculadora");
        spec.setContent(R.id.tab5);
        spec.setIndicator("Calculadora", null);
        tabs.addTab(spec);
        tabs.setCurrentTab(1);
        idtab=getIntent().getStringExtra("idtab");
        if(idtab!=null)tabChanged(idtab);
        else tabChanged("Ranking");
        tabs.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabid) {
                    tabChanged(tabid);

            }
        });
    }

    private void tabChanged(String tabid) {
        idtab=tabid;
        if(musicPlayed){
            position=getPositionMusic(data.getSoluciones());
            musicPlayed=false;
        }
        if(memoryPlayed){
            data =enviarDatosCalculadora();
            musicPlayed=false;
            borrarMemoriaCalculadora();
        }
        if(CalculadoraPlayed){
            dataCalculadora =enviarDatosCalculadora2();
            CalculadoraPlayed=false;
            borrarMemoriaCalculadora2();
        }
        switch (tabid){
            case "Memory":
                if(data==null) Memory = new jocMemory(context,user);
                else Memory = new jocMemory(context,user,data);
                getFragmentManager().beginTransaction().add(R.id.memory, Memory).commit();
                memoryPlayed=true;
                break;
            case "Ranking":
                fragmentRanking = new ranking(context,user);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.add(R.id.ranking, fragmentRanking);
                ft.commit();
                break;
            case "Music":
                fragmentMusic = new music(context,position);
                getFragmentManager().beginTransaction().add(R.id.music, fragmentMusic).commit();
                musicPlayed=true;
                break;
            case "Perfil":
                fragmentPerfil = new perfil(context,user);
                getFragmentManager().beginTransaction().add(R.id.perfil, fragmentPerfil).commit();
                break;
            case "Calculadora":
                if(dataCalculadora==null)fragmentCalculadora = new calculadora(context);
                else fragmentCalculadora = new calculadora(dataCalculadora,context);
                getFragmentManager().beginTransaction().add(R.id.calculadora, fragmentCalculadora).commit();
                CalculadoraPlayed=true;
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_right2, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }

    @Override
    public DataMemory enviarDatosCalculadora() {
        return Memory.getData();
    }

    public DataCalculadora enviarDatosCalculadora2() {
        return fragmentCalculadora.getResultat();
    }

    @Override
    public int getPositionMusic(int[] soluciones) {
        int ret= fragmentMusic.getPosition();
        Log.v(TAG,String.valueOf(ret));
        return ret;

    }

    @Override
    public void borrarMemoriaCalculadora() {
        Memory.getBorrarMemoria();

    }
    @Override
    public void borrarMemoriaCalculadora2() {
        fragmentCalculadora.getBorrarMemoria();

    }

    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
        position = savedInstanceState.getInt("position");
        idtab = savedInstanceState.getString("idtab");
           /* dataCalculadora.op1= savedInstanceState.getString("op1");
            dataCalculadora.op2= savedInstanceState.getString("op2");
            dataCalculadora.textResultat= savedInstanceState.getString("textResultat");
            dataCalculadora.calcul= savedInstanceState.getString("calcul");
            dataCalculadora.num1= savedInstanceState.getDouble("num1");
            dataCalculadora.num2= savedInstanceState.getDouble("num2");
            dataCalculadora.num3= savedInstanceState.getDouble("num3");
            dataCalculadora.resultat= savedInstanceState.getDouble("resultat");
            dataCalculadora.decimal= savedInstanceState.getDouble("decimal");
            dataCalculadora.lastNumber= savedInstanceState.getInt("lastNumber");
            dataCalculadora.numero= savedInstanceState.getInt("numero");
            dataCalculadora.destruccionUniverso= savedInstanceState.getBoolean("destruccionUniverso");
            dataCalculadora.validOperator= savedInstanceState.getBoolean("validOperator");
            dataCalculadora.firstButton= savedInstanceState.getBoolean("firstButton");
            tabChanged(idtab);*/
    }
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt("position",position);
        outState.putString("idtab",idtab);
       /*  if(fragmentCalculadora!=null){
             dataCalculadora=enviarDatosCalculadora2();
             outState.putString("op1",dataCalculadora.op1);
             outState.putString("op2",dataCalculadora.op2);
             outState.putString("idtab",idtab);
             outState.putString("textResultat",dataCalculadora.textResultat);
             outState.putString("calcul",dataCalculadora.calcul);
             outState.putDouble("num1", dataCalculadora.num1);
             outState.putDouble("num2", dataCalculadora.num2);
             outState.putDouble("num3", dataCalculadora.num3);
             outState.putDouble("decimal", dataCalculadora.decimal);
             outState.putDouble("resultat", dataCalculadora.resultat);
             outState.putInt("lastNumber", dataCalculadora.lastNumber);
             outState.putInt("numero", dataCalculadora.numero);
             outState.putBoolean("destruccionUniverso", dataCalculadora.destruccionUniverso);
             outState.putBoolean("firstButton", dataCalculadora.firstButton);
             outState.putBoolean("validOperator", dataCalculadora.validOperator);
         }*/


    }
}