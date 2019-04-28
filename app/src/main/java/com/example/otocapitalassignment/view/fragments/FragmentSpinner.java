package com.example.otocapitalassignment.view.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.otocapitalassignment.MainActivity;
import com.example.otocapitalassignment.R;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentSpinner extends Fragment  implements AdapterView.OnItemSelectedListener {
    Spinner spinner_output;

    public FragmentSpinner() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_fragment_spinner, container, false);
        Spinner spinner_input=(Spinner)view.findViewById(R.id.spinner_input);
        List<String> categories = new ArrayList<String>();
        categories.add("0");
        categories.add("1");
        categories.add("2");
        categories.add("3");
        categories.add("4");
        categories.add("5");
        categories.add("6");
        categories.add("7");
        categories.add("8");
        categories.add("9");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, categories);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner_input.setAdapter(dataAdapter);
        //spinner_output.setAdapter(dataAdapter);
        spinner_output= (Spinner)view.findViewById(R.id.spinner_output);
        spinner_input.setOnItemSelectedListener(this);

        return view;

    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        //String item = parent.getItemAtPosition(position).toString();
        List<String>result= new ArrayList<String>();
        for(int i =1;i<=9;i++)
        {
            int x=position*i;
            result.add(String.valueOf(x));
        }
        // Showing selected spinner item
        ArrayAdapter<String>resultadapter= new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_spinner_item,result);
        resultadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        resultadapter.notifyDataSetChanged();
        spinner_output.setAdapter(resultadapter);
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}
