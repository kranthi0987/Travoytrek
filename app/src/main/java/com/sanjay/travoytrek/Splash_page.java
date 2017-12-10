package com.sanjay.travoytrek;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

public class Splash_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_page);

        Timer t = new Timer();
        boolean checkConnection=new ApplicationUtility().checkConnection(this);
        if (checkConnection) {
            t.schedule(new splash(), 3000);
        } else {
            Toast.makeText(Splash_page.this,
                    "connection not found...plz check connection", 3000).show();
        }
    }

    class splash extends TimerTask {

        @Override
        public void run() {
            Intent i = new Intent(Splash_page.this,MainActivity.class);
            finish();
            startActivity(i);
        }


    }
}
