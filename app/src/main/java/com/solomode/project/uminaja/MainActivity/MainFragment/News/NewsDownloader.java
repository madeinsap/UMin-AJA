package com.solomode.project.uminaja.MainActivity.MainFragment.News;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.solomode.project.uminaja.MainActivity.MainFragment.Report.ReportParser;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by madeinsap on 9/25/2017.
 */

public class NewsDownloader extends AsyncTask<Void,Integer,String> {

    Context c;
    String urlAddress;
    RecyclerView rv;
    ProgressDialog pd;

    public NewsDownloader(Context c, String urlAddress, RecyclerView rv) {
        this.c = c;
        this.urlAddress = urlAddress;
        this.rv = rv;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pd=new ProgressDialog(c);
        pd.setMessage("Loading...");
        pd.show();
    }

    @Override
    protected String doInBackground(Void... params) {
        String data = this.downloadData();
        return data;
    }

    @Override
    protected void onPostExecute(String data) {
        super.onPostExecute(data);
        pd.dismiss();
        if(data != null)
        {
            NewsParser p = new NewsParser(c, data, rv);
            p.execute();
        }else {
            Toast.makeText(c,"Failed",Toast.LENGTH_SHORT).show();
        }
    }

    private String downloadData()
    {
        InputStream is = null;
        String line = null;
        try
        {
            URL url=new URL(urlAddress);
            HttpURLConnection con= (HttpURLConnection) url.openConnection();
            is=new BufferedInputStream(con.getInputStream());
            BufferedReader br=new BufferedReader(new InputStreamReader(is));
            StringBuffer sb=new StringBuffer();
            if(br != null)
            {
                while ((line=br.readLine()) != null)
                {
                    sb.append(line+"n");
                }
            }else
            {
                return null;
            }
            return sb.toString();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(is != null)
            {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }
}
