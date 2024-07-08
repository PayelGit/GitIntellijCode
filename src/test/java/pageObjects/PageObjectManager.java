package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {

    WebDriver driver;
    LandingPageObjects landingPage;
    CartPageObjects cartPage;

    PageObjectManager(WebDriver driver)
    {
        this.driver=driver;
    }

    public LandingPageObjects getLandingPage()
    {
        landingPage = new LandingPageObjects(driver);
        return landingPage;
    }

    public CartPageObjects getCartPage()
    {
        cartPage = new CartPageObjects(driver);
        return cartPage;
    }
}
