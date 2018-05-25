package com.cicos.boosted.boostedapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {
    private final static String NAME = "Transazioni.db";
    private final static int VERSIONE = 5;


    public DbHelper(Context aContext) {
        super(aContext, NAME, null, VERSIONE);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //INSERIRE QUI LE QUERY PER LA  CRAZIONE DEL DB
        sqLiteDatabase.execSQL(UtentiHelper.CREATE_QUERY);
        sqLiteDatabase.execSQL(TransazioneHelper.CREATE_QUERY);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //SI PUO INGORARE O LE QUERY PER FARE LE ALTER O DROPARE IL DB E RICREARL
        //SE HO AGGIUNTO SOLO TABELLE POSSO FARE AD
        //SE HO MODIFICATO TANTO DROPPO TUTTO RICREO IL DB E RIFECCIO I DATI
    }
}