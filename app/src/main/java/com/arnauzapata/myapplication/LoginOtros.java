package com.arnauzapata.myapplication;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link LoginOtros.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link LoginOtros#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LoginOtros extends Fragment {
    Context context;

    private OnFragmentInteractionListener mListener;
    private Button buttonCambiar;
    private Button buttonBorrar;
    private Button buttonAtras;

    public LoginOtros() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login_otros, container, false);
        buttonCambiar = (Button) view.findViewById(R.id.buttonCambiarContrasenya);
        buttonBorrar = (Button) view.findViewById(R.id.buttonBorrarUsuario);
        buttonAtras = (Button) view.findViewById(R.id.buttonAtras);
        buttonCambiar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction trans = getFragmentManager().beginTransaction();
                cambiarContrasenya fragment = new cambiarContrasenya();
                fragment.newInstance(context);
                trans.replace(R.id.fragment_login_container,fragment);
                trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                trans.addToBackStack(null);
                trans.commit();
                //.makeText(view.getContext(),"We created a row with "+id+"!", Toast.LENGTH_SHORT).show();
            }
        });
        buttonBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction trans = getFragmentManager().beginTransaction();
                borrarUsuario fragment = new borrarUsuario();
                fragment.newInstance(context);
                trans.replace(R.id.fragment_login_container,fragment);
                trans.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                trans.addToBackStack(null);
                trans.commit();
                //.makeText(view.getContext(),"We created a row with "+id+"!", Toast.LENGTH_SHORT).show();
            }
        });
        buttonAtras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction trans = getFragmentManager().beginTransaction();
                loginInicial fragment = new loginInicial();
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

    public LoginOtros newInstance(Context c) {
        LoginOtros fragment = new LoginOtros();
        context=c;
        return fragment;
    }

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
