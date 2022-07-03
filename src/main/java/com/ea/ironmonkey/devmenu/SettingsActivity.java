package com.ea.ironmonkey.devmenu;

import static com.ea.ironmonkey.devmenu.components.ResultHandler.RESULT_HANDLER_REQUEST_CODE;

import android.app.AlertDialog;
import android.app.ApplicationErrorReport;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.ea.games.nfs13_na.BuildConfig;
import com.ea.games.nfs13_na.R;
import com.ea.ironmonkey.devmenu.components.HyperLinkText;
import com.ea.ironmonkey.devmenu.components.ResultHandler;
import com.ea.ironmonkey.devmenu.util.SaveManager;
import com.ea.ironmonkey.devmenu.dialog.SvmwCreatorDialog;
import com.ea.ironmonkey.devmenu.dialog.SvmwInspectorDialog;
import com.ea.ironmonkey.devmenu.util.UtilitiesAndData;
import com.ea.nimble.ApplicationLifecycle;

import java.io.File;

import lib.folderpicker.FolderPicker;

public class SettingsActivity extends PreferenceActivity {

    public static final String LOG_TAG = "SettingActivity";

    private void findPreferenceAndSetBehavior(int stringTitleId, Preference.OnPreferenceClickListener behavior){
        findPreference(getString(stringTitleId)).setOnPreferenceClickListener(behavior);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings_xml);

        String title = String.format(getString(R.string.dev_menu_title), BuildConfig.DEV_MENU_VERSION);
        getActionBar().setTitle(title);

        SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(this).edit();
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);

        //TODO переместить инициализацию всех значений по умолчанию в первый запуск
        //Значения по умолчанию
        editor.putString(getString(R.string.path_to_svmw_folder), UtilitiesAndData.getExternalStorage() + File.separator + "svmw");
        editor.apply();

        //Категория: Сохранения
        findPreferenceAndSetBehavior(R.string.choose_save_file_title, preference -> {
            Intent intent = new Intent(this, FolderPicker.class);
            intent.putExtra("title", getString(R.string.choose_save_file_title));
            intent.putExtra("pickFiles", true);

            ResultHandler.addResultHandler(intent, (resultIntent) -> {
                if(resultIntent.hasExtra("data")) {
                    String fileName = resultIntent.getExtras().getString("data");
                    File save = new File(fileName);
                    SaveManager manager = new SaveManager(this);
                    manager.loadSaveFile(save);
                    Toast.makeText(this, R.string.title_replaced, Toast.LENGTH_LONG).show();
                }
            });

            startActivityForResult(intent, RESULT_HANDLER_REQUEST_CODE);
            return true;
        });
        findPreferenceAndSetBehavior(R.string.title_unload_save, preference -> {
            Intent intent = new Intent(this, FolderPicker.class);
            intent.putExtra("pickFiles", false);

            ResultHandler.addResultHandler(intent, (resultIntent) -> {
                if(resultIntent.hasExtra("data")) {
                    String fileName = resultIntent.getExtras().getString("data");
                    File saveFile = UtilitiesAndData.getSaveFile();
                    File to = new File(fileName + File.separator + saveFile.getName());
                    UtilitiesAndData.copy(saveFile, to);
                    Toast.makeText(this, R.string.title_unloaded, Toast.LENGTH_LONG).show();
                }
            });

            startActivityForResult(intent, RESULT_HANDLER_REQUEST_CODE);

            return true;
        });
        findPreferenceAndSetBehavior(R.string.choose_svmw_file_title, preference -> {
            Intent intent = new Intent(this, FolderPicker.class);
            intent.putExtra("title", getString(R.string.choose_svmw_file_title));
            intent.putExtra("pickFiles", true);

            ResultHandler.addResultHandler(intent, (resultIntent) -> {
                if(resultIntent.hasExtra("data")) {
                    String fileName = resultIntent.getExtras().getString("data");
                    File file = new File(fileName);
                    SvmwInspectorDialog inspectorDialog = new SvmwInspectorDialog(this, file);
                    inspectorDialog.show();
                    Toast.makeText(this, R.string.title_replaced, Toast.LENGTH_LONG).show();
                }
            });

            startActivityForResult(intent, RESULT_HANDLER_REQUEST_CODE);
            return true;
        });

        //По нажатии на кнопку создания svmw файла осуществляется переход в диалог создания svmw
        findPreferenceAndSetBehavior(R.string.create_svmw_file_title, preference -> {
            SvmwCreatorDialog dialog = new SvmwCreatorDialog(this);
            dialog.show();

            return true;
        });
        findPreferenceAndSetBehavior(R.string.title_choose_path_to_svmw, preference -> {

            String location = preferences.getString(getString(R.string.path_to_svmw_folder), UtilitiesAndData.getExternalStorage());

            Intent intent = new Intent(this, FolderPicker.class);
            intent.putExtra("pickFiles", false);
            intent.putExtra("location", location);

            ResultHandler.addResultHandler(intent, (resultIntent) -> {
                if(resultIntent.hasExtra("data")) {
                    String fileName = resultIntent.getExtras().getString("data");
                    editor.putString(getString(R.string.path_to_svmw_folder), fileName);
                    editor.commit();
                }
            });
            startActivityForResult(intent, RESULT_HANDLER_REQUEST_CODE);

            return true;
        });

        //Категория: Отслеживнание
        findPreferenceAndSetBehavior(R.string.title_settings_save_file_track, preference -> true);
        
        //Категория: Состояние DevMenu
        findPreferenceAndSetBehavior(R.string.title_about_the_author, preference -> {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);

            HyperLinkText text =
                    new HyperLinkText("text %s",
                            new HyperLinkText.Container(BuildConfig.MY_VK_PAGE, "its me"));

            builder1.setMessage(text.getSpanned());

            builder1.setCancelable(false);
            builder1.setPositiveButton("ok", (dialog, which) -> {
            });

            AlertDialog Alert1 = builder1.create();
            Alert1 .show();
            ((TextView)Alert1.findViewById(android.R.id.message)).setMovementMethod(LinkMovementMethod.getInstance());
            return true;
        });
        findPreferenceAndSetBehavior(R.string.switch_off_devmenu_title, preference -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.switch_off_devmenu_title);
            builder.setMessage(R.string.msg_devmenu_off);
            builder.setPositiveButton(R.string.ok_title, (dialog, which) -> UtilitiesAndData.getDevMenuSwitcher().delete());
            builder.setNegativeButton(R.string.cancel_title, null);
            builder.show();
            return true; 
        });

        
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        ResultHandler handler = new ResultHandler(this);
        handler.onIncomingIntent(data);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
}
