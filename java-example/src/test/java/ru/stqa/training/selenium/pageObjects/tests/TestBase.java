package ru.stqa.training.selenium.pageObjects.tests;

import org.junit.After;
import org.junit.Before;
import ru.stqa.training.selenium.pageObjects.app.Application;

public class TestBase {

    protected final Application app = new Application();

    @Before
    public void start() {
        app.initDriverAndOpenStartPage();
    }

    @After
    public void stop() {
        app.stopDriver();
    }


}
