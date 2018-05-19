package com.cicos.boosted.boostedapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private static final String ACTIVITY_TAG = "MainActivity: ";

    public static final String FRAGMENT="fragment_lista_produttori";
    public static final String FRAGMENT_SCARPA="fragmemntScarpa";
    //FragmentListaProduttori mFragmentcostum;
    private static final String DATE ="data" ;
    String mCreate;
   // FragmentListaScarpe mFragmentListaScarpe;
    long mID;
    Button vBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(ACTIVITY_TAG,"onCreate");
        vBtn=(Button)findViewById(R.id.btn_add);
        vBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),DetailActivity.class);
                startActivity(i);

            }
        });




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
