package com.najib.clientandroid;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.najib.clientandroid.api.BaseApiService;
import com.najib.clientandroid.api.UtilsApi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    EditText etEmail;
    EditText etPassword;
    Button btnLogin;
    Button btnRegister;
    ProgressDialog loading;

    Context mContext;
    BaseApiService mApiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        etEmail = (EditText) findViewById(R.id.username);
        etPassword = (EditText) findViewById(R.id.password);
        btnLogin = (Button) findViewById(R.id.buttonlog);
        mContext = this;
        mApiService = UtilsApi.getAPIService();
        initComponents();

    }

    public void initComponents(){



        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loading = ProgressDialog.show(mContext,null , "Harap Tunggu ...", true, false);
                requestLogin();
            }
        });
    }

    public void requestLogin(){

        mApiService.loginRequest(etEmail.getText().toString(), etPassword.getText().toString())
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()){
                            loading.dismiss();
                            try {
                                JSONObject jsonRESULTS = new JSONObject(response.body().string());
                                if (jsonRESULTS.getString("status").equals("true")){
                                    JSONArray data = jsonRESULTS.getJSONArray("data");
                                    for (int i=0; i <data.length(); i++) {
                                        JSONObject jsonObject = data.getJSONObject(i);

                                        int id = jsonObject.getInt("id_akun");
                                        String nama = jsonObject.getString("username");
                                        Toast.makeText(mContext, "BERHASIL LOGIN", Toast.LENGTH_SHORT).show();
                                        Intent intent = new Intent(mContext, Pembelian.class);
                                        intent.putExtra("hasil_nama", nama);
                                        startActivity(intent);
                                    }

                                } else {
                                    String error_message = jsonRESULTS.getString("message");
                                    Toast.makeText(mContext, error_message, Toast.LENGTH_SHORT).show();
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        } else {
                            loading.dismiss();
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.e("debug", "onFailure: ERROR > " + t.toString());
                        loading.dismiss();
                    }
                });
    }
}
