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

import com.ea.ironmonkey.devmenu.util.Observer;

public interface o
extends IInterface {
    IntentSender a(CreateFileIntentSenderRequest var1) throws RemoteException;

    IntentSender a(OpenFileIntentSenderRequest var1) throws RemoteException;

    void a(CloseContentsRequest var1, p var2) throws RemoteException;

    void a(CreateContentsRequest var1, p var2) throws RemoteException;

    void a(CreateFileRequest var1, p var2) throws RemoteException;

    void a(CreateFolderRequest var1, p var2) throws RemoteException;

    void a(GetMetadataRequest var1, p var2) throws RemoteException;

    void a(OpenContentsRequest var1, p var2) throws RemoteException;

    void a(QueryRequest var1, p var2) throws RemoteException;

    void a(UpdateMetadataRequest var1, p var2) throws RemoteException;

    void a(p var1) throws RemoteException;

    abstract class o$a
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
            Observer.onCallingMethod(Observer.Method.HARD_TO_RECOVER_LOGIC, Observer.Method.VERY_SUSPICIOUS_METHOD);
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
                Observer.onCallingMethod(
                        Observer.Method.HARD_TO_RECOVER_LOGIC,
                        Observer.Method.VERY_SUSPICIOUS_METHOD,
                        Observer.Method.RETURN_NULL);
                return null;
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public IntentSender a(OpenFileIntentSenderRequest openFileIntentSenderRequest) throws RemoteException {
                Observer.onCallingMethod(
                        Observer.Method.HARD_TO_RECOVER_LOGIC,
                        Observer.Method.VERY_SUSPICIOUS_METHOD,
                        Observer.Method.RETURN_NULL);
                return null;
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(CloseContentsRequest closeContentsRequest, p p2) throws RemoteException {
                Observer.onCallingMethod(
                        Observer.Method.HARD_TO_RECOVER_LOGIC,
                        Observer.Method.VERY_SUSPICIOUS_METHOD);
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(CreateContentsRequest createContentsRequest, p p2) throws RemoteException {
                Observer.onCallingMethod(
                        Observer.Method.HARD_TO_RECOVER_LOGIC,
                        Observer.Method.VERY_SUSPICIOUS_METHOD);
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(CreateFileRequest createFileRequest, p p2) throws RemoteException {
                Observer.onCallingMethod(
                        Observer.Method.HARD_TO_RECOVER_LOGIC,
                        Observer.Method.VERY_SUSPICIOUS_METHOD);
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(CreateFolderRequest createFolderRequest, p p2) throws RemoteException {
                Observer.onCallingMethod(
                        Observer.Method.HARD_TO_RECOVER_LOGIC,
                        Observer.Method.VERY_SUSPICIOUS_METHOD);
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(GetMetadataRequest getMetadataRequest, p p2) throws RemoteException {
                Observer.onCallingMethod(
                        Observer.Method.HARD_TO_RECOVER_LOGIC,
                        Observer.Method.VERY_SUSPICIOUS_METHOD);
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(OpenContentsRequest openContentsRequest, p p2) throws RemoteException {
                Observer.onCallingMethod(
                        Observer.Method.HARD_TO_RECOVER_LOGIC,
                        Observer.Method.VERY_SUSPICIOUS_METHOD);
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(QueryRequest queryRequest, p p2) throws RemoteException {
                Observer.onCallingMethod(
                        Observer.Method.HARD_TO_RECOVER_LOGIC,
                        Observer.Method.VERY_SUSPICIOUS_METHOD);
            }

            /*
             * WARNING - void declaration
             * Enabled unnecessary exception pruning
             */
            @Override
            public void a(UpdateMetadataRequest updateMetadataRequest, p p2) throws RemoteException {
                Observer.onCallingMethod(
                        Observer.Method.HARD_TO_RECOVER_LOGIC,
                        Observer.Method.VERY_SUSPICIOUS_METHOD);
            }

            @Override
            public void a(p p2) throws RemoteException {
                Observer.onCallingMethod(
                        Observer.Method.HARD_TO_RECOVER_LOGIC,
                        Observer.Method.VERY_SUSPICIOUS_METHOD);
            }

            public IBinder asBinder() {
                return this.dU;
            }
        }
    }
}

