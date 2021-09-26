package com.ea.ironmonkey.devmenu;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.MimeTypeMap;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.ea.games.nfs13_na.BuildConfig;
import com.ea.games.nfs13_na.R;
import com.ea.ironmonkey.GameActivity;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class MainActivity extends Activity {

    private final String LOG_TAG = "InjectedActivity";

    private String internalFiles;
    private String externalFiles;

    private String globalPath = "";

    private ListView fileList;
    private Button backButton;

    private void runGame() {

        Intent GoToGame = new Intent(this, GameActivity.class);
        startActivity(GoToGame);

    }

    private <T> List<T> asList(T[] a){
        return Arrays.asList(a);
    }

    private List<File> asList(String path){
        return asList(new File(path).listFiles());
    }

    private ArrayList<File> asList2(String path){
        ArrayList<File> arrayList = new ArrayList<>();
        File file = new File(path);
        for(int i = 0; i < file.list().length; i++)
            arrayList.add(file.listFiles()[i]);
        return arrayList;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        internalFiles = "/data/data/" + getPackageName();
        externalFiles = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Android/data/" + getPackageName() + "/files";

        File activityFlag = new File(externalFiles + "/" + BuildConfig.DEV_MENU_ID);
        if(!activityFlag.exists()){
            updateLanguage();
            runGame();
            return;
        }

        setContentView(R.layout.custom);

        String title = String.format(getString(R.string.dev_menu_title), BuildConfig.DEV_MENU_VERSION);

        getActionBar().setTitle(title);


        fileList = (ListView) findViewById(R.id.FileList);

        fileList.setAdapter(new FileAdapter(this, asList(externalFiles)));
        globalPath = externalFiles;

        RadioGroup group = (RadioGroup) findViewById(R.id.switcherFiles);

        fileList.setOnItemClickListener((parent, view, position, id) -> {
            TextView textView = (TextView) view;
            String chosenElem = textView.getText().toString(); // получаем текст нажатого элемента

            //String currentPath = (group.getCheckedRadioButtonId() == R.id.externalStoreButton) ? externalFiles : internalFiles;
            File intermid =  new File(globalPath + "/" + chosenElem);
            if(intermid.isDirectory()) {
                globalPath += "/" + chosenElem;
                File file = new File(globalPath);
                fileList.setAdapter(new FileAdapter(getApplicationContext(), asList(file.listFiles())));
            }
            else{
               String mime = MimeTypeMap.getSingleton().getMimeTypeFromExtension(".JPG");

                Intent intent = new Intent();
                intent.setAction(android.content.Intent.ACTION_VIEW);
                intent.setDataAndType(Uri.fromFile(intermid), mime);
                startActivityForResult(intent, 10);
            }

        });

        fileList.setOnItemLongClickListener((parent, view, position, id) -> {
            TextView textView = (TextView) view;
            String chosenElem = textView.getText().toString();

            DataNinja ninja = new DataNinja(this, globalPath + "/" + chosenElem);
            return true;
        });

        group.setOnCheckedChangeListener((group1, checkedId) -> {

            if ((checkedId == R.id.externalStoreButton)) {
                fileList.setAdapter(new FileAdapter(this, asList(externalFiles)));
                globalPath = externalFiles;
            }
            else {
                fileList.setAdapter(new FileAdapter(this, asList(internalFiles)));
                globalPath = internalFiles;
            }
        });

        backButton = (Button)findViewById(R.id.back_button);

        backButton.setOnClickListener(v -> {
            if(!( globalPath.equals(internalFiles) | globalPath.equals(externalFiles) )
                    & !globalPath.isEmpty()
                    & (new File(globalPath).exists())) {
                globalPath = globalPath.substring(0, globalPath.lastIndexOf("/"));
                fileList.setAdapter(new FileAdapter(this, asList(globalPath)));
            }
        });


    }

    @Override
    public void onBackPressed() {
        backButton.callOnClick();
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
        File locale = new File(internalFiles + "/files/var/locale");
        FileInputStream inputStream;

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