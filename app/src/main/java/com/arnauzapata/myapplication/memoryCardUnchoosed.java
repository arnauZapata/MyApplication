package com.arnauzapata.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class memoryCardUnchoosed extends Fragment {

    int x;
    int y;

    public memoryCardUnchoosed() {

    }

    public memoryCardUnchoosed(int x1, int y1) {
        x=x1;y=y1;
    }


    public void newInstance(int x1, int y1) {
        memoryCardUnchoosed fragment = new memoryCardUnchoosed();
        ;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_memory_card_unchoosed, container, false);
    }

    public void choose(){
        FragmentTransaction trans = getFragmentManager().beginTransaction();
        loginInicial fragment = new loginInicial();
        trans.replace(R.id.fragment_login_container,fragment);
        trans.commit();
    }

}
