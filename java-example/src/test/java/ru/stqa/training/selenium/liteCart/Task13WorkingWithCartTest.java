package ru.stqa.training.selenium.liteCart;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

public class Task13WorkingWithCartTest extends TestBase {

    @Test
    public void testWorkingWithCart() {

        for (int i = 1; i <= 3; i++) {
            driver.findElement(By.cssSelector(".product")).click();
            if (isElementsPresent(By.name("options[Size]"))) {
                actionWithDropDownList(By.name("options[Size]"), "Medium");
            }
            driver.findElement(By.cssSelector("[name=add_cart_product")).click();
            wait.until(ExpectedConditions.attributeContains(By.cssSelector("span.quantity"), "textContent", String.valueOf(i)));
            driver.navigate().back();
        }

        driver.findElement(By.cssSelector("a.link[href *= checkout]")).click();

        for (int i = 1; i <= 3; i++) {
            if ((i == 1) & (driver.findElements(By.cssSelector("td.item")).size() != 1)) {
                wait.until(ExpectedConditions.attributeContains(By.cssSelector("a[class *= inact]"), "className", "inact act"));
            }
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
