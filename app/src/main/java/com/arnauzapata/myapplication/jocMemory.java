package com.arnauzapata.myapplication;

import android.app.Fragment;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.material.joanbarroso.flipper.CoolImageFlipper;

import java.util.Random;


public class jocMemory extends Fragment implements View.OnClickListener {

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
    private ImageView ImageView0;
    private Button button1;
    TextView text1;

    int[] soluciones =new int[12];
    int[] colores =new int[6];
    boolean [] solved=new boolean[12];
    boolean [] selected=new boolean[12];
    int image1; int image2;


    Context context;
    private boolean ocupado;
    private boolean despierto;
    private int pasos =0;
    private Drawable d1;
    private Drawable d2;
    private Drawable d3;
    private Drawable d4;
    private Drawable d5;
    private Drawable d6;

    public jocMemory() {
        for(int i=0;i<12;i++) soluciones[i]=-1;
        for(int i=0;i<12;i++) solved[i]=false;
        for(int i=0;i<12;i++) selected[i]=false;
        for(int i=0;i<6;i++) colores[i]=0;
        image1=-1;image2 = -1;
    }
    public jocMemory(Context c) {
        // Required empty public constructor
        for(int i=0;i<12;i++) soluciones[i]=-1;
        for(int i=0;i<12;i++) solved[i]=false;
        for(int i=0;i<12;i++) selected[i]=false;
        for(int i=0;i<6;i++) colores[i]=0;
        image1=-1;image2 = -1;
        ocupado=false;
        context=c;

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
        View view=inflater.inflate(R.layout.fragment_joc_memory, container, false);
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
        return view;
    }


    @Override
    public void onClick(View v) {
        CoolImageFlipper c = new CoolImageFlipper(context);
        Drawable d;
        int auxImage=-1;
        switch (v.getId()){
            case R.id.imageViewMemory0:
                if(selected[0] || solved[0] || ocupado) break;
                selected[0]=true;
               if(soluciones[0]==-1) soluciones[0] = elegirColor();
                auxImage=soluciones[0];
                d = toDrawable(auxImage);
                c.flipImage(d,ImageView0);
                break;
            case R.id.imageViewMemory1:
                if(selected[1] || solved[1] || ocupado) break;
                selected[1]=true;
                if(soluciones[1]==-1)soluciones[1] = elegirColor();
                auxImage=soluciones[1];
                d = toDrawable(auxImage);
                c.flipImage(d,ImageView1);
                break;
            case R.id.imageViewMemory2:
                if(selected[2] || solved[2] || ocupado) break;
                selected[2]=true;
                if(soluciones[2]==-1)soluciones[2] = elegirColor();
                auxImage=soluciones[2];
                d = toDrawable(auxImage);
                c.flipImage(d,ImageView2);
                break;
            case R.id.imageViewMemory3:
                if(selected[3] || solved[3] || ocupado) break;
                selected[3]=true;
                if(soluciones[3]==-1)soluciones[3] = elegirColor();
                auxImage=soluciones[3];
                d = toDrawable(auxImage);
                c.flipImage(d,ImageView3);
                break;
            case R.id.imageViewMemory4:
                if(selected[4] || solved[4] || ocupado) break;
                selected[4]=true;
                if(soluciones[4]==-1)soluciones[4] = elegirColor();
                 auxImage=soluciones[4];
                d = toDrawable(auxImage);
                c.flipImage(d,ImageView4);
                break;
            case R.id.imageViewMemory5:
                if(selected[5] || solved[5] || ocupado) break;
                selected[5]=true;
                if(soluciones[5]==-1)soluciones[5] = elegirColor();
                 auxImage=soluciones[5];
                d = toDrawable(auxImage);
                c.flipImage(d,ImageView5);
                break;
            case R.id.imageViewMemory6:
                if(selected[6] || solved[6] || ocupado) break;
                selected[6]=true;
                if(soluciones[6]==-1)soluciones[6] = elegirColor();
                 auxImage=soluciones[6];
                d = toDrawable(auxImage);
                c.flipImage(d,ImageView6);
                break;
            case R.id.imageViewMemory7:
                if(selected[7] || solved[7] || ocupado) break;
                selected[7]=true;
                if(soluciones[7]==-1)soluciones[7] = elegirColor();
                 auxImage=soluciones[7];
                d = toDrawable(auxImage);
                c.flipImage(d,ImageView7);
                break;
            case R.id.imageViewMemory8:
                if(selected[8] || solved[8] || ocupado) break;
                selected[8]=true;
                if(soluciones[8]==-1)soluciones[8] = elegirColor();
                 auxImage=soluciones[8];
                d = toDrawable(auxImage);
                c.flipImage(d,ImageView8);
                break;
            case R.id.imageViewMemory9:
                if(selected[9] || solved[9] || ocupado) break;
                selected[9]=true;
                if(soluciones[9]==-1)soluciones[9] = elegirColor();
                 auxImage=soluciones[9];
                d = toDrawable(auxImage);
                c.flipImage(d,ImageView9);
                break;
            case R.id.imageViewMemory10:
                if(selected[10] || solved[10] || ocupado) break;
                selected[10]=true;
                if(soluciones[10]==-1)soluciones[10] = elegirColor();
                 auxImage=soluciones[10];
                d = toDrawable(auxImage);
                c.flipImage(d,ImageView10);
                break;
            case R.id.imageViewMemory11:
                if(selected[11] || solved[11] || ocupado) break;
                selected[11]=true;
                if(soluciones[11]==-1)soluciones[11] = elegirColor();
                 auxImage=soluciones[11];
                d = toDrawable(auxImage);
                 c.flipImage(d,ImageView11);
            break;
            case R.id.buttonMemory1:
                empezarDeNuevo();
                break;
        }
        if(image1==-1){image1=auxImage;}
        else if(image2==-1){image2=auxImage;}

        if(image1!=-1 && image2!=-1) {
            int i;
            if (image1 == image2) {
                for (i = 0; i < 12; i++) if (selected[i]) solved[i] = true;
                boolean aux=true;
                for (i = 0; i < 12; i++) if (!solved[i]) aux=false;
                //Intent in = new Intent(context, ranking.class);
                if(aux);// startActivity(in);
            }
            else{
                ocupado=true;despierto=false;
                dejarPasarTiempo();
                while(!despierto);
                for (i = 0; i < 12; i++) if (selected[i]) voltearCarta(i);

            }
            for (i = 0; i < 12; i++) selected[i] = false;
            image1 = -1;
            image2 = -1;
            pasos++;
            text1.setText("numero de pasos" + String.valueOf(pasos));
            ocupado=false;
        }
    }

    private void empezarDeNuevo() {
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

        for(int i=0;i<12;i++) soluciones[i]=-1;
        for(int i=0;i<12;i++) solved[i]=false;
        for(int i=0;i<12;i++) selected[i]=false;
        for(int i=0;i<6;i++) colores[i]=0;
        image1=-1;image2 = -1;
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
            case R.drawable.lila:
                return d6;
        }
        return null;
    }

    private int elegirColor() {
        Random rand=new Random();
        int num;
        do {num = rand.nextInt(6);}while(colores[num]>=2);colores[num]++; //busca numeros al azar hasta que encuentra uno donde no hayan sido asignados 2 o mas colores, entonces añade uno al color asignado
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
        }
        return R.drawable.black;
    }


    public void dejarPasarTiempo(){
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                despierto=true;
            }
        }).start();

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

        }


    }
}
