package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.CartPageObjects;
import utils.TestContextSetup;

import java.time.Duration;



public class CartPageStepDefinitions {


    WebDriver driver;
    WebDriverWait wait ;
    String onlyProdNameInCartPage ;
    String onlyProdNameInProductListPage ;
    TestContextSetup testContextSetup;
    CartPageObjects cartPage;
    public CartPageStepDefinitions(TestContextSetup testContextSetup)
    {
        this.testContextSetup = testContextSetup;
    }




    @Then("user verifies the product")
    public void user_verifies_the_product()
    {
        wait = new WebDriverWait(testContextSetup.driver, Duration.ofSeconds(15l));
        cartPage = new CartPageObjects(testContextSetup.driver);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Place Order')]")));
        String cartPageURL = "https://rahulshettyacademy.com/seleniumPractise/#/cart";
        Assert.assertEquals(testContextSetup.driver.getCurrentUrl(), cartPageURL);
        String prodNameInCartPage = cartPage.productName();
        System.out.println(prodNameInCartPage);
        String afterTrimmedProdName = prodNameInCartPage.trim();
        testContextSetup.onlyProdNameInCartPage = afterTrimmedProdName.substring(0, 6);
        System.out.println(onlyProdNameInCartPage);
        Assert.assertEquals(onlyProdNameInProductListPage, onlyProdNameInCartPage);
    }

    @And("user places an order")
    public void user_places_an_order()
    {
        cartPage = new CartPageObjects(testContextSetup.driver);
        wait = new WebDriverWait(testContextSetup.driver, Duration.ofSeconds(15l));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Place Order')]")));
        cartPage.placeOrder();


        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'Proceed')]")));
        cartPage.checkbox();
        //        Select sel = new Select();
//        sel.selectByVisibleText("India");
        cartPage.proceedToCart();




    }
}
