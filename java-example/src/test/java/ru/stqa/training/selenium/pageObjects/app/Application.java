package ru.stqa.training.selenium.pageObjects.app;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.stqa.training.selenium.pageObjects.pages.AddingPage;
import ru.stqa.training.selenium.pageObjects.pages.CartPage;
import ru.stqa.training.selenium.pageObjects.pages.MainPage;

public class Application {
    protected WebDriverWait wait;
    protected WebDriver driver;

    private MainPage mainPage;
    private AddingPage addingPage;
    private CartPage cartPage;

    String browser = BrowserType.CHROME;

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
        mainPage = new MainPage(driver);
        addingPage = new AddingPage(driver, wait);
        cartPage = new CartPage(driver, wait);


        driver.manage().deleteAllCookies();
        mainPage.openMainPage();
    }

    public void stopDriver() {
        driver.quit();
        driver = null;
    }

    public void deleteOneProductFromCart() {

        int numberOfItem = cartPage.NumberOfItem();

        if (numberOfItem == 1) {

            WebElement webElement = cartPage.TableOfProduct();
            cartPage.removeProduct().click();
            cartPage.waitWhileProductRemoved(webElement);
        } else {
            cartPage.fieldQuantity().clear();
            cartPage.fieldQuantity().sendKeys(String.valueOf(numberOfItem - 1));
            cartPage.updateProduct().click();
            cartPage.waitWhileProductUpdate(numberOfItem);
        }
    }

    public void goToCart() {
        mainPage.goToCartPage();
    }

    public void addOneProductToCart(String extraOptionForChoosing) {
        mainPage.chooseOneOfProduct();
        if (addingPage.isExtraOptionForChoosingElementPresent()) {
            addingPage.fillExtraOptionForChoosingElement(extraOptionForChoosing);
        }
        int numberOfProductsAfterAdding = addingPage.numberOfProductsAfterAdding();
        addingPage.addProductForCart().click();
        addingPage.waitUntilProductAddingToCart(numberOfProductsAfterAdding);
        addingPage.goToBack();
    }


    public CartPage getCartPage() {
        return cartPage;
    }

    public AddingPage getAddingPage() {
        return addingPage;
    }

    public MainPage getMainPage() {
        return mainPage;
    }
}
