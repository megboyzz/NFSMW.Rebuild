package com.devmenu.server.impl;

import android.database.Cursor;
import com.devmenu.server.ReplacementDataBaseHelper;
import com.devmenu.server.UtilitiesAndData;
import entities.Replacement;
import java.util.ArrayList;
import java.util.List;
import ru.megboyzz.api.ReplacementAPI;


public class ReplacementImpl implements ReplacementAPI {
    @Override
    public void addReplacement(Replacement replacement) {
        UtilitiesAndData.replaceFile(replacement.getWhat(), replacement.getTo());
    }

    @Override
    public List<Replacement> getAllReplacements() {
        Cursor cursor = UtilitiesAndData.getAllReplacementsViaCursor();
        List<Replacement> replacements = new ArrayList<>();
        if (cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
                int id = cursor.getInt(cursor.getColumnIndex("_id"));
                String what = cursor.getString(cursor.getColumnIndex(ReplacementDataBaseHelper.NAME_OF_BACKUPED_ELEMENT));
                String to = cursor.getString(cursor.getColumnIndex(ReplacementDataBaseHelper.PATH_TO_REPLACED_ELEMENT));
                replacements.add(new Replacement(id, what, to));
            }
            return replacements;
        }
        return new ArrayList();
    }

    @Override
    public void recoverAllReplacements() {
        List<Replacement> allReplacements = getAllReplacements();
        for (Replacement replacement : allReplacements) {
            recoverReplacementByID(replacement.getID());
        }
    }

    @Override
    public void recoverReplacementByID(int id) {
        UtilitiesAndData.recoverFile(id);
    }
}
