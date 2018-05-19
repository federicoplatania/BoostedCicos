package com.cicos.boosted.boostedapp;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InsertActivity extends AppCompatActivity {
    long mID = -1;
    Button vBtnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        Intent mIntent = getIntent();
        final TextView txt_importo, txt_descrizione;
        final EditText txt_data;

        vBtnAdd = (Button)findViewById(R.id.button_salva);
        txt_importo = (TextView) findViewById(R.id.textView_importo);
        txt_descrizione = (TextView) findViewById(R.id.textView_descrizione);
        txt_data = (EditText) findViewById(R.id.editText_data);

        Bundle bundle = mIntent.getExtras();

        if (bundle != null) {
            mID = bundle.getLong("id");
           // Uri uri = Uri.parse(PagamentiContentProvider.PRODUTTORI_URI + "/" + mID);
            Cursor cursor = getContentResolver().query(null, null, null, null, null);
            cursor.moveToFirst();
            if (cursor != null) {
                txt_importo.setText(cursor.getString(cursor.getColumnIndex(TransazioneHelper.IMPORTO)));
                txt_descrizione.setText(cursor.getString(cursor.getColumnIndex(TransazioneHelper.DESCRIZIONE)));
                txt_data.setText(cursor.getString(cursor.getColumnIndex(TransazioneHelper.DATA)));

            }

        }

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("TAG", "onNewIntent");
    }
}
