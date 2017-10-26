package com.example.tarajano.block06app;

import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private String IMAGE = "lion";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imageView01 = (ImageView) findViewById(R.id.imageView01);
        imageView01.setImageResource(R.drawable.tux);
        final ImageView imageView02 = (ImageView) findViewById(R.id.imageView02);
        imageView02.setImageResource(R.drawable.tux);

        SeekBar seekBarTunner = (SeekBar) findViewById(R.id.seekBar);

        seekBarTunner.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int lastProgress;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                lastProgress = progress;
                Log.e("lastProgress", "" + lastProgress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                imageView02.setColorFilter(Color.argb(255,0, lastProgress,255-lastProgress));
                //imageView02.setImageAlpha(lastProgress);
                if(lastProgress < 3){
                    imageView02.setImageResource(R.drawable.tux);
                }
            }
        });
    }
}
