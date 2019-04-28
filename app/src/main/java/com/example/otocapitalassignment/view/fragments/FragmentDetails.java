package com.example.otocapitalassignment.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.otocapitalassignment.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDetails extends Fragment {


    public FragmentDetails() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fragment_details, container, false);
        TextView textView= (TextView)view.findViewById(R.id.detail_text);
        textView.setText("Gallery Screen -\n" +
                "I have used Recyclerview to show the images from gallery because it contains different kind of Layoutmanager(as i have used grid layout ) which is not present in Listview.\n" +
                "\n\nSpinner view -\n" +
                "This screen simply contains two spinner so for showing these spinner in align i have used nested linear layout(I found it easy) one verticle to hold textview and spiner inside horizontal Linear layout.\n" +
                "\n\nMovie List Screen-\n" +
                "In this screen agian i have used recyclerview as in gallery screen, and in recycler view every individual is inside Card view, I have used retrofit to build the api call and shown the data.\n" +
                "\n\nMovie Details Screen-\n" +
                "In this screen i have simply use scroll view inside a framelayout and then a relative layout for positioning of text views.\n" +
                "\n Thank you.");
        return view;
    }

}
