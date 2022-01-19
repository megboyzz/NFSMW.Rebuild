/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Intent
 *  android.os.Binder
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 */
package com.google.android.gms.internal;

import android.content.Intent;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface gi
extends IInterface {
    public void a(int var1, Bundle var2, int var3, Intent var4) throws RemoteException;

    public static abstract class com.google.android.gms.internal.gi$a
    extends Binder
    implements gi {
        public com.google.android.gms.internal.gi$a() {
            this.attachInterface(this, "com.google.android.gms.panorama.internal.IPanoramaCallbacks");
        }

        public static gi ao(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.panorama.internal.IPanoramaCallbacks");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof gi)) return new a(iBinder);
            return (gi)iInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int n2, Parcel object, Parcel parcel, int n3) throws RemoteException {
            switch (n2) {
                default: {
                    return super.onTransact(n2, object, parcel, n3);
                }
                case 1598968902: {
                    parcel.writeString("com.google.android.gms.panorama.internal.IPanoramaCallbacks");
                    return true;
                }
                case 1: 
            }
            object.enforceInterface("com.google.android.gms.panorama.internal.IPanoramaCallbacks");
            n2 = object.readInt();
            Bundle bundle = object.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(object) : null;
            n3 = object.readInt();
            object = object.readInt() != 0 ? (Intent)Intent.CREATOR.createFromParcel(object) : null;
            this.a(n2, bundle, n3, (Intent)object);
            parcel.writeNoException();
            return true;
        }

        private static class a
        implements gi {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            /*
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(int n2, Bundle bundle, int n3, Intent intent) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.panorama.internal.IPanoramaCallbacks");
                    parcel.writeInt(n2);
                    if (bundle != null) {
                        parcel.writeInt(1);
                        bundle.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    parcel.writeInt(n3);
                    if (intent != null) {
                        parcel.writeInt(1);
                        intent.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(1, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            public IBinder asBinder() {
                return this.dU;
            }
        }
    }
}

