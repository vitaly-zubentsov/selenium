package ru.stqa.training.selenium.adminLiteCart;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntry;

import java.util.List;

public class Task17MessagesInLogsOfBrowserTest extends TestBase {

    @Test
    public void testMessagesInLogsOfBrowser() {
        driver.get("http://localhost/litecart/admin/?app=catalog&doc=catalog&category_id=1");
        List<WebElement> listOfProduct = driver.findElements(By.cssSelector(".dataTable [href *= product]:nth-child(2)"));

        for (int i = 0; i < listOfProduct.size(); i++) {
            driver.findElements(By.cssSelector(".dataTable [href *= product]:nth-child(2)")).get(i).click();
            for (LogEntry l : driver.manage().logs().get("browser").getAll()) {
                System.out.println("Логи при открытии страницы с товаром №" + String.valueOf(i + 1));
                System.out.println(l);
            }
            driver.navigate().back();

        }


    }
}
