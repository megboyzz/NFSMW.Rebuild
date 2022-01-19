/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.text.TextUtils
 *  com.google.android.gms.R$styleable
 */
package com.google.android.gms.internal;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.google.android.gms.R;
import com.google.android.gms.ads.AdSize;

public final class aa {
    private final AdSize[] eJ;
    private final String eK;

    public aa(Context context, AttributeSet object) {
        boolean bl2;
        boolean bl3;
        block6: {
            block5: {
                String string2;
                block4: {
                    bl3 = true;
                    context = context.getResources().obtainAttributes((AttributeSet)object, R.styleable.AdsAttrs);
                    object = context.getString(0);
                    string2 = context.getString(1);
                    bl2 = !TextUtils.isEmpty((CharSequence)object);
                    if (TextUtils.isEmpty((CharSequence)string2)) {
                        bl3 = false;
                    }
                    if (!bl2 || bl3) break block4;
                    this.eJ = aa.f((String)object);
                    break block5;
                }
                if (bl2 || !bl3) break block6;
                this.eJ = aa.f(string2);
            }
            this.eK = context.getString(2);
            if (!TextUtils.isEmpty((CharSequence)this.eK)) return;
            throw new IllegalArgumentException("Required XML attribute \"adUnitId\" was missing.");
        }
        if (!bl2) throw new IllegalArgumentException("Required XML attribute \"adSize\" was missing.");
        if (!bl3) throw new IllegalArgumentException("Required XML attribute \"adSize\" was missing.");
        throw new IllegalArgumentException("Either XML attribute \"adSize\" or XML attribute \"supportedAdSizes\" should be specified, but not both.");
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private static AdSize[] f(String string2) {
        String[] stringArray = string2.split("\\s*,\\s*");
        AdSize[] adSizeArray = new AdSize[stringArray.length];
        int n2 = 0;
        while (true) {
            block17: {
                String string3;
                block16: {
                    int n3;
                    int n4;
                    if (n2 >= stringArray.length) {
                        if (adSizeArray.length != 0) return adSizeArray;
                        throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": " + string2);
                    }
                    string3 = stringArray[n2].trim();
                    if (!string3.matches("^(\\d+|FULL_WIDTH)\\s*[xX]\\s*(\\d+|AUTO_HEIGHT)$")) break block16;
                    String[] stringArray2 = string3.split("[xX]");
                    stringArray2[0] = stringArray2[0].trim();
                    stringArray2[1] = stringArray2[1].trim();
                    try {
                        n4 = "FULL_WIDTH".equals(stringArray2[0]) ? -1 : Integer.parseInt(stringArray2[0]);
                        boolean bl2 = "AUTO_HEIGHT".equals(stringArray2[1]);
                        if (!bl2) {
                            n3 = Integer.parseInt(stringArray2[1]);
                        }
                        n3 = -2;
                    }
                    catch (NumberFormatException numberFormatException) {
                        throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": " + string3);
                    }
                    adSizeArray[n2] = new AdSize(n4, n3);
                    break block17;
                }
                if ("BANNER".equals(string3)) {
                    adSizeArray[n2] = AdSize.BANNER;
                } else if ("FULL_BANNER".equals(string3)) {
                    adSizeArray[n2] = AdSize.FULL_BANNER;
                } else if ("LEADERBOARD".equals(string3)) {
                    adSizeArray[n2] = AdSize.LEADERBOARD;
                } else if ("MEDIUM_RECTANGLE".equals(string3)) {
                    adSizeArray[n2] = AdSize.MEDIUM_RECTANGLE;
                } else if ("SMART_BANNER".equals(string3)) {
                    adSizeArray[n2] = AdSize.SMART_BANNER;
                } else {
                    if (!"WIDE_SKYSCRAPER".equals(string3)) throw new IllegalArgumentException("Could not parse XML attribute \"adSize\": " + string3);
                    adSizeArray[n2] = AdSize.WIDE_SKYSCRAPER;
                }
            }
            ++n2;
        }
    }

    public AdSize[] c(boolean bl2) {
        if (bl2) return this.eJ;
        if (this.eJ.length == 1) return this.eJ;
        throw new IllegalArgumentException("The adSizes XML attribute is only allowed on PublisherAdViews.");
    }

    public String getAdUnitId() {
        return this.eK;
    }
}

