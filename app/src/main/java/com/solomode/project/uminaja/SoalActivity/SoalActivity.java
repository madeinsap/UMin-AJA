package com.solomode.project.uminaja.SoalActivity;

import android.Manifest;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.location.LocationManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.solomode.project.uminaja.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class SoalActivity extends AppCompatActivity{
    List<Model> GetDataAdapter1 = new ArrayList<>();
    private List<String> search = new ArrayList<>();

    AutoCompleteTextView actv;

    private String m;

    RecyclerView recyclerView;
    RecyclerView.LayoutManager recyclerViewlayoutManager;
    RecyclerView.Adapter recyclerViewadapter;

    public static String table;
    public static String jurusan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal);

        Toolbar mActionBarToolbar = (Toolbar) findViewById(R.id.toolbar_main);
        TextView tittle = (TextView) findViewById(R.id.tittle);
        TextView subtittle = (TextView) findViewById(R.id.subtittle);

        setSupportActionBar(mActionBarToolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        tittle.setText(jurusan);
        subtittle.setText(table);

        actv = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView);

        GetDataAdapter1 = new ArrayList<>();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerViewlayoutManager = new GridLayoutManager(this, 1);
        recyclerView.setLayoutManager(recyclerViewlayoutManager);
        recyclerViewadapter = new Adapter(GetDataAdapter1, this);
        recyclerView.setAdapter(recyclerViewadapter);

        ambilData();
    }

    public void ambilData(){
        GetDataAdapter1.clear();
        try {
            InputStream inputstream = getResources().getAssets().open(jurusan+"/"+table+".json");
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputstream));
            m = reader.toString();
            StringBuilder total = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                total.append(line);
            }
            m = total.toString();
        } catch (IOException ex) {
            Toast.makeText(getApplicationContext(), "fail", Toast.LENGTH_SHORT).show();
        }

        try {
            JSONObject jsonObject = new JSONObject(m);
            JSONArray jsonArray = jsonObject.optJSONArray("matkul");
            int arraylength = jsonArray.length();

            for (int i = 0; i < arraylength; i++) {
                Model GetDataAdapter2 = new Model();
                JSONObject json = jsonArray.getJSONObject(i);
                GetDataAdapter2.setSoal(json.getString("soal"));
                GetDataAdapter2.setJawaban(json.getString("jawaban"));

                search.add(json.getString("soal"));
                GetDataAdapter1.add(GetDataAdapter2);
            }

            ArrayAdapter<String> adapter= new ArrayAdapter<>(this,
                    android.R.layout.simple_spinner_dropdown_item, search);
            actv.setAdapter(adapter);
            actv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    actv.setText("");
                }
            });

            actv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick (AdapterView<?> parent, View view, int position, long id) {
                    String s=parent.getItemAtPosition(position).toString();
                    int pos= search.indexOf(s);
                    recyclerView.scrollToPosition(pos);
                }
            });

            recyclerViewadapter = new Adapter(GetDataAdapter1, this);
            recyclerView.setAdapter(recyclerViewadapter);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(menuItem);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
