/*
 * Decompiled with CFR 0.152.
 */
package com.google.gson.stream;

import com.google.gson.internal.JsonReaderInternalAccess;
import com.google.gson.internal.bind.JsonTreeReader;
import com.google.gson.stream.JsonScope;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.MalformedJsonException;
import com.google.gson.stream.StringPool;
import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.Reader;

public class JsonReader
implements Closeable {
    private static final String FALSE = "false";
    private static final char[] NON_EXECUTE_PREFIX = ")]}'\n".toCharArray();
    private static final String TRUE = "true";
    private final char[] buffer;
    private int bufferStartColumn = 1;
    private int bufferStartLine = 1;
    private final Reader in;
    private boolean lenient = false;
    private int limit = 0;
    private String name;
    private int pos = 0;
    private boolean skipping;
    private JsonScope[] stack;
    private int stackSize = 0;
    private final StringPool stringPool = new StringPool();
    private JsonToken token;
    private String value;
    private int valueLength;
    private int valuePos;

    static {
        JsonReaderInternalAccess.INSTANCE = new JsonReaderInternalAccess(){

            @Override
            public void promoteNameToValue(JsonReader jsonReader) throws IOException {
                if (jsonReader instanceof JsonTreeReader) {
                    ((JsonTreeReader)jsonReader).promoteNameToValue();
                    return;
                }
                jsonReader.peek();
                if (jsonReader.token != JsonToken.NAME) {
                    throw new IllegalStateException("Expected a name but was " + (Object)((Object)jsonReader.peek()) + " " + " at line " + jsonReader.getLineNumber() + " column " + jsonReader.getColumnNumber());
                }
                JsonReader.access$302(jsonReader, jsonReader.name);
                JsonReader.access$402(jsonReader, null);
                JsonReader.access$002(jsonReader, JsonToken.STRING);
            }
        };
    }

    public JsonReader(Reader reader) {
        this.buffer = new char[1024];
        this.stack = new JsonScope[32];
        this.push(JsonScope.EMPTY_DOCUMENT);
        this.skipping = false;
        if (reader == null) {
            throw new NullPointerException("in == null");
        }
        this.in = reader;
    }

    static /* synthetic */ JsonToken access$002(JsonReader jsonReader, JsonToken jsonToken) {
        jsonReader.token = jsonToken;
        return jsonToken;
    }

    static /* synthetic */ String access$302(JsonReader jsonReader, String string2) {
        jsonReader.value = string2;
        return string2;
    }

    static /* synthetic */ String access$402(JsonReader jsonReader, String string2) {
        jsonReader.name = string2;
        return string2;
    }

    private JsonToken advance() throws IOException {
        this.peek();
        JsonToken jsonToken = this.token;
        this.token = null;
        this.value = null;
        this.name = null;
        return jsonToken;
    }

    private void checkLenient() throws IOException {
        if (this.lenient) return;
        throw this.syntaxError("Use JsonReader.setLenient(true) to accept malformed JSON");
    }

    private void consumeNonExecutePrefix() throws IOException {
        this.nextNonWhitespace(true);
        --this.pos;
        if (this.pos + NON_EXECUTE_PREFIX.length > this.limit && !this.fillBuffer(NON_EXECUTE_PREFIX.length)) {
            return;
        }
        int n2 = 0;
        while (true) {
            if (n2 >= NON_EXECUTE_PREFIX.length) {
                this.pos += NON_EXECUTE_PREFIX.length;
                return;
            }
            if (this.buffer[this.pos + n2] != NON_EXECUTE_PREFIX[n2]) return;
            ++n2;
        }
    }

    private JsonToken decodeLiteral() throws IOException {
        if (this.valuePos == -1) {
            return JsonToken.STRING;
        }
        if (!(this.valueLength != 4 || 'n' != this.buffer[this.valuePos] && 'N' != this.buffer[this.valuePos] || 'u' != this.buffer[this.valuePos + 1] && 'U' != this.buffer[this.valuePos + 1] || 'l' != this.buffer[this.valuePos + 2] && 'L' != this.buffer[this.valuePos + 2] || 'l' != this.buffer[this.valuePos + 3] && 'L' != this.buffer[this.valuePos + 3])) {
            this.value = "null";
            return JsonToken.NULL;
        }
        if (!(this.valueLength != 4 || 't' != this.buffer[this.valuePos] && 'T' != this.buffer[this.valuePos] || 'r' != this.buffer[this.valuePos + 1] && 'R' != this.buffer[this.valuePos + 1] || 'u' != this.buffer[this.valuePos + 2] && 'U' != this.buffer[this.valuePos + 2] || 'e' != this.buffer[this.valuePos + 3] && 'E' != this.buffer[this.valuePos + 3])) {
            this.value = TRUE;
            return JsonToken.BOOLEAN;
        }
        if (!(this.valueLength != 5 || 'f' != this.buffer[this.valuePos] && 'F' != this.buffer[this.valuePos] || 'a' != this.buffer[this.valuePos + 1] && 'A' != this.buffer[this.valuePos + 1] || 'l' != this.buffer[this.valuePos + 2] && 'L' != this.buffer[this.valuePos + 2] || 's' != this.buffer[this.valuePos + 3] && 'S' != this.buffer[this.valuePos + 3] || 'e' != this.buffer[this.valuePos + 4] && 'E' != this.buffer[this.valuePos + 4])) {
            this.value = FALSE;
            return JsonToken.BOOLEAN;
        }
        this.value = this.stringPool.get(this.buffer, this.valuePos, this.valueLength);
        return this.decodeNumber(this.buffer, this.valuePos, this.valueLength);
    }

    private JsonToken decodeNumber(char[] cArray, int n2, int n3) {
        int n4;
        block11: {
            int n5;
            int n6;
            block13: {
                block12: {
                    int n7;
                    block10: {
                        n6 = n2;
                        n4 = n7 = cArray[n6];
                        n5 = n6;
                        if (n7 == 45) {
                            n5 = n6 + 1;
                            n4 = cArray[n5];
                        }
                        if (n4 == 48) {
                            n4 = cArray[++n5];
                        } else {
                            if (n4 < 49) return JsonToken.STRING;
                            if (n4 > 57) return JsonToken.STRING;
                            n7 = n5 + 1;
                            n6 = cArray[n7];
                            while (true) {
                                n4 = n6;
                                n5 = n7;
                                if (n6 < 48) break;
                                n4 = n6;
                                n5 = n7++;
                                if (n6 > 57) break;
                                n6 = cArray[n7];
                            }
                        }
                        n7 = n4;
                        n6 = n5;
                        if (n4 == 46) {
                            n4 = n5 + 1;
                            n5 = cArray[n4];
                            while (true) {
                                n7 = n5;
                                n6 = n4;
                                if (n5 < 48) break;
                                n7 = n5;
                                n6 = n4++;
                                if (n5 > 57) break;
                                n5 = cArray[n4];
                            }
                        }
                        if (n7 == 101) break block10;
                        n4 = n6;
                        if (n7 != 69) break block11;
                    }
                    if ((n7 = cArray[n4 = n6 + 1]) == 43) break block12;
                    n6 = n7;
                    n5 = n4;
                    if (n7 != 45) break block13;
                }
                n5 = n4 + 1;
                n6 = cArray[n5];
            }
            if (n6 < 48) return JsonToken.STRING;
            if (n6 > 57) return JsonToken.STRING;
            n6 = cArray[++n5];
            while (true) {
                n4 = n5;
                if (n6 < 48) break;
                n4 = n5++;
                if (n6 > 57) break;
                n6 = cArray[n5];
            }
        }
        if (n4 != n2 + n3) return JsonToken.STRING;
        return JsonToken.NUMBER;
    }

    private void expect(JsonToken jsonToken) throws IOException {
        this.peek();
        if (this.token != jsonToken) {
            throw new IllegalStateException("Expected " + (Object)((Object)jsonToken) + " but was " + (Object)((Object)this.peek()) + " at line " + this.getLineNumber() + " column " + this.getColumnNumber());
        }
        this.advance();
    }

    private boolean fillBuffer(int n2) throws IOException {
        char[] cArray = this.buffer;
        int n3 = this.bufferStartLine;
        int n4 = this.bufferStartColumn;
        int n5 = this.pos;
        for (int i2 = 0; i2 < n5; ++i2) {
            if (cArray[i2] == '\n') {
                ++n3;
                n4 = 1;
                continue;
            }
            ++n4;
        }
        this.bufferStartLine = n3;
        this.bufferStartColumn = n4;
        if (this.limit != this.pos) {
            this.limit -= this.pos;
            System.arraycopy(cArray, this.pos, cArray, 0, this.limit);
        } else {
            this.limit = 0;
        }
        this.pos = 0;
        do {
            if ((n4 = this.in.read(cArray, this.limit, cArray.length - this.limit)) == -1) return false;
            this.limit += n4;
            if (this.bufferStartLine != 1 || this.bufferStartColumn != 1 || this.limit <= 0 || cArray[0] != '\ufeff') continue;
            ++this.pos;
            --this.bufferStartColumn;
        } while (this.limit < n2);
        return true;
    }

    private int getColumnNumber() {
        int n2 = this.bufferStartColumn;
        int n3 = 0;
        while (n3 < this.pos) {
            n2 = this.buffer[n3] == '\n' ? 1 : ++n2;
            ++n3;
        }
        return n2;
    }

    private int getLineNumber() {
        int n2 = this.bufferStartLine;
        int n3 = 0;
        while (n3 < this.pos) {
            int n4 = n2;
            if (this.buffer[n3] == '\n') {
                n4 = n2 + 1;
            }
            ++n3;
            n2 = n4;
        }
        return n2;
    }

    private JsonToken nextInArray(boolean bl2) throws IOException {
        JsonToken jsonToken;
        if (bl2) {
            this.stack[this.stackSize - 1] = JsonScope.NONEMPTY_ARRAY;
        } else {
            switch (this.nextNonWhitespace(true)) {
                case 44: {
                    break;
                }
                default: {
                    throw this.syntaxError("Unterminated array");
                }
                case 93: {
                    JsonToken jsonToken2;
                    --this.stackSize;
                    this.token = jsonToken2 = JsonToken.END_ARRAY;
                    return jsonToken2;
                }
                case 59: {
                    this.checkLenient();
                }
            }
        }
        switch (this.nextNonWhitespace(true)) {
            default: {
                --this.pos;
                return this.nextValue();
            }
            case 93: {
                JsonToken jsonToken3;
                if (!bl2) break;
                --this.stackSize;
                this.token = jsonToken3 = JsonToken.END_ARRAY;
                return jsonToken3;
            }
            case 44: 
            case 59: 
        }
        this.checkLenient();
        --this.pos;
        this.value = "null";
        this.token = jsonToken = JsonToken.NULL;
        return jsonToken;
    }

    /*
     * Exception decompiling
     */
    private JsonToken nextInObject(boolean var1_1) throws IOException {
        /*
         * This method has failed to decompile.  When submitting a bug report, please provide this stack trace, and (if you hold appropriate legal rights) the relevant class file.
         * 
         * org.benf.cfr.reader.util.ConfusedCFRException: Tried to end blocks [8[CASE]], but top level block is 3[SWITCH]
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.processEndingBlocks(Op04StructuredStatement.java:435)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op04StructuredStatement.buildNestedBlocks(Op04StructuredStatement.java:484)
         *     at org.benf.cfr.reader.bytecode.analysis.opgraph.Op03SimpleStatement.createInitialStructuredBlock(Op03SimpleStatement.java:736)
         *     at org.benf.cfr.reader.bytecode.CodeAnalyser.getAnalysisInner(CodeAnalyser.java:850)
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

    private String nextLiteral(boolean bl2) throws IOException {
        int n2;
        StringBuilder stringBuilder;
        CharSequence charSequence = null;
        this.valuePos = -1;
        this.valueLength = 0;
        int n3 = 0;
        block4: while (true) {
            if (this.pos + n3 < this.limit) {
                stringBuilder = charSequence;
                n2 = n3;
                switch (this.buffer[this.pos + n3]) {
                    default: {
                        ++n3;
                        continue block4;
                    }
                    case '#': 
                    case '/': 
                    case ';': 
                    case '=': 
                    case '\\': {
                        this.checkLenient();
                        n2 = n3;
                        stringBuilder = charSequence;
                        break;
                    }
                    case '\t': 
                    case '\n': 
                    case '\f': 
                    case '\r': 
                    case ' ': 
                    case ',': 
                    case ':': 
                    case '[': 
                    case ']': 
                    case '{': 
                    case '}': {
                        break;
                    }
                }
                break;
            }
            if (n3 < this.buffer.length) {
                if (this.fillBuffer(n3 + 1)) continue;
                this.buffer[this.limit] = '\u0000';
                stringBuilder = charSequence;
                n2 = n3;
                break;
            }
            stringBuilder = charSequence;
            if (charSequence == null) {
                stringBuilder = new StringBuilder();
            }
            stringBuilder.append(this.buffer, this.pos, n3);
            this.valueLength += n3;
            this.pos += n3;
            n2 = 0;
            n3 = 0;
            charSequence = stringBuilder;
            if (!this.fillBuffer(1)) break;
        }
        if (bl2 && stringBuilder == null) {
            this.valuePos = this.pos;
            charSequence = null;
        } else if (this.skipping) {
            charSequence = "skipped!";
        } else if (stringBuilder == null) {
            charSequence = this.stringPool.get(this.buffer, this.pos, n2);
        } else {
            stringBuilder.append(this.buffer, this.pos, n2);
            charSequence = stringBuilder.toString();
        }
        this.valueLength += n2;
        this.pos += n2;
        return charSequence;
    }

    private int nextNonWhitespace(boolean bl2) throws IOException {
        char[] cArray = this.buffer;
        int n2 = this.pos;
        int n3 = this.limit;
        block9: while (true) {
            int n4 = n3;
            int n5 = n2;
            if (n2 == n3) {
                this.pos = n2;
                if (!this.fillBuffer(1)) {
                    if (!bl2) return -1;
                    throw new EOFException("End of input at line " + this.getLineNumber() + " column " + this.getColumnNumber());
                }
                n5 = this.pos;
                n4 = this.limit;
            }
            n2 = n5 + 1;
            n3 = cArray[n5];
            switch (n3) {
                default: {
                    this.pos = n2;
                    return n3;
                }
                case 9: 
                case 10: 
                case 13: 
                case 32: {
                    n3 = n4;
                    continue block9;
                }
                case 47: {
                    this.pos = n2;
                    if (n2 == n4) {
                        --this.pos;
                        boolean bl3 = this.fillBuffer(2);
                        ++this.pos;
                        if (!bl3) {
                            return n3;
                        }
                    }
                    this.checkLenient();
                    switch (cArray[this.pos]) {
                        default: {
                            return n3;
                        }
                        case '*': {
                            ++this.pos;
                            if (!this.skipTo("*/")) {
                                throw this.syntaxError("Unterminated comment");
                            }
                            n2 = this.pos + 2;
                            n3 = this.limit;
                            continue block9;
                        }
                        case '/': 
                    }
                    ++this.pos;
                    this.skipToEndOfLine();
                    n2 = this.pos;
                    n3 = this.limit;
                    continue block9;
                }
                case 35: 
            }
            this.pos = n2;
            this.checkLenient();
            this.skipToEndOfLine();
            n2 = this.pos;
            n3 = this.limit;
        }
    }

    private String nextString(char c2) throws IOException {
        char[] cArray = this.buffer;
        StringBuilder stringBuilder = null;
        do {
            StringBuilder stringBuilder2;
            int n2 = this.pos;
            int n3 = this.limit;
            int n4 = n2;
            while (n2 < n3) {
                int n5 = n2 + 1;
                char c3 = cArray[n2];
                if (c3 == c2) {
                    this.pos = n5;
                    if (this.skipping) {
                        return "skipped!";
                    }
                    if (stringBuilder == null) {
                        return this.stringPool.get(cArray, n4, n5 - n4 - 1);
                    }
                    stringBuilder.append(cArray, n4, n5 - n4 - 1);
                    return stringBuilder.toString();
                }
                stringBuilder2 = stringBuilder;
                n2 = n3;
                n3 = n5;
                int n6 = n4;
                if (c3 == '\\') {
                    this.pos = n5;
                    stringBuilder2 = stringBuilder;
                    if (stringBuilder == null) {
                        stringBuilder2 = new StringBuilder();
                    }
                    stringBuilder2.append(cArray, n4, n5 - n4 - 1);
                    stringBuilder2.append(this.readEscapeCharacter());
                    n3 = this.pos;
                    n2 = this.limit;
                    n6 = n3;
                }
                n4 = n3;
                stringBuilder = stringBuilder2;
                n3 = n2;
                n2 = n4;
                n4 = n6;
            }
            stringBuilder2 = stringBuilder;
            if (stringBuilder == null) {
                stringBuilder2 = new StringBuilder();
            }
            stringBuilder2.append(cArray, n4, n2 - n4);
            this.pos = n2;
            stringBuilder = stringBuilder2;
        } while (this.fillBuffer(1));
        throw this.syntaxError("Unterminated string");
    }

    private JsonToken nextValue() throws IOException {
        JsonToken jsonToken;
        int n2 = this.nextNonWhitespace(true);
        switch (n2) {
            default: {
                --this.pos;
                return this.readLiteral();
            }
            case 123: {
                JsonToken jsonToken2;
                this.push(JsonScope.EMPTY_OBJECT);
                this.token = jsonToken2 = JsonToken.BEGIN_OBJECT;
                return jsonToken2;
            }
            case 91: {
                JsonToken jsonToken3;
                this.push(JsonScope.EMPTY_ARRAY);
                this.token = jsonToken3 = JsonToken.BEGIN_ARRAY;
                return jsonToken3;
            }
            case 39: {
                this.checkLenient();
                break;
            }
            case 34: 
        }
        this.value = this.nextString((char)n2);
        this.token = jsonToken = JsonToken.STRING;
        return jsonToken;
    }

    private JsonToken objectValue() throws IOException {
        switch (this.nextNonWhitespace(true)) {
            default: {
                throw this.syntaxError("Expected ':'");
            }
            case 61: {
                this.checkLenient();
                if (this.pos >= this.limit && !this.fillBuffer(1) || this.buffer[this.pos] != '>') break;
                ++this.pos;
                break;
            }
            case 58: 
        }
        this.stack[this.stackSize - 1] = JsonScope.NONEMPTY_OBJECT;
        return this.nextValue();
    }

    private void push(JsonScope jsonScope) {
        JsonScope[] jsonScopeArray;
        if (this.stackSize == this.stack.length) {
            jsonScopeArray = new JsonScope[this.stackSize * 2];
            System.arraycopy(this.stack, 0, jsonScopeArray, 0, this.stackSize);
            this.stack = jsonScopeArray;
        }
        jsonScopeArray = this.stack;
        int n2 = this.stackSize;
        this.stackSize = n2 + 1;
        jsonScopeArray[n2] = jsonScope;
    }

    private char readEscapeCharacter() throws IOException {
        if (this.pos == this.limit && !this.fillBuffer(1)) {
            throw this.syntaxError("Unterminated escape sequence");
        }
        char[] cArray = this.buffer;
        int n2 = this.pos;
        this.pos = n2 + 1;
        char c2 = cArray[n2];
        switch (c2) {
            default: {
                return c2;
            }
            case 'u': {
                int n3;
                if (this.pos + 4 > this.limit && !this.fillBuffer(4)) {
                    throw this.syntaxError("Unterminated escape sequence");
                }
                c2 = '\u0000';
                n2 = n3 = this.pos;
                while (true) {
                    if (n2 >= n3 + 4) {
                        this.pos += 4;
                        return c2;
                    }
                    char c3 = this.buffer[n2];
                    char c4 = (char)(c2 << 4);
                    if (c3 >= '0' && c3 <= '9') {
                        c2 = (char)(c3 - 48 + c4);
                    } else if (c3 >= 'a' && c3 <= 'f') {
                        c2 = (char)(c3 - 97 + 10 + c4);
                    } else {
                        if (c3 < 'A') throw new NumberFormatException("\\u" + this.stringPool.get(this.buffer, this.pos, 4));
                        if (c3 > 'F') throw new NumberFormatException("\\u" + this.stringPool.get(this.buffer, this.pos, 4));
                        c2 = (char)(c3 - 65 + 10 + c4);
                    }
                    ++n2;
                }
            }
            case 't': {
                return '\t';
            }
            case 'b': {
                return '\b';
            }
            case 'n': {
                return '\n';
            }
            case 'r': {
                return '\r';
            }
            case 'f': 
        }
        return '\f';
    }

    private JsonToken readLiteral() throws IOException {
        this.value = this.nextLiteral(true);
        if (this.valueLength == 0) {
            throw this.syntaxError("Expected literal value");
        }
        this.token = this.decodeLiteral();
        if (this.token != JsonToken.STRING) return this.token;
        this.checkLenient();
        return this.token;
    }

    private boolean skipTo(String string2) throws IOException {
        block0: while (true) {
            if (this.pos + string2.length() > this.limit) {
                if (!this.fillBuffer(string2.length())) return false;
            }
            int n2 = 0;
            while (n2 < string2.length()) {
                if (this.buffer[this.pos + n2] != string2.charAt(n2)) {
                    ++this.pos;
                    continue block0;
                }
                ++n2;
            }
            return true;
        }
    }

    private void skipToEndOfLine() throws IOException {
        int n2;
        do {
            if (this.pos >= this.limit) {
                if (!this.fillBuffer(1)) return;
            }
            char[] cArray = this.buffer;
            n2 = this.pos;
            this.pos = n2 + 1;
            if ((n2 = cArray[n2]) == 13) return;
        } while (n2 != 10);
    }

    private IOException syntaxError(String string2) throws IOException {
        throw new MalformedJsonException(string2 + " at line " + this.getLineNumber() + " column " + this.getColumnNumber());
    }

    public void beginArray() throws IOException {
        this.expect(JsonToken.BEGIN_ARRAY);
    }

    public void beginObject() throws IOException {
        this.expect(JsonToken.BEGIN_OBJECT);
    }

    @Override
    public void close() throws IOException {
        this.value = null;
        this.token = null;
        this.stack[0] = JsonScope.CLOSED;
        this.stackSize = 1;
        this.in.close();
    }

    public void endArray() throws IOException {
        this.expect(JsonToken.END_ARRAY);
    }

    public void endObject() throws IOException {
        this.expect(JsonToken.END_OBJECT);
    }

    public boolean hasNext() throws IOException {
        this.peek();
        if (this.token == JsonToken.END_OBJECT) return false;
        if (this.token == JsonToken.END_ARRAY) return false;
        return true;
    }

    public final boolean isLenient() {
        return this.lenient;
    }

    public boolean nextBoolean() throws IOException {
        this.peek();
        if (this.token != JsonToken.BOOLEAN) {
            throw new IllegalStateException("Expected a boolean but was " + (Object)((Object)this.token) + " at line " + this.getLineNumber() + " column " + this.getColumnNumber());
        }
        boolean bl2 = this.value == TRUE;
        this.advance();
        return bl2;
    }

    public double nextDouble() throws IOException {
        this.peek();
        if (this.token != JsonToken.STRING && this.token != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected a double but was " + (Object)((Object)this.token) + " at line " + this.getLineNumber() + " column " + this.getColumnNumber());
        }
        double d2 = Double.parseDouble(this.value);
        if (d2 >= 1.0 && this.value.startsWith("0")) {
            throw new MalformedJsonException("JSON forbids octal prefixes: " + this.value + " at line " + this.getLineNumber() + " column " + this.getColumnNumber());
        }
        if (!this.lenient) {
            if (Double.isNaN(d2)) throw new MalformedJsonException("JSON forbids NaN and infinities: " + this.value + " at line " + this.getLineNumber() + " column " + this.getColumnNumber());
            if (Double.isInfinite(d2)) {
                throw new MalformedJsonException("JSON forbids NaN and infinities: " + this.value + " at line " + this.getLineNumber() + " column " + this.getColumnNumber());
            }
        }
        this.advance();
        return d2;
    }

    public int nextInt() throws IOException {
        int n2;
        block4: {
            this.peek();
            if (this.token != JsonToken.STRING && this.token != JsonToken.NUMBER) {
                throw new IllegalStateException("Expected an int but was " + (Object)((Object)this.token) + " at line " + this.getLineNumber() + " column " + this.getColumnNumber());
            }
            try {
                n2 = Integer.parseInt(this.value);
            }
            catch (NumberFormatException numberFormatException) {
                int n3;
                double d2 = Double.parseDouble(this.value);
                n2 = n3 = (int)d2;
                if ((double)n3 == d2) break block4;
                throw new NumberFormatException("Expected an int but was " + this.value + " at line " + this.getLineNumber() + " column " + this.getColumnNumber());
            }
        }
        if ((long)n2 >= 1L && this.value.startsWith("0")) {
            throw new MalformedJsonException("JSON forbids octal prefixes: " + this.value + " at line " + this.getLineNumber() + " column " + this.getColumnNumber());
        }
        this.advance();
        return n2;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public long nextLong() throws IOException {
        long l2;
        block4: {
            this.peek();
            if (this.token != JsonToken.STRING && this.token != JsonToken.NUMBER) {
                throw new IllegalStateException("Expected a long but was " + (Object)((Object)this.token) + " at line " + this.getLineNumber() + " column " + this.getColumnNumber());
            }
            try {
                l2 = Long.parseLong(this.value);
            }
            catch (NumberFormatException numberFormatException) {
                long l3;
                double d2 = Double.parseDouble(this.value);
                l2 = l3 = (long)d2;
                if ((double)l3 == d2) break block4;
                throw new NumberFormatException("Expected a long but was " + this.value + " at line " + this.getLineNumber() + " column " + this.getColumnNumber());
            }
        }
        while (l2 >= 1L && this.value.startsWith("0")) {
            throw new MalformedJsonException("JSON forbids octal prefixes: " + this.value + " at line " + this.getLineNumber() + " column " + this.getColumnNumber());
        }
        this.advance();
        return l2;
    }

    public String nextName() throws IOException {
        this.peek();
        if (this.token != JsonToken.NAME) {
            throw new IllegalStateException("Expected a name but was " + (Object)((Object)this.peek()) + " at line " + this.getLineNumber() + " column " + this.getColumnNumber());
        }
        String string2 = this.name;
        this.advance();
        return string2;
    }

    public void nextNull() throws IOException {
        this.peek();
        if (this.token != JsonToken.NULL) {
            throw new IllegalStateException("Expected null but was " + (Object)((Object)this.token) + " at line " + this.getLineNumber() + " column " + this.getColumnNumber());
        }
        this.advance();
    }

    public String nextString() throws IOException {
        this.peek();
        if (this.token != JsonToken.STRING && this.token != JsonToken.NUMBER) {
            throw new IllegalStateException("Expected a string but was " + (Object)((Object)this.peek()) + " at line " + this.getLineNumber() + " column " + this.getColumnNumber());
        }
        String string2 = this.value;
        this.advance();
        return string2;
    }

    public JsonToken peek() throws IOException {
        if (this.token != null) {
            return this.token;
        }
        switch (2.$SwitchMap$com$google$gson$stream$JsonScope[this.stack[this.stackSize - 1].ordinal()]) {
            default: {
                throw new AssertionError();
            }
            case 1: {
                JsonToken jsonToken;
                if (this.lenient) {
                    this.consumeNonExecutePrefix();
                }
                this.stack[this.stackSize - 1] = JsonScope.NONEMPTY_DOCUMENT;
                JsonToken jsonToken2 = jsonToken = this.nextValue();
                if (this.lenient) return jsonToken2;
                jsonToken2 = jsonToken;
                if (this.token == JsonToken.BEGIN_ARRAY) return jsonToken2;
                jsonToken2 = jsonToken;
                if (this.token == JsonToken.BEGIN_OBJECT) return jsonToken2;
                throw new IOException("Expected JSON document to start with '[' or '{' but was " + (Object)((Object)this.token) + " at line " + this.getLineNumber() + " column " + this.getColumnNumber());
            }
            case 2: {
                return this.nextInArray(true);
            }
            case 3: {
                return this.nextInArray(false);
            }
            case 4: {
                return this.nextInObject(true);
            }
            case 5: {
                return this.objectValue();
            }
            case 6: {
                return this.nextInObject(false);
            }
            case 7: {
                if (this.nextNonWhitespace(false) == -1) {
                    return JsonToken.END_DOCUMENT;
                }
                --this.pos;
                if (this.lenient) return this.nextValue();
                throw this.syntaxError("Expected EOF");
            }
            case 8: 
        }
        throw new IllegalStateException("JsonReader is closed");
    }

    public final void setLenient(boolean bl2) {
        this.lenient = bl2;
    }

    /*
     * Enabled unnecessary exception pruning
     */
    public void skipValue() throws IOException {
        this.skipping = true;
        int n2 = 0;
        try {
            int n3;
            do {
                block7: {
                    block8: {
                        JsonToken jsonToken;
                        JsonToken jsonToken2;
                        block6: {
                            if ((jsonToken2 = this.advance()) != JsonToken.BEGIN_ARRAY && jsonToken2 != (jsonToken = JsonToken.BEGIN_OBJECT)) break block6;
                            n3 = n2 + 1;
                            break block7;
                        }
                        if (jsonToken2 == JsonToken.END_ARRAY) break block8;
                        jsonToken = JsonToken.END_OBJECT;
                        n3 = n2;
                        if (jsonToken2 != jsonToken) break block7;
                    }
                    n3 = n2 - 1;
                }
                n2 = n3;
            } while (n3 != 0);
            this.skipping = false;
            return;
        }
        catch (Throwable throwable) {
            this.skipping = false;
            throw throwable;
        }
    }

    public String toString() {
        return this.getClass().getSimpleName() + " at line " + this.getLineNumber() + " column " + this.getColumnNumber();
    }
}

