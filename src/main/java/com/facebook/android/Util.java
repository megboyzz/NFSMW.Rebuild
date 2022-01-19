/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.os.Bundle
 *  android.webkit.CookieManager
 *  android.webkit.CookieSyncManager
 *  com.ea.easp.Debug$Log
 *  org.json.JSONException
 *  org.json.JSONObject
 */
package com.facebook.android;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.ea.easp.Debug;
import com.facebook.android.FacebookError;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class Util {
    public static void clearCookies(Context context) {
        CookieSyncManager.createInstance((Context)context);
        CookieManager.getInstance().removeAllCookie();
    }

    public static Bundle decodeUrl(String stringArray) {
        Bundle bundle = new Bundle();
        if (stringArray == null) return bundle;
        stringArray = stringArray.split("&");
        int n2 = stringArray.length;
        int n3 = 0;
        while (n3 < n2) {
            String[] stringArray2 = stringArray[n3].split("=");
            if (stringArray2.length == 2) {
                bundle.putString(URLDecoder.decode(stringArray2[0]), URLDecoder.decode(stringArray2[1]));
            }
            ++n3;
        }
        return bundle;
    }

    public static String encodePostBody(Bundle bundle, String string) {
        if (bundle == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        Iterator iterator = bundle.keySet().iterator();
        while (iterator.hasNext()) {
            String string2 = (String)iterator.next();
            Object object = bundle.get(string2);
            if (!(object instanceof String)) continue;
            stringBuilder.append("Content-Disposition: form-data; name=\"" + string2 + "\"\r\n\r\n" + (String)object);
            stringBuilder.append("\r\n--" + string + "\r\n");
        }
        return stringBuilder.toString();
    }

    public static String encodeUrl(Bundle bundle) {
        if (bundle == null) {
            return "";
        }
        StringBuilder stringBuilder = new StringBuilder();
        boolean bl2 = true;
        Iterator iterator = bundle.keySet().iterator();
        while (iterator.hasNext()) {
            String string = (String)iterator.next();
            if (!(bundle.get(string) instanceof String)) continue;
            if (bl2) {
                bl2 = false;
            } else {
                stringBuilder.append("&");
            }
            stringBuilder.append(URLEncoder.encode(string) + "=" + URLEncoder.encode(bundle.getString(string)));
        }
        return stringBuilder.toString();
    }

    public static String openUrl(String object, String object2, Bundle object3) throws MalformedURLException, IOException {
        String string = object;
        if (((String)object2).equals("GET")) {
            string = (String)object + "?" + Util.encodeUrl((Bundle)object3);
        }
        Debug.Log.d((String)"Facebook-Util", (String)((String)object2 + " URL: " + string));
        object = (HttpURLConnection)new URL(string).openConnection();
        ((URLConnection)object).setRequestProperty("User-Agent", System.getProperties().getProperty("http.agent") + " FacebookAndroidSDK");
        if (!((String)object2).equals("GET")) {
            string = new Bundle();
            for (String string2 : object3.keySet()) {
                Object object4 = object3.get(string2);
                if (!(object4 instanceof byte[])) continue;
                string.putByteArray(string2, (byte[])object4);
            }
            if (!object3.containsKey("method")) {
                object3.putString("method", (String)object2);
            }
            if (object3.containsKey("access_token")) {
                object3.putString("access_token", URLDecoder.decode(object3.getString("access_token")));
            }
            ((HttpURLConnection)object).setRequestMethod("POST");
            ((URLConnection)object).setRequestProperty("Content-Type", "multipart/form-data;boundary=" + "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f");
            ((URLConnection)object).setDoOutput(true);
            ((URLConnection)object).setDoInput(true);
            ((URLConnection)object).setRequestProperty("Connection", "Keep-Alive");
            ((URLConnection)object).connect();
            object2 = new BufferedOutputStream(((URLConnection)object).getOutputStream());
            ((OutputStream)object2).write(("--" + "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f" + "\r\n").getBytes());
            ((OutputStream)object2).write(Util.encodePostBody((Bundle)object3, "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f").getBytes());
            ((OutputStream)object2).write(("\r\n" + "--" + "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f" + "\r\n").getBytes());
            if (!string.isEmpty()) {
                for (Object object5 : string.keySet()) {
                    ((OutputStream)object2).write(("Content-Disposition: form-data; filename=\"" + (String)object5 + "\"" + "\r\n").getBytes());
                    ((OutputStream)object2).write(("Content-Type: content/unknown" + "\r\n" + "\r\n").getBytes());
                    ((OutputStream)object2).write(string.getByteArray((String)object5));
                    ((OutputStream)object2).write(("\r\n" + "--" + "3i2ndDfv2rTHiSisAbouNdArYfORhtTPEefj3q2f" + "\r\n").getBytes());
                }
            }
            ((OutputStream)object2).flush();
        }
        try {
            return Util.read(((URLConnection)object).getInputStream());
        }
        catch (FileNotFoundException fileNotFoundException) {
            return Util.read(((HttpURLConnection)object).getErrorStream());
        }
    }

    public static JSONObject parseJson(String string) throws JSONException, FacebookError {
        if (string.equals("false")) {
            throw new FacebookError("request failed");
        }
        String string2 = string;
        if (string.equals("true")) {
            string2 = "{value : true}";
        }
        if ((string = new JSONObject(string2)).has("error")) {
            string = string.getJSONObject("error");
            throw new FacebookError(string.getString("message"), string.getString("type"), 0);
        }
        if (string.has("error_code") && string.has("error_msg")) {
            throw new FacebookError(string.getString("error_msg"), "", Integer.parseInt(string.getString("error_code")));
        }
        if (string.has("error_code")) {
            throw new FacebookError("request failed", "", Integer.parseInt(string.getString("error_code")));
        }
        if (string.has("error_msg")) {
            throw new FacebookError(string.getString("error_msg"));
        }
        if (!string.has("error_reason")) return string;
        throw new FacebookError(string.getString("error_reason"));
    }

    public static Bundle parseUrl(String object) {
        object = ((String)object).replace("fbconnect", "http");
        try {
            object = new URL((String)object);
            Bundle bundle = Util.decodeUrl(((URL)object).getQuery());
            bundle.putAll(Util.decodeUrl(((URL)object).getRef()));
            return bundle;
        }
        catch (MalformedURLException malformedURLException) {
            return new Bundle();
        }
    }

    private static String read(InputStream inputStream) throws IOException {
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream), 1000);
        String string = bufferedReader.readLine();
        while (true) {
            if (string == null) {
                inputStream.close();
                return stringBuilder.toString();
            }
            stringBuilder.append(string);
            string = bufferedReader.readLine();
        }
    }

    public static void showAlert(Context context, String string, String string2) {
        context = new AlertDialog.Builder(context);
        context.setTitle((CharSequence)string);
        context.setMessage((CharSequence)string2);
        context.create().show();
    }
}

