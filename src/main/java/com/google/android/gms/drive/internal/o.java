/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.IntentSender
 *  android.os.Binder
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcel
 *  android.os.RemoteException
 */
package com.google.android.gms.drive.internal;

import android.content.IntentSender;
import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.drive.internal.CloseContentsRequest;
import com.google.android.gms.drive.internal.CreateContentsRequest;
import com.google.android.gms.drive.internal.CreateFileIntentSenderRequest;
import com.google.android.gms.drive.internal.CreateFileRequest;
import com.google.android.gms.drive.internal.CreateFolderRequest;
import com.google.android.gms.drive.internal.GetMetadataRequest;
import com.google.android.gms.drive.internal.OpenContentsRequest;
import com.google.android.gms.drive.internal.OpenFileIntentSenderRequest;
import com.google.android.gms.drive.internal.QueryRequest;
import com.google.android.gms.drive.internal.UpdateMetadataRequest;
import com.google.android.gms.drive.internal.p;

public interface o
extends IInterface {
    public IntentSender a(CreateFileIntentSenderRequest var1) throws RemoteException;

    public IntentSender a(OpenFileIntentSenderRequest var1) throws RemoteException;

    public void a(CloseContentsRequest var1, p var2) throws RemoteException;

    public void a(CreateContentsRequest var1, p var2) throws RemoteException;

    public void a(CreateFileRequest var1, p var2) throws RemoteException;

    public void a(CreateFolderRequest var1, p var2) throws RemoteException;

    public void a(GetMetadataRequest var1, p var2) throws RemoteException;

    public void a(OpenContentsRequest var1, p var2) throws RemoteException;

    public void a(QueryRequest var1, p var2) throws RemoteException;

    public void a(UpdateMetadataRequest var1, p var2) throws RemoteException;

    public void a(p var1) throws RemoteException;

    public static abstract class com.google.android.gms.drive.internal.o$a
    extends Binder
    implements o {
        public static o A(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterface = iBinder.queryLocalInterface("com.google.android.gms.drive.internal.IDriveService");
            if (iInterface == null) return new a(iBinder);
            if (!(iInterface instanceof o)) return new a(iBinder);
            return (o)iInterface;
        }

        public boolean onTransact(int n2, Parcel parcel, Parcel parcel2, int n3) throws RemoteException {
            GetMetadataRequest getMetadataRequest = null;
            GetMetadataRequest getMetadataRequest2 = null;
            GetMetadataRequest getMetadataRequest3 = null;
            GetMetadataRequest getMetadataRequest4 = null;
            GetMetadataRequest getMetadataRequest5 = null;
            GetMetadataRequest getMetadataRequest6 = null;
            GetMetadataRequest getMetadataRequest7 = null;
            GetMetadataRequest getMetadataRequest8 = null;
            GetMetadataRequest getMetadataRequest9 = null;
            SafeParcelable safeParcelable = null;
            switch (n2) {
                default: {
                    return super.onTransact(n2, parcel, parcel2, n3);
                }
                case 1598968902: {
                    parcel2.writeString("com.google.android.gms.drive.internal.IDriveService");
                    return true;
                }
                case 1: {
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    if (parcel.readInt() != 0) {
                        safeParcelable = (GetMetadataRequest)GetMetadataRequest.CREATOR.createFromParcel(parcel);
                    }
                    this.a((GetMetadataRequest)safeParcelable, p.a.B(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 2: {
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    safeParcelable = getMetadataRequest;
                    if (parcel.readInt() != 0) {
                        safeParcelable = (QueryRequest)QueryRequest.CREATOR.createFromParcel(parcel);
                    }
                    this.a((QueryRequest)safeParcelable, p.a.B(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 3: {
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    safeParcelable = getMetadataRequest2;
                    if (parcel.readInt() != 0) {
                        safeParcelable = (UpdateMetadataRequest)UpdateMetadataRequest.CREATOR.createFromParcel(parcel);
                    }
                    this.a((UpdateMetadataRequest)safeParcelable, p.a.B(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 4: {
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    safeParcelable = getMetadataRequest3;
                    if (parcel.readInt() != 0) {
                        safeParcelable = (CreateContentsRequest)CreateContentsRequest.CREATOR.createFromParcel(parcel);
                    }
                    this.a((CreateContentsRequest)safeParcelable, p.a.B(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 5: {
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    safeParcelable = getMetadataRequest4;
                    if (parcel.readInt() != 0) {
                        safeParcelable = (CreateFileRequest)CreateFileRequest.CREATOR.createFromParcel(parcel);
                    }
                    this.a((CreateFileRequest)safeParcelable, p.a.B(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 6: {
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    safeParcelable = getMetadataRequest5;
                    if (parcel.readInt() != 0) {
                        safeParcelable = (CreateFolderRequest)CreateFolderRequest.CREATOR.createFromParcel(parcel);
                    }
                    this.a((CreateFolderRequest)safeParcelable, p.a.B(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 7: {
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    safeParcelable = getMetadataRequest6;
                    if (parcel.readInt() != 0) {
                        safeParcelable = (OpenContentsRequest)OpenContentsRequest.CREATOR.createFromParcel(parcel);
                    }
                    this.a((OpenContentsRequest)safeParcelable, p.a.B(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 8: {
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    safeParcelable = getMetadataRequest7;
                    if (parcel.readInt() != 0) {
                        safeParcelable = (CloseContentsRequest)CloseContentsRequest.CREATOR.createFromParcel(parcel);
                    }
                    this.a((CloseContentsRequest)safeParcelable, p.a.B(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 9: {
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    this.a(p.a.B(parcel.readStrongBinder()));
                    parcel2.writeNoException();
                    return true;
                }
                case 10: {
                    parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
                    safeParcelable = getMetadataRequest8;
                    if (parcel.readInt() != 0) {
                        safeParcelable = (OpenFileIntentSenderRequest)OpenFileIntentSenderRequest.CREATOR.createFromParcel(parcel);
                    }
                    parcel = this.a((OpenFileIntentSenderRequest)safeParcelable);
                    parcel2.writeNoException();
                    if (parcel != null) {
                        parcel2.writeInt(1);
                        parcel.writeToParcel(parcel2, 1);
                        return true;
                    }
                    parcel2.writeInt(0);
                    return true;
                }
                case 11: 
            }
            parcel.enforceInterface("com.google.android.gms.drive.internal.IDriveService");
            safeParcelable = getMetadataRequest9;
            if (parcel.readInt() != 0) {
                safeParcelable = (CreateFileIntentSenderRequest)CreateFileIntentSenderRequest.CREATOR.createFromParcel(parcel);
            }
            parcel = this.a((CreateFileIntentSenderRequest)safeParcelable);
            parcel2.writeNoException();
            if (parcel != null) {
                parcel2.writeInt(1);
                parcel.writeToParcel(parcel2, 1);
                return true;
            }
            parcel2.writeInt(0);
            return true;
        }

        private static class a
        implements o {
            private IBinder dU;

            a(IBinder iBinder) {
                this.dU = iBinder;
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public IntentSender a(CreateFileIntentSenderRequest createFileIntentSenderRequest) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var1_3;
                    parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFileIntentSenderRequest != null) {
                        parcel.writeInt(1);
                        createFileIntentSenderRequest.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(11, parcel, parcel2, 0);
                    parcel2.readException();
                    if (parcel2.readInt() != 0) {
                        IntentSender intentSender = (IntentSender)IntentSender.CREATOR.createFromParcel(parcel2);
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

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public IntentSender a(OpenFileIntentSenderRequest openFileIntentSenderRequest) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var1_3;
                    parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (openFileIntentSenderRequest != null) {
                        parcel.writeInt(1);
                        openFileIntentSenderRequest.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    this.dU.transact(10, parcel, parcel2, 0);
                    parcel2.readException();
                    if (parcel2.readInt() != 0) {
                        IntentSender intentSender = (IntentSender)IntentSender.CREATOR.createFromParcel(parcel2);
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

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(CloseContentsRequest closeContentsRequest, p p2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var1_3;
                    void var2_6;
                    parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (closeContentsRequest != null) {
                        parcel.writeInt(1);
                        closeContentsRequest.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    if (var2_6 != null) {
                        IBinder iBinder = var2_6.asBinder();
                    } else {
                        Object var1_5 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    this.dU.transact(8, parcel, parcel2, 0);
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
            public void a(CreateContentsRequest createContentsRequest, p p2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var1_3;
                    void var2_6;
                    parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createContentsRequest != null) {
                        parcel.writeInt(1);
                        createContentsRequest.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    if (var2_6 != null) {
                        IBinder iBinder = var2_6.asBinder();
                    } else {
                        Object var1_5 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    this.dU.transact(4, parcel, parcel2, 0);
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
            public void a(CreateFileRequest createFileRequest, p p2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var1_3;
                    void var2_6;
                    parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFileRequest != null) {
                        parcel.writeInt(1);
                        createFileRequest.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    if (var2_6 != null) {
                        IBinder iBinder = var2_6.asBinder();
                    } else {
                        Object var1_5 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    this.dU.transact(5, parcel, parcel2, 0);
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
            public void a(CreateFolderRequest createFolderRequest, p p2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var1_3;
                    void var2_6;
                    parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (createFolderRequest != null) {
                        parcel.writeInt(1);
                        createFolderRequest.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    if (var2_6 != null) {
                        IBinder iBinder = var2_6.asBinder();
                    } else {
                        Object var1_5 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    this.dU.transact(6, parcel, parcel2, 0);
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
            public void a(GetMetadataRequest getMetadataRequest, p p2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var1_3;
                    void var2_6;
                    parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (getMetadataRequest != null) {
                        parcel.writeInt(1);
                        getMetadataRequest.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    if (var2_6 != null) {
                        IBinder iBinder = var2_6.asBinder();
                    } else {
                        Object var1_5 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    this.dU.transact(1, parcel, parcel2, 0);
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
            public void a(OpenContentsRequest openContentsRequest, p p2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var1_3;
                    void var2_6;
                    parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (openContentsRequest != null) {
                        parcel.writeInt(1);
                        openContentsRequest.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    if (var2_6 != null) {
                        IBinder iBinder = var2_6.asBinder();
                    } else {
                        Object var1_5 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    this.dU.transact(7, parcel, parcel2, 0);
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
            public void a(QueryRequest queryRequest, p p2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var1_3;
                    void var2_6;
                    parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (queryRequest != null) {
                        parcel.writeInt(1);
                        queryRequest.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    if (var2_6 != null) {
                        IBinder iBinder = var2_6.asBinder();
                    } else {
                        Object var1_5 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    this.dU.transact(2, parcel, parcel2, 0);
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
            public void a(UpdateMetadataRequest updateMetadataRequest, p p2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    void var1_3;
                    void var2_6;
                    parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    if (updateMetadataRequest != null) {
                        parcel.writeInt(1);
                        updateMetadataRequest.writeToParcel(parcel, 0);
                    } else {
                        parcel.writeInt(0);
                    }
                    if (var2_6 != null) {
                        IBinder iBinder = var2_6.asBinder();
                    } else {
                        Object var1_5 = null;
                    }
                    parcel.writeStrongBinder((IBinder)var1_3);
                    this.dU.transact(3, parcel, parcel2, 0);
                    parcel2.readException();
                    return;
                }
                finally {
                    parcel2.recycle();
                    parcel.recycle();
                }
            }

            @Override
            public void a(p p2) throws RemoteException {
                Parcel parcel = Parcel.obtain();
                Parcel parcel2 = Parcel.obtain();
                try {
                    parcel.writeInterfaceToken("com.google.android.gms.drive.internal.IDriveService");
                    p2 = p2 != null ? p2.asBinder() : null;
                    parcel.writeStrongBinder((IBinder)p2);
                    this.dU.transact(9, parcel, parcel2, 0);
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

