package com.arnauzapata.myapplication;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

public class perfil extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "perfil";
    String user;
    Button cambiarImagen;
    private BaseDatosRanking BaseDatosRanking;
    private boolean canWeRead;
    private SharedPreferences sharedPreferences;
    private ImageView imatgePerfil;
    private static final int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 1;
    private static final int MY_PERMISSIONS_REQUEST_MANAGE_DOCUMENTS = 2;
    private MyDataBaseHelper1 bd;
    private EditText editText;
    private Button guardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        Intent i=getIntent();
        user=i.getStringExtra("user");
        bd=new MyDataBaseHelper1(this);
        bd.getInstance(this);
        String image= bd.getImage(user);
        String direccion=bd.getDireccion(user);
        Log.v(TAG,user);
        Log.v(TAG,image);
        TextView textViewNom = (TextView) findViewById(R.id.textViewPerfilNom);
        TextView textViewRecord = (TextView) findViewById(R.id.textViewPerfilRecord);

        imatgePerfil=(ImageView) findViewById(R.id.imageViewPerfil);
        cambiarImagen = (Button) findViewById(R.id.buttonPerfilImagen);
        editText = (EditText) findViewById(R.id.editTextPerfilDireccion);
        guardar = (Button) findViewById(R.id.buttonPerfilGuardar);
        guardar.setOnClickListener(this);
        editText.setText(direccion);
        editText.setOnClickListener(this);
        cambiarImagen.setOnClickListener(this);

        textViewNom.setText(user);
        BaseDatosRanking= new BaseDatosRanking(this);
        BaseDatosRanking.getInstance(this);
        String puntuation = BaseDatosRanking.queryRow(user);
        textViewRecord.setText(puntuation);
        sharedPreferences = getSharedPreferences("galleryexample", Context.MODE_PRIVATE);
        canWeRead = canWeRead();
        if(canWeRead) {
                Log.v(TAG,"imatge==NULL");
                loadImageFromString(sharedPreferences.getString("imagePath",null));
        }
        else if(image.equals("NULL")){
            Log.v(TAG,"imatge==NULL + !canWeRead");
            loadImageFromString(sharedPreferences.getString("imagePath",null));
        }
        else{
            Log.v(TAG,"imatge!=NULL + !canWeRead");
            loadImageFromString(image);
        }
    }
    private void loadImageFromString (String imagePath){
        if(imagePath != null){
            Uri imageUri = Uri.parse(imagePath);
            try {
                imatgePerfil.setImageBitmap(MediaStore.Images.Media.getBitmap(this.getContentResolver(), imageUri));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private boolean canWeRead(){
        return ContextCompat.checkSelfPermission(this, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_DENIED;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonPerfilImagen:
                Log.v(TAG, String.valueOf(Build.VERSION.SDK_INT));
                Intent ContentImage = null;
                if (Build.VERSION.SDK_INT < 19) {
                    ContentImage = new Intent(Intent.ACTION_GET_CONTENT, null);
                } else {
                    ContentImage = new Intent(Intent.ACTION_OPEN_DOCUMENT);
                    ContentImage.addCategory(Intent.CATEGORY_OPENABLE);
                }
                ContentImage.setType("image/*");
                startActivityForResult(ContentImage, 1);
                break;
            case R.id.editTextPerfilDireccion:
                if(editText.getText().equals("NULL"))editText.setText("");
                break;
            case R.id.buttonPerfilGuardar:
                String direccio=editText.getText().toString();
                bd.setDireccio(user,direccio);
                break;
        }
    }
    @TargetApi(Build.VERSION_CODES.KITKAT)
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(resultCode == RESULT_OK){
            if(requestCode >= 1 && requestCode <= 3){
                Uri selectedImage = data.getData();
                String selectedImagePath = selectedImage.toString();
                guardarImagenBD(selectedImagePath);
                if(canWeRead && requestCode == 2){
                    Log.v("PICK","Selected image uri" + selectedImage);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("imagePath",selectedImagePath );
                    editor.apply();
                }
                try {
                    imatgePerfil.setImageBitmap(MediaStore.Images.Media.getBitmap(this.getContentResolver(), selectedImage));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }else{
            Log.v("Result","Something happened");
        }
    }

    private void guardarImagenBD(String selectedImagePath) {
        bd.setImage(user,selectedImagePath);
    }


    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE: {
                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    canWeRead = true;
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    canWeRead = false;
                }
                return;
            }
            case  MY_PERMISSIONS_REQUEST_MANAGE_DOCUMENTS: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                    canWeRead = true;
                } else {
                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    canWeRead = false;
                }
                return;
            }

            // other 'case' lines to check for other
            // permissions this app might request
        }
    }
}
