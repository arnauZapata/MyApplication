package com.arnauzapata.myapplication;

import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class memory extends AppCompatActivity implements View.OnClickListener {
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
        fragment_0_0= findViewById(R.id.fragment_memory_0_0);
        fragment_0_1= findViewById(R.id.fragment_memory_0_1);
        fragment_0_2= findViewById(R.id.fragment_memory_0_2);
        fragment_1_0= findViewById(R.id.fragment_memory_1_0);
        fragment_1_1= findViewById(R.id.fragment_memory_1_1);
        fragment_1_2= findViewById(R.id.fragment_memory_1_2);
        fragment_2_0= findViewById(R.id.fragment_memory_2_0);
        fragment_2_1= findViewById(R.id.fragment_memory_2_1);
        fragment_2_2= findViewById(R.id.fragment_memory_2_2);
        fragment_3_0= findViewById(R.id.fragment_memory_3_0);
        fragment_3_1= findViewById(R.id.fragment_memory_3_1);
        fragment_3_2= findViewById(R.id.fragment_memory_3_2);

        fragment_0_0.setOnClickListener(this);
        fragment_0_1.setOnClickListener(this);
        fragment_0_2.setOnClickListener(this);
        fragment_1_0.setOnClickListener(this);
        fragment_1_1.setOnClickListener(this);
        fragment_1_2.setOnClickListener(this);
        fragment_2_0.setOnClickListener(this);
        fragment_2_1.setOnClickListener(this);
        fragment_2_2.setOnClickListener(this);
        fragment_3_0.setOnClickListener(this);
        fragment_3_1.setOnClickListener(this);
        fragment_3_2.setOnClickListener(this);

        fragment = new memoryCardUnchoosed();
        fragment.newInstance(0,0);

        fragmentManager.beginTransaction().replace(R.id.fragment_memory_0_0, fragment);
        fragmentManager.beginTransaction().commit();


    }


    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.fragment_memory_0_0:
                break;
            case R.id.fragment_memory_0_1:
                break;
            case R.id.fragment_memory_0_2:
                break;
            case R.id.fragment_memory_1_0:
                break;
            case R.id.fragment_memory_1_1:
                break;
            case R.id.fragment_memory_1_2:
                break;
            case R.id.fragment_memory_2_0:
                break;
            case R.id.fragment_memory_2_1:
                break;
            case R.id.fragment_memory_2_2:
                break;
            case R.id.fragment_memory_3_0:
                break;
            case R.id.fragment_memory_3_1:
                break;
            case R.id.fragment_memory_3_2:
                break;
        }
    }
}
