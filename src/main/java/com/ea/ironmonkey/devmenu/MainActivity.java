package com.ea.ironmonkey.devmenu;

import static com.ea.ironmonkey.devmenu.util.UtilitiesAndData.copy;
import static com.ea.ironmonkey.devmenu.util.UtilitiesAndData.generateMD5;
import static com.ea.ironmonkey.devmenu.util.UtilitiesAndData.getDevMenuSwitcher;
import static com.ea.ironmonkey.devmenu.util.UtilitiesAndData.isFirstRun;
import static com.ea.ironmonkey.devmenu.util.UtilitiesAndData.putObjectToSharedPrefs;

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
import com.ea.ironmonkey.devmenu.components.LongPressContextMenu;
import com.ea.ironmonkey.devmenu.components.ResultHandler;
import com.ea.ironmonkey.devmenu.util.UtilitiesAndData;
import com.ea.nimble.Utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

//TODO сделать нормальный файл сохранения
//TODO сделать его нрмальное отображние

//TODO сделать нормальное отслеживние файлов сохранений
//TODO сдлеать настройки отслеживания файла
//TODO добавить иконки к проводику

public class MainActivity extends Activity{

    private final String LOG_TAG = "InjectedActivity";

    private String internalFiles;
    private String externalFiles;
    private static Thread observerThread;
    private String globalPath = "";
    private ListView fileList;
    private String currentPathFormat;
    private TextView currentPath;
    private Button backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UtilitiesAndData.init(this);
        internalFiles = UtilitiesAndData.getInternalStorage();
        externalFiles = UtilitiesAndData.getExternalStorage();

        if (isFirstRun()) {

            //Если это первый запуск то Задаем значения по умолчанию
            putObjectToSharedPrefs(R.string.path_to_svmw_folder, externalFiles + File.separator + "svmw");
            putObjectToSharedPrefs(R.string.path_changed_saves, externalFiles + File.separator + "saves");
            putObjectToSharedPrefs(R.string.enable_tracking, false);
            putObjectToSharedPrefs(R.string.tracking_rate_ms, 1000);

            File replacements = new File(UtilitiesAndData.getReplacementsStorage());
            replacements.mkdir();

            Log.i(LOG_TAG, "this is first run after install!");
        }else
            Log.i(LOG_TAG, "this is not first run after install!");

        File activityFlag = getDevMenuSwitcher();

        if(!activityFlag.exists()){
            updateLanguage();
            runGame();
            return;
        }

        setContentView(R.layout.custom);


        String title = String.format(getString(R.string.dev_menu_title), BuildConfig.DEV_MENU_VERSION);

        getActionBar().setTitle(title);

        fileList = (ListView) findViewById(R.id.FileList);
        currentPath = (TextView) findViewById(R.id.current_path);
        currentPathFormat = getString(R.string.title_current_path_format);

        globalPath = externalFiles;
        updateListView();

        RadioGroup group = (RadioGroup) findViewById(R.id.switcherFiles);

        fileList.setOnItemClickListener((parent, view, position, id) -> {
            String chosenElem =
                    (view instanceof TwoLineListItem) ?
                            ((TwoLineListItem) view).getText1().getText().toString() :
                            ((TextView) view).getText().toString(); // получаем текст нажатого элемента

            File intermid =  new File(globalPath + "/" + chosenElem);
            if(intermid.isDirectory()) {
                globalPath += "/" + chosenElem;
                updateListView();
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


            LongPressContextMenu ninja = new LongPressContextMenu(this, globalPath + "/" + chosenElem);
            return true;
        });

        group.setOnCheckedChangeListener((group1, checkedId) -> {
            globalPath = (checkedId == R.id.externalStoreButton) ? externalFiles : internalFiles;
            updateListView();
        });

        backButton = (Button)findViewById(R.id.back_button);

        backButton.setOnClickListener(v -> {
            if(!( globalPath.equals(internalFiles) | globalPath.equals(externalFiles) )
                    & !globalPath.isEmpty()
                    & (new File(globalPath).exists())) {
                globalPath = globalPath.substring(0, globalPath.lastIndexOf("/"));
                updateListView();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateListView();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        updateListView();
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        ResultHandler handler = new ResultHandler(this);
        handler.onIncomingIntent(data);
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

                Intent GoToSettings = new Intent(this, SettingsActivity.class);
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

            }break;
            case R.id.optionCheckRecovers:{

                Intent GoToRecovers = new Intent(this, RecoverListActivity.class);
                startActivity(GoToRecovers);

            }break;

        }

        return super.onOptionsItemSelected(item);
    }

    public void openFile(File url) {
        File tempFile;
        Intent intent = new Intent(Intent.ACTION_VIEW);

        if(url.getAbsolutePath().contains(UtilitiesAndData.getInternalStorage())){
            Log.wtf(LOG_TAG, "WTF, man, you cant read my files!!!");

            //Создаем временный файл, там где можем его прочитать
            Random random = new Random();
            tempFile = new File(UtilitiesAndData.getExternalStorage() + File.separator + "temp_" + random.nextInt());

            //Копируем тот файл который хотим посмотреть
            copy(url.getAbsolutePath(), tempFile.getAbsolutePath());

            //Сохраняем ссылку на окрытый файл, в случае его изменения
            final File openedFile = url;
            File finalTempFile = tempFile;
            url = tempFile;
            //Создаем хеш файла для того чтобы его потом сравнить
            final byte[] compTemp = generateMD5(finalTempFile);

            ResultHandler.addResultHandler(intent, (resultListener) -> {
                byte[] bytes = generateMD5(finalTempFile);
                //Если хеши не одинаковы то заменяем одно на другое
                if(!Arrays.equals(bytes, compTemp))
                    copy(finalTempFile.getAbsolutePath(), openedFile.getAbsolutePath());
                finalTempFile.delete();
            });

            //Самое главное тут - не возвращать null так как если везде будет null
            //ResultHandler подумает что это ошибка и крашнет приложуху((
            //                                            |
            //                                           \|/
            //                                      вот тут вота
        }else ResultHandler.addResultHandler(intent, (i) -> {});

        Uri uri = Uri.fromFile(url);

        if (url.toString().contains(".doc") || url.toString().contains(".docx"))
            intent.setDataAndType(uri, "application/msword");
        else if(url.toString().contains(".pdf")) {
            intent.setDataAndType(uri, "application/pdf");
        } else if(url.toString().contains(".ppt") || url.toString().contains(".pptx")) {
            intent.setDataAndType(uri, "application/vnd.ms-powerpoint");
        } else if(url.toString().contains(".xls") || url.toString().contains(".xlsx")) {
            intent.setDataAndType(uri, "application/vnd.ms-excel");
        } else if(url.toString().contains(".zip") || url.toString().contains(".rar")) {
            intent.setDataAndType(uri, "application/x-wav");
        } else if(url.toString().contains(".rtf")) {
            intent.setDataAndType(uri, "application/rtf");
        } else if(url.toString().contains(".wav") || url.toString().contains(".mp3")) {
            intent.setDataAndType(uri, "audio/x-wav");
        } else if(url.toString().contains(".gif")) {
            intent.setDataAndType(uri, "image/gif");
        } else if(url.toString().contains(".jpg") || url.toString().contains(".jpeg") || url.toString().contains(".png")) {
            intent.setDataAndType(uri, "image/jpeg");
        } else if(url.toString().contains(".txt")) {
            intent.setDataAndType(uri, "text/plain");
        } else if(url.toString().contains(".3gp") || url.toString().contains(".mpg") || url.toString().contains(".mpeg") || url.toString().contains(".mpe") || url.toString().contains(".mp4") || url.toString().contains(".avi")) {
            intent.setDataAndType(uri, "video/*");
        } else {
            intent.setDataAndType(uri, "*/*");
        }

        startActivityForResult(intent, ResultHandler.RESULT_HANDLER_ACTION_VIEW_REQUEST_CODE);

    }

    private void runGame() {

        Intent GoToGame = new Intent(this, GameActivity.class);
        startActivity(GoToGame);

    }

    // TODO Сделать номальную систему учета измения файлов
    public static void observ(){
        File save = new File(UtilitiesAndData.getInternalStorage() + File.separator + "files/var/nfstr_save.sb");
        File fileOut = new File(UtilitiesAndData.getExternalStorage() + File.separator + "Log.txt");
        File pathToSave = new File(UtilitiesAndData.getExternalStorage() + File.separator + "saves");
        pathToSave.mkdir();
        if(!fileOut.exists()) {
            try {
                fileOut.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss", Locale.getDefault());
        UtilitiesAndData.setLogger(fileOut);
        observerThread = new Thread(() -> {
            int count = 1;
            byte[] lastMD5 = new byte[10];
            while (true){
                byte[] md5 = generateMD5(save);
                if(!Arrays.equals(md5, lastMD5)) {
                    UtilitiesAndData.printLog(format.format(new Date()) + " | " + Utility.bytesToHexString(md5) + "\n");
                    File change = new File(pathToSave.getAbsolutePath() + File.separator + "nfs_save_change_"+ count +".sb");
                    try {
                        change.createNewFile();
                        copy(save, change);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                lastMD5 = md5;
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                count++;
            }
        });
        observerThread.start();
    }

    private <T> List<T> asList(T[] a){
        return Arrays.asList(a);
    }

    // TODO реализовать сокрытие лишних папок
    private List<File> asList(String path){
        return asList(new File(path).listFiles());
    }

    private void updateLanguage(){
        //Получаем текущий язык
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String current_lang = preferences.getString(getString(R.string.current_lang), "sys");
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

    /**
     * Метод обновления списка файлов во внутреннем проводнике
     * и текстовой метки текущего положения
     */
    public void updateListView(){
        fileList.setAdapter(new FileAdapter(getApplicationContext(), asList(globalPath)));
        String result = (globalPath.contains(externalFiles))
                ?
                globalPath.replace(externalFiles, "/")
                :
                globalPath.replace(internalFiles, "/");
        result = result.replace("//", "/");
        currentPath.setText(String.format(currentPathFormat, result));
    }

}