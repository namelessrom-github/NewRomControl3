#!/system/bin/sh

mount -o rw,remount /data

cp -rf /sdcard/nbackups/databases /data/data/com.android.providers.settings

pkill zygote