package ru.stqa.training.selenium.liteCart;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class Task8CheckForStickersTest extends TestBase {

    @Test
    public void testCheckForStickers() {
        int numberOfProducts = driver.findElements(By.cssSelector("div.content .link")).size();
        for (int i = 0; i < numberOfProducts; i++) {

            List<WebElement> arrayOfproducts = driver.findElements(By.cssSelector(".product.column.shadow.hover-light"));
            List<WebElement> arrayOfstickers = arrayOfproducts.get(i).findElements(By.cssSelector("[class ^= sticker]"));
            assertTrue(arrayOfstickers.size() == 1);

        }
    }
}

