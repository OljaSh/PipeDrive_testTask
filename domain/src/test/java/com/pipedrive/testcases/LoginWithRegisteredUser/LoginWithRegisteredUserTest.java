package com.pipedrive.testcases.LoginWithRegisteredUser;

import com.pipedrive.core.BaseTest;
import com.pipedrive.data.RegisteredUser;
import com.pipedrive.pajeobject.HomePage;
import com.pipedrive.pajeobject.LoginPage;
import com.pipedrive.preset.Error;
import com.pipedrive.preset.URL;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Stream;

import static com.pipedrive.preset.PageObjectSupplier.$;
import static com.pipedrive.preset.PageObjectSupplier.loadSiteUrl;
import static java.util.stream.Collectors.toList;

@Title("Login with created user Functional tests ")
@Description("Login with created user test")
public class LoginWithRegisteredUserTest extends BaseTest {

	private static RegisteredUser registeredUser;

    @DataProvider(name = "positiveDP")
	public static Iterator<Object[]> positiveDP() {
		if (registeredUser == null) {
			registeredUser = new RegisteredUser("sh.olja@gmail.com", "nalT5g8S");
		}
		ArrayList<Object[]> output = new ArrayList<>();
		output.add(new Object[]{registeredUser});
		return output.iterator();
	}


	@DataProvider(name = "negativeDP")
	public static Iterator<Object[]> negariveDP() {
		//new SignUpForm();
		return Stream.of(new RegisteredUser("test@test.com", "nalT5g8S"),
				new RegisteredUser("sh.olja@gmail.com", "pass"),
				new RegisteredUser("sh.olja", "nalT5g8S"),
				new RegisteredUser("@gmail.com", "nalT5g8S"),
				new RegisteredUser("sh.olja@", "nalT5g8S"),
				new RegisteredUser(" ", " "))
				.map(user -> new Object[]{user})
				.collect(toList())
				.iterator();
	}

	/*
	* 1. Should be a single generic locator
	* 2. Email address validness should be checked by browser natively
	* 3. Error messages should be localized
	* 4. It's insecure to display specific error messages linked with particular fields
	* */

    @DataProvider(name = "incorrectEmailFormatDP")
    public static Iterator<Object[]> providerIncorrectEmailFormatDP() {
        return Stream.of(new RegisteredUser("sh.olja", "nalT5g8S"),
                new RegisteredUser("@gmail.com", "nalT5g8S"),
                new RegisteredUser("sh.olja@", "nalT5g8S"),
				new RegisteredUser(" ", " "),
				new RegisteredUser("", ""))
                .map(user -> new Object[]{user})
                .collect(toList())
                .iterator();
    }


///////////////////////// TESTS //////////////////////////

// Positive test

	@Title("Login with created user successful case")
	@Description("Login with Login with created user successful case")
	@Test(dataProvider = "positiveDP", priority = 4)
	public void loginWithRegisteredUser(RegisteredUser registeredUser) {
		loadSiteUrl(URL.PROD)
				//.selectLanguage("en")
				.clickLoginButton()
				.setRegisteredEmailAddress(registeredUser.getEmail())
				.setRegisteredPassword(registeredUser.getPassword())
				.clickButtonLogin();

		Assert.assertEquals($(HomePage.class).getUserName(), "Olja");
		$(HomePage.class).clickProfileDropDownMenu().clickLogOutButton();


	}

// Negative tests

    @Title("Login with invalid user email or password")
    @Description("Login with invalid user email or password")
	@Test(priority=1, dataProvider = "negativeDP")
	public void loginWithInvalidCredentials(RegisteredUser registeredUser) {
		loadSiteUrl(URL.PROD)
				.selectLanguage("en")
				.clickLoginButton()
				.setRegisteredEmailAddress(registeredUser.getEmail())
				.setRegisteredPassword(registeredUser.getPassword())
				.clickButtonLogin();

		Assert.assertEquals($(LoginPage.class).getWarningMessageIncorrectEmailOrPassword(), Error.INCORRECT_EMAIL_OR_PASSWORD.toString());
	}

    @Title("Login with invalid  email")
    @Description("Login with invalid  email")
    @Test(priority=2, dataProvider = "incorrectEmailFormatDP", enabled = true)
    public void loginWithIncorrectEmailFormat(RegisteredUser registeredUser) {
        loadSiteUrl(URL.PROD)
				.selectLanguage("en")
                .clickLoginButton()
                .setRegisteredEmailAddress(registeredUser.getEmail())
                .setRegisteredPassword(registeredUser.getPassword())
                .clickButtonLogin();

        Assert.assertEquals($(LoginPage.class).getWarningMessageInvalidEmailAddress(), Error.INCORRECT_EMAIL_FORMAT.toString());
    }

	@Title("Login with empty email or password")
	@Description("Login with empty email or password")
	@Test(priority=3, enabled = true)
	public void loginWithEmptyemailOrPassword() {
		loadSiteUrl(URL.PROD)
				.selectLanguage("en")
				.clickLoginButton()
				//.setRegisteredEmailAddress(registeredUser.getEmail())
				//.setRegisteredPassword(registeredUser.getPassword())
				.clickButtonLogin();

		Assert.assertEquals($(LoginPage.class).getWarningMessageAddEmail(), Error.EMPTY_EMAIL.toString());
		Assert.assertEquals($(LoginPage.class).getWarningMessageAddPassword(), Error.EMPTY_PASSWORD.toString());
	}

}
