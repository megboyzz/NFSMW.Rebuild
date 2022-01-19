/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.stream;

import com.google.gson.stream.JsonScope;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class JsonWriter
implements Closeable,
Flushable {
    private static final String[] HTML_SAFE_REPLACEMENT_CHARS;
    private static final String[] REPLACEMENT_CHARS;
    private String deferredName;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer out;
    private String separator;
    private boolean serializeNulls;
    private final List<JsonScope> stack = new ArrayList<JsonScope>();

    static {
        REPLACEMENT_CHARS = new String[128];
        int n2 = 0;
        while (true) {
            if (n2 > 31) {
                JsonWriter.REPLACEMENT_CHARS[34] = "\\\"";
                JsonWriter.REPLACEMENT_CHARS[92] = "\\\\";
                JsonWriter.REPLACEMENT_CHARS[9] = "\\t";
                JsonWriter.REPLACEMENT_CHARS[8] = "\\b";
                JsonWriter.REPLACEMENT_CHARS[10] = "\\n";
                JsonWriter.REPLACEMENT_CHARS[13] = "\\r";
                JsonWriter.REPLACEMENT_CHARS[12] = "\\f";
                HTML_SAFE_REPLACEMENT_CHARS = (String[])REPLACEMENT_CHARS.clone();
                JsonWriter.HTML_SAFE_REPLACEMENT_CHARS[60] = "\\u003c";
                JsonWriter.HTML_SAFE_REPLACEMENT_CHARS[62] = "\\u003e";
                JsonWriter.HTML_SAFE_REPLACEMENT_CHARS[38] = "\\u0026";
                JsonWriter.HTML_SAFE_REPLACEMENT_CHARS[61] = "\\u003d";
                JsonWriter.HTML_SAFE_REPLACEMENT_CHARS[39] = "\\u0027";
                return;
            }
            JsonWriter.REPLACEMENT_CHARS[n2] = String.format("\\u%04x", n2);
            ++n2;
        }
    }

    public JsonWriter(Writer writer) {
        this.stack.add(JsonScope.EMPTY_DOCUMENT);
        this.separator = ":";
        this.serializeNulls = true;
        if (writer == null) {
            throw new NullPointerException("out == null");
        }
        this.out = writer;
    }

    private void beforeName() throws IOException {
        JsonScope jsonScope = this.peek();
        if (jsonScope == JsonScope.NONEMPTY_OBJECT) {
            this.out.write(44);
        } else if (jsonScope != JsonScope.EMPTY_OBJECT) {
            throw new IllegalStateException("Nesting problem: " + this.stack);
        }
        this.newline();
        this.replaceTop(JsonScope.DANGLING_NAME);
    }

    private void beforeValue(boolean bl2) throws IOException {
        switch (1.$SwitchMap$com$google$gson$stream$JsonScope[this.peek().ordinal()]) {
            default: {
                throw new IllegalStateException("Nesting problem: " + this.stack);
            }
            case 1: {
                if (!this.lenient) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            case 2: {
                if (!this.lenient && !bl2) {
                    throw new IllegalStateException("JSON must start with an array or an object.");
                }
                this.replaceTop(JsonScope.NONEMPTY_DOCUMENT);
                return;
            }
            case 3: {
                this.replaceTop(JsonScope.NONEMPTY_ARRAY);
                this.newline();
                return;
            }
            case 4: {
                this.out.append(',');
                this.newline();
                return;
            }
            case 5: 
        }
        this.out.append(this.separator);
        this.replaceTop(JsonScope.NONEMPTY_OBJECT);
    }

    private JsonWriter close(JsonScope jsonScope, JsonScope jsonScope2, String string2) throws IOException {
        JsonScope jsonScope3 = this.peek();
        if (jsonScope3 != jsonScope2 && jsonScope3 != jsonScope) {
            throw new IllegalStateException("Nesting problem: " + this.stack);
        }
        if (this.deferredName != null) {
            throw new IllegalStateException("Dangling name: " + this.deferredName);
        }
        this.stack.remove(this.stack.size() - 1);
        if (jsonScope3 == jsonScope2) {
            this.newline();
        }
        this.out.write(string2);
        return this;
    }

    private void newline() throws IOException {
        if (this.indent == null) {
            return;
        }
        this.out.write("\n");
        int n2 = 1;
        while (n2 < this.stack.size()) {
            this.out.write(this.indent);
            ++n2;
        }
    }

    private JsonWriter open(JsonScope jsonScope, String string2) throws IOException {
        this.beforeValue(true);
        this.stack.add(jsonScope);
        this.out.write(string2);
        return this;
    }

    private JsonScope peek() {
        int n2 = this.stack.size();
        if (n2 != 0) return this.stack.get(n2 - 1);
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void replaceTop(JsonScope jsonScope) {
        this.stack.set(this.stack.size() - 1, jsonScope);
    }

    private void string(String string2) throws IOException {
        String[] stringArray = this.htmlSafe ? HTML_SAFE_REPLACEMENT_CHARS : REPLACEMENT_CHARS;
        this.out.write("\"");
        int n2 = 0;
        int n3 = string2.length();
        for (int i2 = 0; i2 < n3; ++i2) {
            int n4;
            block8: {
                String string3;
                block7: {
                    char c2;
                    block9: {
                        block6: {
                            String string4;
                            c2 = string2.charAt(i2);
                            if (c2 >= '\u0080') break block6;
                            string3 = string4 = stringArray[c2];
                            if (string4 != null) break block7;
                            n4 = n2;
                            break block8;
                        }
                        if (c2 != '\u2028') break block9;
                        string3 = "\\u2028";
                        break block7;
                    }
                    n4 = n2;
                    if (c2 != '\u2029') break block8;
                    string3 = "\\u2029";
                }
                if (n2 < i2) {
                    this.out.write(string2, n2, i2 - n2);
                }
                this.out.write(string3);
                n4 = i2 + 1;
            }
            n2 = n4;
        }
        if (n2 < n3) {
            this.out.write(string2, n2, n3 - n2);
        }
        this.out.write("\"");
    }

    private void writeDeferredName() throws IOException {
        if (this.deferredName == null) return;
        this.beforeName();
        this.string(this.deferredName);
        this.deferredName = null;
    }

    public JsonWriter beginArray() throws IOException {
        this.writeDeferredName();
        return this.open(JsonScope.EMPTY_ARRAY, "[");
    }

    public JsonWriter beginObject() throws IOException {
        this.writeDeferredName();
        return this.open(JsonScope.EMPTY_OBJECT, "{");
    }

    @Override
    public void close() throws IOException {
        this.out.close();
        int n2 = this.stack.size();
        if (n2 > 1) throw new IOException("Incomplete document");
        if (n2 == 1 && this.stack.get(n2 - 1) != JsonScope.NONEMPTY_DOCUMENT) {
            throw new IOException("Incomplete document");
        }
        this.stack.clear();
    }

    public JsonWriter endArray() throws IOException {
        return this.close(JsonScope.EMPTY_ARRAY, JsonScope.NONEMPTY_ARRAY, "]");
    }

    public JsonWriter endObject() throws IOException {
        return this.close(JsonScope.EMPTY_OBJECT, JsonScope.NONEMPTY_OBJECT, "}");
    }

    @Override
    public void flush() throws IOException {
        if (this.stack.isEmpty()) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.out.flush();
    }

    public final boolean getSerializeNulls() {
        return this.serializeNulls;
    }

    public final boolean isHtmlSafe() {
        return this.htmlSafe;
    }

    public boolean isLenient() {
        return this.lenient;
    }

    public JsonWriter name(String string2) throws IOException {
        if (string2 == null) {
            throw new NullPointerException("name == null");
        }
        if (this.deferredName != null) {
            throw new IllegalStateException();
        }
        if (this.stack.isEmpty()) {
            throw new IllegalStateException("JsonWriter is closed.");
        }
        this.deferredName = string2;
        return this;
    }

    public JsonWriter nullValue() throws IOException {
        if (this.deferredName != null) {
            if (!this.serializeNulls) {
                this.deferredName = null;
                return this;
            }
            this.writeDeferredName();
        }
        this.beforeValue(false);
        this.out.write("null");
        return this;
    }

    public final void setHtmlSafe(boolean bl2) {
        this.htmlSafe = bl2;
    }

    public final void setIndent(String string2) {
        if (string2.length() == 0) {
            this.indent = null;
            this.separator = ":";
            return;
        }
        this.indent = string2;
        this.separator = ": ";
    }

    public final void setLenient(boolean bl2) {
        this.lenient = bl2;
    }

    public final void setSerializeNulls(boolean bl2) {
        this.serializeNulls = bl2;
    }

    public JsonWriter value(double d2) throws IOException {
        if (Double.isNaN(d2)) throw new IllegalArgumentException("Numeric values must be finite, but was " + d2);
        if (Double.isInfinite(d2)) {
            throw new IllegalArgumentException("Numeric values must be finite, but was " + d2);
        }
        this.writeDeferredName();
        this.beforeValue(false);
        this.out.append(Double.toString(d2));
        return this;
    }

    public JsonWriter value(long l2) throws IOException {
        this.writeDeferredName();
        this.beforeValue(false);
        this.out.write(Long.toString(l2));
        return this;
    }

    public JsonWriter value(Number number) throws IOException {
        if (number == null) {
            return this.nullValue();
        }
        this.writeDeferredName();
        String string2 = number.toString();
        if (!this.lenient) {
            if (string2.equals("-Infinity")) throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
            if (string2.equals("Infinity")) throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
            if (string2.equals("NaN")) {
                throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
            }
        }
        this.beforeValue(false);
        this.out.append(string2);
        return this;
    }

    public JsonWriter value(String string2) throws IOException {
        if (string2 == null) {
            return this.nullValue();
        }
        this.writeDeferredName();
        this.beforeValue(false);
        this.string(string2);
        return this;
    }

    public JsonWriter value(boolean bl2) throws IOException {
        this.writeDeferredName();
        this.beforeValue(false);
        Writer writer = this.out;
        String string2 = bl2 ? "true" : "false";
        writer.write(string2);
        return this;
    }
}

