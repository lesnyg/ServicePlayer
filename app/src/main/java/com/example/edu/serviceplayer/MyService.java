package com.example.edu.serviceplayer;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Binder;
import android.os.IBinder;
import android.widget.Button;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public IBinder onBind(Intent arg0) {  return  new MyBinder(); }
    public class MyBinder extends Binder{
        MyService getService(){
            return MyService.this;
        }
    }
    MediaPlayer mPlayer;

    public void play(){
        mPlayer = MediaPlayer.create(this,R.raw.btn_iamfine);
        mPlayer.setLooping(true);
        mPlayer.setVolume(100,100);
        mPlayer.start();

}
    public void Stop(){
        mPlayer.stop();
        mPlayer.release();


    }
}
