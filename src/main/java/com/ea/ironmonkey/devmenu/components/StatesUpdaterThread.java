package com.ea.ironmonkey.devmenu.components;

import android.content.Context;

/**
 * Класс обновления состояний<br>
 * Он нужен для запуска различных служб
 *
 */
public class StatesUpdaterThread extends Thread {

    private Context context;

    public StatesUpdaterThread(Context context) {
        super(()->{
            while (true){

            }
        });
        this.context = context;
    }


}
