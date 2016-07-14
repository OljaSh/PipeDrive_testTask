package com.pipedrive.pajeobject;

import com.pipedrive.preset.Language;
import ru.yandex.qatools.allure.annotations.Step;
import com.pipedrive.core.BasePage;
import org.openqa.selenium.By;

import static com.pipedrive.preset.PageObjectSupplier.$;


public class SiteHomePage extends BasePage {

    private By buttonLogin = By.className("header__navigation__login");

    //private By buttonSignUp = By.className("header__navigation__signup");
    private By buttonSignUp = By.cssSelector(".btn__label");

    private By selectLanguage = By.xpath(".//*[@id='body']/div/div/div[2]/footer/div[1]/div[3]/div/select");  //className("language-picker__select-box");

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
