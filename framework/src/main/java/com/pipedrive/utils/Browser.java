package com.pipedrive.utils;

import java.util.stream.Stream;

public enum Browser {
    CHROME("chrome"),
    FIREFOX("firefox"),
    IE("ie"),
    SAFARI("safari"),
    ANDROID("android"),
    IPHONEDEV("iphonedev"),
    IPHONEEMU("iphoneemu");

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
