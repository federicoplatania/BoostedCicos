package com.cicos.boosted.boostedapp;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class UtentiCursorAdapter extends CursorAdapter {
    public UtentiCursorAdapter(Context context, Cursor c) {
        super(context,c,false);
    }

    class ViewHolder{
        TextView txt_name;
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.celltransazione,null);
        UtentiCursorAdapter.ViewHolder vHolder=new UtentiCursorAdapter.ViewHolder();
        //vHolder.txt_id_transazione=(TextView)view.findViewById(R.id.textview_id_produttore);
        vHolder.txt_name=(TextView)view.findViewById(R.id.textView_descrizione);


        view.setTag(vHolder);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {

    }






}
