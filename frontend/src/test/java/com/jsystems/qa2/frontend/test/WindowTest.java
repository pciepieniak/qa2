package com.jsystems.qa2.frontend.test;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Set;

public class WindowTest extends ConfigFrontend {

    @Test
    public void testWindows()
    {
        String firstPageWindowHandle;
        String secondTestWindowHandle = null;

        String contactUrl = "http://www.testdiary.com/training/selenium/selenium-test-page/";

        webDriver.get(contactUrl);

        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Open page in a new window")));

        firstPageWindowHandle = webDriver.getWindowHandle();

        int hyperlinkYCoordinate = webDriver.findElement(By.linkText("Open page in a new window")).getLocation().getY();
        int hyperlinkXCoordinate = webDriver.findElement(By.linkText("Open page in a new window")).getLocation().getX();

        JavascriptExecutor jsexecutor = (JavascriptExecutor) webDriver;
        jsexecutor.executeScript("window.scrollBy(" + hyperlinkXCoordinate + "," + hyperlinkYCoordinate + ")", "");

        new WebDriverWait(webDriver, 100)
                .until(ExpectedConditions.elementToBeClickable(By.linkText("Open page in a new window")));

        webDriver.findElement(By.linkText("Open page in a new window")).click();

        Set<String> testPageWindowHandle = webDriver.getWindowHandles();

        for (String windowHandle : testPageWindowHandle) {
            if (!firstPageWindowHandle.equals(windowHandle)) {
                secondTestWindowHandle = windowHandle;
            }
        }

        webDriver.switchTo().window(secondTestWindowHandle);

        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.id("testpagelink")));

        webDriver.switchTo().window(secondTestWindowHandle).close();

        webDriver.switchTo().window(firstPageWindowHandle);

        (new WebDriverWait(webDriver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(By.linkText("Open page in a new window")));

    }

    @Test
    public void frameTest(){
        String contactUrl = "http://www.testdiary.com/training/selenium/selenium-test-page/";

        webDriver.get(contactUrl);

        new WebDriverWait(webDriver, 10)
                .until(ExpectedConditions.visibilityOfElementLocated(By.name("testframe")));

        WebElement testframe = webDriver.findElement(By.name("testframe"));

        webDriver.switchTo().frame(testframe);

        String expectedFrameText =webDriver.findElement(By.id("testpagelink")).getText();
        String actualFrameText = "My frame text";

        if(actualFrameText.equals(expectedFrameText)){
            System.out.println("Found my frame text");
        }
        else {
            System.out.println("Did not find my frame text");
        }

        webDriver.switchTo().parentFrame();
    }
}
