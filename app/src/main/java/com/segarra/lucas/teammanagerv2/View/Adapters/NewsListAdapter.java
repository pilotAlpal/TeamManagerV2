package com.segarra.lucas.teammanagerv2.View.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.movildat.lucassegarra.teammangaerv2.R;
import com.segarra.lucas.teammanagerv2.Model.MyMessage;

import java.util.ArrayList;

/**
 * Created by Propietario on 12/10/2016.
 */
public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.ViewHolder>{
    private ArrayList<MyMessage> myData;

    public NewsListAdapter(ArrayList<MyMessage> conversation) {
        if(conversation==null)
            myData=new ArrayList<>();
        else
            myData=conversation;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tvAuthor.setText(myData.get(position).getIdAutor());
        holder.tvText.setText(myData.get(position).getText());
    }

    @Override
    public int getItemCount() {
        if (myData.isEmpty())
            return 0;
        return myData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView  tvText,tvAuthor;

        public ViewHolder(View itemView) {
            super(itemView);
        }
    }
}
