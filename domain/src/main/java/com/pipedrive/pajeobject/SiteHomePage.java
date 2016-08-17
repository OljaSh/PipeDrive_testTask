package com.pipedrive.pajeobject;

import com.pipedrive.preset.Language;
import ru.yandex.qatools.allure.annotations.Step;
import com.pipedrive.core.BasePage;
import org.openqa.selenium.By;

import static com.pipedrive.preset.PageObjectSupplier.$;


public class SiteHomePage extends BasePage {

    private By buttonLogin = By.className("header__navigation__login");

    private By buttonSignUp = By.cssSelector(".btn.btn--primary");

    private By selectLanguage = By.cssSelector(".language-picker__select-box");

    @Step("Click on login Button")
    public LoginPage clickLoginButton(){
        click(buttonLogin);
        return $(LoginPage.class);
    }

    @Step("Click Sign up free Button")
    public SignUpPage clickSignUpButton(){
        click(buttonSignUp);
        return $(SignUpPage.class);
    }

    @Step("Select language = {0}")
    public SiteHomePage selectLanguage(Language language){
        selectValueFromDropDownList(selectLanguage, language.getLanguage());
        setCurrentLocale(language.getLocale());
        return this;
    }

}
