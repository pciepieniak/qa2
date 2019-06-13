package com.jsystems.qa2.frontend.classicfrontend.test;

import com.jsystems.qa2.frontend.Configuration;
import com.jsystems.qa2.frontend.classicfrontend.page.LoginPage;
import com.jsystems.qa2.frontend.classicfrontend.page.MainWordpressPage;
import com.jsystems.qa2.frontend.classicfrontend.page.UserPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FrontendTest extends ConfigFrontend{
    // mvn clean install -Dtest=FrontendTest#firstFrontTest -pl frontend
    // mvn clean install -Dtest=ClassName#MethodName -pl ModuleName

    MainWordpressPage mainWordpressPage;
    LoginPage loginPage;
    UserPage userPage;

    @Test
    public void firstFrontTest()
    {
        mainWordpressPage = new MainWordpressPage(webDriver);

        assertTrue(mainWordpressPage.span1.isDisplayed());
        assertEquals(mainWordpressPage.span1.getText(), "Build a website,");

        assertTrue(mainWordpressPage.login.isDisplayed());
        assertEquals(mainWordpressPage.login.getText(), "Log In");

        mainWordpressPage.login.click();
    }

    @Test
    public void loginTest()
    {
        login();

        // User page
        userPage = new UserPage(webDriver);
        userPage.waitForVisibilityOfElement(userPage.userAvatar, 30);

        // Assertions
        assertTrue(userPage.userAvatar.isDisplayed());
    }

    @Test
    public void loginActionTest()
    {
        // Home page
        mainWordpressPage = new MainWordpressPage(webDriver);
        mainWordpressPage.waitForVisibilityOfElement(mainWordpressPage.login, 30);
        mainWordpressPage.login.click();

        // Login page
        loginPage = new LoginPage(webDriver);

        // Username input
        loginPage.waitForVisibilityOfElement(loginPage.emailInput, 30);

        Actions actions = new Actions(webDriver);
        actions
                .moveToElement(loginPage.emailInput)
                .sendKeys(Configuration.LOGIN)
                .sendKeys(Keys.chord(Keys.ENTER))
                .build()
                .perform();

        loginPage.waitForVisibilityOfElement(loginPage.passwordInput, 30);

        assertTrue(loginPage.submitButton.getText().trim().equals("Log In"));
    }

    private void login()
    {
        // Home page
        mainWordpressPage = new MainWordpressPage(webDriver);
        mainWordpressPage.waitForVisibilityOfElement(mainWordpressPage.login, 30);
        mainWordpressPage.login.click();

        // Login page
        loginPage = new LoginPage(webDriver);

        // Username input
        loginPage.waitForVisibilityOfElement(loginPage.emailInput, 30);
        loginPage.emailInput.clear();
        loginPage.emailInput.sendKeys(Configuration.LOGIN);
        loginPage.submitButton.click();

        // Password input
        loginPage.waitForVisibilityOfElement(loginPage.passwordInput, 30);
        loginPage.passwordInput.clear();
        loginPage.passwordInput.sendKeys(Configuration.PASSWORD);
        loginPage.submitButton.click();
    }




}