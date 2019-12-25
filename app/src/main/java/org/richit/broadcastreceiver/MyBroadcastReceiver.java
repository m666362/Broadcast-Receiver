package org.richit.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.media.ToneGenerator;
import android.util.Log;
import android.widget.Toast;

public class MyBroadcastReceiver extends BroadcastReceiver {

    String TAG = this.getClass().getSimpleName();

    @Override
    public void onReceive(Context context, Intent intent) {
        ToneGenerator toneGenerator = new ToneGenerator( AudioManager.STREAM_MUSIC, 1000 );
        if(intent.getAction().equals( Intent.ACTION_HEADSET_PLUG )){

            int state = intent.getIntExtra( "state", -1 );
            switch (state){
                case 0:
                    Log.d(TAG, "Headphone Unplugged");
                    Toast.makeText( context, "Headphone Unplugged", Toast.LENGTH_SHORT).show();
                    toneGenerator.startTone( ToneGenerator.TONE_CDMA_ABBR_ALERT, 3000 );
                    break;
                case 1:
                    Log.d(TAG, "Headphone Plugged in");
                    Toast.makeText( context, "Headphone Plugged in", Toast.LENGTH_SHORT).show();
                    toneGenerator.startTone( ToneGenerator.TONE_CDMA_ABBR_ALERT, 3000 );
                    break;
                default:
                    Log.d(TAG, "Default state");
                    Toast.makeText( context, "Default state", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

}
