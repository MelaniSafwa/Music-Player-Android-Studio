package com.example.tutorial_service2;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

import androidx.annotation.Nullable;

public class MusicService extends Service {
    static MediaPlayer player;

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String rcvsong = intent.getStringExtra("song");

        int playedsong = getResources().getIdentifier(rcvsong,"raw",getPackageName());
        stopPlayer();
        if(player == null){
            player = MediaPlayer.create(getApplicationContext(),playedsong);
        }

        player.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopPlayer();
    }

    private void stopPlayer(){
        if(player != null){
            player.release();
            player = null;
        }
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
