package com.ea.ironmonkey.devmenu;

import static com.ea.ironmonkey.devmenu.util.ReplacementDataBaseHelper.MAIN_TABLE_NAME;
import static com.ea.ironmonkey.devmenu.util.ReplacementDataBaseHelper.NAME_OF_BACKUPED_ELEMENT;
import static com.ea.ironmonkey.devmenu.util.UtilitiesAndData.OPEN_FILE_ON_REPLACE_REQUEST;
import static com.ea.ironmonkey.devmenu.util.UtilitiesAndData.copy;
import static com.ea.ironmonkey.devmenu.util.UtilitiesAndData.getFileSize;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.ea.games.nfs13_na.R;
import com.ea.ironmonkey.devmenu.util.ReplacementDataBaseHelper;
import com.ea.ironmonkey.devmenu.util.ResultListener;
import com.ea.ironmonkey.devmenu.util.UtilitiesAndData;

import java.io.File;
import java.io.IOException;
import java.text.CharacterIterator;
import java.text.SimpleDateFormat;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

/**
 * Контекстное меню управления данными
 */
public class LongPressContextMenu extends AlertDialog.Builder implements FileAction {

    private File chosenFile;
    private ListView fileList;
    private MainActivity activity;
    private static final String LOG_TAG = "LongPressContextMenu";

    private AlertDialog show = show();
    private ReplacementDataBaseHelper dataBaseHelper = new ReplacementDataBaseHelper(activity);
    private SQLiteDatabase writableDatabase = dataBaseHelper.getDatabase();
    private ContentValues values = new ContentValues();

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

        fileList.setAdapter(new FileAdapter(activity, asList(path)));

    }


    private File generateReplacementFile(){
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

    protected LongPressContextMenu(MainActivity activity, String pathToChosenElem, ListView fileList, int selectedFileInd) {
        super(activity);
        this.activity = activity;
        chosenFile = new File(pathToChosenElem);
        ListView optionsView = new ListView(activity);
        this.fileList = fileList;

        //Порядок следования строк в этом массиве влияет на обработку нажатий на текствью с ними
        String[] optionsTitles = {
                activity.getString(R.string.replace_file_title),     //0
                activity.getString(R.string.recover_file_title),          //1
                activity.getString(R.string.remove_file_title),      //2
                activity.getString(R.string.track_file_title),   //3
                activity.getString(R.string.file_props_title),        //4
                activity.getString(R.string.hide_file_title) //5
        };



        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                activity, 
                android.R.layout.simple_list_item_1,  
                optionsTitles);
        optionsView.setAdapter(adapter);
       
        setView(optionsView);
        setTitle(chosenFile.getName()
                + " - " +
                ((chosenFile.isDirectory()) ?
                        activity.getString(R.string.folder_title) :
                        activity.getString(R.string.file_title)));


        optionsView.setOnItemClickListener((parent, view, position, id) -> {
            TextView textView = (TextView) view;
            String chosenElem = textView.getText().toString();
            switch (position){
                case 0: actionReplaceFile();
                case 1: actionRecoverFile();
                case 2: actionDeleteFile();
                case 3: actionTrackTheFile();
                case 4: actionGetPropsOfFile();
                case 5: actionHideTheFile();
                default: Log.i(LOG_TAG, "No found action to do(");
            }
        });

    }


    @Override
    public void actionReplaceFile() {
        Intent chooseFile = new Intent(Intent.ACTION_GET_CONTENT);
        chooseFile.addCategory(Intent.CATEGORY_OPENABLE);
        chooseFile.setType("text/plain");
        activity.setResultListener(new ResultListener() {
            @Override
            public void onResult(Object object) {
                //Реализовать замену и воостановление данных
                Intent data;
                if(object instanceof Intent)
                    data = (Intent) object;
                else return;

                String selectedFileToReplace = "";
                selectedFileToReplace = data.getData().getPath();

                //Создание файла куда будет складывться замена
                File replacement = generateReplacementFile();

                //Копирование выбранного оригинального файла в хранилище замен
                //Иначе говоря, создание резервной копии
                String path = chosenFile.getAbsolutePath();
                copy(path, replacement.getPath());

                //Непосредственная замена
                copy(selectedFileToReplace, path);

                values.put(NAME_OF_BACKUPED_ELEMENT, replacement.getName());
                values.put(ReplacementDataBaseHelper.PATH_TO_REPLACED_ELEMENT, path);

                //Запись в бд
                writableDatabase.insert(MAIN_TABLE_NAME, null, values);

                writableDatabase.close();
                rebuildList(path);
                show.cancel();
                //TODO Язык!!!!
                Toast.makeText(activity, "Заменено!", Toast.LENGTH_LONG).show();
            }
        });
        activity.startActivityForResult(
                Intent.createChooser(chooseFile, "Choose a file"),
                OPEN_FILE_ON_REPLACE_REQUEST
        );
    }

    @Override
    public void actionRecoverFile() {
        String path = chosenFile.getAbsolutePath();
        UtilitiesAndData.recoverFile(path);
        rebuildList(path);
        show.cancel();
    }

    @Override
    public void actionDeleteFile() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(activity);
        dialog.setTitle(activity.getString(R.string.remove_file_title));
        String message = String.format(activity.getString(R.string.sure_remove_title), chosenFile.getName());
        dialog.setMessage(message);
        String path = chosenFile.getAbsolutePath();
        dialog.setPositiveButton(R.string.ok_title, (dialog1, which) -> {
            UtilitiesAndData.deleteRecursive(chosenFile);
            rebuildList(path);
        });
        dialog.setNegativeButton(R.string.cancel_title, null);
        dialog.show();
    }

    @Override
    public void actionTrackTheFile() {}

    @Override
    public void actionGetPropsOfFile() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(activity);
        dialog.setTitle(chosenFile.getName()
                + " - " +
                ((chosenFile.isDirectory()) ?
                        activity.getString(R.string.folder_title) :
                        activity.getString(R.string.file_title)));

        long lastModified = chosenFile.lastModified();
        Date date = new Date(lastModified);


        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss:SS");
        String formattedDate = sdf.format(date);

        long size = getFileSize(chosenFile);


        dialog.setMessage(
                activity.getString(R.string.file_lastmod_title) + "\n" +
                        formattedDate + "\n\n" +
                        activity.getString(R.string.file_size_title) + "\n" +
                        humanReadableByteCountSI(size) + " (" + size + " B)"
        );
        dialog.show();
    }

    @Override
    public void actionHideTheFile() {

    }
}
