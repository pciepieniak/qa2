package com.jsystems.qa2.frontend.classicfrontend.test;

import com.jsystems.qa2.frontend.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.URISyntaxException;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class ConfigFrontend {
    protected WebDriver webDriver;

    String chromePath;
    String fireFoxPath;

    {
        try {
            chromePath = Paths.get(getClass().getClassLoader().getResource("driver/chromedriver.exe").toURI()).toFile().getAbsolutePath();
            fireFoxPath = Paths.get(getClass().getClassLoader().getResource("driver/geckodriver.exe").toURI()).toFile().getAbsolutePath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }

    @BeforeAll
    public static void beforeAll()
    {
        //WebDriverManager.chromedriver().setup();
        //System.setProperty("webdriver.chrome.driver", ClassLoader.getSystemClassLoader().getResource("driver/chromedriver.exe").getFile());
        //System.setProperty("webdriver.gecko.driver", ClassLoader.getSystemClassLoader().getResource("driver/geckodriver.exe").getFile());
    }

    @BeforeEach
    public void beforeEach()
    {
        System.setProperty("webdriver.chrome.driver", chromePath);
        System.setProperty("webdriver.gecko.driver", fireFoxPath);

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

        webDriver.get(Configuration.BASE_URL);
    }

    @AfterEach
    public void afterEach()
    {
//        try {
//            sleep(5000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//
//        webDriver.quit();
    }

    public void setWebDriver ()
    {
        webDriver.manage().window().maximize();
        webDriver.manage().deleteAllCookies();
        webDriver.manage().timeouts().pageLoadTimeout(120, TimeUnit.SECONDS);
    }
}
