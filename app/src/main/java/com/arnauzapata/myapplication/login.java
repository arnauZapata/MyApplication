package com.arnauzapata.myapplication;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;


public class login extends AppCompatActivity {
    private FragmentManager fragmentManager=getSupportFragmentManager();
    Context context=this;

    private final String TAG = "MainActivity";
    private MyDataBaseHelper1 myDataBaseHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        loginInicial firstFragment = new loginInicial();
        firstFragment.newInstance(context);
        fragmentManager.beginTransaction().add(R.id.fragment_login_container, firstFragment).commit();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myDataBaseHelper.close();
        Log.v(TAG,"onDestroy()");
    }

}
