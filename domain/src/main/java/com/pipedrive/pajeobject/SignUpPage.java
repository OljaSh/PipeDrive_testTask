package com.pipedrive.pajeobject;

import com.pipedrive.core.BasePage;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

public class SignUpPage extends BasePage {


    private By inputYourName = By.id("name");
    private By inputCompanyName = By.id("company_name");
    private By inputYourEmail = By.id("email");
    private By inputPassword = By.id("password");
    private By selectTeamSize = By.className("auth-activity-icon");
    private By selectCompanyIndustry = By.name("company_industry");
    private By inputPromoCode = By.className("promo-code-link");
    private By buttonSignUpFree = By.id("register_button");
    private By checkboxSalesTipsAndNews = By.id("optin_news");


    @Step("Set Your Name = {0}")
    public SignUpPage setYourName(final String yourName){
        setText(inputYourName, yourName);
        return this;
    }
}
