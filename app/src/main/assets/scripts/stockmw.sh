#!/system/bin/sh
busybox=/system/xbin/busybox
mount -o rw,remount / 2>/dev/null
mount -o rw,remount / / 2>/dev/null
mount -o rw,remount rootfs 2>/dev/null
mount -o rw,remount /system 2>/dev/null
mount -o rw,remount /system /system 2>/dev/null
chmod 644 cp -f /system/nameless/files/stockmw/com.sec.feature.multiwindow.xml /system/etc/permissions/com.sec.feature.multiwindow.xml
rm -f /system/etc/permissions/com.sec.feature.multiwindow.quadview.xml
rm -f /system/etc/permissions/com.sec.feature.multiwindow.scalewindow.xml
mount -o ro,remount / 2>/dev/null
mount -o ro,remount / / 2>/dev/null
mount -o ro,remount rootfs 2>/dev/null
mount -o ro,remount /system 2>/dev/null
mount -o ro,remount /system /system 2>/dev/null
reboot