package ru.stqa.training.selenium.adminLiteCart;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.training.selenium.adminLiteCart.data.CountriesData;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;


public class Task9SortOfCountryAndGeofence extends TestBase {

    @Test
    public void testAdminLogin() {
        driver.get(" http://localhost/litecart/admin/?app=countries&doc=countries");
        List<CountriesData> listOfCountries = getListOfNameForCountries();
        List<CountriesData> listOfSortCountries = new ArrayList<CountriesData>(listOfCountries);

      // listOfSortCountries.sort(Comparator.<String, String>comparing(String::toString));
        assertEquals(listOfCountries,listOfSortCountries);

        //driver.findElements()
    }


    public List<CountriesData> getListOfNameForCountries() {
        List<CountriesData> listOfCountries = new ArrayList<CountriesData>();
        List<WebElement> webElements = driver.findElements(By.cssSelector("tr.row"));
        for (WebElement webElement : webElements) {
            String s = webElement.findElements(By.cssSelector("td")).get(5).getText();
            int numberOfzones = Integer.getInteger(s);
            String name = webElement.findElements(By.cssSelector("td")).get(4).getText();
            CountriesData countriesData = new CountriesData(numberOfzones, name);
            listOfCountries.add(countriesData);
        }
        return listOfCountries;
    }
}
