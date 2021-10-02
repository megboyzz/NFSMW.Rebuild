package com.ea.ironmonkey.devmenu;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.view.MenuItem;

import com.ea.games.nfs13_na.BuildConfig;
import com.ea.games.nfs13_na.R;
import com.ea.nimble.ApplicationLifecycle;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class InjectedSettingsActivity extends PreferenceActivity {


    public void copySave(String fileName) throws IOException {

        File source = new File(fileName);

        File dest = new File("/data/data/" + getPackageName() + "/files/var/nfstr_save.sb");


        if(!dest.exists()) {
            try {
                dest.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            os = new FileOutputStream(dest);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
            is.close();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings_xml);

        ApplicationLifecycle.onActivityCreate(savedInstanceState, this);

        String title = String.format(getString(R.string.dev_menu_title), BuildConfig.DEV_MENU_VERSION);
        getActionBar().setTitle(title);

        Preference chooseSaveFileButton = findPreference(getString(R.string.choose_save_file_title));

        final Context myContext = this;


        chooseSaveFileButton.setOnPreferenceClickListener(preference -> {

            OpenFileDialog fileDialog = new OpenFileDialog(myContext);
            fileDialog
                    .setFilter(".*\\.sb")
                    .setOpenDialogListener(fileName -> {

                        try {
                            copySave(fileName);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                    });

            fileDialog.show();

            return true;
        });

        getActionBar().setDisplayHomeAsUpEnabled(true);


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
