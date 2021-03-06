package com.arnauzapata.myapplication;

import android.app.Fragment;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.material.joanbarroso.flipper.CoolImageFlipper;

import java.util.Random;


public class jocMemory extends Fragment implements View.OnClickListener {

    String user=null;
    private static final String TAG = "Joc Memory";
    private ImageView ImageView1;
    private ImageView ImageView2;
    private ImageView ImageView3;
    private ImageView ImageView4;
    private ImageView ImageView5;
    private ImageView ImageView6;
    private ImageView ImageView7;
    private ImageView ImageView8;
    private ImageView ImageView9;
    private ImageView ImageView10;
    private ImageView ImageView11;
    private ImageView ImageView12;
    private ImageView ImageView13;
    private ImageView ImageView14;
    private ImageView ImageView15;
    private ImageView ImageView0;
    private Button button1;
    TextView text1;

    int[] soluciones =new int[16];
    int[] colores =new int[8];
    boolean [] solved=new boolean[16];
    boolean [] selected=new boolean[16];
    int image1; int image2;
    int select1, select2;
    private static final int color1=R.drawable.red;
    private static final int color2=R.drawable.blue;
    private static final int color3=R.drawable.brown;
    private static final int color4=R.drawable.green;
    private static final int color5=R.drawable.yellow;
    private static final int color6=R.drawable.lila;
    private static final int color7=R.drawable.gris;
    private static final int color8=R.drawable.cian;


    Context context;
    private boolean ocupado;
    //private boolean despierto;
    private int pasos =0;
    private Drawable d1;
    private Drawable d2;
    private Drawable d3;
    private Drawable d4;
    private Drawable d5;
    private Drawable d6;
    private Drawable d7;
    private Drawable d8;
    private BaseDatosRanking BaseDatosRanking=null;
    private boolean noToquesNada=false;

    public jocMemory(Context context, String user, DataMemory data) {
        empezarJuego();
        ocupado=false;
        this.context=context;
        this.user=user;
        soluciones= data.getSoluciones();
        solved=data.solved;
        selected=data.selected;
        colores=data.colores;
        image1=data.image1;
        image2=data.image2;
        select1=data.select1;
        select2=data.select2;
        pasos=data.pasos;
        ocupado=data.ocupado;
    }


    public void empezarJuego(){
        for(int i=0;i<16;i++) soluciones[i]=-1;
        for(int i=0;i<16;i++) solved[i]=false;
        for(int i=0;i<16;i++) selected[i]=false;
        for(int i=0;i<8;i++) colores[i]=0;
        image1=-1;image2 = -1;
        select1=-1;select2 = -1;
    }

    public jocMemory(Context c, String s) {
        empezarJuego();
        ocupado=false;
        context=c;
        user=s;

    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.fragment_joc_memory, container, false);
        BaseDatosRanking= new BaseDatosRanking(context);
        BaseDatosRanking.getInstance(context);
        ImageView15 = (ImageView) view.findViewById(R.id.imageViewMemory15);
        ImageView14 = (ImageView) view.findViewById(R.id.imageViewMemory14);
        ImageView13 = (ImageView) view.findViewById(R.id.imageViewMemory13);
        ImageView12 = (ImageView) view.findViewById(R.id.imageViewMemory12);
        ImageView11 = (ImageView) view.findViewById(R.id.imageViewMemory11);
        ImageView10 = (ImageView) view.findViewById(R.id.imageViewMemory10);
        ImageView9 = (ImageView) view.findViewById(R.id.imageViewMemory9);
        ImageView8 = (ImageView) view.findViewById(R.id.imageViewMemory8);
        ImageView7 = (ImageView) view.findViewById(R.id.imageViewMemory7);
        ImageView6 = (ImageView) view.findViewById(R.id.imageViewMemory6);
        ImageView5 = (ImageView) view.findViewById(R.id.imageViewMemory5);
        ImageView4 = (ImageView) view.findViewById(R.id.imageViewMemory4);
        ImageView3 = (ImageView) view.findViewById(R.id.imageViewMemory3);
        ImageView2 = (ImageView) view.findViewById(R.id.imageViewMemory2);
        ImageView1 = (ImageView) view.findViewById(R.id.imageViewMemory1);
        ImageView0 = (ImageView) view.findViewById(R.id.imageViewMemory0);
        button1 = (Button) view.findViewById(R.id.buttonMemory1);
        text1 = (TextView) view.findViewById(R.id.textMemory);


        d1=getResources().getDrawable(R.drawable.red);
        d2=getResources().getDrawable(R.drawable.blue);
        d3=getResources().getDrawable(R.drawable.brown);
        d4=getResources().getDrawable(R.drawable.green);
        d5=getResources().getDrawable(R.drawable.yellow);
        d6=getResources().getDrawable(R.drawable.lila);
        d7=getResources().getDrawable(R.drawable.gris);
        d8=getResources().getDrawable(R.drawable.cian);

        for(int i=0;i<16;i++){
            toImageView(i).setImageResource(R.drawable.black);
        }

        button1.setOnClickListener(this);
        for(int i=0;i<16;i++){
            toImageView(i).setOnClickListener(this);
        }
        for(int i =0;i<16;i++){
            if(solved[i])toImageView(i).setVisibility(View.INVISIBLE);
        }
        if(select1!=-1)toImageView(select1).setImageResource(soluciones[select1]);
        if(select2!=-1)toImageView(select2).setImageResource(soluciones[select2]);
        comprobar();
        text1.setText("numero de pasos: " + String.valueOf(pasos));
        return view;
    }


    @Override
    public void onClick(View v) {
        CoolImageFlipper c = new CoolImageFlipper(context);
        Drawable d =null;
        int auxImage=-1;
        switch (v.getId()){
            case R.id.imageViewMemory0:
                pulsarCarta(0);
                break;
            case R.id.imageViewMemory1:
                pulsarCarta(1);
                break;
            case R.id.imageViewMemory2:
                pulsarCarta(2);
                break;
            case R.id.imageViewMemory3:
                pulsarCarta(3);
                break;
            case R.id.imageViewMemory4:
                pulsarCarta(4);
                break;
            case R.id.imageViewMemory5:
                pulsarCarta(5);
                break;
            case R.id.imageViewMemory6:
                pulsarCarta(6);
                break;
            case R.id.imageViewMemory7:
                pulsarCarta(7);
                break;
            case R.id.imageViewMemory8:
                pulsarCarta(8);
                break;
            case R.id.imageViewMemory9:
                pulsarCarta(9);
                break;
            case R.id.imageViewMemory10:
                pulsarCarta(10);
                break;
            case R.id.imageViewMemory11:
                pulsarCarta(11);
            break;
            case R.id.imageViewMemory12:
                pulsarCarta(12);
                break;
            case R.id.imageViewMemory13:
                pulsarCarta(13);
                break;
            case R.id.imageViewMemory14:
                pulsarCarta(14);
                break;
            case R.id.imageViewMemory15:
                pulsarCarta(15);
                break;
            case R.id.buttonMemory1:
                empezarDeNuevo();
                break;
        }
    }

    private void allSelectedFalse(){
        for(int i=0;i<16;i++)selected[i]=false;
        select1 = -1;
        select2 = -1;
    }

    private void pulsarCarta(int i) {
        int auxImage;
        if(selected[i] || solved[i] || ocupado) return;
        ocupado=true;
        selected[i]=true;
        if(soluciones[i]==-1)soluciones[i] = elegirColor();
        auxImage=soluciones[i];
        if(image1==-1){image1=auxImage;}
        else if(image2==-1){image2=auxImage;}
        if(select1==-1){select1=i;}
        else if(select2==-1){select2=i;}
        CoolImageFlipper c = new CoolImageFlipper(context);
        Drawable d =null;
        d = toDrawable(auxImage);
        c.flipImage(d,toImageView(i));
        comprobar();
    }

    private void comprobar() {
        if(image1!=-1 && image2!=-1  && select1!= select2 && !solved[select1] && !solved[select2]) {
            noToquesNada=true;
            pasos++;
            if (image1 == image2) {
                if(select1!=-1)solved[select1]=true;
                if(select2!=-1)solved[select2]=true;
                boolean aux=true;
                for (int i = 0; i < 16; i++) if (!solved[i]) aux=false;
                if(aux) {
                    if (pasos < 10) BaseDatosRanking.createRow(user, "0" + String.valueOf(pasos));
                    else BaseDatosRanking.createRow(user, String.valueOf(pasos));
                    String oldPuntuation = BaseDatosRanking.queryRow(user);
                    int oldPunt;
                    Log.v(TAG, oldPuntuation);
                    if (!oldPuntuation.equals("null")) oldPunt = Integer.valueOf(oldPuntuation);
                    else oldPunt=100;
                    if(oldPunt>pasos){
                        if(pasos<10) BaseDatosRanking.updateRow(user,"0"+String.valueOf(pasos));
                        else BaseDatosRanking.updateRow(user,String.valueOf(pasos));
                    }
                    if(pasos>100){
                        CharSequence text = "Has ganado, pero tu manqueo es over 9000 y no se te es permitido subirlo al ranking";
                        int duration = Toast.LENGTH_SHORT; //También puede ser Toast.LENGTH_LONG;
                        Toast.makeText(context, text, duration).show();
                    }
                    else{
                        CharSequence text = "¡¡Has ganado!!";
                        int duration = Toast.LENGTH_SHORT; //También puede ser Toast.LENGTH_LONG;
                        Toast.makeText(context, text, duration).show();
                    }
                }
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(select1!=-1)toImageView(select1).setVisibility(View.INVISIBLE);
                        if(select2!=-1)toImageView(select2).setVisibility(View.INVISIBLE);
                        image1 = -1;
                        image2 = -1;
                        allSelectedFalse();
                        text1.setText("numero de pasos: " + String.valueOf(pasos));
                        ocupado=false;
                        noToquesNada=false;
                    }
                }, 2000);
            }
            else{
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        if(select1!=-1)voltearCarta(select1);
                        if(select2!=-1)voltearCarta(select2);
                        image1 = -1;
                        image2 = -1;
                        allSelectedFalse();
                        text1.setText("numero de pasos: " + String.valueOf(pasos));
                        ocupado=false;
                        noToquesNada=false;
                    }
                }, 2000);

            }
        }
        else if(!noToquesNada){

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    ocupado=false;
                }
            }, 200);

        }
    }

    private void empezarDeNuevo() {
        for(int i=0;i<16;i++){
            toImageView(i).setImageResource(R.drawable.black);
        }
        for(int i=0;i<16;i++){
            toImageView(i).setVisibility(View.VISIBLE);
        }
        empezarJuego();
        pasos=0;text1.setText("numero de pasos: " + String.valueOf(pasos));
    }

    private Drawable toDrawable(int auxImage) {
        switch (auxImage){
            case color1:
                return d1;
            case color2:
                return d2;
            case color3:
                return d3;
            case color4:
                return d4;
            case color5:
                return d5;
            case color6:
                return d6;
            case color7:
                return d7;
            case color8:
                return d8;
        }
        return null;
    }

    private int elegirColor() {
        Random rand=new Random();
        int num;
        do {num = rand.nextInt(8);}while(colores[num]>=2);colores[num]++; //busca numeros al azar hasta que encuentra uno donde no hayan sido asignados 2 o mas colores, entonces añade uno al color asignado
        switch (num){
            case 0:
                return color1;
            case 1:
                return color2;
            case 2:
                return color3;
            case 3:
                return color4;
            case 4:
                return color5;
            case 5:
                return color6;
            case 6:
                return color7;
            case 7:
                return color8;
        }
        return R.drawable.black;
    }


 private ImageView toImageView(int i){
     ImageView ret=null;
     switch (i){
         case 0: ret= ImageView0;break;
         case 1: ret=  ImageView1;break;
         case 2: ret=  ImageView2;break;
         case 3: ret=  ImageView3;break;
         case 4: ret=  ImageView4;break;
         case 5: ret=  ImageView5;break;
         case 6: ret=  ImageView6;break;
         case 7: ret=  ImageView7;break;
         case 8: ret=  ImageView8;break;
         case 9: ret=  ImageView9;break;
         case 10:ret=  ImageView10; break;
         case 11: ret=  ImageView11;break;
         case 12: ret=  ImageView12;break;
         case 13: ret=  ImageView13;break;
         case 14: ret=  ImageView14;break;
         case 15: ret=  ImageView15;break;


     }
     return ret;
 }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    private void voltearCarta(int i) {
        CoolImageFlipper c = new CoolImageFlipper(context);
        Drawable d= getResources().getDrawable(R.drawable.black);
        switch (i){
            case 0:
                c.flipImage(d,ImageView0);
                break;
            case 1:
                c.flipImage(d,ImageView1);
                break;
            case 2:
                c.flipImage(d,ImageView2);
                break;
            case 3:
                c.flipImage(d,ImageView3);
                break;
            case 4:
                c.flipImage(d,ImageView4);
                break;
            case 5:
                c.flipImage(d,ImageView5);
                break;
            case 6:
                c.flipImage(d,ImageView6);
                break;
            case 7:
                c.flipImage(d,ImageView7);
                break;
            case 8:
                c.flipImage(d,ImageView8);
                break;
            case 9:
                c.flipImage(d,ImageView9);
                break;
            case 10:
                c.flipImage(d,ImageView10);
                break;
            case 11:
                c.flipImage(d,ImageView11);
                break;
            case 12:
                c.flipImage(d,ImageView12);
                break;
            case 13:
                c.flipImage(d,ImageView13);
                break;
            case 14:
                c.flipImage(d,ImageView14);
                break;
            case 15:
                c.flipImage(d,ImageView15);
                break;

        }


    }



   public DataMemory getData(){
       DataMemory data=new DataMemory();
       data.setSoluciones(soluciones);
       data.colores=colores;
       data.image1=image1;data.image2=image2;
       data.solved=solved;
       data.selected=selected;
       data.select1=select1;
       data.select2=select2;
       data.pasos=pasos;
       data.ocupado=ocupado;
       return data;
    }

    public void getBorrarMemoria() {
        for(int i=0;i<16;i++){
            toImageView(i).setVisibility(View.INVISIBLE);
        }
        text1.setText("");
    }
}
