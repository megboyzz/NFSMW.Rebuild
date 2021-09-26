package com.ea.ironmonkey.devmenu;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.view.MenuItem;
import android.widget.Toast;

import com.ea.games.nfs13_na.BuildConfig;
import com.ea.games.nfs13_na.R;

public class InjectedSettingsActivity extends PreferenceActivity {

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings_xml);

        String title = String.format(getString(R.string.dev_menu_title), BuildConfig.DEV_MENU_VERSION);
        getActionBar().setTitle(title);

        Preference chooseSaveFileButton = findPreference(getString(R.string.choose_save_file_title));

        final Context myContext = this;


        chooseSaveFileButton.setOnPreferenceClickListener(preference -> {

            OpenFileDialog fileDialog = new OpenFileDialog(myContext);
            fileDialog
                    .setFilter(".*\\.sb")
                    .setOpenDialogListener(fileName -> Toast.makeText(getApplicationContext(), fileName, Toast.LENGTH_LONG).show());

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
