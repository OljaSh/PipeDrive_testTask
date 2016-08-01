package com.pipedrive.pajeobject;

import com.pipedrive.core.BasePage;
import org.openqa.selenium.By;
import ru.yandex.qatools.allure.annotations.Step;


public class BillingAfterTrialPage  extends BasePage{

    public String getUserName(){
        return getText(labelUserName);
    }

    private By labelUserName = By.className("user-name");

    private By textTrialPeriodEnded = By.cssSelector(".large_message.attached_to_title>p");

    @Step("Get warning message that free trial period has ended")
    public String getWarningMessageThatTrialPeriodEnded() {
        return getText(textTrialPeriodEnded);
    }

}
