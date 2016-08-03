package com.pipedrive.core;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.*;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.util.logging.Logger;

import static com.pipedrive.core.BaseTest.getDriver;
import static com.pipedrive.core.BaseTest.getSoftAssert;

public class BaseListener implements IInvokedMethodListener {

    private static final Logger LOGGER = Logger.getLogger(BaseListener.class.getName());

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {
	    if (method.isTestMethod()) {
	    	try {
	    		getSoftAssert().assertAll();
		    } catch (AssertionError error) {
		    	testResult.setStatus(ITestResult.FAILURE);
			    testResult.setThrowable(error);
		    }
		    takeScreenshot();
	    }
    }

    private void takeScreenshot() {
        LOGGER.info("Taking screenshot");
        try {
            WebDriver augmentedDriver = new Augmenter().augment(getDriver());
            saveScreenshot("Screenshot", ((TakesScreenshot) augmentedDriver).getScreenshotAs(OutputType.BYTES));
        } catch (Exception ex) {
            LOGGER.severe("Unable to take screenshot: " + ex);
        }
    }

    @Attachment(value = "{0}", type = "image/png")
    public byte[] saveScreenshot(String name, byte[] screenShot) {
        return screenShot;
    }
}
