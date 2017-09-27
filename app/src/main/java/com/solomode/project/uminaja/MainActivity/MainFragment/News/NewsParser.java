package com.solomode.project.uminaja.MainActivity.MainFragment.News;

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

public class NewsParser extends AsyncTask<Void,Integer,Integer> {

    Context c;
    String data;
    RecyclerView rv;
    ProgressDialog pd;
    ArrayList<String> version = new ArrayList<>();
    ArrayList<String> description = new ArrayList<>();
    NewsAdapter adapter;

    public NewsParser(Context c, String data, RecyclerView rv) {
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
            adapter = new NewsAdapter(c, version, description);
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
            version.clear();
            description.clear();
            for(int i=0;i<ja.length();i++)
            {
                jo = ja.getJSONObject(i);
                String txt_version = jo.getString("versi");
                String txt_description = jo.getString("deskripsi");
                version.add(txt_version);
                description.add(txt_description);
            }
            return 1;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
