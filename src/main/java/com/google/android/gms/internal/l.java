/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.internal;

import com.google.android.gms.internal.j;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class l {
    private final SecureRandom dP;
    private final j dw;

    public l(j j2, SecureRandom secureRandom) {
        this.dw = j2;
        this.dP = secureRandom;
    }

    static void a(byte[] byArray) {
        int n2 = 0;
        while (n2 < byArray.length) {
            byArray[n2] = (byte)(byArray[n2] ^ 0x44);
            ++n2;
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled unnecessary exception pruning
     */
    public byte[] c(byte[] object, String object2) throws a {
        byte[] byArray;
        if (((byte[])object).length != 16) {
            throw new a();
        }
        try {
            byArray = this.dw.a((String)object2, false);
            if (byArray.length <= 16) {
                throw new a();
            }
        }
        catch (NoSuchAlgorithmException noSuchAlgorithmException) {
            throw new a((Throwable)noSuchAlgorithmException);
        }
        catch (InvalidKeyException invalidKeyException) {
            throw new a((Throwable)invalidKeyException);
        }
        catch (IllegalBlockSizeException illegalBlockSizeException) {
            throw new a((Throwable)illegalBlockSizeException);
        }
        catch (NoSuchPaddingException noSuchPaddingException) {
            throw new a((Throwable)noSuchPaddingException);
        }
        catch (BadPaddingException badPaddingException) {
            throw new a((Throwable)badPaddingException);
        }
        catch (InvalidAlgorithmParameterException invalidAlgorithmParameterException) {
            throw new a((Throwable)invalidAlgorithmParameterException);
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new a((Throwable)illegalArgumentException);
        }
        {
            Object object3 = ByteBuffer.allocate(byArray.length);
            ((ByteBuffer)object3).put(byArray);
            ((Buffer)object3).flip();
            object2 = new byte[16];
            byArray = new byte[byArray.length - 16];
            ((ByteBuffer)object3).get((byte[])object2);
            ((ByteBuffer)object3).get(byArray);
            object = new SecretKeySpec((byte[])object, "AES");
            object3 = Cipher.getInstance("AES/CBC/PKCS5Padding");
            ((Cipher)object3).init(2, (Key)object, new IvParameterSpec((byte[])object2));
            return ((Cipher)object3).doFinal(byArray);
        }
    }

    /*
     * WARNING - Removed back jump from a try to a catch block - possible behaviour change.
     * Enabled unnecessary exception pruning
     */
    public byte[] d(String object) throws a {
        try {
            object = this.dw.a((String)object, false);
            if (((Object)object).length != 32) {
                throw new a();
            }
        }
        catch (IllegalArgumentException illegalArgumentException) {
            throw new a((Throwable)illegalArgumentException);
        }
        {
            object = ByteBuffer.wrap((byte[])object, 4, 16);
            byte[] byArray = new byte[16];
            ((ByteBuffer)object).get(byArray);
            l.a(byArray);
            return byArray;
        }
    }

    public class a
    extends Exception {
        public a() {
        }

        public a(Throwable throwable) {
            super(throwable);
        }
    }
}

