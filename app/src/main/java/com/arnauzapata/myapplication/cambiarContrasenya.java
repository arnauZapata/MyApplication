package com.arnauzapata.myapplication;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link cambiarContrasenya#newInstance} factory method to
 * create an instance of this fragment.
 */
public class cambiarContrasenya extends Fragment {

    private static Context context;


    public cambiarContrasenya() {
        // Required empty public constructor
    }

    public static cambiarContrasenya newInstance(Context c) {
        cambiarContrasenya fragment = new cambiarContrasenya();
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
        View view = inflater.inflate(R.layout.fragment_cambiar_contrasenya, container, false);
        editTextUsuari = (EditText) view.findViewById(R.id.editTextCambiarContrasenyaUsuario);
        editTextOldContrasenya = (EditText) view.findViewById(R.id.editTextLoginPass);
        editTextNewContrasenya = (EditText) view.findViewById(R.id.editTextLoginPass);
        buttonAceptar = (Button) view.findViewById(R.id.buttonSignIn);
        buttonAtras = (Button) view.findViewById(R.id.buttonLogIn);
        return view;
    }

}
