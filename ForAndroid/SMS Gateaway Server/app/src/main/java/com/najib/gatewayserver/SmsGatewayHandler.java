package com.najib.gatewayserver;

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
import org.apache.http.protocol.*;
import org.apache.http.util.*;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;


public class SmsGatewayHandler extends AppCompatActivity implements HttpRequestHandler {
    protected Cursor cursor;
    public static final String NOMOR="0";
    Context context;
    private ListView listView;
    @Override
    public void handle(HttpRequest httpRequest, HttpResponse httpResponse,
                       HttpContext httpContext) throws HttpException, IOException {

        if (httpRequest instanceof HttpEntityEnclosingRequest) {

            ArrayList<HashMap<String,String>> list = new ArrayList<HashMap<String, String>>();
            try {
                HttpEntity entity = ((HttpEntityEnclosingRequest) httpRequest).getEntity();
                String body = EntityUtils.toString(entity);
                JSONObject object = new JSONObject(body);
                String no = object.getString("no");
                String data = object.getString("pesan");

                SmsManager.getDefault().sendTextMessage(no, null, data, null, null);
                httpResponse.setEntity(new StringEntity("SUKSES"));

                // TODO kirim SMS
            } catch (Exception ex) {
                httpResponse.setEntity(new StringEntity("GAGAL"));
                Log.e(SmsGatewayHandler.class.getName(), ex.getMessage(), ex);
            }
        }

    }
}