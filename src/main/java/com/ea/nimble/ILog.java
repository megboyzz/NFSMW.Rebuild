/*
 * Decompiled with CFR 0.152.
 */
package com.ea.nimble;

public interface ILog {
    public String getLogFilePath();

    public int getThresholdLevel();

    public void setThresholdLevel(int var1);

    public void writeWithSource(int var1, Object var2, String var3, Object ... var4);

    public void writeWithTitle(int var1, String var2, String var3, Object ... var4);
}

