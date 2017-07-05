package com.arnauzapata.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class memory extends AppCompatActivity{


    Context context=this;
    private String TAG = "Memory";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);
        jocMemory firstFragment = new jocMemory(context);
        //firstFragment.newInstance(context);
        getFragmentManager().beginTransaction().add(R.id.fragment_memory_container, firstFragment).commit();

    }
}
