/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.PendingIntent
 *  android.content.Context
 *  android.content.Intent
 *  android.location.Location
 *  android.os.Looper
 */
package com.google.android.gms.location;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.os.Looper;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.internal.du;
import com.google.android.gms.internal.fm;
import com.google.android.gms.internal.fn;
import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import java.util.ArrayList;
import java.util.List;

public class LocationClient
implements GooglePlayServicesClient {
    public static final String KEY_LOCATION_CHANGED = "com.google.android.location.LOCATION";
    public static final String KEY_MOCK_LOCATION = "mockLocation";
    private final fm ts;

    public LocationClient(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.ts = new fm(context, connectionCallbacks, onConnectionFailedListener, "location");
    }

    public static int getErrorCode(Intent intent) {
        return intent.getIntExtra("gms_error_code", -1);
    }

    public static int getGeofenceTransition(Intent intent) {
        int n2 = intent.getIntExtra("com.google.android.location.intent.extra.transition", -1);
        if (n2 == -1) {
            return -1;
        }
        if (n2 == 1) return n2;
        if (n2 == 2) return n2;
        if (n2 != 4) return -1;
        return n2;
    }

    public static List<Geofence> getTriggeringGeofences(Intent object) {
        Object object2 = (ArrayList)object.getSerializableExtra("com.google.android.location.intent.extra.geofence_list");
        if (object2 == null) {
            return null;
        }
        object = new ArrayList(((ArrayList)object2).size());
        object2 = ((ArrayList)object2).iterator();
        while (object2.hasNext()) {
            ((ArrayList)object).add(fn.f((byte[])object2.next()));
        }
        return object;
    }

    public static boolean hasError(Intent intent) {
        return intent.hasExtra("gms_error_code");
    }

    public void addGeofences(List<Geofence> object, PendingIntent pendingIntent, OnAddGeofencesResultListener onAddGeofencesResultListener) {
        ArrayList<fn> arrayList = null;
        if (object != null) {
            arrayList = new ArrayList<fn>();
            object = object.iterator();
            while (object.hasNext()) {
                Geofence geofence = (Geofence)object.next();
                du.b(geofence instanceof fn, "Geofence must be created using Geofence.Builder.");
                arrayList.add((fn)geofence);
            }
        }
        this.ts.addGeofences(arrayList, pendingIntent, onAddGeofencesResultListener);
    }

    @Override
    public void connect() {
        this.ts.connect();
    }

    @Override
    public void disconnect() {
        this.ts.disconnect();
    }

    public Location getLastLocation() {
        return this.ts.getLastLocation();
    }

    @Override
    public boolean isConnected() {
        return this.ts.isConnected();
    }

    @Override
    public boolean isConnecting() {
        return this.ts.isConnecting();
    }

    @Override
    public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
        return this.ts.isConnectionCallbacksRegistered(connectionCallbacks);
    }

    @Override
    public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        return this.ts.isConnectionFailedListenerRegistered(onConnectionFailedListener);
    }

    @Override
    public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
        this.ts.registerConnectionCallbacks(connectionCallbacks);
    }

    @Override
    public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.ts.registerConnectionFailedListener(onConnectionFailedListener);
    }

    public void removeGeofences(PendingIntent pendingIntent, OnRemoveGeofencesResultListener onRemoveGeofencesResultListener) {
        this.ts.removeGeofences(pendingIntent, onRemoveGeofencesResultListener);
    }

    public void removeGeofences(List<String> list, OnRemoveGeofencesResultListener onRemoveGeofencesResultListener) {
        this.ts.removeGeofences(list, onRemoveGeofencesResultListener);
    }

    public void removeLocationUpdates(PendingIntent pendingIntent) {
        this.ts.removeLocationUpdates(pendingIntent);
    }

    public void removeLocationUpdates(LocationListener locationListener) {
        this.ts.removeLocationUpdates(locationListener);
    }

    public void requestLocationUpdates(LocationRequest locationRequest, PendingIntent pendingIntent) {
        this.ts.requestLocationUpdates(locationRequest, pendingIntent);
    }

    public void requestLocationUpdates(LocationRequest locationRequest, LocationListener locationListener) {
        this.ts.requestLocationUpdates(locationRequest, locationListener);
    }

    public void requestLocationUpdates(LocationRequest locationRequest, LocationListener locationListener, Looper looper) {
        this.ts.requestLocationUpdates(locationRequest, locationListener, looper);
    }

    public void setMockLocation(Location location) {
        this.ts.setMockLocation(location);
    }

    public void setMockMode(boolean bl2) {
        this.ts.setMockMode(bl2);
    }

    @Override
    public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
        this.ts.unregisterConnectionCallbacks(connectionCallbacks);
    }

    @Override
    public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.ts.unregisterConnectionFailedListener(onConnectionFailedListener);
    }

    public static interface OnAddGeofencesResultListener {
        public void onAddGeofencesResult(int var1, String[] var2);
    }

    public static interface OnRemoveGeofencesResultListener {
        public void onRemoveGeofencesByPendingIntentResult(int var1, PendingIntent var2);

        public void onRemoveGeofencesByRequestIdsResult(int var1, String[] var2);
    }
}

