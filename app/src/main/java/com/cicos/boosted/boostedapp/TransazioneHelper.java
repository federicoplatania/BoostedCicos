package com.cicos.boosted.boostedapp;

import android.provider.BaseColumns;

public class TransazioneHelper implements BaseColumns {
    public static final String TABLE_NAME="transazione";
    public final static String DESCRIZIONE="nomescarpe";
    public final static String IMPORTO="modello";
    public final static String DATA="numero";
    public final static String EFFETTUATODA="produttore";
    public final static String PAGATO="produttore";
    public final static String SALDATO="produttore";
    public final static String CREATE_QUERY=
            " CREATE TABLE " + TABLE_NAME
                    + " ( " + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + DESCRIZIONE + " TEXT NOT NULL ,"
                    + IMPORTO + " INTEGER NOT NULL ,"
                    + DATA + " TEXT  NULL ,"
                    + EFFETTUATODA + " TEXT NOT NULL ,"
                    + PAGATO + " TEXT  NULL ,"
                    + SALDATO + " TEXT NOT NULL "
                    + " ) ;";

}
