package com.pipedrive.testcases.RegisterNewUser;

import com.pipedrive.core.BaseTest;
import com.pipedrive.data.DataProviders;
import com.pipedrive.data.NewUser;
import com.pipedrive.pajeobject.HomePage;
import com.pipedrive.preset.Language;
import com.pipedrive.preset.URL;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

import static com.pipedrive.preset.PageObjectSupplier.$;
import static com.pipedrive.preset.PageObjectSupplier.loadSiteUrl;


public class RegisterNewUserPositiveTest extends BaseTest{




    @Features("Register new user")
    @Stories("Positive user registration")
    @Title("New user sign up successful case")
    @Test(dataProviderClass = DataProviders.class, dataProvider = "positiveRegistrationDP", enabled = false)
    public void registerNewUserPositiveTest(NewUser newUser){
        loadSiteUrl(URL.PROD)
                .selectLanguage(Language.ENGLISH)
                .clickSignUpButton()
                .setYourName(newUser.getUserName())
                .setCompanyName(newUser.getCompanyName())
                .setEmail(newUser.getUserEmail())
                .setPassword(newUser.getUserPassword())
                .selectTeamSize(newUser.getTeamSize())
                .selectCompanyIndustry(newUser.getCompanyIndustry())
                .clickRegisterButton();


        //getSoftAssert().assertEquals($(HomePage.class).getUserName(), $(HomePage.class).getUserName());
        getSoftAssert().assertTrue($(HomePage.class).isElementPresent(), String.valueOf($(HomePage.class).isElementPresent()));


    }

/*	@Features("Register new user")
	@Stories("Positive user registration")
	@Title("New user sign up successful case")
	@Test(dataProvider = "negativeRegistrationDP", dataProviderClass = DataProviders.class)
	public void registerNewUserNegativeTest(NewUser newUser){
		loadSiteUrl(URL.PROD)
				.clickSignUpButton()
				.setYourName(newUser.getUserName())
				.setCompanyName(newUser.getCompanyName())
				.setEmail(newUser.getUserEmail())
				.setPassword(newUser.getUserPassword())
				.selectTeamSize(newUser.getTeamSize())
				.selectCompanyIndustry(newUser.getCompanyIndustry())
				.clickRegisterButton();

		verifyTextEquals($(SignUpPage.class).getUsernameErrorText(), Error.EMPTY_EMAIL.toString(),
				"Username error");
		getSoftAssert().assertEquals($(SignUpPage.class).getUsernameErrorText(), Error.EMPTY_EMAIL.toString());
		getSoftAssert().assertEquals($(SignUpPage.class).getUsernameErrorText(), Error.EMPTY_EMAIL.toString());
		getSoftAssert().assertEquals($(SignUpPage.class).getUsernameErrorText(), Error.EMPTY_EMAIL.toString());
		getSoftAssert().assertEquals($(SignUpPage.class).getUsernameErrorText(), Error.EMPTY_EMAIL.toString());
		getSoftAssert().assertEquals($(SignUpPage.class).getUsernameErrorText(), Error.EMPTY_EMAIL.toString());
	}*/
}
