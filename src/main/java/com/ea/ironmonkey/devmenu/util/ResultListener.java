package com.ea.ironmonkey.devmenu.util;

public interface ResultListener {

    void onResult(Object data);

    class EmptyImpl implements ResultListener{
        @Override
        public void onResult(Object data) {}
    }

}
