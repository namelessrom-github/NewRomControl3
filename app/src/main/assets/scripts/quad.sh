#!/system/bin/sh
busybox=/system/xbin/busybox
mount -o rw,remount / 2>/dev/null
mount -o rw,remount / / 2>/dev/null
mount -o rw,remount rootfs 2>/dev/null
mount -o rw,remount /system 2>/dev/null
mount -o rw,remount /system /system 2>/dev/null
cp -f /system/nameless/files/quad/com.sec.feature.multiwindow.quadview.xml /system/etc/permissions/com.sec.feature.multiwindow.quadview.xml
chmod 644 /system/etc/permissions/com.sec.feature.multiwindow.quadview.xml
cp -f /system/nameless/files/quad/com.sec.feature.multiwindow.scalewindow.xml /system/etc/permissions/com.sec.feature.multiwindow.scalewindow.xml
chmod 644 /system/etc/permissions/com.sec.feature.multiwindow.scalewindow.xml
cp -f /system/nameless/files/quad/com.sec.feature.multiwindow.xml /system/etc/permissions/com.sec.feature.multiwindow.xml
chmod 644 /system/etc/permissions/com.sec.feature.multiwindow.xml
mount -o ro,remount / 2>/dev/null
mount -o ro,remount / / 2>/dev/null
mount -o ro,remount rootfs 2>/dev/null
mount -o ro,remount /system 2>/dev/null
mount -o ro,remount /system /system 2>/dev/null
reboot