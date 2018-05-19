package com.cicos.boosted.boostedapp;

import android.content.Intent;

import android.content.Loader;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.content.CursorLoader;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.LoaderManager;


import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>{
    private static final String ACTIVITY_TAG = "MainActivity: ";

    public static final String FRAGMENT="fragment_lista_produttori";
    public static final String FRAGMENT_SCARPA="fragmemntScarpa";
    private static final String DATE ="data" ;

    long mID;
    Button vBtn;
    ListView vList;
    TransazioniCursorAdapter mAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(ACTIVITY_TAG,"onCreate");
        vBtn=findViewById(R.id.btn_add);
        vBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(getApplicationContext(),InsertActivity.class);
                startActivity(i);

            }
        });
        vList=findViewById(R.id.recyclerView);
        mAdapter=new TransazioniCursorAdapter(getBaseContext(),null);
        vList.setAdapter(mAdapter);
        getLoaderManager().initLoader(0,null,this);

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

    @NonNull
    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        CursorLoader cursorLoader=
                new CursorLoader(getBaseContext(), PagamentiContentProvider.TRANSAZIONI_URI,
                        null,null,null,null);
        return cursorLoader;
    }

    @Override
    public void onLoadFinished(android.content.Loader<Cursor> loader, Cursor data) {
        mAdapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(android.content.Loader<Cursor> loader) {
        mAdapter.swapCursor(null);
    }


    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

    }
}
