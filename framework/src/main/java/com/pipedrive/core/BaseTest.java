package com.pipedrive.core;

import com.pipedrive.utils.Browser;
import com.pipedrive.utils.PropertiesUtils;
import com.pipedrive.utils.WebDriverUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static com.pipedrive.utils.PropertiesUtils.getLongValue;


public class BaseTest {

    private static final ThreadLocal<WebDriver> WEB_DRIVER_CONTAINER = new  ThreadLocal<>();
	private static final ThreadLocal<SoftAssert> SOFT_ASSERT_CONTAINER = new  ThreadLocal<>();

    public static WebDriver getDriver(){
        return WEB_DRIVER_CONTAINER.get();
    }

    public static SoftAssert getSoftAssert() {
    	return SOFT_ASSERT_CONTAINER.get();
    }

    @BeforeMethod
    //@Parameters({"browser"})
    public void setUp(ITestContext context) throws MalformedURLException {
        Browser browser = Browser.getBrowser(context.getCurrentXmlTest().getAllParameters().get("browser"));
        WebDriver driver;
        

        switch (browser) {
            case CHROME:
                WebDriverUtils.setChromeDriverPath();
                driver = new ChromeDriver();
                break;
            case SAFARI:
                driver = new SafariDriver();
                break;
            case IE:
                 WebDriverUtils.setIEDriverPath();
                driver = new InternetExplorerDriver();
                break;
            case ANDROID:
                //ToDo: put into separate method; avoid hardcoding
                DesiredCapabilities capabilities = new DesiredCapabilities();
                capabilities.setCapability("platformName", "Android");
                capabilities.setCapability("deviceName", "HT24VW100001");
                capabilities.setCapability("platformVersion", "4.2.2");
                capabilities.setCapability(CapabilityType.BROWSER_NAME, "Chrome");
                driver = new RemoteWebDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
                break;
            case FIREFOX:
            default:
                driver = new FirefoxDriver();
                break;
        }

        driver.manage().timeouts().implicitlyWait(getLongValue(PropertiesUtils.Constants.WAIT_TIME_SEC), TimeUnit.SECONDS);
        // maximization API is absent on mobile platforms
        if (browser != Browser.ANDROID) {
            driver.manage().window().maximize();
        }
        WEB_DRIVER_CONTAINER.set(driver);
	    SOFT_ASSERT_CONTAINER.set(new SoftAssert());
    }

    @AfterMethod
    public void tearDown(){
        if (getDriver() != null){
            getDriver().quit();
            WEB_DRIVER_CONTAINER.remove();
        }
        SOFT_ASSERT_CONTAINER.remove();
    }
}