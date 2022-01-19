/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal;

import java.io.IOException;

public class hs
extends IOException {
    public hs(String string2) {
        super(string2);
    }

    static hs fL() {
        return new hs("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either than the input has been truncated or that an embedded message misreported its own length.");
    }

    static hs fM() {
        return new hs("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    static hs fN() {
        return new hs("CodedInputStream encountered a malformed varint.");
    }

    static hs fO() {
        return new hs("Protocol message contained an invalid tag (zero).");
    }

    static hs fP() {
        return new hs("Protocol message end-group tag did not match expected tag.");
    }

    static hs fQ() {
        return new hs("Protocol message tag had invalid wire type.");
    }
}

