package com.arnauzapata.myapplication;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class memory extends AppCompatActivity{


    private static String user=null;
    Context context=this;
    private String TAG = "Memory";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);
        user=getIntent().getStringExtra("user");
        jocMemory firstFragment = new jocMemory(context,user);
        //firstFragment.newInstance(context);
        getFragmentManager().beginTransaction().add(R.id.fragment_memory_container, firstFragment).commit();

    }

    public static void putUser(String s) {
        user=s;
    }
}
