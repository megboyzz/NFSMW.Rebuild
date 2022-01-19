/*
 * Decompiled with CFR 0.152.
 */
package com.facebook.android;

import java.util.Iterator;
import java.util.LinkedList;

public class SessionEvents {
    private static LinkedList<AuthListener> mAuthListeners = new LinkedList();
    private static LinkedList<LogoutListener> mLogoutListeners = new LinkedList();

    public static void addAuthListener(AuthListener authListener) {
        mAuthListeners.add(authListener);
    }

    public static void addLogoutListener(LogoutListener logoutListener) {
        mLogoutListeners.add(logoutListener);
    }

    public static void onLoginError(String string) {
        Iterator iterator = mAuthListeners.iterator();
        while (iterator.hasNext()) {
            ((AuthListener)iterator.next()).onAuthFail(string);
        }
    }

    public static void onLoginSuccess() {
        Iterator iterator = mAuthListeners.iterator();
        while (iterator.hasNext()) {
            ((AuthListener)iterator.next()).onAuthSucceed();
        }
    }

    public static void onLogoutBegin() {
        Iterator iterator = mLogoutListeners.iterator();
        while (iterator.hasNext()) {
            ((LogoutListener)iterator.next()).onLogoutBegin();
        }
    }

    public static void onLogoutFinish() {
        Iterator iterator = mLogoutListeners.iterator();
        while (iterator.hasNext()) {
            ((LogoutListener)iterator.next()).onLogoutFinish();
        }
    }

    public static void removeAuthListener(AuthListener authListener) {
        mAuthListeners.remove(authListener);
    }

    public static void removeLogoutListener(LogoutListener logoutListener) {
        mLogoutListeners.remove(logoutListener);
    }

    public static interface AuthListener {
        public void onAuthFail(String var1);

        public void onAuthSucceed();
    }

    public static interface LogoutListener {
        public void onLogoutBegin();

        public void onLogoutFinish();
    }
}

