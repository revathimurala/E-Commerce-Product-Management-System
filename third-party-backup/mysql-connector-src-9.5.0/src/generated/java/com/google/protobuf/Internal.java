package com.google.protobuf;

public class Internal {
    public interface EnumLiteMap<T extends Enum<T>> {
        T findValueByNumber(int number);
    }
}
