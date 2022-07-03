package com.ea.ironmonkey.devmenu.util;

import static com.ea.ironmonkey.devmenu.util.ReplacementDataBaseHelper.MAIN_TABLE_NAME;
import static com.ea.ironmonkey.devmenu.util.ReplacementDataBaseHelper.NAME_OF_BACKUPED_ELEMENT;
import static com.ea.ironmonkey.devmenu.util.ReplacementDataBaseHelper.PATH_TO_REPLACED_ELEMENT;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import com.ea.games.nfs13_na.BuildConfig;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

/**
 * Класс-утилита для работы с данными и прочими вещами
 */
public class UtilitiesAndData {

    private static Context context;
    private static FileOutputStream stream;

    private static ReplacementDataBaseHelper dataBaseHelper;
    private static SQLiteDatabase writableDatabase;

    private static final String LOG_TAG = "UtilitiesAndData";

    private static SharedPreferences.Editor editor;
    private static SharedPreferences preferences;

    public static void init(Context context){
        UtilitiesAndData.context = context;
        dataBaseHelper = new ReplacementDataBaseHelper(context);
        writableDatabase = dataBaseHelper.getDatabase();

        editor = PreferenceManager.getDefaultSharedPreferences(context).edit();
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void putObjectToSharedPrefs(String key, Object value){
        if(value instanceof String) {
            editor.putString(key, (String)value);
        }else if(value instanceof Integer){
            editor.putInt(key, (Integer)value);
        }else if(value instanceof Boolean){
            editor.putBoolean(key, (Boolean)value);
        }else if(value instanceof Set){
            editor.putStringSet(key, (Set)value);
        }else if(value instanceof Long){
            editor.putLong(key, (Long)value);
        }else if(value instanceof Float){
            editor.putFloat(key, (Float)value);
        }
        editor.commit();
    }

    public static void putObjectToSharedPrefs(int resStrId, Object value){
        putObjectToSharedPrefs(context.getString(resStrId), value);
    }

    public static <T> T getObjectFromSharedPrefs(String key){
        Map<String, ?> all = preferences.getAll();
        return (T) all.get(key);
    }

    public static <T> T getObjectFromSharedPrefs(int resStrId){
        return getObjectFromSharedPrefs(context.getString(resStrId));
    }

    public static void setLogger(File file){
        if(file.exists()){
            try {
                stream = new FileOutputStream(file);
            } catch (FileNotFoundException e) {
                Log.wtf(LOG_TAG, "cant create out stream(((");
                e.printStackTrace();
            }
        }
    }

    public static void deleteRecursive(File fileOrDirectory) {
        if (fileOrDirectory.isDirectory())
            for (File child : fileOrDirectory.listFiles())
                deleteRecursive(child);

        fileOrDirectory.delete();
    }

    public static boolean isLoggerEnabled(){
        return stream != null;
    }

    public static void printLog(String msg){
        try{
            if(isLoggerEnabled())
            stream.write(msg.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            Log.wtf(LOG_TAG, "cant write to stream(((");
            e.printStackTrace();
        }
    }

    public static String getInternalStorage(){
        return "/data/data/" + context.getPackageName();
    }

    public static String getExternalStorage(){
        return Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + context.getPackageName() + "/files";
    }

    public static File getDevMenuSwitcher(){
        return new File(UtilitiesAndData.getExternalStorage() + File.separator + BuildConfig.DEV_MENU_ID);
    }

    public static File getSaveFile(){
        File save = new File(getInternalStorage() + File.separator + "files" + File.separator + "var" + File.separator + "nfstr_save.sb");
        if(!save.exists()) {
            try {
                save.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return save;
    }

    public static String getReplacementsStorage(){
        return getInternalStorage() + File.separator + "replace";
    }

    public static boolean isFirstRun(){
        File temp = new File(getInternalStorage() + File.separator + "load");
        try {
            if(!temp.exists()){
                temp.createNewFile();
                return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void copy(File from, File to){
        copy(from.getAbsolutePath(), to.getAbsolutePath());
    }

    public static void copyRecursiveFolder(File from, File to){
        if(from.isFile() | to.isFile()) throw new RuntimeException("Cant copy Files as Folders(( Use just copy()");
        //Проходимся рекурсивно по папке которую нужно скопировать
        for (File child : from.listFiles())
            if(child.isDirectory()) copyRecursiveFolder(child, to);
            else {
                File toFile = new File(to.getAbsolutePath() + File.separator + to.getName());
                copy(child, toFile);
            }
    }

    public static void copy(String from, String to) {
        File source = new File(from);

        File dest = new File(to);


        if (!dest.exists()) {
            try {
                //dest.mkdirs();
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

    private static final String[] exclusionNamesArr = {

            BuildConfig.DEV_MENU_ID,
            "replace",
            "lib",
            "databases",
            "cache"

    };

    private static final Set<String> exclusionNames = new HashSet<>(Arrays.asList(exclusionNamesArr));

    public static boolean isExclusionName(String name){
        return exclusionNames.contains(name);
    }

    public static File generateReplacementFile(){
        Random random = new Random();
        int index = random.nextInt();
        index = (index < 0) ? index * -1 : index;
        String nameReplacedOriginal = "replacement_" + index + "";
        File original = new File(UtilitiesAndData.getReplacementsStorage() + File.separator + nameReplacedOriginal);
        try {
            original.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return original;
    }

    /**
     * Группа методов связанных с бд
     */
    public static void recoverFile(String path){
        Cursor query = writableDatabase.rawQuery("SELECT " + PATH_TO_REPLACED_ELEMENT + " , " + NAME_OF_BACKUPED_ELEMENT + " FROM " + MAIN_TABLE_NAME + " WHERE " + PATH_TO_REPLACED_ELEMENT + " = \"" + path + "\"", null);
        if(query.getCount() == 1) {
            query.moveToFirst();
            //Путь к заменяемому файлу
            String pathToReplace = query.getString(query.getColumnIndex(PATH_TO_REPLACED_ELEMENT));
            //Имя бэкапа
            String nameFile = query.getString(query.getColumnIndex(NAME_OF_BACKUPED_ELEMENT));

            //Файл замены
            File toReplace = new File(pathToReplace);

            //Файл бэкапа
            File backup = new File(UtilitiesAndData.getReplacementsStorage() + File.separator + nameFile);

            copy(backup, toReplace);

            writableDatabase.delete(MAIN_TABLE_NAME, PATH_TO_REPLACED_ELEMENT + " = ?", new String[]{path});
            backup.delete();
        }
    }
    public static void replaceFile(String what, String forWhat){
        ContentValues values = new ContentValues();

        //Создание файла куда будет складывться замена
        File replacement = generateReplacementFile();

        //Копирование выбранного оригинального файла в хранилище замен
        //Иначе говоря, создание резервной копии
        copy(what, replacement.getPath());

        //Непосредственная замена
        copy(forWhat, what);

        values.put(NAME_OF_BACKUPED_ELEMENT, replacement.getName());
        values.put(ReplacementDataBaseHelper.PATH_TO_REPLACED_ELEMENT, what);

        //Запись в бд
        writableDatabase.insert(MAIN_TABLE_NAME, null, values);


    }
    public static boolean isFileReplaced(String path){
        Cursor query = writableDatabase.rawQuery("SELECT " + PATH_TO_REPLACED_ELEMENT + " , " + NAME_OF_BACKUPED_ELEMENT + " FROM " + MAIN_TABLE_NAME + " WHERE " + PATH_TO_REPLACED_ELEMENT + " = \"" + path + "\"", null);
        return query.getCount() == 1;
    }

    public static byte[] generateMD5(File file){
        try {
            return DigestUtils.md5(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[1];
    }

    public static void getInfoAboutFile(File file){
        Log.i(LOG_TAG, "Info about File -> " + file.getAbsolutePath());
        if(file.exists()){
            if(file.isFile()) {
                Log.i(LOG_TAG, "isCanRead = " + file.canRead());
                Log.i(LOG_TAG, "isCanWrite = " + file.canWrite());
                Log.i(LOG_TAG, "isCanExecute = " + file.canExecute());
            }else
                Log.i(LOG_TAG, "its dir!");
        }else
            Log.wtf(LOG_TAG, "it does not exists!");
    }

    /**
     * Группа методов связанных с SVMW
     */
    public static byte[] fileAsByteArray(File file){
        byte[] b = new byte[(int) file.length()];
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            fileInputStream.read(b);
        } catch (Exception e) {
            return null;
        }
        return b;
    }
    public static void saveBytesToFile(byte[] bytes, File saveTo){
        try{
            saveTo.createNewFile();
            FileOutputStream outputStream = new FileOutputStream(saveTo);
            outputStream.write(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static int findHeaderInByteFile(byte[] byteFile, byte[] header){
        int[] pf = prefix(header);
        int index = 0;
        for (int i = 0; i < byteFile.length; i++){
            while (index > 0 && header[index] != byteFile[i]) index = pf[index - 1];
            if (header[index] == byteFile[i]) index++;
            if (index == header.length) return i - index + 1;
        }
        return -1;
    }
    /**
     * Префикс функция для алгоритма КМП
     */
    private static int[] prefix(byte[] s) {
        int[] result = new int[s.length];
        result[0] = 0;
        int index = 0;
        for (int i = 1; i < s.length; i++) {
            while (index >= 0 && s[index] != s[i]) index--;
            index++;
            result[i] = index;
        }
        return result;
    }

}
