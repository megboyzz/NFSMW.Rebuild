package com.ea.ironmonkey.devmenu;

import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.ea.games.nfs13_na.R;

import java.io.File;
import java.text.CharacterIterator;
import java.text.SimpleDateFormat;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

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

        //Порядок следования строк в эом массиве влияет на обработку нажатий на текствью с ними
        final String[] optionsTitles = {
                context.getString(R.string.replace_file_title),
                context.getString(R.string.recover_file_title),
                context.getString(R.string.remove_file_title),
                context.getString(R.string.track_file_title),
                context.getString(R.string.file_props_title)
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1,  optionsTitles);
        optionsView.setAdapter(adapter);

        optionsView.setOnItemClickListener((parent, view, position, id) -> {
            TextView textView = (TextView) view;
            String chosenElem = textView.getText().toString();
            switch (position){
                case 0: {
                    //TO DO
                } break;
                case 1: {
                    //TO DO
                } break;
                case 2: {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                    dialog.setTitle(optionsTitles[2]);
                    String message = String.format(context.getString(R.string.sure_remove_title), data.getName());
                    dialog.setMessage(message);
                    dialog.setPositiveButton(R.string.ok_title, (dialog1, which) -> {
                        deleteRecursive(data);
                        rebuildList(path);
                        //fileList.removeViewInLayout(fileList.getChildAt(selectedFileInd));
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
                default:{
                    Log.i("DataNinja", "No found action to do(");
                }
            }
        });

        setView(optionsView);
        setTitle(data.getName()
                + " - " +
                ((data.isDirectory()) ?
                        context.getString(R.string.folder_title) :
                        context.getString(R.string.file_title)));

        show();

    }



}
