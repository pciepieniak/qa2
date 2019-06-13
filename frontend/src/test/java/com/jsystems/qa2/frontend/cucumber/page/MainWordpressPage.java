package com.jsystems.qa2.frontend.cucumber.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainWordpressPage extends BasePage{

    @FindBy(css = ".x-nav-item.x-nav-item--wide.x-nav-item--logged-in  a.x-nav-link.x-link")
    public WebElement login; // = webDriver.findElement(By.cssSelector(".x-nav-item.x-nav-item--wide.x-nav-item--logged-in  a.x-nav-link.x-link"));

    @FindBy(css = "#lpc-headline h1 span:nth-child(1)")
    public WebElement span1; // = webDriver.findElement(By.cssSelector("#lpc-headline h1 span:nth-child(1)"));

    public MainWordpressPage(WebDriver _webDriver) {
        super(_webDriver);

        PageFactory.initElements(webDriver, this);
    }
}
