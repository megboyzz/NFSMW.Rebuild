package com.ea.ironmonkey.devmenu;

import android.app.Activity;
import android.app.AlertDialog;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.ea.games.nfs13_na.R;
import com.ea.ironmonkey.Log;
import com.ea.ironmonkey.devmenu.util.ReplacementDataBaseHelper;
import com.ea.ironmonkey.devmenu.util.UtilitiesAndData;

import java.util.ArrayList;

public class RecoverListActivity extends Activity {

    ArrayList<String> fullNames;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("lol", "onCreate()");

        boolean flag = true;

        getActionBar().setTitle(R.string.recover_file_title);

        ListView view = new ListView(this);

        View result = view;

        SQLiteDatabase database = new ReplacementDataBaseHelper(this).getDatabase();

        Cursor cursor = database.rawQuery("SELECT " + ReplacementDataBaseHelper.PATH_TO_REPLACED_ELEMENT + " FROM " + ReplacementDataBaseHelper.MAIN_TABLE_NAME, null);

        fullNames = new ArrayList<>();
        ArrayList<String> shortNames = new ArrayList<>();

        while (cursor.moveToNext()) {
            String string = cursor.getString(0);
            fullNames.add(string);
            int from = string.lastIndexOf("/files/");
            shortNames.add(string.substring(from));
        }
        if(fullNames.isEmpty()){
            shortNames.add("Нечего заменять!!");
            result = getEmptyScreen();
            flag = false;
        }
        boolean thereIsSmthToRecover = flag;

        ArrayAdapter<String> adapter;

        view.setOnItemClickListener((parent, view1, position, id) -> {
            if(thereIsSmthToRecover){

                TextView textView = (TextView) view1;
                String s = textView.getText().toString();

                AlertDialog.Builder dialog = new AlertDialog.Builder(this);

                //TODO сделать нормальные строки
                dialog.setTitle("Воостановить?");

                dialog.setPositiveButton(R.string.ok_title, (dialog1, which) -> {
                    shortNames.remove(s);
                    view.setAdapter(new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, shortNames));
                    String fullName = fullNames.get(position);
                    fullNames.remove(fullName);
                    UtilitiesAndData.recoverFile(fullName);
                    //System.out.println();
                    //TODO Сделать воостановление
                });

                dialog.setNegativeButton(R.string.cancel_title, (dialog1, which) -> {

                });

                dialog.show();
            }
        });

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, shortNames);

        view.setAdapter(adapter);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        setContentView(result);
        cursor.close();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if(!fullNames.isEmpty())
            getMenuInflater().inflate(R.menu.recover_options, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case R.id.recover_all:{
                AlertDialog.Builder dialog = new AlertDialog.Builder(this);
                dialog.setTitle(R.string.recover_file_title);
                dialog.setMessage(getString(R.string.title_recover_all_files) + "?");
                dialog.setPositiveButton(R.string.ok_title, (c,v) -> {
                    if(fullNames.isEmpty()) throw new RuntimeException("FullNames is Empty! Crash!");
                    for(String path : fullNames)
                        UtilitiesAndData.recoverFile(path);
                    setContentView(getEmptyScreen());
                });
                dialog.setNegativeButton(R.string.cancel_title, null);
                dialog.show();
            }break;
            case android.R.id.home:{
                onBackPressed();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    private View getEmptyScreen(){

        View emptyScreen = LayoutInflater
                .from(this)
                .inflate(R.layout.empty, null, false);
        TextView text = (TextView) emptyScreen.findViewById(R.id.msg);
        text.setText(R.string.title_no_one_to_recover);
        return emptyScreen;
    }
}
