package com.example.otocapitalassignment.Adapters;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.otocapitalassignment.Models.Result;
import com.example.otocapitalassignment.R;
import com.example.otocapitalassignment.view.fragments.FragmentMovieDetail;

import java.util.ArrayList;
import java.util.List;

public class PopularMovieAdapter extends RecyclerView.Adapter<PopularMovieAdapter.Holder> {
      List<Result> movielist= new ArrayList<>();

    public PopularMovieAdapter(List<Result> movielist) {
        this.movielist = movielist;
    }

    @NonNull
    @Override
    public PopularMovieAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.popular_movie_item, parent, false);
        return new PopularMovieAdapter.Holder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final PopularMovieAdapter.Holder holder, final int position) {
            String position_movie=String.valueOf(position+1);
            final int[] array=new int[movielist.size()];
            String name= movielist.get(position).getTitle();
            holder.position.setText(position_movie+ " -");
            holder.movie_name.setText(name+"("+movielist.get(position).getReleaseDate()+")");
            //onclick
        holder.movie_name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentMovieDetail fragmentMovieDetail =new FragmentMovieDetail();
                Bundle args= new Bundle();
                args.putCharSequence("movieTitle",movielist.get(position).getTitle());
                args.putCharSequence("des",movielist.get(position).getOverview());
                args.putCharSequence("pos",movielist.get(position).getPosterPath());
                args.putCharSequence("date",movielist.get(position).getReleaseDate());
                fragmentMovieDetail.setArguments(args);

                AppCompatActivity activity =  (AppCompatActivity)view.getContext();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.relative_layout, fragmentMovieDetail).addToBackStack(null).commit();
            }
        });
    }

    @Override
    public int getItemCount() {
        return movielist.size();
    }
    public class Holder extends RecyclerView.ViewHolder {
        TextView position,movie_name;
        ImageView poster;
        LinearLayout movie_layout;
        CardView cardView;
        public Holder(View itemView) {
            super(itemView);
            position = (TextView) itemView.findViewById(R.id.position);
            movie_name=(TextView)itemView.findViewById(R.id.movie_name);
//            poster=(ImageView)itemView.findViewById(R.id.movie_poster);
//            movie_layout=(LinearLayout)itemView.findViewById(R.id.linear_view);
        }
    }

}
