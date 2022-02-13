package com.ea.ironmonkey.devmenu;

import static com.ea.ironmonkey.devmenu.util.UtilitiesAndData.OPEN_FILE_ON_REPLACE_REQUEST;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TwoLineListItem;

import com.ea.games.nfs13_na.BuildConfig;
import com.ea.games.nfs13_na.R;
import com.ea.ironmonkey.GameActivity;
import com.ea.ironmonkey.devmenu.util.UtilitiesAndData;
import com.ea.ironmonkey.devmenu.util.ReplacementDataBaseHelper;
import com.ea.ironmonkey.devmenu.util.ResultListener;

import org.apache.commons.codec.digest.DigestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends Activity {

    private final String LOG_TAG = "InjectedActivity";

    private String internalFiles;
    private String externalFiles;
    private ResultListener resultListener;
    private ResultListener openResult = new ResultListener() {};

    public void setResultListener(ResultListener resultListener) {
        this.resultListener = resultListener;
    }

    private String globalPath = "";

    private ListView fileList;
    private Button backButton;
    private static final int READ_FILE_REQUEST_CODE = 101;

    private byte[] generateMD5(File file){
        try {
            return DigestUtils.md5(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[1];
    }

    public void openFile(File url) {
        File tempFile = null;

        Intent intent = new Intent(Intent.ACTION_VIEW);

        if(url.getAbsolutePath().contains(UtilitiesAndData.getInternalStorage())){
            Log.wtf(LOG_TAG, "WTF, man, you cant read my files!!! bitch");

            //Создаем временный файл, там где можем его прочитать
            Random random = new Random();
            tempFile = new File(UtilitiesAndData.getExternalStorage() + File.separator + "temp_" + random.nextInt());
            //Копируем тот файл который хотим посмотреть
            copy(url.getAbsolutePath(), tempFile.getAbsolutePath());

            //Сохраняем ссылку на окрытый файл, в случае его изменения
            final File openedFile = url;
            url = tempFile;
            File finalTempFile = tempFile;

            //Создаем хеш файла для того чтобы его потом сравнить

            final byte[] compTemp = generateMD5(finalTempFile);

            File finalUrl = url;
            openResult = new ResultListener(){
                @Override
                public void onResult(Object data) {
                    byte[] bytes = generateMD5(finalTempFile);
                    //Если хеши не одинаковы то заменяем одно на другое
                    if(!bytes.equals(compTemp)){
                        copy(finalTempFile.getAbsolutePath(), openedFile.getAbsolutePath());
                    }
                    finalTempFile.delete();
                }
            };
            intent.putExtra("pathToTemp", tempFile.getAbsolutePath());
        }
        // Create URI
        Uri uri = Uri.fromFile(url);

        // Check what kind of file you are trying to open, by comparing the url with extensions.
        // When the if condition is matched, plugin sets the correct intent (mime) type,
        // so Android knew what application to use to open the file
        // Word document
        if (url.toString().contains(".doc") || url.toString().contains(".docx"))
            intent.setDataAndType(uri, "application/msword");
        else if(url.toString().contains(".pdf")) {
            // PDF file
            intent.setDataAndType(uri, "application/pdf");
        } else if(url.toString().contains(".ppt") || url.toString().contains(".pptx")) {
            // Powerpoint file
            intent.setDataAndType(uri, "application/vnd.ms-powerpoint");
        } else if(url.toString().contains(".xls") || url.toString().contains(".xlsx")) {
            // Excel file
            intent.setDataAndType(uri, "application/vnd.ms-excel");
        } else if(url.toString().contains(".zip") || url.toString().contains(".rar")) {
            // WAV audio file
            intent.setDataAndType(uri, "application/x-wav");
        } else if(url.toString().contains(".rtf")) {
            // RTF file
            intent.setDataAndType(uri, "application/rtf");
        } else if(url.toString().contains(".wav") || url.toString().contains(".mp3")) {
            // WAV audio file
            intent.setDataAndType(uri, "audio/x-wav");
        } else if(url.toString().contains(".gif")) {
            // GIF file
            intent.setDataAndType(uri, "image/gif");
        } else if(url.toString().contains(".jpg") || url.toString().contains(".jpeg") || url.toString().contains(".png")) {
            // JPG file
            intent.setDataAndType(uri, "image/jpeg");
        } else if(url.toString().contains(".txt")) {
            // Text file
            intent.setDataAndType(uri, "text/plain");
        } else if(url.toString().contains(".3gp") || url.toString().contains(".mpg") || url.toString().contains(".mpeg") || url.toString().contains(".mpe") || url.toString().contains(".mp4") || url.toString().contains(".avi")) {
            // Video files
            intent.setDataAndType(uri, "video/*");
        } else {
            //if you want you can also define the intent type for any other file

            //additionally use else clause below, to manage other unknown extensions
            //in this case, Android will show all applications installed on the device
            //so you can choose which application to use
            intent.setDataAndType(uri, "*/*");
        }

        //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivityForResult(intent, READ_FILE_REQUEST_CODE);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode){
            case OPEN_FILE_ON_REPLACE_REQUEST:{
                resultListener.onResult(data);
            }break;

            case READ_FILE_REQUEST_CODE:{
                openResult.onResult(data);
            }
        }

    }

    private void runGame() {

        Intent GoToGame = new Intent(this, GameActivity.class);
        startActivity(GoToGame);

    }
    void copy(String from, String to) {
        File source = new File(from);

        File dest = new File(to);


        if (!dest.exists()) {
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
            //Math.max(getFileSize(source), getFileSize(dest));
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
            is.close();
            os.close();
        } catch (FileNotFoundException e) {
            Log.e(LOG_TAG, e.toString());
            dest.delete();
            e.printStackTrace();
        } catch (IOException e) {
            Log.e(LOG_TAG, e.toString());
            dest.delete();
            e.printStackTrace();
        }
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

        UtilitiesAndData.init(this);

        internalFiles = UtilitiesAndData.getInternalStorage();
        externalFiles = UtilitiesAndData.getExternalStorage();

        File replacements = new File(UtilitiesAndData.getReplacementsStorage());
        if(!replacements.exists()) replacements.mkdir();


        File activityFlag = new File(externalFiles + File.separator + BuildConfig.DEV_MENU_ID);
        if(!activityFlag.exists()){
            updateLanguage();
            runGame();
            return;
        }

        ReplacementDataBaseHelper helper = new ReplacementDataBaseHelper(this);

        setContentView(R.layout.custom);

        String title = String.format(getString(R.string.dev_menu_title), BuildConfig.DEV_MENU_VERSION);

        getActionBar().setTitle(title);




        fileList = (ListView) findViewById(R.id.FileList);

        fileList.setAdapter(new FileAdapter(this, asList(externalFiles)));
        globalPath = externalFiles;

        RadioGroup group = (RadioGroup) findViewById(R.id.switcherFiles);

        fileList.setOnItemClickListener((parent, view, position, id) -> {
            String chosenElem =
                    (view instanceof TwoLineListItem) ?
                            ((TwoLineListItem) view).getText1().getText().toString() :
                            ((TextView) view).getText().toString(); // получаем текст нажатого элемента

            //String currentPath = (group.getCheckedRadioButtonId() == R.id.externalStoreButton) ? externalFiles : internalFiles;
            File intermid =  new File(globalPath + "/" + chosenElem);
            if(intermid.isDirectory()) {
                globalPath += "/" + chosenElem;
                File file = new File(globalPath);
                fileList.setAdapter(new FileAdapter(getApplicationContext(), asList(file.listFiles())));
            }
            else{
               openFile(intermid);
            }

        });

        fileList.setOnItemLongClickListener((parent, view, position, id) -> {
            String chosenElem =
                    (view instanceof TwoLineListItem) ?
                    ((TwoLineListItem) view).getText1().getText().toString() :
                    ((TextView) view).getText().toString();


            DataNinja ninja = new DataNinja(this, globalPath + "/" + chosenElem, fileList, position);
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


        //Настройка языка игры
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        ///preferences.set

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

        FileOutputStream outputStream;
        try {
            outputStream = new FileOutputStream(locale, false);
            outputStream.write(bytes_locale, 0, 4);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

    }


    @SuppressLint("NonConstantResourceId")
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

                builder.setTitle(getString(R.string.remove_action_title));
                builder.setMessage(getString(R.string.sure_remove_all_data_title));
                builder.setPositiveButton(R.string.ok_title, (dialogInterface, i) -> {
                    File[] internals = new File(UtilitiesAndData.getInternalStorage()).listFiles();
                    for (File internal : internals)
                        if(!UtilitiesAndData.isExclusionName(internal.getName()))
                            internal.delete();
                });
                builder.setNegativeButton(R.string.cancel_title, null);
                builder.show();

            }
            break;

        }

        return super.onOptionsItemSelected(item);
    }


}