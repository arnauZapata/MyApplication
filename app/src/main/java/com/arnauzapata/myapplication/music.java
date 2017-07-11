package com.arnauzapata.myapplication;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.io.File;
import java.io.IOException;

public class music extends AppCompatActivity implements View.OnClickListener{

    Button play,pause,reset;
    MediaPlayer mediaPlayer = new MediaPlayer();
    private Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        File sdCard = Environment.getExternalStorageDirectory();
        File song = new File(sdCard.getAbsolutePath() + "/Music/Song.mp3");
        play= (Button) findViewById(R.id.buttonMusicPlay);
        pause= (Button) findViewById(R.id.buttonMusicPause);
        reset= (Button) findViewById(R.id.buttonMusicReset);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        reset.setOnClickListener(this);
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

       // mediaPlayer.pause();
        //mediaPlayer.stop();
        //mediaPlayer.release();

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonMusicPlay:
                mediaPlayer.start();
                break;
            case R.id.buttonMusicPause:
                mediaPlayer.pause();
                break;
            case R.id.buttonMusicReset:
                mediaPlayer.stop();
                mediaPlayer = MediaPlayer.create(context, R.raw.bootyswing);
                mediaPlayer.start();
                break;

        }
    }
}
