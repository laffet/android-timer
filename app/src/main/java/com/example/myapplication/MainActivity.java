package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    int moncompteur=0;
    //int oldvalue;
    TextView tv;
    Timer timer;
    TimerTask timerTask;
    Intent intent;

    final Handler handler = new Handler();

    //chronomètre
    int mm, ss; // modulo 60  mm modulo


    //
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv= (TextView) findViewById(R.id.tv_count);
        //  if (savedInstanceState != null) {
        //     moncompteur= savedInstanceState.getInt("Mon compteur");
        //  }

        tv.setText(Integer.toString(moncompteur));
        Log.d(LOG_TAG, "INGTA3A -------");
        Log.d(LOG_TAG, "INGTA3F onCreate");

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("Mon compteur", moncompteur);
    }

    public void Incrementer(View view) {
        moncompteur++;
        Log.d(LOG_TAG, "Ajout 1");
        tv.setText(Integer.toString(moncompteur));
        startTimer();
    }

    public void resetCounter(View view) {
        moncompteur=0;
        tv.setText(Integer.toString(moncompteur));
        Log.d(LOG_TAG, "Reset");
        stoptimertask(view);


    }

    @Override
    public void onResume() {
        super.onResume();
        startTimer();
        Log.d(LOG_TAG, "INGTA3F -------");
        Log.d(LOG_TAG, "INGTA3F onResume");
    }

    @Override
    public void onStart(){
        super.onStart();
        Log.d(LOG_TAG, "INGTA3F -------");
        Log.d(LOG_TAG, "INGTA3F onStart");

    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d(LOG_TAG, "INGTA3F -------");
        Log.d(LOG_TAG, "INGTA3F onPause");

    }


    @Override
    public void onStop(){
        super.onStop();
        Log.d(LOG_TAG, "INGTA3F -------");
        Log.d(LOG_TAG, "INGTA3F onStop");
    }


    public void AfficherToast(View view) {
        Toast toast= Toast.makeText(this, "Bonjour INGTA3E", Toast.LENGTH_LONG);
        toast.show();
    }


    public void  startTimer() {

        timer = new Timer();
        initializeTimerTask();
        timer.schedule(timerTask, 500, 1000);

    }

    public void stoptimertask(View v) {
        //stop the timer, if it's not already null
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    public void initializeTimerTask() {
        timerTask = new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    public void run (){
                        moncompteur++;
                        tv.setText(Integer.toString(moncompteur));
                    }
                });
            }
        };
    }
}