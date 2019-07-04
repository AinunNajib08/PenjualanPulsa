package com.najib.data;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import org.apache.http.HttpException;

public class MainActivity extends AppCompatActivity{

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
    }

}
