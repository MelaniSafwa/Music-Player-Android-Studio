package com.example.pbp2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Handler;
import android.os.Message;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ImageView play, prev, next, imageView, lagu1, lagu2, lagu3, lagu4, lagu5, lagu6, lagu7, lagu8, lagu9, lagu10, lagu11;
    TextView songTitle;
    SeekBar mSeekBarTime;
    Button button;
    static MediaPlayer mMediaPlayer;
    private Runnable runnable;
    private AudioManager mAudioManager;
    int currentIndex = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();}

        mAudioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);

        // initializing views

        play = findViewById(R.id.play);
        prev = findViewById(R.id.prev);
        next = findViewById(R.id.next);
        songTitle = findViewById(R.id.songTitle);
        imageView = findViewById(R.id.imageView);
        mSeekBarTime = findViewById(R.id.seekBarTime);
        lagu1 = findViewById(R.id.lagu1);
        lagu2 = findViewById(R.id.lagu2);
        lagu3 = findViewById(R.id.lagu3);
        lagu4 = findViewById(R.id.lagu4);
        lagu5 = findViewById(R.id.lagu5);
        lagu6 = findViewById(R.id.lagu6);
        lagu7 = findViewById(R.id.lagu7);
        lagu8 = findViewById(R.id.lagu8);
        lagu9 = findViewById(R.id.lagu9);
        lagu10 = findViewById(R.id.lagu10);
        lagu11 = findViewById(R.id.lagu11);

        // creating an ArrayList to store our songs

        final ArrayList<Integer> songs = new ArrayList<>();

        songs.add(0, R.raw.vokal);
        songs.add(1, R.raw.antifragile);
        songs.add(2, R.raw.hype_boy);
        songs.add(3, R.raw.nxde);
        songs.add(4, R.raw.shut_down);
        songs.add(5, R.raw.after_like);
        songs.add(6, R.raw.reckless);
        songs.add(7, R.raw.photograph);
        songs.add(8, R.raw.traitor);
        songs.add(9, R.raw.lose);
        songs.add(10, R.raw.happiness);


        // intializing mediaplayer

        mMediaPlayer = MediaPlayer.create(getApplicationContext(), songs.get(currentIndex));



        // seekbar volume

        int maxV = mAudioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        int curV = mAudioManager.getStreamVolume(AudioManager.STREAM_MUSIC);



        //above seekbar volume
        //

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mSeekBarTime.setMax(mMediaPlayer.getDuration());
                if (mMediaPlayer != null && mMediaPlayer.isPlaying()) {
                    mMediaPlayer.pause();
                    play.setImageResource(R.drawable.play_btn_foreground);
                } else {
                    mMediaPlayer.start();
                    play.setImageResource(R.drawable.pause_btn_foreground);
                }

                songNames();

            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mMediaPlayer != null) {
                    play.setImageResource(R.drawable.pause_btn_foreground);
                }

                if (currentIndex < songs.size() - 1) {
                    currentIndex++;
                } else {
                    currentIndex = 0;
                }

                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.stop();
                }

                mMediaPlayer = MediaPlayer.create(getApplicationContext(), songs.get(currentIndex));

                mMediaPlayer.start();
                songNames();

            }
        });


        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mMediaPlayer != null) {
                    play.setImageResource(R.drawable.pause_btn_foreground);
                }

                if (currentIndex > 0) {
                    currentIndex--;
                } else {
                    currentIndex = songs.size() - 1;
                }
                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.stop();
                }

                mMediaPlayer = MediaPlayer.create(getApplicationContext(), songs.get(currentIndex));
                mMediaPlayer.start();
                songNames();

            }
        });

        lagu1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex != 0){
                    currentIndex = 0;
                }
                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.stop();
                }
                mMediaPlayer = MediaPlayer.create(getApplicationContext(), songs.get(currentIndex));
                mMediaPlayer.start();
                songNames();
            }
        });

        lagu2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex != 1){
                    currentIndex = 1;
                }
                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.stop();
                }
                mMediaPlayer = MediaPlayer.create(getApplicationContext(), songs.get(currentIndex));
                mMediaPlayer.start();
                songNames();
            }
        });
        lagu3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex != 2){
                    currentIndex = 2;
                }
                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.stop();
                }
                mMediaPlayer = MediaPlayer.create(getApplicationContext(), songs.get(currentIndex));
                mMediaPlayer.start();
                songNames();
            }
        });
        lagu4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex != 3){
                    currentIndex = 3;
                }
                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.stop();
                }
                mMediaPlayer = MediaPlayer.create(getApplicationContext(), songs.get(currentIndex));
                mMediaPlayer.start();
                songNames();
            }
        });
        lagu5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex != 4){
                    currentIndex = 4;
                }
                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.stop();
                }
                mMediaPlayer = MediaPlayer.create(getApplicationContext(), songs.get(currentIndex));
                mMediaPlayer.start();
                songNames();
            }
        });
        lagu6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex != 5){
                    currentIndex = 5;
                }
                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.stop();
                }
                mMediaPlayer = MediaPlayer.create(getApplicationContext(), songs.get(currentIndex));
                mMediaPlayer.start();
                songNames();
            }
        });
        lagu7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex != 6){
                    currentIndex = 6;
                }
                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.stop();
                }
                mMediaPlayer = MediaPlayer.create(getApplicationContext(), songs.get(currentIndex));
                mMediaPlayer.start();
                songNames();
            }
        });
        lagu8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex != 7){
                    currentIndex = 7;
                }
                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.stop();
                }
                mMediaPlayer = MediaPlayer.create(getApplicationContext(), songs.get(currentIndex));
                mMediaPlayer.start();
                songNames();
            }
        });
        lagu9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex != 8){
                    currentIndex = 8;
                }
                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.stop();
                }
                mMediaPlayer = MediaPlayer.create(getApplicationContext(), songs.get(currentIndex));
                mMediaPlayer.start();
                songNames();
            }
        });
        lagu10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex != 9){
                    currentIndex = 9;
                }
                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.stop();
                }
                mMediaPlayer = MediaPlayer.create(getApplicationContext(), songs.get(currentIndex));
                mMediaPlayer.start();
                songNames();
            }
        });
        lagu11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (currentIndex != 10){
                    currentIndex = 10;
                }
                if (mMediaPlayer.isPlaying()) {
                    mMediaPlayer.stop();
                }
                mMediaPlayer = MediaPlayer.create(getApplicationContext(), songs.get(currentIndex));
                mMediaPlayer.start();
                songNames();
            }
        });
    }


    private void songNames() {
        if (currentIndex == 0) {
            songTitle.setText("Gita Bahana Nusantara - Indonesia Raya");
            imageView.setImageResource(R.drawable.vokal);
//            Toast.makeText(MainActivity.this, "Circular Image View " + "without using any library", Toast.LENGTH_LONG).show();
//            setContentView(R.drawable.vokalblur);
//            ScrollView.setImageResource(R.drawable.vokal-blur)
        }
        if (currentIndex == 1) {
            songTitle.setText("Le Sserafim - Anti Fragile");
            imageView.setImageResource(R.drawable.antifragile);
        }
        if (currentIndex == 2) {
            songTitle.setText("NewJeans - Hype Boy");
            imageView.setImageResource(R.drawable.hype_boy);
        }
        if (currentIndex == 3) {
            songTitle.setText("G-Idle - Nxde");
            imageView.setImageResource(R.drawable.nxde);
        }
        if (currentIndex == 4) {
            songTitle.setText("Blackpink - Shut Down");
            imageView.setImageResource(R.drawable.shut_down);
        }
        if (currentIndex == 5) {
            songTitle.setText("Ive - After Like");
            imageView.setImageResource(R.drawable.after_like);
        }
        if (currentIndex == 6) {
            songTitle.setText("Madison Beer - Reckless");
            imageView.setImageResource(R.drawable.reckless);
        }
        if (currentIndex == 7) {
            songTitle.setText("Ed Sheeran - Photograph");
            imageView.setImageResource(R.drawable.photograph);
        }
        if (currentIndex == 8) {
            songTitle.setText("Olivia Rodrigo - Traitor");
            imageView.setImageResource(R.drawable.traitor);
        }
        if (currentIndex == 9) {
            songTitle.setText("NIKI - Lose");
            imageView.setImageResource(R.drawable.lose);
        }
        if (currentIndex == 10) {
            songTitle.setText("Rex Orange County - Happiness");
            imageView.setImageResource(R.drawable.happiness);
        }


        // seekbar duration
        mMediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mSeekBarTime.setMax(mMediaPlayer.getDuration());
                mMediaPlayer.start();
            }
        });

        mSeekBarTime.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mMediaPlayer.seekTo(progress);
                    mSeekBarTime.setProgress(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mMediaPlayer != null) {
                    try {
                        if (mMediaPlayer.isPlaying()) {
                            Message message = new Message();
                            message.what = mMediaPlayer.getCurrentPosition();
                            handler.sendMessage(message);
                            Thread.sleep(1000);
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @SuppressLint("Handler Leak") Handler handler = new Handler () {
        @Override
        public void handleMessage  (Message msg) {
            mSeekBarTime.setProgress(msg.what);
        }
    };
}
