package com.pipedrive.pajeobject;

import com.pipedrive.core.BasePage;
import com.pipedrive.preset.LocaleLoader;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.pipedrive.preset.PageObjectSupplier.$;


public class LoginPage extends BasePage{

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
    private By labeltPageTitle = By.xpath(".//*[@id='login_form']/div[1]/h1");
    //private By labelEmail = By.xpath(".//*[@id='login_form']/div[2]/label");
    private By labelPassword = By.xpath(".//*[@id='login_form']/div[3]/label");
    private By labelRememberMe = By.xpath(".//*[@id='login_form']/div[4]/label");
    private By labelButtonForgot = By.xpath(".//*[@id='login_form']/div[3]/small/a");
    private By labelButtonLognIn = By.xpath(".//*[@id='login_form']/div[5]/button");

    private By labelEmail = By.cssSelector("label[for='login']");



    //---------------------------------------------
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


    /*public boolean checkElementsVisibility() {
        return Stream.of(textPageTitle, textEmail, textPassword, textRememberMe, textButtonForgot, textButtonLognIn)
                .allMatch(this::isDisplayed);
    }*/

    //-------------------


    private LocaleLoader labelsBundle;

    public LoginPage() {
        labelsBundle = new LocaleLoader("LabelsBundle");
    }

    //--------------------
    public String getPageTitleValue(){
        return getText(labeltPageTitle);

    }

    @Step("Get Page Label")
    public String getExpectedPageTitleLabel(){
        return labelsBundle.getValue("label.page.title");
    }

    public String getEmailValue() {
        return getText(labelEmail);

    }

    @Step("Get User name Label")
    public String getExpectedEmailLabel() {
        return labelsBundle.getValue("label.username");
    }


    public String getPasswordValue(){
        return getText(labelPassword);
    }

    @Step("Get password Label")
    public String getExpectedPasswordLabel(){
        return labelsBundle.getValue("label.password");
    }

    public String getForgotValue(){
        return getText(labelButtonForgot);
    }

    @Step("Get Forgot? button label")
    public String getExpectedForgotLabel(){
        return labelsBundle.getValue("label.forgot");
    }

    public String getRememberMeValue(){
        return getText(labelRememberMe);
    }

    @Step("Get Remember me Labael")
    public String getExpectedRememberMeLabel(){
        return  labelsBundle.getValue("label.remember.me");
    }

    public String getLogInButtonValue(){
        return  getText(labelButtonLognIn);
    }

    @Step("Get Log in button Label")
    public String getExpectedButtonLogInLabel(){
        return  labelsBundle.getValue("label.button.log.in");
    }



}
