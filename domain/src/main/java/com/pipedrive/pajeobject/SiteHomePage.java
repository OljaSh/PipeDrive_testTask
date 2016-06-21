package com.pipedrive.pajeobject;

import ru.yandex.qatools.allure.annotations.Step;
import com.pipedrive.core.BasePage;
import org.openqa.selenium.By;

import static com.pipedrive.preset.PageObjectSupplier.$;


public class SiteHomePage extends BasePage {

    private By buttonLogin = By.className("header__navigation__login");

    private By buttonSignUp = By.className("header__navigation__signup");



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

}
