package com.pipedrive.testcases.LoginWithRegisteredUser;

import com.pipedrive.core.BaseTest;
import com.pipedrive.data.RegisteredUser;
import com.pipedrive.pajeobject.HomePage;
import com.pipedrive.preset.URL;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Title;

import java.util.ArrayList;
import java.util.Iterator;

import static com.pipedrive.preset.PageObjectSupplier.$;
import static com.pipedrive.preset.PageObjectSupplier.loadSiteUrl;

@Title("Login with created user Functional tests ")
public class LoginWithRegisteredUserTest extends BaseTest{

    private static RegisteredUser registeredUser;

    @DataProvider(name = "testDP")
    public static Iterator<Object[]> dataProvider() {
        if (registeredUser == null) {
            registeredUser = new RegisteredUser("sh.olja@gmail.com", "nalT5g8S");
        }

        ArrayList<Object[]> output = new ArrayList<>();
        output.add(new Object[]{registeredUser});
        return output.iterator();
    }




    // Positive test
    @Title("Login with created user successful case")
    @Test(dataProvider = "testDP")
    public void LoginWithRegisteredUser(RegisteredUser registeredUser){
        loadSiteUrl(URL.PROD)
                .clickLoginButton()
                .setRegisteredEmailAddress(registeredUser.getEmail())
                .setRegisteredPassword(registeredUser.getPassword())
                .clickButtonLogin();
        Assert.assertEquals($(HomePage.class).getUserName(), "Olja");
    }

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
