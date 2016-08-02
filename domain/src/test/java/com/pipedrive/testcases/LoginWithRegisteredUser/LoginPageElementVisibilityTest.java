package com.pipedrive.testcases.LoginWithRegisteredUser;


import com.pipedrive.core.BaseTest;
import com.pipedrive.pajeobject.LoginPage;
import com.pipedrive.preset.Language;
import com.pipedrive.preset.URL;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

import static com.pipedrive.preset.PageObjectSupplier.$;
import static com.pipedrive.preset.PageObjectSupplier.loadSiteUrl;

public class LoginPageElementVisibilityTest extends BaseTest {

	@Features("Login page Elements visibility")
	@Stories("UI test")
	@Title("check Labels OnLogin Page test")
	@Test
	public void checkLabelsOnLoginPage() {
		loadSiteUrl(URL.PROD)
				.selectLanguage(Language.ENGLISH)
				.clickLoginButton();

		Assert.assertEquals($(LoginPage.class).getPageTitleValue(), $(LoginPage.class).getExpectedPageTitleLabel());
		Assert.assertEquals($(LoginPage.class).getEmailValue(), $(LoginPage.class).getExpectedEmailLabel());
		Assert.assertEquals($(LoginPage.class).getPasswordValue(), $(LoginPage.class).getExpectedPasswordLabel());
		Assert.assertEquals($(LoginPage.class).getForgotValue(), $(LoginPage.class).getExpectedForgotLabel());
		Assert.assertEquals($(LoginPage.class).getRememberMeValue(), $(LoginPage.class).getExpectedRememberMeLabel());
		Assert.assertEquals($(LoginPage.class).getLogInButtonValue(), $(LoginPage.class).getExpectedButtonLogInLabel());
	}

	/*@Test
	public void checkLocale() {
		Locale[] supportedLocates = {
				Locale.forLanguageTag("ru"),
				Locale.ENGLISH,
				Locale.forLanguageTag("et-EE")
		};

		for (Locale locale : supportedLocates) {
			displayValue(locale, "label.password");
		}
	}

	private void displayValue(Locale locale, String key) {
		ResourceBundle labels = ResourceBundle.getBundle("LabelsBundle", locale);
		String value = labels.getString(key);
		System.out.println("Locale = " + locale.toString() + ", " +
				"key = " + key + ", " +
				"value = " + value);
	}*/
}
