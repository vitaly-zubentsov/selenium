package ru.stqa.training.selenium.PageObjects;

import org.junit.Test;
import org.openqa.selenium.By;

public class Task13WorkingWithCartTest extends TestBase {

    @Test
    public void testWorkingWithCart() {

        for (int i = 1; i <= 3; i++) {
            app.addOneProductToCart(By.cssSelector(".product"), "Medium");
        }
        app.goToCart();
        for (int i = 1; i <= 3; i++) {
            app.deleteOneProductFromCart();
        }
    }

}
