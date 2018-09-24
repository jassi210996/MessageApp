package com.example.kingj.messageapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kingj.messageapp.Pojos.UpcomingResult;
import com.squareup.picasso.Picasso;

import java.util.List;

public class SearchMovieAdapter extends RecyclerView.Adapter<SearchMovieViewHolder> {

    Context context;
    List<UpcomingResult> upcoming;
    String url="http://image.tmdb.org/t/p/w500";

    public SearchMovieAdapter(Context context,List<UpcomingResult>upcoming)
    {
        this.context=context;
        this.upcoming=upcoming;
    }

    @NonNull
    @Override
    public SearchMovieViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View searchRowLayout=inflater.inflate(R.layout.searchrowlayout,parent,false);

        return new SearchMovieViewHolder(searchRowLayout);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchMovieViewHolder holder, int position) {

        UpcomingResult upcomingResult=upcoming.get(position);
        String ut = upcomingResult.getPosterPath();
        Picasso.with(context).load(url+upcomingResult.getPosterPath()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return upcoming.size();
    }
}
