package ru.stqa.training.selenium.liteCart;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertTrue;

public class Task10ProductOpenPageTest extends TestBase {
    @Test
    public void testCheckForStickers() {
        WebElement checkingProduct = driver.findElement(By.cssSelector("#box-campaigns .product.column.shadow.hover-light"));
        String nameOfProduct = checkingProduct.findElement(By.cssSelector("div.name")).getText();
        List<String> PricesOfProduct = getPricesList(checkingProduct, By.cssSelector("div > [class *= price]"));
        if (PricesOfProduct.size() == 2) {
            comparisonOfValuesForPrices(By.cssSelector("#box-campaigns .product.column.shadow.hover-light [class = regular-price]"), By.cssSelector("#box-campaigns .product.column.shadow.hover-light [class = campaign-price]"));
        }
        checkingProduct.click();

        String nameOfProductNewPage = driver.findElement(By.cssSelector("h1.title")).getText();
        WebElement webElementContainsPrices = driver.findElement(By.cssSelector("div.information div.price-wrapper"));
        List<String> PricesOfProductNewPage = getPricesList(webElementContainsPrices, By.cssSelector("[class *= price]"));
        if (PricesOfProductNewPage.size() == 2) {
            comparisonOfValuesForPrices(By.cssSelector("div.information div.price-wrapper [class = regular-price]"), By.cssSelector("div.information div.price-wrapper [class = campaign-price]"));
        }
        assertTrue(nameOfProduct.equals(nameOfProductNewPage));
        assertTrue(PricesOfProduct.equals(PricesOfProductNewPage));
    }

    private void comparisonOfValuesForPrices(By locatorForRegularPrice, By locatorForCampaignPrice) {
        WebElement webElementForRegularPrice = driver.findElement(locatorForRegularPrice);
        String textDecorationLineOfRegularPrice = webElementForRegularPrice.getAttribute("tagName");
        String colorOfRegularPrice = webElementForRegularPrice.getCssValue("color");
        double fontsizeOfRegularPrice = Double.parseDouble(webElementForRegularPrice.getCssValue("font-size").replace("px", ""));


        assertTrue(textDecorationLineOfRegularPrice.equals("S"));
        assertTrue(colorIsGrey(colorOfRegularPrice));

        WebElement webElementForCampaignPrice = driver.findElement(locatorForCampaignPrice);
        String fontWeightOfCampaignPrice = webElementForCampaignPrice.getAttribute("tagName");
        String colorOfCampaignPrice = webElementForCampaignPrice.getCssValue("color");
        double fontsizeOfCampaignPrice = Double.parseDouble(webElementForCampaignPrice.getCssValue("font-size").replace("px", ""));

        assertTrue(fontWeightOfCampaignPrice.equals("STRONG"));
        assertTrue(colorIsRed(colorOfCampaignPrice));

        assertTrue(fontsizeOfCampaignPrice > fontsizeOfRegularPrice);
    }

    private boolean colorIsRed(String color) {
        String[] numbers = color.replaceAll("[a-z]", "").replaceAll("[-()]", "").split(",");
        int r = Integer.parseInt(numbers[0].trim());
        int g = Integer.parseInt(numbers[1].trim());
        int b = Integer.parseInt(numbers[2].trim());
        if ((r != 0) & (g == 0) & (b == 0)) {
            return true;
        } else {
            return false;
        }
    }

    private boolean colorIsGrey(String color) {
        String[] numbers = color.replaceAll("[a-z]", "").replaceAll("[-()]", "").split(",");
        int r = Integer.parseInt(numbers[0].trim());
        int g = Integer.parseInt(numbers[1].trim());
        int b = Integer.parseInt(numbers[2].trim());
        if ((r == g) & (g == b)) {
            return true;
        } else {
            return false;
        }
    }

    private List<String> getPricesList(WebElement webElementContainingPrices, By locator) {
        List<String> listOfPrices = new ArrayList<String>();
        List<WebElement> webElementsContainingPrice = webElementContainingPrices.findElements(locator);
        for (WebElement webElementContainingPrice : webElementsContainingPrice) {
            String price = webElementContainingPrice.getText();
            listOfPrices.add(price);
        }
        return listOfPrices;
    }
}
