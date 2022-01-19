/*
 * Decompiled with CFR 0.152.
 */
package com.ea.nimble;

import com.ea.nimble.HttpRequest;
import com.ea.nimble.IOperationalTelemetryDispatch;
import com.ea.nimble.NetworkConnection;
import com.ea.nimble.NetworkImpl;

public class BackgroundNetworkConnection
extends NetworkConnection {
    public BackgroundNetworkConnection(NetworkImpl networkImpl, HttpRequest httpRequest, IOperationalTelemetryDispatch iOperationalTelemetryDispatch) {
        super(networkImpl, httpRequest, iOperationalTelemetryDispatch);
    }

    @Override
    void cancelForAppSuspend() {
    }
}

