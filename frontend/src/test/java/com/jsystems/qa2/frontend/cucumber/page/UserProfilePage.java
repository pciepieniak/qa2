package com.jsystems.qa2.frontend.cucumber.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserProfilePage extends BasePage{
    @FindBy(css = ".button.form-button.is-primary")
    public WebElement buttonSave;

    @FindBy(css = ".material-icon.material-icon-notifications")
    public  WebElement notification;

    public UserProfilePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    // mvn clean install -Dcucumber.options="--tags @wordpress --tags @login"
}
