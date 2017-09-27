package com.solomode.project.uminaja.SoalActivity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.solomode.project.uminaja.R;

import java.util.List;

/**
 * Created by madeinsap on 9/22/2017.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    List<Model> getDataAdapter;

    public Adapter(List<Model> getDataAdapter, Context context){
        super();
        this.getDataAdapter = getDataAdapter;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_soal_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        Model getDataAdapter1 =  getDataAdapter.get(position);
        holder.soal.setText(getDataAdapter1.getSoal());
        holder.jawaban.setText(getDataAdapter1.getJawaban());
    }

    @Override
    public int getItemCount() {
        return getDataAdapter.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        public TextView soal;
        public TextView jawaban;
        private CardView cardView;

        public ViewHolder(View itemView) {
            super(itemView);
            cardView = (CardView) itemView.findViewById(R.id.cardview);
            soal = (TextView) itemView.findViewById(R.id.txt_soal);
            jawaban = (TextView) itemView.findViewById(R.id.txt_jawaban);
        }
    }
}
