package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pageObjects.CartPageObjects;
import pageObjects.LandingPageObjects;
import pageObjects.OfferPageObjects;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

public class OfferStepDefinitaions {

    WebDriver driver;
    WebDriverWait wait ;
    String onlyProdNameInProductListPage ;
    TestContextSetup testContextSetup;
    public OfferPageObjects offerPage;
    public LandingPageObjects landingPage;
    public OfferStepDefinitaions(TestContextSetup testContextSetup)
    {
        this.testContextSetup = testContextSetup;
    }


    @And ("user navigates to offer page and search the same product")
    public  void user_navigates_to_offer_page_and_search_the_same_product() throws InterruptedException {

        offerPage = new OfferPageObjects(testContextSetup.driver);
        landingPage = new LandingPageObjects(testContextSetup.driver);
        landingPage.clickOnTopDeals();
        switchToOfferPage();
        offerPage.searchByProductName("Tom");
        Thread.sleep(2000);
    }
    @Then ("user verifies the product in both pages")
    public void user_verifies_the_product_in_both_pages()
    {
        offerPage = new OfferPageObjects(testContextSetup.driver);
        landingPage = new LandingPageObjects(testContextSetup.driver);
        System.out.println(offerPage.verifyProdName());
        switchToOfferPage();
        switchToLandingPage();
        System.out.println(landingPage.prodNameInLandingPage());

//        Assert.assertEquals(offerPage.verifyProdName(),landingPage.prodNameInLandingPage());
    }


    public void switchToOfferPage()
    {
        Set<String> set = testContextSetup.driver.getWindowHandles();
        Iterator<String> itr = set.iterator();
        String parentWindow = itr.next();
        String childWindow = itr.next();
        testContextSetup.driver.switchTo().window(childWindow);
    }

    public void switchToLandingPage()
    {
        Set<String> set = testContextSetup.driver.getWindowHandles();
        Iterator<String> itr = set.iterator();
        String parentWindow = itr.next();
        String childWindow = itr.next();
        testContextSetup.driver.switchTo().window(parentWindow);
    }



}
