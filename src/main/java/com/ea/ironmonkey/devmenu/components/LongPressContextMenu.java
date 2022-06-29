package com.ea.ironmonkey.devmenu.components;

import static com.ea.ironmonkey.devmenu.util.ReplacementDataBaseHelper.MAIN_TABLE_NAME;
import static com.ea.ironmonkey.devmenu.util.ReplacementDataBaseHelper.NAME_OF_BACKUPED_ELEMENT;
import static com.ea.ironmonkey.devmenu.util.UtilitiesAndData.FILE_PICKER_CODE;
import static com.ea.ironmonkey.devmenu.util.UtilitiesAndData.FILE_REPLACE_CODE;
import static com.ea.ironmonkey.devmenu.util.UtilitiesAndData.OPEN_FILE_ON_REPLACE_REQUEST;
import static com.ea.ironmonkey.devmenu.util.UtilitiesAndData.copy;
import static com.ea.ironmonkey.devmenu.util.UtilitiesAndData.getFileSize;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.ea.games.nfs13_na.R;
import com.ea.ironmonkey.devmenu.MainActivity;
import com.ea.ironmonkey.devmenu.util.ReplacementDataBaseHelper;
import com.ea.ironmonkey.devmenu.util.ResultListener;
import com.ea.ironmonkey.devmenu.util.UtilitiesAndData;

import java.io.File;
import java.io.IOException;
import java.text.CharacterIterator;
import java.text.SimpleDateFormat;
import java.text.StringCharacterIterator;
import java.util.Date;
import java.util.Random;

import lib.folderpicker.FolderPicker;

/**
 * Контекстное меню управления данными
 */
public class LongPressContextMenu extends AlertDialog.Builder implements FileAction {

    private File chosenFile;
    private MainActivity activity;
    private static final String LOG_TAG = "LongPressContextMenu";

    private AlertDialog show;
    private ReplacementDataBaseHelper dataBaseHelper;
    private SQLiteDatabase writableDatabase;
    private ContentValues values;

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

    public LongPressContextMenu(MainActivity activity, String pathToChosenElem) {
        super(activity);
        this.activity = activity;
        chosenFile = new File(pathToChosenElem);
        DynamicOptionsListView optionsView = new DynamicOptionsListView(activity);

        this.dataBaseHelper = new ReplacementDataBaseHelper(activity);
        this.writableDatabase = dataBaseHelper.getDatabase();
        this.values = new ContentValues();

        optionsView.addOption(activity.getString(R.string.replace_file_title), this::actionReplaceFile);
        optionsView.addOption(activity.getString(R.string.recover_file_title), this::actionRecoverFile);
        optionsView.addOption(activity.getString(R.string.remove_file_title), this::actionRemoveFile);
        optionsView.addOption(activity.getString(R.string.track_file_title), this::actionTrackTheFile);
        optionsView.addOption(activity.getString(R.string.file_props_title), this::actionGetPropsOfFile);
        optionsView.addOption(activity.getString(R.string.hide_file_title), this::actionHideTheFile);

        setView(optionsView);
        setTitle(chosenFile.getName()
                + " - " +
                ((chosenFile.isDirectory()) ?
                        activity.getString(R.string.folder_title) :
                        activity.getString(R.string.file_title)));

        this.show = show();

    }


    @Override
    public void actionReplaceFile() {
        Intent intent = new Intent(activity, FolderPicker.class);
        intent.putExtra("title", "Выбрать файл на замену");
        intent.putExtra("location", UtilitiesAndData.getExternalStorage());
        intent.putExtra("pickFiles", true);
        intent.putExtra("replace", chosenFile.getAbsolutePath());

        activity.startActivityForResult(
                intent,
                FILE_REPLACE_CODE
        );
    }

    @Override
    public void actionRecoverFile() {
        String path = chosenFile.getAbsolutePath();
        UtilitiesAndData.recoverFile(path);
        activity.updateListView();
        show.cancel();
        //дщд
    }

    @Override
    public void actionRemoveFile() {
        AlertDialog.Builder dialog = new AlertDialog.Builder(activity);
        dialog.setTitle(activity.getString(R.string.remove_file_title));
        String message = String.format(activity.getString(R.string.sure_remove_title), chosenFile.getName());
        dialog.setMessage(message);

        dialog.setPositiveButton(R.string.ok_title, (dialog1, which) -> {
            UtilitiesAndData.deleteRecursive(chosenFile);
            activity.updateListView();
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
