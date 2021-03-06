package com.example.kingj.messageapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MoviesViewHolder extends RecyclerView.ViewHolder {

    TextView title;
    ImageView poster;
    View itemView;

    public MoviesViewHolder(View itemView) {
        super(itemView);

        this.itemView=itemView;
        title=itemView.findViewById(R.id.title);
        poster=itemView.findViewById(R.id.poster);
    }
}
