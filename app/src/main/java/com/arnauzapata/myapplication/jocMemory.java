package com.arnauzapata.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.material.joanbarroso.flipper.CoolImageFlipper;


public class jocMemory extends android.app.Fragment implements View.OnClickListener {



    private static final String TAG = "Joc Memory";
    private OnFragmentInteractionListener mListener;
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

    int[] soluciones =new int[12];
    boolean [] solved=new boolean[12];
    boolean [] selected=new boolean[12];
    int image1; int image2;


    Context context;

    public jocMemory() {
        for(int i=0;i<12;i++) soluciones[i]=R.drawable.red;
        for(int i=0;i<12;i++) solved[i]=false;
        for(int i=0;i<12;i++) selected[i]=false;
        image1=-1;image2 = -1;
    }
    public jocMemory(Context c) {
        // Required empty public constructor
        //for(int i=0;i<12;i++) soluciones[i]=R.drawable.red;
        soluciones[0] = soluciones[1]=R.drawable.red;
        soluciones[2] = soluciones[3]=R.drawable.blue;
        soluciones[4] = soluciones[5]=R.drawable.brown;
        soluciones[6] = soluciones[7]=R.drawable.green;
        soluciones[8] = soluciones[9]=R.drawable.yellow;
        soluciones[10] = soluciones[11]=R.drawable.lila;
        for(int i=0;i<12;i++) solved[i]=false;
        for(int i=0;i<12;i++) selected[i]=false;
        image1=-1;image2 = -1;
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
    
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onClick(View v) {
        CoolImageFlipper c = new CoolImageFlipper(context);
        Drawable d;
        jocMemory firstFragment;
        int auxImage;
        switch (v.getId()){
            case R.id.imageViewMemory0:
                if(selected[0] || solved[0]) break;
                selected[0]=true;
                auxImage=soluciones[0];
                if(image1==-1){image1=auxImage;}
                else if(image2==-1){image2=auxImage;}
                d = getResources().getDrawable(auxImage);
                c.flipImage(d,ImageView0);
                break;
            case R.id.imageViewMemory1:
                if(selected[1] || solved[1]) break;
                selected[1]=true;
                auxImage=soluciones[1];
                if(image1==-1){image1=auxImage;}
                else if(image2==-1){image2=auxImage;}
                d = getResources().getDrawable(auxImage);
                c.flipImage(d,ImageView1);
                break;
            case R.id.imageViewMemory2:
                if(selected[2] || solved[2]) break;
                selected[2]=true;
                auxImage=soluciones[2];
                if(image1==-1){image1=auxImage;}
                else if(image2==-1){image2=auxImage;}
                d = getResources().getDrawable(auxImage);
                c.flipImage(d,ImageView2);
                break;
            case R.id.imageViewMemory3:
                if(selected[3] || solved[3]) break;
                selected[3]=true;
                auxImage=soluciones[3];
                if(image1==-1){image1=auxImage;}
                else if(image2==-1){image2=auxImage;}
                d = getResources().getDrawable(auxImage);
                c.flipImage(d,ImageView3);
                break;
            case R.id.imageViewMemory4:
                if(selected[4] || solved[4]) break;
                selected[4]=true;
                auxImage=soluciones[4];
                if(image1==-1){image1=auxImage;}
                else if(image2==-1){image2=auxImage;}
                d = getResources().getDrawable(auxImage);
                c.flipImage(d,ImageView4);
                break;
            case R.id.imageViewMemory5:
                if(selected[5] || solved[5]) break;
                selected[5]=true;
                auxImage=soluciones[5];
                if(image1==-1){image1=auxImage;}
                else if(image2==-1){image2=auxImage;}
                d = getResources().getDrawable(auxImage);
                c.flipImage(d,ImageView5);
                break;
            case R.id.imageViewMemory6:
                if(selected[6] || solved[6]) break;
                selected[6]=true;
                auxImage=soluciones[6];
                if(image1==-1){image1=auxImage;}
                else if(image2==-1){image2=auxImage;}
                d = getResources().getDrawable(auxImage);
                c.flipImage(d,ImageView6);
                break;
            case R.id.imageViewMemory7:
                if(selected[7] || solved[7]) break;
                selected[7]=true;
                auxImage=soluciones[7];
                if(image1==-1){image1=auxImage;}
                else if(image2==-1){image2=auxImage;}
                d = getResources().getDrawable(auxImage);
                c.flipImage(d,ImageView7);
                break;
            case R.id.imageViewMemory8:
                if(selected[8] || solved[8]) break;
                selected[8]=true;
                auxImage=soluciones[8];
                if(image1==-1){image1=auxImage;}
                else if(image2==-1){image2=auxImage;}
                d = getResources().getDrawable(auxImage);
                c.flipImage(d,ImageView8);
                break;
            case R.id.imageViewMemory9:
                if(selected[9] || solved[9]) break;
                selected[9]=true;
                auxImage=soluciones[9];
                if(image1==-1){image1=auxImage;}
                else if(image2==-1){image2=auxImage;}
                d = getResources().getDrawable(auxImage);
                c.flipImage(d,ImageView9);
                break;
            case R.id.imageViewMemory10:
                if(selected[10] || solved[10]) break;
                selected[10]=true;
                auxImage=soluciones[10];
                if(image1==-1){image1=auxImage;}
                else if(image2==-1){image2=auxImage;}
                d = getResources().getDrawable(auxImage);
                c.flipImage(d,ImageView10);
                break;
            case R.id.imageViewMemory11:
                if(selected[11] || solved[11]) break;
                selected[11]=true;
                auxImage=soluciones[11];
                if(image1==-1){image1=auxImage;}
                else if(image2==-1){image2=auxImage;}
                d = getResources().getDrawable(auxImage);
                c.flipImage(d,ImageView11);
                break;
        }
        Log.v(TAG,String.valueOf(image1)+ "-" + String.valueOf(image2));
        if(image1!=-1 && image2!=-1){
            int i;
            if(image1 == image2){
                Log.v(TAG,"aqui pasa algo raro");
                for(i=0;i<12;i++)if(selected[i]) {
                    Log.v(TAG,"aqui pasa algo raro");
                    solved[i]=true;
                }
            }
            else{
                Log.v(TAG,"tendria que funcionar");
                for(i=0;i<12;i++)if(selected[i]){
                    Log.v(TAG,"tendria que funcionar");
                    voltearCarta(i);
                }
            }
            for(i=0;i<12;i++)selected[i]=false;
            image1=-1;image2=-1;
        }

        //firstFragment = new jocMemory(context);
        //getFragmentManager().beginTransaction().add(R.id.fragment_memory_container, firstFragment).commit();

    }

    private void voltearCarta(int i) {
        CoolImageFlipper c = new CoolImageFlipper(context);
        Drawable d= getResources().getDrawable(R.drawable.black);
        switch (i){
            case 0:
                Log.v(TAG,"tendria que funcionar 0");
                c.flipImage(d,ImageView0);
                break;
            case 1:
                Log.v(TAG,"tendria que funcionar 1");
                c.flipImage(d,ImageView1);
                break;
            case 2:
                Log.v(TAG,"tendria que funcionar 2");
                c.flipImage(d,ImageView2);
                break;
            case 3:
                Log.v(TAG,"tendria que funcionar 3");
                c.flipImage(d,ImageView3);
                break;
            case 4:
                Log.v(TAG,"tendria que funcionar 4");
                c.flipImage(d,ImageView4);
                break;
            case 5:
                Log.v(TAG,"tendria que funcionar 5");
                c.flipImage(d,ImageView5);
                break;
            case 6:
                Log.v(TAG,"tendria que funcionar 6");
                c.flipImage(d,ImageView6);
                break;
            case 7:
                Log.v(TAG,"tendria que funcionar 7");
                c.flipImage(d,ImageView7);
                break;
            case 8:
                Log.v(TAG,"tendria que funcionar 8");
                c.flipImage(d,ImageView8);
                break;
            case 9:
                Log.v(TAG,"tendria que funcionar 9");
                c.flipImage(d,ImageView9);
                break;
            case 10:
                Log.v(TAG,"tendria que funcionar 10");
                c.flipImage(d,ImageView10);
                break;
            case 11:
                Log.v(TAG,"tendria que funcionar 11");
                c.flipImage(d,ImageView11);
                break;

        }
    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
