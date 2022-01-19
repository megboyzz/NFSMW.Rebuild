/*
 * Decompiled with CFR 0.152.
 */
package com.eamobile.licensing;

import com.eamobile.licensing.LicenseServerActivity;
import com.eamobile.licensing.z;
import java.io.DataInput;
import java.io.DataInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Vector;

public class g {
    public static final int a = 0;
    public static final int b = 1;
    public static final String[] c = new String[2];
    public static final int e = 2;
    public static final int f = 1;
    public static final char g = '\n';
    private static final int h = 2;
    private static int j;
    public final int d;
    private String i;

    public g() {
        this.d = 8096;
    }

    public static char a(DataInput dataInput) {
        if (j != 2) return (char)dataInput.readUnsignedByte();
        int n2 = dataInput.readUnsignedShort();
        return (char)((n2 & 0xFF) << 8 | n2 >> 8);
    }

    public static String a(int n2) {
        return com.eamobile.licensing.g.a(n2, null);
    }

    public static String a(int n2, String[] stringArray) {
        String string2;
        int n3 = 0;
        String string3 = string2 = c[n2];
        if (stringArray == null) return string3;
        String string4 = string2;
        string3 = string2;
        try {
            if (stringArray.length <= 0) return string3;
            n2 = n3;
            while (true) {
                string4 = string2;
                string3 = string2;
                if (string2.indexOf("%%") == -1) return string3;
                string4 = string2;
                string3 = string2;
                if (n2 >= stringArray.length) return string3;
                string4 = string2;
                n3 = string2.indexOf("%%");
                string4 = string2;
                string2 = string2.substring(0, n3) + stringArray[n2] + string2.substring(n3 + 2);
                ++n2;
            }
        }
        catch (Exception exception) {
            z.a("Exception e:" + exception);
            return string4;
        }
    }

    public static String a(DataInput object, char c2, boolean bl2) {
        StringBuffer stringBuffer = new StringBuffer();
        char c3 = com.eamobile.licensing.g.a((DataInput)object);
        while (true) {
            if (c3 == c2) {
                object = stringBuffer.toString();
                if (object == null) return null;
                return ((String)object).trim();
            }
            stringBuffer.append(c3);
            c3 = com.eamobile.licensing.g.a((DataInput)object);
        }
    }

    /*
     * Unable to fully structure code
     */
    public static int b(String var0) {
        block14: {
            var1_5 = 1;
            var3_6 = null;
            var0 = new DataInputStream(LicenseServerActivity.b().getAssets().open((String)var0));
            var2_9 = var0.readUnsignedShort();
            if (var2_9 != 65534) break block14;
            var1_5 = 2;
        }
        var0.close();
        return var1_5;
        catch (IOException var0_1) {
            var0 = null;
lbl15:
            // 2 sources

            while (true) {
                try {
                    var0.close();
                    return 1;
                }
                catch (Exception var0_2) {
                    return 1;
                }
                break;
            }
        }
        catch (Throwable var4_10) {
            var3_6 = var0;
            var0 = var4_10;
        }
        catch (IOException var3_8) {
            ** continue;
        }
lbl-1000:
        // 2 sources

        {
            while (true) {
                var3_6.close();
                throw var0;
                break;
            }
            catch (Exception var0_4) {
                return var1_5;
            }
            catch (Throwable var0_3) {}
            ** continue;
            catch (Exception var3_7) {
                throw var0;
            }
        }
    }

    public String a() {
        return this.i;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public boolean a(String string2) {
        if (string2 == null) {
            return false;
        }
        String string3 = "licenseserver/" + string2 + ".txt";
        z.a("Opening file: " + string3);
        try {
            InputStream inputStream = LicenseServerActivity.b().getAssets().open(string3);
            if (inputStream == null) {
                z.a("Couldn't find file: " + string3);
                return false;
            }
            Vector<String> vector = new Vector<String>();
            inputStream = new DataInputStream(inputStream);
            j = com.eamobile.licensing.g.b(string3);
            if (j == 2) {
                ((DataInputStream)inputStream).skipBytes(2);
            }
            int n2 = 1;
            while (n2 != 0) {
                try {
                    vector.addElement(com.eamobile.licensing.g.a((DataInput)((Object)inputStream), '\n', true));
                }
                catch (Exception exception) {
                    n2 = 0;
                }
            }
            try {
                for (n2 = 0; n2 < c.length; ++n2) {
                    com.eamobile.licensing.g.c[n2] = ((String)vector.elementAt(n2)).toString();
                }
            }
            catch (Exception exception) {
                z.a("Exception caught: " + exception);
                return false;
            }
        }
        catch (FileNotFoundException fileNotFoundException) {
            z.a("File not found: " + string3);
            return false;
        }
        this.i = string2;
        return true;
    }
}

