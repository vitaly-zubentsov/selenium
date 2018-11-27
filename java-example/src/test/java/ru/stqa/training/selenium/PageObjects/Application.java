package ru.stqa.training.selenium.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Application {
    protected WebDriver driver;
    protected WebDriverWait wait;
    String browser = BrowserType.CHROME;

    public void deleteOneProductFromCart() {
//  Тест работает и без этой проверки, включил её во время выполнения 13 задания для тренировки.
//            if ((i == 1) & (driver.findElements(By.cssSelector("td.item")).size() != 1)) {
//                wait.until(ExpectedConditions.attributeContains(By.cssSelector("a[class *= inact]"), "className", "inact act"));
//            }

        int numberOfItem = Integer.parseInt(driver.findElement(By.cssSelector("[name=quantity]")).getAttribute("value"));

        if (numberOfItem == 1) {

            WebElement webElement = driver.findElement(By.cssSelector(".dataTable"));
            driver.findElement(By.cssSelector("[name=remove_cart_item]")).click();
            wait.until(ExpectedConditions.stalenessOf(webElement));
        } else {
            driver.findElement(By.cssSelector("input[name=quantity]")).clear();
            driver.findElement(By.cssSelector("input[name=quantity]")).sendKeys(String.valueOf(numberOfItem - 1));
            driver.findElement(By.cssSelector("[name=update_cart_item]")).click();
            wait.until(ExpectedConditions.attributeContains(By.cssSelector("tr > td[style *= text-align]"), "textContent", String.valueOf(numberOfItem - 1)));
        }
    }

    public void goToCart() {
        driver.findElement(By.cssSelector("a.link[href *= checkout]")).click();
    }

    public void addOneProductToCart(By locatorOfProduct, String extraOptinonForChoosing) {
        driver.findElement(locatorOfProduct).click();
        if (isElementsPresent(By.name("options[Size]"))) {
            actionWithDropDownList(By.name("options[Size]"), extraOptinonForChoosing);
        }
        int numberOfProductsAfterAdding = Integer.parseInt(driver.findElement(By.cssSelector("span.quantity")).getText()) + 1;
        driver.findElement(By.cssSelector("[name=add_cart_product")).click();
        wait.until(ExpectedConditions.attributeContains(By.cssSelector("span.quantity"), "textContent", String.valueOf(numberOfProductsAfterAdding)));
        driver.navigate().back();
    }

    public boolean isElementsPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void actionWithDropDownList(By locatorOfDropDownList, String selectByValue) {
        WebElement webElementContainingDropDownList = driver.findElement(locatorOfDropDownList);
        Select select = new Select(webElementContainingDropDownList);
        select.selectByValue(selectByValue);
    }

    public void initDriverAndOpenStartPage() {
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

    public void stopDriver() {
        driver.quit();
        driver = null;
    }
}
