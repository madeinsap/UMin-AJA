package com.solomode.project.uminaja.AboutActivity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.solomode.project.uminaja.MatkulActivity.MatkulActivity;
import com.solomode.project.uminaja.MatkulActivity.MatkulAdapter;
import com.solomode.project.uminaja.R;

public class AboutActivity extends AppCompatActivity {

    int image = R.drawable.freepik;

    String labels[] = {"freepik", "artmonkey", "macrovector",
            "ibrandify", "makyzz", "Graphiqastock",
            "Titusurya", "Photoroyalty", "Dooder"
    };

    int logos[] = {

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        Toolbar toolbarMain = (Toolbar)findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbarMain);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        logos = new int[labels.length];
        for (int i=0; i<labels.length; i++) {
            logos [i] = image;
        }

        GridView grid = (GridView) findViewById(R.id.grid_home);

        AboutAdapter aboutAdapter = new AboutAdapter(getApplicationContext(), labels, logos);
        grid.setAdapter(aboutAdapter);

        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Uri uri = Uri.parse("http://www.freepik.com/"+labels[position]);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
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
