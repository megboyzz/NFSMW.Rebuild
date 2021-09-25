package com.ea.ironmonkey.devmenu;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilesList extends ListView {

    private ArrayList<File> files = new ArrayList<>();
    //private String currentPath = Environment.get
    private int selectedIndex = -1;

    public FilesList(Context context) {
        super(context);

        setAdapter(new FileAdapter(context, files));
    }

    private <T> List<T> asList(T[] a){
        return Arrays.asList(a);
    }

    class FileAdapter extends ArrayAdapter<File> {

        public FileAdapter(Context context, List files) {
            super(context, android.R.layout.activity_list_item, files);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView view = (TextView) super.getView(position, convertView, parent);
            File file = getItem(position);
            view.setText(file.getName());
            if (selectedIndex == position)
                view.setBackgroundColor(getContext().getResources().getColor(android.R.color.holo_blue_light));
            else
                view.setBackgroundColor(getContext().getResources().getColor(android.R.color.background_dark));
            return view;
        }
    }

}
