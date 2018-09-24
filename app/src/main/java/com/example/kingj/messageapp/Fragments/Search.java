package com.example.kingj.messageapp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.kingj.messageapp.ApiClient;
import com.example.kingj.messageapp.MoviesAdapter;
import com.example.kingj.messageapp.Pojos.RecentPojo;
import com.example.kingj.messageapp.Pojos.RecentResult;
import com.example.kingj.messageapp.Pojos.UpcomingPojo;
import com.example.kingj.messageapp.Pojos.UpcomingResult;
import com.example.kingj.messageapp.R;
import com.example.kingj.messageapp.SearchMovieAdapter;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class Search extends Fragment {


    long totalpages;
    boolean isScrolling = false;
    int currentItems;
    int totalItems;
    int scrolledOutItems;
    RecyclerView recyclerView;
    SearchMovieAdapter adapter;
    UpcomingPojo result;
    String type="upcoming";
    int page=1;

    List<UpcomingResult> movies=new ArrayList<>();


    public Search() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View output = inflater.inflate(R.layout.fragment_search, container, false);
        recyclerView=output.findViewById(R.id.recyclerview);

        adapter=new SearchMovieAdapter(getContext(),movies);

//        adapter=new MoviesAdapter(getContext(),movies);

        recyclerView.setAdapter(adapter);
        final GridLayoutManager staggeredGridLayoutManager =new GridLayoutManager(getContext(),3,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(staggeredGridLayoutManager);

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                isScrolling=true;
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                currentItems=staggeredGridLayoutManager.getChildCount();
                totalItems=staggeredGridLayoutManager.getItemCount();
                scrolledOutItems=staggeredGridLayoutManager.findFirstVisibleItemPosition();

                if(isScrolling && (currentItems+scrolledOutItems==totalItems)&&page<totalpages)
                {
                    page=page+1;
                    isScrolling=false;
                    fetchData(page);

                }
            }
        });


        Call<UpcomingPojo> call= ApiClient.getService().getUpcoming(type,page);

        call.enqueue(new Callback<UpcomingPojo>() {
            @Override
            public void onResponse(Call<UpcomingPojo> call, Response<UpcomingPojo> response) {
                if(response.body()!=null)
                {
                    result=response.body();
                    movies.clear();
                    movies.addAll(result.getResults());
                    adapter.notifyDataSetChanged();
                }
                else
                {
                    Toast.makeText(getContext(),"No RecentResult",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<UpcomingPojo> call, Throwable t) {
                Log.i("Error","= " + t.getMessage());

                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });



        return output;
    }

    void fetchData(long fpage)
    {
        Call<UpcomingPojo> call= ApiClient.getService().getUpcoming(type,page);

        call.enqueue(new Callback<UpcomingPojo>() {
            @Override
            public void onResponse(Call<UpcomingPojo> call, Response<UpcomingPojo> response) {
                if(response.body()!=null)
                {
                    result=response.body();
                    movies.clear();
                    movies.addAll(result.getResults());
                    adapter.notifyDataSetChanged();
                }
                else
                {
                    Toast.makeText(getContext(),"No RecentResult",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<UpcomingPojo> call, Throwable t) {
                Log.i("Error","= " + t.getMessage());

                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
