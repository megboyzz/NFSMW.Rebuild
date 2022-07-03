package com.ea.ironmonkey.devmenu.components;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Обработчик входящих Intent'ов в onActivityResult
 */
public class ResultHandler {

    private Context context;
    private static Map<Integer, ResultAction> map = new HashMap<>();
    private static final int RANDOM_BOUNDS = Integer.MAX_VALUE;
    private static final String LOG_TAG = "ResultHandler";

    public static final int RESULT_HANDLER_REQUEST_CODE = 0;
    public static final String ACTION_ID_TITLE = "ACTION_ID";

    public ResultHandler(Context context) {
        this.context = context;
    }

    /**
     * Статические поля кодов обработки входящих интентов
     */
    public enum Fields{
        FILE_OPEN,
    }

    public static void addResultHandler(Intent intent, ResultAction action){
        int random = (new Random()).nextInt(RANDOM_BOUNDS);
        intent.putExtra(ACTION_ID_TITLE, random);
        map.put(random, action);
    }

    public void onIncomingIntent(Intent data){
        if(data != null){
            if(data.hasExtra(ACTION_ID_TITLE)){
                int id = data.getExtras().getInt(ACTION_ID_TITLE);
                map.get(id).action();
            }else{
                Log.e(LOG_TAG, "Incoming intent haven't got ACTION_ID!!");
                throw new RuntimeException(
                        "ResultHandler::RuntimeException can't parse incoming intent! Shutting down(("
                );
            }
        }else{
            Log.e(LOG_TAG, "Incoming intent is null!!");
            throw new RuntimeException(
                    "ResultHandler::RuntimeException can't parse incoming intent! Shutting down(("
            );
        }
    }
}
