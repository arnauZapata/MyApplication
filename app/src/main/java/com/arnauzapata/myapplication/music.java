package com.arnauzapata.myapplication;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;

import java.io.File;
import java.io.IOException;

public class music extends AppCompatActivity {


    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music2);
        MediaPlayer mediaPlayer = new MediaPlayer();
        File sdCard = Environment.getExternalStorageDirectory();
        File song = new File(sdCard.getAbsolutePath() + "/Music/Song.mp3");

        try{
            mediaPlayer.setDataSource(song.getAbsolutePath());
            mediaPlayer.prepare();
            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mediaPlayer) {

                }
            });
        }
        catch  (IOException e) {
            e.printStackTrace();
        }

//Reproducir una cancion de la carpeta raw
        mediaPlayer = MediaPlayer.create(context, R.raw.bootyswing);


//Funciones de control
        mediaPlayer.start();
       // mediaPlayer.pause();
        //mediaPlayer.stop();
        //mediaPlayer.release();

    }





}
