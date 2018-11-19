package ru.stqa.training.selenium;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestBase {
    protected WebDriver driver;
    protected WebDriverWait wait;
    String browser = BrowserType.FIREFOX;


    @Before
    public void start() {
        if (browser.equals(BrowserType.CHROME)) {
            driver = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)){
            FirefoxOptions options = new FirefoxOptions().setLegacy(true);
            driver = new FirefoxDriver(options);
        } else{ if (browser.equals(BrowserType.EDGE))
            driver = new EdgeDriver();

        }
        wait = new WebDriverWait(driver, 10);

    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}
