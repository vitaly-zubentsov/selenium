package ru.stqa.training.selenium.adminLiteCart;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.io.File;

public class Task12AddingNewProductTest extends TestBase {

    @Test
    public void testAddingNewProduct() {
        driver.findElement(By.cssSelector(" a[href*=catalog]")).click();

        driver.findElement(By.cssSelector("a.button[href*=edit_product]")).click();
        driver.findElement(By.cssSelector("input[type=radio]")).click();
        driver.findElement(By.cssSelector("input[name*=name]")).sendKeys("Batman Duck");
        driver.findElement(By.cssSelector("input[name=code]")).sendKeys("12");
        driver.findElement(By.cssSelector("[data-name*=Rubber]")).click();
        actionWithDropDownList(By.cssSelector("select[name=default_category_id]"), "1");
        driver.findElements(By.cssSelector("[name *= product_groups]")).get(2).click();
        driver.findElement(By.cssSelector("[name=quantity]")).clear();
        driver.findElement(By.cssSelector("[name=quantity]")).sendKeys("300");
        actionWithDropDownList(By.cssSelector("[name=sold_out_status_id"), "");
        File file = new File("Files/BatmanDuck.jpg");
        driver.findElement(By.cssSelector("[name *= new_images]")).sendKeys(file.getAbsolutePath());
        driver.findElement(By.cssSelector("[name=date_valid_from]")).sendKeys(Keys.HOME + "10.02.2017");
        driver.findElement(By.cssSelector("[name=date_valid_to]")).sendKeys(Keys.HOME + "10.02.2020");

        driver.findElement(By.cssSelector("[href*=tab-information]")).click();
        actionWithDropDownList(By.cssSelector("[name=manufacturer_id]"), "1");
        driver.findElement(By.cssSelector("[name = keywords]")).sendKeys("Batman Duck");
        driver.findElement(By.cssSelector("[name *= short]")).sendKeys("Batman");
        driver.findElement(By.cssSelector(".trumbowyg-editor")).sendKeys("Batman Duck has been Gotham's protector for months, CEO of Wayne Enterprises, Patriarch of the Duck Family and veteran member of the Justice League.");
        driver.findElement(By.cssSelector("[name *= head]")).sendKeys("BatmanD");
        driver.findElement(By.cssSelector("[name *= meta]")).sendKeys("BD");

        driver.findElement(By.cssSelector("[href*=tab-prices]")).click();
        driver.findElement(By.cssSelector("[name =  purchase_price]")).clear();
        driver.findElement(By.cssSelector("[name =  purchase_price]")).sendKeys("10");
        actionWithDropDownList(By.cssSelector("[name = purchase_price_currency_code]"), "USD");
        driver.findElement(By.cssSelector("[type=text][name *= USD]")).sendKeys("25");

        driver.findElement(By.cssSelector("button[type=submit][name = save]")).click();
    }

    private void actionWithDropDownList(By locatorOfDropDownList, String selectByValue) {
        WebElement webElementContainingDropDownList = driver.findElement(locatorOfDropDownList);
        Select select = new Select(webElementContainingDropDownList);
        select.selectByValue(selectByValue);
    }
}

