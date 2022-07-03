package com.ea.ironmonkey.devmenu.components;

/**
 * Интерфейс описания действий в контекстном меню файла {@link LongPressContextMenu}
 */
public interface FileAction {
    
    void actionReplaceFile();

    void actionRecoverFile();

    void actionRemoveFile();

    void actionTrackTheFile();

    void actionGetPropsOfFile();

    void actionHideTheFile();

    void actionSaveFile();
}
