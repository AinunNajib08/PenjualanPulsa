package com.najib.clientandroid;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.najib.clientandroid.Rest.ApiClient;
import com.najib.clientandroid.Rest.ApiInterface;
import com.najib.clientandroid.adapter.PulsaAdapter;
import com.najib.clientandroid.model.GetPulsa;
import com.najib.clientandroid.model.Item;
import com.najib.clientandroid.model.Pulsa;
import com.najib.clientandroid.utils.RecyclerItemClickListener;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CekActivity extends AppCompatActivity {
    ApiInterface mApiInterface;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    public static CekActivity ma;
    private RecyclerView mRecycler;
    private RecyclerView.LayoutManager mManager;
    private List<Item> mItems = new ArrayList<>();
    ProgressDialog progressDialog;

    private static final int REQUEST_CODE_ADD = 1;
    private static final int REQUEST_CODE_EDIT = 2;

    public CekActivity() {
        // Required empty public constructor
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cek);


        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mLayoutManager = new LinearLayoutManager(this);
        mRecyclerView.setLayoutManager(mLayoutManager);
        mApiInterface = ApiClient.getClient().create(ApiInterface.class);
        ma=this;
        refresh();
    }

    public void refresh() {
        Call<GetPulsa> PulsaCall = mApiInterface.getPulsaa();
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


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_CODE_ADD: {
                if (resultCode == RESULT_OK && null != data) {
                    if (data.getStringExtra("refreshFlag").equals("1")) {
                        refresh();
                    }
                }
                break;
            }
            case REQUEST_CODE_EDIT: {
                if (resultCode == RESULT_OK && null != data) {
                    if (data.getStringExtra("refreshFlag").equals("1")) {
                        refresh();
                    }
                }
                break;
            }
        }
    }

}
