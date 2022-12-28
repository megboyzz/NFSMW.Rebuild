package com.devmenu.server.impl;

import android.content.Context;
import com.devmenu.server.util.SaveManager;
import com.devmenu.server.util.UtilitiesAndData;
import org.apache.commons.io.FileUtils;
import org.jetbrains.annotations.NotNull;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import entities.SVMW;
import kotlinx.datetime.Instant;
import ru.megboyzz.api.SvmwAPI;

public class SvmwImpl implements SvmwAPI {

    private SaveManager manager;

    public SvmwImpl(Context context) {
        this.manager = new SaveManager(context);
    }

    @Override
    public void clearSVMWcache() {
        UtilitiesAndData.deleteRecursive(new File(UtilitiesAndData.getSVMWCacheStorage()));
    }

    @NotNull
    @Override
    public File createSVMWfromCurrentSave(@NotNull SVMW svmw) {
        String description = svmw.getDescription();
        File fileToSave = UtilitiesAndData.generateSvmwFile(svmw.getName());
        File save = UtilitiesAndData.getSaveFile();
        manager.createBundleFile(description, fileToSave, save);
        String date = SaveManager.dateFormat.format(manager.getDateOfCreateOf(fileToSave));
        UtilitiesAndData.putObjectToSharedPrefs(UtilitiesAndData.last_svmw_name_key, svmw.getName());
        UtilitiesAndData.putObjectToSharedPrefs(UtilitiesAndData.last_svmw_desc_key, description);
        UtilitiesAndData.putObjectToSharedPrefs(UtilitiesAndData.last_svmw_date_key, date);
        return fileToSave;
    }

    @NotNull
    @Override
    public SVMW getInfoAboutLoadedSVMW() {
        String name = UtilitiesAndData.getObjectFromSharedPrefs(UtilitiesAndData.last_svmw_name_key);
        String desc = UtilitiesAndData.getObjectFromSharedPrefs(UtilitiesAndData.last_svmw_desc_key);
        String date_t = UtilitiesAndData.getObjectFromSharedPrefs(UtilitiesAndData.last_svmw_date_key);
        if(name == null || desc == null || date_t == null) throw new RuntimeException("Not Found Info");
        Instant date = Instant.Companion.parse(date_t);
        return new SVMW(name, desc, date);
    }

    @NotNull
    @Override
    public SVMW getInfoAboutSvmw(@NotNull InputStream inputStream) {
        File file = UtilitiesAndData.generateSvmwFile();
        try {
            FileUtils.copyInputStreamToFile(inputStream, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(manager.isSvmwFile(file)) {
            String name = "loaded";
            String desc = manager.getDescriptionOf(file);
            Date dateOfCreateOf = manager.getDateOfCreateOf(file);
            Instant instant = Instant.Companion.fromEpochMilliseconds(dateOfCreateOf.getTime());
            return new SVMW(name, desc, instant);
        }else throw new RuntimeException("Its not a svmw");
    }

    @NotNull
    @Override
    public File getLoadedSVMW() {
        String name = UtilitiesAndData.getObjectFromSharedPrefs(UtilitiesAndData.last_svmw_name_key);
        String desc = UtilitiesAndData.getObjectFromSharedPrefs(UtilitiesAndData.last_svmw_desc_key);
        String date_t = UtilitiesAndData.getObjectFromSharedPrefs(UtilitiesAndData.last_svmw_date_key);
        if(name == null || desc == null || date_t == null) throw new RuntimeException("Svmw was not loaded");
        return UtilitiesAndData.getSaveFile();
    }

    @Override
    public void setSVMWasSaveFile(@NotNull InputStream inputStream) {
        File file = UtilitiesAndData.generateSvmwFile();
        try {
            FileUtils.copyInputStreamToFile(inputStream, file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(manager.isSvmwFile(file)) manager.loadSaveFile(file);
    }
}
