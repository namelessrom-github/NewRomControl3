#!/system/bin/sh
export PATH=/system/bin:$PATH

mount -o rw,remount /system

cp -p /system/nameless/files/stockhost/hosts /system/etc/hosts
