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
    int [] music ={R.raw.bootyswing,R.raw.lonedigger,R.raw.nichijou,R.raw.rasputin};
    int positionMusic=0;
    private Button next;
    private Button previous;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        File sdCard = Environment.getExternalStorageDirectory();
        File song = new File(sdCard.getAbsolutePath() + "/Music/Song.mp3");
        play= (Button) findViewById(R.id.buttonMusicPlay);
        pause= (Button) findViewById(R.id.buttonMusicPause);
        reset= (Button) findViewById(R.id.buttonMusicReset);
        next= (Button) findViewById(R.id.buttonMusicNext);
        previous = (Button) findViewById(R.id.buttonMusicPrevious);
        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        reset.setOnClickListener(this);
        next.setOnClickListener(this);
        previous.setOnClickListener(this);
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
        mediaPlayer = MediaPlayer.create(context, music[positionMusic]);
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
                mediaPlayer = MediaPlayer.create(context, music[positionMusic]);
                mediaPlayer.start();
                break;
            case R.id.buttonMusicNext:
                mediaPlayer.stop();
                positionMusic= (positionMusic+1)%music.length;
                mediaPlayer = MediaPlayer.create(context, music[positionMusic]);
                mediaPlayer.start();
                break;
            case R.id.buttonMusicPrevious:
                mediaPlayer.stop();
                if(positionMusic==0)positionMusic=music.length;
                positionMusic--;
                mediaPlayer = MediaPlayer.create(context, music[positionMusic]);
                mediaPlayer.start();
                break;

        }
    }

    @Override
 protected void onRestoreInstanceState(Bundle savedInstanceState){
         super.onRestoreInstanceState( savedInstanceState);
         positionMusic = savedInstanceState.getInt("position");
         }
 @Override
 protected void onSaveInstanceState(Bundle outState){
         super.onSaveInstanceState(outState);
         outState.putInt("position",positionMusic);
         mediaPlayer.stop();
    }
}
