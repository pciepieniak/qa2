package com.jsystems.qa2.frontend.cucumber;

import com.jsystems.qa2.frontend.Configuration;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class CucumberStepConfig {

    WebDriver webDriver;

    @Before
    public static void beforeAll()
    {
        //WebDriverManager.chromedriver().setup();
        System.setProperty("webdriver.chrome.driver", ClassLoader.getSystemClassLoader().getResource("driver/chromedriver.exe").getFile());
        System.setProperty("webdriver.gecko.driver", ClassLoader.getSystemClassLoader().getResource("driver/geckodriver.exe").getFile());
    }

    //beforeEach
    public WebDriver setUp()
    {
        String browser = Configuration.getBROWSER();

        if (browser.equals("chrome"))
        {
            webDriver = new ChromeDriver();
        }
        else if (browser.equals("firefox"))
        {
            webDriver = new FirefoxDriver();
        }

        setWebDriver();

        //webDriver.get(Configuration.BASE_URL);

        return webDriver;
    }

    public void setWebDriver ()
    {
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        webDriver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
    }

    @After
    public void tearDown(Scenario scenario) {

        System.out.println("=========================== @After Cucumber Test  =======================================");
        String status;
        if(!scenario.isFailed()) {
            status = "( ͡° ͜ʖ ͡°)";

            scenario.write("Scenario passed");
        } else {
            status = "(✖╭╮✖)";

            scenario.embed(((TakesScreenshot)webDriver).getScreenshotAs(OutputType.BYTES),"images/png");
            scenario.write("Scenario failed");
        }
        System.out.println("\n"+status+" End of: " + scenario.getName() + " scenario.");
        webDriver.quit();
        webDriver = null;
    }
}
