package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pageObjects.LandingPageObjects;
import utils.TestContextSetup;

import java.time.Duration;


public class LandingPageStepDefinitions {

    WebDriver driver;
    WebDriverWait wait ;
    String onlyProdNameInCartPage ;
    String onlyProdNameInProductListPage ;
    TestContextSetup testContextSetup;

    LandingPageObjects landingPage;

    public LandingPageStepDefinitions(TestContextSetup testContextSetup)
    {
        this.testContextSetup = testContextSetup;
    }
    @Given("user is in SeleniumPractice page")
    public void user_is_in_seleniumpractice_page()
    {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//target//chromedriver.exe");
        testContextSetup.driver = new ChromeDriver();
        testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        testContextSetup.driver.manage().window().maximize();
    }
    @When("user searches for a product")
    public void user_searches_for_a_product() throws InterruptedException {
        landingPage = new LandingPageObjects(testContextSetup.driver);
        landingPage.searchItem("Tom");
        Thread.sleep(2000);
        String productName = landingPage.prodNameInLandingPage();
        System.out.println(productName);
        testContextSetup.onlyProdNameInProductListPage = productName.substring(0, 6);
        System.out.println(onlyProdNameInProductListPage);
        String searchedProduct = "Tom";
//        if(searchedProduct.contains(onlyProdNameInProductListPage))
//        {
//            System.out.println("Searched product found");
//        }
//

    }
    @And("user process to checkout")
    public void user_proccess_to_checkout()
    {
        landingPage = new LandingPageObjects(testContextSetup.driver);
        wait = new WebDriverWait(testContextSetup.driver, Duration.ofSeconds(15l));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".cart-icon>img"))).isDisplayed();
        landingPage.clickOnAddToCartButton();
        landingPage.clickOnCartBag();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]")));
        landingPage.clickOnProceedToCheckoutBtn();

    }





    /* Google timer
    @Given("user is in google page")
    public void user_is_in_google_page()
    {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//target//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.google.com/");
    }
    @When("user starts the stopwatch")
    public void user_starts_the_stopwatch() throws InterruptedException {
        driver.findElement(By.xpath("//textarea[@title='Search']")).sendKeys("timer", Keys.ENTER);
        Thread.sleep(5000);
//        wait.until(ExpectedConditions.elementToBeClickable( driver.findElement(By.cssSelector(".act-hide.act-tim-pause-lbl"))));
//        driver.findElement(By.cssSelector(".act-hide.act-tim-pause-lbl")).click();
//        Thread.sleep(2000);
        String timer = driver.findElement(By.cssSelector("#act-timer-section > div > div.act-tim-txt-cnt > div")).getText();
        System.out.print(timer);


        /*click on stopwatch*/
//        driver.findElement(By.cssSelector(".act-tab-ul>li:nth-child(2)>a>span:nth-child(3)")).click();
//        driver.quit();



    @Given("user is in emails extractor page")
    public void user_is_in_emails_extractor_page()
    {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"//target//chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.convertcsv.com/email-extractor.htm");
        driver.manage().window().maximize();
    }
    @When("user chooses file for email extraction")
    public void user_chooses_file_for_email_extraction() throws InterruptedException {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("#frm1>h3:nth-child(3)")));
        wait = new WebDriverWait(driver, Duration.ofSeconds(15l));
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector("#fileTabLink"))));
        driver.findElement(By.cssSelector("#fileTabLink")).click();
//        String uploadFile = System.getProperty("user.dir")+"\\target\\3-6 Years - 28-June";
        driver.findElement(By.cssSelector("#f1")).sendKeys("C:\\Users\\Payel\\Downloads\\3-6 Years - 02-July.pdf");
    }
    @And ("user extract the emails and copies it")
    public void user_extract_the_emails_and_copies_it()
    {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);", driver.findElement(By.cssSelector("#frm1 > h3:nth-child(13)")));
        driver.findElement(By.cssSelector("#btnRun")).click();
        WebElement ele = driver.findElement(By.xpath("//button[@title='Copy Result to Clipboard']"));
        ele.click();
        String str = driver.findElement(By.cssSelector("#txta")).getText();
        System.out.println(str);
    }

}



