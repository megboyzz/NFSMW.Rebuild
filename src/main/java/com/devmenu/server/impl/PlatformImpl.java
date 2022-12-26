package com.devmenu.server.impl;

import android.content.Context;
import ru.megboyzz.api.PlatformAPI;

public class PlatformImpl implements PlatformAPI {
    private Context context;

    public PlatformImpl(Context context) {
        this.context = context;
    }

    @Override
    public String getNextLogLine() {
        return null;
    }

    @Override
    public void shutdown() {}
}
