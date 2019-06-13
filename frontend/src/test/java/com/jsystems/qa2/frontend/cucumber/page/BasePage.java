package com.jsystems.qa2.frontend.cucumber.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver webDriver;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void waitForVisibilityOfElement(WebElement element, int maxWaitTime)
    {
        WebDriverWait wait = new WebDriverWait(webDriver, maxWaitTime);
        wait.until(ExpectedConditions.visibilityOf(element));
    }
}
