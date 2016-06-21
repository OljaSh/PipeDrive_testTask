package com.pipedrive.preset;

import com.pipedrive.utils.PropertiesUtils;

import java.util.Optional;

import static com.pipedrive.utils.PropertiesUtils.getStringValue;


public enum URL {

    PROD(getStringValue(PropertiesUtils.Constants.PROD_URL));

    private String address;

    URL(final String address){
        this.address = address;
    }

    public String toString(){
        return Optional.ofNullable(System.getenv("URL")).orElse(address);
    }
}


