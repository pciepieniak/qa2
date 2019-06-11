package com.jsystems.qa2.frontend;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.Time;
import java.util.concurrent.TimeUnit;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FrontendTest {
    WebDriver webDriver;

    @BeforeAll
    public static void beforeAll()
    {
        System.setProperty("webdriver.gecko.driver", "D:/firefox/geckodriver.exe");
    }

    @Test
    public void firstFrontTest()
    {
        //WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();

        //System.setProperty("webdriver.chrome.driver", "D:/chromedriver.exe");
        //System.setProperty("webdriver.gecko.driver", "D:/geckodriver.exe");

        //webDriver = new ChromeDriver();
        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        webDriver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);

        webDriver.get("https://wordpress.com");

//        try {
//            sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        WebElement login = webDriver.findElement(By.cssSelector(".x-nav-item.x-nav-item--wide.x-nav-item--logged-in  a.x-nav-link.x-link"));
        WebElement span1 = webDriver.findElement(By.cssSelector("#lpc-headline h1 span:nth-child(1)"));

        assertTrue(span1.isDisplayed());
        assertEquals(span1.getText(), "Build a website,");

        assertTrue(login.isDisplayed());
        assertEquals(login.getText(), "Log In");

        login.click();

        webDriver.quit();
    }
}