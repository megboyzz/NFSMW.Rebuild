/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.games.multiplayer;

import com.google.android.gms.games.Player;
import com.google.android.gms.games.multiplayer.Participant;
import com.google.android.gms.internal.du;
import java.util.ArrayList;

public final class ParticipantUtils {
    private ParticipantUtils() {
    }

    public static boolean Y(String string2) {
        du.c(string2, "Participant ID must not be null");
        return string2.startsWith("p_");
    }

    public static String getParticipantId(ArrayList<Participant> arrayList, String string2) {
        int n2 = arrayList.size();
        int n3 = 0;
        while (n3 < n2) {
            Participant participant = arrayList.get(n3);
            Player player = participant.getPlayer();
            if (player != null && player.getPlayerId().equals(string2)) {
                return participant.getParticipantId();
            }
            ++n3;
        }
        return null;
    }
}

