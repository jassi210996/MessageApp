package com.example.kingj.messageapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

public class SearchMovieViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView;
    View itemView;

    public SearchMovieViewHolder(View itemView) {
        super(itemView);

        this.itemView=itemView;
        this.imageView=itemView.findViewById(R.id.searchImage);
    }
}
