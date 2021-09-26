package com.ea.ironmonkey.devmenu;

import android.app.AlertDialog;
import android.content.Context;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.ea.games.nfs13_na.R;

import java.io.File;

public class DataNinja extends AlertDialog.Builder {

    private File data;

    protected DataNinja(final Context context, String path) {
        super(context);
        data = new File(path);
        ListView optionsView = new ListView(context);

        //Порядок следования строк в эом массиве влияет на обработку нажатий на текствью с ними
        final String[] optionsTitles = {
                context.getString(R.string.replace_file_title),
                context.getString(R.string.recover_file_title),
                context.getString(R.string.remove_file_title),
                context.getString(R.string.track_file_title)
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(context, android.R.layout.simple_list_item_1,  optionsTitles);
        optionsView.setAdapter(adapter);

        optionsView.setOnItemClickListener((parent, view, position, id) -> {
            TextView textView = (TextView) view;
            String chosenElem = textView.getText().toString();
            switch (position){
                case 0: {
                    //TO DO
                } break;
                case 1: {
                    //TO DO
                } break;
                case 2: {
                    AlertDialog.Builder dialog = new AlertDialog.Builder(context);
                    dialog.setTitle(optionsTitles[2]);
                    String message = String.format(context.getString(R.string.sure_remove_title), data.getName());
                    dialog.setMessage(message);
                    dialog.setPositiveButton(R.string.ok_title, (dialog1, which) -> {

                    });
                    dialog.setNegativeButton(R.string.cancel_title, null);
                    dialog.show();
                }break;
                case 3:{

                }break;
                default:{
                    Log.i("DataNinja", "No found action to do(");
                }
            }
        });

        setView(optionsView);
        setTitle(data.getName()
                + " - " +
                ((data.isDirectory()) ?
                        context.getString(R.string.folder_title) :
                        context.getString(R.string.file_title)));

        show();

    }



}
