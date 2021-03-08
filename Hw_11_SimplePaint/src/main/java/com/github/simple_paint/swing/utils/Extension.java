package com.github.simple_paint.swing.utils;

public enum Extension {
    BIN(".bin"),
    JSON(".json"),
    YML(".yml"),
    XML(".xml"),
    CSV(".csv");

    private String value;

    Extension(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public String toString() {
        return this.getValue();
    }

    public static Extension getValue(String value) {
        for (Extension v : values()) {
            if (v.getValue().equalsIgnoreCase(value)) return v;
        }
        return null;
    }
}

