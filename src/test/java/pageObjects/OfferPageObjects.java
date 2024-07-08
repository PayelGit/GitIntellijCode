package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.Iterator;
import java.util.Set;

public class OfferPageObjects {

    public WebDriver driver;
    public OfferPageObjects (WebDriver driver)
    {
        this.driver = driver;
    }

    By searchByProductName = By.xpath("//input[@type='search']");
    By prodNameFromOfferPage = By.cssSelector(".table.table-bordered>tbody>tr>td:nth-child(1)");


    public void searchByProductName(String str)
    {
//        Actions act = new Actions(driver);
//        act.moveToElement(driver.findElement(searchByProductName)).sendKeys(str).build().perform();
        driver.findElement(searchByProductName).sendKeys(str);
    }

    public String verifyProdName()
    {
        String str = driver.findElement(prodNameFromOfferPage).getText();
        return str;
    }


}
