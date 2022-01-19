/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.net.Uri
 *  android.os.Binder
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 */
package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.gi;

public interface gj
extends IInterface {
    public void a(gi var1, Uri var2, Bundle var3, boolean var4) throws RemoteException;

    public static abstract class com.google.android.gms.internal.gj$a
    extends Binder
    implements gj {
        public static gj ap(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.panorama.internal.IPanoramaService");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof gj)) return new a(iBinder);
            return (gj)iInterface;
        }

        public boolean onTransact(int n2, Parcel parcel, Parcel object, int n3) throws RemoteException {
            switch (n2) {
                default: {
                    return super.onTransact(n2, parcel, object, n3);
                }
                case 1598968902: {
                    object.writeString("com.google.android.gms.panorama.internal.IPanoramaService");
                    return true;
                }
                case 1: 
            }
            parcel.enforceInterface("com.google.android.gms.panorama.internal.IPanoramaService");
            gi gi2 = gi.a.ao(parcel.readStrongBinder());
            object = parcel.readInt() != 0 ? (Uri)Uri.CREATOR.createFromParcel(parcel) : null;
            Bundle bundle = parcel.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(parcel) : null;
            boolean bl2 = parcel.readInt() != 0;
            this.a(gi2, (Uri)object, bundle, bl2);
            return true;
        }

        private static class a
        implements gj {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            /*
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(gi gi2, Uri uri, Bundle bundle, boolean bl2) throws RemoteException {
                IBinder iBinder = null;
                int n2 = 1;
                Parcel parcel = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.panorama.internal.IPanoramaService");
                    if (gi2 != null) {
                        iBinder = gi2.asBinder();
                    }
                    parcel.writeStrongBinder(iBinder);
                    if (uri != null) {
                        parcel.writeInt(1);
                        uri.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    if (bundle != null) {
                        parcel.writeInt(1);
                        bundle.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    if (!bl2) {
                        n2 = 0;
                    }
                    parcel.writeInt(n2);
                    this.dU.transact(1, parcel, null, 1);
                    return;
                }
                finally {
                    parcel.recycle();
                }
            }

            public IBinder asBinder() {
                return this.dU;
            }
        }
    }
}

