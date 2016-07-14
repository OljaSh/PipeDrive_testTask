package com.pipedrive.testcases.LoginWithRegisteredUser;

import com.pipedrive.core.BaseTest;
import com.pipedrive.data.DataProviders;
import com.pipedrive.data.RegisteredUser;
import com.pipedrive.pajeobject.HomePage;
import com.pipedrive.pajeobject.LoginPage;
import com.pipedrive.preset.Error;
import com.pipedrive.preset.Language;
import com.pipedrive.preset.URL;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Title;

import java.util.Iterator;
import java.util.stream.Stream;

import static com.pipedrive.preset.PageObjectSupplier.$;
import static com.pipedrive.preset.PageObjectSupplier.loadSiteUrl;
import static java.util.stream.Collectors.toList;

@Title("Login with created user Functional tests ")
@Description("Login with created user test")
public class LoginWithRegisteredUserTest extends BaseTest {


    @DataProvider(name = "negativeDP")
    public static Iterator<Object[]> negariveDP() {
        return Stream.of(new RegisteredUser("sh.olja", "nalT5g8S"),
                new RegisteredUser("@gmail.com", "nalT5g8S"),
                new RegisteredUser("sh.olja@", "nalT5g8S"),
				new RegisteredUser("sh.olja@gmail.com", "pass"),
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
	@Test(dataProviderClass = DataProviders.class, dataProvider = "positiveDP")
	public void loginWithRegisteredUser(RegisteredUser registeredUser) {
		loadSiteUrl(URL.PROD)
				.selectLanguage(Language.ENGLISH)
				.clickLoginButton()
				.setRegisteredEmailAddress(registeredUser.getEmail())
				.setRegisteredPassword(registeredUser.getPassword())
				.clickButtonLogin();

		Assert.assertEquals($(HomePage.class).getUserName(), "Olja");
		$(HomePage.class).clickProfileDropDownMenu().clickLogOutButton();


	}

// Negative tests

    @Title("Negative tests")
    @Description("Negative test with incorrect user name/password/incorrect format/spase/empty fields value")
	@Test(dataProviderClass = DataProviders.class, dataProvider = "negativeDP")
	public void loginWithInvalidCredentials(RegisteredUser registeredUser) {
		loadSiteUrl(URL.PROD)
				.selectLanguage(Language.ENGLISH)
				.clickLoginButton()
				.setRegisteredEmailAddress(registeredUser.getEmail())
				.setRegisteredPassword(registeredUser.getPassword())
				.clickButtonLogin();

		Assert.assertEquals($(LoginPage.class).getWarningMessageIncorrectEmailOrPassword(), Error.INCORRECT_EMAIL_OR_PASSWORD.toString());
	}

}
