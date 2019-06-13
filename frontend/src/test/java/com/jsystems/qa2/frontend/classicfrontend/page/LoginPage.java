package com.jsystems.qa2.frontend.classicfrontend.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver _webDriver) {
        super(_webDriver);

        PageFactory.initElements(webDriver, this);
    }

    @FindBy(css = "#usernameOrEmail")
    public WebElement emailInput; // = webDriver.findElement(By.id("usernameOrEmail"));

    @FindBy(css = "#password")
    public WebElement passwordInput; // = webDriver.findElement(By.id("password"));

    @FindBy(css = ".button.form-button.is-primary")
    public WebElement submitButton; // = webDriver.findElement(By.cssSelector(".button.form-button.is-primary"));
}
