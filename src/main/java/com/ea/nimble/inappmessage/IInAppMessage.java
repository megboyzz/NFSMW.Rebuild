/*
 * Decompiled with CFR 0.152.
 */
package com.ea.nimble.inappmessage;

import com.ea.nimble.inappmessage.Message;

public interface IInAppMessage {
    public Message popMessageFromCache();

    public void showInAppMessage();
}

