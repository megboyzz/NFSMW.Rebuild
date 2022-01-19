/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.content.Context
 *  android.content.Intent
 *  android.view.View
 */
package com.google.android.gms.games;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import com.google.android.gms.common.GooglePlayServicesClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.a;
import com.google.android.gms.games.Game;
import com.google.android.gms.games.OnGamesLoadedListener;
import com.google.android.gms.games.OnPlayersLoadedListener;
import com.google.android.gms.games.OnSignOutCompleteListener;
import com.google.android.gms.games.Player;
import com.google.android.gms.games.achievement.OnAchievementUpdatedListener;
import com.google.android.gms.games.achievement.OnAchievementsLoadedListener;
import com.google.android.gms.games.achievement.b;
import com.google.android.gms.games.c;
import com.google.android.gms.games.f;
import com.google.android.gms.games.leaderboard.LeaderboardScoreBuffer;
import com.google.android.gms.games.leaderboard.OnLeaderboardMetadataLoadedListener;
import com.google.android.gms.games.leaderboard.OnLeaderboardScoresLoadedListener;
import com.google.android.gms.games.leaderboard.OnPlayerLeaderboardScoreLoadedListener;
import com.google.android.gms.games.leaderboard.OnScoreSubmittedListener;
import com.google.android.gms.games.leaderboard.SubmitScoreResult;
import com.google.android.gms.games.leaderboard.h;
import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.OnInvitationsLoadedListener;
import com.google.android.gms.games.multiplayer.ParticipantResult;
import com.google.android.gms.games.multiplayer.c;
import com.google.android.gms.games.multiplayer.realtime.RealTimeReliableMessageSentListener;
import com.google.android.gms.games.multiplayer.realtime.RealTimeSocket;
import com.google.android.gms.games.multiplayer.realtime.Room;
import com.google.android.gms.games.multiplayer.realtime.RoomConfig;
import com.google.android.gms.games.multiplayer.realtime.RoomUpdateListener;
import com.google.android.gms.games.multiplayer.realtime.a;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchCanceledListener;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchInitiatedListener;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchLeftListener;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchLoadedListener;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdatedListener;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchesLoadedListener;
import com.google.android.gms.games.multiplayer.turnbased.TurnBasedMatchConfig;
import com.google.android.gms.games.multiplayer.turnbased.b;
import com.google.android.gms.internal.du;
import com.google.android.gms.internal.ex;
import java.util.List;

public final class GamesClient
implements GooglePlayServicesClient {
    public static final String EXTRA_EXCLUSIVE_BIT_MASK = "exclusive_bit_mask";
    public static final String EXTRA_INVITATION = "invitation";
    public static final String EXTRA_MAX_AUTOMATCH_PLAYERS = "max_automatch_players";
    public static final String EXTRA_MIN_AUTOMATCH_PLAYERS = "min_automatch_players";
    public static final String EXTRA_PLAYERS = "players";
    public static final String EXTRA_PLAYER_SEARCH_RESULTS = "player_search_results";
    public static final String EXTRA_ROOM = "room";
    public static final String EXTRA_TURN_BASED_MATCH = "turn_based_match";
    public static final int MAX_RELIABLE_MESSAGE_LEN = 1400;
    public static final int MAX_UNRELIABLE_MESSAGE_LEN = 1168;
    public static final int NOTIFICATION_TYPES_ALL = -1;
    public static final int NOTIFICATION_TYPES_MULTIPLAYER = 3;
    public static final int NOTIFICATION_TYPE_INVITATION = 1;
    public static final int NOTIFICATION_TYPE_MATCH_UPDATE = 2;
    public static final int STATUS_ACHIEVEMENT_NOT_INCREMENTAL = 3002;
    public static final int STATUS_ACHIEVEMENT_UNKNOWN = 3001;
    public static final int STATUS_ACHIEVEMENT_UNLOCKED = 3003;
    public static final int STATUS_ACHIEVEMENT_UNLOCK_FAILURE = 3000;
    public static final int STATUS_APP_MISCONFIGURED = 8;
    public static final int STATUS_CLIENT_RECONNECT_REQUIRED = 2;
    public static final int STATUS_GAME_NOT_FOUND = 9;
    public static final int STATUS_INTERNAL_ERROR = 1;
    public static final int STATUS_INVALID_REAL_TIME_ROOM_ID = 7002;
    public static final int STATUS_LICENSE_CHECK_FAILED = 7;
    public static final int STATUS_MATCH_ERROR_ALREADY_REMATCHED = 6505;
    public static final int STATUS_MATCH_ERROR_INACTIVE_MATCH = 6501;
    public static final int STATUS_MATCH_ERROR_INVALID_MATCH_RESULTS = 6504;
    public static final int STATUS_MATCH_ERROR_INVALID_MATCH_STATE = 6502;
    public static final int STATUS_MATCH_ERROR_INVALID_PARTICIPANT_STATE = 6500;
    public static final int STATUS_MATCH_ERROR_LOCALLY_MODIFIED = 6507;
    public static final int STATUS_MATCH_ERROR_OUT_OF_DATE_VERSION = 6503;
    public static final int STATUS_MATCH_NOT_FOUND = 6506;
    public static final int STATUS_MULTIPLAYER_DISABLED = 6003;
    public static final int STATUS_MULTIPLAYER_ERROR_CREATION_NOT_ALLOWED = 6000;
    public static final int STATUS_MULTIPLAYER_ERROR_INVALID_MULTIPLAYER_TYPE = 6002;
    public static final int STATUS_MULTIPLAYER_ERROR_INVALID_OPERATION = 6004;
    public static final int STATUS_MULTIPLAYER_ERROR_NOT_TRUSTED_TESTER = 6001;
    public static final int STATUS_NETWORK_ERROR_NO_DATA = 4;
    public static final int STATUS_NETWORK_ERROR_OPERATION_DEFERRED = 5;
    public static final int STATUS_NETWORK_ERROR_OPERATION_FAILED = 6;
    public static final int STATUS_NETWORK_ERROR_STALE_DATA = 3;
    public static final int STATUS_OK = 0;
    public static final int STATUS_OPERATION_IN_FLIGHT = 7007;
    public static final int STATUS_PARTICIPANT_NOT_CONNECTED = 7003;
    public static final int STATUS_REAL_TIME_CONNECTION_FAILED = 7000;
    public static final int STATUS_REAL_TIME_INACTIVE_ROOM = 7005;
    public static final int STATUS_REAL_TIME_MESSAGE_FAILED = -1;
    public static final int STATUS_REAL_TIME_MESSAGE_SEND_FAILED = 7001;
    public static final int STATUS_REAL_TIME_ROOM_NOT_JOINED = 7004;
    private final ex qm;

    private GamesClient(Context context, String string2, String string3, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener, String[] stringArray, int n2, View view, boolean bl2, int n3) {
        this.qm = new ex(context, string2, string3, connectionCallbacks, onConnectionFailedListener, stringArray, n2, view, false, bl2, n3);
    }

    public void acceptTurnBasedInvitation(final OnTurnBasedMatchInitiatedListener onTurnBasedMatchInitiatedListener, String string2) {
        this.qm.e(new a.c<b.b>(){

            @Override
            public void a(b.b b2) {
                int n2 = b2.getStatus().getStatusCode();
                onTurnBasedMatchInitiatedListener.onTurnBasedMatchInitiated(n2, b2.cT());
            }
        }, string2);
    }

    public void cancelTurnBasedMatch(final OnTurnBasedMatchCanceledListener onTurnBasedMatchCanceledListener, String string2) {
        this.qm.g(new a.c<b.a>(){

            @Override
            public void a(b.a a2) {
                int n2 = a2.getStatus().getStatusCode();
                onTurnBasedMatchCanceledListener.onTurnBasedMatchCanceled(n2, a2.getMatchId());
            }
        }, string2);
    }

    public void cancelTurnBasedMatch(String string2) {
        this.qm.g(new a.c<b.a>(){

            @Override
            public void a(b.a a2) {
            }
        }, string2);
    }

    public void clearAllNotifications() {
        this.qm.clearNotifications(-1);
    }

    public void clearNotifications(int n2) {
        this.qm.clearNotifications(n2);
    }

    @Override
    public void connect() {
        this.qm.connect();
    }

    public void createRoom(RoomConfig roomConfig) {
        this.qm.createRoom(roomConfig);
    }

    public void createTurnBasedMatch(final OnTurnBasedMatchInitiatedListener onTurnBasedMatchInitiatedListener, TurnBasedMatchConfig turnBasedMatchConfig) {
        this.qm.a(new a.c<b.b>(){

            @Override
            public void a(b.b b2) {
                int n2 = b2.getStatus().getStatusCode();
                onTurnBasedMatchInitiatedListener.onTurnBasedMatchInitiated(n2, b2.cT());
            }
        }, turnBasedMatchConfig);
    }

    public void declineRoomInvitation(String string2) {
        this.qm.i(string2, 0);
    }

    public void declineTurnBasedInvitation(String string2) {
        this.qm.i(string2, 1);
    }

    @Override
    public void disconnect() {
        this.qm.disconnect();
    }

    public void dismissRoomInvitation(String string2) {
        this.qm.h(string2, 0);
    }

    public void dismissTurnBasedInvitation(String string2) {
        this.qm.h(string2, 1);
    }

    public void dismissTurnBasedMatch(String string2) {
        this.qm.dismissTurnBasedMatch(string2);
    }

    public void finishTurnBasedMatch(final OnTurnBasedMatchUpdatedListener onTurnBasedMatchUpdatedListener, String string2) {
        this.qm.a(new a.c<b.f>(){

            @Override
            public void a(b.f f2) {
                int n2 = f2.getStatus().getStatusCode();
                onTurnBasedMatchUpdatedListener.onTurnBasedMatchUpdated(n2, f2.cT());
            }
        }, string2, null, null);
    }

    public void finishTurnBasedMatch(OnTurnBasedMatchUpdatedListener onTurnBasedMatchUpdatedListener, String string2, byte[] byArray, List<ParticipantResult> object) {
        object = object == null ? null : object.toArray(new ParticipantResult[object.size()]);
        this.finishTurnBasedMatch(onTurnBasedMatchUpdatedListener, string2, byArray, (ParticipantResult)object);
    }

    public void finishTurnBasedMatch(final OnTurnBasedMatchUpdatedListener onTurnBasedMatchUpdatedListener, String string2, byte[] byArray, ParticipantResult ... participantResultArray) {
        this.qm.a(new a.c<b.f>(){

            @Override
            public void a(b.f f2) {
                int n2 = f2.getStatus().getStatusCode();
                onTurnBasedMatchUpdatedListener.onTurnBasedMatchUpdated(n2, f2.cT());
            }
        }, string2, byArray, participantResultArray);
    }

    public Intent getAchievementsIntent() {
        return this.qm.getAchievementsIntent();
    }

    public Intent getAllLeaderboardsIntent() {
        return this.qm.getAllLeaderboardsIntent();
    }

    public String getAppId() {
        return this.qm.getAppId();
    }

    public String getCurrentAccountName() {
        return this.qm.getCurrentAccountName();
    }

    public Game getCurrentGame() {
        return this.qm.getCurrentGame();
    }

    public Player getCurrentPlayer() {
        return this.qm.getCurrentPlayer();
    }

    public String getCurrentPlayerId() {
        return this.qm.getCurrentPlayerId();
    }

    public Intent getInvitationInboxIntent() {
        return this.qm.getInvitationInboxIntent();
    }

    public Intent getLeaderboardIntent(String string2) {
        return this.qm.getLeaderboardIntent(string2);
    }

    public Intent getMatchInboxIntent() {
        return this.qm.getMatchInboxIntent();
    }

    public int getMaxTurnBasedMatchDataSize() {
        return this.qm.getMaxTurnBasedMatchDataSize();
    }

    public Intent getPlayerSearchIntent() {
        return this.qm.getPlayerSearchIntent();
    }

    public RealTimeSocket getRealTimeSocketForParticipant(String string2, String string3) {
        return this.qm.getRealTimeSocketForParticipant(string2, string3);
    }

    public Intent getRealTimeWaitingRoomIntent(Room room, int n2) {
        return this.qm.getRealTimeWaitingRoomIntent(room, n2);
    }

    public Intent getSelectPlayersIntent(int n2, int n3) {
        return this.qm.getSelectPlayersIntent(n2, n3, true);
    }

    public Intent getSelectPlayersIntent(int n2, int n3, boolean bl2) {
        return this.qm.getSelectPlayersIntent(n2, n3, bl2);
    }

    public Intent getSettingsIntent() {
        return this.qm.getSettingsIntent();
    }

    public void getTurnBasedMatch(final OnTurnBasedMatchLoadedListener onTurnBasedMatchLoadedListener, String string2) {
        this.qm.h(new a.c<b.d>(){

            @Override
            public void a(b.d d2) {
                int n2 = d2.getStatus().getStatusCode();
                onTurnBasedMatchLoadedListener.onTurnBasedMatchLoaded(n2, d2.cT());
            }
        }, string2);
    }

    public void incrementAchievement(String string2, int n2) {
        this.qm.a(null, string2, n2);
    }

    public void incrementAchievementImmediate(final OnAchievementUpdatedListener onAchievementUpdatedListener, String string2, int n2) {
        this.qm.a(new a.c<b.b>(){

            @Override
            public void a(b.b b2) {
                int n2 = b2.getStatus().getStatusCode();
                onAchievementUpdatedListener.onAchievementUpdated(n2, b2.getAchievementId());
            }
        }, string2, n2);
    }

    @Override
    public boolean isConnected() {
        return this.qm.isConnected();
    }

    @Override
    public boolean isConnecting() {
        return this.qm.isConnecting();
    }

    @Override
    public boolean isConnectionCallbacksRegistered(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
        return this.qm.isConnectionCallbacksRegistered(connectionCallbacks);
    }

    @Override
    public boolean isConnectionFailedListenerRegistered(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        return this.qm.isConnectionFailedListenerRegistered(onConnectionFailedListener);
    }

    public void joinRoom(RoomConfig roomConfig) {
        this.qm.joinRoom(roomConfig);
    }

    public void leaveRoom(RoomUpdateListener roomUpdateListener, String string2) {
        this.qm.leaveRoom(roomUpdateListener, string2);
    }

    public void leaveTurnBasedMatch(final OnTurnBasedMatchLeftListener onTurnBasedMatchLeftListener, String string2) {
        this.qm.f(new a.c<b.c>(){

            @Override
            public void a(b.c c2) {
                int n2 = c2.getStatus().getStatusCode();
                onTurnBasedMatchLeftListener.onTurnBasedMatchLeft(n2, c2.cT());
            }
        }, string2);
    }

    public void leaveTurnBasedMatchDuringTurn(final OnTurnBasedMatchLeftListener onTurnBasedMatchLeftListener, String string2, String string3) {
        this.qm.a(new a.c<b.c>(){

            @Override
            public void a(b.c c2) {
                int n2 = c2.getStatus().getStatusCode();
                onTurnBasedMatchLeftListener.onTurnBasedMatchLeft(n2, c2.cT());
            }
        }, string2, string3);
    }

    public void loadAchievements(final OnAchievementsLoadedListener onAchievementsLoadedListener, boolean bl2) {
        this.qm.b(new a.c<b.a>(){

            @Override
            public void a(b.a a2) {
                int n2 = a2.getStatus().getStatusCode();
                onAchievementsLoadedListener.onAchievementsLoaded(n2, a2.cK());
            }
        }, bl2);
    }

    public void loadCurrentPlayerLeaderboardScore(final OnPlayerLeaderboardScoreLoadedListener onPlayerLeaderboardScoreLoadedListener, String string2, int n2, int n3) {
        this.qm.a(new a.c<h.b>(){

            @Override
            public void a(h.b b2) {
                int n2 = b2.getStatus().getStatusCode();
                onPlayerLeaderboardScoreLoadedListener.onPlayerLeaderboardScoreLoaded(n2, b2.cR());
            }
        }, null, string2, n2, n3);
    }

    public void loadGame(final OnGamesLoadedListener onGamesLoadedListener) {
        this.qm.d(new a.c<c.a>(){

            @Override
            public void a(c.a a2) {
                onGamesLoadedListener.onGamesLoaded(a2.getStatus().getStatusCode(), a2.cI());
            }
        });
    }

    public void loadInvitablePlayers(final OnPlayersLoadedListener onPlayersLoadedListener, int n2, boolean bl2) {
        this.qm.a(new a.c<f.a>(){

            @Override
            public void a(f.a a2) {
                onPlayersLoadedListener.onPlayersLoaded(a2.getStatus().getStatusCode(), a2.cJ());
            }
        }, n2, false, bl2);
    }

    public void loadInvitations(final OnInvitationsLoadedListener onInvitationsLoadedListener) {
        this.qm.e(new a.c<c.a>(){

            @Override
            public void a(c.a a2) {
                int n2 = a2.getStatus().getStatusCode();
                onInvitationsLoadedListener.onInvitationsLoaded(n2, a2.getInvitations());
            }
        });
    }

    public void loadLeaderboardMetadata(final OnLeaderboardMetadataLoadedListener onLeaderboardMetadataLoadedListener, String string2, boolean bl2) {
        this.qm.a(new a.c<h.a>(){

            @Override
            public void a(h.a a2) {
                int n2 = a2.getStatus().getStatusCode();
                onLeaderboardMetadataLoadedListener.onLeaderboardMetadataLoaded(n2, a2.cQ());
            }
        }, string2, bl2);
    }

    public void loadLeaderboardMetadata(final OnLeaderboardMetadataLoadedListener onLeaderboardMetadataLoadedListener, boolean bl2) {
        this.qm.a(new a.c<h.a>(){

            @Override
            public void a(h.a a2) {
                int n2 = a2.getStatus().getStatusCode();
                onLeaderboardMetadataLoadedListener.onLeaderboardMetadataLoaded(n2, a2.cQ());
            }
        }, bl2);
    }

    public void loadMoreInvitablePlayers(final OnPlayersLoadedListener onPlayersLoadedListener, int n2) {
        this.qm.a(new a.c<f.a>(){

            @Override
            public void a(f.a a2) {
                onPlayersLoadedListener.onPlayersLoaded(a2.getStatus().getStatusCode(), a2.cJ());
            }
        }, n2, true, false);
    }

    public void loadMoreScores(final OnLeaderboardScoresLoadedListener onLeaderboardScoresLoadedListener, LeaderboardScoreBuffer leaderboardScoreBuffer, int n2, int n3) {
        this.qm.a(new a.c<h.c>(){

            @Override
            public void a(h.c c2) {
                int n2 = c2.getStatus().getStatusCode();
                onLeaderboardScoresLoadedListener.onLeaderboardScoresLoaded(n2, c2.cO(), c2.cP());
            }
        }, leaderboardScoreBuffer, n2, n3);
    }

    public void loadPlayer(final OnPlayersLoadedListener onPlayersLoadedListener, String string2) {
        this.qm.a(new a.c<f.a>(){

            @Override
            public void a(f.a a2) {
                onPlayersLoadedListener.onPlayersLoaded(a2.getStatus().getStatusCode(), a2.cJ());
            }
        }, string2);
    }

    public void loadPlayerCenteredScores(final OnLeaderboardScoresLoadedListener onLeaderboardScoresLoadedListener, String string2, int n2, int n3, int n4) {
        this.qm.b(new a.c<h.c>(){

            @Override
            public void a(h.c c2) {
                int n2 = c2.getStatus().getStatusCode();
                onLeaderboardScoresLoadedListener.onLeaderboardScoresLoaded(n2, c2.cO(), c2.cP());
            }
        }, string2, n2, n3, n4, false);
    }

    public void loadPlayerCenteredScores(final OnLeaderboardScoresLoadedListener onLeaderboardScoresLoadedListener, String string2, int n2, int n3, int n4, boolean bl2) {
        this.qm.b(new a.c<h.c>(){

            @Override
            public void a(h.c c2) {
                int n2 = c2.getStatus().getStatusCode();
                onLeaderboardScoresLoadedListener.onLeaderboardScoresLoaded(n2, c2.cO(), c2.cP());
            }
        }, string2, n2, n3, n4, bl2);
    }

    public void loadTopScores(final OnLeaderboardScoresLoadedListener onLeaderboardScoresLoadedListener, String string2, int n2, int n3, int n4) {
        this.qm.a(new a.c<h.c>(){

            @Override
            public void a(h.c c2) {
                int n2 = c2.getStatus().getStatusCode();
                onLeaderboardScoresLoadedListener.onLeaderboardScoresLoaded(n2, c2.cO(), c2.cP());
            }
        }, string2, n2, n3, n4, false);
    }

    public void loadTopScores(final OnLeaderboardScoresLoadedListener onLeaderboardScoresLoadedListener, String string2, int n2, int n3, int n4, boolean bl2) {
        this.qm.a(new a.c<h.c>(){

            @Override
            public void a(h.c c2) {
                int n2 = c2.getStatus().getStatusCode();
                onLeaderboardScoresLoadedListener.onLeaderboardScoresLoaded(n2, c2.cO(), c2.cP());
            }
        }, string2, n2, n3, n4, bl2);
    }

    public void loadTurnBasedMatches(final OnTurnBasedMatchesLoadedListener onTurnBasedMatchesLoadedListener, int ... nArray) {
        this.qm.a(new a.c<b.e>(){

            @Override
            public void a(b.e e2) {
                int n2 = e2.getStatus().getStatusCode();
                onTurnBasedMatchesLoadedListener.onTurnBasedMatchesLoaded(n2, e2.cU());
            }
        }, nArray);
    }

    public void reconnect() {
        this.qm.disconnect();
        this.qm.connect();
    }

    @Override
    public void registerConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
        this.qm.registerConnectionCallbacks(connectionCallbacks);
    }

    @Override
    public void registerConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.qm.registerConnectionFailedListener(onConnectionFailedListener);
    }

    public void registerInvitationListener(OnInvitationReceivedListener onInvitationReceivedListener) {
        this.qm.registerInvitationListener(onInvitationReceivedListener);
    }

    public void registerMatchUpdateListener(OnTurnBasedMatchUpdateReceivedListener onTurnBasedMatchUpdateReceivedListener) {
        this.qm.registerMatchUpdateListener(onTurnBasedMatchUpdateReceivedListener);
    }

    public void rematchTurnBasedMatch(final OnTurnBasedMatchInitiatedListener onTurnBasedMatchInitiatedListener, String string2) {
        this.qm.d(new a.c<b.b>(){

            @Override
            public void a(b.b b2) {
                int n2 = b2.getStatus().getStatusCode();
                onTurnBasedMatchInitiatedListener.onTurnBasedMatchInitiated(n2, b2.cT());
            }
        }, string2);
    }

    public void revealAchievement(String string2) {
        this.qm.b(null, string2);
    }

    public void revealAchievementImmediate(final OnAchievementUpdatedListener onAchievementUpdatedListener, String string2) {
        this.qm.b(new a.c<b.b>(){

            @Override
            public void a(b.b b2) {
                int n2 = b2.getStatus().getStatusCode();
                onAchievementUpdatedListener.onAchievementUpdated(n2, b2.getAchievementId());
            }
        }, string2);
    }

    public int sendReliableRealTimeMessage(final RealTimeReliableMessageSentListener realTimeReliableMessageSentListener, byte[] byArray, String string2, String string3) {
        return this.qm.a(new a.a(){

            @Override
            public void onRealTimeMessageSent(int n2, int n3, String string2) {
                realTimeReliableMessageSentListener.onRealTimeMessageSent(n2, n3, string2);
            }
        }, byArray, string2, string3);
    }

    public int sendUnreliableRealTimeMessage(byte[] byArray, String string2, String string3) {
        return this.qm.a(byArray, string2, new String[]{string3});
    }

    public int sendUnreliableRealTimeMessage(byte[] byArray, String string2, List<String> stringArray) {
        stringArray = stringArray.toArray(new String[stringArray.size()]);
        return this.qm.a(byArray, string2, stringArray);
    }

    public int sendUnreliableRealTimeMessageToAll(byte[] byArray, String string2) {
        return this.qm.sendUnreliableRealTimeMessageToAll(byArray, string2);
    }

    public void setAchievementSteps(String string2, int n2) {
        this.qm.b(null, string2, n2);
    }

    public void setAchievementStepsImmediate(final OnAchievementUpdatedListener onAchievementUpdatedListener, String string2, int n2) {
        this.qm.b(new a.c<b.b>(){

            @Override
            public void a(b.b b2) {
                int n2 = b2.getStatus().getStatusCode();
                onAchievementUpdatedListener.onAchievementUpdated(n2, b2.getAchievementId());
            }
        }, string2, n2);
    }

    public void setGravityForPopups(int n2) {
        this.qm.setGravityForPopups(n2);
    }

    public void setViewForPopups(View view) {
        du.f(view);
        this.qm.setViewForPopups(view);
    }

    public void signOut() {
        this.qm.b(new a.c<Status>(){

            @Override
            public void a(Status status) {
            }
        });
    }

    public void signOut(final OnSignOutCompleteListener onSignOutCompleteListener) {
        this.qm.b(new a.c<Status>(){

            @Override
            public void a(Status status) {
                onSignOutCompleteListener.onSignOutComplete();
            }
        });
    }

    public void submitScore(String string2, long l2) {
        this.qm.a(null, string2, l2, null);
    }

    public void submitScore(String string2, long l2, String string3) {
        this.qm.a(null, string2, l2, string3);
    }

    public void submitScoreImmediate(final OnScoreSubmittedListener onScoreSubmittedListener, String string2, long l2) {
        this.qm.a(new a.c<h.d>(){

            @Override
            public void a(h.d object) {
                int n2 = object.getStatus().getStatusCode();
                object = new SubmitScoreResult(object.cS().dl());
                onScoreSubmittedListener.onScoreSubmitted(n2, (SubmitScoreResult)object);
            }
        }, string2, l2, null);
    }

    public void submitScoreImmediate(final OnScoreSubmittedListener onScoreSubmittedListener, String string2, long l2, String string3) {
        this.qm.a(new a.c<h.d>(){

            @Override
            public void a(h.d object) {
                int n2 = object.getStatus().getStatusCode();
                object = new SubmitScoreResult(object.cS().dl());
                onScoreSubmittedListener.onScoreSubmitted(n2, (SubmitScoreResult)object);
            }
        }, string2, l2, string3);
    }

    public void takeTurn(final OnTurnBasedMatchUpdatedListener onTurnBasedMatchUpdatedListener, String string2, byte[] byArray, String string3) {
        this.qm.a(new a.c<b.f>(){

            @Override
            public void a(b.f f2) {
                int n2 = f2.getStatus().getStatusCode();
                onTurnBasedMatchUpdatedListener.onTurnBasedMatchUpdated(n2, f2.cT());
            }
        }, string2, byArray, string3, null);
    }

    public void takeTurn(final OnTurnBasedMatchUpdatedListener onTurnBasedMatchUpdatedListener, String string2, byte[] byArray, String string3, List<ParticipantResult> object) {
        object = object == null ? null : object.toArray(new ParticipantResult[object.size()]);
        this.qm.a(new a.c<b.f>(){

            @Override
            public void a(b.f f2) {
                int n2 = f2.getStatus().getStatusCode();
                onTurnBasedMatchUpdatedListener.onTurnBasedMatchUpdated(n2, f2.cT());
            }
        }, string2, byArray, string3, (ParticipantResult[])object);
    }

    public void takeTurn(final OnTurnBasedMatchUpdatedListener onTurnBasedMatchUpdatedListener, String string2, byte[] byArray, String string3, ParticipantResult ... participantResultArray) {
        this.qm.a(new a.c<b.f>(){

            @Override
            public void a(b.f f2) {
                int n2 = f2.getStatus().getStatusCode();
                onTurnBasedMatchUpdatedListener.onTurnBasedMatchUpdated(n2, f2.cT());
            }
        }, string2, byArray, string3, participantResultArray);
    }

    public void unlockAchievement(String string2) {
        this.qm.c(null, string2);
    }

    public void unlockAchievementImmediate(final OnAchievementUpdatedListener onAchievementUpdatedListener, String string2) {
        this.qm.c(new a.c<b.b>(){

            @Override
            public void a(b.b b2) {
                int n2 = b2.getStatus().getStatusCode();
                onAchievementUpdatedListener.onAchievementUpdated(n2, b2.getAchievementId());
            }
        }, string2);
    }

    @Override
    public void unregisterConnectionCallbacks(GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks) {
        this.qm.unregisterConnectionCallbacks(connectionCallbacks);
    }

    @Override
    public void unregisterConnectionFailedListener(GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
        this.qm.unregisterConnectionFailedListener(onConnectionFailedListener);
    }

    public void unregisterInvitationListener() {
        this.qm.unregisterInvitationListener();
    }

    public void unregisterMatchUpdateListener() {
        this.qm.unregisterMatchUpdateListener();
    }

    public static final class Builder {
        private final GooglePlayServicesClient.ConnectionCallbacks jA;
        private final GooglePlayServicesClient.OnConnectionFailedListener jB;
        private String[] jC = new String[]{"https://www.googleapis.com/auth/games"};
        private String jD = "<<default account>>";
        private final Context mContext;
        private String qF;
        private int qG = 49;
        private View qH;
        private boolean qI = true;
        private int qJ = 17;

        public Builder(Context context, GooglePlayServicesClient.ConnectionCallbacks connectionCallbacks, GooglePlayServicesClient.OnConnectionFailedListener onConnectionFailedListener) {
            this.mContext = context;
            this.qF = context.getPackageName();
            this.jA = connectionCallbacks;
            this.jB = onConnectionFailedListener;
        }

        public GamesClient create() {
            return new GamesClient(this.mContext, this.qF, this.jD, this.jA, this.jB, this.jC, this.qG, this.qH, this.qI, this.qJ);
        }

        public Builder setAccountName(String string2) {
            this.jD = du.f(string2);
            return this;
        }

        public Builder setGravityForPopups(int n2) {
            this.qG = n2;
            return this;
        }

        public Builder setScopes(String ... stringArray) {
            this.jC = stringArray;
            return this;
        }

        public Builder setShowConnectingPopup(boolean bl2) {
            this.qI = bl2;
            this.qJ = 17;
            return this;
        }

        public Builder setShowConnectingPopup(boolean bl2, int n2) {
            this.qI = bl2;
            this.qJ = n2;
            return this;
        }

        public Builder setViewForPopups(View view) {
            this.qH = du.f(view);
            return this;
        }
    }
}

