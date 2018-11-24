package ru.stqa.training.selenium.liteCart;

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

import static junit.framework.TestCase.assertTrue;

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
        driver.get("http://localhost/litecart/");
    }

    @After
    public void stop() {
        driver.quit();
        driver = null;
    }

    public void comparisonOfValuesForPrices(By locatorForRegularPrice, By locatorForCampaignPrice) {
        WebElement webElementForRegularPrice = driver.findElement(locatorForRegularPrice);
        String textDecorationLineOfRegularPrice = webElementForRegularPrice.getAttribute("tagName");
        String colorOfRegularPrice = webElementForRegularPrice.getCssValue("color");
        double fontsizeOfRegularPrice = Double.parseDouble(webElementForRegularPrice.getCssValue("font-size").replace("px", ""));


        assertTrue(textDecorationLineOfRegularPrice.equals("S"));
        assertTrue(colorIsGrey(colorOfRegularPrice));

        WebElement webElementForCampaignPrice = driver.findElement(locatorForCampaignPrice);
        String fontWeightOfCampaignPrice = webElementForCampaignPrice.getAttribute("tagName");
        String colorOfCampaignPrice = webElementForCampaignPrice.getCssValue("color");
        double fontsizeOfCampaignPrice = Double.parseDouble(webElementForCampaignPrice.getCssValue("font-size").replace("px", ""));

        assertTrue(fontWeightOfCampaignPrice.equals("STRONG"));
        assertTrue(colorIsRed(colorOfCampaignPrice));

        assertTrue(fontsizeOfCampaignPrice > fontsizeOfRegularPrice);
    }

    public boolean colorIsRed(String color) {
        String[] numbers = color.replaceAll("[a-z]", "").replaceAll("[-()]", "").split(",");
        int r = Integer.parseInt(numbers[0].trim());
        int g = Integer.parseInt(numbers[1].trim());
        int b = Integer.parseInt(numbers[2].trim());
        if ((r != 0) & (g == 0) & (b == 0)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean colorIsGrey(String color) {
        String[] numbers = color.replaceAll("[a-z]", "").replaceAll("[-()]", "").split(",");
        int r = Integer.parseInt(numbers[0].trim());
        int g = Integer.parseInt(numbers[1].trim());
        int b = Integer.parseInt(numbers[2].trim());
        if ((r == g) & (g == b)) {
            return true;
        } else {
            return false;
        }
    }

    public List<String> getPricesList(WebElement webElementContainingPrices, By locator) {
        List<String> listOfPrices = new ArrayList<String>();
        List<WebElement> webElementsContainingPrice = webElementContainingPrices.findElements(locator);
        for (WebElement webElementContainingPrice : webElementsContainingPrice) {
            String price = webElementContainingPrice.getText();
            listOfPrices.add(price);
        }
        return listOfPrices;
    }
}
