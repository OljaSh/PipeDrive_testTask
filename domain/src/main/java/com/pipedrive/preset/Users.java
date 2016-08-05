package com.pipedrive.preset;

import com.pipedrive.utils.PropertiesUtils;

import static com.pipedrive.utils.PropertiesUtils.getStringValue;

public enum Users {

    DEMOUSER(getStringValue(PropertiesUtils.Constants.DEMO_USER)),
    EXPIREDUSER(getStringValue(PropertiesUtils.Constants.EXPIRED_USER));

    private String text;

    Users(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return text;
    }
}

    /*PROD(getStringValue(PropertiesUtils.Constants.PROD_URL));

private String address;

        URL(final String address){
        this.address = address;
        }

public String toString(){
        return Optional.ofNullable(System.getenv("URL")).orElse(address);
        }*/
