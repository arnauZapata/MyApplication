package com.arnauzapata.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class login extends AppCompatActivity {

    EditText editText1;
    private EditText editText;
    private Button buttonCreate;
    private Button buttonQuery;

    private final String TAG = "MainActivity";

    private MyDataBaseHelper1 myDataBaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Initialize objects
        editText1 = (EditText) findViewById(R.id.editText);
        editText = (EditText) findViewById(R.id.editText1);
        buttonCreate = (Button) findViewById(R.id.buttonSignIn);
        buttonQuery = (Button) findViewById(R.id.buttonLogIn);

        myDataBaseHelper.getInstance(this);


        buttonCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = editText.getText().toString();
                String s = editText.getText().toString();
                long id = myDataBaseHelper.createRow(s,s1);
                Toast.makeText(view.getContext(),"We created a row with "+id+"!", Toast.LENGTH_SHORT).show();

            }
        });


        buttonQuery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = editText.getText().toString();
                String s1 = editText.getText().toString();
                String id = myDataBaseHelper.queryRow(s,s1);
            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        myDataBaseHelper.close();
        Log.v(TAG,"onDestroy()");
    }
}
