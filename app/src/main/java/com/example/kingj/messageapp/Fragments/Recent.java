package com.example.kingj.messageapp.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import com.example.kingj.messageapp.Pojos.Result;
import com.example.kingj.messageapp.R;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * A simple {@link Fragment} subclass.
 */
public class Recent extends Fragment {

    RecyclerView recyclerView;
    MoviesAdapter adapter;
    RecentPojo result;
    String type="now_playing";
    int page=1;

    List<Result> movies=new ArrayList<>();

    public Recent() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View output= inflater.inflate(R.layout.fragment_recent, container, false);

        recyclerView=output.findViewById(R.id.recyclerview);

        adapter=new MoviesAdapter(getContext(),movies);

        recyclerView.setAdapter(adapter);

        LinearLayoutManager layoutManager= new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);


        Call<RecentPojo> call= ApiClient.getService().getRecent(type,page);

        call.enqueue(new Callback<RecentPojo>() {
            @Override
            public void onResponse(Call<RecentPojo> call, Response<RecentPojo> response) {
                if(response.body()!=null)
                {
                    result=response.body();
                    movies.addAll(result.getResults());
                    adapter.notifyDataSetChanged();
                }
                else
                {
                    Toast.makeText(getContext(),"No Result",Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onFailure(Call<RecentPojo> call, Throwable t) {
                Log.i("Error","= " + t.getMessage());

                Toast.makeText(getContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });

        return output;
    }

}
