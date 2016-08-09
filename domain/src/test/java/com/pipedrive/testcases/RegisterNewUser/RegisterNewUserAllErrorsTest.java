package com.pipedrive.testcases.RegisterNewUser;

import com.pipedrive.core.BaseTest;
import com.pipedrive.data.DataProviders;
import com.pipedrive.data.NewUserPredefined;
import com.pipedrive.pajeobject.LoginPage;
import com.pipedrive.preset.Error;
import com.pipedrive.preset.Language;
import com.pipedrive.preset.URL;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

import static com.pipedrive.preset.PageObjectSupplier.$;
import static com.pipedrive.preset.PageObjectSupplier.loadSiteUrl;

public class RegisterNewUserAllErrorsTest extends BaseTest {

    /*What to test
      1. Registration with already existed user
      2. Fields length long/short
      3. Empty fields
      4. Fields format
      5. Mandatory fields

      */


    @Features("Register new user")
    @Stories("Negative user registration")
    @Title("New user sign up negative cases")
    @Test(dataProviderClass = DataProviders.class, dataProvider = "registrationAllFieldsEmptyDP")
    public void signUpWithEmptyFields(NewUserPredefined newUserPredefined) {
        loadSiteUrl(URL.PROD)
                .selectLanguage(Language.ENGLISH)
                .clickSignUpButton()
                .setYourName(newUserPredefined.getUserName())
                .setCompanyName(newUserPredefined.getCompanyName())
                .setEmail(newUserPredefined.getUserEmail())
                .setPassword(newUserPredefined.getUserPassword())
                .selectTeamSize(newUserPredefined.getTeamSize())
                .selectCompanyIndustry(newUserPredefined.getCompanyIndustry())
                .clickRegisterButton();


        Assert.assertEquals($(LoginPage.class).getWarningMessageAddEmail(), Error.EMPTY_USER_NAME.toString());
        Assert.assertEquals($(LoginPage.class).getWarningMessageAddEmail(), Error.EMPTY_COMPANY_NAME.toString());
        Assert.assertEquals($(LoginPage.class).getWarningMessageAddEmail(), Error.EMPTY_EMAIL.toString());
        Assert.assertEquals($(LoginPage.class).getWarningMessageAddEmail(), Error.EMPTY_PASSWORD.toString());
        Assert.assertEquals($(LoginPage.class).getWarningMessageAddEmail(), Error.EMPTY_COMPANY_INDUSTRY.toString());

    }
}
