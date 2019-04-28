package com.example.otocapitalassignment.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.otocapitalassignment.R;

import java.util.ArrayList;

public class GalleryViewAdapter extends RecyclerView.Adapter<GalleryViewAdapter.Holder> {

    Context context;
    private ArrayList<String> imageData = new ArrayList<String>();


    public GalleryViewAdapter(ArrayList<String> imageData, FragmentActivity activity) {
        this.imageData = imageData;
        this.context = activity;
    }

    @NonNull
    @Override
    public GalleryViewAdapter.Holder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.gallery_item, parent, false);
        return new Holder(itemView);
    }



    @Override
    public void onBindViewHolder(@NonNull GalleryViewAdapter.Holder holder, int position) {
        String data = imageData.get(position);
        if (data != null){
            Glide.with(context).load(data).into(holder.singleImageView);

        }else {
            Toast.makeText(context, "Images Empty", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public int getItemCount()
    {
        return imageData.size();
    }

    public class Holder extends RecyclerView.ViewHolder {
        ImageView singleImageView;

        public Holder(View itemView) {
            super(itemView);
            singleImageView = (ImageView) itemView.findViewById(R.id.image_view);
        }
    }

}
