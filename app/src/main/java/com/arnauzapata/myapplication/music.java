package com.arnauzapata.myapplication;

import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Environment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.File;
import java.io.IOException;

public class music extends Fragment implements View.OnClickListener{

    Button play,pause,reset;
    MediaPlayer mediaPlayer = new MediaPlayer();
    int [] music ={R.raw.bootyswing,R.raw.lonedigger,R.raw.nichijou,R.raw.rasputin};
    private Context context;
    int positionMusic=0;
    private Button next;
    private Button previous;

    public music(Context context) {
        this.context=context;
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.activity_music, container, false);

        File sdCard = Environment.getExternalStorageDirectory();
        File song = new File(sdCard.getAbsolutePath() + "/Music/Song.mp3");
        play= (Button) v.findViewById(R.id.buttonMusicPlay);
        pause= (Button) v.findViewById(R.id.buttonMusicPause);
        reset= (Button) v.findViewById(R.id.buttonMusicReset);
        next= (Button) v.findViewById(R.id.buttonMusicNext);
        previous = (Button) v.findViewById(R.id.buttonMusicPrevious);
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
        return v;
    }


    @Override
    public void onClick(View v) {
        Intent i;
        switch (v.getId()){
            case R.id.buttonMusicPlay:
                 i = new Intent(context,musicService.class);
                i.putExtra("action","play");
                i.putExtra("position",positionMusic);
                context.startService(i);
                break;
            case R.id.buttonMusicPause:
                 i = new Intent(context,musicService.class);
                i.putExtra("action","pause");
                i.putExtra("position",positionMusic);
                context.startService(i);
                break;
            case R.id.buttonMusicReset:
                i = new Intent(context,musicService.class);
                context.stopService(i);
                i.putExtra("action","reset");
                i.putExtra("position",positionMusic);
                context.startService(i);

                break;
            case R.id.buttonMusicNext:
                i = new Intent(context,musicService.class);
                context.stopService(i);
                positionMusic= (positionMusic+1)%music.length;
                i.putExtra("action","next");
                i.putExtra("position",positionMusic);
                context.startService(i);
                break;
            case R.id.buttonMusicPrevious:
                i = new Intent(context,musicService.class);
                context.stopService(i);
                if(positionMusic==0) positionMusic= music.length;
                positionMusic--;
                i.putExtra("action","previous");
                i.putExtra("position",positionMusic);
                context.startService(i);
                break;

        }
    }

/*    @Override
 public void onRestoreInstanceState(Bundle savedInstanceState){
        super.onRestoreInstanceState(savedInstanceState);
         positionMusic = savedInstanceState.getInt("position");
         }
 @Override
 public void onSaveInstanceState(Bundle outState){
         super.onSaveInstanceState(outState);
         outState.putInt("position",positionMusic);
    }*/

    @Override
    public void onPause() {
        super.onPause();
        Intent i = new Intent(context, musicService.class);
        i.putExtra("action", "pause");
        context.startService(i);
    }

    @Override
    public void onResume() {
        super.onResume();
        Intent i = new Intent(context, musicService.class);
        i.putExtra("action", "play");
        context.startService(i);
    }
}
