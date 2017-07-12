package com.arnauzapata.myapplication;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;

public class musicService extends Service {

    MediaPlayer reproductor;
    int [] music ={R.raw.bootyswing,R.raw.lonedigger,R.raw.nichijou,R.raw.rasputin};
    boolean shouldPause=false;
    private int positionMusic=0;

    @Override

    public void onCreate() {
        reproductor = MediaPlayer.create(this, music[positionMusic]);
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        super.onStartCommand(intent, flags, startId);
        positionMusic=intent.getIntExtra("position",0);

        Log.i(getClass().getSimpleName(), "Intent received");

        try {
            int actionDefault = 0;
            String action = "play";
            if(intent != null){
                if(intent.hasExtra("action")){
                    action = intent.getStringExtra("action");
                }
            }

            switch (action) {
                case "play":
                    reproductor.start();
                    break;
                case "pause":
                    reproductor.pause();
                    break;
                case "reset":
                    reproductor = MediaPlayer.create(this, music[positionMusic]);
                    reproductor.start();
                    break;
                case "previous":
                    reproductor = MediaPlayer.create(this, music[positionMusic]);
                    reproductor.start();
                    break;
                case "next":
                    reproductor = MediaPlayer.create(this, music[positionMusic]);
                    reproductor.start();
                    break;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return START_STICKY;
    }



    @Override

    public void onDestroy() {
        reproductor.stop();
    }



    @Override

    public IBinder onBind(Intent intencion) {

        return null;

    }

    private void start(){
        //startLoop();
        shouldPause = false;
    }
    private void pause(){
        shouldPause = true;
        new android.os.Handler().postDelayed(
                new Runnable() {
                    public void run() {
                        if(shouldPause) {
                            reproductor.pause();
                        }
                    }
                }, 100);
    }

}