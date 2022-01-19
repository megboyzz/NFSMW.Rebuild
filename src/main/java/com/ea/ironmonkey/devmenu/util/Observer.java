package com.ea.ironmonkey.devmenu.util;

import android.util.Log;

public class Observer {

    private static final String LOG_TAG = "Observer";

    public static void onCallingMethod(){
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();

        Log.i(LOG_TAG, "info{");

        for(int i = 1; i < stackTrace.length; i++) {
            Log.i(LOG_TAG, "\t" + stackTrace[i]);
        }

        Log.i(LOG_TAG, "}");
    }


}

