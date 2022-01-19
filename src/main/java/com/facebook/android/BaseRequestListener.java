/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.ea.easp.Debug$Log
 */
package com.facebook.android;

import com.ea.easp.Debug;
import com.facebook.android.AsyncFacebookRunner;
import com.facebook.android.FacebookError;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

public abstract class BaseRequestListener
implements AsyncFacebookRunner.RequestListener {
    @Override
    public void onFacebookError(FacebookError facebookError, Object object) {
        Debug.Log.e((String)"Facebook", (String)facebookError.getMessage());
        facebookError.printStackTrace();
    }

    @Override
    public void onFileNotFoundException(FileNotFoundException fileNotFoundException, Object object) {
        Debug.Log.e((String)"Facebook", (String)fileNotFoundException.getMessage());
        fileNotFoundException.printStackTrace();
    }

    @Override
    public void onIOException(IOException iOException, Object object) {
        Debug.Log.e((String)"Facebook", (String)iOException.getMessage());
        iOException.printStackTrace();
    }

    @Override
    public void onMalformedURLException(MalformedURLException malformedURLException, Object object) {
        Debug.Log.e((String)"Facebook", (String)malformedURLException.getMessage());
        malformedURLException.printStackTrace();
    }
}

