package com.arnauzapata.myapplication;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
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
    private ImageView ImageView12;

    int [] soluciones;
    boolean [] solved;
    boolean [] selected;
    int image1; int image2;


    Context context;

    public jocMemory() {
        // Required empty public constructor
    }
    public jocMemory(Context c) {
        // Required empty public constructor
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


        ImageView1.setImageResource(R.drawable.images);
       // ImageView1.setI

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
        Drawable d=null;
        jocMemory firstFragment;
        switch (v.getId()){
            case R.id.imageViewMemory1:
                c.flipImage(d,ImageView1);
                break;
            case R.id.imageViewMemory2:
                c.flipImage(d,ImageView2);
                break;
            case R.id.imageViewMemory3:
                c.flipImage(d,ImageView3);
                break;
            case R.id.imageViewMemory4:
                c.flipImage(d,ImageView4);
                break;
            case R.id.imageViewMemory5:
                c.flipImage(d,ImageView5);
                break;
            case R.id.imageViewMemory6:
                c.flipImage(d,ImageView6);
                break;
            case R.id.imageViewMemory7:
                c.flipImage(d,ImageView7);
                break;
            case R.id.imageViewMemory8:
                c.flipImage(d,ImageView8);
                break;
            case R.id.imageViewMemory9:
                c.flipImage(d,ImageView9);
                break;
            case R.id.imageViewMemory10:
                c.flipImage(d,ImageView10);
                break;
            case R.id.imageViewMemory11:
                c.flipImage(d,ImageView11);
                break;
            case R.id.imageViewMemory12:
                c.flipImage(d,ImageView12);
                break;

        }

        firstFragment = new jocMemory(context);
        getFragmentManager().beginTransaction().add(R.id.fragment_memory_container, firstFragment).commit();

    }


    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
