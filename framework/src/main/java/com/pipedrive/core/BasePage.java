package com.pipedrive.core;


import com.pipedrive.utils.PropertiesUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Locale;
import java.util.logging.Logger;

import static com.pipedrive.utils.PropertiesUtils.getLongValue;




public class BasePage {

    private WebDriver driver;
    private WebDriverWait wait;
    private static Locale currentLocale = Locale.getDefault();

    private static final Logger LOGGER = Logger.getLogger(BasePage.class.getName());

    public BasePage () {
        driver = BaseTest.getDriver();
        wait = new WebDriverWait(driver, getLongValue(PropertiesUtils.Constants.DEFAULT_TIMEOUT));
    }

    public static Locale getCurrentLocale() {
        return currentLocale;
    }

    public static void setCurrentLocale(Locale currentLocale) {
        BasePage.currentLocale = currentLocale;
    }

    public WebElement findElement(By element){
        return driver.findElement(element);
    }

    public void setText(By element, String text){
        findElement(element).sendKeys(text);
    }

    public void click(By element){
        findElement(element).click();
    }

    public void clickAndWait(By element){
        wait.until(ExpectedConditions.visibilityOfElementLocated(element));
    }

    public String getText(By element){
        return findElement(element).getText();
    }

    public void setRadioSelected(By element, String text){
        findElement(element).click();
    }

    public void selectFromDropDownList(By element, String text){
        new Select(findElement(element)).selectByVisibleText(text);
    }

    public void selectValueFromDropDownList(By element, String text){
        new Select(findElement(element)).selectByValue(text);
    }

    public void scrollTo(By locator) {
        WebElement element=getDriver().findElement(locator);
        executeJs("window.scrollTo(0, document.body.scrollHeight)");
    }


    public WebDriver getDriver(){
        return driver;
    }


    public boolean isDisplayed(By element) {
        try {
            return findElement(element).isDisplayed();
        } catch (Exception ignored) {
            LOGGER.info("Unable to find " + element);
            return false;
        }
    }

    public boolean isDisplayedByCondition(By element) {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(element)).isDisplayed();
        } catch (Exception ignored) {
            LOGGER.info("Unable to find " + element);
            return false;
        }
    }



    public void executeJs(String command, Object... args){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript(command,args);
    }


}
