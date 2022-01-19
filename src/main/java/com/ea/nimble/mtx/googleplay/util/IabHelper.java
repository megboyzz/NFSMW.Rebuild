/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.app.Activity
 *  android.app.PendingIntent
 *  android.content.BroadcastReceiver
 *  android.content.ComponentName
 *  android.content.Context
 *  android.content.Intent
 *  android.content.IntentFilter
 *  android.content.IntentSender$SendIntentException
 *  android.content.ServiceConnection
 *  android.content.pm.ResolveInfo
 *  android.os.Bundle
 *  android.os.Handler
 *  android.os.IBinder
 *  android.os.Looper
 *  android.os.RemoteException
 *  android.text.TextUtils
 *  org.json.JSONException
 */
package com.ea.nimble.mtx.googleplay.util;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.RemoteException;
import android.text.TextUtils;
import com.ea.nimble.ApplicationEnvironment;
import com.ea.nimble.Log;
import com.ea.nimble.LogSource;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;

public class IabHelper
implements LogSource {
    public static final int BILLING_RESPONSE_RESULT_BILLING_UNAVAILABLE = 3;
    public static final int BILLING_RESPONSE_RESULT_DEVELOPER_ERROR = 5;
    public static final int BILLING_RESPONSE_RESULT_ERROR = 6;
    public static final int BILLING_RESPONSE_RESULT_ITEM_ALREADY_OWNED = 7;
    public static final int BILLING_RESPONSE_RESULT_ITEM_NOT_OWNED = 8;
    public static final int BILLING_RESPONSE_RESULT_ITEM_UNAVAILABLE = 4;
    public static final int BILLING_RESPONSE_RESULT_OK = 0;
    public static final int BILLING_RESPONSE_RESULT_USER_CANCELED = 1;
    public static final String GET_SKU_DETAILS_ITEM_LIST = "ITEM_ID_LIST";
    public static final String GET_SKU_DETAILS_ITEM_TYPE_LIST = "ITEM_TYPE_LIST";
    public static final int IABHELPER_BAD_RESPONSE = -1002;
    public static final int IABHELPER_BAD_STATE_ERROR = -1008;
    public static final int IABHELPER_ERROR_BASE = -1000;
    public static final int IABHELPER_MISSING_TOKEN = -1007;
    public static final int IABHELPER_REMOTE_EXCEPTION = -1001;
    public static final int IABHELPER_SEND_INTENT_FAILED = -1004;
    public static final int IABHELPER_UNKNOWN_ERROR = -1009;
    public static final int IABHELPER_UNKNOWN_PURCHASE_RESPONSE = -1006;
    public static final int IABHELPER_USER_CANCELLED = -1005;
    public static final int IABHELPER_VERIFICATION_FAILED = -1003;
    public static final String INAPP_CONTINUATION_TOKEN = "INAPP_CONTINUATION_TOKEN";
    public static final String ITEM_TYPE_INAPP = "inapp";
    public static final String RESPONSE_BUY_INTENT = "BUY_INTENT";
    public static final String RESPONSE_CODE = "RESPONSE_CODE";
    public static final String RESPONSE_GET_SKU_DETAILS_LIST = "DETAILS_LIST";
    public static final String RESPONSE_INAPP_ITEM_LIST = "INAPP_PURCHASE_ITEM_LIST";
    public static final String RESPONSE_INAPP_PURCHASE_DATA = "INAPP_PURCHASE_DATA";
    public static final String RESPONSE_INAPP_PURCHASE_DATA_LIST = "INAPP_PURCHASE_DATA_LIST";
    public static final String RESPONSE_INAPP_SIGNATURE = "INAPP_DATA_SIGNATURE";
    public static final String RESPONSE_INAPP_SIGNATURE_LIST = "INAPP_DATA_SIGNATURE_LIST";
    boolean mAsyncInProgress = false;
    AsyncOperation mAsyncOperation;
    LinkedList<AsyncOperation> mAsyncRequestQueue;
    Context mContext;
    boolean mDebugLog = false;
    String mDebugTag = "IabHelper";
    OnIabPurchaseFinishedListener mPurchaseListener;
    IabPurchaseUpdateReceiver mPurchaseUpdateReceiver = null;
    int mRequestCode;
    ServiceConnection mServiceConn;
    boolean mSetupDone = false;
    String mSignatureBase64 = null;

    public IabHelper(Context context, String string2) {
        this.mContext = context.getApplicationContext();
        if (this.mContext == null) {
            this.logError("IabHelper initializing with null application context!");
        }
        this.mSignatureBase64 = string2;
        this.logDebug("IAB helper created.");
        this.mAsyncRequestQueue = new LinkedList();
    }

    private void checkAndPopAsyncQueue() {
        if (this.mAsyncRequestQueue.size() <= 0) return;
        AsyncOperation asyncOperation = this.mAsyncRequestQueue.removeFirst();
        this.flagStartAsync(asyncOperation);
        asyncOperation.run();
    }

    private void enqueueOperation(AsyncOperation asyncOperation) {
        this.logDebug("Enqueuing operation " + asyncOperation.getName() + " to execute after current async op, " + this.mAsyncOperation.getName() + ", is finished.");
        this.mAsyncRequestQueue.add(asyncOperation);
    }

    public static String getResponseDesc(int n2) {
        String[] stringArray = "0:OK/1:User Canceled/2:Unknown/3:Billing Unavailable/4:Item unavailable/5:Developer Error/6:Error/7:Item Already Owned/8:Item not owned".split("/");
        String[] stringArray2 = "0:OK/-1001:Remote exception during initialization/-1002:Bad response received/-1003:Purchase signature verification failed/-1004:Send intent failed/-1005:User cancelled/-1006:Unknown purchase response/-1007:Missing token/-1008:Unknown error".split("/");
        if (n2 <= -1000) {
            int n3 = -1000 - n2;
            if (n3 < 0) return String.valueOf(n2) + ":Unknown IAB Helper Error";
            if (n3 >= stringArray2.length) return String.valueOf(n2) + ":Unknown IAB Helper Error";
            return stringArray2[n3];
        }
        if (n2 < 0) return String.valueOf(n2) + ":Unknown";
        if (n2 < stringArray.length) return stringArray[n2];
        return String.valueOf(n2) + ":Unknown";
    }

    private void startOrQueueRunnable(AsyncOperation asyncOperation) {
        synchronized (this) {
            if (this.isAsyncInProgress()) {
                this.enqueueOperation(asyncOperation);
            } else {
                this.flagStartAsync(asyncOperation);
                asyncOperation.run();
            }
            return;
        }
    }

    void checkSetupDone(String string2) {
        if (this.mSetupDone) return;
        this.logError("Illegal state for operation (" + string2 + "): IAB helper is not set up.");
        throw new IllegalStateException("IAB helper is not set up. Can't perform operation: " + string2);
    }

    void consume(Purchase purchase) throws IabException {
        String string2;
        String string3;
        this.checkSetupDone("consume");
        string3 = purchase.getToken();
        string2 = purchase.getSku();
        if (string3 == null || string3.equals("")) {
            this.logError("Can't consume " + string2 + ". No token.");
            throw new IabException(-1007, "PurchaseInfo is missing token for sku: " + string2 + " " + purchase);
        }
        this.logDebug("Consuming sku: " + string2 + ", token: " + string3);
        int n2 = 0;
        this.logDebug("Successfully consumed sku: " + string2);
    }

    public void consumeAsync(Purchase purchase, OnConsumeFinishedListener onConsumeFinishedListener) {
        ArrayList<Purchase> arrayList = new ArrayList<Purchase>();
        arrayList.add(purchase);
        this.consumeAsyncInternal(arrayList, onConsumeFinishedListener, null);
    }

    public void consumeAsync(List<Purchase> list, OnConsumeMultiFinishedListener onConsumeMultiFinishedListener) {
        this.consumeAsyncInternal(list, null, onConsumeMultiFinishedListener);
    }

    void consumeAsyncInternal(final List<Purchase> list, final OnConsumeFinishedListener onConsumeFinishedListener, OnConsumeMultiFinishedListener onConsumeMultiFinishedListener) {
        Looper looper;
        Looper looper2 = looper = Looper.myLooper();
        if (looper == null) {
            looper2 = Looper.getMainLooper();
        }
        final Handler h = new Handler(looper2);
        this.startOrQueueRunnable(new AsyncOperation("consume", true, new Runnable(){
            final /* synthetic */ Handler handler = h;
            /* synthetic */ final OnConsumeMultiFinishedListener val$multiListener = onConsumeMultiFinishedListener;

            @Override
            public void run() {
                final ArrayList<IabResult> arrayList = new ArrayList<IabResult>();
                for (Purchase purchase : list) {
                    try {
                        IabHelper.this.consume(purchase);
                        arrayList.add(new IabResult(0, "Successful consume of sku " + purchase.getSku()));
                    }
                    catch (IabException iabException) {
                        arrayList.add(iabException.getResult());
                    }
                }
                IabHelper.this.flagEndAsync();
                if (onConsumeFinishedListener != null) {
                    this.handler.post(() -> onConsumeFinishedListener.onConsumeFinished((Purchase)list.get(0), (IabResult)arrayList.get(0)));
                }
                if (this.val$multiListener == null) return;
                this.handler.post(() -> val$multiListener.onConsumeMultiFinished(list, arrayList));
            }
        }));
    }

    public void dispose() {
        this.logDebug("Disposing.");
        this.mSetupDone = false;
        if (this.mServiceConn == null) return;
        this.logDebug("Unbinding from service.");
        if (this.mContext != null) {
            this.mContext.unbindService(this.mServiceConn);
        }
        this.mServiceConn = null;
        this.mPurchaseListener = null;
    }

    public void enableDebugLogging(boolean bl2) {
        this.mDebugLog = bl2;
    }

    public void enableDebugLogging(boolean bl2, String string2) {
        this.mDebugLog = bl2;
        this.mDebugTag = string2;
    }

    void flagEndAsync() {
        synchronized (this) {
            this.logDebug("Ending async operation: " + this.mAsyncOperation.getName());
            this.mAsyncOperation = null;
            this.mAsyncInProgress = false;
            this.checkAndPopAsyncQueue();
            return;
        }
    }

    void flagStartAsync(AsyncOperation asyncOperation) {
        if (this.mAsyncInProgress) {
            throw new IllegalStateException("Can't start async operation (" + asyncOperation.getName() + ") because another async operation(" + this.mAsyncOperation.getName() + ") is in progress.");
        }
        this.mAsyncOperation = asyncOperation;
        this.mAsyncInProgress = true;
        this.logDebug("Starting async operation: " + asyncOperation.getName());
    }

    @Override
    public String getLogSourceTitle() {
        return "MTX Google IABHelper";
    }

    int getResponseCodeFromBundle(Bundle object) {
        if (object.get(RESPONSE_CODE) == null) {
            this.logDebug("Bundle with null response code, assuming OK (known issue)");
            return 0;
        }
        this.logError("Unexpected type for bundle response code.");
        this.logError(object.getClass().getName());
        throw new RuntimeException("Unexpected type for bundle response code: " + object.getClass().getName());
    }

    int getResponseCodeFromIntent(Intent object) {
        if (object.getExtras().get(RESPONSE_CODE) == null) {
            this.logError("Intent with no response code, assuming OK (known issue)");
            return 0;
        }
        this.logError("Unexpected type for intent response code.");
        this.logError(object.getClass().getName());
        throw new RuntimeException("Unexpected type for intent response code: " + object.getClass().getName());
    }

    public boolean handleActivityResult(int n2, int n3, Intent object) {
        this.logDebug("handleActivityResult...");
        if (n2 != this.mRequestCode) {
            return false;
        }
        this.checkSetupDone("handleActivityResult");
        this.flagEndAsync();
        if (object == null) {
            this.logError("Null data in IAB activity result.");
            IabResult result = new IabResult(-1002, "Null data in IAB result");
            if (this.mPurchaseListener == null) return true;
            this.mPurchaseListener.onIabPurchaseFinished(result, null);
            return true;
        }
        n2 = this.getResponseCodeFromIntent((Intent)object);
        String string2 = object.getStringExtra(RESPONSE_INAPP_PURCHASE_DATA);
        String string3 = object.getStringExtra(RESPONSE_INAPP_SIGNATURE);
        if (n3 == -1 && n2 == 0) {
            this.logDebug("Successful resultcode from purchase activity.");
            this.logDebug("Purchase data: " + string2);
            this.logDebug("Data signature: " + string3);
            this.logDebug("Extras: " + object.getExtras());
            if (string2 == null || string3 == null) {
                this.logError("BUG: either purchaseData or dataSignature is null.");
                this.logDebug("Extras: " + object.getExtras().toString());
                IabResult iabResult = new IabResult(-1009, "IAB returned null purchaseData or dataSignature");
                if (this.mPurchaseListener == null) return true;
                this.mPurchaseListener.onIabPurchaseFinished(iabResult, null);
                return true;
            }
            try {
                Purchase purchase = new Purchase(string2, string3);
                if (this.mPurchaseListener == null) return true;
                this.mPurchaseListener.onIabPurchaseFinished(new IabResult(0, "Success"), purchase);
                return true;
            }
            catch (JSONException jSONException) {
                this.logError("Failed to parse purchase data.");
                jSONException.printStackTrace();
                IabResult iabResult = new IabResult(-1002, "Failed to parse purchase data.");
                if (this.mPurchaseListener == null) return true;
                this.mPurchaseListener.onIabPurchaseFinished(iabResult, null);
                return true;
            }
        }
        if (n3 == -1) {
            this.logDebug("Result code was OK but in-app billing response was not OK: " + IabHelper.getResponseDesc(n2));
            if (this.mPurchaseListener == null) return true;
            IabResult iabResult = new IabResult(n2, "Problem purchashing item.");
            this.mPurchaseListener.onIabPurchaseFinished(iabResult, null);
            return true;
        }
        if (n3 == 0) {
            this.logDebug("Google Play Activity canceled - Response: " + IabHelper.getResponseDesc(n2));
            IabResult iabResult = new IabResult(n2, "Problem purchashing item.");
            if (this.mPurchaseListener == null) return true;
            this.mPurchaseListener.onIabPurchaseFinished(iabResult, null);
            return true;
        }
        this.logError("Purchase failed. Result code: " + Integer.toString(n3) + ". Response: " + IabHelper.getResponseDesc(n2));
        IabResult iabResult = new IabResult(-1006, "Unknown purchase response.");
        if (this.mPurchaseListener == null) return true;
        this.mPurchaseListener.onIabPurchaseFinished(iabResult, null);
        return true;
    }

    boolean isAsyncInProgress() {
        return this.mAsyncInProgress;
    }

    public boolean isServiceAvailable() {
        return this.mSetupDone;
    }

    public void launchPurchaseFlow(Activity activity, String string2, int n2, OnIabPurchaseFinishedListener onIabPurchaseFinishedListener) {
        this.launchPurchaseFlow(activity, string2, n2, onIabPurchaseFinishedListener, "");
    }

    public void launchPurchaseFlow(final Activity activity, final String string2, final int n2, final OnIabPurchaseFinishedListener onIabPurchaseFinishedListener, final String string3) {
        synchronized (this) {
            this.startOrQueueRunnable(new AsyncOperation("launchPurchaseFlow", false, new Runnable(){

                /*
                 * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
                 * Enabled unnecessary exception pruning
                 */
                @Override
                public void run() {
                    Object object;
                    try {
                        IabHelper.this.logDebug("Constructing buy intent for " + string2);
                        object = IabHelper.this.mService.getBuyIntent(3, IabHelper.this.mContext.getPackageName(), string2, IabHelper.ITEM_TYPE_INAPP, string3);
                        int n22 = IabHelper.this.getResponseCodeFromBundle((Bundle)object);
                        if (n22 != 0) {
                            IabHelper.this.logDebug("BuyIntent Bundle: " + object);
                            IabHelper.this.logError("Unable to buy item, Error response: " + IabHelper.getResponseDesc(n22));
                            IabHelper.this.flagEndAsync();
                            object = new IabResult(n22, "Unable to buy item");
                            OnIabPurchaseFinishedListener onIabPurchaseFinishedListener2 = onIabPurchaseFinishedListener;
                            if (onIabPurchaseFinishedListener2 == null) return;
                            try {
                                onIabPurchaseFinishedListener.onIabPurchaseFinished((IabResult)object, null);
                                return;
                            }
                            catch (Exception exception) {
                                IabHelper.this.logError("Uncaught exception in listener's onIabPurchaseFinished: " + exception);
                                return;
                            }
                        }
                    }
                    catch (IntentSender.SendIntentException sendIntentException) {
                        IabHelper.this.logError("SendIntentException while launching purchase flow for sku " + string2);
                        sendIntentException.printStackTrace();
                        IabResult iabResult = new IabResult(-1004, "Failed to send intent.");
                        if (onIabPurchaseFinishedListener != null) {
                            onIabPurchaseFinishedListener.onIabPurchaseFinished(iabResult, null);
                        }
                        IabHelper.this.flagEndAsync();
                        return;
                    }
                    catch (RemoteException remoteException) {
                        IabHelper.this.logError("RemoteException while launching purchase flow for sku " + string2);
                        remoteException.printStackTrace();
                        IabResult iabResult = new IabResult(-1001, "Remote exception while starting purchase flow");
                        if (onIabPurchaseFinishedListener != null) {
                            onIabPurchaseFinishedListener.onIabPurchaseFinished(iabResult, null);
                        }
                        IabHelper.this.flagEndAsync();
                        return;
                    }
                    {
                        object = (PendingIntent)object.getParcelable(IabHelper.RESPONSE_BUY_INTENT);
                        IabHelper.this.logDebug("Launching buy intent for " + string2 + ". Request code: " + n2);
                        IabHelper.this.mRequestCode = n2;
                        IabHelper.this.mPurchaseListener = onIabPurchaseFinishedListener;
                        activity.startIntentSenderForResult(object.getIntentSender(), n2, new Intent(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue(), Integer.valueOf(0).intValue());
                        return;
                    }
                }
            }));
            return;
        }
    }

    void logDebug(String string2) {
        Log.Helper.LOGD(this, string2, new Object[0]);
    }

    void logError(String string2) {
        Log.Helper.LOGE(this, string2, new Object[0]);
    }

    void logWarn(String string2) {
        Log.Helper.LOGW(this, string2, new Object[0]);
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled unnecessary exception pruning
     */
    public Inventory queryInventory(boolean bl2, boolean bl3, List<String> list) throws IabException {
        int n2;
        Inventory inventory;
        try {
            this.checkSetupDone("queryInventory");
            inventory = new Inventory();
            if (bl2 && (n2 = this.queryPurchases(inventory)) != 0) {
                throw new IabException(n2, "Error refreshing inventory (querying owned items).");
            }
        }
        catch (RemoteException remoteException) {
            throw new IabException(-1001, "Remote exception while refreshing inventory.", (Exception)((Object)remoteException));
        }
        catch (JSONException jSONException) {
            throw new IabException(-1002, "Error parsing JSON response while refreshing inventory.", (Exception)((Object)jSONException));
        }
        catch (IllegalStateException illegalStateException) {
            throw new IabException(-1008, "IabHelper in a bad state (billing service not connected, application context is null, etc.", illegalStateException);
        }
        if (!bl3) return inventory;
        {
            n2 = this.querySkuDetails(inventory, list);
            if (n2 == 0) return inventory;
            throw new IabException(n2, "Error refreshing inventory (querying prices of items).");
        }
    }

    public void queryInventoryAsync(QueryInventoryFinishedListener queryInventoryFinishedListener) {
        this.queryInventoryAsync(true, true, null, queryInventoryFinishedListener);
    }

    public void queryInventoryAsync(boolean bl2, boolean bl3, QueryInventoryFinishedListener queryInventoryFinishedListener) {
        this.queryInventoryAsync(bl2, bl3, null, queryInventoryFinishedListener);
    }

    public void queryInventoryAsync(final boolean bl2, final boolean bl3, final List<String> list, QueryInventoryFinishedListener queryInventoryFinishedListener) {
        Looper looper;
        Looper looper2 = looper = Looper.myLooper();
        if (looper == null) {
            looper2 = Looper.getMainLooper();
        }
        this.startOrQueueRunnable(new AsyncOperation("queryInventory", true, new Runnable(new Handler(looper2), queryInventoryFinishedListener){
            final /* synthetic */ Handler val$handler;
            final /* synthetic */ QueryInventoryFinishedListener val$listener;
            {
                this.val$handler = handler;
                this.val$listener = queryInventoryFinishedListener;
            }

            /*
             * Unable to fully structure code
             */
            @Override
            public void run() {
                var2_1 = new IabResult(0, "Inventory refresh successful.");
                var1_3 = null;
                try {
                    var1_3 = var3_4 = IabHelper.this.queryInventory(bl2, bl3, list);
lbl5:
                    // 2 sources

                    while (true) {
                        IabHelper.this.flagEndAsync();
                        break;
                    }
                }
                catch (IabException var2_2) {
                    var2_1 = var2_2.getResult();
                    ** continue;
                }
                this.val$handler.post(new Runnable(){

                    @Override
                    public void run() {
                        val$listener.onQueryInventoryFinished(var2_1, var1_3);
                    }
                });
            }
        }));
    }

    int queryPurchases(Inventory inventory) throws JSONException, RemoteException, IllegalStateException {
        int n2;
        Object object;
        this.logDebug("Querying owned items...");
        this.logDebug("Package name: " + this.mContext.getPackageName());
        int n3 = 0;
        Object object2 = null;
        IInAppBillingService iInAppBillingService = this.mService;
        if (iInAppBillingService == null) {
            throw new IllegalStateException("Billing service is not connected.");
        }
        if (this.mContext == null) {
            throw new IllegalStateException("InAppBilling application context is unset.");
        }
        do {
            this.logDebug("Calling getPurchases with continuation token: " + object2);
            object2 = iInAppBillingService.getPurchases(3, this.mContext.getPackageName(), ITEM_TYPE_INAPP, (String)object2);
            if (object2 == null) {
                throw new IllegalStateException("Billing service is not connected.");
            }
            n2 = this.getResponseCodeFromBundle((Bundle)object2);
            this.logDebug("Owned items response: " + String.valueOf(n2));
            if (n2 != 0) {
                this.logDebug("getPurchases() failed: " + IabHelper.getResponseDesc(n2));
                return n2;
            }
            if (!(object2.containsKey(RESPONSE_INAPP_ITEM_LIST) && object2.containsKey(RESPONSE_INAPP_PURCHASE_DATA_LIST) && object2.containsKey(RESPONSE_INAPP_SIGNATURE_LIST))) {
                this.logError("Bundle returned from getPurchases() doesn't contain required fields.");
                return -1002;
            }
            object = object2.getStringArrayList(RESPONSE_INAPP_ITEM_LIST);
            ArrayList arrayList = object2.getStringArrayList(RESPONSE_INAPP_PURCHASE_DATA_LIST);
            ArrayList arrayList2 = object2.getStringArrayList(RESPONSE_INAPP_SIGNATURE_LIST);
            int n4 = 0;
            n2 = n3;
            for (n3 = n4; n3 < arrayList.size(); ++n3) {
                String string2 = (String)arrayList.get(n3);
                Object object3 = (String)arrayList2.get(n3);
                String string3 = (String)((ArrayList)object).get(n3);
                if (this.mSignatureBase64 == null) {
                    Log.Helper.LOGV(this, "App public key not set. Skipping client-side validation.", new Object[0]);
                } else {
                    Log.Helper.LOGD(this, "Signature((%s))", this.mSignatureBase64);
                }
                Log.Helper.LOGD(this, "purchaseData((%s))", string2);
                Log.Helper.LOGD(this, "signature((%s))", object3);
                if (this.mSignatureBase64 == null || Security.verifyPurchase(this.mSignatureBase64, string2, (String)object3)) {
                    this.logDebug("Sku is owned: " + string3);
                    object3 = new Purchase(string2, (String)object3);
                    if (TextUtils.isEmpty((CharSequence)((Purchase)object3).getToken())) {
                        this.logWarn("BUG: empty/null token!");
                        this.logDebug("Purchase data: " + string2);
                    }
                    inventory.addPurchase((Purchase)object3);
                    continue;
                }
                this.logWarn("Purchase signature verification **FAILED**. Not adding item.");
                this.logDebug("   Purchase data: " + string2);
                this.logDebug("   Signature: " + (String)object3);
                n2 = 1;
            }
            object = object2.getString(INAPP_CONTINUATION_TOKEN);
            this.logDebug("Continuation token: " + (String)object);
            object2 = object;
            n3 = n2;
        } while (!TextUtils.isEmpty((CharSequence)object));
        if (n2 == 0) return 0;
        return -1003;
    }

    int querySkuDetails(Inventory inventory, List<String> object) throws RemoteException, JSONException, IllegalStateException {
        this.logDebug("Querying SKU details.");
        IInAppBillingService iInAppBillingService = this.mService;
        if (iInAppBillingService == null) {
            throw new IllegalStateException("Billing service is not connected.");
        }
        if (this.mContext == null) {
            throw new IllegalStateException("InAppBilling application context is unset.");
        }
        ArrayList<String> arrayList = new ArrayList<String>();
        arrayList.addAll(inventory.getAllOwnedSkus());
        if (object != null) {
            arrayList.addAll((Collection<String>)object);
        }
        if (arrayList.size() == 0) {
            this.logDebug("queryPrices: nothing to do because there are no SKUs.");
            return 0;
        }
        int n2 = 0;
        block0: while (n2 != arrayList.size()) {
            int n3 = arrayList.size() - n2 > 20 ? n2 + 20 : arrayList.size();
            object = new ArrayList<String>(arrayList.subList(n2, n3));
            Object object2 = new Bundle();
            object2.putStringArrayList(GET_SKU_DETAILS_ITEM_LIST, object);
            object = iInAppBillingService.getSkuDetails(3, this.mContext.getPackageName(), ITEM_TYPE_INAPP, (Bundle)object2);
            if (object == null) {
                throw new IllegalStateException("Billing service is not connected.");
            }
            if (!object.containsKey(RESPONSE_GET_SKU_DETAILS_LIST)) {
                n3 = this.getResponseCodeFromBundle((Bundle)object);
                if (n3 != 0) {
                    this.logDebug("getSkuDetails() failed: " + IabHelper.getResponseDesc(n3));
                    return n3;
                }
                this.logError("getSkuDetails() returned a bundle with neither an error nor a detail list.");
                return -1002;
            }
            object = object.getStringArrayList(RESPONSE_GET_SKU_DETAILS_LIST).iterator();
            while (true) {
                n2 = n3;
                if (!object.hasNext()) continue block0;
                object2 = new SkuDetails((String)object.next());
                this.logDebug("Got sku details: " + object2);
                inventory.addSkuDetails((SkuDetails)object2);
            }
            break;
        }
        return 0;
    }

    public void setApplicationPublicKey(String string2) {
        this.mSignatureBase64 = string2;
    }

    public void startSetup(final OnIabSetupFinishedListener onIabSetupFinishedListener, final OnIabBroadcastListener onIabBroadcastListener) {
        if (this.mSetupDone) {
            throw new IllegalStateException("IAB helper is already set up.");
        }
        this.logDebug("Starting in-app billing setup.");
        this.mServiceConn = new ServiceConnection(){

            /*
             * Unable to fully structure code
             * Could not resolve type clashes
             */
            public void onServiceConnected(ComponentName var1_1, IBinder var2_3) {
                IabHelper.this.logDebug("Billing service connected.");
                IabHelper.this.mService = IInAppBillingService.Stub.asInterface(var2_3);
                var1_1 /* !! */  = IabHelper.this.mContext.getPackageName();
                try {
                    IabHelper.this.logDebug("Checking for in-app billing 3 support.");
                    var3_4 = IabHelper.this.mService.isBillingSupported(3, (String)var1_1 /* !! */ , "inapp");
                    if (var3_4 != 0) {
                        if (onIabSetupFinishedListener == null) return;
                        onIabSetupFinishedListener.onIabSetupFinished(new IabResult(var3_4, "Error checking for billing v3 support."));
                        return;
                    }
                    IabHelper.this.logDebug("In-app billing version 3 supported for " + (String)var1_1 /* !! */ );
                    if (IabHelper.this.mPurchaseUpdateReceiver == null) {
                        IabHelper.this.mPurchaseUpdateReceiver = new IabPurchaseUpdateReceiver(onIabBroadcastListener);
                        var1_1 /* !! */  = new IntentFilter("com.android.vending.billing.PURCHASES_UPDATED");
                        ApplicationEnvironment.getComponent().getApplicationContext().registerReceiver((BroadcastReceiver)IabHelper.this.mPurchaseUpdateReceiver, (IntentFilter)var1_1 /* !! */ );
                    }
                    IabHelper.this.mSetupDone = true;
lbl18:
                    // 2 sources

                    while (true) {
                        if (onIabSetupFinishedListener == null) return;
                        onIabSetupFinishedListener.onIabSetupFinished(new IabResult(0, "Setup successful."));
                        return;
                    }
                }
                catch (RemoteException var1_2) {
                    if (onIabSetupFinishedListener != null) {
                        onIabSetupFinishedListener.onIabSetupFinished(new IabResult(-1001, "RemoteException while setting up in-app billing."));
                    }
                    var1_2.printStackTrace();
                    ** continue;
                }
            }

            public void onServiceDisconnected(ComponentName componentName) {
                IabHelper.this.logDebug("Billing service disconnected.");
                if (IabHelper.this.mPurchaseUpdateReceiver != null) {
                    ApplicationEnvironment.getComponent().getApplicationContext().unregisterReceiver((BroadcastReceiver)IabHelper.this.mPurchaseUpdateReceiver);
                    IabHelper.this.mPurchaseUpdateReceiver = null;
                }
                IabHelper.this.mService = null;
                IabHelper.this.mSetupDone = false;
            }
        };
        this.logDebug("...Starting in-app billing setup.");
        this.logDebug("Binding service...");
        onIabBroadcastListener = this.mContext.getPackageManager();
        onIabSetupFinishedListener = new Intent("com.android.vending.billing.InAppBillingService.BIND");
        onIabBroadcastListener = onIabBroadcastListener.resolveService((Intent)onIabSetupFinishedListener, 0);
        if (onIabBroadcastListener == null) {
            this.logError("Unable to get ResolveInfo for InAppBillingService intent. Cannot bind to InAppBillinbService");
            this.mServiceConn = null;
            return;
        }
        this.logDebug("PackageName = " + ((ResolveInfo)onIabBroadcastListener).serviceInfo.packageName);
        this.logDebug("ClassName = " + ((ResolveInfo)onIabBroadcastListener).serviceInfo.name);
        onIabSetupFinishedListener.setComponent(new ComponentName(((ResolveInfo)onIabBroadcastListener).serviceInfo.packageName, ((ResolveInfo)onIabBroadcastListener).serviceInfo.name));
        if (this.mContext.bindService((Intent)onIabSetupFinishedListener, this.mServiceConn, 1)) {
            this.logDebug("Success - Bind to InAppBillingService");
            return;
        }
        this.logError("Failed to Bind to InAppBillingService");
        this.mServiceConn = null;
    }

    private class AsyncOperation {
        private String m_name;
        private Runnable m_operation;
        private boolean m_runInNewThread;

        public AsyncOperation(String string2, boolean bl2, Runnable runnable) {
            this.m_name = string2;
            this.m_runInNewThread = bl2;
            this.m_operation = runnable;
            IabHelper.this.checkSetupDone(this.m_name);
        }

        public String getName() {
            return this.m_name;
        }

        public void run() {
            if (this.m_runInNewThread) {
                new Thread(this.m_operation).start();
                return;
            }
            this.m_operation.run();
        }
    }

    public class IabPurchaseUpdateReceiver
    extends BroadcastReceiver {
        private final OnIabBroadcastListener mListener;

        public IabPurchaseUpdateReceiver(OnIabBroadcastListener onIabBroadcastListener) {
            this.mListener = onIabBroadcastListener;
        }

        public void onReceive(Context context, Intent intent) {
            if (this.mListener == null) return;
            this.mListener.receivedBroadcast();
        }
    }

    public static interface OnConsumeFinishedListener {
        public void onConsumeFinished(Purchase var1, IabResult var2);
    }

    public static interface OnConsumeMultiFinishedListener {
        public void onConsumeMultiFinished(List<Purchase> var1, List<IabResult> var2);
    }

    public static interface OnIabBroadcastListener {
        public void receivedBroadcast();
    }

    public static interface OnIabPurchaseFinishedListener {
        public void onIabPurchaseFinished(IabResult var1, Purchase var2);
    }

    public static interface OnIabSetupFinishedListener {
        public void onIabSetupFinished(IabResult var1);
    }

    public static interface QueryInventoryFinishedListener {
        public void onQueryInventoryFinished(IabResult var1, Inventory var2);
    }
}

