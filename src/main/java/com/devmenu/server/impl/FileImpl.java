package com.devmenu.server.impl;

import com.devmenu.server.UtilitiesAndData;
import entities.Element;
import entities.Folder;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import kotlinx.datetime.Instant;
import org.apache.commons.io.FileUtils;
import ru.megboyzz.api.FileAPI;

public class FileImpl implements FileAPI {
    @Override
    public boolean isFile(String path) {
        return new File(path).isFile();
    }

    @Override
    public File openFile(String path) {
        File file = new File(path);
        if (!file.exists()) {
            throw new RuntimeException();
        }
        return file;
    }

    @Override
    public void removeFile(String path) {
        File file = new File(path);
        if (!file.exists()) {
            throw new RuntimeException();
        }
        if (!file.isFile()) {
            try {
                FileUtils.deleteDirectory(file);
                return;
            } catch (IOException e) {
                e.printStackTrace();
                return;
            }
        }
        file.delete();
    }

    @Override
    public void createFile(String path) {
        File file = new File(path);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Folder getFile(String path) {
        File[] listFiles;
        File file = new File(path);
        List<String> files = new ArrayList<>();
        List<String> folders = new ArrayList<>();
        for (File f : file.listFiles()) {
            if (f.isFile()) {
                files.add(f.getName());
            } else {
                folders.add(f.getName());
            }
        }
        return new Folder(folders, files);
    }

    @Override
    public Element getInfo(String path) {
        File file = new File(path);
        if (!file.exists()) {
            throw new RuntimeException();
        }
        return new Element(file.getName(), file.getParent(), path, UtilitiesAndData.getElementSize(file), Instant.Companion.fromEpochMilliseconds(file.lastModified()), UtilitiesAndData.getReplacementID(path));
    }

    @Override
    public void saveFile(String path, InputStream inputStream) {
        File file = new File(path);
        if (!file.exists()) {
            throw new RuntimeException();
        }
        try {
            FileUtils.copyInputStreamToFile(inputStream, file);
        } catch (IOException e) {
            throw new RuntimeException();
        }
    }
}
