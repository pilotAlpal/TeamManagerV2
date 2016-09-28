package com.segarra.lucas.teammanagerv2.View.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.movildat.lucassegarra.teammangaerv2.R;
import com.segarra.lucas.teammanagerv2.Model.MyEvents;

import java.util.ArrayList;

/**
 * Created by lucas.segarra on 28/09/2016.
 */
public class EventsListAdapter extends RecyclerView.Adapter {
    private ArrayList<MyEvents> eventos;

    public EventsListAdapter(ArrayList<MyEvents> events) {
        eventos=events;
    }

    private static class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvFecha,tvNomRival;
        ViewHolder(View v){
            super(v);
            tvFecha=(TextView)v.findViewById(R.id.tv_fecha);
            tvNomRival=(TextView)v.findViewById(R.id.tv_nom_rival);
        }
        void setTvFecha(String fecha){
            tvFecha.setText(fecha);
        }
        void setTvNomRival(String nomRival){
            tvNomRival.setText(nomRival);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup group,int viewType){
        View v= LayoutInflater.from(group.getContext()).inflate(R.layout.item_event,group,false);
        return new ViewHolder(v);
    }



    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ViewHolder myHolder=(ViewHolder) holder;
        myHolder.setTvFecha(eventos.get(position).getDate().toString());
        myHolder.setTvNomRival(eventos.get(position).getTitle());
    }



    @Override
    public int getItemCount() {
        return eventos.size();
    }
}
