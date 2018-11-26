package ru.stqa.training.selenium.adminLiteCart;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

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

    protected boolean isElementsPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    protected List<String> getListOfZonesForGeoZones() {
        List<String> listOfZones = new ArrayList<String>();
        List<WebElement> webElementsOfZones = driver.findElements(By.cssSelector("[name *= zone_code ] [selected]"));
        for (WebElement webElement : webElementsOfZones) {
            String name = webElement.getText();
            listOfZones.add(name);
        }
        return listOfZones;
    }

    protected List<String> getListOfZonesForCountry() {
        List<String> listOfZones = new ArrayList<String>();
        List<WebElement> webElementsOfZones = driver.findElements(By.cssSelector("[type*=hidden][name *= name ]"));
        for (WebElement webElement : webElementsOfZones) {
            String name = webElement.getAttribute("value");
            listOfZones.add(name);
        }
        return listOfZones;
    }

    public List<String> getListOfNameForCountries() {
        List<String> listOfCountries = new ArrayList<String>();
        List<WebElement> webElements = driver.findElements(By.cssSelector("tr.row"));
        for (WebElement webElement : webElements) {
            String name = webElement.findElement(By.cssSelector("a")).getText();
            listOfCountries.add(name);
        }
        return listOfCountries;
    }
}

