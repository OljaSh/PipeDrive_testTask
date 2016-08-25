package com.pipedrive.utils;

import org.apache.commons.lang.SystemUtils;

import java.util.Optional;

import static java.lang.ClassLoader.getSystemResource;


public final class WebDriverUtils {

    public static void setChromeDriverPath() {

        final String driverName = "chromedriver_" +
                (SystemUtils.IS_OS_WINDOWS ? "win32.exe" :
                        SystemUtils.IS_OS_MAC || SystemUtils.IS_OS_MAC_OSX ? "mac32" :
                                Optional.ofNullable(SystemUtils.OS_ARCH)
                                        .filter(arch -> arch.contains("86"))
                                        .map(arch -> "linux32")
                                        .orElse("linux64"));

        System.setProperty("webdriver.chrome.driver", getSystemResource("drivers/" + driverName).getFile());
       // System.setProperty("webdriver.chrome.driver", "drivers/chromedriver_linux64");
    }

    public static void setIEDriverPath(){
        System.setProperty("webdriver.ie.driver", getSystemResource("drivers/" + "IEDriverServer.exe").getFile());
    }

    private WebDriverUtils() {
    }

}

