package com.najib.clientandroid;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.najib.clientandroid.Rest.ApiRequest;
import com.najib.clientandroid.Rest.Retroserver;
import com.najib.clientandroid.Rest.response.StatusResponse;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Random;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BeliPulsa extends AppCompatActivity {
    ProgressDialog progressDialog;
    private String refreshFlag = "0";
    Button buttonDaftar;
    private DatePickerDialog datePickerDialog;
    private SimpleDateFormat dateFormatter;
    private TextView tvDateResult;
    private EditText tanggal, nomor, id_trans, date;
    Spinner provider,nominal;
    TextView notif;
    Random rand = new Random();
    int n = rand.nextInt(2000000);

    public boolean checkNetworkConnection() {
        ConnectivityManager connMgr = (ConnectivityManager)
                getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        boolean isConnected = false;
        if (networkInfo != null && (isConnected = networkInfo.isConnected())) {
            // show "Connected" & type of network "WIFI or MOBILE"
            Toast.makeText(this, "Terhubung", Toast.LENGTH_SHORT).show();


        } else {
            Toast.makeText(this, "Tidak Terhubung", Toast.LENGTH_SHORT).show();
        }

        return isConnected;
    }

    private void showDateDialog(){
        Calendar newCalendar = Calendar.getInstance();
        datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {

            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {

                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);

                tanggal.setText(dateFormatter.format(newDate.getTime()));
            }

        },newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));

        datePickerDialog.show();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belipulsa);
        notif = (TextView) findViewById(R.id.notif);

        checkNetworkConnection();
        date = (EditText) findViewById(R.id.tanggal);
        id_trans = (EditText) findViewById(R.id.id_trans);
        provider = (Spinner) findViewById(R.id.provider);
        nominal = (Spinner) findViewById(R.id.nominal);
        nomor = (EditText) findViewById(R.id.nomor);
        buttonDaftar = findViewById(R.id.buttonBeli);

        id_trans.setText(""+n);
        progressDialog = new ProgressDialog(this);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        provider.setAdapter(adapter);

        ArrayAdapter<CharSequence> data= ArrayAdapter.createFromResource(this,
                R.array.nominal, android.R.layout.simple_spinner_item);
        data.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        nominal.setAdapter(data);
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
        tvDateResult = (TextView) findViewById(R.id.date);
        tanggal = (EditText) findViewById(R.id.tanggal);
        tanggal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();
            }
        });

        buttonDaftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                progressDialog.setMessage("Loading ...");
                progressDialog.setCancelable(false);
                progressDialog.show();

                refreshFlag = "1";
                send();
                String id_transset = id_trans.getText().toString();
                String operatorset = provider.getSelectedItem().toString();
                String nominalset = nominal.getSelectedItem().toString();
                String nomorset = nomor.getText().toString();

                ApiRequest api = Retroserver.getClient().create(ApiRequest.class);
                Call<StatusResponse> postItem = api.postItem(id_transset, operatorset, nominalset, "6000", nomorset);
                postItem.enqueue(new Callback<StatusResponse>() {
                    @Override
                    public void onResponse(Call<StatusResponse> call, Response<StatusResponse> response) {
                        progressDialog.hide();
                        String status = response.body().getStatus();

                        if (status.equals("success")) {
                            Toast.makeText(BeliPulsa.this, "Data berhasil disimpan", Toast.LENGTH_SHORT).show();
                            finish();
                        } else {
                            Toast.makeText(BeliPulsa.this, "Data gagal disimpan", Toast
                                    .LENGTH_SHORT).show();
                        }

                    }

                    @Override
                    public void onFailure(Call<StatusResponse> call, Throwable t) {

                    }
                });
            }
        });

    }



    private String httpPost(String myUrl) throws IOException, JSONException {
        String result = "";

        URL url = new URL(myUrl);

        // 1. create HttpURLConnection
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("POST");
        conn.setRequestProperty("Content-Type", "application/json; charset=utf-8");

        // 2. build JSON object
        JSONObject jsonObject = buidJsonObject();

        // 3. add JSON content to POST request body
        setPostRequestContent(conn, jsonObject);

        // 4. make POST request to the given URL
        conn.connect();

        // 5. return response message
        return conn.getResponseMessage()+"";

    }

    public void tambah(View view) {
        n++;
        id_trans.setText(""+n);
    }


    private class HTTPAsyncTask extends AsyncTask<String, Void, String> {
        @Override
        protected String doInBackground(String... urls) {
            // params comes from the execute() call: params[0] is the url.
            try {
                try {
                    return httpPost(urls[0]);
                } catch (JSONException e) {
                    e.printStackTrace();
                    return "Error!";
                }
            } catch (IOException e) {
                return "Unable to retrieve web page. URL may be invalid.";
            }
        }
        // onPostExecute displays the results of the AsyncTask.
        @Override
        protected void onPostExecute(String result) {
            notif.setText(result);
        }
    }


    public void send() {
        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
        if(checkNetworkConnection())
            new HTTPAsyncTask().execute("http://192.168.43.1:8000");
        else
            Toast.makeText(this, "Not Connected!", Toast.LENGTH_SHORT).show();

    }

    private JSONObject buidJsonObject() throws JSONException {
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("no", 3636);
        jsonObject.put("pesan",  "BeliPulsa "+nominal.getSelectedItem().toString()+" Nomor "+nomor.getText().toString());

        return jsonObject;
    }

    private void setPostRequestContent(HttpURLConnection conn, JSONObject jsonObject) throws IOException {

        OutputStream os = conn.getOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
        writer.write(jsonObject.toString());
        Log.i(MainActivity.class.toString(), jsonObject.toString());
        writer.flush();
        writer.close();
        os.close();
    }
}
