package com.pipedrive.testcases.RegisterNewUser;

import com.pipedrive.core.BaseTest;
import com.pipedrive.data.NewUser;
import com.pipedrive.pajeobject.HomePage;
import com.pipedrive.preset.URL;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.Title;

import java.util.ArrayList;
import java.util.Iterator;

import static com.pipedrive.preset.PageObjectSupplier.$;
import static com.pipedrive.preset.PageObjectSupplier.loadSiteUrl;


public class RegisterNewUserPositiveTest extends BaseTest{

    private static NewUser newUser;

    @DataProvider(name = "testDP")
    public static Iterator<Object[]> dataProvider() {
        if (newUser == null) {
            newUser = new NewUser("userName", "companyName", "email", "password", "6-15 members", "IT  Services");
        }

        ArrayList<Object[]> output = new ArrayList<>();
        output.add(new Object[]{newUser});
        return output.iterator();
    }

    @Features("Register new user")
    @Stories("Positive user registration")
    @Title("New user sign up successful case")
    @Test(dataProvider = "testDP")
    public void registerNewUserPositiveTest(NewUser newUser){
        loadSiteUrl(URL.PROD)
                .clickSignUpButton()
                .setYourName(newUser.getUserName())
                .setCompanyName(newUser.getCompanyName())
                .setEmail(newUser.getUserEmail())
                .setPassword(newUser.getUserPassword())
                .selectTeamSize(newUser.getTeamSize())
                .selectCompanyIndustry(newUser.getCompanyIndustry())
                .clickRegisterButton();

        Assert.assertEquals($(HomePage.class).getUserName(), $(HomePage.class).getUserName());
    }
}
