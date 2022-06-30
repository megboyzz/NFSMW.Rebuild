package com.ea.ironmonkey.devmenu;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.view.MenuItem;

import com.ea.games.nfs13_na.BuildConfig;
import com.ea.games.nfs13_na.R;
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



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings_xml);
        
        ApplicationLifecycle.onActivityCreate(savedInstanceState, this);

        String title = String.format(getString(R.string.dev_menu_title), BuildConfig.DEV_MENU_VERSION);
        getActionBar().setTitle(title);

        Preference chooseSaveFileButton = findPreference(getString(R.string.choose_save_file_title));
        Preference chooseSVMWfileButton = findPreference(getString(R.string.choose_svmw_file_title));
        Preference createSVMWfileButton = findPreference(getString(R.string.create_svmw_file_title));
        Preference turnOffTheDevMenuButton = findPreference(getString(R.string.switch_off_devmenu_title));


        turnOffTheDevMenuButton.setOnPreferenceClickListener(preference -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(R.string.switch_off_devmenu_title);
            builder.setMessage(R.string.msg_devmenu_off);
            builder.setPositiveButton(R.string.ok_title, (dialog, which) -> UtilitiesAndData.getDevMenuSwitcher().delete());
            builder.setNegativeButton(R.string.cancel_title, null);
            builder.show();
            return true;
        });

        chooseSaveFileButton.setOnPreferenceClickListener(preference -> {

            Intent intent = new Intent(this, FolderPicker.class);
            intent.putExtra("title", getString(R.string.choose_save_file_title));
            intent.putExtra("pickFiles", true);
            intent.putExtra("svmw", false);

            startActivityForResult(intent, PICKFILE_REQUEST_CODE);

            return true;
        });

        chooseSVMWfileButton.setOnPreferenceClickListener(preference -> {

            Intent intent = new Intent(this, FolderPicker.class);
            intent.putExtra("title", getString(R.string.choose_save_file_title));
            intent.putExtra("pickFiles", true);
            intent.putExtra("svmw", true);

            startActivityForResult(intent, PICKFILE_REQUEST_CODE);
            return true;
        });

        //По нажатии на кнопку создания svmw файла осуществляется переход в диалог создания svmw
        createSVMWfileButton.setOnPreferenceClickListener(preference -> {

            SvmwCreatorDialog dialog = new SvmwCreatorDialog(this);
            dialog.show();

            return true;
        });
        
        getActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(data != null) {
            switch (requestCode) {
                //В случае если произошел файл пик
                case PICKFILE_REQUEST_CODE: {
                    //Интент имеет ключи data и svmw
                    //data - путь к выбранному файлу
                    //svmw - флаг отого что пришло sb или svmw
                    if(data.hasExtra("data") && data.hasExtra("svmw")){
                        
                        String fileName = data.getExtras().getString("data");
                        
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
                    String s = data.getData().toString();
                    String s1 = s.replaceAll("file://", "");
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
