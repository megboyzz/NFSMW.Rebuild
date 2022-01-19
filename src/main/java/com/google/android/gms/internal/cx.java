/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.AlertDialog$Builder
 *  android.content.Context
 *  android.content.DialogInterface
 *  android.content.DialogInterface$OnCancelListener
 *  android.content.DialogInterface$OnClickListener
 *  android.os.Message
 *  android.view.View
 *  android.webkit.ConsoleMessage
 *  android.webkit.JsPromptResult
 *  android.webkit.JsResult
 *  android.webkit.WebChromeClient
 *  android.webkit.WebChromeClient$CustomViewCallback
 *  android.webkit.WebStorage$QuotaUpdater
 *  android.webkit.WebView
 *  android.webkit.WebView$WebViewTransport
 *  android.webkit.WebViewClient
 *  android.widget.EditText
 *  android.widget.LinearLayout
 *  android.widget.TextView
 */
package com.google.android.gms.internal;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Message;
import android.view.View;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.internal.bk;
import com.google.android.gms.internal.cs;
import com.google.android.gms.internal.cv;

public class cx
extends WebChromeClient {
    private final cv gu;

    public cx(cv cv2) {
        this.gu = cv2;
    }

    private static void a(AlertDialog.Builder builder, String string2, final JsResult jsResult) {
        builder.setMessage((CharSequence)string2).setPositiveButton(17039370, new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialogInterface, int n2) {
                jsResult.confirm();
            }
        }).setNegativeButton(0x1040000, new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialogInterface, int n2) {
                jsResult.cancel();
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener(){

            public void onCancel(DialogInterface dialogInterface) {
                jsResult.cancel();
            }
        }).create().show();
    }

    private static void a(Context context, AlertDialog.Builder builder, String string2, String string3, final JsPromptResult jsPromptResult) {
        LinearLayout linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        TextView textView = new TextView(context);
        textView.setText((CharSequence)string2);
        context = new EditText(context);
        context.setText((CharSequence)string3);
        linearLayout.addView((View)textView);
        linearLayout.addView((View)context);
        builder.setView((View)linearLayout).setPositiveButton(17039370, new DialogInterface.OnClickListener((EditText)context){
            final /* synthetic */ EditText jc;
            {
                this.jc = editText;
            }

            public void onClick(DialogInterface dialogInterface, int n2) {
                jsPromptResult.confirm(this.jc.getText().toString());
            }
        }).setNegativeButton(0x1040000, new DialogInterface.OnClickListener(){

            public void onClick(DialogInterface dialogInterface, int n2) {
                jsPromptResult.cancel();
            }
        }).setOnCancelListener(new DialogInterface.OnCancelListener(){

            public void onCancel(DialogInterface dialogInterface) {
                jsPromptResult.cancel();
            }
        }).create().show();
    }

    private static boolean a(Context context, String string2, String string3, String string4, JsResult jsResult, JsPromptResult jsPromptResult, boolean bl2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle((CharSequence)string2);
        if (bl2) {
            cx.a(context, builder, string3, string4, jsPromptResult);
            return true;
        }
        cx.a(builder, string3, jsResult);
        return true;
    }

    protected final void a(View view, int n2, WebChromeClient.CustomViewCallback customViewCallback) {
        bk bk2 = this.gu.aA();
        if (bk2 == null) {
            cs.v("Could not get ad overlay when showing custom view.");
            customViewCallback.onCustomViewHidden();
            return;
        }
        bk2.a(view, customViewCallback);
        bk2.setRequestedOrientation(n2);
    }

    public final void onCloseWindow(WebView object) {
        if (!(object instanceof cv)) {
            cs.v("Tried to close a WebView that wasn't an AdWebView.");
            return;
        }
        if ((object = ((cv)((Object)object)).aA()) == null) {
            cs.v("Tried to close an AdWebView not associated with an overlay.");
            return;
        }
        ((bk)object).close();
    }

    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String string2 = "JS: " + consoleMessage.message() + " (" + consoleMessage.sourceId() + ":" + consoleMessage.lineNumber() + ")";
        switch (7.jd[consoleMessage.messageLevel().ordinal()]) {
            default: {
                cs.t(string2);
                return super.onConsoleMessage(consoleMessage);
            }
            case 1: {
                cs.s(string2);
                return super.onConsoleMessage(consoleMessage);
            }
            case 2: {
                cs.v(string2);
                return super.onConsoleMessage(consoleMessage);
            }
            case 3: 
            case 4: {
                cs.t(string2);
                return super.onConsoleMessage(consoleMessage);
            }
            case 5: 
        }
        cs.r(string2);
        return super.onConsoleMessage(consoleMessage);
    }

    public final boolean onCreateWindow(WebView webView, boolean bl2, boolean bl3, Message message) {
        WebView.WebViewTransport webViewTransport = (WebView.WebViewTransport)message.obj;
        webView = new WebView(webView.getContext());
        webView.setWebViewClient((WebViewClient)this.gu.aB());
        webViewTransport.setWebView(webView);
        message.sendToTarget();
        return true;
    }

    public final void onExceededDatabaseQuota(String string2, String string3, long l2, long l3, long l4, WebStorage.QuotaUpdater quotaUpdater) {
        long l5 = 0x500000L - l4;
        if (l5 <= 0L) {
            quotaUpdater.updateQuota(l2);
            return;
        }
        if (l2 == 0L) {
            if (l3 > l5 || l3 > 0x100000L) {
                l3 = 0L;
            }
        } else if (l3 == 0L) {
            l3 = Math.min(Math.min(131072L, l5) + l2, 0x100000L);
        } else {
            l4 = l2;
            if (l3 <= Math.min(0x100000L - l2, l5)) {
                l4 = l2 + l3;
            }
            l3 = l4;
        }
        quotaUpdater.updateQuota(l3);
    }

    public final void onHideCustomView() {
        bk bk2 = this.gu.aA();
        if (bk2 == null) {
            cs.v("Could not get ad overlay when hiding custom view.");
            return;
        }
        bk2.X();
    }

    public final boolean onJsAlert(WebView webView, String string2, String string3, JsResult jsResult) {
        return cx.a(webView.getContext(), string2, string3, null, jsResult, null, false);
    }

    public final boolean onJsBeforeUnload(WebView webView, String string2, String string3, JsResult jsResult) {
        return cx.a(webView.getContext(), string2, string3, null, jsResult, null, false);
    }

    public final boolean onJsConfirm(WebView webView, String string2, String string3, JsResult jsResult) {
        return cx.a(webView.getContext(), string2, string3, null, jsResult, null, false);
    }

    public final boolean onJsPrompt(WebView webView, String string2, String string3, String string4, JsPromptResult jsPromptResult) {
        return cx.a(webView.getContext(), string2, string3, string4, null, jsPromptResult, true);
    }

    public final void onReachedMaxAppCacheSize(long l2, long l3, WebStorage.QuotaUpdater quotaUpdater) {
        if (0x500000L - l3 < (l2 = 131072L + l2)) {
            quotaUpdater.updateQuota(0L);
            return;
        }
        quotaUpdater.updateQuota(l2);
    }

    public final void onShowCustomView(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.a(view, -1, customViewCallback);
    }
}

