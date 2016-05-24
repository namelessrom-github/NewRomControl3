package com.nammeless.romcontrol;

import android.app.Activity;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Environment;
import android.provider.Settings;
import android.support.v7.app.AlertDialog;
import android.support.v7.view.ContextThemeWrapper;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class RestorePreferences {
    ContentResolver cr;
    Context c;
    File sddir = new File(Environment.getExternalStorageDirectory().getPath()+"/RomControl");
    File bkpdir = new File(sddir +"/backup");

    public RestorePreferences(Context context) {
        c = context;
        cr = c.getContentResolver();

    }

    public void showConfirmDialog() {
        //first of all we will display a popup that if confirm will start the real restore
        AlertDialog confirm = new AlertDialog.Builder(new ContextThemeWrapper(c, R.style.AppTheme))
                .setMessage(R.string.confirm_restore)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //here we call the method that is going to restore
                                restoreSettings();
                            }
                        }

                )
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();

                    }
                })
                .create();
        confirm.show();
    }

    public void restoreSettings() {
        //first of all we delete any existing file in our special file preference folder
        //by check if list of files inside the folder is not null and if so delete each one
        File deletecurr = new File(c.getFilesDir()+"/FilePrefs");
        if (deletecurr.listFiles() != null) {
            for (File deleteBkp : deletecurr.listFiles()) {
                deleteBkp.delete();

            }
        }
        //now we read the backup preference file
        File file = new File(bkpdir +"/prefs.txt");
        if (file.exists())
            try {
                BufferedReader br = new BufferedReader(new FileReader(file));
                //for each line of the file we spilt it into before the ":" the key part and after the value
                for (String line = br.readLine(); line != null; line = br.readLine()) {
                    String key = line.substring(0, line.indexOf(":"));
                    String value = line.substring(line.indexOf(" ") + 1, line.length());
                    //if value is a bolean we replace the preference value with a value suitable for database
                    //then we are ready to write into db
                    if (value.equals("false")) {
                        Settings.System.putString(cr, String.valueOf(key), "0");
                    } else if (value.equals("true")) {
                        Settings.System.putString(cr, String.valueOf(key), "1");
                    } else
                        Settings.System.putString(cr, String.valueOf(key), String.valueOf(value));
                }
            } catch (IOException e) {
            }
        //now we read the special prefs file
        for (File files : bkpdir.listFiles()) {
            if (files.isFile()) {
                Log.d("restore", "found file"+ files);
                String name = files.getName();
                if (!name.endsWith(".txt")) {
                    Log.d("restore", "file is not txt");
                    File filerestore = new File(deletecurr +"/" + name);
                    Log.d("restore", name);
                    try {
                        filerestore.createNewFile();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        if (c instanceof MainViewActivity) {
            ((Activity) c).finish();
            Intent start = new Intent(c, MainViewActivity.class);
            start.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            c.startActivity(start);
        }
    }

}