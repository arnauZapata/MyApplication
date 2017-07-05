package com.arnauzapata.myapplication;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import static android.content.ContentValues.TAG;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link borrarUsuario#newInstance} factory method to
 * create an instance of this fragment.
 */
public class borrarUsuario extends Fragment {

    private static Context context;
    private MyDataBaseHelper1 myDataBaseHelper;
    private EditText editTextUsuari;
    private EditText editTextOldContrasenya;
    private Button buttonAceptar;
    private Button  buttonAtras;

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
        View view = inflater.inflate(R.layout.fragment_borrar_usuario, container, false);
        editTextUsuari = (EditText) view.findViewById(R.id.editTextCambiarContrasenyaUsuario);
        editTextOldContrasenya = (EditText) view.findViewById(R.id.editTextCambiarContrasenyaOldPassword);
        buttonAceptar = (Button) view.findViewById(R.id.buttonCambiarContrasenyaAceptar);
        buttonAtras = (Button) view.findViewById(R.id.buttonAtras);
        myDataBaseHelper = new MyDataBaseHelper1(context);
        myDataBaseHelper.getInstance(context);
        buttonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = editTextUsuari.getText().toString();
                String s1 = editTextOldContrasenya.getText().toString();
                String id = myDataBaseHelper.queryRow(s);
                if(s1.equals(id)){
                    Log.v(TAG,"va todo correcto")  ;
                    myDataBaseHelper.deleteRow(s);
                }
                else Log.v(TAG,"va todo INcorrecto") ;
            }
        });
        buttonAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction trans = getFragmentManager().beginTransaction();
                LoginOtros fragment = new LoginOtros();
                fragment.newInstance(context);
                trans.replace(R.id.fragment_login_container,fragment);
                trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                trans.addToBackStack(null);
                trans.commit();
            }
        });
        return view;
    }

}
