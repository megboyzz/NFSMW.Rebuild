package com.ea.ironmonkey.devmenu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import com.ea.games.nfs13_na.BuildConfig;
import com.ea.games.nfs13_na.R;
import com.ea.ironmonkey.GameActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

public class MainActivity extends Activity {

    private final String LOG_TAG = "InjectedActivity";
    private File internalFiles;
    private ListView fileList;

    private void runGame() {

        Intent GoToGame = new Intent(this, GameActivity.class);
        startActivity(GoToGame);

    }

    //(new ContextWrapper(this)).getFilesDir().getAbsolutePath()

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        String flag;

        File activityFlag = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + this.getPackageName() + "/mode.txt");
        try {
            Log.d(LOG_TAG, "activityFlag is exists))");

            BufferedReader reader = new BufferedReader(new FileReader(activityFlag));

            flag = reader.readLine();

        } catch (FileNotFoundException e) {
            Log.e(LOG_TAG, "FileNotFoundException " + e.getLocalizedMessage());
            flag = "false";
        } catch (IOException e) {
            Log.e(LOG_TAG, "IOException " + e.getLocalizedMessage());
            flag = "false";
        }

        if (flag == null || !flag.equals("true")) runGame();

        super.onCreate(savedInstanceState);

        setContentView(R.layout.custom);

        String title = String.format(getString(R.string.dev_menu_title), BuildConfig.DEV_MENU_VERSION);

        getActionBar().setTitle(title);

        internalFiles = new File(getFilesDir().getAbsolutePath() + "/var");

        fileList = (ListView) findViewById(R.id.FileList);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.options, menu);
        return true;
    }

    private void updateLanguage(){
        //Получаем текущий язык
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String current_lang = preferences.getString(getString(R.string.current_lang), "00");
        if(current_lang.equals("00")) {
            Log.e(LOG_TAG, "Not found currentLang preference(");
            return;
        }
        if(current_lang.equals("sys"))
            current_lang = Locale.getDefault().getLanguage();

        byte[] current_lang_bytes = current_lang.getBytes();

        //Открываем языковой файл и создаем поток чтения
        File locale = new File(internalFiles.getAbsolutePath() + "/locale");
        FileInputStream inputStream = null;

        //Байтовое представление файла
        byte[] bytes_locale = new byte[4];
        try {

            inputStream = new FileInputStream(locale);
            inputStream.read(bytes_locale);

        } catch (FileNotFoundException e) {
            Log.wtf(LOG_TAG, "No found locale(((((");
            return;
        }catch (IOException e){
            Log.wtf(LOG_TAG, "Couldn't read the locale file((((((");
            return;
        }

        if(
                bytes_locale[2] != current_lang_bytes[0] &
                bytes_locale[3] != current_lang_bytes[1]
        )
        {
            bytes_locale[2] = current_lang_bytes[0];
            bytes_locale[3] = current_lang_bytes[1];
        }
        else return;

        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(locale, false);
            outputStream.write(bytes_locale, 0, 4);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.optionRunTheGame: {
                updateLanguage();
                runGame();
            }
            break;

            case R.id.optionSettings: {

                Intent GoToSettings = new Intent(this, InjectedSettingsActivity.class);
                startActivity(GoToSettings);

            }
            break;
            case R.id.optionDeleteData: {

                AlertDialog.Builder builder = new AlertDialog.Builder(this);

                builder.setTitle("lol");
                builder.setMessage("Hello, world!");
                builder.setPositiveButton("OK", (dialogInterface, i) -> {
                    Toast.makeText(MainActivity.this, "Deleted)", Toast.LENGTH_LONG).show();
                });
                builder.setNegativeButton("Cancel", (dialogInterface, i) -> {

                });
                builder.show();

            }
            break;

        }

        return super.onOptionsItemSelected(item);
    }


}