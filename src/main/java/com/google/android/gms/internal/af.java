/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.location.Location
 */
package com.google.android.gms.internal;

import android.content.Context;
import android.location.Location;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.internal.cr;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class af {
    public static final String DEVICE_ID_EMULATOR = cr.q("emulator");
    private final Date d;
    private final int eL;
    private final Location eM;
    private final boolean eN;
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> eO;
    private final String eP;
    private final SearchAdRequest eQ;
    private final int eR;
    private final Set<String> eS;
    private final Set<String> f;

    public af(a a2) {
        this(a2, null);
    }

    public af(a a2, SearchAdRequest searchAdRequest) {
        this.d = a2.d;
        this.eL = a2.eL;
        this.f = Collections.unmodifiableSet(a2.eT);
        this.eM = a2.eM;
        this.eN = a2.eN;
        this.eO = Collections.unmodifiableMap(a2.eU);
        this.eP = a2.eP;
        this.eQ = searchAdRequest;
        this.eR = a2.eR;
        this.eS = Collections.unmodifiableSet(a2.eV);
    }

    public SearchAdRequest Q() {
        return this.eQ;
    }

    public Map<Class<? extends NetworkExtras>, NetworkExtras> R() {
        return this.eO;
    }

    public int S() {
        return this.eR;
    }

    public Date getBirthday() {
        return this.d;
    }

    public int getGender() {
        return this.eL;
    }

    public Set<String> getKeywords() {
        return this.f;
    }

    public Location getLocation() {
        return this.eM;
    }

    public boolean getManualImpressionsEnabled() {
        return this.eN;
    }

    public <T extends NetworkExtras> T getNetworkExtras(Class<T> clazz) {
        return (T)this.eO.get(clazz);
    }

    public String getPublisherProvidedId() {
        return this.eP;
    }

    public boolean isTestDevice(Context context) {
        return this.eS.contains(cr.l(context));
    }

    public static final class a {
        private Date d;
        private int eL = -1;
        private Location eM;
        private boolean eN = false;
        private String eP;
        private int eR = -1;
        private final HashSet<String> eT = new HashSet();
        private final HashMap<Class<? extends NetworkExtras>, NetworkExtras> eU = new HashMap();
        private final HashSet<String> eV = new HashSet();

        public void a(Location location) {
            this.eM = location;
        }

        public void a(NetworkExtras networkExtras) {
            this.eU.put(networkExtras.getClass(), networkExtras);
        }

        public void a(Date date) {
            this.d = date;
        }

        public void d(int n2) {
            this.eL = n2;
        }

        public void d(boolean bl2) {
            this.eN = bl2;
        }

        public void e(boolean bl2) {
            int n2 = bl2 ? 1 : 0;
            this.eR = n2;
        }

        public void g(String string2) {
            this.eT.add(string2);
        }

        public void h(String string2) {
            this.eV.add(string2);
        }

        public void i(String string2) {
            this.eP = string2;
        }
    }
}

