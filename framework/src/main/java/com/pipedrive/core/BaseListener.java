package com.pipedrive.core;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.Augmenter;
import org.testng.*;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.util.logging.Logger;

import static com.pipedrive.core.BaseTest.getDriver;

/**
 * Author: Serhii Korol.
 */
public class BaseListener implements IInvokedMethodListener, ITestListener {

    private static final Logger LOGGER = Logger.getLogger(BaseListener.class.getName());

    @Override
    public void beforeInvocation(IInvokedMethod method, ITestResult testResult) {

    }

    @Override
    public void afterInvocation(IInvokedMethod method, ITestResult testResult) {

    }

    @Override
    public void onTestStart(ITestResult result) {

    }

    @Override
    public void onTestSuccess(ITestResult result) {
        takeScreenshot();
    }

    @Override
    public void onTestFailure(ITestResult result) {
        takeScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {

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
