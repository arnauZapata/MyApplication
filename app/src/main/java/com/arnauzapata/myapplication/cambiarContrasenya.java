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


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link cambiarContrasenya#newInstance} factory method to
 * create an instance of this fragment.
 */
public class cambiarContrasenya extends Fragment {

    private static Context context;
    private EditText editTextUsuari;
    private EditText editTextOldContrasenya;
    private EditText editTextNewContrasenya;
    private Button buttonAceptar;
    private Button  buttonAtras;
    private MyDataBaseHelper1 myDataBaseHelper;
    private String TAG="cambiarContrasenya";


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
        editTextOldContrasenya = (EditText) view.findViewById(R.id.editTextCambiarContrasenyaOldPassword);
        editTextNewContrasenya = (EditText) view.findViewById(R.id.editTextCambiarContrasenyaNewPassword);
        buttonAceptar = (Button) view.findViewById(R.id.buttonCambiarContrasenyaAceptar);
        buttonAtras = (Button) view.findViewById(R.id.buttonAtras);
        myDataBaseHelper = new MyDataBaseHelper1(context);
        myDataBaseHelper.getInstance(context);
        buttonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = editTextUsuari.getText().toString();
                String oldPassW = editTextOldContrasenya.getText().toString();
                String newPassW = editTextNewContrasenya.getText().toString();
                String id = myDataBaseHelper.queryRow(user);
                if(oldPassW.equals(id)){
                    myDataBaseHelper.updateRow(user,newPassW);
                    FragmentTransaction trans = getFragmentManager().beginTransaction();
                    loginInicial fragment = new loginInicial();
                    fragment.newInstance(context);
                    trans.replace(R.id.fragment_login_container,fragment);
                    trans.commit();
                    Log.v(TAG,"va todo correcto")  ;                  //HACE ALGO
                }
                else Log.v(TAG,"va todo INcorrecto") ;
                //.makeText(view.getContext(),"We created a row with "+id+"!", Toast.LENGTH_SHORT).show();
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
                //.makeText(view.getContext(),"We created a row with "+id+"!", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
