package com.arnauzapata.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class constants extends AppCompatActivity {


    public static final String PREFS_NAME = "Hay que poner algo? o cualquier chorrada esta bien?";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constants);
    }


}
