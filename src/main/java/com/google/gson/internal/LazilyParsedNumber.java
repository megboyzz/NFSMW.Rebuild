/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.internal;

import java.math.BigInteger;

public final class LazilyParsedNumber
extends Number {
    private final String value;

    public LazilyParsedNumber(String string2) {
        this.value = string2;
    }

    @Override
    public double doubleValue() {
        return Double.parseDouble(this.value);
    }

    @Override
    public float floatValue() {
        return Float.parseFloat(this.value);
    }

    @Override
    public int intValue() {
        try {
            return Integer.parseInt(this.value);
        }
        catch (NumberFormatException numberFormatException) {
            try {
                long l2 = Long.parseLong(this.value);
                return (int)l2;
            }
            catch (NumberFormatException numberFormatException2) {
                return new BigInteger(this.value).intValue();
            }
        }
    }

    @Override
    public long longValue() {
        try {
            return Long.parseLong(this.value);
        }
        catch (NumberFormatException numberFormatException) {
            return new BigInteger(this.value).longValue();
        }
    }

    public String toString() {
        return this.value;
    }
}

