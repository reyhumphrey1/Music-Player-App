package com.dope.rey.musicplayerapp;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    private Button buttonForward, buttonPause, buttonPlay, buttonRewind;
    private MediaPlayer mediaPlayer;

    private double startTime = 0;
    private double finalTime = 0;

    private Handler myhandler = new Handler();
    private int forwardTime = 5000;
    private int backwardTime = 5000;
    private SeekBar seekbar;
    private TextView startSongLength, songName, endSongLength;

    private static int oneTimeOnly = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonForward = findViewById(R.id.button_forward);
        buttonPause = findViewById(R.id.button_pause);
        buttonPlay = findViewById(R.id.button_play);
        buttonRewind = findViewById(R.id.button_rewind);

        startSongLength = findViewById(R.id.start_song_length);
        songName = findViewById(R.id.song_name);
        endSongLength = findViewById(R.id.end_song_length);

        songName.setText("Song.mp3");

        mediaPlayer = MediaPlayer.create(this,R.raw.mankind_north);
        seekbar = findViewById(R.id.seekBar);
        seekbar.setClickable(false);

        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "Now Playing Music", Toast.LENGTH_SHORT).show();
                mediaPlayer.start();

                finalTime = mediaPlayer.getDuration();
                startTime = mediaPlayer.getCurrentPosition();

                if(oneTimeOnly == 0){
                    seekbar.setMax((int)finalTime);
                    oneTimeOnly = 1;
                }

                seekbar.setProgress((int) startTime);
            }
        });

        buttonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });


    }
}
