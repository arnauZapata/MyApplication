package com.arnauzapata.myapplication;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class memory extends AppCompatActivity{
    View fragment_0_0;View fragment_0_1;View fragment_0_2;
    View fragment_1_0;View fragment_1_1;View fragment_1_2;
    View fragment_2_0;View fragment_2_1;View fragment_2_2;
    View fragment_3_0;View fragment_3_1;View fragment_3_2;
    memoryCardUnchoosed fragment;

    private android.app.FragmentManager fragmentManager = getFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);
        FragmentTransaction trans = getFragmentManager().beginTransaction();
/*
        fragment= new memoryCardUnchoosed(0,0);
        trans.add(R.id.fragment_memory_0_0, fragment);
        trans.commit();

        fragment= new memoryCardUnchoosed(0,1);
        trans.add(R.id.fragment_memory_0_1, fragment);
        trans.commit();

        fragment= new memoryCardUnchoosed(0,2);
        trans.add(R.id.fragment_memory_0_2, fragment);
        trans.commit();

        fragment= new memoryCardUnchoosed(1,0);
        trans.add(R.id.fragment_memory_1_0, fragment);
        trans.commit();

        fragment= new memoryCardUnchoosed(1,1);
        trans.add(R.id.fragment_memory_1_1, fragment);
        trans.commit();

        fragment= new memoryCardUnchoosed(1,2);
        trans.add(R.id.fragment_memory_1_2, fragment);
        trans.commit();

        fragment= new memoryCardUnchoosed(2,0);
        trans.add(R.id.fragment_memory_2_0, fragment);
        trans.commit();

        fragment= new memoryCardUnchoosed(2,1);
        trans.add(R.id.fragment_memory_2_1, fragment);
        trans.commit();

        fragment= new memoryCardUnchoosed(2,2);
        trans.add(R.id.fragment_memory_2_2, fragment);
        trans.commit();


        fragment= new memoryCardUnchoosed(3,0);
        trans.add(R.id.fragment_memory_3_0, fragment);
        trans.commit();

        fragment= new memoryCardUnchoosed(3,1);
        trans.add(R.id.fragment_memory_3_1, fragment);
        trans.commit();

        fragment= new memoryCardUnchoosed(3,2);
        trans.add(R.id.fragment_memory_3_2, fragment);
        trans.commit();*/


    }
}
