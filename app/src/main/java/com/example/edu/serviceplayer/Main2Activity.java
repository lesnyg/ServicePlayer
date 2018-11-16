package com.example.edu.serviceplayer;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {
    Button play,stop;
    Binder binder;
    private MyService myServiceBinder;
    private ServiceConnection myConnection = new ServiceConnection() {
        @Override
        public void onServiceConnected(ComponentName name, IBinder binder) {
            myServiceBinder=((MyService.MyBinder)binder).getService();
        }

        @Override
        public void onServiceDisconnected(ComponentName name) { myServiceBinder=null;}
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent = new Intent(this,MyService.class);
        bindService(intent,myConnection,Context.BIND_AUTO_CREATE);

        play = findViewById(R.id.play);
        play.setOnClickListener(this);
        stop = findViewById(R.id.stop);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.play:
                myServiceBinder.play();
                break;
            case R.id.stop:
                myServiceBinder.Stop();
                break;
        }
    }
}
