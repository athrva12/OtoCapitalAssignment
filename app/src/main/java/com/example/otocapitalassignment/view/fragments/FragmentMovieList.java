package com.example.otocapitalassignment.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.otocapitalassignment.Adapters.PopularMovieAdapter;
import com.example.otocapitalassignment.Models.PopularList;
import com.example.otocapitalassignment.Models.Result;
import com.example.otocapitalassignment.R;
import com.example.otocapitalassignment.Remote.RetrofitClass;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentMovieList extends Fragment {

    public final static String api_key= "1f28f20e1ac64d98b412f986f102c396";
    public  final  static String language= "en-US";
    List<Result> list=new ArrayList<>();

    public FragmentMovieList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fragment_movie_list, container, false);
        final RecyclerView recyclerView = (RecyclerView)view.findViewById(R.id.movielist_recycler);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager= new LinearLayoutManager(this.getContext());
        recyclerView.setLayoutManager(layoutManager);


        final Call<PopularList>jsonData= RetrofitClass.getAPIService().getPopularList(api_key,language,1);
        jsonData.enqueue(new Callback<PopularList>() {
            @Override
            public void onResponse(Call<PopularList> call, Response<PopularList> response) {
//                Result result=new Result();
//                result= response.body().getResults().get(0);
                for(int i=0;i<response.body().getResults().size();i++) {
                    list.add(response.body().getResults().get(i));
                }
                PopularMovieAdapter popularMovieAdapter=new PopularMovieAdapter(list);
                recyclerView.setAdapter(popularMovieAdapter);

            }

            @Override
            public void onFailure(Call<PopularList> call, Throwable t) {

            }
        });

        return view;
    }

}
