package com.nammeless.romcontrol;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.preference.PreferenceManager;

import java.io.File;

public class BootCompleteReceiver extends BroadcastReceiver {
    File dir = new File(Environment.getExternalStorageDirectory().getPath()+"/RomControl");

    @Override
    public void onReceive(Context context, Intent intent) {
        boolean firstTime = PreferenceManager.getDefaultSharedPreferences(context).getBoolean("first_time", true);
        if (firstTime) {
            File file = new File(dir +"/auto_restore.txt");
            if (file.exists()) {
                context.startService(new Intent(context, BootRestoreService.class));
            }
        }
    }
}