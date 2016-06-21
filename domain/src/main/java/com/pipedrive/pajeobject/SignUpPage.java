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


    @Step("Set  Name = {0}")
    public SignUpPage setYourName(final String yourName){
        setText(inputYourName, yourName);
        return this;
    }

    @Step("Set company Name = {0}")
    public SignUpPage setCompanyName(final String companyName){
        setText(inputCompanyName, companyName);
        return this;
    }

    @Step("Set email = {0}")
    public SignUpPage setEmail(final String email){
        setText(inputYourEmail, email);
        return this;
    }

    @Step("Set company Name = {0}")
    public SignUpPage setPassword(final String password){
        setText(inputPassword, password);
        return this;
    }


    @Step("Select team size = {0}")
    public SignUpPage selectTeamSize(final String teamSize){
        selectFromDropDownList(selectTeamSize, String.valueOf(teamSize));
        return this;
    }

    @Step("Select company industry = {0}")
    public SignUpPage selectCompanyIndustry(final String companyIndustry){
        selectFromDropDownList(selectCompanyIndustry, String.valueOf(companyIndustry));
        return this;
    }

    @Step("Click  Sign up Free button")
    public HomePage clickRegisterButton() {
        click(buttonSignUpFree);
        return new HomePage();
    }



}
