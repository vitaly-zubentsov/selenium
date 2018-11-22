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
       /* List<String> listOfCountries = getListOfNameForCountries();
        List<String> listOfSortCountries = new ArrayList<String>(listOfCountries);
        listOfSortCountries.sort(Comparator.<String, String>comparing(String::toString));
        assertEquals(listOfCountries,listOfSortCountries);*/

        List<WebElement> webElements = driver.findElements(By.cssSelector("tr.row"));
        int numberOfZones;
        for (WebElement webElement : webElements) {

            numberOfZones = Integer.parseInt(webElement.findElements(By.cssSelector("td")).get(5).getText());
            if ( numberOfZones > 0) {
                webElement.findElement(By.cssSelector("td a")).click();
                List<String> listOfZones = getListOfZonesForCountry();
                List<String> listOfSortZones = new ArrayList<String>(listOfZones);
                listOfSortZones.sort(Comparator.<String, String>comparing(String::toString));
                assertEquals(listOfZones,listOfSortZones);
                driver.get(" http://localhost/litecart/admin/?app=countries&doc=countries");
            }

        }
    }

    private List<String> getListOfZonesForCountry() {
        List<String>  listOfZones = new ArrayList<String>();
        List<WebElement> webElementsofzones = driver.findElements(By.cssSelector("[type*=hidden][name *= name ]"));
        for (WebElement webElement : webElementsofzones) {
            String name = webElement.getAttribute("value");
            listOfZones.add(name);
        }
        return listOfZones;
    }


    public List<String> getListOfNameForCountries() {
        List<String> listOfCountries = new ArrayList<String>();
        List<WebElement> webElements = driver.findElements(By.cssSelector("tr.row"));
        for (WebElement webElement : webElements) {
            String name = webElement.findElement(By.cssSelector("a")).getText();
            listOfCountries.add(name);
        }
        return listOfCountries;
    }
}
