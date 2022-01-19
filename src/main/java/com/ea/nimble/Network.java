/*
 * Decompiled with CFR 0.152.
 */
package com.ea.nimble;

import com.ea.nimble.Base;
import com.ea.nimble.INetwork;
import com.ea.nimble.Log;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.Iterator;
import java.util.Map;

public class Network {
    public static final String COMPONENT_ID = "com.ea.nimble.network";

    public static String generateParameterString(Map<String, String> object) {
        if (object == null) {
            return null;
        }
        if (object.size() == 0) return null;
        String string2 = "";
        Iterator<Map.Entry<String, String>> iterator = object.entrySet().iterator();
        object = string2;
        while (true) {
            String string3;
            Object object2;
            block8: {
                if (!iterator.hasNext()) {
                    if (((String)object).length() == 0) return null;
                    return ((String)object).substring(0, ((String)object).length() - 1);
                }
                object2 = iterator.next();
                string2 = object2.getKey();
                object2 = object2.getValue();
                if ("".equals(string2)) {
                    Log.Helper.LOGWS("Network", "URL parameters map contains invalid key", new Object[0]);
                    continue;
                }
                try {
                    string3 = URLEncoder.encode(string2, "UTF-8");
                    if (!"".equals(object2)) break block8;
                }
                catch (UnsupportedEncodingException unsupportedEncodingException) {
                    Log.Helper.LOGWS("Network", "URL parameters map contains invalid key", new Object[0]);
                    continue;
                }
                Log.Helper.LOGWS("Network", "URL parameters map contains invalid value", new Object[0]);
                continue;
            }
            try {
                string2 = URLEncoder.encode((String)object2, "UTF-8");
                object = (String)object + string3;
                object = (String)object + "=";
                object = (String)object + string2;
                object = (String)object + "&";
            }
            catch (UnsupportedEncodingException unsupportedEncodingException) {
                Log.Helper.LOGWS("Network", "URL parameters map contains invalid value", new Object[0]);
                continue;
            }
            break;
        }
    }

    public static URL generateURL(String string2, Map<String, String> object) {
        if ("".equals(string2)) {
            Log.Helper.LOGWS("Network", "Base url is blank, return null", new Object[0]);
            return null;
        }
        if ((object = Network.generateParameterString(object)) == null) {
            Log.Helper.LOGWS("Network", "Generated URL with only base url = %s", string2);
        } else {
            string2 = string2 + "?" + (String)object;
            Log.Helper.LOGVS("Network", "Generated URL = %s", string2);
        }
        try {
            return new URL(string2);
        }
        catch (MalformedURLException malformedURLException) {
            Log.Helper.LOGFS("Network", "Malformed URL from %s", string2);
            return null;
        }
    }

    public static INetwork getComponent() {
        return (INetwork)((Object)Base.getComponent(COMPONENT_ID));
    }

    public static enum Status {
        UNKNOWN,
        NONE,
        DEAD,
        OK;


        public String toString() {
            switch (1.$SwitchMap$com$ea$nimble$Network$Status[this.ordinal()]) {
                default: {
                    return "NET UNKNOWN";
                }
                case 1: {
                    return "NET NONE";
                }
                case 2: {
                    return "NET DEAD";
                }
                case 3: 
            }
            return "NET OK";
        }
    }
}

