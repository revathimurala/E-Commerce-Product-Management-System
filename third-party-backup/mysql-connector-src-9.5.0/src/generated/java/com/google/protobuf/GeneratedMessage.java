package com.google.protobuf;

import java.io.InputStream;
import java.io.IOException;

public abstract class GeneratedMessage {
    public static abstract class Builder<T extends GeneratedMessage> {
    }

    // Minimal nested FieldAccessorTable used by generated code
    public static class FieldAccessorTable {
        private final Object descriptor;
        private final String[] names;

        public FieldAccessorTable(Object descriptor, String[] names) {
            this.descriptor = descriptor;
            this.names = names;
        }

        public FieldAccessorTable ensureFieldAccessorsInitialized(Class<?> messageClass, Class<?> builderClass) {
            return this;
        }
    }

    // Parsing helpers used by generated code (shims)
    public static <T> T parseWithIOException(Parser<T> parser, InputStream input) throws IOException {
        throw new IOException("parseWithIOException not implemented in shim");
    }

    public static <T> T parseWithIOException(Parser<T> parser, InputStream input, ExtensionRegistryLite ext) throws IOException {
        throw new IOException("parseWithIOException not implemented in shim");
    }

    public static <T> T parseDelimitedWithIOException(Parser<T> parser, InputStream input) throws IOException {
        throw new IOException("parseDelimitedWithIOException not implemented in shim");
    }

    public static <T> T parseDelimitedWithIOException(Parser<T> parser, InputStream input, ExtensionRegistryLite ext) throws IOException {
        throw new IOException("parseDelimitedWithIOException not implemented in shim");
    }
}
