package ru.stqa.training.selenium.pageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AddingPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public AddingPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public boolean isElementsPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }



    public WebElement addProductForCart() {
        return driver.findElement(By.cssSelector("[name=add_cart_product"));
    }

    public int numberOfProductsAfterAdding() {
        return Integer.parseInt(driver.findElement(By.cssSelector("span.quantity")).getText()) + 1;
    }

    public void fillExtraOptionForChoosingElement(String extraOptionForChoosing) {
        actionWithDropDownList(By.name("options[Size]"), extraOptionForChoosing);
    }

    public boolean isExtraOptionForChoosingElementPresent() {
        return isElementsPresent(By.name("options[Size]"));
    }

    public void goToBack() {
        driver.navigate().back();
    }

    public void actionWithDropDownList(By locatorOfDropDownList, String selectByValue) {
        WebElement webElementContainingDropDownList = driver.findElement(locatorOfDropDownList);
        Select select = new Select(webElementContainingDropDownList);
        select.selectByValue(selectByValue);
    }

    public void waitUntilProductAddingToCart(int numberOfProductsAfterAdding) {
        wait.until(ExpectedConditions.attributeContains(By.cssSelector("span.quantity"), "textContent", String.valueOf(numberOfProductsAfterAdding)));
    }
}