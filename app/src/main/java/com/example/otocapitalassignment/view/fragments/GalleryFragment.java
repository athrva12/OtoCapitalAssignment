package com.example.otocapitalassignment.view.fragments;


import android.app.Activity;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.otocapitalassignment.Adapters.GalleryViewAdapter;
import com.example.otocapitalassignment.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment {
    RecyclerView gallery_view;
    GalleryViewAdapter adapter;
    ArrayList<String> imageData;
    public GalleryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_gallery, container, false);
        gallery_view=(RecyclerView)view.findViewById(R.id.gallery_recyclerview);
        gallery_view.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this.getContext(),2);
        gallery_view.setLayoutManager(layoutManager);
        MyTask myTask= new MyTask();
        myTask.execute();
    return view;
    }

    private class MyTask extends AsyncTask<Void, Void, Void> {
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... params) {
            imageData = getAllShownImagesPath(getActivity());
            Log.e("imageData: ", String.valueOf(imageData.size()));
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            adapter = new GalleryViewAdapter(imageData, getActivity());
            gallery_view.setAdapter(adapter);

        }

    }
    private ArrayList<String> getAllShownImagesPath(Activity activity) {
        Uri uri;
        Cursor cursor;
        int column_index_data, column_index_folder_name;
        ArrayList<String> listOfAllImages = new ArrayList<String>();
        String absolutePathOfImage = null;
        uri = android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

        String[] projection = { MediaStore.MediaColumns.DATA,
                MediaStore.Images.Media.BUCKET_DISPLAY_NAME };

        cursor = activity.getContentResolver().query(uri, projection, null,
                null, null);

        column_index_data = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        column_index_folder_name = cursor
                .getColumnIndexOrThrow(MediaStore.Images.Media.BUCKET_DISPLAY_NAME);
        while (cursor.moveToNext()) {
            absolutePathOfImage = cursor.getString(column_index_data);

            listOfAllImages.add(absolutePathOfImage);
        }
        return listOfAllImages;
    }
}
