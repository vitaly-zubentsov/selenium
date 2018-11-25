package ru.stqa.training.selenium.liteCart;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Task11RegistrationOfUserTest extends TestBase {
    @Test
    public void testRegistrationOfUserTest() {
        driver.findElement(By.cssSelector("[href *= create_account]")).click();
        actionWithDropDownList(By.cssSelector("select[name = country_code]"), "US");
        driver.findElement(By.cssSelector("[name=firstname]")).sendKeys("Test");
        driver.findElement(By.cssSelector("[name=lastname]")).sendKeys("Test");
        driver.findElement(By.cssSelector("[name=address1]")).sendKeys("Test");
        driver.findElement(By.cssSelector("[name=postcode]")).sendKeys("94102");
        driver.findElement(By.cssSelector("[name=city]")).sendKeys("Test");
        String uniqueEmail = getUniqueEmail();
        driver.findElement(By.cssSelector("[name=email]")).sendKeys(uniqueEmail);
        driver.findElement(By.cssSelector("[name=phone]")).sendKeys("124566");
        String password = "123456";
        driver.findElement(By.cssSelector("[name=password]")).sendKeys(password);
        driver.findElement(By.cssSelector("[name=confirmed_password]")).sendKeys(password);
        actionWithDropDownList(By.cssSelector("select[name = zone_code]"), "CA");
        driver.findElement(By.cssSelector("[name= create_account]")).click();

        driver.findElement(By.cssSelector("a[href*=logout")).click();

        driver.findElement(By.cssSelector("input[name=email]")).sendKeys(uniqueEmail);
        driver.findElement(By.cssSelector("input[name=password]")).sendKeys(password);
        driver.findElement(By.cssSelector("button[name=login]")).click();

        driver.findElement(By.cssSelector("a[href*=logout")).click();
    }

    private void actionWithDropDownList(By locatorOfDropDownList, String selectByValue) {
        WebElement webElementContainingDropDownList = driver.findElement(locatorOfDropDownList);
        Select select = new Select(webElementContainingDropDownList);
        select.selectByValue(selectByValue);
    }

    private String getUniqueEmail() {
        DateFormat dateFormat = new SimpleDateFormat("ddMMyyyyHHmmss");
        Date today = Calendar.getInstance().getTime();
        String uniqueEmail = dateFormat.format(today) + "@yandex.ru";
        return uniqueEmail;
    }
}

