package com.pipedrive.pajeobject;

import com.pipedrive.core.BasePage;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;

import static com.pipedrive.preset.PageObjectSupplier.$;


public class HomePage extends BasePage {

    public String getUserName(){
        return getText(labelUserName);
    }

    private By labelUserName = By.className("name"); //xpath("html/body/nav/div[1]/a/div/span[1]");  //className("name");

    private By buttonLogOut = By.xpath(".//*[@id='login_form']/div[2]/div[1]");
    private By buttonProfileDropDownMenu = By.xpath("html/body/nav/div[1]/a");
    private By dropDownMenu = By.xpath("html/body/div[8]/ul");



    @Step("Select Profile DropDown Menu")
    public HomePage clickProfileDropDownMenu(){
        click(buttonProfileDropDownMenu);
        return this;
    }

    @Step("Log Out")
    public LogOutPage clickLogOutButton(){
        click(buttonLogOut);
        return $(LogOutPage.class);
    }

}
