package com.jsystems.qa2.frontend.cucumber;

import com.jsystems.qa2.frontend.Configuration;
import com.jsystems.qa2.frontend.cucumber.page.*;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginSteps {
    WebDriver webDriver;
    MainWordpressPage mainWordpressPage;
    LoginPage loginPage;
    UserPage userPage;
    UserProfilePage userProfilePage;
    NotificationPage notificationPage;

    public LoginSteps(CucumberStepConfig stepConfig) {
        webDriver = stepConfig.setUp();
    }

    @Given("^User start on main page$")
    public void userStartOnMainPage() {
        webDriver.get(Configuration.BASE_URL);
    }

    @When("^User log In to the user page$")
    public void userLogInToTheUserPage() {
        login();

        // User page
        userPage = new UserPage(webDriver);
        userPage.waitForVisibilityOfElement(userPage.userAvatar, 30);

        // Assertions
        assertTrue(userPage.userAvatar.isDisplayed());
    }

    @Then("^User can modfied user profile$")
    public void userCanModfiedUserProfile() {
        userPage.userAvatar.click();


        userProfilePage = new UserProfilePage(webDriver);
        userProfilePage.waitForVisibilityOfElement(userProfilePage.buttonSave, 120);



        JavascriptExecutor js = (JavascriptExecutor) webDriver;
        js.executeScript("arguments[0].scrollIntoView(true);", userProfilePage.buttonSave);
        userProfilePage.waitForVisibilityOfElement(userProfilePage.buttonSave, 120);

        assertFalse(userProfilePage.buttonSave.isEnabled());
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

    @Given("^User start on page \"([^\"]*)\"$")
    public void userStartOnPage(String arg0) throws Throwable {
        webDriver.get(arg0);
/*

      // User page
        userPage = new UserPage(webDriver);
        userPage.waitForVisibilityOfElement(userPage.userAvatar, 30);

        // Assertions
        assertTrue(userPage.userAvatar.isDisplayed());
 */

    }

    @Then("^User can modfied notyfication$")
    public void userCanModfiedNotyfication() {
        userPage.userAvatar.click();

        userProfilePage = new UserProfilePage(webDriver);

        userProfilePage.waitForVisibilityOfElement(userProfilePage.notification, 30);
        userProfilePage.notification.click();

        notificationPage = new NotificationPage(webDriver);
        notificationPage.waitForVisibilityOfElement(notificationPage.firstCheckbox, 30);

        assertTrue(notificationPage.firstCheckbox.isSelected());
    }
}
