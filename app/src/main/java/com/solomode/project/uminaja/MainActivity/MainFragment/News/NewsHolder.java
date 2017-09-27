package com.solomode.project.uminaja.MainActivity.MainFragment.News;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.solomode.project.uminaja.R;

/**
 * Created by madeinsap on 9/25/2017.
 */

public class NewsHolder extends RecyclerView.ViewHolder{

    TextView version;
    TextView description;

    public NewsHolder(View itemView) {
        super(itemView);
        version = (TextView) itemView.findViewById(R.id.version);
        description = (TextView) itemView.findViewById(R.id.description);
    }
}
