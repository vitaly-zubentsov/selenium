package ru.stqa.training.selenium.liteCart;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class Task8CheckForStickersTest extends TestBase {

    @Test
    public void testCheckForStickers() {
        List<WebElement> arrayOfProducts = driver.findElements(By.cssSelector(".product.column.shadow.hover-light"));
        for (int i = 0; i < arrayOfProducts.size(); i++) {
            List<WebElement> arrayOfStickers = arrayOfProducts.get(i).findElements(By.cssSelector("[class ^= sticker]"));
            assertTrue(arrayOfStickers.size() == 1);

        }
    }
}

