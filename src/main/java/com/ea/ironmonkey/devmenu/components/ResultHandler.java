package com.ea.ironmonkey.devmenu.components;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

/**
 * Обработчик входящих Intent'ов в onActivityResult
 * <br>
 *
 * <br>
 * Работет это следующим образом:<br>
 * Есть две Активности А и Б. Нужно из А переити в Б
 * и вернуть результат из Б обратно А(Пример выбор папки или файла)<br><br>
 * Для этого нужно создать интент перехода из А в Б
 * Далее вызвать метод {@link ResultHandler#addResultHandler(Intent, ResultAction)}<br>
 * с созданным интентом и действием по завершению работы Акстиности Б<br><br>
 * Так же нужно не забыть произвести действия в onActivityResult(int, int, Intent)
 * А именно Вызвать метод {@link ResultHandler#onIncomingIntent(Intent)} и передать туда входящий интент<br><br>
 * Примечание:<br>
 * Если Актиность Б определена как {@link Intent#ACTION_VIEW} то в onActivityResult(int, int, Intent)<br>
 * вернется интент == null поэтому в этом классе есть {@link ResultHandler#actionViewResultAction} который предоставляет действие если это все таки был {@link Intent#ACTION_VIEW}
 */
public class ResultHandler {

    private Context context;
    private static Map<Integer, ResultAction> map = new HashMap<>();
    private static final String LOG_TAG = "ResultHandler";
    private static ResultAction actionViewResultAction;
    private static final String INTENT_ERROR_MSG = "ResultHandler::RuntimeException can't parse incoming intent! Shutting down((";

    public static final int RESULT_HANDLER_REQUEST_CODE = 0;
    public static final int RESULT_HANDLER_ACTION_VIEW_REQUEST_CODE = 1;
    public static final String ACTION_ID_TITLE = "ACTION_ID";

    public ResultHandler(Context context) {
        this.context = context;
    }

    public static void addResultHandler(Intent intent, ResultAction action){

        if(Objects.equals(intent.getAction(), Intent.ACTION_VIEW)) actionViewResultAction = action;
        else {
            int hash = action.hashCode();
            intent.putExtra(ACTION_ID_TITLE, hash);
            map.put(hash, action);
        }
    }

    public void onIncomingIntent(Intent data){
        if(data != null){
            if(data.hasExtra(ACTION_ID_TITLE)){
                int id = data.getExtras().getInt(ACTION_ID_TITLE);
                ResultAction resultAction = map.get(id);
                //Если resultAction == null то происходит пустое действие(Ничего не происходит)
                if(resultAction != null) resultAction.action(data);
            }else{
                Log.e(LOG_TAG, "Incoming intent haven't got ACTION_ID!!");
                throw new RuntimeException(INTENT_ERROR_MSG);
            }
        }else{
            if(actionViewResultAction != null){
                actionViewResultAction.action(new Intent());
            }else {
                Log.e(LOG_TAG, "Incoming intent is null!!");
                throw new RuntimeException(INTENT_ERROR_MSG);
            }
        }
    }
}
