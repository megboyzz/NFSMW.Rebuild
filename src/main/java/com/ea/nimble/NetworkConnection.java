/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  android.text.TextUtils
 */
package com.ea.nimble;

import android.text.TextUtils;
import com.ea.nimble.ApplicationEnvironment;
import com.ea.nimble.BaseCore;
import com.ea.nimble.ByteBufferIOStream;
import com.ea.nimble.Error;
import com.ea.nimble.HttpError;
import com.ea.nimble.HttpRequest;
import com.ea.nimble.HttpResponse;
import com.ea.nimble.IHttpRequest;
import com.ea.nimble.IOperationalTelemetryDispatch;
import com.ea.nimble.Log;
import com.ea.nimble.LogSource;
import com.ea.nimble.NetworkConnectionCallback;
import com.ea.nimble.NetworkConnectionHandle;
import com.ea.nimble.NetworkImpl;
import com.ea.nimble.OperationalTelemetryDispatch;
import com.ea.nimble.Utility;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InterruptedIOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URLConnection;
import java.nio.channels.FileChannel;
import java.nio.channels.spi.AbstractInterruptibleChannel;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

class NetworkConnection
implements LogSource,
NetworkConnectionHandle,
Runnable {
    private static int MAXIMUM_RAW_DATA_LENGTH = 0x100000;
    static int s_loggingIdCount = 100;
    private NetworkConnectionCallback m_completionCallback;
    private Date m_connectionStartTimestamp;
    private NetworkConnectionCallback m_headerCallback;
    private String m_loggingId;
    private NetworkImpl m_manager;
    private IOperationalTelemetryDispatch m_otDispatch;
    private NetworkConnectionCallback m_progressCallback;
    private HttpRequest m_request;
    private String m_requestDataForLog;
    private HttpResponse m_response;
    private StringBuilder m_responseDataForLog;
    private Thread m_thread;

    public NetworkConnection(NetworkImpl networkImpl, HttpRequest httpRequest) {
        this(networkImpl, httpRequest, null);
    }

    public NetworkConnection(NetworkImpl networkImpl, HttpRequest httpRequest, IOperationalTelemetryDispatch iOperationalTelemetryDispatch) {
        this.m_manager = networkImpl;
        this.m_thread = null;
        this.m_request = httpRequest;
        this.m_response = new HttpResponse();
        this.m_headerCallback = null;
        this.m_progressCallback = null;
        this.m_completionCallback = null;
        this.m_connectionStartTimestamp = null;
        this.m_otDispatch = iOperationalTelemetryDispatch;
        this.m_loggingId = String.valueOf(s_loggingIdCount);
        int n2 = s_loggingIdCount;
        s_loggingIdCount = n2 + 1;
        if (n2 < 1000) return;
        s_loggingIdCount = 100;
    }

    /*
     * Handled duff style switch with additional control
     */
    private String beautifyJSONString(String string2) {
        if (string2 == null) return string2;
        if (string2.length() <= 0) {
            return string2;
        }
        String string3 = System.getProperty("line.separator");
        StringBuilder stringBuilder = new StringBuilder(string2.length() + 2048);
        Stack<Character> stack = new Stack<Character>();
        int n2 = 0;
        char c2 = '\u0000';
        boolean bl2 = true;
        int n3 = 0;
        while (true) {
            if (n3 >= string2.length()) {
                if (stack.isEmpty()) return stringBuilder.toString();
                Log.Helper.LOGE(this, "JSONString did not close it's brackets, invalid json", new Object[0]);
                return string2;
            }
            int n4 = string2.charAt(n3);
            boolean bl3 = bl2;
            int n5 = n2;
            char c3 = c2;
            int n6 = 0;
            block8: do {
                switch (n6 == 0 ? n4 : n6) {
                    default: {
                        stringBuilder.append((char)n4);
                        c3 = '\u0000';
                        bl3 = false;
                        n5 = n2;
                        break;
                    }
                    case 9: 
                    case 32: {
                        bl3 = bl2;
                        n5 = n2;
                        c3 = c2;
                        n6 = 10;
                        if (c2 != '\u0000') continue block8;
                        stringBuilder.append((char)n4);
                        bl3 = bl2;
                        n5 = n2;
                        c3 = c2;
                        break;
                    }
                    case 91: 
                    case 123: {
                        if (!bl2) {
                            stringBuilder.append(string3).append(this.multiplyStringNTimes("\t", n2));
                        }
                        n5 = n2 + 1;
                        stack.push(Character.valueOf((char)n4));
                        stringBuilder.append((char)n4).append(string3).append(this.multiplyStringNTimes("\t", n5));
                        c3 = '\u0001';
                        bl3 = true;
                        break;
                    }
                    case 44: {
                        stringBuilder.append((char)n4).append(string3).append(this.multiplyStringNTimes("\t", n2));
                        c3 = '\u0001';
                        bl3 = true;
                        n5 = n2;
                    }
                    case 10: 
                    case 13: {
                        break;
                    }
                    case 93: 
                    case 125: {
                        n5 = n2 - 1;
                        c3 = ((Character)stack.pop()).charValue();
                        if (n4 == 125 && c3 != '{' || n4 == 93 && c3 != '[') {
                            Log.Helper.LOGE(this, "JSONString expect valid closing brackets but found none", new Object[0]);
                            return string2;
                        }
                        stringBuilder.append(string3).append(this.multiplyStringNTimes("\t", n5)).append((char)n4);
                        c3 = '\u0001';
                        bl3 = bl2;
                    }
                }
                break;
            } while (true);
            ++n3;
            bl2 = bl3;
            n2 = n5;
            c2 = c3;
        }
    }

    /*
     * Loose catch block
     * Enabled unnecessary exception pruning
     */
    private void downloadToBuffer(HttpURLConnection object) throws IOException {
        int n2 = 0;
        this.prepareResponseLog();
        object = ((URLConnection)object).getInputStream();
        while (true) {
            int n3;
            byte[] byArray;
            block9: {
                int n4;
                if (n2 < 0) {
                    ((InputStream)object).close();
                    return;
                }
                byArray = this.m_response.data.prepareSegment();
                n2 = 0;
                do {
                    n3 = ((InputStream)object).read(byArray, n2, byArray.length - n2);
                    if (Thread.interrupted()) {
                        throw new InterruptedIOException();
                    }
                    if (n3 < 0) break block9;
                    if (n3 == 0) {
                        Thread.yield();
                        n4 = n2;
                    } else {
                        this.prepareResponseLog(byArray, n2, n3);
                        n4 = n2 + n3;
                        HttpResponse httpResponse = this.m_response;
                        httpResponse.downloadedContentLength += (long)n3;
                    }
                    n2 = n4;
                } while (n4 < byArray.length);
                n2 = n4;
            }
            this.m_response.data.appendSegmentToBuffer(byArray, n2);
            n2 = n3;
            if (this.m_progressCallback == null) continue;
            this.m_progressCallback.callback(this);
            n2 = n3;
            continue;
            break;
        }
        catch (Throwable throwable) {
            ((InputStream)object).close();
            throw throwable;
        }
    }

    /*
     * Exception decompiling
     */
    private void downloadToBufferWithError(HttpURLConnection var1_1) throws IOException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 1[TRYBLOCK] [4 : 117->173)] java.lang.Throwable
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:306)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$null$1(ResourceDecompiling.java:114)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling$$Lambda$144/691390785.run(Unknown Source)
         *     at java.lang.Thread.run(Unknown Source)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private void downloadToFile(HttpURLConnection object) throws IOException {
        FileChannel fileChannel;
        File file;
        block18: {
            FileChannel fileChannel2;
            Object object2;
            if (this.skipDownloadForOverwritePolicy((HttpURLConnection)object)) {
                return;
            }
            File file2 = new File(this.m_request.targetFilePath);
            Object object3 = ApplicationEnvironment.getComponent().getCachePath();
            file = new File((String)object3 + File.separator + file2.getName());
            boolean bl2 = file.exists() && this.m_request.overwritePolicy.contains((Object)IHttpRequest.OverwritePolicy.RESUME_DOWNLOAD);
            object = ((URLConnection)object).getInputStream();
            object3 = new FileOutputStream(file, bl2);
            Object object4 = new byte[65536];
            Log.Helper.LOGI(this, "Started File Download for " + file2.toString(), new Object[0]);
            try {
                int n2;
                while ((n2 = ((InputStream)object).read((byte[])object4)) >= 0) {
                    if (n2 == 0) {
                        Thread.yield();
                        continue;
                    }
                    ((FileOutputStream)object3).write((byte[])object4, 0, n2);
                    object2 = this.m_response;
                    ((HttpResponse)object2).downloadedContentLength += (long)n2;
                    if (this.m_progressCallback == null) continue;
                    this.m_progressCallback.callback(this);
                }
            }
            finally {
                ((InputStream)object).close();
                ((FileOutputStream)object3).close();
            }
            if (file2.exists() && !file2.delete()) {
                Log.Helper.LOGE(this, "Failed to delete existed target file " + file2, new Object[0]);
            }
            if (file.renameTo(file2)) return;
            Log.Helper.LOGI(this, "Failed to move temp file " + file + " to target file " + file2, new Object[0]);
            Log.Helper.LOGI(this, "Using fallback, and copying file instead " + file + "to target file " + file2, new Object[0]);
            if (!file2.exists()) {
                file2.createNewFile();
            }
            object2 = null;
            object4 = null;
            Object var9_11 = null;
            fileChannel = null;
            object = fileChannel;
            object3 = var9_11;
            try {
                fileChannel2 = new FileInputStream(file).getChannel();
                object = fileChannel;
                object4 = fileChannel2;
                object3 = var9_11;
                object2 = fileChannel2;
                fileChannel = new FileOutputStream(file2).getChannel();
                object = fileChannel;
                object4 = fileChannel2;
                object3 = fileChannel;
                object2 = fileChannel2;
                fileChannel.transferFrom(fileChannel2, 0L, fileChannel2.size());
                if (fileChannel2 == null) break block18;
            }
            catch (Exception exception) {
                block19: {
                    object3 = object;
                    object2 = object4;
                    try {
                        Log.Helper.LOGE(this, "ERROR while copying file, " + exception, new Object[0]);
                        if (object4 == null) break block19;
                    }
                    catch (Throwable throwable) {
                        if (object2 != null) {
                            ((AbstractInterruptibleChannel)object2).close();
                        }
                        if (object3 != null) {
                            ((AbstractInterruptibleChannel)object3).close();
                        }
                        if (!file.exists()) throw throwable;
                        file.delete();
                        throw throwable;
                    }
                    ((AbstractInterruptibleChannel)object4).close();
                }
                if (object != null) {
                    ((AbstractInterruptibleChannel)object).close();
                }
                if (!file.exists()) return;
                file.delete();
                return;
            }
            fileChannel2.close();
        }
        if (fileChannel != null) {
            fileChannel.close();
        }
        if (!file.exists()) return;
        file.delete();
        return;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    private void finish() {
        this.m_response.isCompleted = true;
        this.logOperationalTelemetryResponse();
        if (this.m_completionCallback != null) {
            this.m_completionCallback.callback(this);
        }
        synchronized (this) {
            this.notifyAll();
        }
        this.m_manager.removeConnection(this);
    }

    /*
     * Unable to fully structure code
     * Enabled unnecessary exception pruning
     */
    private void httpRecv(HttpURLConnection var1_1) throws IOException, Error {
        block16: {
            block19: {
                block18: {
                    try {
                        var4_4 = var1_1.getInputStream();
                    }
                    catch (Exception var4_5) {
                        try {
                            var4_4 = var1_1.getErrorStream();
                        }
                        catch (Exception var1_3) {
                            throw new Error(Error.Code.NETWORK_CONNECTION_ERROR, "Exception when getting error stream from HTTP connection.", var1_3);
                        }
                    }
                    this.m_response.url = var1_1.getURL();
                    try {}
                    catch (Throwable var1_2) {
                        if (var4_4 != null) {
                            var4_4.close();
                        }
                        this.logCommunication();
                        throw var1_2;
                    }
                    this.m_response.statusCode = var1_1.getResponseCode();
                    this.m_response.expectedContentLength = var1_1.getContentLength();
                    this.m_response.lastModified = var1_1.getLastModified();
                    for (Map.Entry<String, List<String>> var6_7 : var1_1.getHeaderFields().entrySet()) {
                        this.m_response.headers.put(var6_7.getKey(), TextUtils.join((CharSequence)", ", (Iterable)var6_7.getValue()));
                    }
                    var2_8 = this.m_response.expectedContentLength > (long)NetworkConnection.MAXIMUM_RAW_DATA_LENGTH;
                    var3_9 = Utility.validString(this.m_request.targetFilePath);
                    if (var2_8 && !var3_9) {
                        throw new Error(Error.Code.NETWORK_OVERSIZE_DATA, "Request " + this + " is oversize, please provide a local file path to download it as file.");
                    }
                    this.m_response.downloadedContentLength = 0L;
                    if (this.m_headerCallback != null) {
                        this.m_headerCallback.callback(this);
                    }
                    if (!var3_9 || var4_4 == null) break block18;
                    this.downloadToFile(var1_1);
lbl34:
                    // 4 sources

                    while (this.m_response.statusCode != 200) {
                        if (var3_9 == false) throw new HttpError(this.m_response.statusCode, "Request " + this + " failed for HTTP error");
                        if (this.m_response.statusCode != 206) {
                            throw new HttpError(this.m_response.statusCode, "Request " + this + " failed for HTTP error");
                        }
                        break block16;
                    }
                    break block16;
                }
                if (this.m_response.expectedContentLength == 0L) ** GOTO lbl34
                if (this.m_response.data == null) {
                    this.m_response.data = new ByteBufferIOStream((int)this.m_response.expectedContentLength);
                } else {
                    this.m_response.data.clear();
                }
                if (this.m_response.statusCode != 200) break block19;
                this.downloadToBuffer(var1_1);
                ** GOTO lbl34
            }
            this.downloadToBufferWithError(var1_1);
            ** GOTO lbl34
        }
        if (var4_4 != null) {
            var4_4.close();
        }
        this.logCommunication();
    }

    /*
     * WARNING - void declaration
     * Enabled unnecessary exception pruning
     */
    private void httpSend(HttpURLConnection object) throws IOException {
        this.m_connectionStartTimestamp = new Date();
        if (this.m_request.headers != null) {
            for (String string2 : this.m_request.headers.keySet()) {
                ((URLConnection)object).setRequestProperty(string2, this.m_request.headers.get(string2));
            }
        }
        if (this.m_request.getMethod() != IHttpRequest.Method.POST && this.m_request.getMethod() != IHttpRequest.Method.PUT) {
            this.logRequest();
            return;
        }
        byte[] byArray = this.m_request.data.toByteArray();
        if (byArray == null || byArray.length <= 0) {
            this.logRequest();
            return;
        }
        this.prepareRequestLog(byArray);
        this.logRequest();
        ((URLConnection)object).setDoOutput(true);
        ((HttpURLConnection)object).setFixedLengthStreamingMode(byArray.length);
        Object var3_7 = null;
        Object object2 = null;
        try {
            object2 = object = ((URLConnection)object).getOutputStream();
            Object object3 = object;
            ((OutputStream)object).write(byArray);
            if (object == null) return;
        }
        catch (Exception exception) {
            Iterator<String> iterator = object2;
            try {
                StringWriter stringWriter = new StringWriter();
                Object object4 = object2;
                exception.printStackTrace(new PrintWriter(stringWriter));
                Object object5 = object2;
                String string3 = stringWriter.toString();
                Object object6 = object2;
                Log.Helper.LOGE(this, "Exception in network connection:" + string3, new Object[0]);
                if (object2 == null) return;
            }
            catch (Throwable throwable) {
                void var3_13;
                if (var3_13 == null) throw throwable;
                var3_13.close();
                throw throwable;
            }
            ((OutputStream)object2).close();
            return;
        }
        ((OutputStream)object).close();
        return;
    }

    /*
     * Unable to fully structure code
     */
    private void logCommunication() {
        if (Log.getComponent().getThresholdLevel() > 100) {
            return;
        }
        var1_1 = 4096;
        if (this.m_requestDataForLog != null) {
            var1_1 = 4096 + this.m_requestDataForLog.length();
        }
        var2_2 = var1_1;
        if (this.m_responseDataForLog != null) {
            var2_2 = var1_1 + this.m_responseDataForLog.length();
        }
        var6_3 = new StringBuilder(var2_2);
        var6_3.append(String.format("\n>>>> CONNECTION ID %s FINISHED >>>>>>>>>>>>>>\n", new Object[]{this.m_loggingId}));
        var6_3.append("\n>>>> REQUEST >>>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
        var6_3.append("REQUEST: ").append(this.m_request.method.toString());
        var6_3.append(' ').append(this.m_request.url.toString()).append('\n');
        var3_4 = 0;
        var1_1 = 0;
        var2_2 = var3_4;
        if (this.m_request.headers != null) {
            var2_2 = var3_4;
            if (this.m_request.headers.size() > 0) {
                var4_5 = this.m_request.headers.keySet().iterator();
                while (true) {
                    var2_2 = var1_1;
                    if (!var4_5.hasNext()) break;
                    var5_7 = (String)var4_5.next();
                    if (var5_7 == null) continue;
                    var6_3.append("REQ HEADER: ").append((String)var5_7);
                    var7_8 = Utility.safeString(this.m_request.headers.get(var5_7));
                    var6_3.append(" VALUE: ").append(var7_8).append('\n');
                    if (!var5_7.equals("Content-Type") || !var7_8.contains("application/json") && !var7_8.contains("text/json")) continue;
                    var1_1 = 1;
                }
            }
        }
        if (this.m_requestDataForLog != null && this.m_requestDataForLog.length() > 0) {
            var6_3.append("REQ BODY:\n");
            var4_5 = var5_7 = this.m_requestDataForLog.toString();
            if (var2_2 != 0) {
                var4_5 = this.beautifyJSONString((String)var5_7);
            }
            var6_3.append((String)var4_5).append('\n');
        }
        var6_3.append("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<\n");
        var6_3.append(">>>> RESPONSE >>>>>>>>>>>>>>>>>>>>>>>>>>>>>\n");
        var6_3.append("RESP URL: ").append(this.m_response.url.toString()).append('\n');
        var6_3.append("RESP STATUS: ").append(this.m_response.statusCode).append('\n');
        var3_4 = 0;
        var1_1 = 0;
        var2_2 = var3_4;
        if (this.m_response.headers != null) {
            var2_2 = var3_4;
            if (this.m_response.headers.size() > 0) {
                var4_5 = this.m_response.headers.keySet().iterator();
                while (true) {
                    var2_2 = var1_1;
                    if (!var4_5.hasNext()) break;
                    var5_7 = (String)var4_5.next();
                    if (var5_7 == null) continue;
                    var6_3.append("RESP HEADER: ").append((String)var5_7);
                    var7_8 = Utility.safeString(this.m_response.headers.get(var5_7));
                    var6_3.append(" VALUE: ").append(var7_8).append('\n');
                    if (!var5_7.equals("Content-Type") || !var7_8.contains("application/json") && !var7_8.contains("text/json")) continue;
                    var1_1 = 1;
                }
            }
        }
        var6_3.append("RESP BODY:\n");
        var4_5 = var5_7 = "<Empty>: there is no response body for this call";
        try {
            if (this.m_responseDataForLog != null) {
                var4_5 = this.m_responseDataForLog.toString();
            }
lbl80:
            // 7 sources

            while (true) {
                var5_7 = var4_5;
                if (var2_2 != 0) {
                    var5_7 = this.beautifyJSONString((String)var4_5);
                }
                var6_3.append((String)var5_7).append('\n');
                break;
            }
        }
        catch (Exception var4_6) {
            Log.Helper.LOGE(this, "Attempting to process the response body failed.", new Object[0]);
            var4_5 = var5_7;
            if (this.m_response == null) ** GOTO lbl80
            var4_5 = var5_7;
            if (this.m_response.getError() == null) ** GOTO lbl80
            var4_5 = var5_7;
            if (this.m_response.getError().getMessage() == null) ** GOTO lbl80
            var4_5 = this.m_response.getError().getMessage();
            ** continue;
        }
        var6_3.append("<<<< CONNECTION FINISHED <<<<<<<<<<<<<<<<<<<<<");
        Log.Helper.LOGV(this, var6_3.toString(), new Object[0]);
    }

    private void logRequest() {
        String string2;
        Object object;
        if (Log.getComponent().getThresholdLevel() > 100) {
            return;
        }
        int n2 = 2048;
        if (this.m_requestDataForLog != null) {
            n2 = 2048 + this.m_requestDataForLog.length();
        }
        StringBuilder stringBuilder = new StringBuilder(n2);
        stringBuilder.append(String.format("\n>>>> CONNECTION ID %s BEGIN >>>>>>>>>>>>>>>>>\n", this.m_loggingId));
        stringBuilder.append("REQUEST: ").append(this.m_request.method.toString());
        stringBuilder.append(' ').append(this.m_request.url.toString()).append('\n');
        int n3 = 0;
        n2 = 0;
        int n4 = n3;
        if (this.m_request.headers != null) {
            n4 = n3;
            if (this.m_request.headers.size() > 0) {
                object = this.m_request.headers.keySet().iterator();
                while (true) {
                    n4 = n2;
                    if (!object.hasNext()) break;
                    string2 = (String)object.next();
                    stringBuilder.append("REQ HEADER: ").append(string2);
                    String string3 = this.m_request.headers.get(string2);
                    stringBuilder.append(" VALUE: ").append(string3).append('\n');
                    if (!string2.equals("Content-Type") || !string3.contains("application/json") && !string3.contains("text/json")) continue;
                    n2 = 1;
                }
            }
        }
        if (this.m_requestDataForLog != null && this.m_requestDataForLog.length() > 0) {
            stringBuilder.append("REQ BODY:\n");
            string2 = this.m_requestDataForLog.toString();
            object = string2;
            if (n4 != 0) {
                object = this.beautifyJSONString(string2);
            }
            stringBuilder.append((String)object).append('\n');
        }
        stringBuilder.append("<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
        Log.Helper.LOGV(this, stringBuilder.toString(), new Object[0]);
    }

    private String multiplyStringNTimes(String string2, int n2) {
        StringBuilder stringBuilder = new StringBuilder(string2.length() * n2);
        int n3 = 0;
        while (n3 < n2) {
            stringBuilder.append(string2);
            ++n3;
        }
        return stringBuilder.toString();
    }

    private void prepareRequestLog(byte[] byArray) {
        if (Log.getComponent().getThresholdLevel() > 100) {
            return;
        }
        try {
            this.m_requestDataForLog = new String(byArray, "UTF-8");
            return;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            this.m_requestDataForLog = null;
            return;
        }
    }

    private void prepareResponseLog() {
        if (Log.getComponent().getThresholdLevel() > 100) {
            return;
        }
        int n2 = this.m_response.expectedContentLength > 0L ? (int)this.m_response.expectedContentLength : 4096;
        this.m_responseDataForLog = new StringBuilder(n2);
    }

    private void prepareResponseLog(byte[] object, int n2, int n3) {
        if (Log.getComponent().getThresholdLevel() > 100) return;
        if (this.m_responseDataForLog == null) {
            return;
        }
        try {
            object = new String((byte[])object, n2, n3, "UTF-8");
            this.m_responseDataForLog.append((String)object);
            return;
        }
        catch (UnsupportedEncodingException unsupportedEncodingException) {
            this.m_responseDataForLog = null;
            return;
        }
    }

    private boolean skipDownloadForOverwritePolicy(HttpURLConnection object) {
        boolean bl2;
        boolean bl3 = true;
        object = new File(this.m_request.targetFilePath);
        if (!((File)object).exists()) {
            return false;
        }
        if (((File)object).length() != this.m_response.expectedContentLength) {
            bl2 = bl3;
            if (this.m_request.overwritePolicy.contains((Object)IHttpRequest.OverwritePolicy.LENGTH_CHECK)) return bl2;
        }
        bl2 = bl3;
        if (((File)object).lastModified() < this.m_response.lastModified) return bl2;
        bl2 = bl3;
        if (!this.m_request.overwritePolicy.contains((Object)IHttpRequest.OverwritePolicy.DATE_CHECK)) return bl2;
        return true;
    }

    @Override
    public void cancel() {
        synchronized (this) {
            if (this.m_thread != null) {
                this.m_thread.interrupt();
            } else {
                this.finishWithError(new Error(Error.Code.NETWORK_OPERATION_CANCELLED, "Network connection " + this.toString() + " is cancelled"));
            }
            return;
        }
    }

    void cancelForAppSuspend() {
        this.cancel();
    }

    void finishWithError(Exception exception) {
        if (this.m_response.isCompleted) {
            Log.Helper.LOGI(this, "Finished connection %s skipped an error %s", this.toString(), exception.toString());
            return;
        }
        Log.Helper.LOGW(this, "Running connection number %s with name %s failed for error %s", this.m_loggingId, this.toString(), exception.toString());
        this.m_response.error = exception;
        this.finish();
    }

    @Override
    public NetworkConnectionCallback getCompletionCallback() {
        return this.m_completionCallback;
    }

    @Override
    public NetworkConnectionCallback getHeaderCallback() {
        return this.m_headerCallback;
    }

    @Override
    public String getLogSourceTitle() {
        return "Network";
    }

    @Override
    public NetworkConnectionCallback getProgressCallback() {
        return this.m_progressCallback;
    }

    @Override
    public HttpRequest getRequest() {
        return this.m_request;
    }

    @Override
    public HttpResponse getResponse() {
        return this.m_response;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    void logOperationalTelemetryResponse() {
        Object object;
        Object object2;
        String string2;
        int n2;
        String string3;
        String string4;
        String string5;
        String string6;
        HashMap<String, String> hashMap;
        block11: {
            if (this.m_request == null || this.m_request.url == null) {
                Log.Helper.LOGE(this, "Empty request object and/or request URL for OT logging.", new Object[0]);
                return;
            }
            if (this.m_response == null) {
                Log.Helper.LOGE(this, "Empty response object for OT logging.", new Object[0]);
                return;
            }
            if (!BaseCore.getInstance().isActive()) {
                Log.Helper.LOGV(this, "BaseCore not active for operational telemetry logging.", new Object[0]);
                return;
            }
            if (this.m_otDispatch == null) {
                this.m_otDispatch = OperationalTelemetryDispatch.getComponent();
                if (this.m_otDispatch == null) {
                    Log.Helper.LOGV(this, "OperationalTelemetry Component not active for operational telemetry logging.", new Object[0]);
                    return;
                }
            }
            hashMap = new HashMap<String, String>();
            string6 = this.m_request.url.getProtocol();
            string5 = this.m_request.url.getPath();
            string4 = this.m_request.url.getQuery();
            string3 = this.m_request.url.getHost();
            n2 = this.m_response.statusCode;
            string2 = this.m_request.url.toString();
            object = object2 = "0";
            if (this.m_connectionStartTimestamp != null) {
                long l2;
                long l3;
                try {
                    Date date = new Date();
                    object = object2;
                    if (date == null) break block11;
                    l3 = date.getTime();
                    l2 = this.m_connectionStartTimestamp.getTime();
                }
                catch (Exception exception) {
                    Log.Helper.LOGE(this, "Unable to allocate new Date object to calculate response time.", new Object[0]);
                    object = object2;
                }
                object = String.valueOf(l3 - l2);
            }
        }
        boolean bl2 = false;
        object2 = this.m_response.getError();
        boolean bl3 = bl2;
        if (object2 != null) {
            if (object2 instanceof Error) {
                object2 = (Error)object2;
                int n3 = ((Error)object2).getCode();
                hashMap.put("NIMBLE_ERROR_DOMAIN", ((Error)object2).getDomain());
                hashMap.put("NIMBLE_ERROR_CODE", String.valueOf(n3));
                bl3 = ((Error)object2).getDomain().equals("NimbleError") && n3 == Error.Code.NETWORK_TIMEOUT.intValue();
            } else {
                hashMap.put("NIMBLE_ERROR_DOMAIN", object2.getClass().getName());
                bl3 = bl2;
            }
        }
        hashMap.put("CONNECTIONID", this.m_loggingId);
        hashMap.put("URL_ABSOLUTE", string2);
        hashMap.put("URL_PROTOCOL", string6);
        hashMap.put("URL_PATH", string5);
        hashMap.put("URL_QUERY", string4);
        hashMap.put("URL_HOST", string3);
        hashMap.put("RESPONSE_TIME_MS", (String)object);
        hashMap.put("HTTP_STATUS_CODE", String.valueOf(n2));
        hashMap.put("REQUEST_TIMED_OUT", String.valueOf(bl3));
        this.m_otDispatch.logEvent("com.ea.nimble.network", hashMap);
    }

    /*
     * Exception decompiling
     */
    @Override
    public void run() {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Back jump on a try block [egrp 5[TRYBLOCK] [21, 22, 23, 24, 28, 25, 26, 27 : 114->116)] java.lang.ClassCastException
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op02WithProcessedDataAndRefs.insertExceptionBlocks(Op02WithProcessedDataAndRefs.java:2283)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:415)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisOrWrapFail(CodeAnalyser.java:278)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysis(CodeAnalyser.java:201)
         *     at org.benf.cfr.reader.entities.attributes.AttributeCode.analyse(AttributeCode.java:94)
         *     at org.benf.cfr.reader.entities.Method.analyse(Method.java:531)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseMid(ClassFile.java:1055)
         *     at org.benf.cfr.reader.entities.ClassFile.analyseTop(ClassFile.java:942)
         *     at org.benf.cfr.reader.Driver.doJarVersionTypes(Driver.java:257)
         *     at org.benf.cfr.reader.Driver.doJar(Driver.java:139)
         *     at org.benf.cfr.reader.CfrDriverImpl.analyse(CfrDriverImpl.java:76)
         *     at org.benf.cfr.reader.Main.main(Main.java:54)
         *     at the.bytecode.club.bytecodeviewer.decompilers.impl.CFRDecompiler.decompileToZip(CFRDecompiler.java:306)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling.lambda$null$1(ResourceDecompiling.java:114)
         *     at the.bytecode.club.bytecodeviewer.resources.ResourceDecompiling$$Lambda$144/691390785.run(Unknown Source)
         *     at java.lang.Thread.run(Unknown Source)
         */
        throw new IllegalStateException("Decompilation failed");
    }

    @Override
    public void setCompletionCallback(NetworkConnectionCallback networkConnectionCallback) {
        this.m_completionCallback = networkConnectionCallback;
    }

    @Override
    public void setHeaderCallback(NetworkConnectionCallback networkConnectionCallback) {
        this.m_headerCallback = networkConnectionCallback;
    }

    @Override
    public void setProgressCallback(NetworkConnectionCallback networkConnectionCallback) {
        this.m_progressCallback = networkConnectionCallback;
    }

    @Override
    public void waitOn() {
        synchronized (this) {
            boolean bl2;
            while (!(bl2 = this.m_response.isCompleted)) {
                try {
                    this.wait();
                }
                catch (InterruptedException interruptedException) {}
            }
            return;
        }
    }
}

