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
 *  android.os.ParcelFileDescriptor
 *  android.os.Parcelable
 *  android.os.Parcelable$Creator
 *  android.os.RemoteException
 */
package com.google.android.gms.internal;

import android.net.Uri;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.internal.fb;

public interface fc
extends IInterface {
    public String S(String var1) throws RemoteException;

    public String T(String var1) throws RemoteException;

    public void U(String var1) throws RemoteException;

    public int V(String var1) throws RemoteException;

    public Uri W(String var1) throws RemoteException;

    public void X(String var1) throws RemoteException;

    public int a(fb var1, byte[] var2, String var3, String var4) throws RemoteException;

    public void a(long var1, String var3) throws RemoteException;

    public void a(IBinder var1, Bundle var2) throws RemoteException;

    public void a(fb var1) throws RemoteException;

    public void a(fb var1, int var2, int var3, boolean var4, boolean var5) throws RemoteException;

    public void a(fb var1, int var2, int var3, String[] var4, Bundle var5) throws RemoteException;

    public void a(fb var1, int var2, boolean var3, boolean var4) throws RemoteException;

    public void a(fb var1, long var2) throws RemoteException;

    public void a(fb var1, long var2, String var4) throws RemoteException;

    public void a(fb var1, Bundle var2, int var3, int var4) throws RemoteException;

    public void a(fb var1, IBinder var2, int var3, String[] var4, Bundle var5, boolean var6, long var7) throws RemoteException;

    public void a(fb var1, IBinder var2, String var3, boolean var4, long var5) throws RemoteException;

    public void a(fb var1, String var2) throws RemoteException;

    public void a(fb var1, String var2, int var3, int var4, int var5, boolean var6) throws RemoteException;

    public void a(fb var1, String var2, int var3, IBinder var4, Bundle var5) throws RemoteException;

    public void a(fb var1, String var2, int var3, boolean var4) throws RemoteException;

    public void a(fb var1, String var2, int var3, boolean var4, boolean var5) throws RemoteException;

    public void a(fb var1, String var2, int var3, boolean var4, boolean var5, boolean var6, boolean var7) throws RemoteException;

    public void a(fb var1, String var2, long var3) throws RemoteException;

    public void a(fb var1, String var2, long var3, String var5) throws RemoteException;

    public void a(fb var1, String var2, IBinder var3, Bundle var4) throws RemoteException;

    public void a(fb var1, String var2, String var3) throws RemoteException;

    public void a(fb var1, String var2, String var3, int var4, int var5) throws RemoteException;

    public void a(fb var1, String var2, String var3, int var4, int var5, int var6, boolean var7) throws RemoteException;

    public void a(fb var1, String var2, String var3, boolean var4) throws RemoteException;

    public void a(fb var1, String var2, boolean var3) throws RemoteException;

    public void a(fb var1, String var2, boolean var3, long[] var4) throws RemoteException;

    public void a(fb var1, String var2, byte[] var3, String var4, ParticipantResult[] var5) throws RemoteException;

    public void a(fb var1, String var2, byte[] var3, ParticipantResult[] var4) throws RemoteException;

    public void a(fb var1, String var2, int[] var3) throws RemoteException;

    public void a(fb var1, boolean var2) throws RemoteException;

    public void a(fb var1, int[] var2) throws RemoteException;

    public void a(String var1, String var2, int var3) throws RemoteException;

    public int b(byte[] var1, String var2, String[] var3) throws RemoteException;

    public void b(long var1, String var3) throws RemoteException;

    public void b(fb var1) throws RemoteException;

    public void b(fb var1, int var2, boolean var3, boolean var4) throws RemoteException;

    public void b(fb var1, long var2) throws RemoteException;

    public void b(fb var1, long var2, String var4) throws RemoteException;

    public void b(fb var1, String var2) throws RemoteException;

    public void b(fb var1, String var2, int var3, int var4, int var5, boolean var6) throws RemoteException;

    public void b(fb var1, String var2, int var3, IBinder var4, Bundle var5) throws RemoteException;

    public void b(fb var1, String var2, int var3, boolean var4, boolean var5) throws RemoteException;

    public void b(fb var1, String var2, IBinder var3, Bundle var4) throws RemoteException;

    public void b(fb var1, String var2, String var3) throws RemoteException;

    public void b(fb var1, String var2, String var3, int var4, int var5, int var6, boolean var7) throws RemoteException;

    public void b(fb var1, String var2, String var3, boolean var4) throws RemoteException;

    public void b(fb var1, String var2, boolean var3) throws RemoteException;

    public void b(fb var1, boolean var2) throws RemoteException;

    public void b(String var1, String var2, int var3) throws RemoteException;

    public Bundle bc() throws RemoteException;

    public void c(fb var1) throws RemoteException;

    public void c(fb var1, int var2, boolean var3, boolean var4) throws RemoteException;

    public void c(fb var1, String var2) throws RemoteException;

    public void c(fb var1, String var2, String var3) throws RemoteException;

    public void c(fb var1, String var2, boolean var3) throws RemoteException;

    public void c(fb var1, boolean var2) throws RemoteException;

    public void c(String var1, String var2) throws RemoteException;

    public void cN() throws RemoteException;

    public DataHolder cV() throws RemoteException;

    public boolean cW() throws RemoteException;

    public DataHolder cX() throws RemoteException;

    public void cY() throws RemoteException;

    public void clearNotifications(int var1) throws RemoteException;

    public void d(fb var1) throws RemoteException;

    public void d(fb var1, int var2, boolean var3, boolean var4) throws RemoteException;

    public void d(fb var1, String var2) throws RemoteException;

    public void d(fb var1, String var2, String var3) throws RemoteException;

    public void d(fb var1, String var2, boolean var3) throws RemoteException;

    public void d(fb var1, boolean var2) throws RemoteException;

    public void d(String var1, String var2) throws RemoteException;

    public ParcelFileDescriptor e(Uri var1) throws RemoteException;

    public void e(fb var1) throws RemoteException;

    public void e(fb var1, int var2, boolean var3, boolean var4) throws RemoteException;

    public void e(fb var1, String var2) throws RemoteException;

    public void e(fb var1, String var2, String var3) throws RemoteException;

    public void f(long var1) throws RemoteException;

    public void f(fb var1) throws RemoteException;

    public void f(fb var1, String var2) throws RemoteException;

    public void f(fb var1, String var2, String var3) throws RemoteException;

    public void g(long var1) throws RemoteException;

    public void g(fb var1) throws RemoteException;

    public void g(fb var1, String var2) throws RemoteException;

    public String getAppId() throws RemoteException;

    public String getCurrentAccountName() throws RemoteException;

    public String getCurrentPlayerId() throws RemoteException;

    public int getMaxTurnBasedMatchDataSize() throws RemoteException;

    public void h(long var1) throws RemoteException;

    public void h(fb var1) throws RemoteException;

    public void h(fb var1, String var2) throws RemoteException;

    public void h(String var1, int var2) throws RemoteException;

    public void i(fb var1) throws RemoteException;

    public void i(fb var1, String var2) throws RemoteException;

    public void i(String var1, int var2) throws RemoteException;

    public int j(fb var1, String var2) throws RemoteException;

    public void j(String var1, int var2) throws RemoteException;

    public void k(fb var1, String var2) throws RemoteException;

    public void l(fb var1, String var2) throws RemoteException;

    public void m(fb var1, String var2) throws RemoteException;

    public void n(fb var1, String var2) throws RemoteException;

    public void o(fb var1, String var2) throws RemoteException;

    public void p(fb var1, String var2) throws RemoteException;

    public void q(fb var1, String var2) throws RemoteException;

    public void q(boolean var1) throws RemoteException;

    public void r(fb var1, String var2) throws RemoteException;

    public static abstract class com.google.android.gms.internal.fc$a
    extends Binder
    implements fc {
        public static fc F(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesService");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof fc)) return new a(iBinder);
            return (fc)iInterface;
        }

        public boolean onTransact(int n2, Parcel object, Parcel parcel, int n3) throws RemoteException {
            String[] stringArray = null;
            fb fb2 = null;
            String[] stringArray2 = null;
            fb fb3 = null;
            Object object2 = null;
            boolean bl2 = false;
            boolean bl3 = false;
            boolean bl4 = false;
            boolean bl5 = false;
            boolean bl6 = false;
            boolean bl7 = false;
            int n4 = 0;
            boolean bl8 = false;
            boolean bl9 = false;
            boolean bl10 = false;
            boolean bl11 = false;
            boolean bl12 = false;
            boolean bl13 = false;
            boolean bl14 = false;
            boolean bl15 = false;
            boolean bl16 = false;
            boolean bl17 = false;
            boolean bl18 = false;
            boolean bl19 = false;
            boolean bl20 = false;
            boolean bl21 = false;
            boolean bl22 = false;
            switch (n2) {
                default: {
                    return super.onTransact(n2, (Parcel)object, parcel, n3);
                }
                case 1598968902: {
                    parcel.writeString("com.google.android.gms.games.internal.IGamesService");
                    return true;
                }
                case 5001: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.f(object.readLong());
                    parcel.writeNoException();
                    return true;
                }
                case 5002: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.a(fb.a.E(object.readStrongBinder()));
                    parcel.writeNoException();
                    return true;
                }
                case 5003: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    object = this.getAppId();
                    parcel.writeNoException();
                    parcel.writeString((String)object);
                    return true;
                }
                case 5004: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    object = this.bc();
                    parcel.writeNoException();
                    if (object != null) {
                        parcel.writeInt(1);
                        object.writeToParcel(parcel, 1);
                        return true;
                    }
                    parcel.writeInt(0);
                    return true;
                }
                case 5005: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    stringArray2 = object.readStrongBinder();
                    fb2 = object2;
                    if (object.readInt() != 0) {
                        fb2 = (Bundle)Bundle.CREATOR.createFromParcel((Parcel)object);
                    }
                    this.a((IBinder)stringArray2, (Bundle)fb2);
                    parcel.writeNoException();
                    return true;
                }
                case 5006: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.cN();
                    parcel.writeNoException();
                    return true;
                }
                case 5007: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    object = this.getCurrentAccountName();
                    parcel.writeNoException();
                    parcel.writeString((String)object);
                    return true;
                }
                case 5064: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    object = this.S(object.readString());
                    parcel.writeNoException();
                    parcel.writeString((String)object);
                    return true;
                }
                case 5065: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.c(object.readString(), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 5008: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.a(fb.a.E(object.readStrongBinder()), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 5009: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.a(fb.a.E(object.readStrongBinder()), object.readString(), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 5010: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.b(fb.a.E(object.readStrongBinder()), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 5011: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb.a.E(object.readStrongBinder());
                    stringArray2 = object.readString();
                    bl2 = object.readInt() != 0;
                    this.a(fb2, (String)stringArray2, bl2, object.createLongArray());
                    parcel.writeNoException();
                    return true;
                }
                case 5012: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    object = this.getCurrentPlayerId();
                    parcel.writeNoException();
                    parcel.writeString((String)object);
                    return true;
                }
                case 5013: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    object = this.cV();
                    parcel.writeNoException();
                    if (object != null) {
                        parcel.writeInt(1);
                        ((DataHolder)object).writeToParcel(parcel, 1);
                        return true;
                    }
                    parcel.writeInt(0);
                    return true;
                }
                case 5014: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.c(fb.a.E(object.readStrongBinder()), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 5015: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb.a.E(object.readStrongBinder());
                    n2 = object.readInt();
                    bl2 = object.readInt() != 0;
                    if (object.readInt() != 0) {
                        bl22 = true;
                    }
                    this.a(fb2, n2, bl2, bl22);
                    parcel.writeNoException();
                    return true;
                }
                case 5016: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.a(fb.a.E(object.readStrongBinder()), object.readString(), object.readLong());
                    parcel.writeNoException();
                    return true;
                }
                case 5017: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.b(fb.a.E(object.readStrongBinder()));
                    parcel.writeNoException();
                    return true;
                }
                case 5018: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.d(fb.a.E(object.readStrongBinder()), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 5019: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb.a.E(object.readStrongBinder());
                    stringArray2 = object.readString();
                    n2 = object.readInt();
                    n3 = object.readInt();
                    n4 = object.readInt();
                    bl2 = object.readInt() != 0;
                    this.a(fb2, (String)stringArray2, n2, n3, n4, bl2);
                    parcel.writeNoException();
                    return true;
                }
                case 5020: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb.a.E(object.readStrongBinder());
                    stringArray2 = object.readString();
                    n2 = object.readInt();
                    n3 = object.readInt();
                    n4 = object.readInt();
                    bl2 = object.readInt() != 0;
                    this.b(fb2, (String)stringArray2, n2, n3, n4, bl2);
                    parcel.writeNoException();
                    return true;
                }
                case 5021: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    stringArray2 = fb.a.E(object.readStrongBinder());
                    fb2 = stringArray;
                    if (object.readInt() != 0) {
                        fb2 = (Bundle)Bundle.CREATOR.createFromParcel((Parcel)object);
                    }
                    this.a((fb)stringArray2, (Bundle)fb2, object.readInt(), object.readInt());
                    parcel.writeNoException();
                    return true;
                }
                case 5022: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.c(fb.a.E(object.readStrongBinder()));
                    parcel.writeNoException();
                    return true;
                }
                case 5023: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    stringArray2 = fb.a.E(object.readStrongBinder());
                    object2 = object.readString();
                    stringArray = object.readStrongBinder();
                    if (object.readInt() != 0) {
                        fb2 = (Bundle)Bundle.CREATOR.createFromParcel((Parcel)object);
                    }
                    this.a((fb)stringArray2, (String)object2, (IBinder)stringArray, (Bundle)fb2);
                    parcel.writeNoException();
                    return true;
                }
                case 5024: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    object2 = fb.a.E(object.readStrongBinder());
                    stringArray = object.readString();
                    fb3 = object.readStrongBinder();
                    fb2 = stringArray2;
                    if (object.readInt() != 0) {
                        fb2 = (Bundle)Bundle.CREATOR.createFromParcel((Parcel)object);
                    }
                    this.b((fb)object2, (String)stringArray, (IBinder)fb3, (Bundle)fb2);
                    parcel.writeNoException();
                    return true;
                }
                case 5025: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb.a.E(object.readStrongBinder());
                    stringArray2 = object.readString();
                    n2 = object.readInt();
                    object2 = object.readStrongBinder();
                    object = object.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel((Parcel)object) : null;
                    this.a(fb2, (String)stringArray2, n2, (IBinder)object2, (Bundle)object);
                    parcel.writeNoException();
                    return true;
                }
                case 5026: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.d(fb.a.E(object.readStrongBinder()));
                    parcel.writeNoException();
                    return true;
                }
                case 5027: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.e(fb.a.E(object.readStrongBinder()));
                    parcel.writeNoException();
                    return true;
                }
                case 5028: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.i(object.readString(), object.readInt());
                    parcel.writeNoException();
                    return true;
                }
                case 5029: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.h(object.readString(), object.readInt());
                    parcel.writeNoException();
                    return true;
                }
                case 5058: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.a(fb.a.E(object.readStrongBinder()), object.readLong());
                    parcel.writeNoException();
                    return true;
                }
                case 5059: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.g(object.readLong());
                    parcel.writeNoException();
                    return true;
                }
                case 5030: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    stringArray2 = fb.a.E(object.readStrongBinder());
                    object2 = object.readStrongBinder();
                    n2 = object.readInt();
                    stringArray = object.createStringArray();
                    fb2 = object.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel((Parcel)object) : null;
                    if (object.readInt() != 0) {
                        bl2 = true;
                    }
                    this.a((fb)stringArray2, (IBinder)object2, n2, stringArray, (Bundle)fb2, bl2, object.readLong());
                    parcel.writeNoException();
                    return true;
                }
                case 5031: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb.a.E(object.readStrongBinder());
                    stringArray2 = object.readStrongBinder();
                    object2 = object.readString();
                    bl2 = object.readInt() != 0;
                    this.a(fb2, (IBinder)stringArray2, (String)object2, bl2, object.readLong());
                    parcel.writeNoException();
                    return true;
                }
                case 5032: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.e(fb.a.E(object.readStrongBinder()), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 5033: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    n2 = this.a(fb.a.E(object.readStrongBinder()), object.createByteArray(), object.readString(), object.readString());
                    parcel.writeNoException();
                    parcel.writeInt(n2);
                    return true;
                }
                case 5034: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    n2 = this.b(object.createByteArray(), object.readString(), object.createStringArray());
                    parcel.writeNoException();
                    parcel.writeInt(n2);
                    return true;
                }
                case 5035: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    object = this.T(object.readString());
                    parcel.writeNoException();
                    parcel.writeString((String)object);
                    return true;
                }
                case 5036: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.clearNotifications(object.readInt());
                    parcel.writeNoException();
                    return true;
                }
                case 5037: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.f(fb.a.E(object.readStrongBinder()), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 5038: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.b(fb.a.E(object.readStrongBinder()), object.readString(), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 5039: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb.a.E(object.readStrongBinder());
                    stringArray2 = object.readString();
                    object2 = object.readString();
                    n2 = object.readInt();
                    n3 = object.readInt();
                    n4 = object.readInt();
                    bl2 = bl3;
                    if (object.readInt() != 0) {
                        bl2 = true;
                    }
                    this.a(fb2, (String)stringArray2, (String)object2, n2, n3, n4, bl2);
                    parcel.writeNoException();
                    return true;
                }
                case 5040: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb.a.E(object.readStrongBinder());
                    stringArray2 = object.readString();
                    object2 = object.readString();
                    n2 = object.readInt();
                    n3 = object.readInt();
                    n4 = object.readInt();
                    bl2 = bl4;
                    if (object.readInt() != 0) {
                        bl2 = true;
                    }
                    this.b(fb2, (String)stringArray2, (String)object2, n2, n3, n4, bl2);
                    parcel.writeNoException();
                    return true;
                }
                case 5041: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.c(fb.a.E(object.readStrongBinder()), object.readString(), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 5042: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.g(fb.a.E(object.readStrongBinder()), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 5043: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.h(fb.a.E(object.readStrongBinder()), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 5044: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb.a.E(object.readStrongBinder());
                    n2 = object.readInt();
                    n3 = object.readInt();
                    bl2 = object.readInt() != 0;
                    bl22 = object.readInt() != 0;
                    this.a(fb2, n2, n3, bl2, bl22);
                    parcel.writeNoException();
                    return true;
                }
                case 5045: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb.a.E(object.readStrongBinder());
                    stringArray2 = object.readString();
                    n2 = object.readInt();
                    bl2 = object.readInt() != 0;
                    bl22 = object.readInt() != 0;
                    this.a(fb2, (String)stringArray2, n2, bl2, bl22);
                    parcel.writeNoException();
                    return true;
                }
                case 5046: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb.a.E(object.readStrongBinder());
                    n2 = object.readInt();
                    bl2 = object.readInt() != 0;
                    bl22 = bl5;
                    if (object.readInt() != 0) {
                        bl22 = true;
                    }
                    this.b(fb2, n2, bl2, bl22);
                    parcel.writeNoException();
                    return true;
                }
                case 5047: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.f(fb.a.E(object.readStrongBinder()));
                    parcel.writeNoException();
                    return true;
                }
                case 5048: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb.a.E(object.readStrongBinder());
                    n2 = object.readInt();
                    bl2 = object.readInt() != 0;
                    bl22 = bl6;
                    if (object.readInt() != 0) {
                        bl22 = true;
                    }
                    this.c(fb2, n2, bl2, bl22);
                    parcel.writeNoException();
                    return true;
                }
                case 5049: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.g(fb.a.E(object.readStrongBinder()));
                    parcel.writeNoException();
                    return true;
                }
                case 5050: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.U(object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 5051: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.a(object.readString(), object.readString(), object.readInt());
                    parcel.writeNoException();
                    return true;
                }
                case 5052: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.i(fb.a.E(object.readStrongBinder()), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 5053: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    n2 = this.j(fb.a.E(object.readStrongBinder()), object.readString());
                    parcel.writeNoException();
                    parcel.writeInt(n2);
                    return true;
                }
                case 5060: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    n2 = this.V(object.readString());
                    parcel.writeNoException();
                    parcel.writeInt(n2);
                    return true;
                }
                case 5054: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb.a.E(object.readStrongBinder());
                    stringArray2 = object.readString();
                    bl2 = bl7;
                    if (object.readInt() != 0) {
                        bl2 = true;
                    }
                    this.a(fb2, (String)stringArray2, bl2);
                    parcel.writeNoException();
                    return true;
                }
                case 5061: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.k(fb.a.E(object.readStrongBinder()), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 5055: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.j(object.readString(), object.readInt());
                    parcel.writeNoException();
                    return true;
                }
                case 5067: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    bl2 = this.cW();
                    parcel.writeNoException();
                    n2 = n4;
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    return true;
                }
                case 5068: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    bl2 = bl8;
                    if (object.readInt() != 0) {
                        bl2 = true;
                    }
                    this.q(bl2);
                    parcel.writeNoException();
                    return true;
                }
                case 5056: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.h(fb.a.E(object.readStrongBinder()));
                    parcel.writeNoException();
                    return true;
                }
                case 5057: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.l(fb.a.E(object.readStrongBinder()), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 5062: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.i(fb.a.E(object.readStrongBinder()));
                    parcel.writeNoException();
                    return true;
                }
                case 5063: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb.a.E(object.readStrongBinder());
                    bl2 = bl9;
                    if (object.readInt() != 0) {
                        bl2 = true;
                    }
                    this.a(fb2, bl2);
                    parcel.writeNoException();
                    return true;
                }
                case 5066: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    object = this.W(object.readString());
                    parcel.writeNoException();
                    if (object != null) {
                        parcel.writeInt(1);
                        object.writeToParcel(parcel, 1);
                        return true;
                    }
                    parcel.writeInt(0);
                    return true;
                }
                case 5501: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb.a.E(object.readStrongBinder());
                    stringArray2 = object.readString();
                    n2 = object.readInt();
                    bl2 = object.readInt() != 0;
                    bl22 = object.readInt() != 0;
                    this.b(fb2, (String)stringArray2, n2, bl2, bl22);
                    parcel.writeNoException();
                    return true;
                }
                case 5502: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    object = this.cX();
                    parcel.writeNoException();
                    if (object != null) {
                        parcel.writeInt(1);
                        ((DataHolder)object).writeToParcel(parcel, 1);
                        return true;
                    }
                    parcel.writeInt(0);
                    return true;
                }
                case 6001: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb.a.E(object.readStrongBinder());
                    bl2 = bl10;
                    if (object.readInt() != 0) {
                        bl2 = true;
                    }
                    this.b(fb2, bl2);
                    parcel.writeNoException();
                    return true;
                }
                case 6002: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb.a.E(object.readStrongBinder());
                    stringArray2 = object.readString();
                    object2 = object.readString();
                    bl2 = bl11;
                    if (object.readInt() != 0) {
                        bl2 = true;
                    }
                    this.a(fb2, (String)stringArray2, (String)object2, bl2);
                    parcel.writeNoException();
                    return true;
                }
                case 6003: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb.a.E(object.readStrongBinder());
                    n2 = object.readInt();
                    bl2 = object.readInt() != 0;
                    bl22 = bl12;
                    if (object.readInt() != 0) {
                        bl22 = true;
                    }
                    this.d(fb2, n2, bl2, bl22);
                    parcel.writeNoException();
                    return true;
                }
                case 6004: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb.a.E(object.readStrongBinder());
                    n2 = object.readInt();
                    bl2 = object.readInt() != 0;
                    bl22 = bl13;
                    if (object.readInt() != 0) {
                        bl22 = true;
                    }
                    this.e(fb2, n2, bl2, bl22);
                    parcel.writeNoException();
                    return true;
                }
                case 6501: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb.a.E(object.readStrongBinder());
                    stringArray2 = object.readString();
                    n2 = object.readInt();
                    bl2 = object.readInt() != 0;
                    bl22 = object.readInt() != 0;
                    bl5 = object.readInt() != 0;
                    if (object.readInt() != 0) {
                        bl14 = true;
                    }
                    this.a(fb2, (String)stringArray2, n2, bl2, bl22, bl5, bl14);
                    parcel.writeNoException();
                    return true;
                }
                case 6502: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb.a.E(object.readStrongBinder());
                    stringArray2 = object.readString();
                    bl2 = bl15;
                    if (object.readInt() != 0) {
                        bl2 = true;
                    }
                    this.b(fb2, (String)stringArray2, bl2);
                    parcel.writeNoException();
                    return true;
                }
                case 6503: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb.a.E(object.readStrongBinder());
                    bl2 = bl16;
                    if (object.readInt() != 0) {
                        bl2 = true;
                    }
                    this.c(fb2, bl2);
                    parcel.writeNoException();
                    return true;
                }
                case 6504: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb.a.E(object.readStrongBinder());
                    stringArray2 = object.readString();
                    bl2 = bl17;
                    if (object.readInt() != 0) {
                        bl2 = true;
                    }
                    this.c(fb2, (String)stringArray2, bl2);
                    parcel.writeNoException();
                    return true;
                }
                case 6505: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb.a.E(object.readStrongBinder());
                    stringArray2 = object.readString();
                    bl2 = bl18;
                    if (object.readInt() != 0) {
                        bl2 = true;
                    }
                    this.d(fb2, (String)stringArray2, bl2);
                    parcel.writeNoException();
                    return true;
                }
                case 6506: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb.a.E(object.readStrongBinder());
                    stringArray2 = object.readString();
                    object2 = object.readString();
                    bl2 = bl19;
                    if (object.readInt() != 0) {
                        bl2 = true;
                    }
                    this.b(fb2, (String)stringArray2, (String)object2, bl2);
                    parcel.writeNoException();
                    return true;
                }
                case 6507: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb3;
                    if (object.readInt() != 0) {
                        fb2 = (Uri)Uri.CREATOR.createFromParcel((Parcel)object);
                    }
                    object = this.e((Uri)fb2);
                    parcel.writeNoException();
                    if (object != null) {
                        parcel.writeInt(1);
                        object.writeToParcel(parcel, 1);
                        return true;
                    }
                    parcel.writeInt(0);
                    return true;
                }
                case 7001: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.m(fb.a.E(object.readStrongBinder()), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 7002: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.a(fb.a.E(object.readStrongBinder()), object.readString(), object.readLong(), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 7003: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb.a.E(object.readStrongBinder());
                    stringArray2 = object.readString();
                    n2 = object.readInt();
                    object2 = object.readStrongBinder();
                    object = object.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel((Parcel)object) : null;
                    this.b(fb2, (String)stringArray2, n2, (IBinder)object2, (Bundle)object);
                    parcel.writeNoException();
                    return true;
                }
                case 8001: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.a(fb.a.E(object.readStrongBinder()), object.readString(), object.readString(), object.readInt(), object.readInt());
                    parcel.writeNoException();
                    return true;
                }
                case 8002: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.X(object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 8003: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.a(fb.a.E(object.readStrongBinder()), object.createIntArray());
                    parcel.writeNoException();
                    return true;
                }
                case 8004: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb.a.E(object.readStrongBinder());
                    n2 = object.readInt();
                    n3 = object.readInt();
                    stringArray2 = object.createStringArray();
                    object = object.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel((Parcel)object) : null;
                    this.a(fb2, n2, n3, stringArray2, (Bundle)object);
                    parcel.writeNoException();
                    return true;
                }
                case 8005: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.n(fb.a.E(object.readStrongBinder()), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 8006: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.o(fb.a.E(object.readStrongBinder()), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 8007: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.a(fb.a.E(object.readStrongBinder()), object.readString(), object.createByteArray(), object.readString(), (ParticipantResult[])object.createTypedArray((Parcelable.Creator)ParticipantResult.CREATOR));
                    parcel.writeNoException();
                    return true;
                }
                case 8008: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.a(fb.a.E(object.readStrongBinder()), object.readString(), object.createByteArray(), (ParticipantResult[])object.createTypedArray((Parcelable.Creator)ParticipantResult.CREATOR));
                    parcel.writeNoException();
                    return true;
                }
                case 8009: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.p(fb.a.E(object.readStrongBinder()), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 8010: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.q(fb.a.E(object.readStrongBinder()), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 8011: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.d(fb.a.E(object.readStrongBinder()), object.readString(), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 8012: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.b(fb.a.E(object.readStrongBinder()), object.readLong());
                    parcel.writeNoException();
                    return true;
                }
                case 8013: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.h(object.readLong());
                    parcel.writeNoException();
                    return true;
                }
                case 8014: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.r(fb.a.E(object.readStrongBinder()), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 8024: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    n2 = this.getMaxTurnBasedMatchDataSize();
                    parcel.writeNoException();
                    parcel.writeInt(n2);
                    return true;
                }
                case 8025: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.d(object.readString(), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 8015: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.e(fb.a.E(object.readStrongBinder()), object.readString(), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 8016: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.f(fb.a.E(object.readStrongBinder()), object.readString(), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 8017: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.a(fb.a.E(object.readStrongBinder()), object.readString(), object.createIntArray());
                    parcel.writeNoException();
                    return true;
                }
                case 8026: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.b(object.readString(), object.readString(), object.readInt());
                    parcel.writeNoException();
                    return true;
                }
                case 8018: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.a(fb.a.E(object.readStrongBinder()), object.readLong(), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 8019: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.a(object.readLong(), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 8020: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.b(fb.a.E(object.readStrongBinder()), object.readLong(), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 8021: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.b(object.readLong(), object.readString());
                    parcel.writeNoException();
                    return true;
                }
                case 8022: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    this.cY();
                    parcel.writeNoException();
                    return true;
                }
                case 8023: {
                    object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb.a.E(object.readStrongBinder());
                    stringArray2 = object.readString();
                    n2 = object.readInt();
                    bl2 = bl20;
                    if (object.readInt() != 0) {
                        bl2 = true;
                    }
                    this.a(fb2, (String)stringArray2, n2, bl2);
                    parcel.writeNoException();
                    return true;
                }
                case 8027: 
            }
            object.enforceInterface("com.google.android.gms.games.internal.IGamesService");
            fb2 = fb.a.E(object.readStrongBinder());
            bl2 = bl21;
            if (object.readInt() != 0) {
                bl2 = true;
            }
            this.d(fb2, bl2);
            parcel.writeNoException();
            return true;
        }

        private static class a
        implements fc {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            @Override
            public String S(String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcel.writeString(string2);
                    this.dU.transact(5064, parcel, parcel2, 0);
                    parcel2.readException();
                    string2 = parcel2.readString();
                    return string2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public String T(String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcel.writeString(string2);
                    this.dU.transact(5035, parcel, parcel2, 0);
                    parcel2.readException();
                    string2 = parcel2.readString();
                    return string2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void U(String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcel.writeString(string2);
                    this.dU.transact(5050, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public int V(String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcel.writeString(string2);
                    this.dU.transact(5060, parcel, parcel2, 0);
                    parcel2.readException();
                    int n2 = parcel2.readInt();
                    return n2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public Uri W(String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcel.writeString(string2);
                    this.dU.transact(5066, parcel, parcel2, 0);
                    parcel2.readException();
                    string2 = parcel2.readInt() != 0 ? (Uri)Uri.CREATOR.createFromParcel(parcel2) : null;
                    return string2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void X(String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcel.writeString(string2);
                    this.dU.transact(8002, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public int a(fb fb2, byte[] byArray, String string2, String string3) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeByteArray(byArray);
                    parcel.writeString(string2);
                    parcel.writeString(string3);
                    this.dU.transact(5033, parcel, parcel2, 0);
                    parcel2.readException();
                    int n2 = parcel2.readInt();
                    return n2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(long l2, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcel.writeLong(l2);
                    parcel.writeString(string2);
                    this.dU.transact(8019, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcel.writeStrongBinder(iBinder);
                    if (bundle != null) {
                        parcel.writeInt(1);
                        bundle.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(5005, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(fb fb2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    this.dU.transact(5002, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(fb fb2, int n2, int n3, boolean bl2, boolean bl3) throws RemoteException {
                int n4 = 1;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeInt(n2);
                    parcel.writeInt(n3);
                    n2 = bl2 ? 1 : 0;
                    parcel.writeInt(n2);
                    n2 = bl3 ? n4 : 0;
                    parcel.writeInt(n2);
                    this.dU.transact(5044, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(fb fb2, int n2, int n3, String[] stringArray, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var5_10;
                    void var4_9;
                    void var3_8;
                    void var2_7;
                    void var1_3;
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (fb2 != null) {
                        IBinder iBinder = fb2.asBinder();
                    } else {
                        Object var1_4 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    parcel.writeInt((int)var2_7);
                    parcel.writeInt((int)var3_8);
                    parcel.writeStringArray((String[])var4_9);
                    if (var5_10 != null) {
                        parcel.writeInt(1);
                        var5_10.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(8004, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(fb fb2, int n2, boolean bl2, boolean bl3) throws RemoteException {
                int n3 = 1;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeInt(n2);
                    n2 = bl2 ? 1 : 0;
                    parcel.writeInt(n2);
                    n2 = bl3 ? n3 : 0;
                    parcel.writeInt(n2);
                    this.dU.transact(5015, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(fb fb2, long l2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeLong(l2);
                    this.dU.transact(5058, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(fb fb2, long l2, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeLong(l2);
                    parcel.writeString(string2);
                    this.dU.transact(8018, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(fb fb2, Bundle bundle, int n2, int n3) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var4_9;
                    void var3_8;
                    void var2_7;
                    void var1_3;
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (fb2 != null) {
                        IBinder iBinder = fb2.asBinder();
                    } else {
                        Object var1_4 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    if (var2_7 != null) {
                        parcel.writeInt(1);
                        var2_7.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    parcel.writeInt((int)var3_8);
                    parcel.writeInt((int)var4_9);
                    this.dU.transact(5021, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(fb fb2, IBinder iBinder, int n2, String[] stringArray, Bundle bundle, boolean bl2, long l2) throws RemoteException {
                int n3 = 1;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var7_12;
                    void var6_11;
                    void var5_10;
                    void var4_9;
                    int n4;
                    void var2_7;
                    void var1_3;
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (fb2 != null) {
                        IBinder iBinder2 = fb2.asBinder();
                    } else {
                        Object var1_4 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    parcel.writeStrongBinder((IBinder)var2_7);
                    parcel.writeInt(n4);
                    parcel.writeStringArray((String[])var4_9);
                    if (var5_10 != null) {
                        parcel.writeInt(1);
                        var5_10.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    n4 = var6_11 != false ? n3 : 0;
                    parcel.writeInt(n4);
                    parcel.writeLong((long)var7_12);
                    this.dU.transact(5030, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(fb fb2, IBinder iBinder, String string2, boolean bl2, long l2) throws RemoteException {
                int n2 = 0;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeStrongBinder(iBinder);
                    parcel.writeString(string2);
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    parcel.writeLong(l2);
                    this.dU.transact(5031, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(fb fb2, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    this.dU.transact(5008, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(fb fb2, String string2, int n2, int n3, int n4, boolean bl2) throws RemoteException {
                int n5 = 0;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    parcel.writeInt(n2);
                    parcel.writeInt(n3);
                    parcel.writeInt(n4);
                    n2 = n5;
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    this.dU.transact(5019, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(fb fb2, String string2, int n2, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var5_10;
                    void var4_9;
                    void var3_8;
                    void var2_7;
                    void var1_3;
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (fb2 != null) {
                        IBinder iBinder2 = fb2.asBinder();
                    } else {
                        Object var1_4 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    parcel.writeString((String)var2_7);
                    parcel.writeInt((int)var3_8);
                    parcel.writeStrongBinder((IBinder)var4_9);
                    if (var5_10 != null) {
                        parcel.writeInt(1);
                        var5_10.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(5025, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(fb fb2, String string2, int n2, boolean bl2) throws RemoteException {
                int n3 = 0;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    parcel.writeInt(n2);
                    n2 = n3;
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    this.dU.transact(8023, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(fb fb2, String string2, int n2, boolean bl2, boolean bl3) throws RemoteException {
                int n3 = 1;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    parcel.writeInt(n2);
                    n2 = bl2 ? 1 : 0;
                    parcel.writeInt(n2);
                    n2 = bl3 ? n3 : 0;
                    parcel.writeInt(n2);
                    this.dU.transact(5045, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(fb fb2, String string2, int n2, boolean bl2, boolean bl3, boolean bl4, boolean bl5) throws RemoteException {
                int n3 = 1;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    parcel.writeInt(n2);
                    n2 = bl2 ? 1 : 0;
                    parcel.writeInt(n2);
                    n2 = bl3 ? 1 : 0;
                    parcel.writeInt(n2);
                    n2 = bl4 ? 1 : 0;
                    parcel.writeInt(n2);
                    n2 = bl5 ? n3 : 0;
                    parcel.writeInt(n2);
                    this.dU.transact(6501, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(fb fb2, String string2, long l2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    parcel.writeLong(l2);
                    this.dU.transact(5016, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(fb fb2, String string2, long l2, String string3) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    parcel.writeLong(l2);
                    parcel.writeString(string3);
                    this.dU.transact(7002, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(fb fb2, String string2, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var4_9;
                    void var3_8;
                    void var2_7;
                    void var1_3;
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (fb2 != null) {
                        IBinder iBinder2 = fb2.asBinder();
                    } else {
                        Object var1_4 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    parcel.writeString((String)var2_7);
                    parcel.writeStrongBinder((IBinder)var3_8);
                    if (var4_9 != null) {
                        parcel.writeInt(1);
                        var4_9.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(5023, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(fb fb2, String string2, String string3) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    parcel.writeString(string3);
                    this.dU.transact(5009, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(fb fb2, String string2, String string3, int n2, int n3) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    parcel.writeString(string3);
                    parcel.writeInt(n2);
                    parcel.writeInt(n3);
                    this.dU.transact(8001, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(fb fb2, String string2, String string3, int n2, int n3, int n4, boolean bl2) throws RemoteException {
                int n5 = 0;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    parcel.writeString(string3);
                    parcel.writeInt(n2);
                    parcel.writeInt(n3);
                    parcel.writeInt(n4);
                    n2 = n5;
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    this.dU.transact(5039, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(fb fb2, String string2, String string3, boolean bl2) throws RemoteException {
                int n2 = 0;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    parcel.writeString(string3);
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    this.dU.transact(6002, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(fb fb2, String string2, boolean bl2) throws RemoteException {
                int n2 = 0;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    this.dU.transact(5054, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(fb fb2, String string2, boolean bl2, long[] lArray) throws RemoteException {
                int n2 = 0;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    parcel.writeLongArray(lArray);
                    this.dU.transact(5011, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(fb fb2, String string2, byte[] byArray, String string3, ParticipantResult[] participantResultArray) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    parcel.writeByteArray(byArray);
                    parcel.writeString(string3);
                    parcel.writeTypedArray((Parcelable[])participantResultArray, 0);
                    this.dU.transact(8007, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(fb fb2, String string2, byte[] byArray, ParticipantResult[] participantResultArray) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    parcel.writeByteArray(byArray);
                    parcel.writeTypedArray((Parcelable[])participantResultArray, 0);
                    this.dU.transact(8008, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(fb fb2, String string2, int[] nArray) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    parcel.writeIntArray(nArray);
                    this.dU.transact(8017, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(fb fb2, boolean bl2) throws RemoteException {
                int n2 = 0;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    this.dU.transact(5063, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(fb fb2, int[] nArray) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeIntArray(nArray);
                    this.dU.transact(8003, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(String string2, String string3, int n2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcel.writeString(string2);
                    parcel.writeString(string3);
                    parcel.writeInt(n2);
                    this.dU.transact(5051, parcel, parcel2, 0);
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

            @Override
            public int b(byte[] byArray, String string2, String[] stringArray) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcel.writeByteArray(byArray);
                    parcel.writeString(string2);
                    parcel.writeStringArray(stringArray);
                    this.dU.transact(5034, parcel, parcel2, 0);
                    parcel2.readException();
                    int n2 = parcel2.readInt();
                    return n2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void b(long l2, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcel.writeLong(l2);
                    parcel.writeString(string2);
                    this.dU.transact(8021, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void b(fb fb2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    this.dU.transact(5017, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void b(fb fb2, int n2, boolean bl2, boolean bl3) throws RemoteException {
                int n3 = 1;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeInt(n2);
                    n2 = bl2 ? 1 : 0;
                    parcel.writeInt(n2);
                    n2 = bl3 ? n3 : 0;
                    parcel.writeInt(n2);
                    this.dU.transact(5046, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void b(fb fb2, long l2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeLong(l2);
                    this.dU.transact(8012, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void b(fb fb2, long l2, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeLong(l2);
                    parcel.writeString(string2);
                    this.dU.transact(8020, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void b(fb fb2, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    this.dU.transact(5010, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void b(fb fb2, String string2, int n2, int n3, int n4, boolean bl2) throws RemoteException {
                int n5 = 0;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    parcel.writeInt(n2);
                    parcel.writeInt(n3);
                    parcel.writeInt(n4);
                    n2 = n5;
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    this.dU.transact(5020, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void b(fb fb2, String string2, int n2, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var5_10;
                    void var4_9;
                    void var3_8;
                    void var2_7;
                    void var1_3;
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (fb2 != null) {
                        IBinder iBinder2 = fb2.asBinder();
                    } else {
                        Object var1_4 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    parcel.writeString((String)var2_7);
                    parcel.writeInt((int)var3_8);
                    parcel.writeStrongBinder((IBinder)var4_9);
                    if (var5_10 != null) {
                        parcel.writeInt(1);
                        var5_10.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(7003, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void b(fb fb2, String string2, int n2, boolean bl2, boolean bl3) throws RemoteException {
                int n3 = 1;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    parcel.writeInt(n2);
                    n2 = bl2 ? 1 : 0;
                    parcel.writeInt(n2);
                    n2 = bl3 ? n3 : 0;
                    parcel.writeInt(n2);
                    this.dU.transact(5501, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void b(fb fb2, String string2, IBinder iBinder, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var4_9;
                    void var3_8;
                    void var2_7;
                    void var1_3;
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (fb2 != null) {
                        IBinder iBinder2 = fb2.asBinder();
                    } else {
                        Object var1_4 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    parcel.writeString((String)var2_7);
                    parcel.writeStrongBinder((IBinder)var3_8);
                    if (var4_9 != null) {
                        parcel.writeInt(1);
                        var4_9.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(5024, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void b(fb fb2, String string2, String string3) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    parcel.writeString(string3);
                    this.dU.transact(5038, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void b(fb fb2, String string2, String string3, int n2, int n3, int n4, boolean bl2) throws RemoteException {
                int n5 = 0;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    parcel.writeString(string3);
                    parcel.writeInt(n2);
                    parcel.writeInt(n3);
                    parcel.writeInt(n4);
                    n2 = n5;
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    this.dU.transact(5040, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void b(fb fb2, String string2, String string3, boolean bl2) throws RemoteException {
                int n2 = 0;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    parcel.writeString(string3);
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    this.dU.transact(6506, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void b(fb fb2, String string2, boolean bl2) throws RemoteException {
                int n2 = 0;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    this.dU.transact(6502, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void b(fb fb2, boolean bl2) throws RemoteException {
                int n2 = 0;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    this.dU.transact(6001, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void b(String string2, String string3, int n2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcel.writeString(string2);
                    parcel.writeString(string3);
                    parcel.writeInt(n2);
                    this.dU.transact(8026, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public Bundle bc() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.dU.transact(5004, parcel, parcel2, 0);
                    parcel2.readException();
                    Bundle bundle = parcel2.readInt() != 0 ? (Bundle)Bundle.CREATOR.createFromParcel(parcel2) : null;
                    return bundle;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void c(fb fb2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    this.dU.transact(5022, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void c(fb fb2, int n2, boolean bl2, boolean bl3) throws RemoteException {
                int n3 = 1;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeInt(n2);
                    n2 = bl2 ? 1 : 0;
                    parcel.writeInt(n2);
                    n2 = bl3 ? n3 : 0;
                    parcel.writeInt(n2);
                    this.dU.transact(5048, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void c(fb fb2, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    this.dU.transact(5014, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void c(fb fb2, String string2, String string3) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    parcel.writeString(string3);
                    this.dU.transact(5041, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void c(fb fb2, String string2, boolean bl2) throws RemoteException {
                int n2 = 0;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    this.dU.transact(6504, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void c(fb fb2, boolean bl2) throws RemoteException {
                int n2 = 0;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    this.dU.transact(6503, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void c(String string2, String string3) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcel.writeString(string2);
                    parcel.writeString(string3);
                    this.dU.transact(5065, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void cN() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.dU.transact(5006, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public DataHolder cV() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.dU.transact(5013, parcel, parcel2, 0);
                    parcel2.readException();
                    DataHolder dataHolder = parcel2.readInt() != 0 ? DataHolder.CREATOR.createFromParcel(parcel2) : null;
                    return dataHolder;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public boolean cW() throws RemoteException {
                boolean bl2 = false;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.dU.transact(5067, parcel, parcel2, 0);
                    parcel2.readException();
                    int n2 = parcel2.readInt();
                    if (n2 == 0) return bl2;
                    bl2 = true;
                    return bl2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public DataHolder cX() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.dU.transact(5502, parcel, parcel2, 0);
                    parcel2.readException();
                    DataHolder dataHolder = parcel2.readInt() != 0 ? DataHolder.CREATOR.createFromParcel(parcel2) : null;
                    return dataHolder;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void cY() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.dU.transact(8022, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void clearNotifications(int n2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcel.writeInt(n2);
                    this.dU.transact(5036, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void d(fb fb2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    this.dU.transact(5026, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void d(fb fb2, int n2, boolean bl2, boolean bl3) throws RemoteException {
                int n3 = 1;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeInt(n2);
                    n2 = bl2 ? 1 : 0;
                    parcel.writeInt(n2);
                    n2 = bl3 ? n3 : 0;
                    parcel.writeInt(n2);
                    this.dU.transact(6003, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void d(fb fb2, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    this.dU.transact(5018, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void d(fb fb2, String string2, String string3) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    parcel.writeString(string3);
                    this.dU.transact(8011, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void d(fb fb2, String string2, boolean bl2) throws RemoteException {
                int n2 = 0;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    this.dU.transact(6505, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void d(fb fb2, boolean bl2) throws RemoteException {
                int n2 = 0;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    this.dU.transact(8027, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void d(String string2, String string3) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcel.writeString(string2);
                    parcel.writeString(string3);
                    this.dU.transact(8025, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public ParcelFileDescriptor e(Uri object) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var1_3;
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (object != null) {
                        parcel.writeInt(1);
                        object.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(6507, parcel, parcel2, 0);
                    parcel2.readException();
                    if (parcel2.readInt() != 0) {
                        ParcelFileDescriptor parcelFileDescriptor = (ParcelFileDescriptor)ParcelFileDescriptor.CREATOR.createFromParcel(parcel2);
                        return var1_3;
                    } else {
                        Object var1_5 = null;
                    }
                    return var1_3;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void e(fb fb2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    this.dU.transact(5027, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void e(fb fb2, int n2, boolean bl2, boolean bl3) throws RemoteException {
                int n3 = 1;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeInt(n2);
                    n2 = bl2 ? 1 : 0;
                    parcel.writeInt(n2);
                    n2 = bl3 ? n3 : 0;
                    parcel.writeInt(n2);
                    this.dU.transact(6004, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void e(fb fb2, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    this.dU.transact(5032, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void e(fb fb2, String string2, String string3) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    parcel.writeString(string3);
                    this.dU.transact(8015, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void f(long l2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcel.writeLong(l2);
                    this.dU.transact(5001, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void f(fb fb2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    this.dU.transact(5047, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void f(fb fb2, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    this.dU.transact(5037, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void f(fb fb2, String string2, String string3) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    parcel.writeString(string3);
                    this.dU.transact(8016, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void g(long l2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcel.writeLong(l2);
                    this.dU.transact(5059, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void g(fb fb2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    this.dU.transact(5049, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void g(fb fb2, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    this.dU.transact(5042, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public String getAppId() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.dU.transact(5003, parcel, parcel2, 0);
                    parcel2.readException();
                    String string2 = parcel2.readString();
                    return string2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public String getCurrentAccountName() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.dU.transact(5007, parcel, parcel2, 0);
                    parcel2.readException();
                    String string2 = parcel2.readString();
                    return string2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public String getCurrentPlayerId() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.dU.transact(5012, parcel, parcel2, 0);
                    parcel2.readException();
                    String string2 = parcel2.readString();
                    return string2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public int getMaxTurnBasedMatchDataSize() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    this.dU.transact(8024, parcel, parcel2, 0);
                    parcel2.readException();
                    int n2 = parcel2.readInt();
                    return n2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void h(long l2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcel.writeLong(l2);
                    this.dU.transact(8013, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void h(fb fb2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    this.dU.transact(5056, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void h(fb fb2, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    this.dU.transact(5043, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void h(String string2, int n2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcel.writeString(string2);
                    parcel.writeInt(n2);
                    this.dU.transact(5029, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void i(fb fb2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    this.dU.transact(5062, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void i(fb fb2, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    this.dU.transact(5052, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void i(String string2, int n2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcel.writeString(string2);
                    parcel.writeInt(n2);
                    this.dU.transact(5028, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public int j(fb fb2, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    this.dU.transact(5053, parcel, parcel2, 0);
                    parcel2.readException();
                    int n2 = parcel2.readInt();
                    return n2;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void j(String string2, int n2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    parcel.writeString(string2);
                    parcel.writeInt(n2);
                    this.dU.transact(5055, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void k(fb fb2, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    this.dU.transact(5061, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void l(fb fb2, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    this.dU.transact(5057, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void m(fb fb2, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    this.dU.transact(7001, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void n(fb fb2, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    this.dU.transact(8005, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void o(fb fb2, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    this.dU.transact(8006, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void p(fb fb2, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    this.dU.transact(8009, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void q(fb fb2, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    this.dU.transact(8010, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void q(boolean bl2) throws RemoteException {
                int n2 = 0;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    this.dU.transact(5068, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void r(fb fb2, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesService");
                    fb2 = fb2 != null ? fb2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)fb2);
                    parcel.writeString(string2);
                    this.dU.transact(8014, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }
        }
    }
}

