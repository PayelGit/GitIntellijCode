package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CartPageObjects {

    public WebDriver driver;

    public CartPageObjects(WebDriver driver)
    {
        this.driver = driver;
    }


    By placeOrderButton = By.xpath("//button[contains(text(),'Place Order')]");
    By prodnameInCartPage = By.cssSelector("#productCartTables>tbody>tr>td:nth-child(2)>p");
    By checkbox = By.xpath("//input[@type='checkbox']");
    By proceedButton = By.xpath("//button[contains(text(),'Proceed')]");

    public void placeOrder()
    {
        driver.findElement(placeOrderButton).click();
    }

    public String productName()
    {
        String productNameCartPage =  driver.findElement(prodnameInCartPage).getText();
        return productNameCartPage;
    }
    public void checkbox()
    {
        driver.findElement(checkbox).click();
    }

    public void proceedToCart()
    {
        driver.findElement(proceedButton).click();
    }
}
