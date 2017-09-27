package com.solomode.project.uminaja.MainActivity.MainFragment.News;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.solomode.project.uminaja.MainActivity.MainFragment.Report.ReportHolder;
import com.solomode.project.uminaja.R;

import java.util.ArrayList;

/**
 * Created by madeinsap on 9/25/2017.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsHolder> {
    Context c;
    ArrayList<String> version;
    ArrayList<String> description;

    public NewsAdapter(Context c, ArrayList<String> version, ArrayList<String> description) {
        this.c = c;
        this.version = version;
        this.description = description;
    }

    @Override
    public NewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_news_model,parent,false);
        NewsHolder holder = new NewsHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(NewsHolder holder, int position) {
        holder.version.setText(version.get(position));
        holder.description.setText(description.get(position));
    }

    @Override
    public int getItemCount() {
        return version.size();
    }
}
