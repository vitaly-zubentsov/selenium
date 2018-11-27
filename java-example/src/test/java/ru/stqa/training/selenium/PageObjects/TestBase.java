package ru.stqa.training.selenium.PageObjects;

import org.junit.After;
import org.junit.Before;

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
