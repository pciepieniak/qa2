package com.jsystems.qa2.frontend.cucumber.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage extends BasePage{
    public UserPage(WebDriver _webDriver) {
        super(_webDriver);

        PageFactory.initElements(webDriver, this);
    }

    //@FindBy(css = "img.gravatar")
    @FindBy(css = ".masterbar__item.masterbar__item-me")
    public WebElement userAvatar;
}
