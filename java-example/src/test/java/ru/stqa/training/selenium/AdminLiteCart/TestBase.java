package ru.stqa.training.selenium.AdminLiteCart;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
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
    String browser = BrowserType.CHROME;


    @Before
    public void start() {
        if (browser.equals(BrowserType.CHROME)) {
            driver = new ChromeDriver();
        } else if (browser.equals(BrowserType.FIREFOX)) {
            FirefoxOptions options = new FirefoxOptions().setLegacy(false);
            driver = new FirefoxDriver(options);
        } else if (browser.equals(BrowserType.EDGE)) {
                driver = new EdgeDriver();
            }


        wait = new WebDriverWait(driver, 10);
        driver.manage().deleteAllCookies();
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }
}

