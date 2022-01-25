/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.graphics.Bitmap
 *  android.os.Binder
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 */
package com.google.android.gms.maps.model.internal;

import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

import com.ea.ironmonkey.devmenu.util.Observer;
import com.google.android.gms.dynamic.b;

public interface a
extends IInterface {
    b a(Bitmap var1) throws RemoteException;

    b aO(int var1) throws RemoteException;

    b ad(String var1) throws RemoteException;

    b ae(String var1) throws RemoteException;

    b af(String var1) throws RemoteException;

    b c(float var1) throws RemoteException;

    b en() throws RemoteException;

    abstract class a$a
    extends Binder
    implements com.google.android.gms.maps.model.internal.a {
        public static com.google.android.gms.maps.model.internal.a ag(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.maps.model.internal.IBitmapDescriptorFactoryDelegate");
            return (com.google.android.gms.maps.model.internal.a)iInterface;
        }

        public boolean onTransact(int n2, Parcel object, Parcel parcel, int n3) throws RemoteException {
            Observer.onCallingMethod(
                    Observer.Method.HARD_TO_RECOVER_LOGIC,
                    Observer.Method.VERY_SUSPICIOUS_METHOD);
            return true;
        }
    }
}

