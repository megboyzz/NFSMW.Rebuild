package com.ea.ironmonkey.devmenu.components;

import android.text.Html;
import android.text.Spanned;

public class HyperLinkText {

    public static class Container{
        private String link;
        private String name;

        public Container(String link, String name) {
            this.link = link;
            this.name = name;
        }

        @Override
        public String toString() {
            return "<a href=\"" + link + "\">"+name+"</a>";
        }
    }
    private String result;

    public HyperLinkText(String text, Container... containers) {
        result = String.format(text, containers);
    }

    public Spanned getSpanned(){
        return Html.fromHtml(result);
    }
}
