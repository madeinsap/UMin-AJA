package com.solomode.project.uminaja.MainActivity.MainFragment.Report;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.solomode.project.uminaja.R;

/**
 * Created by madeinsap on 9/25/2017.
 */

public class ReportHolder extends RecyclerView.ViewHolder{

    TextView tittle;
    TextView subtittle;

    public ReportHolder(View itemView) {
        super(itemView);
        tittle = (TextView) itemView.findViewById(R.id.tittle);
        subtittle = (TextView) itemView.findViewById(R.id.subtittle);
    }
}
