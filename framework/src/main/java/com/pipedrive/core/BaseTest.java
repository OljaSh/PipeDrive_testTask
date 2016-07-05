package com.pipedrive.core;

import com.pipedrive.utils.Browser;
import com.pipedrive.utils.PropertiesUtils;
import com.pipedrive.utils.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

import static com.pipedrive.utils.PropertiesUtils.getLongValue;


public class BaseTest {

    private static final ThreadLocal<WebDriver> WEB_DRIVER_CONTAINER = new  ThreadLocal<WebDriver>();

    public static WebDriver getDriver(){
        return WEB_DRIVER_CONTAINER.get();
    }

    @BeforeMethod
    //@Parameters({"browser"})
    public void setUp(ITestContext context) {
        String browser = context.getCurrentXmlTest().getAllParameters().get("browser");
        WebDriver driver;

        switch (Browser.getBrowser(browser/*System.getProperty("browser", "firefox")*/)) {
            case CHROME:
                WebDriverUtils.setChromeDriverPath();
                driver = new ChromeDriver();
                break;
            case FIREFOX:
            default:
                driver = new FirefoxDriver();
                break;
        }

        driver.manage().timeouts().implicitlyWait(getLongValue(PropertiesUtils.Constants.WAIT_TIME_SEC), TimeUnit.SECONDS);
        driver.manage().window().maximize();
        WEB_DRIVER_CONTAINER.set(driver);
    }

    @AfterMethod
    public void tearDown(){
        if (getDriver() != null){
            getDriver().quit();
            WEB_DRIVER_CONTAINER.remove();
        }
    }
}