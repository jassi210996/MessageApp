package com.example.kingj.messageapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kingj.messageapp.Pojos.RecentResult;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MoviesAdapter extends RecyclerView.Adapter<MoviesViewHolder>  {

    Context context;
    List<RecentResult> topRated;
    String url="http://image.tmdb.org/t/p/w500";

    public MoviesAdapter(Context context, List<RecentResult> movies)
    {
        this.context=context;
        topRated=movies;
    }

    @NonNull
    @Override
    public MoviesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowLayout=inflater.inflate(R.layout.rowlayout,parent,false);

        return new MoviesViewHolder(rowLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull MoviesViewHolder holder, int position) {

        RecentResult recent = topRated.get(position);

        holder.title.setText(recent.getTitle());
        String avb = recent.getTitle();
        String imageUrl=recent.getPosterPath();

        Picasso.with(context).load(url+imageUrl).into(holder.poster);

    }

    @Override
    public int getItemCount() {
        return topRated.size();
    }
}
