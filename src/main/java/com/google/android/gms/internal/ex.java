/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.net.LocalSocket
 *  android.net.LocalSocketAddress
 *  android.os.Binder
 *  android.os.Bundle
 *  android.os.IBinder
 *  android.os.IInterface
 *  android.os.Parcelable
 *  android.os.RemoteException
 *  android.view.View
 */
package com.google.android.gms.internal;

import android.content.Context;
import android.content.Intent;
import android.net.LocalSocket;
import android.net.LocalSocketAddress;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcelable;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Releasable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.GameBuffer;
import com.google.android.gms.games.GameEntity;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.PlayerBuffer;
import com.google.android.gms.games.PlayerEntity;
import com.google.android.gms.games.achievement.AchievementBuffer;
import com.google.android.gms.games.achievement.b;
import com.google.android.gms.games.c;
import com.google.android.gms.games.f;
import com.google.android.gms.games.leaderboard.Leaderboard;
import com.google.android.gms.games.leaderboard.LeaderboardBuffer;
import com.google.android.gms.games.leaderboard.LeaderboardScore;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.h;
import com.google.android.gms.games.multiplayer.Invitation;
import com.google.android.gms.games.multiplayer.InvitationBuffer;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.ParticipantUtils;
import com.google.android.gms.games.multiplayer.c;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessage;
import com.google.android.gms.games.multiplayer.realtime.RealTimeMessageReceivedListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomStatusUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.a;
import com.google.android.gms.games.multiplayer.turnbased.LoadMatchesResponse;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatch;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchBuffer;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.b;
import com.google.android.gms.internal.dk;
import com.google.android.gms.internal.dq;
import com.google.android.gms.internal.du;
import com.google.android.gms.internal.ew;
import com.google.android.gms.internal.ez;
import com.google.android.gms.internal.fa;
import com.google.android.gms.internal.fb;
import com.google.android.gms.internal.fc;
import com.google.android.gms.internal.fd;
import com.google.android.gms.internal.fe;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class ex
extends dk<fc>
implements GoogleApiClient.ConnectionCallbacks,
GoogleApiClient.OnConnectionFailedListener {
    private final String jD;
    private boolean qI = false;
    private int qJ;
    private final String qM;
    private final Map<String, fe> qN;
    private PlayerEntity qO;
    private GameEntity qP;
    private final fd qQ;
    private boolean qR = false;
    private final Binder qS;
    private final long qT;
    private final boolean qU;

    public ex(Context context, String string2, String string3, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, String[] stringArray, int n2, View view, boolean bl2, boolean bl3, int n3) {
        super(context, connectionCallbacks, onConnectionFailedListener, stringArray);
        this.qM = string2;
        this.jD = du.f(string3);
        this.qS = new Binder();
        this.qN = new HashMap<String, fe>();
        this.qQ = fd.a(this, n2);
        this.setViewForPopups(view);
        this.qI = bl3;
        this.qJ = n3;
        this.qT = this.hashCode();
        this.qU = bl2;
        this.registerConnectionCallbacks(this);
        this.registerConnectionFailedListener(this);
    }

    private Room D(DataHolder parcelable) {
        com.google.android.gms.games.multiplayer.realtime.b b2 = new com.google.android.gms.games.multiplayer.realtime.b((DataHolder)parcelable);
        parcelable = null;
        try {
            if (b2.getCount() <= 0) return parcelable;
            parcelable = (Room)((Room)b2.get(0)).freeze();
            return parcelable;
        }
        finally {
            b2.close();
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    private fe R(String string2) {
        Object object = ((fc)this.bC()).T(string2);
        if (object == null) {
            return null;
        }
        LocalSocket localSocket = new LocalSocket();
        localSocket.connect(new LocalSocketAddress((String)object));
        object = new fe(localSocket, string2);
        this.qN.put(string2, (fe)object);
        return object;
        {
            catch (RemoteException remoteException) {
                fa.b("GamesClientImpl", "Unable to create socket. Service died.");
                return null;
            }
            catch (IOException iOException) {}
            {
                fa.b("GamesClientImpl", "connect() call failed on socket: " + iOException.getMessage());
                return null;
            }
        }
    }

    private void cL() {
        this.qO = null;
    }

    private void cM() {
        Iterator<fe> iterator = this.qN.values().iterator();
        while (true) {
            if (!iterator.hasNext()) {
                this.qN.clear();
                return;
            }
            fe fe2 = iterator.next();
            try {
                fe2.close();
            }
            catch (IOException iOException) {
                fa.a("GamesClientImpl", "IOException:", iOException);
                continue;
            }
            break;
        }
    }

    protected fc D(IBinder iBinder) {
        return fc.a.F(iBinder);
    }

    public int a(a.a a2, byte[] byArray, String string2, String string3) {
        try {
            return ((fc)this.bC()).a((fb)new an(a2), byArray, string2, string3);
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return -1;
        }
    }

    public int a(byte[] byArray, String string2, String[] stringArray) {
        du.c(stringArray, "Participant IDs must not be null");
        try {
            return ((fc)this.bC()).b(byArray, string2, stringArray);
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return -1;
        }
    }

    @Override
    protected void a(int n2, IBinder iBinder, Bundle bundle) {
        if (n2 == 0 && bundle != null) {
            this.qR = bundle.getBoolean("show_welcome_popup");
        }
        super.a(n2, iBinder, bundle);
    }

    public void a(IBinder iBinder, Bundle bundle) {
        if (!this.isConnected()) return;
        try {
            ((fc)this.bC()).a(iBinder, bundle);
            return;
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
    }

    public void a(a.c<f.a> c2, int n2, boolean bl2, boolean bl3) {
        try {
            ((fc)this.bC()).a((fb)new ak(c2), n2, bl2, bl3);
            return;
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
    }

    public void a(a.c<h.c> c2, LeaderboardScoreBuffer leaderboardScoreBuffer, int n2, int n3) {
        try {
            ((fc)this.bC()).a((fb)new r(c2), leaderboardScoreBuffer.de().df(), n2, n3);
            return;
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
    }

    public void a(a.c<b.b> c2, TurnBasedMatchConfig turnBasedMatchConfig) {
        try {
            ((fc)this.bC()).a((fb)new bb(c2), turnBasedMatchConfig.getVariant(), turnBasedMatchConfig.getMinPlayers(), turnBasedMatchConfig.getInvitedPlayerIds(), turnBasedMatchConfig.getAutoMatchCriteria());
            return;
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
    }

    public void a(a.c<f.a> c2, String string2) {
        try {
            ((fc)this.bC()).c((fb)new ak(c2), string2);
            return;
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
    }

    /*
     * Unable to fully structure code
     */
    public void a(a.c<b.b> var1_1, String var2_3, int var3_4) {
        if (var1_1 != null) ** GOTO lbl-1000
        var1_1 = null;
        try {}
        catch (RemoteException var1_2) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
        ** GOTO lbl9
lbl-1000:
        // 1 sources

        {
            var1_1 = new d((a.c<b.b>)var1_1);
lbl9:
            // 2 sources

            ((fc)this.bC()).a((fb)var1_1, var2_3, var3_4, this.qQ.db(), this.qQ.da());
            return;
        }
    }

    public void a(a.c<h.c> c2, String string2, int n2, int n3, int n4, boolean bl2) {
        try {
            ((fc)this.bC()).a(new r(c2), string2, n2, n3, n4, bl2);
            return;
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
    }

    /*
     * Unable to fully structure code
     */
    public void a(a.c<h.d> var1_1, String var2_3, long var3_4, String var5_5) {
        if (var1_1 != null) ** GOTO lbl-1000
        var1_1 = null;
        try {}
        catch (RemoteException var1_2) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
        ** GOTO lbl9
lbl-1000:
        // 1 sources

        {
            var1_1 = new aw((a.c<h.d>)var1_1);
lbl9:
            // 2 sources

            ((fc)this.bC()).a((fb)var1_1, var2_3, var3_4, var5_5);
            return;
        }
    }

    public void a(a.c<b.c> c2, String string2, String string3) {
        try {
            ((fc)this.bC()).d((fb)new bd(c2), string2, string3);
            return;
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
    }

    public void a(a.c<h.b> c2, String string2, String string3, int n2, int n3) {
        try {
            ((fc)this.bC()).a((fb)new ai(c2), string2, string3, n2, n3);
            return;
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
    }

    public void a(a.c<h.a> c2, String string2, boolean bl2) {
        try {
            ((fc)this.bC()).c((fb)new t(c2), string2, bl2);
            return;
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
    }

    public void a(a.c<b.f> c2, String string2, byte[] byArray, String string3, ParticipantResult[] participantResultArray) {
        try {
            ((fc)this.bC()).a((fb)new bh(c2), string2, byArray, string3, participantResultArray);
            return;
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
    }

    public void a(a.c<b.f> c2, String string2, byte[] byArray, ParticipantResult[] participantResultArray) {
        try {
            ((fc)this.bC()).a((fb)new bh(c2), string2, byArray, participantResultArray);
            return;
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
    }

    public void a(a.c<h.a> c2, boolean bl2) {
        try {
            ((fc)this.bC()).c((fb)new t(c2), bl2);
            return;
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
    }

    public void a(a.c<b.e> c2, int[] nArray) {
        try {
            ((fc)this.bC()).a((fb)new bj(c2), nArray);
            return;
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
    }

    @Override
    protected void a(dq dq2, dk.d d2) throws RemoteException {
        String string2 = this.getContext().getResources().getConfiguration().locale.toString();
        Bundle bundle = new Bundle();
        bundle.putBoolean("com.google.android.gms.games.key.isHeadless", this.qU);
        bundle.putBoolean("com.google.android.gms.games.key.showConnectingPopup", this.qI);
        bundle.putInt("com.google.android.gms.games.key.connectingPopupGravity", this.qJ);
        dq2.a(d2, 4132500, this.getContext().getPackageName(), this.jD, this.bA(), this.qM, this.qQ.db(), string2, bundle);
    }

    @Override
    protected void a(String ... stringArray) {
        boolean bl2 = false;
        boolean bl3 = false;
        for (int i2 = 0; i2 < stringArray.length; ++i2) {
            boolean bl4;
            String string2 = stringArray[i2];
            if (string2.equals("https://www.googleapis.com/auth/games")) {
                bl4 = true;
            } else {
                bl4 = bl3;
                if (string2.equals("https://www.googleapis.com/auth/games.firstparty")) {
                    bl2 = true;
                    bl4 = bl3;
                }
            }
            bl3 = bl4;
        }
        if (!bl2) {
            du.a(bl3, String.format("Games APIs requires %s to function.", "https://www.googleapis.com/auth/games"));
            return;
        }
        bl3 = !bl3;
        du.a(bl3, String.format("Cannot have both %s and %s!", "https://www.googleapis.com/auth/games", "https://www.googleapis.com/auth/games.firstparty"));
    }

    @Override
    protected String am() {
        return "com.google.android.gms.games.service.START";
    }

    @Override
    protected String an() {
        return "com.google.android.gms.games.internal.IGamesService";
    }

    public void b(a.c<Status> c2) {
        try {
            ((fc)this.bC()).a(new au(c2));
            return;
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
    }

    /*
     * Unable to fully structure code
     */
    public void b(a.c<b.b> var1_1, String var2_3) {
        if (var1_1 != null) ** GOTO lbl-1000
        var1_1 = null;
        try {}
        catch (RemoteException var1_2) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
        ** GOTO lbl9
lbl-1000:
        // 1 sources

        {
            var1_1 = new d((a.c<b.b>)var1_1);
lbl9:
            // 2 sources

            ((fc)this.bC()).a((fb)var1_1, var2_3, this.qQ.db(), this.qQ.da());
            return;
        }
    }

    /*
     * Unable to fully structure code
     */
    public void b(a.c<b.b> var1_1, String var2_3, int var3_4) {
        if (var1_1 != null) ** GOTO lbl-1000
        var1_1 = null;
        try {}
        catch (RemoteException var1_2) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
        ** GOTO lbl9
lbl-1000:
        // 1 sources

        {
            var1_1 = new d((a.c<b.b>)var1_1);
lbl9:
            // 2 sources

            ((fc)this.bC()).b((fb)var1_1, var2_3, var3_4, this.qQ.db(), this.qQ.da());
            return;
        }
    }

    public void b(a.c<h.c> c2, String string2, int n2, int n3, int n4, boolean bl2) {
        try {
            ((fc)this.bC()).b(new r(c2), string2, n2, n3, n4, bl2);
            return;
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
    }

    public void b(a.c<b.a> c2, boolean bl2) {
        try {
            ((fc)this.bC()).b((fb)new f(c2), bl2);
            return;
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
    }

    @Override
    public Bundle bc() {
        try {
            Bundle bundle = ((fc)this.bC()).bc();
            if (bundle == null) return bundle;
            bundle.setClassLoader(ex.class.getClassLoader());
            return bundle;
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return null;
        }
    }

    /*
     * Unable to fully structure code
     */
    public void c(a.c<b.b> var1_1, String var2_3) {
        if (var1_1 != null) ** GOTO lbl-1000
        var1_1 = null;
        try {}
        catch (RemoteException var1_2) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
        ** GOTO lbl9
lbl-1000:
        // 1 sources

        {
            var1_1 = new d((a.c<b.b>)var1_1);
lbl9:
            // 2 sources

            ((fc)this.bC()).b((fb)var1_1, var2_3, this.qQ.db(), this.qQ.da());
            return;
        }
    }

    public void cN() {
        if (!this.isConnected()) return;
        try {
            ((fc)this.bC()).cN();
            return;
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
    }

    public void clearNotifications(int n2) {
        try {
            ((fc)this.bC()).clearNotifications(n2);
            return;
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
    }

    @Override
    public void connect() {
        this.cL();
        super.connect();
    }

    public void createRoom(RoomConfig roomConfig) {
        try {
            aq aq2 = new aq(roomConfig.getRoomUpdateListener(), roomConfig.getRoomStatusUpdateListener(), roomConfig.getMessageReceivedListener());
            ((fc)this.bC()).a((fb)aq2, (IBinder)this.qS, roomConfig.getVariant(), roomConfig.getInvitedPlayerIds(), roomConfig.getAutoMatchCriteria(), roomConfig.isSocketEnabled(), this.qT);
            return;
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
    }

    public void d(a.c<c.a> c2) {
        try {
            ((fc)this.bC()).d(new j(c2));
            return;
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
    }

    public void d(a.c<b.b> c2, String string2) {
        try {
            ((fc)this.bC()).n(new bb(c2), string2);
            return;
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
    }

    @Override
    public void disconnect() {
        this.qR = false;
        if (this.isConnected()) {
            try {
                fc fc2 = (fc)this.bC();
                fc2.cN();
                fc2.f(this.qT);
            }
            catch (RemoteException remoteException) {
                fa.a("GamesClientImpl", "Failed to notify client disconnect.");
            }
        }
        this.cM();
        super.disconnect();
    }

    public void dismissTurnBasedMatch(String string2) {
        try {
            ((fc)this.bC()).X(string2);
            return;
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
    }

    public void e(a.c<c.a> c2) {
        try {
            ((fc)this.bC()).e(new o(c2));
            return;
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
    }

    public void e(a.c<b.b> c2, String string2) {
        try {
            ((fc)this.bC()).o(new bb(c2), string2);
            return;
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
    }

    public void f(a.c<b.c> c2, String string2) {
        try {
            ((fc)this.bC()).q(new bd(c2), string2);
            return;
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
    }

    public void g(a.c<b.a> c2, String string2) {
        try {
            ((fc)this.bC()).p(new az(c2), string2);
            return;
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
    }

    public Intent getAchievementsIntent() {
        this.bB();
        Intent intent = new Intent("com.google.android.gms.games.VIEW_ACHIEVEMENTS");
        intent.addFlags(0x4000000);
        return ez.c(intent);
    }

    public Intent getAllLeaderboardsIntent() {
        this.bB();
        Intent intent = new Intent("com.google.android.gms.games.VIEW_LEADERBOARDS");
        intent.putExtra("com.google.android.gms.games.GAME_PACKAGE_NAME", this.qM);
        intent.addFlags(0x4000000);
        return ez.c(intent);
    }

    public String getAppId() {
        try {
            return ((fc)this.bC()).getAppId();
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return null;
        }
    }

    public String getCurrentAccountName() {
        try {
            return ((fc)this.bC()).getCurrentAccountName();
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return null;
        }
    }

    /*
     * Loose catch block
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public Game getCurrentGame() {
        Object object;
        block9: {
            this.bB();
            // MONITORENTER : this
            object = this.qP;
            if (object != null) return this.qP;
            object = new GameBuffer(((fc)this.bC()).cX());
            {
                catch (RemoteException remoteException) {
                    fa.a("GamesClientImpl", "service died");
                    return this.qP;
                }
            }
            if (((DataBuffer)object).getCount() <= 0) break block9;
            this.qP = (GameEntity)((GameBuffer)object).get(0).freeze();
        }
        ((DataBuffer)object).close();
        // MONITOREXIT : this
        return this.qP;
        catch (Throwable throwable) {
            ((DataBuffer)object).close();
            throw throwable;
        }
    }

    /*
     * Loose catch block
     * Enabled unnecessary exception pruning
     * Converted monitor instructions to comments
     */
    public Player getCurrentPlayer() {
        Object object;
        block9: {
            this.bB();
            // MONITORENTER : this
            object = this.qO;
            if (object != null) return this.qO;
            object = new PlayerBuffer(((fc)this.bC()).cV());
            {
                catch (RemoteException remoteException) {
                    fa.a("GamesClientImpl", "service died");
                    return this.qO;
                }
            }
            if (((DataBuffer)object).getCount() <= 0) break block9;
            this.qO = (PlayerEntity)((PlayerBuffer)object).get(0).freeze();
        }
        ((DataBuffer)object).close();
        // MONITOREXIT : this
        return this.qO;
        catch (Throwable throwable) {
            ((DataBuffer)object).close();
            throw throwable;
        }
    }

    public String getCurrentPlayerId() {
        try {
            return ((fc)this.bC()).getCurrentPlayerId();
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return null;
        }
    }

    public Intent getInvitationInboxIntent() {
        this.bB();
        Intent intent = new Intent("com.google.android.gms.games.SHOW_INVITATIONS");
        intent.putExtra("com.google.android.gms.games.GAME_PACKAGE_NAME", this.qM);
        return ez.c(intent);
    }

    public Intent getLeaderboardIntent(String string2) {
        this.bB();
        Intent intent = new Intent("com.google.android.gms.games.VIEW_LEADERBOARD_SCORES");
        intent.putExtra("com.google.android.gms.games.LEADERBOARD_ID", string2);
        intent.addFlags(0x4000000);
        return ez.c(intent);
    }

    public Intent getMatchInboxIntent() {
        this.bB();
        Intent intent = new Intent("com.google.android.gms.games.SHOW_MULTIPLAYER_INBOX");
        intent.putExtra("com.google.android.gms.games.GAME_PACKAGE_NAME", this.qM);
        return ez.c(intent);
    }

    public int getMaxTurnBasedMatchDataSize() {
        try {
            return ((fc)this.bC()).getMaxTurnBasedMatchDataSize();
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return 2;
        }
    }

    public Intent getPlayerSearchIntent() {
        this.bB();
        return ez.c(new Intent("com.google.android.gms.games.PLAYER_SEARCH"));
    }

    public RealTimeSocket getRealTimeSocketForParticipant(String object, String string2) {
        if (string2 == null) throw new IllegalArgumentException("Bad participant ID");
        if (!ParticipantUtils.Y(string2)) {
            throw new IllegalArgumentException("Bad participant ID");
        }
        fe fe2 = this.qN.get(string2);
        if (fe2 == null) return this.R(string2);
        object = fe2;
        if (!fe2.isClosed()) return object;
        return this.R(string2);
    }

    public Intent getRealTimeWaitingRoomIntent(Room room, int n2) {
        this.bB();
        Intent intent = new Intent("com.google.android.gms.games.SHOW_REAL_TIME_WAITING_ROOM");
        du.c(room, "Room parameter must not be null");
        intent.putExtra("room", (Parcelable)room.freeze());
        boolean bl2 = n2 >= 0;
        du.a(bl2, "minParticipantsToStart must be >= 0");
        intent.putExtra("com.google.android.gms.games.MIN_PARTICIPANTS_TO_START", n2);
        return ez.c(intent);
    }

    public Intent getSelectPlayersIntent(int n2, int n3, boolean bl2) {
        this.bB();
        Intent intent = new Intent("com.google.android.gms.games.SELECT_PLAYERS");
        intent.putExtra("com.google.android.gms.games.MIN_SELECTIONS", n2);
        intent.putExtra("com.google.android.gms.games.MAX_SELECTIONS", n3);
        intent.putExtra("com.google.android.gms.games.SHOW_AUTOMATCH", bl2);
        return ez.c(intent);
    }

    public Intent getSettingsIntent() {
        this.bB();
        Intent intent = new Intent("com.google.android.gms.games.SHOW_SETTINGS");
        intent.putExtra("com.google.android.gms.games.GAME_PACKAGE_NAME", this.qM);
        intent.addFlags(0x4000000);
        return ez.c(intent);
    }

    public void h(a.c<b.d> c2, String string2) {
        try {
            ((fc)this.bC()).r(new bf(c2), string2);
            return;
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
    }

    public void h(String string2, int n2) {
        try {
            ((fc)this.bC()).h(string2, n2);
            return;
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
    }

    public void i(String string2, int n2) {
        try {
            ((fc)this.bC()).i(string2, n2);
            return;
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
    }

    public void joinRoom(RoomConfig roomConfig) {
        try {
            aq aq2 = new aq(roomConfig.getRoomUpdateListener(), roomConfig.getRoomStatusUpdateListener(), roomConfig.getMessageReceivedListener());
            ((fc)this.bC()).a((fb)aq2, (IBinder)this.qS, roomConfig.getInvitationId(), roomConfig.isSocketEnabled(), this.qT);
            return;
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
    }

    public void leaveRoom(RoomUpdateListener roomUpdateListener, String string2) {
        try {
            ((fc)this.bC()).e(new aq(roomUpdateListener), string2);
            this.cM();
            return;
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
    }

    @Override
    public void onConnected(Bundle bundle) {
        if (!this.qR) return;
        this.qQ.cZ();
        this.qR = false;
    }

    @Override
    public void onConnectionFailed(ConnectionResult connectionResult) {
        this.qR = false;
    }

    @Override
    public void onDisconnected() {
    }

    @Override
    protected /* synthetic */ IInterface p(IBinder iBinder) {
        return this.D(iBinder);
    }

    public void registerInvitationListener(OnInvitationReceivedListener object) {
        try {
            object = new l((OnInvitationReceivedListener)object);
            ((fc)this.bC()).a((fb)object, this.qT);
            return;
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
    }

    public void registerMatchUpdateListener(OnTurnBasedMatchUpdateReceivedListener object) {
        try {
            object = new x((OnTurnBasedMatchUpdateReceivedListener)object);
            ((fc)this.bC()).b((fb)object, this.qT);
            return;
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
    }

    public int sendUnreliableRealTimeMessageToAll(byte[] byArray, String string2) {
        try {
            return ((fc)this.bC()).b(byArray, string2, null);
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return -1;
        }
    }

    public void setGravityForPopups(int n2) {
        this.qQ.setGravity(n2);
    }

    public void setViewForPopups(View view) {
        this.qQ.e(view);
    }

    public void unregisterInvitationListener() {
        try {
            ((fc)this.bC()).g(this.qT);
            return;
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
    }

    public void unregisterMatchUpdateListener() {
        try {
            ((fc)this.bC()).h(this.qT);
            return;
        }
        catch (RemoteException remoteException) {
            fa.a("GamesClientImpl", "service died");
            return;
        }
    }

    abstract class a
    extends c {
        private final ArrayList<String> qV;

        a(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder, String[] stringArray) {
            super(roomStatusUpdateListener, dataHolder);
            this.qV = new ArrayList();
            int n2 = 0;
            int n3 = stringArray.length;
            while (n2 < n3) {
                this.qV.add(stringArray[n2]);
                ++n2;
            }
        }

        @Override
        protected void a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            this.a(roomStatusUpdateListener, room, this.qV);
        }

        protected abstract void a(RoomStatusUpdateListener var1, Room var2, ArrayList<String> var3);
    }

    final class aa
    extends dk.b<RoomStatusUpdateListener> {
        private final String rm;

        aa(RoomStatusUpdateListener roomStatusUpdateListener, String string2) {
            super(roomStatusUpdateListener);
            this.rm = string2;
        }

        public void a(RoomStatusUpdateListener roomStatusUpdateListener) {
            if (roomStatusUpdateListener == null) return;
            roomStatusUpdateListener.onP2PConnected(this.rm);
        }

        @Override
        protected void aQ() {
        }

        @Override
        public /* synthetic */ void b(Object object) {
            this.a((RoomStatusUpdateListener)object);
        }
    }

    final class ab
    extends dk.b<RoomStatusUpdateListener> {
        private final String rm;

        ab(RoomStatusUpdateListener roomStatusUpdateListener, String string2) {
            super(roomStatusUpdateListener);
            this.rm = string2;
        }

        public void a(RoomStatusUpdateListener roomStatusUpdateListener) {
            if (roomStatusUpdateListener == null) return;
            roomStatusUpdateListener.onP2PDisconnected(this.rm);
        }

        @Override
        protected void aQ() {
        }

        @Override
        public /* synthetic */ void b(Object object) {
            this.a((RoomStatusUpdateListener)object);
        }
    }

    final class ac
    extends a {
        ac(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder, String[] stringArray) {
            super(roomStatusUpdateListener, dataHolder, stringArray);
        }

        @Override
        protected void a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersConnected(room, arrayList);
        }
    }

    final class ad
    extends a {
        ad(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder, String[] stringArray) {
            super(roomStatusUpdateListener, dataHolder, stringArray);
        }

        @Override
        protected void a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerDeclined(room, arrayList);
        }
    }

    final class ae
    extends a {
        ae(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder, String[] stringArray) {
            super(roomStatusUpdateListener, dataHolder, stringArray);
        }

        @Override
        protected void a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeersDisconnected(room, arrayList);
        }
    }

    final class af
    extends a {
        af(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder, String[] stringArray) {
            super(roomStatusUpdateListener, dataHolder, stringArray);
        }

        @Override
        protected void a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerInvitedToRoom(room, arrayList);
        }
    }

    final class ag
    extends a {
        ag(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder, String[] stringArray) {
            super(roomStatusUpdateListener, dataHolder, stringArray);
        }

        @Override
        protected void a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerJoined(room, arrayList);
        }
    }

    final class ah
    extends a {
        ah(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder, String[] stringArray) {
            super(roomStatusUpdateListener, dataHolder, stringArray);
        }

        @Override
        protected void a(RoomStatusUpdateListener roomStatusUpdateListener, Room room, ArrayList<String> arrayList) {
            roomStatusUpdateListener.onPeerLeft(room, arrayList);
        }
    }

    final class ai
    extends ew {
        private final a.c<h.b> jN;

        ai(a.c<h.b> c2) {
            this.jN = du.c(c2, "Holder must not be null");
        }

        @Override
        public void C(DataHolder dataHolder) {
            ex.this.a(new aj(this.jN, dataHolder));
        }
    }

    final class aj
    extends dk.c<a.c<h.b>>
    implements h.b {
        private final Status jP;
        private final com.google.android.gms.games.leaderboard.d rn;

        aj(a.c<h.b> c2, DataHolder dataHolder) {
            super(c2, dataHolder);
            this.jP = new Status(dataHolder.getStatusCode());
            ex.this = new LeaderboardScoreBuffer(dataHolder);
            try {
                if (((DataBuffer)ex.this).getCount() > 0) {
                    this.rn = (com.google.android.gms.games.leaderboard.d)((LeaderboardScoreBuffer)ex.this).get(0).freeze();
                    return;
                }
                this.rn = null;
                return;
            }
            finally {
                ((DataBuffer)ex.this).close();
            }
        }

        @Override
        protected void a(a.c<h.b> c2, DataHolder dataHolder) {
            c2.a(this);
        }

        @Override
        public LeaderboardScore cR() {
            return this.rn;
        }

        @Override
        public Status getStatus() {
            return this.jP;
        }
    }

    final class ak
    extends ew {
        private final a.c<f.a> jN;

        ak(a.c<f.a> c2) {
            this.jN = du.c(c2, "Holder must not be null");
        }

        @Override
        public void e(DataHolder dataHolder) {
            ex.this.a(new al(this.jN, dataHolder));
        }
    }

    final class al
    extends ao<a.c<f.a>>
    implements f.a {
        private final PlayerBuffer ro;

        al(a.c<f.a> c2, DataHolder dataHolder) {
            super(ex.this, c2, dataHolder);
            this.ro = new PlayerBuffer(dataHolder);
        }

        @Override
        protected void a(a.c<f.a> c2, DataHolder dataHolder) {
            c2.a(this);
        }

        @Override
        public PlayerBuffer cJ() {
            return this.ro;
        }
    }

    final class am
    extends dk.b<a.a> {
        private final int ka;
        private final String rp;
        private final int rq;

        am(a.a a2, int n2, int n3, String string2) {
            super(a2);
            this.ka = n2;
            this.rq = n3;
            this.rp = string2;
        }

        public void a(a.a a2) {
            if (a2 == null) return;
            a2.onRealTimeMessageSent(this.ka, this.rq, this.rp);
        }

        @Override
        protected void aQ() {
        }

        @Override
        public /* synthetic */ void b(Object object) {
            this.a((a.a)object);
        }
    }

    final class an
    extends ew {
        final a.a rr;

        public an(a.a a2) {
            this.rr = a2;
        }

        @Override
        public void b(int n2, int n3, String string2) {
            ex.this.a(new am(this.rr, n2, n3, string2));
        }
    }

    static abstract class ao<R extends a.c<?>>
    extends dk.c<R>
    implements Releasable,
    Result {
        final Status jP;
        final DataHolder lb;
        final /* synthetic */ ex qW;

        public ao(R r2, DataHolder dataHolder) {
            this.qW = var1_1;
            super(r2, dataHolder);
            this.jP = new Status(dataHolder.getStatusCode());
            this.lb = dataHolder;
        }

        @Override
        public Status getStatus() {
            return this.jP;
        }

        @Override
        public void release() {
            if (this.lb == null) return;
            this.lb.close();
        }
    }

    final class ap
    extends c {
        ap(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            super(roomStatusUpdateListener, dataHolder);
        }

        @Override
        public void a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomAutoMatching(room);
        }
    }

    final class aq
    extends ew {
        private final RoomUpdateListener rs;
        private final RoomStatusUpdateListener rt;
        private final RealTimeMessageReceivedListener ru;

        public aq(RoomUpdateListener roomUpdateListener) {
            this.rs = du.c(roomUpdateListener, "Callbacks must not be null");
            this.rt = null;
            this.ru = null;
        }

        public aq(RoomUpdateListener roomUpdateListener, RoomStatusUpdateListener roomStatusUpdateListener, RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            this.rs = du.c(roomUpdateListener, "Callbacks must not be null");
            this.rt = roomStatusUpdateListener;
            this.ru = realTimeMessageReceivedListener;
        }

        @Override
        public void a(DataHolder dataHolder, String[] stringArray) {
            ex.this.a(new af(this.rt, dataHolder, stringArray));
        }

        @Override
        public void b(DataHolder dataHolder, String[] stringArray) {
            ex.this.a(new ag(this.rt, dataHolder, stringArray));
        }

        @Override
        public void c(DataHolder dataHolder, String[] stringArray) {
            ex.this.a(new ah(this.rt, dataHolder, stringArray));
        }

        @Override
        public void d(DataHolder dataHolder, String[] stringArray) {
            ex.this.a(new ad(this.rt, dataHolder, stringArray));
        }

        @Override
        public void e(DataHolder dataHolder, String[] stringArray) {
            ex.this.a(new ac(this.rt, dataHolder, stringArray));
        }

        @Override
        public void f(DataHolder dataHolder, String[] stringArray) {
            ex.this.a(new ae(this.rt, dataHolder, stringArray));
        }

        @Override
        public void onLeftRoom(int n2, String string2) {
            ex.this.a(new v(this.rs, n2, string2));
        }

        @Override
        public void onP2PConnected(String string2) {
            ex.this.a(new aa(this.rt, string2));
        }

        @Override
        public void onP2PDisconnected(String string2) {
            ex.this.a(new ab(this.rt, string2));
        }

        @Override
        public void onRealTimeMessageReceived(RealTimeMessage realTimeMessage) {
            ex.this.a(new z(this.ru, realTimeMessage));
        }

        @Override
        public void s(DataHolder dataHolder) {
            ex.this.a(new at(this.rs, dataHolder));
        }

        @Override
        public void t(DataHolder dataHolder) {
            ex.this.a(new q(this.rs, dataHolder));
        }

        @Override
        public void u(DataHolder dataHolder) {
            ex.this.a(new as(this.rt, dataHolder));
        }

        @Override
        public void v(DataHolder dataHolder) {
            ex.this.a(new ap(this.rt, dataHolder));
        }

        @Override
        public void w(DataHolder dataHolder) {
            ex.this.a(new ar(this.rs, dataHolder));
        }

        @Override
        public void x(DataHolder dataHolder) {
            ex.this.a(new h(this.rt, dataHolder));
        }

        @Override
        public void y(DataHolder dataHolder) {
            ex.this.a(new i(this.rt, dataHolder));
        }
    }

    final class ar
    extends b {
        ar(RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            super(roomUpdateListener, dataHolder);
        }

        @Override
        public void a(RoomUpdateListener roomUpdateListener, Room room, int n2) {
            roomUpdateListener.onRoomConnected(n2, room);
        }
    }

    final class as
    extends c {
        as(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            super(roomStatusUpdateListener, dataHolder);
        }

        @Override
        public void a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onRoomConnecting(room);
        }
    }

    final class at
    extends b {
        public at(RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            super(roomUpdateListener, dataHolder);
        }

        @Override
        public void a(RoomUpdateListener roomUpdateListener, Room room, int n2) {
            roomUpdateListener.onRoomCreated(n2, room);
        }
    }

    final class au
    extends ew {
        private final a.c<Status> jN;

        public au(a.c<Status> c2) {
            this.jN = du.c(c2, "Holder must not be null");
        }

        @Override
        public void onSignOutComplete() {
            Status status = new Status(0);
            ex.this.a(new av(this.jN, status));
        }
    }

    final class av
    extends dk.b<a.c<Status>> {
        private final Status jP;

        public av(a.c<Status> c2, Status status) {
            super(c2);
            this.jP = status;
        }

        @Override
        protected void aQ() {
        }

        @Override
        public /* synthetic */ void b(Object object) {
            this.c((a.c)object);
        }

        public void c(a.c<Status> c2) {
            c2.a(this.jP);
        }
    }

    final class aw
    extends ew {
        private final a.c<h.d> jN;

        public aw(a.c<h.d> c2) {
            this.jN = du.c(c2, "Holder must not be null");
        }

        @Override
        public void d(DataHolder dataHolder) {
            ex.this.a(new ax(this.jN, dataHolder));
        }
    }

    final class ax
    extends ao<a.c<h.d>>
    implements h.d {
        private final com.google.android.gms.games.leaderboard.i rv;

        public ax(a.c<h.d> c2, DataHolder dataHolder) {
            super(ex.this, c2, dataHolder);
            this.rv = new com.google.android.gms.games.leaderboard.i(dataHolder);
        }

        @Override
        public void a(a.c<h.d> c2, DataHolder dataHolder) {
            c2.a(this);
        }

        @Override
        public com.google.android.gms.games.leaderboard.i cS() {
            return this.rv;
        }
    }

    static abstract class ay<T extends a.c<?>>
    extends ao<T> {
        final /* synthetic */ ex qW;
        final TurnBasedMatch rk;

        /*
         * WARNING - Possible parameter corruption
         */
        ay(T t2, DataHolder dataHolder) {
            this.qW = turnBasedMatchBuffer;
            super((ex)((Object)turnBasedMatchBuffer), t2, dataHolder);
            turnBasedMatchBuffer = new TurnBasedMatchBuffer(dataHolder);
            try {
                if (turnBasedMatchBuffer.getCount() > 0) {
                    this.rk = (TurnBasedMatch)((TurnBasedMatch)turnBasedMatchBuffer.get(0)).freeze();
                    return;
                }
                this.rk = null;
                return;
            }
            finally {
                turnBasedMatchBuffer.close();
            }
        }

        @Override
        protected void a(T t2, DataHolder dataHolder) {
            this.f(t2);
        }

        public TurnBasedMatch cT() {
            return this.rk;
        }

        abstract void f(T var1);
    }

    final class az
    extends ew {
        private final a.c<b.a> rw;

        public az(a.c<b.a> c2) {
            this.rw = du.c(c2, "Holder must not be null");
        }

        @Override
        public void onTurnBasedMatchCanceled(int n2, String string2) {
            Status status = new Status(n2);
            ex.this.a(new ba(this.rw, status, string2));
        }
    }

    abstract class b
    extends dk.c<RoomUpdateListener> {
        b(RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            super(roomUpdateListener, dataHolder);
        }

        @Override
        protected void a(RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            this.a(roomUpdateListener, ex.this.D(dataHolder), dataHolder.getStatusCode());
        }

        protected abstract void a(RoomUpdateListener var1, Room var2, int var3);
    }

    final class ba
    extends dk.b<a.c<b.a>>
    implements b.a {
        private final Status jP;
        private final String rx;

        ba(a.c<b.a> c2, Status status, String string2) {
            super(c2);
            this.jP = status;
            this.rx = string2;
        }

        @Override
        protected void aQ() {
        }

        @Override
        public /* synthetic */ void b(Object object) {
            this.c((a.c)object);
        }

        public void c(a.c<b.a> c2) {
            c2.a(this);
        }

        @Override
        public String getMatchId() {
            return this.rx;
        }

        @Override
        public Status getStatus() {
            return this.jP;
        }
    }

    final class bb
    extends ew {
        private final a.c<b.b> ry;

        public bb(a.c<b.b> c2) {
            this.ry = du.c(c2, "Holder must not be null");
        }

        @Override
        public void m(DataHolder dataHolder) {
            ex.this.a(new bc(this.ry, dataHolder));
        }
    }

    final class bc
    extends ay<a.c<b.b>>
    implements b.b {
        bc(a.c<b.b> c2, DataHolder dataHolder) {
            super(ex.this, c2, dataHolder);
        }

        @Override
        protected void f(a.c<b.b> c2) {
            c2.a(this);
        }
    }

    final class bd
    extends ew {
        private final a.c<b.c> rz;

        public bd(a.c<b.c> c2) {
            this.rz = du.c(c2, "Holder must not be null");
        }

        @Override
        public void o(DataHolder dataHolder) {
            ex.this.a(new be(this.rz, dataHolder));
        }
    }

    final class be
    extends ay<a.c<b.c>>
    implements b.c {
        be(a.c<b.c> c2, DataHolder dataHolder) {
            super(ex.this, c2, dataHolder);
        }

        @Override
        protected void f(a.c<b.c> c2) {
            c2.a(this);
        }
    }

    final class bf
    extends ew {
        private final a.c<b.d> rA;

        public bf(a.c<b.d> c2) {
            this.rA = du.c(c2, "Holder must not be null");
        }

        @Override
        public void l(DataHolder dataHolder) {
            ex.this.a(new bg(this.rA, dataHolder));
        }
    }

    final class bg
    extends ay<a.c<b.d>>
    implements b.d {
        bg(a.c<b.d> c2, DataHolder dataHolder) {
            super(ex.this, c2, dataHolder);
        }

        @Override
        protected void f(a.c<b.d> c2) {
            c2.a(this);
        }
    }

    final class bh
    extends ew {
        private final a.c<b.f> rB;

        public bh(a.c<b.f> c2) {
            this.rB = du.c(c2, "Holder must not be null");
        }

        @Override
        public void n(DataHolder dataHolder) {
            ex.this.a(new bi(this.rB, dataHolder));
        }
    }

    final class bi
    extends ay<a.c<b.f>>
    implements b.f {
        bi(a.c<b.f> c2, DataHolder dataHolder) {
            super(ex.this, c2, dataHolder);
        }

        @Override
        protected void f(a.c<b.f> c2) {
            c2.a(this);
        }
    }

    final class bj
    extends ew {
        private final a.c<b.e> rC;

        public bj(a.c<b.e> c2) {
            this.rC = du.c(c2, "Holder must not be null");
        }

        @Override
        public void a(int n2, Bundle bundle) {
            bundle.setClassLoader(this.getClass().getClassLoader());
            Status status = new Status(n2);
            ex.this.a(new bk(this.rC, status, bundle));
        }
    }

    final class bk
    extends dk.b<a.c<b.e>>
    implements b.e {
        private final Status jP;
        private final Bundle rD;
        private final LoadMatchesResponse rE;

        bk(a.c<b.e> c2, Status status, Bundle bundle) {
            super(c2);
            this.jP = status;
            this.rD = bundle;
            this.rE = new LoadMatchesResponse(bundle);
        }

        @Override
        protected void aQ() {
            this.release();
        }

        @Override
        protected /* synthetic */ void b(Object object) {
            this.c((a.c)object);
        }

        protected void c(a.c<b.e> c2) {
            c2.a(this);
        }

        @Override
        public LoadMatchesResponse cU() {
            return this.rE;
        }

        @Override
        public Status getStatus() {
            return this.jP;
        }

        @Override
        public void release() {
            Iterator iterator = this.rD.keySet().iterator();
            while (iterator.hasNext()) {
                Object object = (String)iterator.next();
                if ((object = (DataHolder)this.rD.getParcelable((String)object)) == null) continue;
                ((DataHolder)object).close();
            }
        }
    }

    abstract class c
    extends dk.c<RoomStatusUpdateListener> {
        c(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            super(roomStatusUpdateListener, dataHolder);
        }

        @Override
        protected void a(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            this.a(roomStatusUpdateListener, ex.this.D(dataHolder));
        }

        protected abstract void a(RoomStatusUpdateListener var1, Room var2);
    }

    final class d
    extends ew {
        private final a.c<b.b> jN;

        d(a.c<b.b> c2) {
            this.jN = du.c(c2, "Holder must not be null");
        }

        @Override
        public void onAchievementUpdated(int n2, String string2) {
            ex.this.a(new e(this.jN, n2, string2));
        }
    }

    final class e
    extends dk.b<a.c<b.b>>
    implements b.b {
        private final Status jP;
        private final String qX;

        e(a.c<b.b> c2, int n2, String string2) {
            super(c2);
            this.jP = new Status(n2);
            this.qX = string2;
        }

        @Override
        protected void aQ() {
        }

        @Override
        protected /* synthetic */ void b(Object object) {
            this.c((a.c)object);
        }

        protected void c(a.c<b.b> c2) {
            c2.a(this);
        }

        @Override
        public String getAchievementId() {
            return this.qX;
        }

        @Override
        public Status getStatus() {
            return this.jP;
        }
    }

    final class f
    extends ew {
        private final a.c<b.a> jN;

        f(a.c<b.a> c2) {
            this.jN = du.c(c2, "Holder must not be null");
        }

        @Override
        public void b(DataHolder dataHolder) {
            ex.this.a(new g(this.jN, dataHolder));
        }
    }

    final class g
    extends ao<a.c<b.a>>
    implements b.a {
        private final AchievementBuffer qY;

        g(a.c<b.a> c2, DataHolder dataHolder) {
            super(ex.this, c2, dataHolder);
            this.qY = new AchievementBuffer(dataHolder);
        }

        @Override
        protected void a(a.c<b.a> c2, DataHolder dataHolder) {
            c2.a(this);
        }

        @Override
        public AchievementBuffer cK() {
            return this.qY;
        }
    }

    final class h
    extends c {
        h(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            super(roomStatusUpdateListener, dataHolder);
        }

        @Override
        public void a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onConnectedToRoom(room);
        }
    }

    final class i
    extends c {
        i(RoomStatusUpdateListener roomStatusUpdateListener, DataHolder dataHolder) {
            super(roomStatusUpdateListener, dataHolder);
        }

        @Override
        public void a(RoomStatusUpdateListener roomStatusUpdateListener, Room room) {
            roomStatusUpdateListener.onDisconnectedFromRoom(room);
        }
    }

    final class j
    extends ew {
        private final a.c<c.a> jN;

        j(a.c<c.a> c2) {
            this.jN = du.c(c2, "Holder must not be null");
        }

        @Override
        public void g(DataHolder dataHolder) {
            ex.this.a(new k(this.jN, dataHolder));
        }
    }

    final class k
    extends ao<a.c<c.a>>
    implements c.a {
        private final GameBuffer qZ;

        k(a.c<c.a> c2, DataHolder dataHolder) {
            super(ex.this, c2, dataHolder);
            this.qZ = new GameBuffer(dataHolder);
        }

        @Override
        protected void a(a.c<c.a> c2, DataHolder dataHolder) {
            c2.a(this);
        }

        @Override
        public GameBuffer cI() {
            return this.qZ;
        }
    }

    final class l
    extends ew {
        private final OnInvitationReceivedListener ra;

        l(OnInvitationReceivedListener onInvitationReceivedListener) {
            this.ra = onInvitationReceivedListener;
        }

        @Override
        public void k(DataHolder parcelable) {
            InvitationBuffer invitationBuffer = new InvitationBuffer((DataHolder)parcelable);
            parcelable = null;
            if (invitationBuffer.getCount() > 0) {
                parcelable = (Invitation)((Invitation)invitationBuffer.get(0)).freeze();
            }
            if (parcelable == null) return;
            ex.this.a(new m(this.ra, (Invitation)parcelable));
            return;
            finally {
                invitationBuffer.close();
            }
        }

        @Override
        public void onInvitationRemoved(String string2) {
            ex.this.a(new n(this.ra, string2));
        }
    }

    final class m
    extends dk.b<OnInvitationReceivedListener> {
        private final Invitation rb;

        m(OnInvitationReceivedListener onInvitationReceivedListener, Invitation invitation) {
            super(onInvitationReceivedListener);
            this.rb = invitation;
        }

        protected void a(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationReceived(this.rb);
        }

        @Override
        protected void aQ() {
        }

        @Override
        protected /* synthetic */ void b(Object object) {
            this.a((OnInvitationReceivedListener)object);
        }
    }

    final class n
    extends dk.b<OnInvitationReceivedListener> {
        private final String rc;

        n(OnInvitationReceivedListener onInvitationReceivedListener, String string2) {
            super(onInvitationReceivedListener);
            this.rc = string2;
        }

        protected void a(OnInvitationReceivedListener onInvitationReceivedListener) {
            onInvitationReceivedListener.onInvitationRemoved(this.rc);
        }

        @Override
        protected void aQ() {
        }

        @Override
        protected /* synthetic */ void b(Object object) {
            this.a((OnInvitationReceivedListener)object);
        }
    }

    final class o
    extends ew {
        private final a.c<c.a> jN;

        o(a.c<c.a> c2) {
            this.jN = du.c(c2, "Holder must not be null");
        }

        @Override
        public void j(DataHolder dataHolder) {
            ex.this.a(new p(this.jN, dataHolder));
        }
    }

    final class p
    extends ao<a.c<c.a>>
    implements c.a {
        private final InvitationBuffer rd;

        p(a.c<c.a> c2, DataHolder dataHolder) {
            super(ex.this, c2, dataHolder);
            this.rd = new InvitationBuffer(dataHolder);
        }

        @Override
        protected void a(a.c<c.a> c2, DataHolder dataHolder) {
            c2.a(this);
        }

        @Override
        public InvitationBuffer getInvitations() {
            return this.rd;
        }
    }

    final class q
    extends b {
        public q(RoomUpdateListener roomUpdateListener, DataHolder dataHolder) {
            super(roomUpdateListener, dataHolder);
        }

        @Override
        public void a(RoomUpdateListener roomUpdateListener, Room room, int n2) {
            roomUpdateListener.onJoinedRoom(n2, room);
        }
    }

    final class r
    extends ew {
        private final a.c<h.c> jN;

        r(a.c<h.c> c2) {
            this.jN = du.c(c2, "Holder must not be null");
        }

        @Override
        public void a(DataHolder dataHolder, DataHolder dataHolder2) {
            ex.this.a(new s(this.jN, dataHolder, dataHolder2));
        }
    }

    final class s
    extends ao<a.c<h.c>>
    implements h.c {
        private final com.google.android.gms.games.leaderboard.a re;
        private final LeaderboardScoreBuffer rf;

        s(a.c<h.c> c2, DataHolder dataHolder, DataHolder dataHolder2) {
            super((ex)ex.this, c2, dataHolder2);
            ex.this = new LeaderboardBuffer(dataHolder);
            try {
                this.re = ((com.google.android.gms.common.data.d)ex.this).getCount() > 0 ? (com.google.android.gms.games.leaderboard.a)((Leaderboard)((com.google.android.gms.common.data.d)ex.this).get(0)).freeze() : null;
                this.rf = new LeaderboardScoreBuffer(dataHolder2);
                return;
            }
            finally {
                ((DataBuffer)ex.this).close();
            }
        }

        @Override
        protected void a(a.c<h.c> c2, DataHolder dataHolder) {
            c2.a(this);
        }

        @Override
        public Leaderboard cO() {
            return this.re;
        }

        @Override
        public LeaderboardScoreBuffer cP() {
            return this.rf;
        }
    }

    final class t
    extends ew {
        private final a.c<h.a> jN;

        t(a.c<h.a> c2) {
            this.jN = du.c(c2, "Holder must not be null");
        }

        @Override
        public void c(DataHolder dataHolder) {
            ex.this.a(new u(this.jN, dataHolder));
        }
    }

    final class u
    extends ao<a.c<h.a>>
    implements h.a {
        private final LeaderboardBuffer rg;

        u(a.c<h.a> c2, DataHolder dataHolder) {
            super(ex.this, c2, dataHolder);
            this.rg = new LeaderboardBuffer(dataHolder);
        }

        @Override
        protected void a(a.c<h.a> c2, DataHolder dataHolder) {
            c2.a(this);
        }

        @Override
        public LeaderboardBuffer cQ() {
            return this.rg;
        }
    }

    final class v
    extends dk.b<RoomUpdateListener> {
        private final int ka;
        private final String rh;

        v(RoomUpdateListener roomUpdateListener, int n2, String string2) {
            super(roomUpdateListener);
            this.ka = n2;
            this.rh = string2;
        }

        public void a(RoomUpdateListener roomUpdateListener) {
            roomUpdateListener.onLeftRoom(this.ka, this.rh);
        }

        @Override
        protected void aQ() {
        }

        @Override
        public /* synthetic */ void b(Object object) {
            this.a((RoomUpdateListener)object);
        }
    }

    final class w
    extends dk.b<OnTurnBasedMatchUpdateReceivedListener> {
        private final String ri;

        w(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener, String string2) {
            super(onTurnBasedMatchUpdateReceivedListener);
            this.ri = string2;
        }

        protected void a(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchRemoved(this.ri);
        }

        @Override
        protected void aQ() {
        }

        @Override
        protected /* synthetic */ void b(Object object) {
            this.a((OnTurnBasedMatchUpdateReceivedListener)object);
        }
    }

    final class x
    extends ew {
        private final OnTurnBasedMatchUpdateReceivedListener rj;

        x(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            this.rj = onTurnBasedMatchUpdateReceivedListener;
        }

        @Override
        public void onTurnBasedMatchRemoved(String string2) {
            ex.this.a(new w(this.rj, string2));
        }

        @Override
        public void p(DataHolder parcelable) {
            TurnBasedMatchBuffer turnBasedMatchBuffer = new TurnBasedMatchBuffer((DataHolder)parcelable);
            parcelable = null;
            if (turnBasedMatchBuffer.getCount() > 0) {
                parcelable = (TurnBasedMatch)((TurnBasedMatch)turnBasedMatchBuffer.get(0)).freeze();
            }
            if (parcelable == null) return;
            ex.this.a(new y(this.rj, (TurnBasedMatch)parcelable));
            return;
            finally {
                turnBasedMatchBuffer.close();
            }
        }
    }

    final class y
    extends dk.b<OnTurnBasedMatchUpdateReceivedListener> {
        private final TurnBasedMatch rk;

        y(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener, TurnBasedMatch turnBasedMatch) {
            super(onTurnBasedMatchUpdateReceivedListener);
            this.rk = turnBasedMatch;
        }

        protected void a(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
            onTurnBasedMatchUpdateReceivedListener.onTurnBasedMatchReceived(this.rk);
        }

        @Override
        protected void aQ() {
        }

        @Override
        protected /* synthetic */ void b(Object object) {
            this.a((OnTurnBasedMatchUpdateReceivedListener)object);
        }
    }

    final class z
    extends dk.b<RealTimeMessageReceivedListener> {
        private final RealTimeMessage rl;

        z(RealTimeMessageReceivedListener realTimeMessageReceivedListener, RealTimeMessage realTimeMessage) {
            super(realTimeMessageReceivedListener);
            this.rl = realTimeMessage;
        }

        public void a(RealTimeMessageReceivedListener realTimeMessageReceivedListener) {
            if (realTimeMessageReceivedListener == null) return;
            realTimeMessageReceivedListener.onRealTimeMessageReceived(this.rl);
        }

        @Override
        protected void aQ() {
        }

        @Override
        public /* synthetic */ void b(Object object) {
            this.a((RealTimeMessageReceivedListener)object);
        }
    }
}

