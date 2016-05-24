export PATH=/system/bin:$PATH
mount -o rw,remount /system
rm -f -r /data/system/batterystats.bin
reboot
