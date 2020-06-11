package com.example.dardos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Victory extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_victory);

        Music.play(this, R.raw.victory);

    }

    @Override
    protected void onPause() {
        super.onPause();
        Music.stop();
    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Music.play(this, R.raw.victory);
    }

}
