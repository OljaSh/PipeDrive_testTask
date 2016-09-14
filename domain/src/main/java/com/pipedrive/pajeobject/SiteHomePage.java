package com.pipedrive.pajeobject;

import com.pipedrive.core.BasePage;
import com.pipedrive.preset.Language;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.pipedrive.preset.PageObjectSupplier.$;


public class SiteHomePage extends BasePage {

    private By buttonLogin = By.className("header__navigation__login");

    private By buttonSignUp = By.cssSelector(".btn.btn--primary");

    private By selectLanguage = By.name("language-picker");

    @Step("Click on Login button")
    public LoginPage clickLoginButton(){
        click(buttonLogin);
        return $(LoginPage.class);
    }

    @Step("Click Sign up Free button")
    public SignUpPage clickSignUpButton(){
        click(buttonSignUp);
        return $(SignUpPage.class);
    }

    @Step("Scroll page down")
    public SignUpPage scrollToButton(){
        scrollTo(selectLanguage);
        return $(SignUpPage.class);
    }

    /*private void scrollTo(By locator) {
        WebElement element=getDriver().findElement(locator);
        executeJs("window.scrollTo(0, document.body.scrollHeight)");
    }*/

    @Step("Select language = {0}")
    public SiteHomePage selectLanguage(Language language){
        scrollTo(selectLanguage);
        selectValueFromDropDownList(selectLanguage, language.getLanguage());
        setCurrentLocale(language.getLocale());
        return this;
    }



    /*private void executeJs(String command, Object...  args){
        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript(command,args);
    }*/
}
