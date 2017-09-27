package com.solomode.project.uminaja.MainActivity.MainFragment.Report;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by madeinsap on 9/25/2017.
 */

public class ReportParser extends AsyncTask<Void,Integer,Integer> {

    Context c;
    String data;
    RecyclerView rv;
    ProgressDialog pd;
    ArrayList<String> tittle = new ArrayList<>();
    ArrayList<String> subtittle = new ArrayList<>();
    ReportAdapter adapter;

    public ReportParser(Context c, String data, RecyclerView rv) {
        this.c = c;
        this.data = data;
        this.rv = rv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd=new ProgressDialog(c);
        pd.setMessage("Please Wait...");
        pd.show();
    }

    @Override
    protected Integer doInBackground(Void... params) {
        return this.parse();
    }

    @Override
    protected void onPostExecute(Integer integer) {
        super.onPostExecute(integer);
        pd.dismiss();
        if(integer==1)
        {
            adapter = new ReportAdapter(c, tittle, subtittle);
            rv.setAdapter(adapter);
        }else {
            Toast.makeText(c,"Failed",Toast.LENGTH_SHORT).show();
        }
    }

    private int parse()
    {
        try
        {
            JSONArray ja = new JSONArray(data);
            JSONObject jo = null;
            tittle.clear();
            subtittle.clear();
            for(int i=0;i<ja.length();i++)
            {
                jo = ja.getJSONObject(i);
                String txt_tittle = jo.getString("tittle");
                String txt_subtittle = jo.getString("subtittle");
                tittle.add(txt_tittle);
                subtittle.add(txt_subtittle);
            }
            return 1;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
