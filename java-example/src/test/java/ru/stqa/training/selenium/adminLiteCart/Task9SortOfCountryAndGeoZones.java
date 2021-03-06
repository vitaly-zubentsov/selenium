package ru.stqa.training.selenium.adminLiteCart;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static junit.framework.TestCase.assertEquals;


public class Task9SortOfCountryAndGeoZones extends TestBase {

    @Test
    public void testSortOfCountryAndGeoZones() {

        driver.get("http://localhost/litecart/admin/?app=countries&doc=countries");
        List<String> listOfCountries = getListOfNameForCountries();
        List<String> listOfSortCountries = new ArrayList<String>(listOfCountries);
        listOfSortCountries.sort(Comparator.<String, String>comparing(String::toString));
        assertEquals(listOfCountries, listOfSortCountries);

        List<WebElement> listOfRowForCountries = driver.findElements(By.cssSelector("tr.row"));
        int numberOfZonesForCountry;
        WebElement rowForCountry;
        for (int i = 0; i < listOfRowForCountries.size(); i++) {
            rowForCountry = listOfRowForCountries.get(i);
            numberOfZonesForCountry = Integer.parseInt(rowForCountry.findElements(By.cssSelector("td")).get(5).getText());
            if (numberOfZonesForCountry > 0) {
                rowForCountry.findElement(By.cssSelector("td a")).click();
                List<String> listOfZones = getListOfZonesForCountry();
                List<String> listOfSortZones = new ArrayList<String>(listOfZones);
                listOfSortZones.sort(Comparator.<String, String>comparing(String::toString));
                assertEquals(listOfZones, listOfSortZones);
                driver.findElement(By.cssSelector("li#app-.selected")).click();
                listOfRowForCountries = driver.findElements(By.cssSelector("tr.row"));

            }

        }

        driver.get("http://localhost/litecart/admin/?app=geo_zones&doc=geo_zones");
        List<WebElement> listOfRowForGeoZones = driver.findElements(By.cssSelector("tr.row"));
        for (int i = 0; i < listOfRowForGeoZones.size(); i++) {
            listOfRowForGeoZones.get(i).findElement(By.cssSelector("td a")).click();
            List<String> listOfZones = getListOfZonesForGeoZones();
            List<String> listOfSortZones = new ArrayList<String>(listOfZones);
            listOfSortZones.sort(Comparator.<String, String>comparing(String::toString));
            assertEquals(listOfZones, listOfSortZones);
            driver.findElement(By.cssSelector("li#app-.selected")).click();
            listOfRowForGeoZones = driver.findElements(By.cssSelector("tr.row"));
        }

    }


}
