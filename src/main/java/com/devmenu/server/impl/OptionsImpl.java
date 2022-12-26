package com.devmenu.server.impl;

import android.util.Log;

import com.devmenu.server.UtilitiesAndData;
import entities.GameLanguage;
import entities.GameLanguageType;
import entities.SaveTrackingInfo;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import ru.megboyzz.api.OptionsAPI;


public class OptionsImpl implements OptionsAPI {
    @Override
    public GameLanguage getLanguage() {
        File locale = new File(UtilitiesAndData.getInternalStorage() + "/files/var/locale");
        if (!locale.exists()) {
            return GameLanguageType.System.getInvoke();
        }
        byte[] localeBytes = UtilitiesAndData.fileAsByteArray(locale);
        byte[] lang = {localeBytes[2], localeBytes[3]};
        String result = new String(lang);
        return GameLanguageType.Companion.invoke(result);
    }

    @Override
    public void setLanguage(GameLanguage gameLanguage) {
        File locale = new File(UtilitiesAndData.getInternalStorage() + "/files/var/locale");
        byte[] localeBytes = {2, 0, 0, 0};
        byte[] bytes = gameLanguage.toString().getBytes(StandardCharsets.UTF_8);
        localeBytes[2] = bytes[0];
        localeBytes[3] = bytes[1];
        try {
            if (!locale.exists()) {
                locale.createNewFile();
            }
            FileOutputStream fos = new FileOutputStream(locale, false);
            fos.write(localeBytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void print(byte[] b){
        for (byte b1 : b) {
            System.out.print(b1 + " ,");
        }
        System.out.println();
    }

    @Override
    public void setSaveFile(InputStream inputStream) {
        byte[] sbmagic = {83, 66, 73, 78};
        byte[] checkMagicArray;
        try {
            byte[] file = IOUtils.toByteArray(inputStream);
            checkMagicArray = Arrays.copyOfRange(file, 0, 4);
            if (!Arrays.equals(sbmagic, checkMagicArray)) return;
            File saveFile = UtilitiesAndData.getSaveFile();
            UtilitiesAndData.saveBytesToFile(file, saveFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override // ru.megboyzz.api.OptionsAPI
    public File getSaveFile() {
        return UtilitiesAndData.getSaveFile();
    }

    @Override // ru.megboyzz.api.OptionsAPI
    public void setSaveTrackingInfo(SaveTrackingInfo saveTrackingInfo) {
        String fullPathToTracking = saveTrackingInfo.getFullPathToTracking();
        File file = new File(saveTrackingInfo.getFullPathToTracking());
        if (!file.exists()) {
            file.mkdir();
        }
        UtilitiesAndData.putObjectToSharedPrefs(UtilitiesAndData.save_tracking_enabled_key, Boolean.valueOf(saveTrackingInfo.getEnabled()));
        UtilitiesAndData.putObjectToSharedPrefs(UtilitiesAndData.save_tracking_frequency_key, Integer.valueOf(saveTrackingInfo.getTrackingTime()));
        UtilitiesAndData.putObjectToSharedPrefs(UtilitiesAndData.save_tracking_path_key, fullPathToTracking);
    }

    @Override
    public SaveTrackingInfo getSaveTrackingInfo() {
        boolean enabled = safeGetFromPrefs(UtilitiesAndData.save_tracking_enabled_key, false);
        int trackingFrequency = safeGetFromPrefs(UtilitiesAndData.save_tracking_frequency_key, 1000);
        String path = safeGetFromPrefs(UtilitiesAndData.save_tracking_path_key, UtilitiesAndData.getExternalStorage() + "/saveTracking");
        return new SaveTrackingInfo(enabled, trackingFrequency, path);
    }

    private <T> T safeGetFromPrefs(String key, T _default) {
        T t = (T) UtilitiesAndData.getObjectFromSharedPrefs(key);
        if (t != null) {
            return t;
        }
        UtilitiesAndData.putObjectToSharedPrefs(key, _default);
        return _default;
    }
}
