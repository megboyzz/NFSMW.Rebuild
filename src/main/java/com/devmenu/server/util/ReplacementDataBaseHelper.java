package com.devmenu.server.util;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteCursorDriver;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQuery;

public class ReplacementDataBaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    public static final String MAIN_TABLE_NAME = "Replacements";
    public static final String NAME_OF_BACKUPED_ELEMENT = "Original_element";
    public static final String PATH_TO_REPLACED_ELEMENT = "Path";
    private SQLiteDatabase database;

    public SQLiteDatabase getDatabase() {
        return this.database;
    }

    public ReplacementDataBaseHelper(Context context) {
        super(context, "Replacements.db", null, 1);
        SQLiteDatabase openOrCreateDatabase = context.openOrCreateDatabase("Replacements.db", 0, null);
        this.database = openOrCreateDatabase;
        openOrCreateDatabase.execSQL("CREATE TABLE IF NOT EXISTS Replacements (_id INTEGER PRIMARY KEY AUTOINCREMENT, Path TEXT,Original_element TEXT);");
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }
}
