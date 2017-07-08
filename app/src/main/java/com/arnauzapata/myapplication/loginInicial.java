package com.arnauzapata.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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


public class loginInicial extends Fragment {
    private OnFragmentInteractionListener mListener;
    
    private EditText editText;
    private Button buttonCreate;
    private Button buttonQuery;
    private EditText editText1;
    private MyDataBaseHelper1 myDataBaseHelper;
    private Context context;
    private String TAG = "loginInicial";
    private Button buttonBorrar;
    private Button buttonCambiarContraseña;

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    public loginInicial() {
        // Required empty public constructor
    }

    public loginInicial newInstance(Context c) {
        loginInicial fragment = new loginInicial();
        this.context=c;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
            View view = inflater.inflate(R.layout.fragment_login_inicial, container, false);

            editText1 = (EditText) view.findViewById(R.id.editTextLoginUser);
            editText = (EditText) view.findViewById(R.id.editTextLoginPass);
            buttonCreate = (Button) view.findViewById(R.id.buttonSignIn);
            buttonQuery = (Button) view.findViewById(R.id.buttonLogIn);
            buttonBorrar = (Button) view.findViewById(R.id.buttonBorrar);
            buttonCambiarContraseña = (Button) view.findViewById(R.id.buttonOtros);
            myDataBaseHelper = new MyDataBaseHelper1(context);
            myDataBaseHelper.getInstance(context);
            buttonCreate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String s1 = editText1.getText().toString();
                    String s = editText.getText().toString();
                    long id = myDataBaseHelper.createRow(s1,s);
                    CharSequence text = "registro con exito";
                    int duration = Toast.LENGTH_SHORT; //También puede ser Toast.LENGTH_LONG;
                    Toast toast = Toast.makeText(context, text, duration);
                    toast.show();
                    Toast.makeText(context, text, duration).show();
                    //.makeText(view.getContext(),"We created a row with "+id+"!", Toast.LENGTH_SHORT).show();
                }
            });


            buttonQuery.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String s = editText1.getText().toString();
                    String s1 = editText.getText().toString();
                    String id = myDataBaseHelper.queryRow(s);
                    if(s1.equals(id)){
                        Log.v(TAG,"va todo correcto")  ;
                        Intent i = new Intent(context, memory.class);

                        memory.putUser(s);
                        startActivity(i);
                    }
                    else{
                        CharSequence text = "usuario o contraseña erroneos";
                        int duration = Toast.LENGTH_SHORT; //También puede ser Toast.LENGTH_LONG;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        Toast.makeText(context, text, duration).show();
                    }
                }
            });
            buttonBorrar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String s = editText1.getText().toString();
                    String s1 = editText.getText().toString();
                    String id = myDataBaseHelper.queryRow(s);
                    if(s1.equals(id)){
                        myDataBaseHelper.deleteRow(s);
                        CharSequence text = "usuario eliminado";
                        int duration = Toast.LENGTH_SHORT; //También puede ser Toast.LENGTH_LONG;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        Toast.makeText(context, text, duration).show();

                    }
                    else{
                        CharSequence text = "usuario o contraseña erroneos";
                        int duration = Toast.LENGTH_SHORT; //También puede ser Toast.LENGTH_LONG;
                        Toast toast = Toast.makeText(context, text, duration);
                        toast.show();
                        Toast.makeText(context, text, duration).show();
                    }
                }
            });
        buttonCambiarContraseña.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        String s = editText1.getText().toString();
                        String s1 = editText.getText().toString();
                        FragmentTransaction trans = getFragmentManager().beginTransaction();
                        cambiarContrasenya fragment = new cambiarContrasenya();
                        String id = myDataBaseHelper.queryRow(s);
                        if(s1.equals(id)) {
                            fragment.newInstance(context, s, s1);
                            trans.replace(R.id.fragment_login_container, fragment);
                            trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                            trans.addToBackStack(null);
                            trans.commit();
                        }
                        else{
                            CharSequence text = "usuario o contraseña erroneos";
                            int duration = Toast.LENGTH_SHORT; //También puede ser Toast.LENGTH_LONG;
                            Toast toast = Toast.makeText(context, text, duration);
                            toast.show();
                            Toast.makeText(context, text, duration).show();
                        }
                    }
                });
            return view;
        }


    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


}
