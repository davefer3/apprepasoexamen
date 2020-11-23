package com.davefer.apprepasoexamen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.SeekBar;

public class reproductor extends AppCompatActivity {
    final int DELAY_TIME = 1000;
    MediaPlayer mediaPlayer;
    ImageButton btn1, btn2,btn3;
    SeekBar seekBar;
    ProgressBar progressBar;
    Handler handler;

    int playPosition = 0;
    Boolean playing = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);

        btn1 = (ImageButton) findViewById(R.id.play);
        btn2 = (ImageButton) findViewById(R.id.pause);
        btn3 = (ImageButton) findViewById(R.id.stop);
        seekBar = (SeekBar) findViewById(R.id.seekBar);
        progressBar = (ProgressBar)findViewById(R.id.progressBar);

        btn1.setVisibility(View.INVISIBLE);
        btn2.setVisibility(View.INVISIBLE);
        btn3.setVisibility(View.INVISIBLE);
        seekBar.setVisibility(View.INVISIBLE);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                progressBar.setVisibility(View.GONE);
                btn1.setVisibility(View.VISIBLE);
                btn2.setVisibility(View.VISIBLE);
                btn3.setVisibility(View.VISIBLE);
                seekBar.setVisibility(View.VISIBLE);
            }
        },3000);

        handler = new Handler();
        moverBarra();

        mediaPlayer = MediaPlayer.create(this,R.raw.musica);
        mediaPlayer.setVolume(10,10);


        int millis = mediaPlayer.getDuration();

        seekBar.setMax(millis);



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                playing = true;
                mediaPlayer.start();
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(playing){
                    playing = false;

                }
                mediaPlayer.pause();

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(playing){
                    playing = false;
                }
                seekBar.setProgress(0);
                mediaPlayer.seekTo(0);
                mediaPlayer.pause();

            }
        });




        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(i);
                if(playing)
                    mediaPlayer.start();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    /*
    public void irVideo(View view) {
        Intent i = new Intent(this,Video.class);
        mediaPlayer.stop();
        playing = false;
        startActivity(i);
    }
    */

    private void moverBarra(){
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                seekBar.setProgress(mediaPlayer.getCurrentPosition());
                handler.postDelayed(this,DELAY_TIME);
            }
        },DELAY_TIME);
    }
}