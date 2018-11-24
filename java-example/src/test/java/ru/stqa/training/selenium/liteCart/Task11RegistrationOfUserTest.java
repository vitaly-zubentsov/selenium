package ru.stqa.training.selenium.liteCart;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class Task11RegistrationOfUserTest extends TestBase {
    @Test
    public void testCheckForStickers() {

        driver.findElement(By.cssSelector("[href *= create_account]")).click();
        driver.findElement(By.cssSelector("[name=firstname]")).sendKeys("Test");
        driver.findElement(By.cssSelector("[name=lastname]")).sendKeys("Test");
        driver.findElement(By.cssSelector("[name=address1]")).sendKeys("Test");
        driver.findElement(By.cssSelector("[name=postcode]")).sendKeys("94102");
        driver.findElement(By.cssSelector("[name=city]")).sendKeys("Test");
        WebElement webElementContainingChoosingOfCoyntry = driver.findElement(By.cssSelector(".select2-selection__rendered"));
        Select(webElementContainingChoosingOfCoyntry).
        WebElement webElementContainingChoosingOfZones = driver.findElement(By.cssSelector("[name=zone_code]"));
     //
        driver.findElement(By.cssSelector("[name=email]")).sendKeys(getUniqueEmail());
        driver.findElement(By.cssSelector("[name=phone]")).sendKeys("124566");
        driver.findElement(By.cssSelector("[name=password]")).sendKeys("Test");
        driver.findElement(By.cssSelector("[name=confirmed_password]")).sendKeys("Test");
        driver.findElement(By.cssSelector("[name= create_account]")).click();

//        WebElement checkingProduct = driver.findElement(By.cssSelector("#box-campaigns .product.column.shadow.hover-light"));
//        String nameOfProduct = checkingProduct.findElement(By.cssSelector("div.name")).getText();
//        List<String> PricesOfProduct = getPricesList(checkingProduct, By.cssSelector("div > [class *= price]"));
//        if (PricesOfProduct.size() == 2) {
//            comparisonOfValuesForPrices(By.cssSelector("#box-campaigns .product.column.shadow.hover-light [class = regular-price]"), By.cssSelector("#box-campaigns .product.column.shadow.hover-light [class = campaign-price]"));
//        }
//        checkingProduct.click();
//
//        String nameOfProductNewPage = driver.findElement(By.cssSelector("h1.title")).getText();
//        WebElement webElementContainsPrices = driver.findElement(By.cssSelector("div.information div.price-wrapper"));
//        List<String> PricesOfProductNewPage = getPricesList(webElementContainsPrices, By.cssSelector("[class *= price]"));
//        if (PricesOfProductNewPage.size() == 2) {
//            comparisonOfValuesForPrices(By.cssSelector("div.information div.price-wrapper [class = regular-price]"), By.cssSelector("div.information div.price-wrapper [class = campaign-price]"));
//        }
//        assertTrue(nameOfProduct.equals(nameOfProductNewPage));
//        assertTrue(PricesOfProduct.equals(PricesOfProductNewPage));
    }

    private String getUniqueEmail() {
        String uniqueEmail;
        return "mail@lj.ru";
    }
}

