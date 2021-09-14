package com.ea.ironmonkey;

import android.provider.Settings;
import com.eamobile.licensing.ILicenseServerActivityCallback;
import com.eamobile.licensing.LicenseServerActivity;

/* access modifiers changed from: package-private */
public class GoogleDrm implements ILicenseServerActivityCallback {
    private static final String NA_BASE64_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAsPSqZyfa7iZ9DOslXqDVPiyjsIjCCCDsp1x4pcuH9gFiivyVWhIAHrfMdLlg+6UmlbUoSyKwNRUKJA+H5N/L792/PewpOe2yXSvsqtdROJ12O34q8DPC2D7ezL8M/Io3bp9x18u/D5lf2PEQq4uBNEV1W1iK3PtsdWdpmNKMvnPDQXT3vciWdKa1R0g2xRHCXEK2Ft1Tlkx38ejAAmYvpvoP2e8IqnlwH2fz89G5nxnKdmGop1mz4KTZ8REmBCnmTb07fRkSd4N7S64W2zu8lktMUUbGvCmRbt4zE48AzXEWmyHNW+mqx+IUKyK5wHObnDM9RSwKLWsDe++rrGgROQIDAQAB";
    private static final String ROW_BASE64_PUBLIC_KEY = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAjDe1oWKcLp/Rtm1ezKa9G+fHdqKvWExNR1aYuudU5VGX9gTby6w8UPKLHXeWxuOq2mS2hWxjIXVsOanspXWJbnBaqydpXmNz+0qZ0K6VlEiL7YvVL9KHNpVAck1bz4toLrmrjM6E/RyphBl+3W5+XSGOJ4Z3dabuz/TQdgNlYAr9nd1NlLg8S2Pu1FsFygy79kpwKBDZFUiCTDwzmGgLSetFnOfr0NwC+NnF/bEB6gE3REcdtT0zyFj0SR8ZWIKRvRPu5BYXe9nKguLN0AUvshXm/MjhrxKmRWTjTTKZkax+f3zFut/yq8UDxMwGA15Ex60xkCcELgCcNPBrWdFDtQIDAQAB";
    private static final byte[] SALT = {13, -1, 23, -45, 11, -28, 56, -1, -14, 24, -12, 98, -13, 49, 11, 15, -27, 93, 86, -24};
    private GameActivity _activity;
    private String publicKey = NA_BASE64_PUBLIC_KEY;

    public GoogleDrm(GameActivity gameActivity) {
        this._activity = gameActivity;
        if (this._activity.getPackageName().endsWith("_row")) {
            this.publicKey = ROW_BASE64_PUBLIC_KEY;
        }
    }

    public void destroy() {
        LicenseServerActivity.getInstance().destroyLicenseServerActvity();
    }

    public boolean isEnable() {
        return false;
    }

    @Override // com.eamobile.licensing.ILicenseServerActivityCallback
    public void onLicenseResultEnd() {
        GameActivity gameActivity = this._activity;
        GameActivity gameActivity2 = this._activity;
        gameActivity.onResult("GOOGL_DRM", 0);
        LicenseServerActivity.getInstance().destroyLicenseServerActvity();
    }

    @Override // com.eamobile.licensing.ILicenseServerActivityCallback
    public void onLicenseResultStart() {
        GameActivity gameActivity = this._activity;
        LicenseServerActivity.getInstance().LastCheckPointCheck();
        GameActivity gameActivity2 = this._activity;
        gameActivity.onResult("GOOGL_DRM", -1);
        LicenseServerActivity.getInstance().destroyLicenseServerActvity();
    }

    public void start() {
        LicenseServerActivity.getInstance().initLicenseServerActivity(this._activity, this, this._activity, SALT, this._activity.getPackageName(), this.publicKey, Settings.Secure.getString(this._activity.getContentResolver(), "android_id"));
    }
}
