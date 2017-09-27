package com.solomode.project.uminaja.MatkulActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.solomode.project.uminaja.R;

/**
 * Created by madeinsap on 9/20/2017.
 */

public class MatkulAdapter extends BaseAdapter {
    Context context;
    int logos[];
    String labels[];
    LayoutInflater inflter;

    public MatkulAdapter(Context applicationContext, String[] labels, int[] logos) {
        this.context = applicationContext;
        this.logos = logos;
        this.labels = labels;
        inflter = (LayoutInflater.from(applicationContext));
    }

    @Override
    public int getCount() {
        return logos.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.activity_matkul_model, null);
        ImageView icon = (ImageView) view.findViewById(R.id.icon);
        TextView text = (TextView) view.findViewById(R.id.label);
        icon.setImageResource(logos[i]);
        text.setText(labels[i]);
        return view;
    }
}
