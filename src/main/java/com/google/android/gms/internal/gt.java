/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.internal.gs;
import java.util.ArrayList;
import java.util.Arrays;

public class gt {
    private String jD;
    private String[] zI;
    private String zJ;
    private String zK;
    private String zL;
    private ArrayList<String> zN = new ArrayList();
    private String[] zO;

    public gt(Context context) {
        this.zK = context.getPackageName();
        this.zJ = context.getPackageName();
        this.zN.add("https://www.googleapis.com/auth/plus.login");
    }

    public gt ak(String string2) {
        this.jD = string2;
        return this;
    }

    public gt d(String ... stringArray) {
        this.zN.clear();
        this.zN.addAll(Arrays.asList(stringArray));
        return this;
    }

    public gt e(String ... stringArray) {
        this.zO = stringArray;
        return this;
    }

    public gt eD() {
        this.zN.clear();
        return this;
    }

    public gs eE() {
        if (this.jD == null) {
            this.jD = "<<default account>>";
        }
        String[] stringArray = this.zN.toArray(new String[this.zN.size()]);
        return new gs(this.jD, stringArray, this.zO, this.zI, this.zJ, this.zK, this.zL);
    }
}

