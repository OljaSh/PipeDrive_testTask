package com.pipedrive.preset;

import com.esotericsoftware.reflectasm.ConstructorAccess;
import com.pipedrive.pajeobject.SiteHomePage;

import static com.pipedrive.core.BaseTest.getDriver;

//import com.pipedrive.pajeobject.Site;


public class PageObjectSupplier {

    public static <T> T $(Class<T> pageObject) {
        return ConstructorAccess.get(pageObject).newInstance();
    }

    public static SiteHomePage loadSiteUrl(final URL url) {
        getDriver().get(url.toString());
        return $(SiteHomePage.class);
    }

    private PageObjectSupplier(){
    }
}
