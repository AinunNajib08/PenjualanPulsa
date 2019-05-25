package android.com.ainunnajib.created.androidsmsgateaway;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

public class MainActivity extends AppCompatActivity {
    public static MainActivity ma;
    private SmsGatewayServer server;
    public MainActivity() {
// TODO membuat server
        server = new SmsGatewayServer(8989);
    }
    protected Cursor cursor;
    private ListView listView;
    TextView nomor,provider,jumlah,status;

    private String JSON_STRING;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nomor = findViewById(R.id.nomor);
        provider = findViewById(R.id.provider);
        jumlah = findViewById(R.id.jumlah);
        status = findViewById(R.id.status);

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

    private void showEmployee(String json) {
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(konfigurasi.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            String nomor = c.getString(konfigurasi.TAG_NOMOR);
            String provider = c.getString(konfigurasi.TAG_PROVIDER);
            String jumlah = c.getString(konfigurasi.TAG_JUMLAH);
            String status = c.getString(konfigurasi.TAG_STATUS);


        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
