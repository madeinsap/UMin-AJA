package com.solomode.project.uminaja.MatkulActivity;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.TextView;

import com.solomode.project.uminaja.R;
import com.solomode.project.uminaja.SoalActivity.SoalActivity;

import java.io.IOException;

public class MatkulActivity extends AppCompatActivity {

    int images[] = {R.drawable.background1, R.drawable.background2, R.drawable.background3, R.drawable.background4,
            R.drawable.background5, R.drawable.background6, R.drawable.background7, R.drawable.background8,
    };

    int logos[];
    String labels[];
    String jurusan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matkul);

        Toolbar toolbarMain = (Toolbar)findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbarMain);
        TextView tittle = (TextView) findViewById(R.id.tittle);

        Intent intent = getIntent();
        SoalActivity.jurusan = (intent.getStringExtra("labels"));
        jurusan = intent.getStringExtra("labels");

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        tittle.setText(jurusan);

        final AssetManager assetManager = getAssets();

        if(jurusan.equals("informatika")){
            try {
                String[] filelistInSubfolder = assetManager.list("informatika");
                labels = new String[filelistInSubfolder.length];
                if (filelistInSubfolder == null) {
                    labels = new String[]{
                            "Belum Tersedia"
                    };
                } else {
                    for (int i=0; i<filelistInSubfolder.length; i++) {
                        labels [i] = filelistInSubfolder[i].replaceAll(".json$", "");
                        Log.d("labels", "labels = "+i + "= " + labels[i]);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if(jurusan.equals("industri")){
            try {
                String[] filelistInSubfolder = assetManager.list("industri");
                labels = new String[filelistInSubfolder.length];
                if (filelistInSubfolder == null) {
                    labels = new String[]{
                            "Belum Tersedia"
                    };
                } else {
                    for (int i=0; i<filelistInSubfolder.length; i++) {
                        labels [i] = filelistInSubfolder[i].replaceAll(".json$", "");
                        Log.d("labels", "labels = "+i + "= " + labels[i]);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if(jurusan.equals("mesin")){
            try {
                String[] filelistInSubfolder = assetManager.list("mesin");
                labels = new String[filelistInSubfolder.length];
                if (filelistInSubfolder == null) {
                    labels = new String[]{
                            "Belum Tersedia"
                    };
                } else {
                    for (int i=0; i<filelistInSubfolder.length; i++) {
                        labels [i] = filelistInSubfolder[i].replaceAll(".json$", "");
                        Log.d("labels", "labels = "+i + "= " + labels[i]);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if(jurusan.equals("elektro")){
            try {
                String[] filelistInSubfolder = assetManager.list("elektro");
                labels = new String[filelistInSubfolder.length];
                if (filelistInSubfolder == null) {
                    labels = new String[]{
                            "Belum Tersedia"
                    };
                } else {
                    for (int i=0; i<filelistInSubfolder.length; i++) {
                        labels [i] = filelistInSubfolder[i].replaceAll(".json$", "");
                        Log.d("labels", "labels = "+i + "= " + labels[i]);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if(jurusan.equals("sastra")){
            try {
                String[] filelistInSubfolder = assetManager.list("sastra");
                labels = new String[filelistInSubfolder.length];
                if (filelistInSubfolder == null) {
                    labels = new String[]{
                            "Belum Tersedia"
                    };
                } else {
                    for (int i=0; i<filelistInSubfolder.length; i++) {
                        labels [i] = filelistInSubfolder[i].replaceAll(".json$", "");
                        Log.d("labels", "labels = "+i + "= " + labels[i]);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if(jurusan.equals("sisfor")){
            try {
                String[] filelistInSubfolder = assetManager.list("sisfor");
                labels = new String[filelistInSubfolder.length];
                if (filelistInSubfolder == null) {
                    labels = new String[]{
                            "Belum Tersedia"
                    };
                } else {
                    for (int i=0; i<filelistInSubfolder.length; i++) {
                        labels [i] = filelistInSubfolder[i].replaceAll(".json$", "");
                        Log.d("labels", "labels = "+i + "= " + labels[i]);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if(jurusan.equals("siskom")){
            try {
                String[] filelistInSubfolder = assetManager.list("siskom");
                labels = new String[filelistInSubfolder.length];
                if (filelistInSubfolder == null) {
                    labels = new String[]{
                            "Belum Tersedia"
                    };
                } else {
                    for (int i=0; i<filelistInSubfolder.length; i++) {
                        labels [i] = filelistInSubfolder[i].replaceAll(".json$", "");
                        Log.d("labels", "labels = "+i + "= " + labels[i]);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if(jurusan.equals("sipil")){
            try {
                String[] filelistInSubfolder = assetManager.list("sipil");
                labels = new String[filelistInSubfolder.length];
                if (filelistInSubfolder == null) {
                    labels = new String[]{
                            "Belum Tersedia"
                    };
                } else {
                    for (int i=0; i<filelistInSubfolder.length; i++) {
                        labels [i] = filelistInSubfolder[i].replaceAll(".json$", "");
                        Log.d("labels", "labels = "+i + "= " + labels[i]);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if(jurusan.equals("arsitektur")){
            try {
                String[] filelistInSubfolder = assetManager.list("arsitektur");
                labels = new String[filelistInSubfolder.length];
                if (filelistInSubfolder == null) {
                    labels = new String[]{
                            "Belum Tersedia"
                    };
                } else {
                    for (int i=0; i<filelistInSubfolder.length; i++) {
                        labels [i] = filelistInSubfolder[i].replaceAll(".json$", "");
                        Log.d("labels", "labels = "+i + "= " + labels[i]);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if(jurusan.equals("akuntansi")){
            try {
                String[] filelistInSubfolder = assetManager.list("akuntansi");
                labels = new String[filelistInSubfolder.length];
                if (filelistInSubfolder == null) {
                    labels = new String[]{
                            "Belum Tersedia"
                    };
                } else {
                    for (int i=0; i<filelistInSubfolder.length; i++) {
                        labels [i] = filelistInSubfolder[i].replaceAll(".json$", "");
                        Log.d("labels", "labels = "+i + "= " + labels[i]);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if(jurusan.equals("management")){
            try {
                String[] filelistInSubfolder = assetManager.list("management");
                labels = new String[filelistInSubfolder.length];
                if (filelistInSubfolder == null) {
                    labels = new String[]{
                            "Belum Tersedia"
                    };
                } else {
                    for (int i=0; i<filelistInSubfolder.length; i++) {
                        labels [i] = filelistInSubfolder[i].replaceAll(".json$", "");
                        Log.d("labels", "labels = "+i + "= " + labels[i]);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else if(jurusan.equals("psikologi")){
            try {
                String[] filelistInSubfolder = assetManager.list("psikologi");
                labels = new String[filelistInSubfolder.length];
                if (filelistInSubfolder == null) {
                    labels = new String[]{
                            "Belum Tersedia"
                    };
                } else {
                    for (int i=0; i<filelistInSubfolder.length; i++) {
                        labels [i] = filelistInSubfolder[i].replaceAll(".json$", "");
                        Log.d("labels", "labels = "+i + "= " + labels[i]);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        else{
            labels = new String[]{
                    "Belum Tersedia"
            };
        }

        logos = new int[labels.length];
        int selected=0;
        for(int loop = 0; loop < labels.length; loop++){
            logos[loop] = images[selected];
            selected++;
            Log.d("array", "my logos array"+loop+"="+logos[loop]);
            if(selected>7){
                selected=0;
            }
        }

        GridView grid = (GridView) findViewById(R.id.grid_home);

        MatkulAdapter semAdapter = new MatkulAdapter(getApplicationContext(),labels, logos);
        grid.setAdapter(semAdapter);
        // implement setOnItemClickListener event on GridView
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MatkulActivity.this, SoalActivity.class);
                SoalActivity.table = labels[position];
                startActivity(intent);
            }
        });
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
