package com.google.protobuf;

public class RuntimeVersion {
    public enum RuntimeDomain { PUBLIC }

    // Older generated code calls this overload with version parts and suffix.
    public static void validateProtobufGencodeVersion(RuntimeDomain d, int major, int minor, int patch, String suffix, String className) {
        // no-op shim for generated code compatibility
    }

    // Keep a simpler overload too
    public static void validateProtobufGencodeVersion(RuntimeDomain d, String s) {
        // no-op shim
    }
}
