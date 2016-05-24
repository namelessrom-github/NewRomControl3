package com.nammeless.romcontrol;

import android.app.Service;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.IBinder;
import android.support.v7.app.AlertDialog;
import android.view.WindowManager;

public class BootRestoreService extends Service {

    public BootRestoreService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public void onCreate() {
        super.onCreate();
        showConfirmDialog();
    }

    private void showConfirmDialog() {

        AlertDialog confirm = new AlertDialog.Builder(this)
                .setMessage(R.string.confirm_restore)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                RestorePreferences rp = new RestorePreferences(BootRestoreService.this);
                                rp.restoreSettings();
                                BootRestoreService.this.stopSelf();
                            }
                        }

                )
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        BootRestoreService.this.stopSelf();


                    }
                })
                .create();
        confirm.getWindow().setType(WindowManager.LayoutParams.TYPE_SYSTEM_ALERT);
        confirm.show();


    }
}