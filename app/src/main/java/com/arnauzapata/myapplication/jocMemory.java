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

    public jocMemory() {
        for(int i=0;i<16;i++) soluciones[i]=-1;
        for(int i=0;i<16;i++) solved[i]=false;
        for(int i=0;i<16;i++) selected[i]=false;
        for(int i=0;i<8;i++) colores[i]=0;
        image1=-1;image2 = -1;
    }

    public jocMemory(Context c, String s) {
        // Required empty public constructor
        for(int i=0;i<16;i++) soluciones[i]=-1;
        for(int i=0;i<16;i++) solved[i]=false;
        for(int i=0;i<16;i++) selected[i]=false;
        for(int i=0;i<8;i++) colores[i]=0;
        image1=-1;image2 = -1;
        ocupado=false;
        context=c;
        user=s;

    }
    public static jocMemory newInstance(String param1, String param2) {
        jocMemory fragment = new jocMemory();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        
        
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        BaseDatosRanking= new BaseDatosRanking(context);
        BaseDatosRanking.getInstance(context);
        View view=inflater.inflate(R.layout.fragment_joc_memory, container, false);
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

        ImageView0.setImageResource(R.drawable.black);
        ImageView1.setImageResource(R.drawable.black);
        ImageView2.setImageResource(R.drawable.black);
        ImageView3.setImageResource(R.drawable.black);
        ImageView4.setImageResource(R.drawable.black);
        ImageView5.setImageResource(R.drawable.black);
        ImageView6.setImageResource(R.drawable.black);
        ImageView7.setImageResource(R.drawable.black);
        ImageView8.setImageResource(R.drawable.black);
        ImageView9.setImageResource(R.drawable.black);
        ImageView10.setImageResource(R.drawable.black);
        ImageView11.setImageResource(R.drawable.black);
        ImageView12.setImageResource(R.drawable.black);
        ImageView13.setImageResource(R.drawable.black);
        ImageView14.setImageResource(R.drawable.black);
        ImageView15.setImageResource(R.drawable.black);

        button1.setOnClickListener(this);
        ImageView0.setOnClickListener(this);
        ImageView1.setOnClickListener(this);
        ImageView2.setOnClickListener(this);
        ImageView3.setOnClickListener(this);
        ImageView4.setOnClickListener(this);
        ImageView5.setOnClickListener(this);
        ImageView6.setOnClickListener(this);
        ImageView7.setOnClickListener(this);
        ImageView8.setOnClickListener(this);
        ImageView9.setOnClickListener(this);
        ImageView10.setOnClickListener(this);
        ImageView11.setOnClickListener(this);
        ImageView12.setOnClickListener(this);
        ImageView13.setOnClickListener(this);
        ImageView14.setOnClickListener(this);
        ImageView15.setOnClickListener(this);
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
        if(image1!=-1 && image2!=-1) {
            pasos++;
            int i;
            if (image1 == image2) {
                for (i = 0; i < 12; i++) if (selected[i]){
                    solved[i] = true;
                }
                boolean aux=true;
                for (i = 0; i < 12; i++) if (!solved[i]) aux=false;
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
                        CharSequence text = "Tu manqueo es over 9000 y no se te es permitido subirlo al ranking";
                        int duration = Toast.LENGTH_SHORT; //También puede ser Toast.LENGTH_LONG;
                        Toast.makeText(context, text, duration).show();
                    }
                    else{
                        CharSequence text = "¡¡Has ganado!!";
                        int duration = Toast.LENGTH_SHORT; //También puede ser Toast.LENGTH_LONG;
                        Toast.makeText(context, text, duration).show();
                    }
                }
                for (int pos = 0; pos < 16; pos++) selected[pos] = false;
                image1 = -1;
                image2 = -1;
                text1.setText("numero de pasos: " + String.valueOf(pasos));
            }
            else{
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        for (int pos = 0; pos < 16; pos++) {
                            if (selected[pos]) {
                                voltearCarta(pos);
                            }
                        }
                        for (int pos = 0; pos < 16; pos++) selected[pos] = false;
                        image1 = -1;
                        image2 = -1;
                        text1.setText("numero de pasos: " + String.valueOf(pasos));
                    }
                }, 1000);

            }
        }
    }

    private void pulsarCarta(int i) {
        int auxImage;
        if(selected[i] || solved[i]) return;
        selected[i]=true;
        if(soluciones[i]==-1)soluciones[i] = elegirColor();
        auxImage=soluciones[i];
        if(image1==-1){image1=auxImage;}
        else if(image2==-1){image2=auxImage;}
        CoolImageFlipper c = new CoolImageFlipper(context);
        Drawable d =null;
        d = toDrawable(auxImage);
        c.flipImage(d,toImageView(i));
    }

    private void empezarDeNuevo() {
        for(int i=0;i<16;i++){
            toImageView(i).setImageResource(R.drawable.black);
        }

        for(int i=0;i<16;i++) soluciones[i]=-1;
        for(int i=0;i<16;i++) solved[i]=false;
        for(int i=0;i<16;i++) selected[i]=false;
        for(int i=0;i<8;i++) colores[i]=0;
        image1=-1;image2 = -1;
        pasos=0;text1.setText("numero de pasos: " + String.valueOf(pasos));
    }

    private Drawable toDrawable(int auxImage) {
        switch (auxImage){
            case R.drawable.red:
                return d1;
            case R.drawable.blue:
                return d2;
            case R.drawable.brown:
                return d3;
            case R.drawable.green:
                return d4;
            case R.drawable.yellow:
                return d5;
            case R.drawable.gris:
                return d7;
            case R.drawable.cian:
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
                return R.drawable.red;
            case 1:
                return R.drawable.blue;
            case 2:
                return R.drawable.brown;
            case 3:
                return R.drawable.green;
            case 4:
                return R.drawable.yellow;
            case 5:
                return R.drawable.lila;
            case 6:
                return R.drawable.gris;
            case 7:
                return R.drawable.cian;
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
}
