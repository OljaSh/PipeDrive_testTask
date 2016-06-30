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
	public static Iterator<Object[]> dataProvider() {
		if (registeredUser == null) {
			registeredUser = new RegisteredUser("sh.olja@gmail.com", "nalT5g8S");
		}
		ArrayList<Object[]> output = new ArrayList<>();
		output.add(new Object[]{registeredUser});
		return output.iterator();
	}

	@DataProvider(name = "negativeDP")
	public static Iterator<Object[]> provideNegativeData() {
		//new SignUpForm();
		return Stream.of(new RegisteredUser("test@test.com", "nalT5g8S"),
				new RegisteredUser("sh.olja@gmail.com", "pass")
				/*new RegisteredUser("", "")*/)
				.map(user -> new Object[]{user})
				.collect(toList())
				.iterator();
	}

    @DataProvider(name = "incorrectEmailFormatDP")
    public static Iterator<Object[]> providerIncorrectEmailFormat() {
        return Stream.of(new RegisteredUser("sh.olja", "nalT5g8S"),
                new RegisteredUser("@gmail.com", "nalT5g8S"),
                new RegisteredUser("sh.olja@", "nalT5g8S"),
				new RegisteredUser(" ", " "))
                .map(user -> new Object[]{user})
                .collect(toList())
                .iterator();
    }

	@DataProvider(name = "emptyEmailAndPasswordFields")
	public static Iterator<Object[]> providerEmptyFields() {
		if (registeredUser == null) {
			registeredUser = new RegisteredUser(" ", " ");
		}
		ArrayList<Object[]> output = new ArrayList<>();
		output.add(new Object[]{registeredUser});
		return output.iterator();
	}
	// Positive test
	@Title("Login with created user successful case")
	@Description("Login with Login with created user successful case")
	@Test(dataProvider = "positiveDP")
	public void loginWithRegisteredUser(RegisteredUser registeredUser) {
		loadSiteUrl(URL.PROD)
				.selectLanguage("en")
				.clickLoginButton()
				.setRegisteredEmailAddress(registeredUser.getEmail())
				.setRegisteredPassword(registeredUser.getPassword())
				.clickButtonLoginPositive();

		Assert.assertEquals($(HomePage.class).getUserName(), "Olja");
		//$(HomePage.class).clickProfileDropDownMenu().clickLogOutButton();

	}


    @Title("Login with invalid user email or password")
    @Description("Login with invalid user email or password")
	@Test(priority=1, dataProvider = "negativeDP", enabled = false)
	public void loginWithInvalidCredentials(RegisteredUser registeredUser) {
		loadSiteUrl(URL.PROD)
				.selectLanguage("en")
				.clickLoginButton()
				.setRegisteredEmailAddress(registeredUser.getEmail())
				.setRegisteredPassword(registeredUser.getPassword())
				.clickButtonLoginNegative();

		Assert.assertEquals($(LoginPage.class).getWarningMessageIncorrectEmailOrPassword(), Error.INCORRECT_EMAIL_OR_PASSWORD.toString());

	}

    @Title("Login with invalid  email")
    @Description("Login with invalid  email")
    @Test(priority=2, dataProvider = "incorrectEmailFormatDP", enabled = false)
    public void loginWithIncorrectEmailFormat(RegisteredUser registeredUser) {
        loadSiteUrl(URL.PROD)
				.selectLanguage("en")
                .clickLoginButton()
                .setRegisteredEmailAddress(registeredUser.getEmail())
                .setRegisteredPassword(registeredUser.getPassword())
                .clickButtonLoginNegative();

        Assert.assertEquals($(LoginPage.class).getWarningMessageInvalidEmailAddress(), Error.INCORRECT_EMAIL_FORMAT.toString());
    }

	@Title("Login with empty email or password")
	@Description("Login with empty email or password")
	@Test(priority=3, dataProvider = "emptyEmailAndPasswordFields",  enabled = false)
	public void loginWithEmptyemailOrPassword(RegisteredUser registeredUser) {
		loadSiteUrl(URL.PROD)
				.selectLanguage("en")
				.clickLoginButton()
				//.setRegisteredEmailAddress(registeredUser.getEmail())
				//.setRegisteredPassword(registeredUser.getPassword())
				.clickButtonLoginNegative();

		Assert.assertEquals($(LoginPage.class).getWarningMessageAddEmail(), Error.EMPTY_EMAIL.toString());
		Assert.assertEquals($(LoginPage.class).getWarningMessageAddPassword(), Error.EMPTY_PASSWORD.toString());
	}

/*
	@Test
	public void checkLoginPageElementsVisibility() {
		loadSiteUrl(URL.PROD)
				.clickLoginButton();

		Assert.assertEquals($(LoginPage.class).checkElementsVisibility(), true);
	}

	@Test
	public void checkLocale() {
		Locale[] supportedLocates = {
				Locale.GERMAN,
				Locale.ENGLISH
		};

		for (Locale locale : supportedLocates) {
			displayValue(locale, "button.log.in");
		}
	}

	private void displayValue(Locale locale, String key) {
		ResourceBundle labels = ResourceBundle.getBundle("LabelsBundle", locale);
		String value = labels.getString(key);
		System.out.println("Locale = " + locale.toString() + ", " +
				"key = " + key + ", " +
				"value = " + value);
	}*/

	//Negative test, incorrect user name
	/*@Title("Login with created user incorrect user name")
	@Test(dataProvider = "testDP")
    public void LoginWithRegisteredUser(RegisteredUser registeredUser){
        loadSiteUrl(URL.PROD)
                .clickLoginButton()
                .setRegisteredEmailAddress(registeredUser.getEmail())
                .setRegisteredPassword(registeredUser.getPassword())
                .clickButtonLogin();
        Assert.assertEquals($(HomePage.class).getUserName(), "Incorrect email or password");
    }*/

	//Negative test, incorrect password
    /*@Title("Login with created user incorrect password")
    @Test(dataProvider = "testDP")
    public void LoginWithRegisteredUser(RegisteredUser registeredUser){
        loadSiteUrl(URL.PROD)
                .clickLoginButton()
                .setRegisteredEmailAddress(registeredUser.getEmail())
                .setRegisteredPassword(registeredUser.getPassword())
                .clickButtonLogin();
        Assert.assertEquals($(HomePage.class).getUserName(), "Incorrect email or password");
    }*/

}
