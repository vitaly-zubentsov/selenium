package ru.stqa.training.selenium.pageObjects.tests;

import org.junit.Test;

public class Task19WorkingWithCartTest extends TestBase {

    @Test
    public void testWorkingWithCart() {

        for (int i = 1; i <= 3; i++) {
            app.addOneProductToCart("Medium");
        }
        app.goToCart();
        for (int i = 1; i <= 3; i++) {
            app.deleteOneProductFromCart();
        }
    }

}
