package com.devmenu.server;

import android.app.IntentService;
import android.app.Notification;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

import com.devmenu.server.impl.FileImpl;
import com.devmenu.server.impl.OptionsImpl;
import com.devmenu.server.impl.PlatformImpl;
import com.devmenu.server.impl.ReplacementImpl;
import com.devmenu.server.impl.SvmwImpl;
import com.devmenu.server.util.UtilitiesAndData;
import com.ea.games.nfs13_na.R;
import com.ea.ironmonkey.Log;

import org.jetbrains.annotations.NotNull;

import ru.megboyzz.api.FileAPI;
import ru.megboyzz.api.OptionsAPI;
import ru.megboyzz.api.PlatformAPI;
import ru.megboyzz.api.ReplacementAPI;
import ru.megboyzz.api.SvmwAPI;
import ru.megboyzz.application.ServerKt;
import ru.megboyzz.factory.ApiFactory;

public class AppService extends IntentService {

    private static final String TAG = "AppService";

    public AppService() {
        super("App");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        int port = 8888;
        String ip = "";
        if(intent != null) {
            port = intent.getIntExtra("port", 8888);
            ip = intent.getStringExtra("ip");
        }else
            Log.i("AppService", "intent is null");
        UtilitiesAndData.init(this);
        Context context = this.getApplicationContext();
        ApiFactory factory = new ApiFactory() {
            @NotNull
            @Override
            public SvmwAPI createSvmwAPI() { return new SvmwImpl(context); }

            @NotNull
            @Override
            public FileAPI createFileAPI() {
                return new FileImpl();
            }

            @NotNull
            @Override
            public OptionsAPI createOptionsAPI() {
                return new OptionsImpl();
            }

            @NotNull
            @Override
            public PlatformAPI createPlatformAPI() {
                return new PlatformImpl(context);
            }

            @NotNull
            @Override
            public ReplacementAPI createReplacementsAPI() {
                return new ReplacementImpl();
            }
        };

        ServerKt.start(
                port,
                factory,
                UtilitiesAndData.getInternalStorage(),
                UtilitiesAndData.getExternalStorage()
        );

        Notification notification =
                new Notification.Builder(this)
                        .setContentTitle("title")
                        .setContentText(ip + ":" + port)
                        .setSmallIcon(R.drawable.icon)
                        .setTicker("ticker")
                        //.addAction()
                        .build();

        startForeground(100, notification);

        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("Service", "Я умир");
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        Log.i(TAG, "О я интент получил, ыыыы");
    }

}
