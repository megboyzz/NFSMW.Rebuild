/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.ActivityManager
 *  android.content.ComponentCallbacks
 *  android.content.ComponentCallbacks2
 *  android.content.Context
 *  android.content.Intent
 *  android.content.res.Configuration
 *  android.graphics.Bitmap
 *  android.graphics.BitmapFactory
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.Looper
 *  android.os.ParcelFileDescriptor
 *  android.os.Parcelable
 *  android.os.ResultReceiver
 *  android.util.Log
 *  android.widget.ImageView
 */
package com.google.android.gms.common.images;

import android.app.ActivityManager;
import android.content.ComponentCallbacks;
import android.content.ComponentCallbacks2;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ParcelFileDescriptor;
import android.os.Parcelable;
import android.os.ResultReceiver;
import android.util.Log;
import android.widget.ImageView;
import com.google.android.gms.common.images.a;
import com.google.android.gms.internal.dg;
import com.google.android.gms.internal.dy;
import com.google.android.gms.internal.es;
import java.io.FileDescriptor;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class ImageManager {
    private static ImageManager lA;
    private static ImageManager lB;
    private static final Object ly;
    private static HashSet<Uri> lz;
    private final ExecutorService lC;
    private final b lD;
    private final Map<com.google.android.gms.common.images.a, ImageReceiver> lE;
    private final Map<Uri, ImageReceiver> lF;
    private final Context mContext;
    private final Handler mHandler;

    static {
        ly = new Object();
        lz = new HashSet();
    }

    private ImageManager(Context context, boolean bl2) {
        this.mContext = context.getApplicationContext();
        this.mHandler = new Handler(Looper.getMainLooper());
        this.lC = Executors.newFixedThreadPool(4);
        if (bl2) {
            this.lD = new b(this.mContext);
            if (es.cn()) {
                this.bm();
            }
        } else {
            this.lD = null;
        }
        this.lE = new HashMap<com.google.android.gms.common.images.a, ImageReceiver>();
        this.lF = new HashMap<Uri, ImageReceiver>();
    }

    private Bitmap a(a.a a2) {
        if (this.lD != null) return (Bitmap)this.lD.get(a2);
        return null;
    }

    public static ImageManager a(Context context, boolean bl2) {
        if (bl2) {
            if (lB != null) return lB;
            lB = new ImageManager(context, true);
            return lB;
        }
        if (lA != null) return lA;
        lA = new ImageManager(context, false);
        return lA;
    }

    private boolean b(com.google.android.gms.common.images.a a2) {
        dg.B("ImageManager.cleanupHashMaps() must be called in the main thread");
        if (a2.lP == 1) {
            return true;
        }
        ImageReceiver imageReceiver = this.lE.get(a2);
        if (imageReceiver == null) {
            return true;
        }
        if (imageReceiver.lH) {
            return false;
        }
        this.lE.remove(a2);
        imageReceiver.d(a2);
        return true;
    }

    private void bm() {
        this.mContext.registerComponentCallbacks((ComponentCallbacks)new e(this.lD));
    }

    public static ImageManager create(Context context) {
        return ImageManager.a(context, false);
    }

    public void a(com.google.android.gms.common.images.a object) {
        dg.B("ImageManager.loadImage() must be called in the main thread");
        boolean bl2 = this.b((com.google.android.gms.common.images.a)object);
        object = new d((com.google.android.gms.common.images.a)object);
        if (bl2) {
            object.run();
            return;
        }
        this.mHandler.post((Runnable)object);
    }

    public void loadImage(ImageView imageView, int n2) {
        com.google.android.gms.common.images.a a2 = new com.google.android.gms.common.images.a(n2);
        a2.a(imageView);
        this.a(a2);
    }

    public void loadImage(ImageView imageView, Uri object) {
        object = new com.google.android.gms.common.images.a((Uri)object);
        ((com.google.android.gms.common.images.a)object).a(imageView);
        this.a((com.google.android.gms.common.images.a)object);
    }

    public void loadImage(ImageView imageView, Uri object, int n2) {
        object = new com.google.android.gms.common.images.a((Uri)object);
        ((com.google.android.gms.common.images.a)object).w(n2);
        ((com.google.android.gms.common.images.a)object).a(imageView);
        this.a((com.google.android.gms.common.images.a)object);
    }

    public void loadImage(OnImageLoadedListener onImageLoadedListener, Uri object) {
        object = new com.google.android.gms.common.images.a((Uri)object);
        ((com.google.android.gms.common.images.a)object).a(onImageLoadedListener);
        this.a((com.google.android.gms.common.images.a)object);
    }

    public void loadImage(OnImageLoadedListener onImageLoadedListener, Uri object, int n2) {
        object = new com.google.android.gms.common.images.a((Uri)object);
        ((com.google.android.gms.common.images.a)object).w(n2);
        ((com.google.android.gms.common.images.a)object).a(onImageLoadedListener);
        this.a((com.google.android.gms.common.images.a)object);
    }

    private final class ImageReceiver
    extends ResultReceiver {
        private final ArrayList<com.google.android.gms.common.images.a> lG;
        boolean lH;
        private final Uri mUri;

        ImageReceiver(Uri uri) {
            super(new Handler(Looper.getMainLooper()));
            this.lH = false;
            this.mUri = uri;
            this.lG = new ArrayList();
        }

        public void bp() {
            Intent intent = new Intent("com.google.android.gms.common.images.LOAD_IMAGE");
            intent.putExtra("com.google.android.gms.extras.uri", (Parcelable)this.mUri);
            intent.putExtra("com.google.android.gms.extras.resultReceiver", (Parcelable)this);
            intent.putExtra("com.google.android.gms.extras.priority", 3);
            ImageManager.this.mContext.sendBroadcast(intent);
        }

        public void c(com.google.android.gms.common.images.a a2) {
            boolean bl2 = !this.lH;
            dg.a(bl2, "Cannot add an ImageRequest when mHandlingRequests is true");
            dg.B("ImageReceiver.addImageRequest() must be called in the main thread");
            this.lG.add(a2);
        }

        public void d(com.google.android.gms.common.images.a a2) {
            boolean bl2 = !this.lH;
            dg.a(bl2, "Cannot remove an ImageRequest when mHandlingRequests is true");
            dg.B("ImageReceiver.removeImageRequest() must be called in the main thread");
            this.lG.remove(a2);
        }

        public void onReceiveResult(int n2, Bundle bundle) {
            bundle = (ParcelFileDescriptor)bundle.getParcelable("com.google.android.gms.extra.fileDescriptor");
            ImageManager.this.lC.execute(new c(this.mUri, (ParcelFileDescriptor)bundle));
        }
    }

    public static interface OnImageLoadedListener {
        public void onImageLoaded(Uri var1, Drawable var2, boolean var3);
    }

    private static final class a {
        static int a(ActivityManager activityManager) {
            return activityManager.getLargeMemoryClass();
        }
    }

    private static final class b
    extends dy<a.a, Bitmap> {
        public b(Context context) {
            super(b.q(context));
        }

        private static int q(Context context) {
            ActivityManager activityManager = (ActivityManager)context.getSystemService("activity");
            int n2 = (context.getApplicationInfo().flags & 0x100000) != 0 ? 1 : 0;
            if (n2 != 0 && es.ck()) {
                n2 = a.a(activityManager);
                return (int)((float)(n2 * 0x100000) * 0.33f);
            }
            n2 = activityManager.getMemoryClass();
            return (int)((float)(n2 * 0x100000) * 0.33f);
        }

        protected int a(a.a a2, Bitmap bitmap) {
            return bitmap.getHeight() * bitmap.getRowBytes();
        }

        protected void a(boolean bl2, a.a a2, Bitmap bitmap, Bitmap bitmap2) {
            super.entryRemoved(bl2, a2, bitmap, bitmap2);
        }

        @Override
        protected /* synthetic */ void entryRemoved(boolean bl2, Object object, Object object2, Object object3) {
            this.a(bl2, (a.a)object, (Bitmap)object2, (Bitmap)object3);
        }

        @Override
        protected /* synthetic */ int sizeOf(Object object, Object object2) {
            return this.a((a.a)object, (Bitmap)object2);
        }
    }

    private final class c
    implements Runnable {
        private final ParcelFileDescriptor lJ;
        private final Uri mUri;

        public c(Uri uri, ParcelFileDescriptor parcelFileDescriptor) {
            this.mUri = uri;
            this.lJ = parcelFileDescriptor;
        }

        @Override
        public void run() {
            dg.C("LoadBitmapFromDiskRunnable can't be executed in the main thread");
            boolean bl2 = false;
            boolean bl3 = false;
            Object object = null;
            CountDownLatch countDownLatch = null;
            if (this.lJ != null) {
                try {
                    object = BitmapFactory.decodeFileDescriptor((FileDescriptor)this.lJ.getFileDescriptor());
                    bl2 = bl3;
                }
                catch (OutOfMemoryError outOfMemoryError) {
                    Log.e((String)"ImageManager", (String)("OOM while loading bitmap for uri: " + this.mUri), (Throwable)outOfMemoryError);
                    bl2 = true;
                    object = countDownLatch;
                }
                try {
                    this.lJ.close();
                }
                catch (IOException iOException) {
                    Log.e((String)"ImageManager", (String)"closed failed", (Throwable)iOException);
                }
            }
            countDownLatch = new CountDownLatch(1);
            ImageManager.this.mHandler.post((Runnable)new f(this.mUri, (Bitmap)object, bl2, countDownLatch));
            try {
                countDownLatch.await();
                return;
            }
            catch (InterruptedException interruptedException) {
                Log.w((String)"ImageManager", (String)("Latch interrupted while posting " + this.mUri));
                return;
            }
        }
    }

    private final class d
    implements Runnable {
        private final com.google.android.gms.common.images.a lK;

        public d(com.google.android.gms.common.images.a a2) {
            this.lK = a2;
        }

        @Override
        public void run() {
            dg.B("LoadImageRunnable must be executed on the main thread");
            ImageManager.this.b(this.lK);
            a.a a2 = this.lK.lM;
            if (a2.uri == null) {
                this.lK.b(ImageManager.this.mContext, true);
                return;
            }
            Object object = ImageManager.this.a(a2);
            if (object != null) {
                this.lK.a(ImageManager.this.mContext, (Bitmap)object, true);
                return;
            }
            this.lK.r(ImageManager.this.mContext);
            Object object2 = (ImageReceiver)((Object)ImageManager.this.lF.get(a2.uri));
            object = object2;
            if (object2 == null) {
                object = new ImageReceiver(a2.uri);
                ImageManager.this.lF.put(a2.uri, object);
            }
            ((ImageReceiver)((Object)object)).c(this.lK);
            if (this.lK.lP != 1) {
                ImageManager.this.lE.put(this.lK, object);
            }
            object2 = ly;
            synchronized (object2) {
                if (lz.contains(a2.uri)) return;
                lz.add(a2.uri);
                ((ImageReceiver)((Object)object)).bp();
                return;
            }
        }
    }

    private static final class e
    implements ComponentCallbacks2 {
        private final b lD;

        public e(b b2) {
            this.lD = b2;
        }

        public void onConfigurationChanged(Configuration configuration) {
        }

        public void onLowMemory() {
            this.lD.evictAll();
        }

        public void onTrimMemory(int n2) {
            if (n2 >= 60) {
                this.lD.evictAll();
                return;
            }
            if (n2 < 20) return;
            this.lD.trimToSize(this.lD.size() / 2);
        }
    }

    private final class f
    implements Runnable {
        private final CountDownLatch kv;
        private boolean lL;
        private final Bitmap mBitmap;
        private final Uri mUri;

        public f(Uri uri, Bitmap bitmap, boolean bl2, CountDownLatch countDownLatch) {
            this.mUri = uri;
            this.mBitmap = bitmap;
            this.lL = bl2;
            this.kv = countDownLatch;
        }

        private void a(ImageReceiver imageReceiver, boolean bl2) {
            imageReceiver.lH = true;
            ArrayList arrayList = imageReceiver.lG;
            int n2 = arrayList.size();
            int n3 = 0;
            while (true) {
                if (n3 >= n2) {
                    imageReceiver.lH = false;
                    return;
                }
                com.google.android.gms.common.images.a a2 = (com.google.android.gms.common.images.a)arrayList.get(n3);
                if (bl2) {
                    a2.a(ImageManager.this.mContext, this.mBitmap, false);
                } else {
                    a2.b(ImageManager.this.mContext, false);
                }
                if (a2.lP != 1) {
                    ImageManager.this.lE.remove(a2);
                }
                ++n3;
            }
        }

        @Override
        public void run() {
            Object object;
            dg.B("OnBitmapLoadedRunnable must be executed in the main thread");
            boolean bl2 = this.mBitmap != null;
            if (ImageManager.this.lD != null) {
                if (this.lL) {
                    ImageManager.this.lD.evictAll();
                    System.gc();
                    this.lL = false;
                    ImageManager.this.mHandler.post((Runnable)this);
                    return;
                }
                if (bl2) {
                    ImageManager.this.lD.put(new a.a(this.mUri), this.mBitmap);
                }
            }
            if ((object = (ImageReceiver)((Object)ImageManager.this.lF.remove(this.mUri))) != null) {
                this.a((ImageReceiver)((Object)object), bl2);
            }
            this.kv.countDown();
            object = ly;
            synchronized (object) {
                lz.remove(this.mUri);
                return;
            }
        }
    }
}

