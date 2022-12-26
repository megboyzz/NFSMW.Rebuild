package com.devmenu.server;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.preference.PreferenceManager;
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
import java.util.Map;
import java.util.Random;
import java.util.Set;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.io.FileUtils;


public class UtilitiesAndData {
    private static final String LOG_TAG = "UtilitiesAndData";
    private static Context context = null;
    private static ReplacementDataBaseHelper dataBaseHelper = null;
    private static SharedPreferences.Editor editor = null;
    private static SharedPreferences preferences = null;
    public static final String save_tracking_enabled_key = "save_tracking_enabled";
    public static final String save_tracking_frequency_key = "save_tracking_frequency";
    public static final String save_tracking_path_key = "save_tracking_path";
    private static FileOutputStream stream;
    private static SQLiteDatabase writableDatabase;
    private static final String[] exclusionNamesArr = {BuildConfig.DEV_MENU_ID, "replace", "lib", "databases", "cache"};
    private static final Set<String> exclusionNames = new HashSet(Arrays.asList(exclusionNamesArr));

    public static void init(Context context2) {
        context = context2;
        ReplacementDataBaseHelper replacementDataBaseHelper = new ReplacementDataBaseHelper(context2);
        dataBaseHelper = replacementDataBaseHelper;
        writableDatabase = replacementDataBaseHelper.getDatabase();
        editor = PreferenceManager.getDefaultSharedPreferences(context2).edit();
        preferences = PreferenceManager.getDefaultSharedPreferences(context2);
    }

    public static void putObjectToSharedPrefs(String key, Object value) {
        if (value instanceof String) {
            editor.putString(key, (String) value);
        } else if (value instanceof Integer) {
            editor.putInt(key, ((Integer) value).intValue());
        } else if (value instanceof Boolean) {
            editor.putBoolean(key, ((Boolean) value).booleanValue());
        } else if (value instanceof Set) {
            editor.putStringSet(key, (Set) value);
        } else if (value instanceof Long) {
            editor.putLong(key, ((Long) value).longValue());
        } else if (value instanceof Float) {
            editor.putFloat(key, ((Float) value).floatValue());
        }
        editor.commit();
    }

    public static void putObjectToSharedPrefs(int resStrId, Object value) {
        putObjectToSharedPrefs(context.getString(resStrId), value);
    }

    public static <T> T getObjectFromSharedPrefs(String key) {
        Map<String, ?> all = preferences.getAll();
        if (all.isEmpty()) {
            return null;
        }
        return (T) all.get(key);
    }

    public static <T> T getObjectFromSharedPrefs(int resStrId) {
        return (T) getObjectFromSharedPrefs(context.getString(resStrId));
    }

    public static void deleteRecursive(File fileOrDirectory) {
        File[] listFiles;
        if (fileOrDirectory.isDirectory()) {
            for (File child : fileOrDirectory.listFiles()) {
                deleteRecursive(child);
            }
        }
        fileOrDirectory.delete();
    }

    public static boolean isLoggerEnabled() {
        return stream != null;
    }

    public static String getInternalStorage() {
        return "/data/data/" + context.getPackageName();
    }

    public static String getExternalStorage() {
        return Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + context.getPackageName() + "/files";
    }

    public static File getDevMenuSwitcher() {
        return new File(getExternalStorage() + File.separator + BuildConfig.DEV_MENU_ID);
    }

    public static File getSaveFile() {
        File save = new File(getInternalStorage() + File.separator + "files" + File.separator + "var" + File.separator + "nfstr_save.sb");
        if (!save.exists()) {
            try {
                save.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return save;
    }

    public static String getReplacementsStorage() {
        return getInternalStorage() + File.separator + "replace";
    }

    public static boolean isFirstRun() {
        File temp = new File(getInternalStorage() + File.separator + "load");
        try {
            if (!temp.exists()) {
                temp.createNewFile();
                return true;
            }
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void copy(File from, File to) {
        copy(from.getAbsolutePath(), to.getAbsolutePath());
    }

    public static void copyRecursiveFolder(File from, File to) {
        File[] listFiles;
        if (from.isFile() | to.isFile()) {
            throw new RuntimeException("Cant copy Files as Folders(( Use just copy()");
        }
        for (File child : from.listFiles()) {
            if (child.isDirectory()) {
                copyRecursiveFolder(child, to);
            } else {
                File toFile = new File(to.getAbsolutePath() + File.separator + to.getName());
                copy(child, toFile);
            }
        }
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
        try {
            InputStream is = new FileInputStream(source);
            OutputStream os = new FileOutputStream(dest);
            Math.max(getElementSize(source), getElementSize(dest));
            byte[] buffer = new byte[1024];
            while (true) {
                int length = is.read(buffer);
                if (length > 0) {
                    os.write(buffer, 0, length);
                } else {
                    is.close();
                    os.close();
                    return;
                }
            }
        } catch (FileNotFoundException e2) {
            Log.e("lol", e2.toString());
            e2.printStackTrace();
        } catch (IOException e3) {
            Log.e("lol1", e3.toString());
            e3.printStackTrace();
        }
    }

    public static long getElementSize(File file) {
        if (file == null || !file.exists()) {
            return 0L;
        }
        return file.isFile() ? file.length() : FileUtils.sizeOfDirectory(file);
    }

    public static boolean isExclusionName(String name) {
        return exclusionNames.contains(name);
    }

    public static File generateReplacementFile() {
        Random random = new Random();
        int index = random.nextInt();
        String nameReplacedOriginal = "replacement_" + (index < 0 ? index * (-1) : index) + "";
        String replacementsStorage = getReplacementsStorage();
        File storage = new File(replacementsStorage);
        if (!storage.exists()) {
            storage.mkdir();
        }
        File original = new File(getReplacementsStorage() + File.separator + nameReplacedOriginal);
        try {
            original.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return original;
    }

    public static void recoverFile(String path) {
        SQLiteDatabase sQLiteDatabase = writableDatabase;
        Cursor query = sQLiteDatabase.rawQuery("SELECT Path , Original_element FROM Replacements WHERE Path = \"" + path + "\"", null);
        if (query.getCount() == 1) {
            query.moveToFirst();
            String pathToReplace = query.getString(query.getColumnIndex(ReplacementDataBaseHelper.PATH_TO_REPLACED_ELEMENT));
            String nameFile = query.getString(query.getColumnIndex(ReplacementDataBaseHelper.NAME_OF_BACKUPED_ELEMENT));
            File toReplace = new File(pathToReplace);
            File backup = new File(getReplacementsStorage() + File.separator + nameFile);
            copy(backup, toReplace);
            writableDatabase.delete(ReplacementDataBaseHelper.MAIN_TABLE_NAME, "Path = ?", new String[]{path});
            backup.delete();
        }
        query.close();
    }

    public static void replaceFile(String what, String forWhat) {
        ContentValues values = new ContentValues();
        File replacement = generateReplacementFile();
        copy(what, replacement.getPath());
        copy(forWhat, what);
        values.put(ReplacementDataBaseHelper.NAME_OF_BACKUPED_ELEMENT, replacement.getName());
        values.put(ReplacementDataBaseHelper.PATH_TO_REPLACED_ELEMENT, what);
        writableDatabase.insert(ReplacementDataBaseHelper.MAIN_TABLE_NAME, null, values);
    }

    public static void recoverFile(int ID) {
        SQLiteDatabase sQLiteDatabase = writableDatabase;
        Cursor query = sQLiteDatabase.rawQuery("SELECT Path , Original_element FROM Replacements WHERE _id = \"" + ID + "\"", null);
        if (query.getCount() == 1) {
            query.moveToFirst();
            String pathToReplace = query.getString(query.getColumnIndex(ReplacementDataBaseHelper.PATH_TO_REPLACED_ELEMENT));
            String nameFile = query.getString(query.getColumnIndex(ReplacementDataBaseHelper.NAME_OF_BACKUPED_ELEMENT));
            File toReplace = new File(pathToReplace);
            File backup = new File(getReplacementsStorage() + File.separator + nameFile);
            copy(backup, toReplace);
            SQLiteDatabase sQLiteDatabase2 = writableDatabase;
            sQLiteDatabase2.delete(ReplacementDataBaseHelper.MAIN_TABLE_NAME, "_id = ?", new String[]{ID + ""});
            backup.delete();
        }
        query.close();
    }

    public static Cursor getAllReplacementsViaCursor() {
        Cursor cursor = writableDatabase.rawQuery("SELECT * FROM Replacements", null);
        return cursor;
    }

    public static int getReplacementID(String path) {
        SQLiteDatabase sQLiteDatabase = writableDatabase;
        Cursor query = sQLiteDatabase.rawQuery("SELECT _id FROM Replacements WHERE Path = \"" + path + "\"", null);
        if (query.getCount() == 0) {
            return -1;
        }
        query.moveToFirst();
        int id = query.getInt(0);
        query.close();
        return id;
    }

    public static boolean isFileReplaced(String path) {
        return -1 != getReplacementID(path);
    }

    public static byte[] generateMD5(File file) {
        try {
            return DigestUtils.md5(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
            return new byte[1];
        }
    }

    public static void getInfoAboutFile(File file) {
        Log.i(LOG_TAG, "Info about File -> " + file.getAbsolutePath());
        if (file.exists()) {
            if (file.isFile()) {
                Log.i(LOG_TAG, "isCanRead = " + file.canRead());
                Log.i(LOG_TAG, "isCanWrite = " + file.canWrite());
                Log.i(LOG_TAG, "isCanExecute = " + file.canExecute());
                return;
            }
            Log.i(LOG_TAG, "its dir!");
            return;
        }
        Log.wtf(LOG_TAG, "it does not exists!");
    }

    public static byte[] fileAsByteArray(File file) {
        byte[] b = new byte[(int) file.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(b);
            return b;
        } catch (Exception e) {
            return null;
        }
    }

    public static void saveBytesToFile(byte[] bytes, File saveTo) {
        try {
            saveTo.createNewFile();
            FileOutputStream outputStream = new FileOutputStream(saveTo);
            outputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static int findHeaderInByteFile(byte[] byteFile, byte[] header) {
        int[] pf = prefix(header);
        int index = 0;
        for (int i = 0; i < byteFile.length; i++) {
            while (index > 0 && header[index] != byteFile[i]) {
                index = pf[index - 1];
            }
            if (header[index] == byteFile[i]) {
                index++;
            }
            if (index == header.length) {
                return (i - index) + 1;
            }
        }
        return -1;
    }

    private static int[] prefix(byte[] s) {
        int[] result = new int[s.length];
        result[0] = 0;
        int index = 0;
        for (int i = 1; i < s.length; i++) {
            while (index >= 0 && s[index] != s[i]) {
                index--;
            }
            index++;
            result[i] = index;
        }
        return result;
    }
}