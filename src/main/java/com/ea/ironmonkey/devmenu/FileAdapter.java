package com.ea.ironmonkey.devmenu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.io.File;
import java.util.List;

class FileAdapter extends ArrayAdapter<File> {

    private List files;

    public FileAdapter(Context context, List files) {

        super(context, android.R.layout.simple_list_item_1, files);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView view = (TextView) super.getView(position, convertView, parent);
        File file = getItem(position);
        view.setText(file.getName());

        /*
        if (selectedIndex == position)
            view.setBackgroundColor(getContext().getResources().getColor(android.R.color.holo_blue_light));
        else
            view.setBackgroundColor(getContext().getResources().getColor(android.R.color.background_dark));*/
        return view;
    }

    public List getFiles() {
        return files;
    }
}
