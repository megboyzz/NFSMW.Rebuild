/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.util.Base64
 */
package com.ea.nimble.mtx.catalog.synergy;

import android.util.Base64;
import com.ea.nimble.ApplicationEnvironment;
import com.ea.nimble.IApplicationEnvironment;
import com.ea.nimble.IHttpRequest;
import com.ea.nimble.ISynergyEnvironment;
import com.ea.nimble.Log;
import com.ea.nimble.LogSource;
import com.ea.nimble.Network;
import com.ea.nimble.NetworkConnectionCallback;
import com.ea.nimble.NetworkConnectionHandle;
import com.ea.nimble.SynergyEnvironment;
import com.ea.nimble.SynergyIdManager;
import com.ea.nimble.SynergyNetwork;
import com.ea.nimble.SynergyNetworkConnectionCallback;
import com.ea.nimble.SynergyNetworkConnectionHandle;
import com.ea.nimble.SynergyRequest;
import com.ea.nimble.Utility;
import com.ea.nimble.mtx.NimbleCatalogItem;
import com.ea.nimble.mtx.catalog.synergy.ItemCategory;
import com.ea.nimble.mtx.catalog.synergy.SynergyCatalogItem;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class SynergyCatalog
implements LogSource {
    public static final String MTX_INFO_KEY_CURRENCY = "localCurrency";
    private static final String SYNERGY_API_GET_AVAILABLE_ITEMS = "/product/api/core/getAvailableItems";
    private static final String SYNERGY_API_GET_CATEGORIES = "/product/api/core/getMTXGameCategories";
    private static final String SYNERGY_API_GET_DOWNLOAD_URL = "/product/api/core/getDownloadItemUrl";
    private static final String SYNERGY_API_GET_NONCE = "/drm/api/core/getNonce";
    private static final String SYNERGY_API_GET_PURCHASED_ITEMS = "/drm/api/core/getPurchasedItems";
    private String m_itemSkuPrefix;
    private int m_itemsLoadingBinaryData = 0;

    public SynergyCatalog(StoreType storeType) {
        if (storeType == StoreType.AMAZON) {
            this.m_itemSkuPrefix = ApplicationEnvironment.getComponent().getApplicationBundleId() + ".";
            return;
        }
        this.m_itemSkuPrefix = "";
    }

    static /* synthetic */ int access$106(SynergyCatalog synergyCatalog) {
        int n2;
        synergyCatalog.m_itemsLoadingBinaryData = n2 = synergyCatalog.m_itemsLoadingBinaryData - 1;
        return n2;
    }

    private SynergyCatalogItem createItemFromMap(Map<String, Object> object) {
        SynergyCatalogItem synergyCatalogItem = new SynergyCatalogItem();
        synergyCatalogItem.m_sku = this.m_itemSkuPrefix + object.get("sellId");
        synergyCatalogItem.m_title = (String)object.get("title");
        NimbleCatalogItem.ItemType itemType = (Boolean)object.get("consumable") != false ? NimbleCatalogItem.ItemType.CONSUMABLE : NimbleCatalogItem.ItemType.NONCONSUMABLE;
        synergyCatalogItem.m_type = itemType;
        synergyCatalogItem.m_description = (String)object.get("desc");
        synergyCatalogItem.m_metaDataUrl = (String)object.get("packUrl");
        synergyCatalogItem.m_isFree = (Boolean)object.get("free");
        synergyCatalogItem.m_additionalInfo.putAll((Map<String, Object>)object);
        object = (String)object.get("binaryPack");
        if (!Utility.validString((String)object)) return synergyCatalogItem;
        synergyCatalogItem.m_additionalInfo.put("binaryData", Base64.decode((String)object, (int)0));
        return synergyCatalogItem;
    }

    private void downloadContent(String string2, final DataCallback dataCallback) {
        try {
            URL uRL = new URL(string2);
            Network.getComponent().sendGetRequest(uRL, null, new NetworkConnectionCallback(){

                @Override
                public void callback(NetworkConnectionHandle networkConnectionHandle) {
                    if (networkConnectionHandle.getResponse().getError() == null) {
                        dataCallback.callback(networkConnectionHandle.getResponse().getDataStream(), null);
                        return;
                    }
                    dataCallback.callback(null, networkConnectionHandle.getResponse().getError());
                }
            });
            return;
        }
        catch (MalformedURLException malformedURLException) {
            Log.Helper.LOGE(this, "Invalid url: " + string2, new Object[0]);
            return;
        }
    }

    private void getDownloadUrlForItem(SynergyCatalogItem object, StringCallback object2) {
        object = new SynergyRequest.SynergyRequestPreparingCallback((SynergyCatalogItem)object){
            final /* synthetic */ SynergyCatalogItem val$item;
            {
                this.val$item = synergyCatalogItem;
            }

            @Override
            public void prepareRequest(SynergyRequest synergyRequest) {
                IApplicationEnvironment iApplicationEnvironment = ApplicationEnvironment.getComponent();
                synergyRequest.baseUrl = SynergyEnvironment.getComponent().getServerUrlWithKey("synergy.product");
                HashMap<String, String> hashMap = new HashMap<String, String>();
                hashMap.put("apiVer", "1.0.0");
                hashMap.put("ver", iApplicationEnvironment.getApplicationVersion());
                hashMap.put("uid", SynergyIdManager.getComponent().getSynergyId());
                hashMap.put("langCode", iApplicationEnvironment.getShortApplicationLanguageCode());
                hashMap.put("sellId", this.val$item.getSku().substring(SynergyCatalog.this.m_itemSkuPrefix.length()));
                synergyRequest.urlParameters = hashMap;
                synergyRequest.send();
            }
        };
        object2 = new SynergyNetworkConnectionCallback((StringCallback)object2){
            final /* synthetic */ StringCallback val$callback;
            {
                this.val$callback = stringCallback;
            }

            @Override
            public void callback(SynergyNetworkConnectionHandle object) {
                if (object.getResponse().getError() != null) {
                    this.val$callback.callback(null, object.getResponse().getError());
                    return;
                }
                if ((object = (List)((Map)object.getResponse().getJsonData().get("infoData")).get("fileURL")).size() > 0) {
                    object = (String)object.get(0);
                    this.val$callback.callback((String)object, null);
                    return;
                }
                object = new Exception("No urls for item");
                this.val$callback.callback(null, (Exception)object);
            }
        };
        object = new SynergyRequest(SYNERGY_API_GET_DOWNLOAD_URL, IHttpRequest.Method.GET, (SynergyRequest.SynergyRequestPreparingCallback)object);
        SynergyNetwork.getComponent().sendRequest((SynergyRequest)object, (SynergyNetworkConnectionCallback)object2);
    }

    public void downloadItem(SynergyCatalogItem synergyCatalogItem, final DataCallback dataCallback) {
        this.getDownloadUrlForItem(synergyCatalogItem, new StringCallback(){

            @Override
            public void callback(String string2, Exception exception) {
                if (exception == null) {
                    SynergyCatalog.this.downloadContent(string2, dataCallback);
                    return;
                }
                this.callback(null, exception);
            }
        });
    }

    public void getCategories(CategoryCallback object) {
        Object object2 = new SynergyRequest.SynergyRequestPreparingCallback(){

            @Override
            public void prepareRequest(SynergyRequest synergyRequest) {
                IApplicationEnvironment iApplicationEnvironment = ApplicationEnvironment.getComponent();
                ISynergyEnvironment iSynergyEnvironment = SynergyEnvironment.getComponent();
                synergyRequest.baseUrl = iSynergyEnvironment.getServerUrlWithKey("synergy.product");
                HashMap<String, String> hashMap = new HashMap<String, String>();
                hashMap.put("apiVer", "1.0.0");
                hashMap.put("masterSellId", iSynergyEnvironment.getSellId());
                hashMap.put("langCode", iApplicationEnvironment.getShortApplicationLanguageCode());
                synergyRequest.urlParameters = hashMap;
                synergyRequest.send();
            }
        };
        object = new SynergyNetworkConnectionCallback((CategoryCallback)object){
            final /* synthetic */ CategoryCallback val$callback;
            {
                this.val$callback = categoryCallback;
            }

            @Override
            public void callback(SynergyNetworkConnectionHandle object) {
                if (object.getResponse().getError() != null) {
                    this.val$callback.callback(null, object.getResponse().getError());
                    return;
                }
                Object object2 = (List)object.getResponse().getJsonData().get("gameCategoryData");
                object = new HashSet();
                object2 = object2.iterator();
                while (true) {
                    if (!object2.hasNext()) {
                        this.val$callback.callback((Set<ItemCategory>)object, null);
                        return;
                    }
                    Map map = (Map)object2.next();
                    ItemCategory itemCategory = new ItemCategory();
                    itemCategory.m_id = (Integer)map.get("categoryId");
                    itemCategory.m_title = (String)map.get("title");
                    itemCategory.m_regularImageData = Base64.decode((String)((String)map.get("imageOff")), (int)0);
                    itemCategory.m_selectedImageData = Base64.decode((String)((String)map.get("imageOn")), (int)0);
                    object.add(itemCategory);
                }
            }
        };
        object2 = new SynergyRequest(SYNERGY_API_GET_CATEGORIES, IHttpRequest.Method.GET, (SynergyRequest.SynergyRequestPreparingCallback)object2);
        SynergyNetwork.getComponent().sendRequest((SynergyRequest)object2, (SynergyNetworkConnectionCallback)object);
    }

    public void getItemCatalog(ItemCallback object) {
        Object object2 = new SynergyRequest.SynergyRequestPreparingCallback(){

            @Override
            public void prepareRequest(SynergyRequest synergyRequest) {
                IApplicationEnvironment iApplicationEnvironment = ApplicationEnvironment.getComponent();
                Object object = SynergyEnvironment.getComponent();
                synergyRequest.baseUrl = object.getServerUrlWithKey("synergy.product");
                HashMap<String, String> hashMap = new HashMap<String, String>();
                hashMap.put("masterSellId", object.getSellId());
                hashMap.put("typeSubstr", "1");
                hashMap.put("apiVer", "1.0.0");
                hashMap.put("ver", iApplicationEnvironment.getApplicationVersion());
                object = Utility.validString(SynergyIdManager.getComponent().getSynergyId()) ? SynergyIdManager.getComponent().getSynergyId() : "0";
                hashMap.put("uid", (String)object);
                hashMap.put("sdkVer", "1.23.14.1217");
                hashMap.put("langCode", iApplicationEnvironment.getShortApplicationLanguageCode());
                synergyRequest.urlParameters = hashMap;
                synergyRequest.send();
            }
        };
        object = new SynergyNetworkConnectionCallback((ItemCallback)object){
            final /* synthetic */ ItemCallback val$callback;
            {
                this.val$callback = itemCallback;
            }

            @Override
            public void callback(SynergyNetworkConnectionHandle object) {
                if (object.getResponse().getError() != null) {
                    this.val$callback.callback(null, object.getResponse().getError());
                    return;
                }
                Object object2 = (List)object.getResponse().getJsonData().get("productData");
                object = new ArrayList(object2.size());
                object2 = object2.iterator();
                while (true) {
                    if (!object2.hasNext()) {
                        this.val$callback.callback((List<SynergyCatalogItem>)object, null);
                        return;
                    }
                    Map map = (Map)object2.next();
                    object.add(SynergyCatalog.this.createItemFromMap(map));
                }
            }
        };
        object2 = new SynergyRequest(SYNERGY_API_GET_AVAILABLE_ITEMS, IHttpRequest.Method.GET, (SynergyRequest.SynergyRequestPreparingCallback)object2);
        SynergyNetwork.getComponent().sendRequest((SynergyRequest)object2, (SynergyNetworkConnectionCallback)object);
    }

    public String getItemSkuPrefix() {
        return this.m_itemSkuPrefix;
    }

    @Override
    public String getLogSourceTitle() {
        return "SynergyCatalog";
    }

    public void getNonce(StringCallback object) {
        Object object2 = new SynergyRequest.SynergyRequestPreparingCallback(){

            @Override
            public void prepareRequest(SynergyRequest synergyRequest) {
                ISynergyEnvironment iSynergyEnvironment = SynergyEnvironment.getComponent();
                synergyRequest.baseUrl = iSynergyEnvironment.getServerUrlWithKey("synergy.drm");
                HashMap<String, String> hashMap = new HashMap<String, String>();
                hashMap.put("apiVer", "1.0.0");
                hashMap.put("uid", SynergyIdManager.getComponent().getSynergyId());
                hashMap.put("masterSellId", iSynergyEnvironment.getSellId());
                synergyRequest.urlParameters = hashMap;
                synergyRequest.send();
            }
        };
        object = new SynergyNetworkConnectionCallback((StringCallback)object){
            final /* synthetic */ StringCallback val$callback;
            {
                this.val$callback = stringCallback;
            }

            @Override
            public void callback(SynergyNetworkConnectionHandle object) {
                if (object.getResponse().getError() != null) {
                    this.val$callback.callback(null, object.getResponse().getError());
                    return;
                }
                Object object2 = object.getResponse().getJsonData().get("nonce");
                object = "";
                if (object2 != null) {
                    object = object2.toString();
                }
                this.val$callback.callback((String)object, null);
            }
        };
        object2 = new SynergyRequest(SYNERGY_API_GET_NONCE, IHttpRequest.Method.GET, (SynergyRequest.SynergyRequestPreparingCallback)object2);
        SynergyNetwork.getComponent().sendRequest((SynergyRequest)object2, (SynergyNetworkConnectionCallback)object);
    }

    public void getPurchasedItems(ItemSkuCallback object) {
        Object object2 = new SynergyRequest.SynergyRequestPreparingCallback(){

            @Override
            public void prepareRequest(SynergyRequest synergyRequest) {
                ISynergyEnvironment iSynergyEnvironment = SynergyEnvironment.getComponent();
                synergyRequest.baseUrl = iSynergyEnvironment.getServerUrlWithKey("synergy.drm");
                HashMap<String, String> hashMap = new HashMap<String, String>();
                hashMap.put("apiVer", "1.0.0");
                hashMap.put("uid", SynergyIdManager.getComponent().getSynergyId());
                hashMap.put("masterSellId", iSynergyEnvironment.getSellId());
                synergyRequest.urlParameters = hashMap;
                synergyRequest.send();
            }
        };
        object = new SynergyNetworkConnectionCallback((ItemSkuCallback)object){
            final /* synthetic */ ItemSkuCallback val$callback;
            {
                this.val$callback = itemSkuCallback;
            }

            @Override
            public void callback(SynergyNetworkConnectionHandle object) {
                if (object.getResponse().getError() != null) {
                    this.val$callback.callback(null, object.getResponse().getError());
                    return;
                }
                Object object2 = (List)object.getResponse().getJsonData().get("sellIds");
                object = new ArrayList(object2.size());
                object2 = object2.iterator();
                while (true) {
                    if (!object2.hasNext()) {
                        this.val$callback.callback((List<String>)object, null);
                        return;
                    }
                    Integer n2 = (Integer)object2.next();
                    object.add(SynergyCatalog.this.m_itemSkuPrefix + n2);
                }
            }
        };
        object2 = new SynergyRequest(SYNERGY_API_GET_PURCHASED_ITEMS, IHttpRequest.Method.GET, (SynergyRequest.SynergyRequestPreparingCallback)object2);
        SynergyNetwork.getComponent().sendRequest((SynergyRequest)object2, (SynergyNetworkConnectionCallback)object);
    }

    public void loadBinaryDataForItems(Collection<SynergyCatalogItem> object, final CompletionCallback completionCallback) {
        if (this.m_itemsLoadingBinaryData != 0) {
            Log.Helper.LOGE(this, "Error: items already loading binary data", new Object[0]);
            return;
        }
        object = object.iterator();
        while (object.hasNext()) {
            String string2;
            final SynergyCatalogItem synergyCatalogItem = (SynergyCatalogItem)object.next();
            if (synergyCatalogItem.m_additionalInfo.get("binaryData") != null || (string2 = synergyCatalogItem.getMetaDataUrl()) == null) continue;
            try {
                URL uRL = new URL(string2);
                ++this.m_itemsLoadingBinaryData;
                Network.getComponent().sendGetRequest(uRL, null, new NetworkConnectionCallback(){

                    /*
                     * Enabled unnecessary exception pruning
                     */
                    @Override
                    public void callback(NetworkConnectionHandle object) {
                        InputStream inputStream = object.getResponse().getDataStream();
                        object = new ByteArrayOutputStream();
                        try {
                            int n2;
                            byte[] byArray = new byte[4096];
                            while ((n2 = inputStream.read(byArray, 0, byArray.length)) != -1) {
                                ((ByteArrayOutputStream)object).write(byArray, 0, n2);
                            }
                            ((OutputStream)object).flush();
                        }
                        catch (IOException iOException) {
                            Log.Helper.LOGE(this, "Error reading binary data", new Object[0]);
                        }
                        object = ((ByteArrayOutputStream)object).toByteArray();
                        synergyCatalogItem.getAdditionalInfo().put("binaryData", object);
                        SynergyCatalog.access$106(SynergyCatalog.this);
                        if (SynergyCatalog.this.m_itemsLoadingBinaryData != 0) return;
                        completionCallback.callback(null);
                    }
                });
            }
            catch (MalformedURLException malformedURLException) {
                Log.Helper.LOGE(this, "Error: Malformed item url: " + string2, new Object[0]);
            }
        }
    }

    public static interface CategoryCallback {
        public void callback(Set<ItemCategory> var1, Exception var2);
    }

    public static interface CompletionCallback {
        public void callback(Exception var1);
    }

    public static interface DataCallback {
        public void callback(InputStream var1, Exception var2);
    }

    public static interface ItemCallback {
        public void callback(List<SynergyCatalogItem> var1, Exception var2);
    }

    public static interface ItemSkuCallback {
        public void callback(List<String> var1, Exception var2);
    }

    public static enum StoreType {
        GOOGLE,
        AMAZON;

    }

    public static interface StringCallback {
        public void callback(String var1, Exception var2);
    }
}

