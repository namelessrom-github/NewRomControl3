#!/system/bin/sh

mount -o rw,remount /data

mkdir /sdcard/nbackups

cp -rf /data/data/com.android.providers.settings/databases /sdcard/nbackups