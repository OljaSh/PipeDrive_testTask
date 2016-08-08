package com.pipedrive.testcases.LoginWithRegisteredUser;

import com.pipedrive.core.BaseTest;
import com.pipedrive.data.DataProviders;
import com.pipedrive.data.RegisteredUser;
import com.pipedrive.pajeobject.BillingAfterTrialPage;
import com.pipedrive.pajeobject.LoginPage;
import com.pipedrive.preset.Error;
import com.pipedrive.preset.Language;
import com.pipedrive.preset.URL;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

import static com.pipedrive.preset.PageObjectSupplier.$;
import static com.pipedrive.preset.PageObjectSupplier.loadSiteUrl;

//@Title("Login with created user Functional tests ")
//@Description("Login with created user test")
public class LoginWithRegisteredUserAllErrorsTest extends BaseTest {

    @Features("Login With Register User all Errors")
    @Stories("Login")
    @Title("Negative tests")
    @Description("Negative test with incorrect user name/password/incorrect format/spase/empty fields value")
    @Test(dataProviderClass = DataProviders.class, dataProvider = "incorrectEmailorPassword", enabled = false)
    public void loginWithInvalidCredentials(RegisteredUser registeredUser) {
        loadSiteUrl(URL.PROD)
                .selectLanguage(Language.ENGLISH)
                .clickLoginButton()
                .setRegisteredEmailAddress(registeredUser.getEmail())
                .setRegisteredPassword(registeredUser.getPassword())
                .clickButtonLogin();

        Assert.assertEquals($(LoginPage.class).getWarningMessageIncorrectEmailOrPassword(), Error.INCORRECT_EMAIL_OR_PASSWORD.toString());
    }

    @Features("Login With Register User all Errors")
    @Stories("Login")
    @Title("Login with invalid  email")
    @Test(dataProviderClass = DataProviders.class, dataProvider = "incorrectEmailFormatDP", enabled = false)
    public void loginWithIncorrectEmailFormat(RegisteredUser registeredUser) {
        loadSiteUrl(URL.PROD)
				.selectLanguage(Language.ENGLISH)
                .clickLoginButton()
                .setRegisteredEmailAddress(registeredUser.getEmail())
                .setRegisteredPassword(registeredUser.getPassword())
                .clickButtonLogin();

        Assert.assertEquals($(LoginPage.class).getWarningMessageInvalidEmailAddress(), Error.INCORRECT_EMAIL_FORMAT.toString());
    }

    @Features("Login With Register User all Errors")
    @Stories("Login")
	@Title("Login with empty email or password")
	@Test (enabled = false)
	public void loginWithEmptyEmailOrPassword() {
		loadSiteUrl(URL.PROD)
				.selectLanguage(Language.ENGLISH)
				.clickLoginButton()
				//.setRegisteredEmailAddress(registeredUser.getEmail())
				//.setRegisteredPassword(registeredUser.getPassword())
				.clickButtonLogin();

		Assert.assertEquals($(LoginPage.class).getWarningMessageAddEmail(), Error.EMPTY_EMAIL.toString());
		Assert.assertEquals($(LoginPage.class).getWarningMessageAddPassword(), Error.EMPTY_PASSWORD.toString());
	}

    @Features("Login With Register User all Errors")
    @Stories("Login")
    @Title("Login with expired user")
    @Test(dataProviderClass = DataProviders.class, dataProvider = "expiredUserDP")
    public void loginWithExpiredUser(RegisteredUser registeredUser){
        loadSiteUrl(URL.PROD)
                .selectLanguage(Language.ENGLISH)
                .clickLoginButton()
                .setRegisteredEmailAddress(registeredUser.getEmail())
                .setRegisteredPassword(registeredUser.getPassword())
                .clickButtonLogin();

        Assert.assertEquals($(BillingAfterTrialPage.class).getWarningMessageThatTrialPeriodEnded(), Error.EXPIRED_USER.toString());
    }

}
