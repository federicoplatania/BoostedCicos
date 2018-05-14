package com.cicos.boosted.boostedapp;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class TransazioniCursorAdapter extends CursorAdapter {
    public TransazioniCursorAdapter(Context context, Cursor c) {
        super(context,c,false);
    }

    class ViewHolder{
        TextView txt_id_transazione,txt_descrizione,txt_data,txt_importo;
    }
    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View view = LayoutInflater.from(context).inflate(R.layout.celltransazione,null);
        ViewHolder vHolder=new ViewHolder();
        //vHolder.txt_id_transazione=(TextView)view.findViewById(R.id.textview_id_produttore);
        vHolder.txt_descrizione=(TextView)view.findViewById(R.id.textView_descrizione);
        vHolder.txt_data=(TextView)view.findViewById(R.id.textView_data);
        vHolder.txt_importo=(TextView)view.findViewById(R.id.textView_importo);

        view.setTag(vHolder);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder viewHolder=(ViewHolder)view.getTag();
        //viewHolder.txt_id_transazione.setText(""+cursor.getLong(cursor.getColumnIndex(ProduttoriHelper._ID)));
        viewHolder.txt_descrizione.setText(cursor.getString(cursor.getColumnIndex(TransazioneHelper.DESCRIZIONE)));
        viewHolder.txt_data.setText(cursor.getString(cursor.getColumnIndex(TransazioneHelper.DATA)));
        viewHolder.txt_importo.setText(cursor.getString(cursor.getColumnIndex(TransazioneHelper.IMPORTO)));

    }
}
