package com.pipedrive.testcases.LoginWithRegisteredUser;

import com.pipedrive.core.BaseTest;
import com.pipedrive.data.DataProviders;
import com.pipedrive.data.RegisteredUser;
import com.pipedrive.pajeobject.HomePage;
import com.pipedrive.preset.URL;
import com.pipedrive.preset.Users;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

import static com.pipedrive.preset.PageObjectSupplier.$;
import static com.pipedrive.preset.PageObjectSupplier.loadSiteUrl;

public class LoginWithRegisteredUserTest extends BaseTest {



	@Features("Login With Register user")
	@Stories("Positive Login")
	@Title("Login with created user successful case")
	@Test(dataProviderClass = DataProviders.class, dataProvider = "positiveLoginDP")
	public void loginWithRegisteredUser(RegisteredUser registeredUser) {
		loadSiteUrl(URL.PROD)
				//.selectLanguage(Language.RUSSIAN)
				.clickLoginButton()
				.setRegisteredEmailAddress(registeredUser.getEmail())
				.setRegisteredPassword(registeredUser.getPassword())
				.clickButtonLogin();

		getSoftAssert().assertEquals($(HomePage.class).getUserName(), Users.DEMOUSER.toString());
		//Change hardcoded User name
		$(HomePage.class).clickProfileDropDownMenu().clickLogOutButton();


	}
}
