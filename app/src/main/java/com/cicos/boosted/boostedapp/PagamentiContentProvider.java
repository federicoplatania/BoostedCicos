package com.cicos.boosted.boostedapp;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;

public class PagamentiContentProvider extends ContentProvider {

    public static final String CONTENT_TYPE_TRANSAZIONI= ContentResolver.CURSOR_DIR_BASE_TYPE +"/transactions";
    public static final String CONTENT_ITEM_TYPE_TRANSAZIONI= ContentResolver.CURSOR_ITEM_BASE_TYPE+"/transaction";
    public static final String CONTENT_TYPE_UTENTI= ContentResolver.CURSOR_DIR_BASE_TYPE +"/users";
    public static final String CONTENT_ITEM_TYPE_UTENTE= ContentResolver.CURSOR_ITEM_BASE_TYPE+"/user";
    private static final String AUTHORITY="com.cicos.boosted.boostedapp";
    private static final String BASE_PATH_TRANSAZIONI="transactions";
    private static final String BASE_PATH_UTENTI="users";
    public static final Uri  TRANSAZIONI_URI=Uri.parse("content://"+AUTHORITY+"/"+BASE_PATH_TRANSAZIONI);
    public static final Uri  UTENTI_URI=Uri.parse("content://"+AUTHORITY+"/"+BASE_PATH_UTENTI);

    private static final int TRANSAZIONI=10;
    private static final int TRANSAZIONI_ID=20;
    private static final int UTENTI=30;
    private static final int UTENTI_ID=40;
    private static final UriMatcher sURIMatcher=new UriMatcher(UriMatcher.NO_MATCH);
    static {
        sURIMatcher.addURI(AUTHORITY,BASE_PATH_TRANSAZIONI,TRANSAZIONI);
        sURIMatcher.addURI(AUTHORITY,BASE_PATH_TRANSAZIONI+"/#",TRANSAZIONI_ID);
        sURIMatcher.addURI(AUTHORITY,BASE_PATH_UTENTI,UTENTI);
        sURIMatcher.addURI(AUTHORITY,BASE_PATH_UTENTI+"/#",UTENTI_ID);
    }
    private DbHelper mDbHelper;


    @Override
    public boolean onCreate() {
        mDbHelper=new DbHelper(getContext());
        return true;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        SQLiteQueryBuilder vQueryBuilder=new SQLiteQueryBuilder();
        vQueryBuilder.setTables(TransazioneHelper.TABLE_NAME);
        vQueryBuilder.setTables(UtentiHelper.TABLE_NAME);
        int vUriType=sURIMatcher.match(uri);
        switch (vUriType){
            case TRANSAZIONI:
                vQueryBuilder.setTables(TransazioneHelper.TABLE_NAME);
                break;
            case TRANSAZIONI_ID:
                vQueryBuilder.setTables(TransazioneHelper.TABLE_NAME);
                vQueryBuilder.appendWhere(TransazioneHelper._ID + " = " + uri.getLastPathSegment());
                break;
            case UTENTI:
                vQueryBuilder.setTables(UtentiHelper.TABLE_NAME);
                if(!TextUtils.isEmpty(selection)){
                    vQueryBuilder.appendWhere(selection);
                }
                break;
            case UTENTI_ID:
                vQueryBuilder.setTables(UtentiHelper.TABLE_NAME);
                //vQueryBuilder.appendWhere(TemperatureHelper._ID + " = " );
                break;
            default:
                throw new IllegalArgumentException("bho"+uri);
        }

        SQLiteDatabase db =mDbHelper.getReadableDatabase();
        Cursor cursor=vQueryBuilder.query(db,projection,selection,selectionArgs,null,null,sortOrder);
        cursor.setNotificationUri(getContext().getContentResolver(),uri);

        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        int vUriType=sURIMatcher.match(uri);
        String vResult=null;
        switch (vUriType){
            case TRANSAZIONI:
                vResult=CONTENT_TYPE_TRANSAZIONI;
                break;
            case TRANSAZIONI_ID:
                vResult=CONTENT_ITEM_TYPE_TRANSAZIONI;
            case UTENTI:
                vResult=CONTENT_TYPE_UTENTI;
                break;
            case UTENTI_ID:
                vResult=CONTENT_ITEM_TYPE_UTENTE;
        }
        return vResult;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        int vUriType=sURIMatcher.match(uri);
        SQLiteDatabase vSqlDB=mDbHelper.getWritableDatabase();
        long vID=0;
        Uri vUri;
        switch (vUriType){
            case TRANSAZIONI:
                vID=vSqlDB.insert(TransazioneHelper.TABLE_NAME,null,values);

                vUri = Uri.parse("content://"+AUTHORITY+"/"+BASE_PATH_TRANSAZIONI+"/"+vID);
                break;
            case UTENTI:
                vID=vSqlDB.insert(UtentiHelper.TABLE_NAME,null,values);
                vUri = Uri.parse("content://"+AUTHORITY+"/"+BASE_PATH_UTENTI+"/"+vID);
                break;
            default:
                throw new IllegalArgumentException(uri.toString());
        }

        getContext().getContentResolver().notifyChange(uri,null);

        if(vID>=0) {
            return vUri;
        }
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
