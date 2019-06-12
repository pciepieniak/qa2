package com.jsystems.qa2.frontend.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver webDriver;

    public BasePage (WebDriver _webDriver)
    {
        this.webDriver = _webDriver;
    }

    public void waitForVisibilityOfElement(WebElement element, int maxWaitTime)
    {
        WebDriverWait wait = new WebDriverWait(webDriver, maxWaitTime);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
