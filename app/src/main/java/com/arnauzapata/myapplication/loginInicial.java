package com.arnauzapata.myapplication;

import android.content.Context;
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


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link loginInicial.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link loginInicial#newInstance} factory method to
 * create an instance of this fragment.
 */
public class loginInicial extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";




    private OnFragmentInteractionListener mListener;
    
    private EditText editText;
    private Button buttonCreate;
    private Button buttonQuery;
    private EditText editText1;
    private MyDataBaseHelper1 myDataBaseHelper;
    private Context context;
    private String TAG = "loginInicial";
    private Button buttonOtros;

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
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
            buttonOtros = (Button) view.findViewById(R.id.buttonOtros);
            myDataBaseHelper = new MyDataBaseHelper1(context);
            myDataBaseHelper.getInstance(context);
            buttonCreate.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    String s1 = editText1.getText().toString();
                    String s = editText.getText().toString();
                    long id = myDataBaseHelper.createRow(s1,s);
                    Log.v(TAG,"has apretado el boton Sign UP");
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
                        Log.v(TAG,"va todo correcto")  ;                  //HACE ALGO
                    }
                    else Log.v(TAG,"va todo INcorrecto") ;
                }
            });

        buttonOtros.setOnClickListener(new View.OnClickListener() {
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

    // TODO: Rename method, update argument and hook method into UI event
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

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */

}
