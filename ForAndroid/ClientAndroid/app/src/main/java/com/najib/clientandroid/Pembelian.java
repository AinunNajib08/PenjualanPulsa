package com.najib.clientandroid;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Pembelian extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pembelian);
    }

    public void belipulsa(View view) {
        Intent beli = new Intent(this, BeliPulsa.class);
        startActivity(beli);
    }

    public void cekdat(View view) {
        Intent beli = new Intent(this, CekActivity.class);
        startActivity(beli);
    }
}
