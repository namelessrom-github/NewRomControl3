#!/system/bin/sh
export PATH=/system/bin:$PATH

mount -o rw,remount /system

cp -p /system/nameless/files/blockhost/hosts /system/etc/hosts
