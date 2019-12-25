package org.richit.broadcastreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    MyBroadcastReceiver myBroadcastReceiver;
    IntentFilter intentFilter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        myBroadcastReceiver = new MyBroadcastReceiver();
        intentFilter = new IntentFilter( Intent.ACTION_HEADSET_PLUG );
    }

//    public void broadcastIntent(View view) {
//        Intent intent = new Intent();
//        intent.setAction("CUSTOM_INTENT");
//        sendBroadcast(intent);
//    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        registerReceiver( myBroadcastReceiver, intentFilter );
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver( myBroadcastReceiver );
    }

    public void broadcastIntent(View view) {
        registerReceiver( myBroadcastReceiver, intentFilter );
    }
}
