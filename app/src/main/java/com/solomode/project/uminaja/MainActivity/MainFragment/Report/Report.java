package com.solomode.project.uminaja.MainActivity.MainFragment.Report;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.solomode.project.uminaja.InsertReportActivity.InsertReportActivity;
import com.solomode.project.uminaja.R;

/**
 * Created by madeinsap on 9/19/2017.
 */

public class Report extends Fragment {

    public static Report newInstance() {
        Report fragment = new Report();
        return fragment;
    }

    String url="http://insapol.esy.es/um/getReport.php";
    FloatingActionButton insert;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_report, container, false);

        final RecyclerView rv = (RecyclerView) root.findViewById(R.id.mRecycler);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));

        ReportDownloader d = new ReportDownloader(getActivity(), url, rv);
        d.execute();

        insert = (FloatingActionButton) root.findViewById(R.id.btn_insert);
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent report = new Intent(getActivity(), InsertReportActivity.class);
                startActivity(report);

            }
        });

        return root;
    }
}
