package ru.stqa.training.selenium.adminLiteCart;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import ru.stqa.training.selenium.adminLiteCart.data.CountriesData;

import java.util.ArrayList;
import java.util.List;


public class Task9SortOfCountryAndGeofence extends TestBase {

    @Test
    public void testAdminLogin() {
        driver.get(" http://localhost/litecart/admin/?app=countries&doc=countries");
        //int nuberOfCountries = driver.findElements(By.cssSelector("tr.row")).size();
       // String id = driver.findElement(By.cssSelector("tr.row")).findElements(By.cssSelector("td")).get(2).getText();
        List<CountriesData> ListOfCountries = getListOfCountries();
    }

    public List<CountriesData> getListOfCountries() {
        List<CountriesData> listOfCountries = new ArrayList<CountriesData>();
        List<WebElement> webElements = driver.findElements(By.cssSelector("tr.row"));
       for (WebElement webElement : webElements) {
        List <WebElement> listOfRowColumns = webElement.findElements(By.cssSelector("td"));
        int id = Integer.parseInt(listOfRowColumns.get(2).getText());
        String name = listOfRowColumns.get(4).getText();
        CountriesData countriesData = new CountriesData(id,name);
        listOfCountries.add(countriesData);
        }
        return listOfCountries;
    }
}
