package com.arnauzapata.myapplication;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link borrarUsuario#newInstance} factory method to
 * create an instance of this fragment.
 */
public class borrarUsuario extends Fragment {

    private static Context context;


    public borrarUsuario() {
        // Required empty public constructor
    }

    public static borrarUsuario newInstance(Context c) {
        borrarUsuario fragment = new borrarUsuario();
        context=c;
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
        return inflater.inflate(R.layout.fragment_borrar_usuario, container, false);
    }

}
