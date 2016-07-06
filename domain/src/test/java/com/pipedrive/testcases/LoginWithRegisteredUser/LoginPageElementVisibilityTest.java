package com.pipedrive.testcases.LoginWithRegisteredUser;


import com.pipedrive.core.BaseTest;
import com.pipedrive.data.RegisteredUser;
import com.pipedrive.pajeobject.HomePage;
import com.pipedrive.pajeobject.LoginPage;
import com.pipedrive.preset.URL;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Locale;
import java.util.ResourceBundle;

import static com.pipedrive.preset.PageObjectSupplier.$;
import static com.pipedrive.preset.PageObjectSupplier.loadSiteUrl;

public class LoginPageElementVisibilityTest extends BaseTest {

	@Test
	public void checkLoginPageElementsVisibility() {
		loadSiteUrl(URL.PROD)
				.clickLoginButton();

		Assert.assertEquals($(LoginPage.class).checkElementsVisibility(), true);


	}

	@Test
	public void checkLabel() {
		loadSiteUrl(URL.PROD)
				.selectLanguage("en")
				.clickLoginButton();

		System.out.println($(LoginPage.class).getEmailLabel());
		System.out.println($(LoginPage.class).getExpectedEmailLabel());
		Assert.assertEquals($(LoginPage.class).getEmailLabel(), $(LoginPage.class).getExpectedEmailLabel());
	}

	@Test
	public void checkLocale() {
		Locale[] supportedLocates = {
				Locale.GERMAN,
				Locale.ENGLISH,
				Locale.forLanguageTag("et-EE")
		};

		for (Locale locale : supportedLocates) {
			displayValue(locale, "button.log.in");
		}

		displayValue(Locale.getDefault(), "button.log.in");
	}

	private void displayValue(Locale locale, String key) {
		ResourceBundle labels = ResourceBundle.getBundle("LabelsBundle", locale);
		String value = labels.getString(key);
		System.out.println("Locale = " + locale.toString() + ", " +
				"key = " + key + ", " +
				"value = " + value);
	}

   /* @Title("Check element visibility")
	@Description("Check element visibility")
    @Test
    public void checkLoginPageElementsVisibility() {
        loadSiteUrl(URL.PROD)
               // .selectLanguage("en")
                .clickLoginButton();

        Assert.assertEquals($(LoginPage.class).checkElementsVisibility(), true);
    }

    @Test
    public void checkLocale() {
        Locale[] supportedLocates = {
                //Locale.GERMAN,
                Locale.ENGLISH,
        };

        for (Locale locale : supportedLocates) {
            //displayValue(locale, "button.login");
            displayValue(locale, "label.log.in");
            displayValue(locale, "label.email");
            displayValue(locale, "label.password");
            displayValue(locale, "label.forgot");
            displayValue(locale, "label.remember.me");
            displayValue(locale, "button.log.in");

        }
    }

    private void displayValue(Locale locale, String key) {
        ResourceBundle labels = ResourceBundle.getBundle("LabelsBundle", locale);
        String value = labels.getString(key);
        System.out.println("Locale = " + locale.toString() + ", " +
                "key = " + key + ", " +
                "value = " + value);
    }
*/
}
