package com.devmenu.server;

import android.app.Application;

import com.devmenu.server.util.UtilitiesAndData;

import java.io.File;

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        UtilitiesAndData.init(this);

        File svmw = new File(UtilitiesAndData.getSVMWCacheStorage());
        if(!svmw.exists()) svmw.mkdir();

        File folderToTrack = new File(UtilitiesAndData.getExternalStorage() + "/saveTracking");
        if(!folderToTrack.exists()) folderToTrack.mkdir();

    }
}
