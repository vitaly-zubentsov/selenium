package ru.stqa.training.selenium.pageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public CartPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public WebElement fieldQuantity() {
        return driver.findElement(By.cssSelector("input[name=quantity]"));
    }

    public WebElement updateProduct() {
        return driver.findElement(By.cssSelector("[name=update_cart_item]"));
    }

    public WebElement removeProduct() {
        return driver.findElement(By.cssSelector("[name=remove_cart_item]"));
    }

    public WebElement TableOfProduct() {
        return driver.findElement(By.cssSelector(".dataTable"));
    }

    public int NumberOfItem() {
        return Integer.parseInt(driver.findElement(By.cssSelector("[name=quantity]")).getAttribute("value"));
    }

    public void waitWhileProductUpdate(int numberOfItem) {
        wait.until(ExpectedConditions.attributeContains(By.cssSelector("tr > td[style *= text-align]"), "textContent", String.valueOf(numberOfItem - 1)));
    }

    public void waitWhileProductRemoved(WebElement webElement) {
        wait.until(ExpectedConditions.stalenessOf(webElement));
    }
}
