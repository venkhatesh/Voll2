package com.example.venkat.voll2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by venkat on 20/1/18.
 */

public class Recyclerviewadapter extends RecyclerView.Adapter<Recyclerviewadapter.ViewHolder> {
    List<Song> songs;
    Context context;

    public Recyclerviewadapter(List<Song> songs, Context context) {
        this.songs = songs;
        this.context = context;
        Log.d("mainac",songs.size()+"");
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View layoutinflate = (View) LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview,parent,false);
        return new ViewHolder(layoutinflate);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.txtsng.setText("Song Name :-"+songs.get(position).getName());
        holder.txtart.setText("Artist :-"+songs.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtsng;
        ImageView imgview;
        TextView txtart;
        public ViewHolder(View itemView) {
            super(itemView);
            txtsng=(TextView)itemView.findViewById(R.id.txtsng);
            txtart=(TextView)itemView.findViewById(R.id.txtart);
            imgview=(ImageView)itemView.findViewById(R.id.img);
        }
    }

}
