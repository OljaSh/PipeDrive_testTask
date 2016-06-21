package com.pipedrive.pajeobject;

import com.pipedrive.core.BasePage;
import org.openqa.selenium.By;


public class HomePage extends BasePage {

    public String getUserName(){
        return getText(labelUserName);
    }

    private By labelUserName = By.className("name"); //xpath("html/body/nav/div[1]/a/div/span[1]");  //className("name");
    private By selextUserDropDownList = By.className("icon-dropdown profilePictureTooltip");
    private By buttonLogOut = By.xpath("icon-dropdown profilePictureTooltip");


}
