package com.najib.data;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.najib.data.Adapter.PulsaAdapter;
import com.najib.data.Model.GetPulsa;
import com.najib.data.Model.Pulsa;
import com.najib.data.Rest.ApiClient;
import com.najib.data.Rest.ApiInterface;

import org.apache.http.HttpException;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    Button btIns;
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static MainActivity ma;
    private SmsGatewayServer server;
    public MainActivity() {
        server = new SmsGatewayServer(8000);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma=this;
        refresh();
    }

    public void refresh() {
        Call<GetPulsa> PulsaCall = mApiInterface.getPulsa();
        PulsaCall.enqueue(new Callback<GetPulsa>() {
            @Override
            public void onResponse(Call<GetPulsa> call, Response<GetPulsa>
                    response) {
                List<Pulsa> PulsaList = response.body().getListDataKontak();
                Log.d("Retrofit Get", "Jumlah data Pulsa: " +
                        String.valueOf(PulsaList.size()));
                mAdapter = new PulsaAdapter(PulsaList);
                mRecyclerView.setAdapter(mAdapter);
            }

            @Override
            public void onFailure(Call<GetPulsa> call, Throwable t) {
                Log.e("Retrofit Get", t.toString());
            }
        });
    }
}
