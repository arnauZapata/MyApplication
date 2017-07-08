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
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link cambiarContrasenya#newInstance} factory method to
 * create an instance of this fragment.
 */
public class cambiarContrasenya extends Fragment {

    private static Context context;
    private EditText editTextNewContrasenya;
    private Button buttonAceptar;
    private Button  buttonAtras;
    private MyDataBaseHelper1 myDataBaseHelper;
    private String TAG="cambiarContrasenya";
    private static String user;


    public cambiarContrasenya() {
        // Required empty public constructor
    }

    public static cambiarContrasenya newInstance(Context c, String u, String p) {
        cambiarContrasenya fragment = new cambiarContrasenya();
        context=c;
        user=u;
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
        editTextNewContrasenya = (EditText) view.findViewById(R.id.editTextCambiarContrasenyaNewPassword);
        buttonAceptar = (Button) view.findViewById(R.id.buttonCambiarContrasenyaAceptar);
        buttonAtras = (Button) view.findViewById(R.id.buttonAtras);
        myDataBaseHelper = new MyDataBaseHelper1(context);
        myDataBaseHelper.getInstance(context);
        buttonAceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String newPassW = editTextNewContrasenya.getText().toString();

                    myDataBaseHelper.updateRow(user,newPassW);
                    CharSequence text = "contraseña cambiada con exito";
                    int duration = Toast.LENGTH_SHORT; //También puede ser Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    Toast.makeText(context, text, duration).show();

                    FragmentTransaction trans = getFragmentManager().beginTransaction();
                    loginInicial fragment = new loginInicial();
                    fragment.newInstance(context);
                    trans.replace(R.id.fragment_login_container,fragment);
                    trans.commit();
            }
        });
        buttonAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction trans = getFragmentManager().beginTransaction();
                loginInicial fragment = new loginInicial();
                fragment.newInstance(context);
                trans.replace(R.id.fragment_login_container,fragment);
                trans.commit();
                Log.v(TAG,"va todo correcto")  ;
                //.makeText(view.getContext(),"We created a row with "+id+"!", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

}
