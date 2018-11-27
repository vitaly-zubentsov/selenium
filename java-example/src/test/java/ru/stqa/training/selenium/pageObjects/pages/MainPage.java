package ru.stqa.training.selenium.pageObjects.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MainPage {
    private WebDriver driver;

    public MainPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openMainPage() {
        driver.get("http://localhost/litecart/");
    }

    public void goToCartPage() {
        driver.findElement(By.cssSelector("a.link[href *= checkout]")).click();
    }

    public void chooseOneOfProduct() {
        driver.findElement(By.cssSelector(".product")).click();
    }
}
