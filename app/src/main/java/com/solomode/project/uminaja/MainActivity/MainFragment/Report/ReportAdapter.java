package com.solomode.project.uminaja.MainActivity.MainFragment.Report;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.solomode.project.uminaja.R;

import java.util.ArrayList;

/**
 * Created by madeinsap on 9/25/2017.
 */

public class ReportAdapter extends RecyclerView.Adapter<ReportHolder> {
    Context c;
    ArrayList<String> tittle;
    ArrayList<String> subtittle;

    public ReportAdapter(Context c, ArrayList<String> tittle, ArrayList<String> subtittle) {
        this.c = c;
        this.tittle = tittle;
        this.subtittle = subtittle;
    }

    @Override
    public ReportHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fragment_report_model,parent,false);
        ReportHolder holder = new ReportHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(ReportHolder holder, int position) {
        holder.tittle.setText(tittle.get(position));
        holder.subtittle.setText(subtittle.get(position));
    }

    @Override
    public int getItemCount() {
        return tittle.size();
    }
}
