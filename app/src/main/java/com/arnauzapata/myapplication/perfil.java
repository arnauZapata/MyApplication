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
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;

import static android.app.Activity.RESULT_OK;

public class perfil extends android.app.Fragment implements View.OnClickListener {

    private static final String TAG = "perfil";
    String user;
    Context context;
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
    private TextView textViewRecord;

    public perfil(Context context, String user) {
        this.context=context;
        this.user=user;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.activity_perfil, container, false);
        bd=new MyDataBaseHelper1(context);
        bd.getInstance(context);
        String image= bd.getImage(user);
        String direccion=bd.getDireccion(user);
        Log.v(TAG,user);
        Log.v(TAG,image);
        TextView textViewNom = (TextView) v.findViewById(R.id.textViewPerfilNom);
        textViewRecord = (TextView) v.findViewById(R.id.textViewPerfilRecord);

        imatgePerfil=(ImageView) v.findViewById(R.id.imageViewPerfil);
        cambiarImagen = (Button) v.findViewById(R.id.buttonPerfilImagen);
        editText = (EditText) v.findViewById(R.id.editTextPerfilDireccion);
        guardar = (Button) v.findViewById(R.id.buttonPerfilGuardar);
        guardar.setOnClickListener(this);
        editText.setText(direccion);
        editText.setOnClickListener(this);
        editText.setVisibility(View.VISIBLE);
        cambiarImagen.setOnClickListener(this);
        textViewRecord.setVisibility(View.VISIBLE);
        textViewNom.setText(user);
        BaseDatosRanking= new BaseDatosRanking(context);
        BaseDatosRanking.getInstance(context);
        String puntuation = BaseDatosRanking.queryRow(user);
        textViewRecord.setText(puntuation);
        sharedPreferences = context.getSharedPreferences("galleryexample", Context.MODE_PRIVATE);
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
        return v;
    }
    private void loadImageFromString (String imagePath){
        if(imagePath != null){
            Uri imageUri = Uri.parse(imagePath);
            try {
                imatgePerfil.setImageBitmap(MediaStore.Images.Media.getBitmap(context.getContentResolver(), imageUri));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private boolean canWeRead(){
        return ContextCompat.checkSelfPermission(context, android.Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_DENIED;
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
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
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
                    imatgePerfil.setImageBitmap(MediaStore.Images.Media.getBitmap(context.getContentResolver(), selectedImage));
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

    public void borrarMemoria() {
        editText.setVisibility(View.INVISIBLE);
        textViewRecord.setVisibility(View.INVISIBLE);

    }
}
