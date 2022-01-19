/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Environment
 *  android.util.Log
 */
package com.eamobile.licensing;

import android.os.Environment;
import android.util.Log;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class z {
    public static boolean a = false;
    static OutputStream b = null;

    public static void a() {
        if (!a) return;
        String string2 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/debug.txt";
        try {
            b = new FileOutputStream(string2, true);
            return;
        }
        catch (Throwable throwable) {
            throwable.printStackTrace();
            return;
        }
    }

    public static void a(String string2) {
        if (!a) return;
        Log.w((String)"DownloadActivity", (String)string2);
        try {
            b.write((string2 + "\n").getBytes());
            return;
        }
        catch (IOException iOException) {
            return;
        }
    }

    public static void b() {
        if (!a) return;
        try {
            b.flush();
            b.close();
            return;
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
            return;
        }
    }
}

