package com.pipedrive.pajeobject;

import com.pipedrive.core.BasePage;
import com.pipedrive.preset.LocaleLoader;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.stream.Stream;

import static com.pipedrive.preset.PageObjectSupplier.$;


public class LoginPage extends BasePage{

    private By labelEmail = By.cssSelector("label[for='login']");

    private By inputEmail = By.id("login");
    private By inputPassword = By.id("password");
    /*private By buttonLoginNegative = By.xpath("./*//*[@id='login_form']/div[5]/button");
    private By buttonLoginPositive = By.xpath("./*//*[@id='login_form']/div[5]/button");*/
    private By buttonLogin = By.xpath(".//*[@id='login_form']/div[5]/button");


    private By checkboxRememberMe = By.id("remember");
    private By buttonLoginWithGoogle = By.className("btn-google-plus btn-link");
    private By buttonForgot = By.className("btn-link");


    private By textWarningIncorrectEmailOrPassword = By.className("form_error");
    private By textWarningInvalidEmailAddress = By.xpath(".//*[@id='login_form']/div[2]/div[2]");
    private By textWarningAddEmail = By.xpath(".//*[@id='login_form']/div[2]/div[1]");
    private By textWarningAddPassword = By.xpath(".//*[@id='login_form']/div[3]/div");

    private By selectboxLanguage = By.id("auth-language-picker");

    ///----------
    private By textPageTitle = By.className("auth-title page-title secure");
    private By textEmail = By.xpath(".//*[@id='login_form']/div[2]/label");
    private By textPassword = By.xpath(".//*[@id='login_form']/div[3]/label");
    private By textRememberMe = By.xpath(".//*[@id='login_form']/div[4]/label");
    private By textButtonForgot = By.xpath(".//*[@id='login_form']/div[3]/small/a");
    private By textButtonLognIn = By.xpath(".//*[@id='login_form']/div[5]/button");


    private LocaleLoader labelsBundle;

    public LoginPage() {
        labelsBundle = new LocaleLoader("LabelsBundle");
    }

    public String getEmailLabel() {
        return getText(labelEmail);
    }

    public String getExpectedEmailLabel() {
        return labelsBundle.getValue("label.username");
    }

    @Step("Set email = {0}")
    public LoginPage setRegisteredEmailAddress(String emailAddress){
        setText(inputEmail, emailAddress);
        //labelsBundle.getValue("label.error.message");
        return this;
    }

    @Step("Enter password")
    public LoginPage setRegisteredPassword(String password){
        setText(inputPassword, password);
        return this;
    }

    /*@Step("Click on Login button")
    public LoginPage clickButtonLoginNegative(){
        click(buttonLoginNegative);
        return this;
    }*/

    @Step("Click on Login button")
    public HomePage clickButtonLogin(){
        click(buttonLogin);
        return $(HomePage.class);
    }


    @Step("Get warning message that password or email is incorrect= {0}")
    public String  getWarningMessageIncorrectEmailOrPassword(){

        return getText(textWarningIncorrectEmailOrPassword);
    }

    @Step("Get warning message that password format is incorrect= {0}")
    public String  getWarningMessageInvalidEmailAddress(){
        return getText(textWarningInvalidEmailAddress);
    }

    @Step("Get warning Add email")
    public String getWarningMessageAddEmail(){
        return getText(textWarningAddEmail);
    }

    @Step("Get warning Add password")
    public  String getWarningMessageAddPassword(){
        return getText(textWarningAddPassword);
    }


    public boolean checkElementsVisibility() {
        return Stream.of(textPageTitle, textEmail, textPassword, textRememberMe, textButtonForgot, textButtonLognIn)
                .allMatch(this::isDisplayed);
    }
}
