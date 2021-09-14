package com.ea.easp;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.provider.ContactsContract;
import android.telephony.TelephonyManager;
import android.text.Html;
import com.ea.easp.Debug;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ContactsAndroid {
    private static String TAG = "ContactsAndroid";

    public static boolean CanSendMail() {
        return true;
    }

    public static boolean CanSendSMS() {
        return ((TelephonyManager) EASPHandler.mActivity.getSystemService("phone")).getSimState() == 5;
    }

    public static void OpenEmailClient(String str, String str2, String str3) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("message/rfc822");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{str});
        intent.putExtra("android.intent.extra.SUBJECT", str2);
        intent.putExtra("android.intent.extra.TEXT", Html.fromHtml(str3));
        EASPHandler.mActivity.startActivity(Intent.createChooser(intent, "Email..."));
    }

    public static void OpenSMSClient(String str, String str2) {
        Intent intent = new Intent("android.intent.action.VIEW", Uri.fromParts("sms", str, null));
        intent.setType("vnd.android-dir/mms-sms");
        intent.putExtra("sms_body", str2);
        intent.putExtra("address", str);
        EASPHandler.mActivity.startActivity(Intent.createChooser(intent, "SMS..."));
    }

    public static String getContacts() {
        ContentResolver contentResolver = EASPHandler.mActivity.getContentResolver();
        if (contentResolver != null) {
            Cursor query = contentResolver.query(ContactsContract.Contacts.CONTENT_URI, null, null, null, null);
            User[] userArr = null;
            if (query.getCount() > 0) {
                userArr = new User[query.getCount()];
                String[] strArr = new String[1];
                int i = 0;
                while (query.moveToNext()) {
                    userArr[i] = new User();
                    strArr[0] = query.getString(query.getColumnIndex("_id"));
                    userArr[i].mDisplayName = query.getString(query.getColumnIndex("display_name"));
                    Cursor query2 = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, "contact_id = ?", strArr, null);
                    if (query2.getCount() > 0) {
                        userArr[i].mPhoneNumber = new String[query2.getCount()];
                        int i2 = 0;
                        while (query2.moveToNext()) {
                            userArr[i].mPhoneNumber[i2] = query2.getString(query2.getColumnIndex("data1"));
                            i2++;
                        }
                    }
                    query2.close();
                    Cursor query3 = contentResolver.query(ContactsContract.CommonDataKinds.Email.CONTENT_URI, null, "contact_id = ?", strArr, null);
                    if (query3.getCount() > 0) {
                        userArr[i].mEmail = new String[query3.getCount()];
                        int i3 = 0;
                        while (query3.moveToNext()) {
                            userArr[i].mEmail[i3] = query3.getString(query3.getColumnIndex("data1"));
                            i3++;
                        }
                    }
                    query3.close();
                    i++;
                }
            }
            query.close();
            Debug.Log.d(TAG, " ----- Prepare JSON ------ ");
            if (userArr != null) {
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                try {
                    jSONObject.accumulate("users", jSONArray);
                } catch (JSONException e) {
                    Debug.Log.e(TAG, e.toString(), e);
                }
                for (int i4 = 0; i4 < userArr.length; i4++) {
                    try {
                        JSONObject jSONObject2 = new JSONObject();
                        jSONObject2.accumulate("name", userArr[i4].mDisplayName);
                        JSONArray jSONArray2 = new JSONArray();
                        if (userArr[i4].mPhoneNumber != null) {
                            for (int i5 = 0; i5 < userArr[i4].mPhoneNumber.length; i5++) {
                                jSONArray2.put(userArr[i4].mPhoneNumber[i5]);
                            }
                        }
                        jSONObject2.accumulate("phone", jSONArray2);
                        JSONArray jSONArray3 = new JSONArray();
                        if (userArr[i4].mEmail != null) {
                            for (int i6 = 0; i6 < userArr[i4].mEmail.length; i6++) {
                                jSONArray3.put(userArr[i4].mEmail[i6]);
                            }
                        }
                        jSONObject2.accumulate("email", jSONArray3);
                        jSONArray.put(jSONObject2);
                    } catch (JSONException e2) {
                        Debug.Log.e(TAG, e2.toString(), e2);
                    }
                }
                return jSONObject.toString();
            }
        }
        return "";
    }
}
