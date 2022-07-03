package com.ea.ironmonkey.devmenu;

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

import com.ea.games.nfs13_na.BuildConfig;
import com.ea.games.nfs13_na.R;
import com.ea.ironmonkey.devmenu.components.HyperLinkText;
import com.ea.ironmonkey.devmenu.util.SaveManager;
import com.ea.ironmonkey.devmenu.dialog.SvmwCreatorDialog;
import com.ea.ironmonkey.devmenu.dialog.SvmwInspectorDialog;
import com.ea.ironmonkey.devmenu.util.UtilitiesAndData;
import com.ea.nimble.ApplicationLifecycle;

import java.io.File;

import lib.folderpicker.FolderPicker;

public class SettingsActivity extends PreferenceActivity {

    public static final String LOG_TAG = "SettingActivity";

    private static final int PICKFILE_REQUEST_CODE = 128;
    public static final int PICK_SVMW_REQUEST_CODE = 129;
    public static final int PICK_SVMW_IN_CREATE = 228;
    public static final int SAVE_FILE_INTO = 65;
    public static final int PICK_FOLDER_SVMW_REQUEST_CODE = 130;

    private void findPreferenceAndSetBehavior(int stringTitleId, Preference.OnPreferenceClickListener behavior){
        findPreference(getString(stringTitleId)).setOnPreferenceClickListener(behavior);
    }


    private void findSwitchPreferenceAndSetBehavior(int stringTitleId, Preference.OnPreferenceChangeListener behavior){
        findPreference(getString(stringTitleId)).setOnPreferenceChangeListener(behavior);
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
            intent.putExtra("svmw", false);

            startActivityForResult(intent, PICKFILE_REQUEST_CODE);

            return true;
        });
        findPreferenceAndSetBehavior(R.string.title_unload_save, preference -> {
            Intent intent = new Intent(this, FolderPicker.class);
            intent.putExtra("pickFiles", false);
            startActivityForResult(intent, SAVE_FILE_INTO);
            return true;
        });
        findPreferenceAndSetBehavior(R.string.choose_svmw_file_title, preference -> {
            Intent intent = new Intent(this, FolderPicker.class);
            intent.putExtra("title", getString(R.string.choose_save_file_title));
            intent.putExtra("pickFiles", true);
            intent.putExtra("svmw", true);

            startActivityForResult(intent, PICKFILE_REQUEST_CODE);
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

            startActivityForResult(intent, PICK_FOLDER_SVMW_REQUEST_CODE);

            return true;
        });

        //Категория: Отслеживнание
        findSwitchPreferenceAndSetBehavior(R.string.enable_tracking, (preference, o) -> true);
        findPreferenceAndSetBehavior(R.string.title_settings_save_file_track, preference -> true);
        
        //Категория: Состояние DevMenu
        findPreferenceAndSetBehavior(R.string.title_about_the_author, preference -> {
            AlertDialog.Builder builder1 = new AlertDialog.Builder(this);

            HyperLinkText text =
                    new HyperLinkText(
                            "ЧТО НОВОГО v0.2\n" +
                                    "\n" +
                                    "+Обновлен проводник для выбора файлов и добавлена возможность\n" +
                                    "выбирать папки для сохранения файлов из внутреннего хранилища(/data/data)\n" +
                                    "\n" +
                                    "+Код основной части отрефакторен\n" +
                                    "\n" +
                                    "+На Главной страннице, а именно в проводнике добавилась строка состояния\n" +
                                    "Указывающаяя на то где по папкам мы находимся\n" +
                                    "\n" +
                                    "+Добавлен список всех замененных файлов с кнопкой воостановить все замененные файлы\n" +
                                    "\n" +
                                    "+-Реализованы bundle-файлы сохранений - *.svmw специальные файлы сохранений\n" +
                                    "призванные упростить работу с сохранениями(Я писал о них постами ниже)\n" +
                                    "Они хранят дату создания файла и его краткое описание\n" +
                                    "Чтобы было проще различать файлы сохранений\n" +
                                    "Эти файлы можно создавать как из текущего сохранения в игре так \n" +
                                    "и из любого другого файла nfstr_save.sb \n" +
                                    "\n" +
                                    "+Реализована выгрузка любого файла из внутреннего хранилища(Кроме нативных библиотек(*.so) и папки lib)\n" +
                                    "\n" +
                                    "Добавлена кнопочка об авторе)\n" +
                                    "\n" +
                                    "Добавлена функция отслеживания изменения файла сохранения,\n" +
                                    "что поможет в разборе *.sb/*.sba файлов\n" +
                                    "\n" +
                                    "+Реализована кнопка менб \"Удалить данные\"\n %s" ,
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


        String fileName = "";
        if(data != null) {

            if(data.hasExtra("data"))
                fileName = data.getExtras().getString("data");
            else throw new RuntimeException("data has no data extras((");

            switch (requestCode) {
                //В случае если произошел файл пик
                case PICKFILE_REQUEST_CODE: {
                    //Интент имеет ключи data и svmw
                    //data - путь к выбранному файлу
                    //svmw - флаг отого что пришло sb или svmw
                    if(data.hasExtra("svmw")){
                        
                        if(data.getExtras().getBoolean("svmw")) {
                            File file = new File(fileName);
                            SvmwInspectorDialog inspectorDialog = new SvmwInspectorDialog(this, file);
                            inspectorDialog.show();
                        }else{
                            File save = new File(fileName);
                            SaveManager manager = new SaveManager(this);
                            manager.loadSaveFile(save);
                        }
                    }
                }
                case PICK_SVMW_REQUEST_CODE: {

                }
                case PICK_FOLDER_SVMW_REQUEST_CODE:{
                    SharedPreferences.Editor editor = PreferenceManager.getDefaultSharedPreferences(this).edit();
                    editor.putString(getString(R.string.path_to_svmw_folder), fileName);
                    editor.commit();
                }
                case SAVE_FILE_INTO:{
                    File saveFile = UtilitiesAndData.getSaveFile();
                    File to = new File(fileName + File.separator + saveFile.getName());
                    UtilitiesAndData.copy(saveFile, to);
                }
            }

        }
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
