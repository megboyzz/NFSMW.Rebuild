package com.ea.easp.mtx.market.amazon;

import android.app.Activity;
import com.amazon.inapp.purchasing.BasePurchasingObserver;
import com.amazon.inapp.purchasing.ItemDataResponse;
import com.amazon.inapp.purchasing.PurchaseResponse;
import com.amazon.inapp.purchasing.PurchaseUpdatesResponse;

/* access modifiers changed from: package-private */
public class AmazonPurchasingObserver extends BasePurchasingObserver {
    private AmazonPurchasingEventHandler mEventHandler = null;

    /* access modifiers changed from: package-private */
    public interface AmazonPurchasingEventHandler {
        void onItemDataResponse(ItemDataResponse itemDataResponse);

        void onPurchaseResponse(PurchaseResponse purchaseResponse);

        void onPurchaseUpdatesResponse(PurchaseUpdatesResponse purchaseUpdatesResponse);
    }

    public AmazonPurchasingObserver(Activity activity, AmazonPurchasingEventHandler amazonPurchasingEventHandler) {
        super(activity);
        this.mEventHandler = amazonPurchasingEventHandler;
    }

    @Override // com.amazon.inapp.purchasing.PurchasingObserver, com.amazon.inapp.purchasing.BasePurchasingObserver
    public void onItemDataResponse(ItemDataResponse itemDataResponse) {
        if (this.mEventHandler != null) {
            this.mEventHandler.onItemDataResponse(itemDataResponse);
        }
    }

    @Override // com.amazon.inapp.purchasing.PurchasingObserver, com.amazon.inapp.purchasing.BasePurchasingObserver
    public void onPurchaseResponse(PurchaseResponse purchaseResponse) {
        if (this.mEventHandler != null) {
            this.mEventHandler.onPurchaseResponse(purchaseResponse);
        }
    }

    @Override // com.amazon.inapp.purchasing.PurchasingObserver, com.amazon.inapp.purchasing.BasePurchasingObserver
    public void onPurchaseUpdatesResponse(PurchaseUpdatesResponse purchaseUpdatesResponse) {
        if (this.mEventHandler != null) {
            this.mEventHandler.onPurchaseUpdatesResponse(purchaseUpdatesResponse);
        }
    }

    @Override // com.amazon.inapp.purchasing.PurchasingObserver, com.amazon.inapp.purchasing.BasePurchasingObserver
    public void onSdkAvailable(boolean z) {
        System.out.println((z ? "sandbox" : "production") + " mode");
    }
}
