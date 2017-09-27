package com.solomode.project.uminaja.InsertReportActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.solomode.project.uminaja.AboutActivity.AboutActivity;
import com.solomode.project.uminaja.MainActivity.MainActivity;
import com.solomode.project.uminaja.R;
import com.solomode.project.uminaja.TipsActivity.TipsActivity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class InsertReportActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    String url = "http://insapol.esy.es/um/v1/Api.php?apicall=insertData";
    private static final int CODE_POST_REQUEST = 1025;
    String status, tittle, subtittle;

    Spinner spinnerTittle;
    EditText editSubtittle;
    ProgressBar progressBar;

    ImageButton buttonSend;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_insert_report);

        Toolbar toolbarMain = (Toolbar)findViewById(R.id.toolbar_main);
        setSupportActionBar(toolbarMain);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        status = "unsolved";

        editSubtittle = (EditText) findViewById(R.id.subtittle);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        spinnerTittle = (Spinner) findViewById(R.id.tittle);

        spinnerTittle.setOnItemSelectedListener(this);

        ArrayAdapter dataAdapter = ArrayAdapter.createFromResource(this, R.array.spinner_arrays, R.layout.spinner_text);
        dataAdapter.setDropDownViewResource(R.layout.spinner_dropdown);
        spinnerTittle.setAdapter(dataAdapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int position, long id) {
        tittle = adapterView.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void insertData() {
        String txtTittle = tittle;
        String txtSubtittle = editSubtittle.getText().toString().trim();
        String txtStatus = status;

        if (TextUtils.isEmpty(txtSubtittle)) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(InsertReportActivity.this);
            alertDialogBuilder
                    .setMessage("Masukan keluhan anda")
                    .setCancelable(true)
                    .setNeutralButton("Ok",new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog,int id) {
                            dialog.cancel();
                        }
                    });
            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
        }

        else{
            HashMap<String, String> params = new HashMap<>();
            params.put("tittle", txtTittle);
            params.put("subtittle", txtSubtittle);
            params.put("status", status);

            //Calling the create hero API
            PerformNetworkRequest request = new PerformNetworkRequest(url, params, CODE_POST_REQUEST);
            request.execute();
        }
    }

    private class PerformNetworkRequest extends AsyncTask<Void, Void, String> {
        String url;
        HashMap<String, String> params;
        int requestCode;

        PerformNetworkRequest(String url, HashMap<String, String> params, int requestCode) {
            this.url = url;
            this.params = params;
            this.requestCode = requestCode;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            progressBar.setVisibility(View.VISIBLE);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            progressBar.setVisibility(View.GONE);
            try {
                JSONObject object = new JSONObject(s);
                if (!object.getBoolean("error")) {
                    Toast.makeText(getApplicationContext(), object.getString("message"), Toast.LENGTH_SHORT).show();
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }

            onBackPressed();
        }

        @Override
        protected String doInBackground(Void... voids) {
            RequestHandler requestHandler = new RequestHandler();

            if (requestCode == CODE_POST_REQUEST)
                return requestHandler.sendPostRequest(url, params);

            return null;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.option_report, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;

            case R.id.send:
                insertData();
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
