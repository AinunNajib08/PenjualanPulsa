package android.com.ainunnajib.created.androidsmsgateaway;

import android.content.Context;
import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.provider.Telephony;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.protocol.*;
import org.apache.http.util.*;
import org.json.*;
import java.io.IOException;


public class SmsGatewayHandler extends AppCompatActivity implements HttpRequestHandler {
    protected Cursor cursor;
    public static final String NOMOR="0";
    String nilai;
    Context context;
    DataHelper dataHelper = new DataHelper(context);
    SQLiteDatabase db;

    @Override
    public void handle(HttpRequest httpRequest, HttpResponse httpResponse,
                       HttpContext httpContext) throws HttpException, IOException {

        if (httpRequest instanceof HttpEntityEnclosingRequest) {


            try {
                HttpEntity entity = ((HttpEntityEnclosingRequest) httpRequest).getEntity();
                String body = EntityUtils.toString(entity);
                JSONObject object = new JSONObject(body);
                String no = object.getString("no");
                String data = object.getString("pesan");

                db = dataHelper.getWritableDatabase();
                db.execSQL("insert into biodata(nos, nama, tgl, jk, alamat) values('899', 'Ainun', '04-08-2018', 'Pria','Pasar Lama')");


                SmsManager.getDefault().sendTextMessage(no, null, data, null, null);
                httpResponse.setEntity(new StringEntity("SUKSES"+nilai));

                // TODO kirim SMS
            } catch (Exception ex) {
                httpResponse.setEntity(new StringEntity("GAGAL"+nilai));
                Log.e(SmsGatewayHandler.class.getName(), ex.getMessage(), ex);
            }

        }

    }


}