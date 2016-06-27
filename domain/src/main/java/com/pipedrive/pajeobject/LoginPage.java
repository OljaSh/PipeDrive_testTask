package com.pipedrive.pajeobject;

import com.pipedrive.core.BasePage;
import com.pipedrive.preset.LocaleLoader;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.stream.Stream;

import static com.pipedrive.preset.PageObjectSupplier.$;

/**
 * Created by oljashabanova on 18/06/16.
 */
public class LoginPage extends BasePage{

    private By inputEmail = By.id("login");
    private By inputPassword = By.id("password");
    private By buttonLogin = By.xpath(".//*[@id='login_form']/div[5]/button");  //className("submit-button id--login");
    private By checkboxRememberMe = By.id("remember");
    private By buttonLoginWithGoogle = By.className("btn-google-plus btn-link");
    private By buttonForgot = By.className("btn-link");

    private By errorFormIncorrectEmailPassword = By.className("form_error");

    private By selectboxLanguage = By.id("auth-language-picker");

    private LocaleLoader labelsBundle;

    public LoginPage() {
        labelsBundle = new LocaleLoader("LabelsBundle");
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

    @Step("Clict on Login button")
    public HomePage clickButtonLogin(){
        click(buttonLogin);
        return $(HomePage.class);
    }

    @Step("Get error message")
    public  String gerErrorMessage() {
      return getText(errorFormIncorrectEmailPassword);
    }

    public boolean checkElementsVisibility() {
        return Stream.of(inputEmail, inputPassword, buttonLogin)
                .allMatch(this::isDisplayed);
    }
}
