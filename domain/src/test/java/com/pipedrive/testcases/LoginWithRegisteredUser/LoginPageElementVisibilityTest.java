package com.pipedrive.testcases.LoginWithRegisteredUser;


import com.pipedrive.core.BaseTest;
import com.pipedrive.pajeobject.LoginPage;
import com.pipedrive.preset.Language;
import com.pipedrive.preset.URL;
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


		getSoftAssert().assertEquals($(LoginPage.class).getPageTitleValue(), $(LoginPage.class).getExpectedPageTitleLabel());
		getSoftAssert().assertEquals($(LoginPage.class).getEmailValue(), $(LoginPage.class).getExpectedEmailLabel());
		getSoftAssert().assertEquals($(LoginPage.class).getPasswordValue(), $(LoginPage.class).getExpectedPasswordLabel());
		getSoftAssert().assertEquals($(LoginPage.class).getForgotValue(), $(LoginPage.class).getExpectedForgotLabel());
		getSoftAssert().assertEquals($(LoginPage.class).getRememberMeValue(), $(LoginPage.class).getExpectedRememberMeLabel());
		getSoftAssert().assertEquals($(LoginPage.class).getLogInButtonValue(), $(LoginPage.class).getExpectedButtonLogInLabel());
	}

}
