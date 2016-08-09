package com.pipedrive.pajeobject;

import com.pipedrive.core.BasePage;
import com.pipedrive.preset.LocaleLoader;
import lombok.Getter;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

@Getter
public class SignUpPage extends BasePage {


    private By inputYourName = By.id("name");
    private By inputCompanyName = By.id("company_name");
    private By inputYourEmail = By.id("email");
    private By inputPassword = By.id("password");
    private By selectTeamSize = By.xpath(".//*[@id='register_form']/div[5]/div/select");
    private By selectCompanyIndustry = By.cssSelector(".selectWrapper.industry.icon-chevron-down>select");
    private By inputPromoCode = By.className("promo-code-link");
    private By buttonSignUpFree = By.cssSelector("#register_button");
    private By checkboxSalesTipsAndNews = By.id("optin_news");

    private By textWarningAddYourName = By.cssSelector("#name+div");
    private By textWarningAddCompanyName = By.cssSelector("#company_name+div");
    private By textWarningAddEmail = By.xpath(".//*[@id='register_form']/div[3]/div[1]");
    private By textWarningAddPassword = By.xpath(".//*[@id='register_form']/div[4]/div[2]");
    private By textWarningAddCompanyIndustry = By.xpath(".//*[@id='register_form']/div[6]/div[2]");

	private By labelUsernameError = By.cssSelector("");

    //----------------------------------------------------------

    private LocaleLoader labelsBundle;

    public SignUpPage() {
        labelsBundle = new LocaleLoader("LabelsBundle", getCurrentLocale());
    }

    //----------------------------------------------------------

    @Step("Get warning message that User name required")
    public String getWarningMessageAddYourName() {
        return getText(textWarningAddYourName);
    }


    @Step("Get warning message that Company name  required")
    public String getWarningMessageAddCompanyName() {
        return getText(textWarningAddCompanyName);
    }

    @Step("Get warning message that Email required")
    public String getWarningMessageAddEmail() {
        return getText(textWarningAddEmail);
    }

    @Step("Get warning message that Password required")
    public String getWarningMessageAddPassword() {
        return getText(textWarningAddPassword);
    }

    @Step("Get warning message that Company Industry required")
    public String getWarningMessageAddCompanyIndustry() {
        return getText(textWarningAddCompanyIndustry);
    }

    //----------------------------------------------------------

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


    public String getUsernameErrorText() {
    	return getText(labelUsernameError);
    }

}
