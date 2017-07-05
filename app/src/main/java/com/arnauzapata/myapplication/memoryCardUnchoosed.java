package com.arnauzapata.myapplication;


import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class memoryCardUnchoosed extends android.app.Fragment {
    private loginInicial.OnFragmentInteractionListener mListener;
    int x;
    int y;
    int whoThis;
    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    public memoryCardUnchoosed(int fragment) {
        whoThis=fragment;
    }



    public void newInstance(int x1, int y1) {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_memory_card_unchoosed, container, false);
        return view;
    }

    public void select(View v){
        memoryCardChoosed fragment = new memoryCardChoosed(whoThis);
        getFragmentManager().beginTransaction().replace(whoThis,fragment);
        getFragmentManager().beginTransaction().commit();
    }

}
