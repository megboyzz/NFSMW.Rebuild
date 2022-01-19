/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.os.Bundle
 */
package com.facebook.android;

import android.content.Context;
import android.os.Bundle;
import com.facebook.android.Facebook;
import com.facebook.android.FacebookError;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;

public class AsyncFacebookRunner {
    Facebook fb;

    public AsyncFacebookRunner(Facebook facebook) {
        this.fb = facebook;
    }

    public void logout(Context context, RequestListener requestListener) {
        this.logout(context, requestListener, null);
    }

    public void logout(final Context context, final RequestListener requestListener, final Object object) {
        new Thread(){

            @Override
            public void run() {
                try {
                    String string = AsyncFacebookRunner.this.fb.logout(context);
                    if (string.length() != 0 && !string.equals("false")) {
                        requestListener.onComplete(string, object);
                        return;
                    }
                    requestListener.onFacebookError(new FacebookError("auth.expireSession failed"), object);
                    return;
                }
                catch (FileNotFoundException fileNotFoundException) {
                    requestListener.onFileNotFoundException(fileNotFoundException, object);
                    return;
                }
                catch (MalformedURLException malformedURLException) {
                    requestListener.onMalformedURLException(malformedURLException, object);
                    return;
                }
                catch (IOException iOException) {
                    requestListener.onIOException(iOException, object);
                    return;
                }
            }
        }.start();
    }

    public void request(Bundle bundle, RequestListener requestListener) {
        this.request(null, bundle, "GET", requestListener, null);
    }

    public void request(Bundle bundle, RequestListener requestListener, Object object) {
        this.request(null, bundle, "GET", requestListener, object);
    }

    public void request(String string, Bundle bundle, RequestListener requestListener) {
        this.request(string, bundle, "GET", requestListener, null);
    }

    public void request(String string, Bundle bundle, RequestListener requestListener, Object object) {
        this.request(string, bundle, "GET", requestListener, object);
    }

    public void request(final String string, final Bundle bundle, final String string2, final RequestListener requestListener, final Object object) {
        new Thread(){

            @Override
            public void run() {
                try {
                    String string3 = AsyncFacebookRunner.this.fb.request(string, bundle, string2);
                    requestListener.onComplete(string3, object);
                    return;
                }
                catch (FileNotFoundException fileNotFoundException) {
                    requestListener.onFileNotFoundException(fileNotFoundException, object);
                    return;
                }
                catch (MalformedURLException malformedURLException) {
                    requestListener.onMalformedURLException(malformedURLException, object);
                    return;
                }
                catch (IOException iOException) {
                    requestListener.onIOException(iOException, object);
                    return;
                }
            }
        }.start();
    }

    public void request(String string, RequestListener requestListener) {
        this.request(string, new Bundle(), "GET", requestListener, null);
    }

    public void request(String string, RequestListener requestListener, Object object) {
        this.request(string, new Bundle(), "GET", requestListener, object);
    }

    public static interface RequestListener {
        public void onComplete(String var1, Object var2);

        public void onFacebookError(FacebookError var1, Object var2);

        public void onFileNotFoundException(FileNotFoundException var1, Object var2);

        public void onIOException(IOException var1, Object var2);

        public void onMalformedURLException(MalformedURLException var1, Object var2);
    }
}

