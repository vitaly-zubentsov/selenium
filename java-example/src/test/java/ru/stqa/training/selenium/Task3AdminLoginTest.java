package ru.stqa.training.selenium;

import org.junit.Test;
import org.openqa.selenium.By;

public class Task3AdminLoginTest extends TestBase {

    @Test
    public void testAdminLogin() {
        driver.get("http://localhost/litecart/admin/login.php");
        driver.findElement(By.name("username")).sendKeys("admin");
        driver.findElement(By.name("password")).sendKeys("admin");
        driver.findElement(By.name("login")).click();
}
}
