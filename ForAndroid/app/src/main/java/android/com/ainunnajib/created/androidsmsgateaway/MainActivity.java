package android.com.ainunnajib.created.androidsmsgateaway;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import org.apache.http.HttpException;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    public static MainActivity ma;
    private SmsGatewayServer server;
    public MainActivity() {
// TODO membuat server
        server = new SmsGatewayServer(8989);
    }
    protected Cursor cursor;
    DataHelper dataHelper;
    TextView trans, nomor, pesan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dataHelper = new DataHelper(this);

        trans = findViewById(R.id.trans);
        nomor = findViewById(R.id.nomor);
        pesan = findViewById(R.id.pesan);

        SQLiteDatabase db = dataHelper.getReadableDatabase();
        cursor = db.rawQuery("SELECT * FROM biodata ORDER BY nos DESC LIMIT 1",null);
        cursor.moveToFirst();

        trans.setText(cursor.getString(0));
        nomor.setText(cursor.getString(1));
        pesan.setText(cursor.getString(2));

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
    }
}
