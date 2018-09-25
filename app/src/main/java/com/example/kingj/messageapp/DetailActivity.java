package com.example.kingj.messageapp;

import android.content.Intent;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.kingj.messageapp.Pojos.DetailsPojo;
import com.example.kingj.messageapp.Pojos.VideosPojo;
import com.example.kingj.messageapp.Pojos.VideosResult;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class DetailActivity extends YouTubeBaseActivity {

    Intent intent;
    TextView titleTextView;
    TextView releaseDate,overViewTextView;
    long id;
    String ID_K="Id";
    String baseurl = "http://image.tmdb.org/t/p/w780";
    ImageView backDropView;
    DetailsPojo detailsPojo;
    String videoKey;
    CollapsingToolbarLayout collapsingToolbarLayout;

    YouTubePlayerView mYouTubePlayerView;
    YouTubePlayer.OnInitializedListener mOnInitializedListner;

    List<VideosResult> videosList=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        backDropView=findViewById(R.id.imageBack);
        collapsingToolbarLayout=findViewById(R.id.toolbar_layout);
        collapsingToolbarLayout.setTitle("");
        titleTextView=findViewById(R.id.titleDetail);
        releaseDate=findViewById(R.id.detailReleaseDate);
        overViewTextView=findViewById(R.id.overview);

        mYouTubePlayerView=(YouTubePlayerView)findViewById(R.id.youTube);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        intent=getIntent();

        id= intent.getLongExtra(ID_K,1);


        Call<DetailsPojo> call = ApiClient.getService().getDetails(id);

        call.enqueue(new Callback<DetailsPojo>() {
            @Override
            public void onResponse(Call<DetailsPojo> call, Response<DetailsPojo> response) {
                   if(response.body()!=null) {
                       detailsPojo = response.body();

                       String imageUrl = detailsPojo.getBackdropPath();
                       Picasso.with(getApplicationContext()).load(baseurl + imageUrl).into(backDropView);

                       String title = detailsPojo.getTitle();
                       collapsingToolbarLayout.setTitle(title);
                       titleTextView.setPaintFlags(Paint.UNDERLINE_TEXT_FLAG);
                       titleTextView.setText(title);

                       String date=detailsPojo.getReleaseDate();
                       releaseDate.setText(date);

                       String overView = detailsPojo.getOverview();
                       overViewTextView.setText(overView);


                        playYouTube(id);
                   }
                   else {
                       Toast.makeText(getApplicationContext(),"No RecentResult",Toast.LENGTH_LONG).show();
                   }
            }

            @Override
            public void onFailure(Call<DetailsPojo> call, Throwable t) {
                Toast.makeText(getApplicationContext(),t.getMessage(),Toast.LENGTH_LONG).show();
            }
        });



    }

    public void playYouTube(long mId)
    {
        Call<VideosPojo> call = ApiClient.getService().getTrailer(mId);

        call.enqueue(new Callback<VideosPojo>() {
            @Override
            public void onResponse(Call<VideosPojo> call, Response<VideosPojo> response) {
                VideosPojo videosPojo = response.body();
                videosList = videosPojo.getResults();

                videoKey = videosList.get(0).getKey();

                mYouTubePlayerView.initialize(YouTubeApiKey.getApi_key(),mOnInitializedListner);
            }

            @Override
            public void onFailure(Call<VideosPojo> call, Throwable t) {

            }
        });

        mOnInitializedListner= new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                    youTubePlayer.loadVideo(videoKey);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };
    }
}
