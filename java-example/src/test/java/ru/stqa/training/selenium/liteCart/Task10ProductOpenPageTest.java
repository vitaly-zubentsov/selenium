package ru.stqa.training.selenium.liteCart;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class Task10ProductOpenPageTest extends TestBase {
    @Test
    public void testProductOpenPage() {
        WebElement checkingProduct = driver.findElement(By.cssSelector("#box-campaigns .product.column.shadow.hover-light"));
        String nameOfProduct = checkingProduct.findElement(By.cssSelector("div.name")).getText();
        List<String> PricesOfProduct = getPricesList(checkingProduct, By.cssSelector("div > [class *= price]"));
        if (PricesOfProduct.size() == 2) {
            comparisonOfValuesForPrices(By.cssSelector("#box-campaigns .product.column.shadow.hover-light [class = regular-price]"), By.cssSelector("#box-campaigns .product.column.shadow.hover-light [class = campaign-price]"));
        }
        checkingProduct.click();

        String nameOfProductNewPage = driver.findElement(By.cssSelector("h1.title")).getText();
        WebElement webElementContainsPrices = driver.findElement(By.cssSelector("div.information div.price-wrapper"));
        List<String> PricesOfProductNewPage = getPricesList(webElementContainsPrices, By.cssSelector("[class *= price]"));
        if (PricesOfProductNewPage.size() == 2) {
            comparisonOfValuesForPrices(By.cssSelector("div.information div.price-wrapper [class = regular-price]"), By.cssSelector("div.information div.price-wrapper [class = campaign-price]"));
        }
        assertTrue(nameOfProduct.equals(nameOfProductNewPage));
        assertTrue(PricesOfProduct.equals(PricesOfProductNewPage));
    }

}
