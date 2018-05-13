package com.cicos.boosted.boostedapp;

import android.provider.BaseColumns;

public class UtentiHelper implements BaseColumns {

    public static final String TABLE_NAME="utenti";
    public final static String NAME="nome";
    public final static String CREATE_QUERY=
            " CREATE TABLE " + TABLE_NAME
                    + " ( " + _ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                    + NAME + " TEXT NOT NULL "
                    + " ) ;";
}
