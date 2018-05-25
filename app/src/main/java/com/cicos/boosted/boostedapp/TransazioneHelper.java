package com.cicos.boosted.boostedapp;

import android.provider.BaseColumns;

public class TransazioneHelper implements BaseColumns {
    public static final String TABLE_NAME="transazione";
    public final static String DESCRIZIONE="descrizione";
    public final static String IMPORTO="importo";
    public final static String DATA="dataPagamento";
    public final static String EFFETTUATODA="effettuatoDA";
    public final static String PAGATO="pagato";
    public final static String SALDATO="saldato";
    public final static String CREATE_QUERY=
            " CREATE TABLE " + TABLE_NAME
                    + " ( " + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + DESCRIZIONE + " TEXT ,"
                    + IMPORTO + " INTEGER NOT NULL ,"
                    + DATA + " TEXT ,"
                    + EFFETTUATODA + " TEXT ,"
                    + PAGATO + " TEXT ,"
                    + SALDATO + " TEXT "
                    + " ) ;";

}
