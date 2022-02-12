package com.ea.ironmonkey.devmenu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.TwoLineListItem;

import java.io.File;
import java.util.List;

class FileAdapter extends ArrayAdapter<File> {

    private static int count = 0;
    private List files;
    private Context context;

    public FileAdapter(Context context, List files) {

        super(context, android.R.layout.simple_list_item_2, files);
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService( Context.LAYOUT_INFLATER_SERVICE );
        String name = getItem(position).getName();

        if(name.endsWith("_")){
            TwoLineListItem listItem = (TwoLineListItem) inflater.inflate(android.R.layout.simple_list_item_2, null, true);
            listItem.getText1().setText(name.substring(0, name.length()));
            listItem.getText2().setText("Скрыт");
            view = listItem;
        }else{
            TextView textView = (TextView) inflater.inflate(android.R.layout.simple_list_item_1, null, true);
            textView.setText(name);
            view = textView;
        }
        return view;
    }

    public List getFiles() {
        return files;
    }
}
