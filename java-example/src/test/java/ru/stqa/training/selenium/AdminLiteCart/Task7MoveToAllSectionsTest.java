package ru.stqa.training.selenium.AdminLiteCart;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Task7MoveToAllSectionsTest extends TestBase {

    @Test
    public void testMoveToAllSection() {
        int numberOfWebElementsFromLeftPanel = driver.findElements(By.cssSelector("li#app-")).size();
        for (int i=0; i<numberOfWebElementsFromLeftPanel; i++) {
            List <WebElement> arrayOfWebElements = driver.findElements(By.cssSelector("Li#app-"));
            arrayOfWebElements.get(i).click();
            //Проверка тега driver.findElements(By.cssSelector("h1"))
            int numberOfIncludingWebElements = driver.findElements(By.cssSelector("[id ^= doc-]")).size();
            if (numberOfIncludingWebElements != 0) {
                for (int j=1; j<numberOfIncludingWebElements; j++){ // - 1 так как при открытии проверяется первый!!!!
                    List <WebElement> arrayOfIncludingWebElements = driver.findElements(By.cssSelector("[id ^= doc-]"));
                    arrayOfIncludingWebElements.get(j).click();
                    //Проверка тега
                }
            }



        }



    }
}
