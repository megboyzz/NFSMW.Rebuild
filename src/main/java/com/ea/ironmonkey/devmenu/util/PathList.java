package com.ea.ironmonkey.devmenu.util;

import android.content.Context;
import android.os.Environment;

import com.ea.games.nfs13_na.BuildConfig;

import java.io.File;
import java.util.Arrays;
import java.util.HashSet;

public class PathList {

    private static Context context;

    public static void init(Context context){
        PathList.context = context;
    }

    public static String getInternalStorage(){
        return "/data/data/" + context.getPackageName() + File.separator;
    }

    public static String getExternalStorage(){
        return Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + context.getPackageName() + "/files";
    }

    public static String getReplacementsStorage(){
        return getInternalStorage() + File.separator + "replace";
    }

    private static String[] exclusionNamesArr = {

            BuildConfig.DEV_MENU_ID,
            "replace"

    };

    public static final HashSet<String> exclusionNames = new HashSet<>(Arrays.asList(exclusionNamesArr));



}
