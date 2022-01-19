/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 */
package com.google.android.gms.internal;

import android.content.Context;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import com.google.android.gms.common.GooglePlayServicesNotAvailableException;
import com.google.android.gms.common.GooglePlayServicesRepairableException;
import com.google.android.gms.internal.f;
import com.google.android.gms.internal.j;
import com.google.android.gms.internal.k;
import com.google.android.gms.internal.m;
import java.io.IOException;

public class g
extends f {
    private g(Context context, j j2, k k2) {
        super(context, j2, k2);
    }

    public static g a(String string2, Context context) {
        com.google.android.gms.internal.a a2 = new com.google.android.gms.internal.a();
        g.a(string2, context, a2);
        return new g(context, a2, new m(239));
    }

    /*
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    @Override
    protected void b(Context object) {
        long l2 = 1L;
        super.b((Context)object);
        object = this.f((Context)object);
        try {
            block6: {
                block5: {
                    if (!((a)object).isLimitAdTrackingEnabled()) break block5;
                    break block6;
                    catch (IOException iOException) {
                        this.a(28, 1L);
                        return;
                    }
                }
                l2 = 0L;
            }
            this.a(28, l2);
            object = ((a)object).getId();
            if (object == null) return;
            this.a(30, (String)object);
            return;
        }
        catch (IOException iOException) {
            return;
        }
        catch (GooglePlayServicesNotAvailableException googlePlayServicesNotAvailableException) {
            // empty catch block
        }
    }

    a f(Context object) throws IOException, GooglePlayServicesNotAvailableException {
        AdvertisingIdClient.Info info;
        int n2 = 0;
        try {
            info = AdvertisingIdClient.getAdvertisingIdInfo((Context)object);
            object = info.getId();
            if (object == null) return new a((String)object, info.isLimitAdTrackingEnabled());
            if (!((String)object).matches("^[a-fA-F0-9]{8}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{4}-[a-fA-F0-9]{12}$")) return new a((String)object, info.isLimitAdTrackingEnabled());
        }
        catch (GooglePlayServicesRepairableException googlePlayServicesRepairableException) {
            throw new IOException(googlePlayServicesRepairableException);
        }
        byte[] byArray = new byte[16];
        int n3 = 0;
        while (true) {
            int n4;
            block8: {
                block7: {
                    if (n2 >= ((String)object).length()) {
                        object = this.dw.a(byArray, true);
                        return new a((String)object, info.isLimitAdTrackingEnabled());
                    }
                    if (n2 == 8 || n2 == 13 || n2 == 18) break block7;
                    n4 = n2;
                    if (n2 != 23) break block8;
                }
                n4 = n2 + 1;
            }
            byArray[n3] = (byte)((Character.digit(((String)object).charAt(n4), 16) << 4) + Character.digit(((String)object).charAt(n4 + 1), 16));
            ++n3;
            n2 = n4 + 2;
        }
    }

    class a {
        private String dH;
        private boolean dI;

        public a(String string2, boolean bl2) {
            this.dH = string2;
            this.dI = bl2;
        }

        public String getId() {
            return this.dH;
        }

        public boolean isLimitAdTrackingEnabled() {
            return this.dI;
        }
    }
}

