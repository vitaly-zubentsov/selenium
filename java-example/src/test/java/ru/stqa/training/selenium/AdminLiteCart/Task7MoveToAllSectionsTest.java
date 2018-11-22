package ru.stqa.training.selenium.adminLiteCart;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class Task7MoveToAllSectionsTest extends TestBase {

    @Test
    public void testMoveToAllSection() {
        // логин в панель администратора реализован в фикстуре в классе TestBase
        int numberOfWebElementsFromLeftPanel = driver.findElements(By.cssSelector("li#app-")).size();
        for (int i = 0; i < numberOfWebElementsFromLeftPanel; i++) {
            List<WebElement> arrayOfWebElements = driver.findElements(By.cssSelector("Li#app-"));
            arrayOfWebElements.get(i).click();
            assertTrue(isElementsPresent(By.cssSelector("h1")));
            int numberOfIncludingWebElements = driver.findElements(By.cssSelector("[id ^= doc-]")).size();
            if (numberOfIncludingWebElements != 0) {
                for (int j = 1; j < numberOfIncludingWebElements; j++) {
                    List<WebElement> arrayOfIncludingWebElements = driver.findElements(By.cssSelector("[id ^= doc-]"));
                    arrayOfIncludingWebElements.get(j).click();
                    assertTrue(isElementsPresent(By.cssSelector("h1")));
                }
            }
        }
    }

    private boolean isElementsPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

}

