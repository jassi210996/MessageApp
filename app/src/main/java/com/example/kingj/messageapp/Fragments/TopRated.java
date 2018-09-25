package com.example.kingj.messageapp.Fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.Toast;

import com.example.kingj.messageapp.ApiClient;
import com.example.kingj.messageapp.DetailActivity;
import com.example.kingj.messageapp.MovieClickListner;
import com.example.kingj.messageapp.MoviesAdapter;
import com.example.kingj.messageapp.Pojos.RecentPojo;
import com.example.kingj.messageapp.Pojos.RecentResult;
import com.example.kingj.messageapp.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class TopRated extends Fragment {

    RecyclerView recyclerView;
    MoviesAdapter adapter;
    RecentPojo result;
    Boolean isScrolling=false;
    long totalPage;
    int totalItems;
    int currentItems;
    String ID_K="ID";
    int scrolledoutitems;
    String type="top_rated";
    int page=1;

    List<RecentResult> movies=new ArrayList<>();


    public TopRated() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View output= inflater.inflate(R.layout.fragment_recent, container, false);

        recyclerView=output.findViewById(R.id.recyclerview);

        adapter=new MoviesAdapter(getContext(), movies, new MovieClickListner() {
            @Override
            public void onMovieClicked(View view, int position) {
                Intent intent=new Intent(getContext(), DetailActivity.class);
                RecentResult rResult = movies.get(position);
                long id = rResult.getId();
                intent.putExtra(ID_K,id);
                startActivity(intent);

            }
        });

        recyclerView.setAdapter(adapter);

        final LinearLayoutManager layoutManager= new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);


        Call<RecentPojo> call= ApiClient.getService().getRecent(type,page);

        call.enqueue(new Callback<RecentPojo>() {
            @Override
            public void onResponse(Call<RecentPojo> call, Response<RecentPojo> response) {
                if(response.body()!=null)
                {
                    result=response.body();
                    movies.clear();
                    movies.addAll(result.getRecentResults());
                    adapter.notifyDataSetChanged();
                    totalPage=result.getTotalPages();
                }
                else
                {
                    Toast.makeText(getContext(),"No RecentResult",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<RecentPojo> call, Throwable t) {
                Log.i("Error","= " + t.getMessage());

                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);

                if(newState== AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL)
                {
                    isScrolling=true;
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);

                currentItems=layoutManager.getChildCount();
                totalItems=layoutManager.getItemCount();
                scrolledoutitems=layoutManager.findFirstVisibleItemPosition();

                if(isScrolling&&(currentItems+scrolledoutitems==totalItems) && page<totalPage)
                {
                    page=page+1;
                    isScrolling=false;
                    fetchData(page);

                }
            }
        });

        return output;
    }

    void fetchData(long fpage)
    {
        Call<RecentPojo> call= ApiClient.getService().getRecent(type,fpage);

        call.enqueue(new Callback<RecentPojo>() {
            @Override
            public void onResponse(Call<RecentPojo> call, Response<RecentPojo> response) {
                if(response.body()!=null)
                {
                    result=response.body();
//                    movies.clear();
                    movies.addAll(result.getRecentResults());
                    adapter.notifyDataSetChanged();
//                    totalPage=result.getTotalPages();
                }
                else
                {
                    Toast.makeText(getContext(),"No RecentResult",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<RecentPojo> call, Throwable t) {
                Log.i("Error","= " + t.getMessage());

                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });
    }

}
