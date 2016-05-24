#!/system/bin/sh
busybox=/system/xbin/busybox
mount -o rw,remount / 2>/dev/null
mount -o rw,remount / / 2>/dev/null
mount -o rw,remount rootfs 2>/dev/null
mount -o rw,remount /system 2>/dev/null
mount -o rw,remount /system /system 2>/dev/null
cp -f /system/nameless/files/soundmodoff/mixer_paths.xml /system/etc/mixer_paths.xml
chmod 644 /system/etc/mixer_paths.xml
mount -o ro,remount / 2>/dev/null
mount -o ro,remount / / 2>/dev/null
mount -o ro,remount rootfs 2>/dev/null
mount -o ro,remount /system 2>/dev/null
mount -o ro,remount /system /system 2>/dev/null