package com.mygdx.game;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class HallAdapter extends RecyclerView.Adapter<HallAdapter.AdapterViewHolder>{

    ArrayList<HallRow> rows;

    HallAdapter(ArrayList<HallRow> intel){
        this.rows = new ArrayList<>(intel);
    }

    @Override
    public HallAdapter.AdapterViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        //Instancia un layout XML en la correspondiente vista.
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        //Inflamos en la vista el layout para cada elemento
        View view = inflater.inflate(R.layout.recycler_row, viewGroup, false);
        return new AdapterViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HallAdapter.AdapterViewHolder adapterViewholder, int position) {
        Log.v("Test", rows.get(position).getName() );
        Log.v("Test", ""+rows.get(position).getScore() );
        Log.v("Test", adapterViewholder.score.toString() );;
        adapterViewholder.name.setText(rows.get(position).getName());
        adapterViewholder.score.setText(Integer.toString(rows.get(position).getScore()));
    }

    @Override
    public int getItemCount() {
        //Debemos retornar el tamaño de todos los elementos contenidos en el viewholder
        //Por defecto es return 0 --> No se mostrará nada.
        return rows.size();
    }



    //Definimos una clase viewholder que funciona como adapter para
    public class AdapterViewHolder extends RecyclerView.ViewHolder {
        /*
        *  Mantener una referencia a los elementos de nuestro ListView mientras el usuario realiza
        *  scrolling en nuestra aplicación. Así que cada vez que obtenemos la vista de un item,
        *  evitamos las frecuentes llamadas a findViewById, la cuál se realizaría únicamente la primera vez y el resto
        *  llamaríamos a la referencia en el ViewHolder, ahorrándonos procesamiento.
        */

        public TextView score;
        public TextView name;
        public AdapterViewHolder(View itemView) {
            super(itemView);
            this.name = (TextView) itemView.findViewById(R.id.name);
            this.name.setTextSize(18);
            this.score = (TextView) itemView.findViewById(R.id.score);
            this.score.setTextSize(18);
        }
    }
}

