/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.os.Binder
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 */
package com.google.android.gms.internal;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;

public interface fb
extends IInterface {
    public void A(DataHolder var1) throws RemoteException;

    public void B(DataHolder var1) throws RemoteException;

    public void C(DataHolder var1) throws RemoteException;

    public void a(int var1, Bundle var2) throws RemoteException;

    public void a(int var1, String var2, boolean var3) throws RemoteException;

    public void a(DataHolder var1, DataHolder var2) throws RemoteException;

    public void a(DataHolder var1, String[] var2) throws RemoteException;

    public void ao(int var1) throws RemoteException;

    public void ap(int var1) throws RemoteException;

    public void aq(int var1) throws RemoteException;

    public void ar(int var1) throws RemoteException;

    public void b(int var1, int var2, String var3) throws RemoteException;

    public void b(DataHolder var1) throws RemoteException;

    public void b(DataHolder var1, String[] var2) throws RemoteException;

    public void c(int var1, String var2) throws RemoteException;

    public void c(DataHolder var1) throws RemoteException;

    public void c(DataHolder var1, String[] var2) throws RemoteException;

    public void d(DataHolder var1) throws RemoteException;

    public void d(DataHolder var1, String[] var2) throws RemoteException;

    public void e(DataHolder var1) throws RemoteException;

    public void e(DataHolder var1, String[] var2) throws RemoteException;

    public void f(DataHolder var1) throws RemoteException;

    public void f(DataHolder var1, String[] var2) throws RemoteException;

    public void g(DataHolder var1) throws RemoteException;

    public void h(DataHolder var1) throws RemoteException;

    public void i(DataHolder var1) throws RemoteException;

    public void j(DataHolder var1) throws RemoteException;

    public void k(DataHolder var1) throws RemoteException;

    public void l(DataHolder var1) throws RemoteException;

    public void m(DataHolder var1) throws RemoteException;

    public void n(DataHolder var1) throws RemoteException;

    public void o(DataHolder var1) throws RemoteException;

    public void onAchievementUpdated(int var1, String var2) throws RemoteException;

    public void onInvitationRemoved(String var1) throws RemoteException;

    public void onLeftRoom(int var1, String var2) throws RemoteException;

    public void onP2PConnected(String var1) throws RemoteException;

    public void onP2PDisconnected(String var1) throws RemoteException;

    public void onRealTimeMessageReceived(RealTimeMessage var1) throws RemoteException;

    public void onSignOutComplete() throws RemoteException;

    public void onTurnBasedMatchCanceled(int var1, String var2) throws RemoteException;

    public void onTurnBasedMatchRemoved(String var1) throws RemoteException;

    public void p(DataHolder var1) throws RemoteException;

    public void q(DataHolder var1) throws RemoteException;

    public void r(DataHolder var1) throws RemoteException;

    public void s(DataHolder var1) throws RemoteException;

    public void t(DataHolder var1) throws RemoteException;

    public void u(DataHolder var1) throws RemoteException;

    public void v(DataHolder var1) throws RemoteException;

    public void w(DataHolder var1) throws RemoteException;

    public void x(DataHolder var1) throws RemoteException;

    public void y(DataHolder var1) throws RemoteException;

    public void z(DataHolder var1) throws RemoteException;

    public static abstract class com.google.android.gms.internal.fb$a
    extends Binder
    implements fb {
        public com.google.android.gms.internal.fb$a() {
            this.attachInterface(this, "com.google.android.gms.games.internal.IGamesCallbacks");
        }

        public static fb E(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof fb)) return new a(iBinder);
            return (fb)iInterface;
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) throws RemoteException {
            String string2 = null;
            DataHolder dataHolder = null;
            String string3 = null;
            String string4 = null;
            String string5 = null;
            String string6 = null;
            String string7 = null;
            String string8 = null;
            String string9 = null;
            String string10 = null;
            String string11 = null;
            String string12 = null;
            String string13 = null;
            String string14 = null;
            String string15 = null;
            String string16 = null;
            String string17 = null;
            String string18 = null;
            String string19 = null;
            String string20 = null;
            String string21 = null;
            String string22 = null;
            String string23 = null;
            String string24 = null;
            String string25 = null;
            String string26 = null;
            String string27 = null;
            String string28 = null;
            String string29 = null;
            String string30 = null;
            String string31 = null;
            String string32 = null;
            String string33 = null;
            String string34 = null;
            String string35 = null;
            String string36 = null;
            Object object = null;
            switch (n2) {
                default: {
                    return super.onTransact(n2, parcel, parcel2, n3);
                }
                case 1598968902: {
                    parcel2.writeString("com.google.android.gms.games.internal.IGamesCallbacks");
                    return true;
                }
                case 5001: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    this.c(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                }
                case 5002: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (parcel.readInt() != 0) {
                        object = DataHolder.CREATOR.createFromParcel(parcel);
                    }
                    this.b((DataHolder)object);
                    parcel2.writeNoException();
                    return true;
                }
                case 5003: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    this.onAchievementUpdated(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                }
                case 5004: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    object = string2;
                    if (parcel.readInt() != 0) {
                        object = DataHolder.CREATOR.createFromParcel(parcel);
                    }
                    this.c((DataHolder)object);
                    parcel2.writeNoException();
                    return true;
                }
                case 5005: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    object = parcel.readInt() != 0 ? DataHolder.CREATOR.createFromParcel(parcel) : null;
                    if (parcel.readInt() != 0) {
                        dataHolder = DataHolder.CREATOR.createFromParcel(parcel);
                    }
                    this.a((DataHolder)object, dataHolder);
                    parcel2.writeNoException();
                    return true;
                }
                case 5006: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    object = string3;
                    if (parcel.readInt() != 0) {
                        object = DataHolder.CREATOR.createFromParcel(parcel);
                    }
                    this.d((DataHolder)object);
                    parcel2.writeNoException();
                    return true;
                }
                case 5007: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    object = string4;
                    if (parcel.readInt() != 0) {
                        object = DataHolder.CREATOR.createFromParcel(parcel);
                    }
                    this.e((DataHolder)object);
                    parcel2.writeNoException();
                    return true;
                }
                case 5008: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    object = string5;
                    if (parcel.readInt() != 0) {
                        object = DataHolder.CREATOR.createFromParcel(parcel);
                    }
                    this.f((DataHolder)object);
                    parcel2.writeNoException();
                    return true;
                }
                case 5009: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    object = string6;
                    if (parcel.readInt() != 0) {
                        object = DataHolder.CREATOR.createFromParcel(parcel);
                    }
                    this.g((DataHolder)object);
                    parcel2.writeNoException();
                    return true;
                }
                case 5010: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    object = string7;
                    if (parcel.readInt() != 0) {
                        object = DataHolder.CREATOR.createFromParcel(parcel);
                    }
                    this.h((DataHolder)object);
                    parcel2.writeNoException();
                    return true;
                }
                case 5011: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    object = string8;
                    if (parcel.readInt() != 0) {
                        object = DataHolder.CREATOR.createFromParcel(parcel);
                    }
                    this.i((DataHolder)object);
                    parcel2.writeNoException();
                    return true;
                }
                case 5012: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    object = string9;
                    if (parcel.readInt() != 0) {
                        object = DataHolder.CREATOR.createFromParcel(parcel);
                    }
                    this.q((DataHolder)object);
                    parcel2.writeNoException();
                    return true;
                }
                case 5013: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    this.ao(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                }
                case 5014: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    object = string10;
                    if (parcel.readInt() != 0) {
                        object = DataHolder.CREATOR.createFromParcel(parcel);
                    }
                    this.r((DataHolder)object);
                    parcel2.writeNoException();
                    return true;
                }
                case 5015: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    this.ap(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                }
                case 5016: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    this.onSignOutComplete();
                    parcel2.writeNoException();
                    return true;
                }
                case 5017: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    object = string11;
                    if (parcel.readInt() != 0) {
                        object = DataHolder.CREATOR.createFromParcel(parcel);
                    }
                    this.j((DataHolder)object);
                    parcel2.writeNoException();
                    return true;
                }
                case 5037: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    object = string12;
                    if (parcel.readInt() != 0) {
                        object = DataHolder.CREATOR.createFromParcel(parcel);
                    }
                    this.k((DataHolder)object);
                    parcel2.writeNoException();
                    return true;
                }
                case 5018: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    object = string13;
                    if (parcel.readInt() != 0) {
                        object = DataHolder.CREATOR.createFromParcel(parcel);
                    }
                    this.s((DataHolder)object);
                    parcel2.writeNoException();
                    return true;
                }
                case 5019: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    object = string14;
                    if (parcel.readInt() != 0) {
                        object = DataHolder.CREATOR.createFromParcel(parcel);
                    }
                    this.t((DataHolder)object);
                    parcel2.writeNoException();
                    return true;
                }
                case 5020: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    this.onLeftRoom(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                }
                case 5021: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    object = string15;
                    if (parcel.readInt() != 0) {
                        object = DataHolder.CREATOR.createFromParcel(parcel);
                    }
                    this.u((DataHolder)object);
                    parcel2.writeNoException();
                    return true;
                }
                case 5022: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    object = string16;
                    if (parcel.readInt() != 0) {
                        object = DataHolder.CREATOR.createFromParcel(parcel);
                    }
                    this.v((DataHolder)object);
                    parcel2.writeNoException();
                    return true;
                }
                case 5023: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    object = string17;
                    if (parcel.readInt() != 0) {
                        object = DataHolder.CREATOR.createFromParcel(parcel);
                    }
                    this.w((DataHolder)object);
                    parcel2.writeNoException();
                    return true;
                }
                case 5024: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    object = string18;
                    if (parcel.readInt() != 0) {
                        object = DataHolder.CREATOR.createFromParcel(parcel);
                    }
                    this.x((DataHolder)object);
                    parcel2.writeNoException();
                    return true;
                }
                case 5025: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    object = string19;
                    if (parcel.readInt() != 0) {
                        object = DataHolder.CREATOR.createFromParcel(parcel);
                    }
                    this.y((DataHolder)object);
                    parcel2.writeNoException();
                    return true;
                }
                case 5026: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    object = string20;
                    if (parcel.readInt() != 0) {
                        object = DataHolder.CREATOR.createFromParcel(parcel);
                    }
                    this.a((DataHolder)object, parcel.createStringArray());
                    parcel2.writeNoException();
                    return true;
                }
                case 5027: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    object = string21;
                    if (parcel.readInt() != 0) {
                        object = DataHolder.CREATOR.createFromParcel(parcel);
                    }
                    this.b((DataHolder)object, parcel.createStringArray());
                    parcel2.writeNoException();
                    return true;
                }
                case 5028: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    object = string22;
                    if (parcel.readInt() != 0) {
                        object = DataHolder.CREATOR.createFromParcel(parcel);
                    }
                    this.c((DataHolder)object, parcel.createStringArray());
                    parcel2.writeNoException();
                    return true;
                }
                case 5029: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    object = string23;
                    if (parcel.readInt() != 0) {
                        object = DataHolder.CREATOR.createFromParcel(parcel);
                    }
                    this.d((DataHolder)object, parcel.createStringArray());
                    parcel2.writeNoException();
                    return true;
                }
                case 5030: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    object = string24;
                    if (parcel.readInt() != 0) {
                        object = DataHolder.CREATOR.createFromParcel(parcel);
                    }
                    this.e((DataHolder)object, parcel.createStringArray());
                    parcel2.writeNoException();
                    return true;
                }
                case 5031: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    object = string25;
                    if (parcel.readInt() != 0) {
                        object = DataHolder.CREATOR.createFromParcel(parcel);
                    }
                    this.f((DataHolder)object, parcel.createStringArray());
                    parcel2.writeNoException();
                    return true;
                }
                case 5032: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    object = string26;
                    if (parcel.readInt() != 0) {
                        object = (RealTimeMessage)RealTimeMessage.CREATOR.createFromParcel(parcel);
                    }
                    this.onRealTimeMessageReceived((RealTimeMessage)object);
                    parcel2.writeNoException();
                    return true;
                }
                case 5033: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    this.b(parcel.readInt(), parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                }
                case 5034: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    n2 = parcel.readInt();
                    object = parcel.readString();
                    boolean bl2 = parcel.readInt() != 0;
                    this.a(n2, (String)object, bl2);
                    parcel2.writeNoException();
                    return true;
                }
                case 5038: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    object = string27;
                    if (parcel.readInt() != 0) {
                        object = DataHolder.CREATOR.createFromParcel(parcel);
                    }
                    this.z((DataHolder)object);
                    parcel2.writeNoException();
                    return true;
                }
                case 5035: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    object = string28;
                    if (parcel.readInt() != 0) {
                        object = DataHolder.CREATOR.createFromParcel(parcel);
                    }
                    this.A((DataHolder)object);
                    parcel2.writeNoException();
                    return true;
                }
                case 5036: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    this.aq(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                }
                case 5039: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    object = string29;
                    if (parcel.readInt() != 0) {
                        object = DataHolder.CREATOR.createFromParcel(parcel);
                    }
                    this.B((DataHolder)object);
                    parcel2.writeNoException();
                    return true;
                }
                case 5040: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    this.ar(parcel.readInt());
                    parcel2.writeNoException();
                    return true;
                }
                case 6001: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    this.onP2PConnected(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                }
                case 6002: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    this.onP2PDisconnected(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                }
                case 8001: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    object = string30;
                    if (parcel.readInt() != 0) {
                        object = DataHolder.CREATOR.createFromParcel(parcel);
                    }
                    this.C((DataHolder)object);
                    parcel2.writeNoException();
                    return true;
                }
                case 8002: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    n2 = parcel.readInt();
                    object = string31;
                    if (parcel.readInt() != 0) {
                        object = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                    }
                    this.a(n2, (Bundle)object);
                    parcel2.writeNoException();
                    return true;
                }
                case 8003: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    object = string32;
                    if (parcel.readInt() != 0) {
                        object = DataHolder.CREATOR.createFromParcel(parcel);
                    }
                    this.l((DataHolder)object);
                    parcel2.writeNoException();
                    return true;
                }
                case 8004: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    object = string33;
                    if (parcel.readInt() != 0) {
                        object = DataHolder.CREATOR.createFromParcel(parcel);
                    }
                    this.m((DataHolder)object);
                    parcel2.writeNoException();
                    return true;
                }
                case 8005: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    object = string34;
                    if (parcel.readInt() != 0) {
                        object = DataHolder.CREATOR.createFromParcel(parcel);
                    }
                    this.n((DataHolder)object);
                    parcel2.writeNoException();
                    return true;
                }
                case 8006: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    object = string35;
                    if (parcel.readInt() != 0) {
                        object = DataHolder.CREATOR.createFromParcel(parcel);
                    }
                    this.o((DataHolder)object);
                    parcel2.writeNoException();
                    return true;
                }
                case 8007: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    this.onTurnBasedMatchCanceled(parcel.readInt(), parcel.readString());
                    parcel2.writeNoException();
                    return true;
                }
                case 8008: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    object = string36;
                    if (parcel.readInt() != 0) {
                        object = DataHolder.CREATOR.createFromParcel(parcel);
                    }
                    this.p((DataHolder)object);
                    parcel2.writeNoException();
                    return true;
                }
                case 8009: {
                    parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
                    this.onTurnBasedMatchRemoved(parcel.readString());
                    parcel2.writeNoException();
                    return true;
                }
                case 8010: 
            }
            parcel.enforceInterface("com.google.android.gms.games.internal.IGamesCallbacks");
            this.onInvitationRemoved(parcel.readString());
            parcel2.writeNoException();
            return true;
        }

        private static class a
        implements fb {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            @Override
            public void A(DataHolder dataHolder) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        parcel.writeInt(1);
                        dataHolder.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(5035, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void B(DataHolder dataHolder) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        parcel.writeInt(1);
                        dataHolder.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
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
            public void C(DataHolder dataHolder) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        parcel.writeInt(1);
                        dataHolder.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
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
            public void a(int n2, Bundle bundle) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    parcel.writeInt(n2);
                    if (bundle != null) {
                        parcel.writeInt(1);
                        bundle.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
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
            public void a(int n2, String string2, boolean bl2) throws RemoteException {
                int n3 = 0;
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    parcel.writeInt(n2);
                    parcel.writeString(string2);
                    n2 = n3;
                    if (bl2) {
                        n2 = 1;
                    }
                    parcel.writeInt(n2);
                    this.dU.transact(5034, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            /*
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(DataHolder dataHolder, DataHolder dataHolder2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        parcel.writeInt(1);
                        dataHolder.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    if (dataHolder2 != null) {
                        parcel.writeInt(1);
                        dataHolder2.writeToParcel(parcel, 0);
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
            public void a(DataHolder dataHolder, String[] stringArray) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        parcel.writeInt(1);
                        dataHolder.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    parcel.writeStringArray(stringArray);
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
            public void ao(int n2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    parcel.writeInt(n2);
                    this.dU.transact(5013, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void ap(int n2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
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
            public void aq(int n2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
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
            public void ar(int n2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
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

            public IBinder asBinder() {
                return this.dU;
            }

            @Override
            public void b(int n2, int n3, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    parcel.writeInt(n2);
                    parcel.writeInt(n3);
                    parcel.writeString(string2);
                    this.dU.transact(5033, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void b(DataHolder dataHolder) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        parcel.writeInt(1);
                        dataHolder.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
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
            public void b(DataHolder dataHolder, String[] stringArray) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        parcel.writeInt(1);
                        dataHolder.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    parcel.writeStringArray(stringArray);
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
            public void c(int n2, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    parcel.writeInt(n2);
                    parcel.writeString(string2);
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
            public void c(DataHolder dataHolder) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        parcel.writeInt(1);
                        dataHolder.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(5004, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void c(DataHolder dataHolder, String[] stringArray) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        parcel.writeInt(1);
                        dataHolder.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    parcel.writeStringArray(stringArray);
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
            public void d(DataHolder dataHolder) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        parcel.writeInt(1);
                        dataHolder.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
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
            public void d(DataHolder dataHolder, String[] stringArray) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        parcel.writeInt(1);
                        dataHolder.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    parcel.writeStringArray(stringArray);
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
            public void e(DataHolder dataHolder) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        parcel.writeInt(1);
                        dataHolder.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(5007, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void e(DataHolder dataHolder, String[] stringArray) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        parcel.writeInt(1);
                        dataHolder.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    parcel.writeStringArray(stringArray);
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
            public void f(DataHolder dataHolder) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        parcel.writeInt(1);
                        dataHolder.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
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
            public void f(DataHolder dataHolder, String[] stringArray) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        parcel.writeInt(1);
                        dataHolder.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    parcel.writeStringArray(stringArray);
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
            public void g(DataHolder dataHolder) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        parcel.writeInt(1);
                        dataHolder.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
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
            public void h(DataHolder dataHolder) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        parcel.writeInt(1);
                        dataHolder.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
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
            public void i(DataHolder dataHolder) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        parcel.writeInt(1);
                        dataHolder.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
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
            public void j(DataHolder dataHolder) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        parcel.writeInt(1);
                        dataHolder.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
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
            public void k(DataHolder dataHolder) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        parcel.writeInt(1);
                        dataHolder.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
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
            public void l(DataHolder dataHolder) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        parcel.writeInt(1);
                        dataHolder.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
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
            public void m(DataHolder dataHolder) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        parcel.writeInt(1);
                        dataHolder.writeToParcel(parcel, 0);
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
            public void n(DataHolder dataHolder) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        parcel.writeInt(1);
                        dataHolder.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
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
            public void o(DataHolder dataHolder) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        parcel.writeInt(1);
                        dataHolder.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
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
            public void onAchievementUpdated(int n2, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    parcel.writeInt(n2);
                    parcel.writeString(string2);
                    this.dU.transact(5003, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void onInvitationRemoved(String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
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
            public void onLeftRoom(int n2, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    parcel.writeInt(n2);
                    parcel.writeString(string2);
                    this.dU.transact(5020, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void onP2PConnected(String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    parcel.writeString(string2);
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
            public void onP2PDisconnected(String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    parcel.writeString(string2);
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
            public void onRealTimeMessageReceived(RealTimeMessage realTimeMessage) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (realTimeMessage != null) {
                        parcel.writeInt(1);
                        realTimeMessage.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
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
            public void onSignOutComplete() throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
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
            public void onTurnBasedMatchCanceled(int n2, String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    parcel.writeInt(n2);
                    parcel.writeString(string2);
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
            public void onTurnBasedMatchRemoved(String string2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
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
            public void p(DataHolder dataHolder) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        parcel.writeInt(1);
                        dataHolder.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
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
            public void q(DataHolder dataHolder) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        parcel.writeInt(1);
                        dataHolder.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(5012, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void r(DataHolder dataHolder) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        parcel.writeInt(1);
                        dataHolder.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
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
            public void s(DataHolder dataHolder) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        parcel.writeInt(1);
                        dataHolder.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
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
            public void t(DataHolder dataHolder) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        parcel.writeInt(1);
                        dataHolder.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(5019, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void u(DataHolder dataHolder) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        parcel.writeInt(1);
                        dataHolder.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(5021, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void v(DataHolder dataHolder) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        parcel.writeInt(1);
                        dataHolder.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
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
            public void w(DataHolder dataHolder) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        parcel.writeInt(1);
                        dataHolder.writeToParcel(parcel, 0);
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
            public void x(DataHolder dataHolder) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        parcel.writeInt(1);
                        dataHolder.writeToParcel(parcel, 0);
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
            public void y(DataHolder dataHolder) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        parcel.writeInt(1);
                        dataHolder.writeToParcel(parcel, 0);
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
            public void z(DataHolder dataHolder) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.games.internal.IGamesCallbacks");
                    if (dataHolder != null) {
                        parcel.writeInt(1);
                        dataHolder.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(5038, parcel, parcel2, 0);
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

