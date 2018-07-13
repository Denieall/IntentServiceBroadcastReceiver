package com.example.denieall.intentservicebroadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    ProgressBar progressBar;

    public static final String MYINTENTFILTER = "com.denieall.PROGRESS";

    // Creating a receiver
    private BroadcastReceiver myReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            progressBar.setProgress(intent.getIntExtra("Progress", 0));

        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();

        unregisterReceiver(myReceiver);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button);
        Button btn_toast = findViewById(R.id.button_toast);
        progressBar = findViewById(R.id.progressBar2);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MyIntentService.class);
                startService(i);
            }
        });

        btn_toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(), "Hello", Toast.LENGTH_SHORT).show();
            }
        });

        // Creating IntentFilter --- is like creating own channel --- like radio channel
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(MYINTENTFILTER);
        registerReceiver(myReceiver, intentFilter);
    }


}
