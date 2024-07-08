package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPageObjects {

    WebDriver driver;

    public LandingPageObjects(WebDriver driver)
    {
        this.driver=driver;
    }

    By seacrhForItem = By.xpath("//input[@placeholder='Search for Vegetables and Fruits']");
    By prodNameInLandingPage = By.cssSelector(".product>h4");
    By addToCartButton = By.xpath("//button[contains(text(),'ADD TO CART')]");
    By proceedToCheckoutBtn = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
    By cartBag = By.cssSelector(".cart-icon>img");
    By topDeals = By.xpath("//a[@href='#/offers']");


    public void searchItem(String item)
    {
        driver.findElement(seacrhForItem).sendKeys(item);
    }

    public String prodNameInLandingPage()
    {
        String str = driver.findElement(prodNameInLandingPage).getText();
        str.trim().substring(0,6);
        return str.trim().substring(0,6);
    }

    public void clickOnAddToCartButton()
    {
        driver.findElement(addToCartButton).click();
    }
    public void clickOnCartBag()
    {
        driver.findElement(cartBag).click();
    }

    public void clickOnProceedToCheckoutBtn()
    {
        driver.findElement(proceedToCheckoutBtn).click();
    }

    public void clickOnTopDeals()
    {
        driver.findElement(topDeals).click();
    }
}
