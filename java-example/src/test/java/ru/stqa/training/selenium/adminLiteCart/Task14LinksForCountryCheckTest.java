package ru.stqa.training.selenium.adminLiteCart;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;
import java.util.Set;

public class Task14LinksForCountryCheckTest extends TestBase {

    @Test
    public void testLinksForCountryCheck() {
        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        driver.findElement(By.cssSelector("tr.row a")).click();
        List<WebElement> listOfLinks = driver.findElements(By.cssSelector(".fa-external-link"));
        for (WebElement webElementWithLink : listOfLinks) {
            linkCheck(webElementWithLink);
        }

    }

    private void linkCheck(WebElement webElementWithLink) {
        String oldWindow = driver.getWindowHandle();
        Set<String> oldWindows = driver.getWindowHandles();
        webElementWithLink.click();
        Set<String> newWindows = driver.getWindowHandles();
        newWindows.removeAll(oldWindows);
        String newWindow = newWindows.toString().replace("[", "").replace("]", "");
        wait.until(ExpectedConditions.numberOfWindowsToBe(oldWindows.size() + 1));
        driver.switchTo().window(newWindow);
        driver.close();
        driver.switchTo().window(oldWindow);
    }


}






