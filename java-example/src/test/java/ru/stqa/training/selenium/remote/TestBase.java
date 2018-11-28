package ru.stqa.training.selenium.remote;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.URL;

public class TestBase {
    public WebDriver driver = new RemoteWebDriver(new URL("https://192.168.1.124:4444/wd/hub"), DesiredCapabilities.chrome());
    protected WebDriverWait wait;
    String s = "http://192.168.1.124:4444/wd/hub";


    @Before
    public void start() {
        wait = new WebDriverWait(driver, 10);
        driver.manage().deleteAllCookies();
        driver.get("http://localhost/litecart/");
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

}
