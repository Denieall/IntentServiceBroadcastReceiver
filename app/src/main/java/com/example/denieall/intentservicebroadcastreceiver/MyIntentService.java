package com.example.denieall.intentservicebroadcastreceiver;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import com.example.denieall.intentservicebroadcastreceiver.MainActivity;

public class MyIntentService extends IntentService {

    final String TAG = "Test Intent Service: ";

    public static final String PROGRESS_COUNTER = "Progress";

    public MyIntentService() {
        super("MyIntentService");
    }

     @Override
    protected void onHandleIntent(Intent intent) {

        Intent broadcastIntent;

        int i = 0;

        while(i <= 100) {

            try {

                broadcastIntent = new Intent();
                broadcastIntent.putExtra("Progress", i);
                broadcastIntent.setAction(MainActivity.MYINTENTFILTER);
                sendBroadcast(broadcastIntent);

                Thread.sleep(3000);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            i = i + 20;
        }

    }
}
