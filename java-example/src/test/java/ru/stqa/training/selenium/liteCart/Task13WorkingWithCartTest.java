package ru.stqa.training.selenium.liteCart;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class Task13WorkingWithCartTest extends TestBase {

    @Test
    public void testRegistrationOfUserTest() {
        for (int i = 1; i <= 3; i++) {
            driver.findElement(By.cssSelector("#box-most-popular .product.column.shadow.hover-light")).click();
            if (isElementsPresent(By.name("options[Size]"))) {
                actionWithDropDownList(By.name("options[Size]"), "Medium");
            }
            driver.findElement(By.cssSelector("button[name=add_cart_product")).click();
            wait.until(ExpectedConditions.attributeContains(By.cssSelector("span.quantity"), "textContent", String.valueOf(i)));
            driver.navigate().back();
        }

        driver.findElement(By.cssSelector("a.link[href *= checkout]")).click();
        for (int i = 1; i <= 3; i++) {
            driver.findElement(By.cssSelector("input[name=quantity]")).clear();
            driver.findElement(By.cssSelector("input[name=quantity]")).sendKeys("1");
            driver.findElement(By.cssSelector(" [name=remove_cart_item]")).click();
            //удалять по одному если несколько одинаковых товаров.

            driver.findElement(By.cssSelector("button[name=add_cart_product")).click();
            //Ожидание
            //Проверка того что количество товара в корзине изменилось

        }


    }

    protected boolean isElementsPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    private void actionWithDropDownList(By locatorOfDropDownList, String selectByValue) {
        WebElement webElementContainingDropDownList = driver.findElement(locatorOfDropDownList);
        Select select = new Select(webElementContainingDropDownList);
        select.selectByValue(selectByValue);
    }
}
