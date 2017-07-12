package com.arnauzapata.myapplication;

import android.content.Context;
import android.content.Intent;
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
    int [] music ={R.raw.bootyswing,R.raw.lonedigger,R.raw.nichijou,R.raw.rasputin};
    private Context context = this;
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
    }


    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.buttonMusicPlay:
                 i = new Intent(this,musicService.class);
                i.putExtra("action","play");
                i.putExtra("position",positionMusic);
                startService(i);

                //mediaPlayer.start();
                break;
            case R.id.buttonMusicPause:
                 i = new Intent(this,musicService.class);
                i.putExtra("action","pause");
                i.putExtra("position",positionMusic);
                startService(i);
           //     mediaPlayer.pause();
                break;
            case R.id.buttonMusicReset:
                i = new Intent(this,musicService.class);
                stopService(i);
                i.putExtra("action","reset");
                i.putExtra("position",positionMusic);
                startService(i);

                break;
            case R.id.buttonMusicNext:
                i = new Intent(this,musicService.class);
                stopService(i);
                positionMusic= (positionMusic+1)%music.length;
                i.putExtra("action","next");
                i.putExtra("position",positionMusic);
                startService(i);
                break;
            case R.id.buttonMusicPrevious:
                i = new Intent(this,musicService.class);
                stopService(i);
                if(positionMusic==0) positionMusic= music.length;
                positionMusic--;
                i.putExtra("action","previous");
                i.putExtra("position",positionMusic);
                startService(i);
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

    @Override
    public void onPause() {
        super.onPause();
        Intent i = new Intent(this, musicService.class);
        i.putExtra("action", "pause");
        startService(i);
    }

    @Override
    public void onResume() {
        super.onResume();
        Intent i = new Intent(this, musicService.class);
        i.putExtra("action", "play");
        startService(i);
    }
}
