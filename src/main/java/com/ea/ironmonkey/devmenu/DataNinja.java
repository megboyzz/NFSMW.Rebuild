package com.ea.ironmonkey.devmenu;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ea.games.nfs13_na.R;
import com.ea.ironmonkey.devmenu.util.PathList;
import com.ea.ironmonkey.devmenu.util.ReplacementDataBaseHelper;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.CharacterIterator;
import java.text.SimpleDateFormat;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class DataNinja extends AlertDialog.Builder {

    private File data;
    private ListView fileList;
    private Context context;

    private List<File> asList(String path){
        path = path.substring(0, path.lastIndexOf("/"));
        List<File> list = new ArrayList<>();
        File files = new File(path);
        try {
            list.addAll(Arrays.asList(files.listFiles()));
        }catch (NullPointerException e){
            e.printStackTrace();
            return new ArrayList<>();
        }
        return list;
    }

    private void rebuildList(String path){

        fileList.setAdapter(new FileAdapter(context, asList(path)));

    }

    void deleteRecursive(File fileOrDirectory) {
        if (fileOrDirectory.isDirectory())
            for (File child : fileOrDirectory.listFiles())
                deleteRecursive(child);

        fileOrDirectory.delete();
    }

    long getFileSize(final File file) {
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


    void copy(String from, String to) {
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

    private File generateReplacementFile(){
        Random random = new Random();
        int index = random.nextInt();
        index = (index < 0) ? index * -1 : index;
        String nameReplacedOriginal = "replacement_" + index + "";
        File original = new File(PathList.getReplacementsStorage() + File.separator + nameReplacedOriginal);
        try {
            original.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return original;
    }

    public static String humanReadableByteCountSI(long bytes) {
        if (-1000 < bytes && bytes < 1000) {
            return bytes + " B";
        }
        CharacterIterator ci = new StringCharacterIterator("kMGTPE");
        while (bytes <= -999_950 || bytes >= 999_950) {
            bytes /= 1000;
            ci.next();
        }
        return String.format("%.1f %cB", bytes / 1000.0, ci.current());
    }

    protected DataNinja(final Context context, String path, ListView fileList, int selectedFileInd) {
        super(context);
        this.context = context;
        data = new File(path);
        ListView optionsView = new ListView(context);
        this.fileList = fileList;

        //Порядок следования строк в этом массиве влияет на обработку нажатий на текствью с ними
        String[] optionsTitles = {
                context.getString(R.string.replace_file_title),     //0
                context.getString(R.string.recover_file_title),          //1
                context.getString(R.string.remove_file_title),      //2
                context.getString(R.string.track_file_title),   //3
                context.getString(R.string.file_props_title),        //4
                context.getString(R.string.hide_file_title) //5
        };



        ArrayAdapter<String> adapter = new ArrayAdapter<>(context, android.R.layout.simple_list_item_1,  optionsTitles);
        optionsView.setAdapter(adapter);
        final DataNinja f_this = this;
        setView(optionsView);
        setTitle(data.getName()
                + " - " +
                ((data.isDirectory()) ?
                        context.getString(R.string.folder_title) :
                        context.getString(R.string.file_title)));

        final AlertDialog show = show();
        ReplacementDataBaseHelper dataBaseHelper = new ReplacementDataBaseHelper(context);
        SQLiteDatabase writableDatabase = dataBaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();

        optionsView.setOnItemClickListener((parent, view, position, id) -> {
            TextView textView = (TextView) view;
            String chosenElem = textView.getText().toString();
            switch (position){
                case 0: {
                    OpenFileDialog replaceDialog = new OpenFileDialog(context);
                    replaceDialog.setOpenDialogListener(selectedFileToReplace -> {
                        //Реализовать замену и воостановление данных

                        //Создание файла куда будет складывться замена
                        File replacement = generateReplacementFile();

                        //Копирование выбранного оригинального файла в хранилище замен
                        //Иначе говоря, создание резервной копии
                        copy(path, replacement.getPath());

                        //Непосредственная замена
                        copy(selectedFileToReplace, path);

                        values.put(ReplacementDataBaseHelper.NAME_OF_BACKUPED_ELEMENT, replacement.getName());
                        values.put(ReplacementDataBaseHelper.PATH_TO_REPLACED_ELEMENT, path);

                        writableDatabase.insert(ReplacementDataBaseHelper.MAIN_TABLE_NAME, null, values);

                        writableDatabase.close();
                        //Log.i("lol", selectedFileToReplace + " " + path);
                        //Log.i("lol", PathList.getReplacementsStorage());
                        Toast.makeText(context, "Заменено!", Toast.LENGTH_LONG).show();
                        show.cancel();
                    });
                    replaceDialog.show();
                } break;
                case 1: {

                } break;
                case 2: {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                    dialog.setTitle(optionsTitles[2]);
                    String message = String.format(context.getString(R.string.sure_remove_title), data.getName());
                    dialog.setMessage(message);
                    dialog.setPositiveButton(R.string.ok_title, (dialog1, which) -> {
                        deleteRecursive(data);
                        rebuildList(path);
                    });
                    dialog.setNegativeButton(R.string.cancel_title, null);
                    dialog.show();
                }break;
                case 3:{

                }break;
                case 4:{
                    AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                    dialog.setTitle(data.getName()
                            + " - " +
                            ((data.isDirectory()) ?
                                    context.getString(R.string.folder_title) :
                                    context.getString(R.string.file_title)));

                    long lastModified = data.lastModified();
                    Date date = new Date(lastModified);


                    SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss:SS");
                    String formattedDate = sdf.format(date);

                    long size = getFileSize(data);


                    dialog.setMessage(
                            context.getString(R.string.file_lastmod_title) + "\n" +
                            formattedDate + "\n\n" +
                            context.getString(R.string.file_size_title) + "\n" +
                            humanReadableByteCountSI(size) + " (" + size + " B)"
                    );
                    dialog.show();
                }break;
                case 5:{
                    /*
                    File file = new File(path);
                    File renameFile;
                    if(file.getPath().endsWith("_")){
                        renameFile = new File(file.getPath().substring(0, file.getPath().length() - 1));
                    }else {
                        renameFile = new File(file.getPath() + "_");
                    }
                    file.renameTo(renameFile);
                    rebuildList(path);
                    show.cancel();

                     */
                }break;
                default:{
                    Log.i("DataNinja", "No found action to do(");
                }
            }
        });

    }



}
