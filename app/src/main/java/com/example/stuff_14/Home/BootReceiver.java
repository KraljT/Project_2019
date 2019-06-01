package com.example.stuff_14.Home;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.stuff_14.MainActivity;

public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, MainActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}