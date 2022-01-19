/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Dialog
 *  android.app.ProgressDialog
 *  android.content.Context
 *  android.content.Intent
 *  android.graphics.Bitmap
 *  android.graphics.drawable.Drawable
 *  android.net.Uri
 *  android.os.Bundle
 *  android.view.View
 *  android.view.View$OnClickListener
 *  android.view.ViewGroup$LayoutParams
 *  android.webkit.WebView
 *  android.webkit.WebViewClient
 *  android.widget.FrameLayout
 *  android.widget.FrameLayout$LayoutParams
 *  android.widget.ImageView
 *  android.widget.LinearLayout
 *  com.ea.easp.Debug$Log
 */
package com.facebook.android;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.ea.easp.Debug;
import com.facebook.android.DialogError;
import com.facebook.android.Facebook;
import com.facebook.android.FacebookError;
import com.facebook.android.Util;

public class FbDialog
extends Dialog {
    static final float[] DIMENSIONS_DIFF_LANDSCAPE = new float[]{20.0f, 60.0f};
    static final float[] DIMENSIONS_DIFF_PORTRAIT = new float[]{40.0f, 60.0f};
    static final String DISPLAY_STRING = "touch";
    static final int FB_BLUE = -9599820;
    static final String FB_ICON = "icon.png";
    static final FrameLayout.LayoutParams FILL = new FrameLayout.LayoutParams(-1, -1);
    static final int MARGIN = 4;
    static final int PADDING = 2;
    private FrameLayout mContent;
    private ImageView mCrossImage;
    private Facebook.DialogListener mListener;
    private ProgressDialog mSpinner;
    private String mUrl;
    private WebView mWebView;

    public FbDialog(Context context, String string, Facebook.DialogListener dialogListener) {
        super(context, 0x1030010);
        this.mUrl = string;
        this.mListener = dialogListener;
    }

    private void createCrossImage() {
        this.mCrossImage = new ImageView(this.getContext());
        this.mCrossImage.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view) {
                FbDialog.this.mListener.onCancel();
                FbDialog.this.dismiss();
            }
        });
        int n2 = this.getContext().getResources().getIdentifier("facebook_close", "drawable", this.getContext().getPackageName());
        Debug.Log.d((String)"FbDialog", (String)("createCrossImage(): closeImageId = " + n2));
        Drawable drawable = this.getContext().getResources().getDrawable(n2);
        this.mCrossImage.setImageDrawable(drawable);
        this.mCrossImage.setVisibility(4);
    }

    private void setUpWebView(int n2) {
        LinearLayout linearLayout = new LinearLayout(this.getContext());
        this.mWebView = new WebView(this.getContext());
        this.mWebView.setVerticalScrollBarEnabled(false);
        this.mWebView.setHorizontalScrollBarEnabled(false);
        this.mWebView.setWebViewClient((WebViewClient)new FbWebViewClient());
        this.mWebView.getSettings().setJavaScriptEnabled(true);
        this.mWebView.loadUrl(this.mUrl);
        this.mWebView.setLayoutParams((ViewGroup.LayoutParams)FILL);
        this.mWebView.setVisibility(4);
        this.mWebView.getSettings().setSavePassword(false);
        linearLayout.setPadding(n2, n2, n2, n2);
        linearLayout.addView((View)this.mWebView);
        this.mContent.addView((View)linearLayout);
    }

    public void onBackPressed() {
        Debug.Log.d((String)"FbDialog", (String)"onBackPressed()");
        this.mListener.onCancel();
        super.onBackPressed();
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.mSpinner = new ProgressDialog(this.getContext());
        this.mSpinner.requestWindowFeature(1);
        this.mSpinner.setMessage((CharSequence)"Loading...");
        this.requestWindowFeature(1);
        this.mContent = new FrameLayout(this.getContext());
        this.createCrossImage();
        this.mCrossImage.getDrawable().getIntrinsicWidth();
        this.setUpWebView(0);
        this.mContent.addView((View)this.mCrossImage, new ViewGroup.LayoutParams(-2, -2));
        this.addContentView((View)this.mContent, new ViewGroup.LayoutParams(-1, -1));
    }

    protected void onStop() {
        Debug.Log.d((String)"FbDialog", (String)"onStop()");
    }

    private class FbWebViewClient
    extends WebViewClient {
        private FbWebViewClient() {
        }

        public void onPageFinished(WebView webView, String string) {
            super.onPageFinished(webView, string);
            FbDialog.this.mSpinner.dismiss();
            FbDialog.this.mContent.setBackgroundColor(0);
            FbDialog.this.mWebView.setVisibility(0);
            FbDialog.this.mCrossImage.setVisibility(0);
        }

        public void onPageStarted(WebView webView, String string, Bitmap bitmap) {
            Debug.Log.d((String)"Facebook-WebView", (String)("Webview loading URL: " + string));
            super.onPageStarted(webView, string, bitmap);
            FbDialog.this.mSpinner.show();
        }

        public void onReceivedError(WebView webView, int n2, String string, String string2) {
            super.onReceivedError(webView, n2, string, string2);
            FbDialog.this.mListener.onError(new DialogError(string, n2, string2));
            FbDialog.this.dismiss();
        }

        public boolean shouldOverrideUrlLoading(WebView object, String string) {
            Debug.Log.d((String)"Facebook-WebView", (String)("Redirect URL: " + string));
            if (string.startsWith("fbconnect://success")) {
                Bundle bundle = Util.parseUrl(string);
                string = bundle.getString("error");
                object = string;
                if (string == null) {
                    object = bundle.getString("error_type");
                }
                if (object == null) {
                    FbDialog.this.mListener.onComplete(bundle);
                } else if (((String)object).equals("access_denied") || ((String)object).equals("OAuthAccessDeniedException")) {
                    FbDialog.this.mListener.onCancel();
                } else {
                    FbDialog.this.mListener.onFacebookError(new FacebookError((String)object));
                }
                FbDialog.this.dismiss();
                return true;
            }
            if (string.startsWith("fbconnect://cancel")) {
                FbDialog.this.mListener.onCancel();
                FbDialog.this.dismiss();
                return true;
            }
            if (string.contains(FbDialog.DISPLAY_STRING)) {
                return false;
            }
            FbDialog.this.getContext().startActivity(new Intent("android.intent.action.VIEW", Uri.parse((String)string)));
            return true;
        }
    }
}

