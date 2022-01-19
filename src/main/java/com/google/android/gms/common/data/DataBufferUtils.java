/*
 * Decompiled with CFR 0.152.
 */
package com.google.android.gms.common.data;

import com.google.android.gms.common.data.DataBuffer;
import com.google.android.gms.common.data.Freezable;
import java.util.ArrayList;
import java.util.Iterator;

public final class DataBufferUtils {
    private DataBufferUtils() {
    }

    public static <T, E extends Freezable<T>> ArrayList<T> freezeAndClose(DataBuffer<E> dataBuffer) {
        ArrayList arrayList = new ArrayList(dataBuffer.getCount());
        try {
            Iterator<E> iterator = dataBuffer.iterator();
            while (iterator.hasNext()) {
                arrayList.add(((Freezable)iterator.next()).freeze());
            }
            return arrayList;
        }
        finally {
            dataBuffer.close();
        }
    }
}

