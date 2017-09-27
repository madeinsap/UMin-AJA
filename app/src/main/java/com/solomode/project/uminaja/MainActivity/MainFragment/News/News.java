package com.solomode.project.uminaja.MainActivity.MainFragment.News;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.solomode.project.uminaja.InsertReportActivity.InsertReportActivity;
import com.solomode.project.uminaja.MainActivity.MainFragment.Report.Report;
import com.solomode.project.uminaja.MainActivity.MainFragment.Report.ReportDownloader;
import com.solomode.project.uminaja.R;

/**
 * Created by madeinsap on 9/19/2017.
 */

public class News extends Fragment {

        public static News newInstance() {
            News fragment = new News();
            return fragment;
        }

        String url="http://insapol.esy.es/um/getNews.php";

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View root = inflater.inflate(R.layout.fragment_news, container, false);

            final RecyclerView rv = (RecyclerView) root.findViewById(R.id.mRecycler);
            rv.setLayoutManager(new LinearLayoutManager(getActivity()));

            NewsDownloader d = new NewsDownloader(getActivity(), url, rv);
            d.execute();

            return root;
        }
}
