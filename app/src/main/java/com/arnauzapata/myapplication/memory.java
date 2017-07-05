package com.arnauzapata.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.FrameLayout;

public class memory extends AppCompatActivity{
    View fragment_0_0;View fragment_0_1;View fragment_0_2;
    View fragment_1_0;View fragment_1_1;View fragment_1_2;
    View fragment_2_0;View fragment_2_1;View fragment_2_2;
    View fragment_3_0;View fragment_3_1;View fragment_3_2;
    android.app.Fragment fragment;

    private android.app.FragmentManager fragmentManager = getFragmentManager();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);

        FrameLayout frame = new FrameLayout(this);

        fragment= new memoryCardUnchoosed(R.id.fragment_memory_0_0);
        getFragmentManager().beginTransaction().add(R.id.fragment_memory_0_0, fragment).commit();

        fragment= new memoryCardUnchoosed(R.id.fragment_memory_0_1);
        getFragmentManager().beginTransaction().add(R.id.fragment_memory_0_1, fragment).commit();

        fragment= new memoryCardUnchoosed(R.id.fragment_memory_0_2);
        getFragmentManager().beginTransaction().add(R.id.fragment_memory_0_2, fragment).commit();

        fragment= new memoryCardUnchoosed(R.id.fragment_memory_1_0);
        getFragmentManager().beginTransaction().add(R.id.fragment_memory_1_0, fragment).commit();

        fragment= new memoryCardUnchoosed(R.id.fragment_memory_1_1);
        getFragmentManager().beginTransaction().add(R.id.fragment_memory_1_1, fragment).commit();

        fragment= new memoryCardUnchoosed(R.id.fragment_memory_1_2);
        getFragmentManager().beginTransaction().add(R.id.fragment_memory_1_2, fragment).commit();

        fragment= new memoryCardUnchoosed(R.id.fragment_memory_2_0);
        getFragmentManager().beginTransaction().add(R.id.fragment_memory_2_0, fragment).commit();

        fragment= new memoryCardUnchoosed(R.id.fragment_memory_2_1);
        getFragmentManager().beginTransaction().add(R.id.fragment_memory_2_1, fragment).commit();

        fragment= new memoryCardUnchoosed(R.id.fragment_memory_2_2);
        getFragmentManager().beginTransaction().add(R.id.fragment_memory_2_2, fragment).commit();

        fragment= new memoryCardUnchoosed(R.id.fragment_memory_3_0);
        getFragmentManager().beginTransaction().add(R.id.fragment_memory_3_0, fragment).commit();

        fragment= new memoryCardUnchoosed(R.id.fragment_memory_3_1);
        getFragmentManager().beginTransaction().add(R.id.fragment_memory_3_1, fragment).commit();

        fragment= new memoryCardUnchoosed(R.id.fragment_memory_3_2);
        getFragmentManager().beginTransaction().add(R.id.fragment_memory_3_2, fragment).commit();

        fragment= new memoryCardUnchoosed(R.id.fragment_memory_3_2);
        getFragmentManager().beginTransaction().add(R.id.fragment_memory_3_2, fragment).commit();


    }

    public void unSelect(View v) {


    }

    public void select(View v) {

    }
}
