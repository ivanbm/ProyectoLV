package com.izv.proyectolv;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class Adaptador extends ArrayAdapter<Disco> {

    private ArrayList<Disco> lista;
    private Context contexto;
    private int recurso;
    private static LayoutInflater i;

    public Adaptador(Context context, int resource, ArrayList<Disco> objects) {
        super(context, resource, objects);
        this.contexto = context;
        this.lista = objects;
        this.recurso = resource;
        this.i = (LayoutInflater) contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public static class ViewHolder{
        public TextView tv1, tv2, tv3;
        public ImageView iv1;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
        if(convertView == null){
            convertView = i.inflate(recurso, null);
            vh = new ViewHolder();
            vh.tv1 = (TextView)convertView.findViewById(R.id.tvTexto1);
            vh.tv2 = (TextView)convertView.findViewById(R.id.tvTexto2);
            vh.tv3 = (TextView)convertView.findViewById(R.id.tvTexto3);
            vh.iv1 = (ImageView)convertView.findViewById(R.id.ivImagen);
            convertView.setTag(vh);
        }else{
            vh = (ViewHolder)convertView.getTag();
        }

        Log.v("LOG",vh.toString());
        vh.tv1.setText(lista.get(position).getTitulo());
        vh.tv2.setText(lista.get(position).getAutor());
        vh.tv3.setText(lista.get(position).getDiscografica());
        //Svh.iv1.setImageResource(R.drawable.coldplay);
        return convertView;
    }
}
