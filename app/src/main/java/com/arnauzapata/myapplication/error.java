package com.arnauzapata.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class error extends AppCompatActivity {

    private Button buttonError;
    Context context=this;
    private TextView textViewError;
    int intent=0;
    private Intent i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_error);
        buttonError=(Button) findViewById(R.id.buttonError);
        textViewError=(TextView) findViewById(R.id.textViewError);
        intent=getIntent().getIntExtra("intent",0);
        if(intent>3)buttonError.setVisibility(View.INVISIBLE);
        i= new Intent(context, login.class);
        i.putExtra("intent",intent);
        hacerTexto();
        buttonError.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(i);
            }
        });
    }

    private void hacerTexto() {
        switch (intent){
            case 1:
                textViewError.setText("te considero un intruso, asi que no podras entras en mi gran aplicacion");
                break;
            case 2:
                textViewError.setText("¿Tu escuchas? He dicho que no puedes entrar");
                break;
            case 3:
                textViewError.setText("Ya me estas cabreando, como sigas asi te quito el boton");
                break;
            case 4:
                textViewError.setText("Ea, boton eliminado ¿que haras ahora, listillo?");
                break;
            case 5:
                textViewError.setText("Espera ¿como has conseguido volver al login de inicio, bueno ¿sabes que? yo ya paso de avisarte. Haz lo que quieras");
                break;
        }
    }
}
