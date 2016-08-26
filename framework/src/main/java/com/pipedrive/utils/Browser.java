package com.pipedrive.utils;

import java.util.stream.Stream;

public enum Browser {
    CHROME("chrome"),
    FIREFOX("firefox"),
    IE("ie"),
    SAFARI("safari"),
    ANDROID_DEV("android"),
    IPHONE_DEV("iphonedev"),
    IPHONE_EMU("iphoneemu");

    private String name;

    Browser(final String name) {
        this.name = name;
    }

    public static Browser getBrowser(final String name) {
        return Stream.of(values())
                .filter(value -> value.name.equals(name))
                .findFirst()
                .orElse(FIREFOX);
    }

    public String toString() {
        return name;
    }
}
