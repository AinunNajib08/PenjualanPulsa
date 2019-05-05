package android.com.penjualanpulsa;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void belipulsa(View view) {
        Intent belipulsa = new Intent(MainActivity.this, android.com.penjualanpulsa.belipulsa.class );
        startActivity(belipulsa);
    }


}
