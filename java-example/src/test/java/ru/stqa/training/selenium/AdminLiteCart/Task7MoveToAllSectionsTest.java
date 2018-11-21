package ru.stqa.training.selenium.AdminLiteCart;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Task7MoveToAllSectionsTest extends TestBase {

    @Test
    public void testMoveToAllSection() {
        int size = driver.findElements(By.cssSelector("li#app-")).size();
        for (int i=0; i<size; i++) {
            List <WebElement> arrayOfWebElements = driver.findElements(By.cssSelector("Li#app-"));
            arrayOfWebElements.get(i).click();
            

        }



    }
}
