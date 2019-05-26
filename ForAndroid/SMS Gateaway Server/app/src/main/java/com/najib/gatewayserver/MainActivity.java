package com.najib.gatewayserver;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity extends AppCompatActivity {
    public static MainActivity ma;
    private SmsGatewayServer server;
    public MainActivity() {
// TODO membuat server
        server = new SmsGatewayServer(8989);
    }
    protected Cursor cursor;
    private ListView listView;
    TextView id_ui,nomor_ui,provider_ui,jumlah_ui,status_ui;

    private String JSON_STRING;
    private String id = "1";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        id_ui = findViewById(R.id.id_ui);
        nomor_ui = findViewById(R.id.nomor);
        provider_ui = findViewById(R.id.provider);
        jumlah_ui = findViewById(R.id.jumlah);
        status_ui = findViewById(R.id.status);

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    server.start();
                } catch (IOException e) {
                    Log.e(MainActivity.class.getName(), e.getMessage(), e);
                } catch (HttpException e) {
                    Log.e(MainActivity.class.getName(), e.getMessage(), e);
                }
            }
        }).start();
    }

    void getData(){
// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);

        String url = "https://dissentient-keyword.000webhostapp.com/Android/pegawai/tampilPgw.php?id=17";

        JSONObject jsonBody = new JSONObject();
        final String requestBody = jsonBody.toString();

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
//menaruh data JSON kkedalam variabel JSON Object
                            JSONObject jsonPost = new JSONObject(response.toString());
                            id_ui.setText(jsonPost.getString("id"));
                            nomor_ui.setText(jsonPost.getString("name"));
                            provider_ui.setText(jsonPost.getString("desg"));
                            jumlah_ui.setText(jsonPost.getString("salary"));

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error Response",error.toString());
            }
        });
// Add the request to the RequestQueue.
        queue.add(stringRequest);

    }

    @Override
    protected void onDestroy() {
        // menghentikan server
        try {
            server.stop();
        } catch (IOException e) {
            Log.e(MainActivity.class.getName(), e.getMessage(), e);
        }
// TODO menghentikan server
        super.onDestroy();
        Toast.makeText(MainActivity.this, "Kata", Toast.LENGTH_SHORT).show();
    }

    public void Baru(View view) {
        Intent intent = new Intent(MainActivity.this, SmsGatewayHandler.class);
        startActivity(intent);
    }
    JSONObject jsonObject = null;

    private void showEmployee() {
        try {
            JSONObject jsonObject = new JSONObject(JSON_STRING);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);
            for(int i = 0; i<result.length(); i++) {
                JSONObject c = result.getJSONObject(i);
                String nomor = c.getString(konfigurasi.TAG_NOMOR);
                String provider = c.getString(konfigurasi.TAG_PROVIDER);
                String jumlah = c.getString(konfigurasi.TAG_JUMLAH);
                String status = c.getString(konfigurasi.TAG_STATUS);

                nomor_ui.setText(nomor);
                provider_ui.setText(provider);
                jumlah_ui.setText(jumlah);
                status_ui.setText(status);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    private void getJSON(){
        class GetJSON extends AsyncTask<Void,Void,String>{

            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(MainActivity.this,"Mengambil Data","Mohon Tunggu...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                JSON_STRING = s;
                showEmployee();
            }

            @Override
            protected String doInBackground(Void... params) {
                RequestHandler rh = new RequestHandler();
                String s = rh.sendGetRequest(konfigurasi.URL_GET_ALL);
                return s;
            }
        }
        GetJSON gj = new GetJSON();
        gj.execute();
    }
}
