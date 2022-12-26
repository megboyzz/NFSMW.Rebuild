package com.devmenu.server;

import android.app.Application;
import java.io.File;

public class MainApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        UtilitiesAndData.init(this);
        File folderToTrack = new File(UtilitiesAndData.getExternalStorage() + "/saveTracking");
        folderToTrack.mkdir();
    }
}
