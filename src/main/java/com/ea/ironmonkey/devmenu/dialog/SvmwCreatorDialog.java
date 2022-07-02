package com.ea.ironmonkey.devmenu.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.ea.games.nfs13_na.R;
import com.ea.ironmonkey.devmenu.util.SaveManager;
import com.ea.ironmonkey.devmenu.util.UtilitiesAndData;

import java.io.File;
import java.io.IOException;

/**
 * Диалог для содания бандлов
 * Сам умеет их создавать
 */
public class SvmwCreatorDialog extends AlertDialog {

    private EditText nameEdit;
    private EditText desEdit;
    private CheckBox isUseCurSaveBox;
    private View mainView;

    private boolean useCurrentSave;

    private SaveManager manager;
    private Context context;

    private File svmwPath;

    public SvmwCreatorDialog(Activity activity) {
        super(activity);
        context = activity.getApplicationContext();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(context);
        String path = preferences.getString(
                context.getString(R.string.path_to_svmw_folder),
                UtilitiesAndData.getExternalStorage() + File.separator + "svmw"
        );
        svmwPath = new File(path);
        svmwPath.mkdir();
        setTitle("Создание SVMW");
        mainView = LayoutInflater
                .from(context)
                .inflate(R.layout.saves, null, false);

        nameEdit = (EditText) mainView.findViewById(R.id.name_svmw);
        desEdit = (EditText) mainView.findViewById(R.id.des_svmw);

        isUseCurSaveBox = (CheckBox) mainView.findViewById(R.id.isUseCurrentSave);
        manager = new SaveManager(context);

        //Конпка создания
        setButton(context.getText(R.string.create_svmw_file_title), (dialog, witch) -> {
            String name = getTextFrom(nameEdit);
            String des = getTextFrom(desEdit);
            if(name.isEmpty() | des.isEmpty()){
                Toast.makeText(context, context.getText(R.string.toast_strings_must_be_entered), Toast.LENGTH_LONG).show();
                return;
            }
            File to = new File(svmwPath.getAbsolutePath() + File.separator + name + ".svmw");
            try {
                to.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            manager.createBundleFile(des, to, UtilitiesAndData.getSaveFile());
        });
        //Кнопка отмены
        setButton2(context.getText(R.string.cancel_title), (OnClickListener) null);
        //Кнопка выбора отдельного файла
        setButton3(context.getString(R.string.choose_svmw_file_title), (dialog, witch) -> {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("file/*");
            getOwnerActivity().startActivityForResult(intent, 228);
        });

        isUseCurSaveBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            useCurrentSave = isChecked;
            getButton(AlertDialog.BUTTON3).setEnabled(!isChecked);
        });


        // Если включена опция "Использовать текущее сохранение" то заюлокировтаь кнопку выбора файла сохранения

        setView(mainView);
    }

    private String getTextFrom(EditText editText){
        return editText.getText().toString();
    }
}
