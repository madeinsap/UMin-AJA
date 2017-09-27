package com.solomode.project.uminaja.MainActivity.MainFragment.Home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.solomode.project.uminaja.R;
import com.solomode.project.uminaja.MatkulActivity.MatkulActivity;

/**
 * Created by madeinsap on 9/19/2017.
 */

public class Home extends Fragment{

    public static Home newInstance() {
        Home fragment = new Home();
        return fragment;
    }

    int logos[] = {R.drawable.ic_ti, R.drawable.ic_industri, R.drawable.ic_mesin, R.drawable.ic_elektro,
            R.drawable.ic_sastra, R.drawable.ic_si, R.drawable.ic_sk, R.drawable.ic_sipil,
            R.drawable.ic_arsitek, R.drawable.ic_akuntansi, R.drawable.ic_management, R.drawable.ic_psikologi,
    };

    String labels[] = {"informatika", "industri", "mesin", "elektro",
            "sastra", "sisfor", "siskom", "sipil",
            "arsitektur", "akuntansi", "management", "psikologi",
    };

    private String jurusan;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        GridView grid = (GridView) root.findViewById(R.id.grid_home);

        HomeAdapter homeAdapter = new HomeAdapter(getActivity().getApplicationContext(),labels, logos);
        grid.setAdapter(homeAdapter);
        // implement setOnItemClickListener event on GridView
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), MatkulActivity.class);
                intent.putExtra("labels", labels[position]);
                startActivity(intent); // start Intent
            }
        });

        return root;
    }
}
