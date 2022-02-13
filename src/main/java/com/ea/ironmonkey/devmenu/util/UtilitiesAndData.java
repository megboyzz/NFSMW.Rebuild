package com.ea.ironmonkey.devmenu.util;

import android.content.Context;
import android.os.Environment;
import android.util.Log;

import com.ea.games.nfs13_na.BuildConfig;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class UtilitiesAndData {

    private static Context context;
    public static final int OPEN_FILE_ON_REPLACE_REQUEST = 100;
    public static final int READ_FILE_REQUEST_CODE = 101;

    public static void init(Context context){
        UtilitiesAndData.context = context;
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
            "replace",
            "lib",
            "databases"

    };

    public static void copy(File from, File to){
        copy(from.getAbsolutePath(), to.getAbsolutePath());
    }

    public static void copy(String from, String to) {
        File source = new File(from);

        File dest = new File(to);


        if (!dest.exists()) {
            try {
                dest.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            Math.max(getFileSize(source), getFileSize(dest));
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
            is.close();
            os.close();
        } catch (FileNotFoundException e) {
            Log.e("lol", e.toString());
            e.printStackTrace();
        } catch (IOException e) {
            Log.e("lol1", e.toString());
            e.printStackTrace();
        }
    }

    public static long getFileSize(final File file) {
        if (file == null || !file.exists())
            return 0;
        if (!file.isDirectory())
            return file.length();
        final List<File> dirs = new LinkedList<>();
        dirs.add(file);
        long result = 0;
        while (!dirs.isEmpty()) {
            final File dir = dirs.remove(0);
            if (!dir.exists())
                continue;
            final File[] listFiles = dir.listFiles();
            if (listFiles == null || listFiles.length == 0)
                continue;
            for (final File child : listFiles) {
                result += child.length();
                if (child.isDirectory())
                    dirs.add(child);
            }
        }
        return result;
    }

    private static final HashSet<String> exclusionNames = new HashSet<>(Arrays.asList(exclusionNamesArr));

    public static boolean isExclusionName(String name){
        return exclusionNames.contains(name);
    }

}
