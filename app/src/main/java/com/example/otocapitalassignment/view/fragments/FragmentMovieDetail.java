package com.example.otocapitalassignment.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.otocapitalassignment.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMovieDetail extends Fragment {
    public static final String MOVIE_BASE_URL="https://image.tmdb.org/t/p/w185";


    public FragmentMovieDetail() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_fragment_movie_detail, container, false);
        Toast.makeText(getContext(),getArguments().getCharSequence("movieTitle"),Toast.LENGTH_LONG).show();
        ImageView poster=(ImageView)view.findViewById(R.id.poster_movie);
        Glide.with(getContext()).load(MOVIE_BASE_URL+getArguments().getString("pos")).into(poster);
        TextView name= (TextView)view.findViewById(R.id.movie_name_details);
        name.setText(getArguments().getCharSequence("movieTitle")+" ("+getArguments().getCharSequence("date")+")");
        TextView overview=(TextView)view.findViewById(R.id.overview_details);
        overview.setText(getArguments().getCharSequence("des"));
        return view;
    }

}
