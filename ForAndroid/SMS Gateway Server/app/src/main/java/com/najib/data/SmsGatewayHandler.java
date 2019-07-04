package com.najib.data;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.ListView;

import org.apache.http.HttpEntity;
import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpException;
import org.apache.http.HttpRequest;
import org.apache.http.HttpResponse;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.HttpContext;
import org.apache.http.protocol.HttpRequestHandler;
import org.apache.http.util.EntityUtils;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class SmsGatewayHandler extends AppCompatActivity implements HttpRequestHandler {
    protected Cursor cursor;
    public static final String NOMOR = "0";
    Context context;
    private ListView listView;

    @Override
    public void handle(HttpRequest httpRequest, HttpResponse httpResponse,
                        HttpContext httpContext) throws HttpException, IOException {
        if (httpRequest instanceof HttpEntityEnclosingRequest) {
// HTTP request haruslah memiliki body
            try {
                HttpEntity entity = ((HttpEntityEnclosingRequest) httpRequest).getEntity();
// convert String body menjadi JSON
                String body = EntityUtils.toString(entity);
                JSONObject object = new JSONObject(body);
                // ambil no tujuan dari json
                String no = object.getString("no");
// ambil pesan dari json
                String pesan = object.getString("pesan");
// kirim SMS
                SmsManager.getDefault().sendTextMessage(no, null, pesan, null, null);
// beri respon SUKSES
                httpResponse.setEntity(new StringEntity("SUKSES"));
            } catch (Exception ex) {
// beri respon GAGAL
                httpResponse.setEntity(new StringEntity("GAGAL"));
                Log.e(SmsGatewayHandler.class.getName(), ex.getMessage(), ex);
            }
        }
    }

}