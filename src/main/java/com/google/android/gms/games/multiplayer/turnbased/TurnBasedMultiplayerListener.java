/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.games.multiplayer.turnbased;

import com.google.android.gms.games.multiplayer.OnInvitationReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchCanceledListener;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchInitiatedListener;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchLeftListener;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdateReceivedListener;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchUpdatedListener;
import com.google.android.gms.games.multiplayer.turnbased.OnTurnBasedMatchesLoadedListener;

public interface TurnBasedMultiplayerListener
extends OnInvitationReceivedListener,
OnTurnBasedMatchCanceledListener,
OnTurnBasedMatchInitiatedListener,
OnTurnBasedMatchLeftListener,
OnTurnBasedMatchUpdateReceivedListener,
OnTurnBasedMatchUpdatedListener,
OnTurnBasedMatchesLoadedListener {
}

