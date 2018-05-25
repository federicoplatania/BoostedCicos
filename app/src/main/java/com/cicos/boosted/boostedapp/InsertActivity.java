package com.cicos.boosted.boostedapp;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class InsertActivity extends AppCompatActivity {
    long mID = -1;
    Button vBtnAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert);
        Intent mIntent = getIntent();
        final EditText txt_data,txt_importo, txt_descrizionebella;;

        vBtnAdd =(Button)findViewById(R.id.button_salva);
        txt_importo = findViewById(R.id.editText_importo);
        txt_descrizionebella =findViewById(R.id.editText_descrizione);
        txt_data = findViewById(R.id.editText_data);

        Date c = Calendar.getInstance().getTime();

        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String formattedDate = df.format(c);
        txt_data.setText(formattedDate);
        Bundle bundle = mIntent.getExtras();

        if (bundle != null) {
            mID = bundle.getLong("id");
            Uri uri = Uri.parse(PagamentiContentProvider.TRANSAZIONI_URI + "/" + mID);
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);
            cursor.moveToFirst();
            if (cursor != null) {
                txt_importo.setText(cursor.getInt(cursor.getColumnIndex(TransazioneHelper.IMPORTO)));
                txt_descrizionebella.setText(cursor.getString(cursor.getColumnIndex(TransazioneHelper.DESCRIZIONE)));
                txt_data.setText(cursor.getString(cursor.getColumnIndex(TransazioneHelper.DATA)));

            }

        }

        vBtnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ContentValues vValues = new ContentValues();
                vValues.put(TransazioneHelper.IMPORTO, txt_importo.getText().toString());
                vValues.put(TransazioneHelper.DESCRIZIONE, txt_descrizionebella.getText().toString());
                vValues.put(TransazioneHelper.DATA, txt_data.getText().toString());

                setValue(vValues);
                Intent mIntent=new Intent(InsertActivity.this, MainActivity.class);
                InsertActivity.this.startActivity(mIntent);
            }
        });

    }
    public void setValue(ContentValues values){
        if(mID==-1){
            getContentResolver().insert(PagamentiContentProvider.TRANSAZIONI_URI,values);
        } else{
            Uri uri = Uri.parse(PagamentiContentProvider.TRANSAZIONI_URI + "/" + mID);
            getContentResolver().update(uri, values, null, null);
        }
    }
    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.d("TAG", "onNewIntent");
    }
}
