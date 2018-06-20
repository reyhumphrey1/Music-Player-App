package com.dope.rey.musicplayerapp;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private Button buttonForward, buttonPause, buttonBack, buttonRewind;
    private MediaPlayer mediaPlayer;

    private double startTime = 0;
    private double finalTime = 0;

    private Handler myhandler = new Handler();
    private int forwardTime = 5000;
    private int backwardTime = 5000;
    private SeekBar seekbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonForward = findViewById(R.id.button_forward);
        buttonPause = findViewById(R.id.button_pause);
        buttonBack = findViewById(R.id.button_back);
        buttonRewind = findViewById(R.id.button_rewind);


    }
}
