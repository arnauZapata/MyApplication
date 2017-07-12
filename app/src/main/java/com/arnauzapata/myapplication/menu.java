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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
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
        tabs.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabid) {
                    if(musicPlayed){
                        position=getPositionMusic();
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
                            if(dataCalculadora==null)fragmentCalculadora = new calculadora();
                            else fragmentCalculadora = new calculadora(dataCalculadora);
                            getFragmentManager().beginTransaction().add(R.id.calculadora, fragmentCalculadora).commit();
                            CalculadoraPlayed=true;
                            break;
                    }
            }
        });
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
    public int getPositionMusic() {
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

        }
 @Override
 public void onSaveInstanceState(Bundle outState){
         super.onSaveInstanceState(outState);
         outState.putInt("position",getPositionMusic());
    }
}