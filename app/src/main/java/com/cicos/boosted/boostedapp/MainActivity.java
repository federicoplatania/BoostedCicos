package com.cicos.boosted.boostedapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {
    private static final String ACTIVITY_TAG = "MainActivity: ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(ACTIVITY_TAG,"onCreate");




    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(ACTIVITY_TAG,"onStart");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(ACTIVITY_TAG,"onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(ACTIVITY_TAG,"onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(ACTIVITY_TAG,"onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(ACTIVITY_TAG,"onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(ACTIVITY_TAG,"onDestroy");
    }
}
