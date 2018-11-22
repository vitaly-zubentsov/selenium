package ru.stqa.training.selenium.adminLiteCart;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;


public class Task9SortOfCountryAndGeofence extends TestBase {

    @Test
    public void testAdminLogin() {
        driver.get(" http://localhost/litecart/admin/?app=countries&doc=countries");
        List<String> listOfCountries = getListOfNameForCountries();
        List<String> listOfSortCountries = new ArrayList<String>(listOfCountries);
        listOfSortCountries.sort(Comparator.<String, String>comparing(String::toString));
        assertEquals(listOfCountries,listOfSortCountries);

        driver.findElements()
    }


    public List<String> getListOfNameForCountries() {
        List<String> listOfCountries = new ArrayList<String>();
        List<WebElement> webElements = driver.findElements(By.cssSelector("tr.row"));
        for (WebElement webElement : webElements) {
            String name = webElement.findElements(By.cssSelector("td")).get(4).getText();
            listOfCountries.add(name);
        }
        return listOfCountries;
    }
}
