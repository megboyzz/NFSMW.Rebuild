/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.google.android.gms.internal;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class eq {
    private static final Pattern nR = Pattern.compile("\\\\.");
    private static final Pattern nS = Pattern.compile("[\\\\\"/\b\f\n\r\t]");

    public static String O(String string2) {
        if (TextUtils.isEmpty((CharSequence)string2)) return string2;
        Matcher matcher = nS.matcher(string2);
        StringBuffer stringBuffer = null;
        block10: while (matcher.find()) {
            StringBuffer stringBuffer2 = stringBuffer;
            if (stringBuffer == null) {
                stringBuffer2 = new StringBuffer();
            }
            switch (matcher.group().charAt(0)) {
                default: {
                    stringBuffer = stringBuffer2;
                    continue block10;
                }
                case '\b': {
                    matcher.appendReplacement(stringBuffer2, "\\\\b");
                    stringBuffer = stringBuffer2;
                    continue block10;
                }
                case '\"': {
                    matcher.appendReplacement(stringBuffer2, "\\\\\\\"");
                    stringBuffer = stringBuffer2;
                    continue block10;
                }
                case '\\': {
                    matcher.appendReplacement(stringBuffer2, "\\\\\\\\");
                    stringBuffer = stringBuffer2;
                    continue block10;
                }
                case '/': {
                    matcher.appendReplacement(stringBuffer2, "\\\\/");
                    stringBuffer = stringBuffer2;
                    continue block10;
                }
                case '\f': {
                    matcher.appendReplacement(stringBuffer2, "\\\\f");
                    stringBuffer = stringBuffer2;
                    continue block10;
                }
                case '\n': {
                    matcher.appendReplacement(stringBuffer2, "\\\\n");
                    stringBuffer = stringBuffer2;
                    continue block10;
                }
                case '\r': {
                    matcher.appendReplacement(stringBuffer2, "\\\\r");
                    stringBuffer = stringBuffer2;
                    continue block10;
                }
                case '\t': 
            }
            matcher.appendReplacement(stringBuffer2, "\\\\t");
            stringBuffer = stringBuffer2;
        }
        if (stringBuffer == null) {
            return string2;
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }
}

