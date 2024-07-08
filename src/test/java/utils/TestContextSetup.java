package utils;

import org.openqa.selenium.WebDriver;
import pageObjects.PageObjectManager;

public class TestContextSetup {
    public WebDriver driver;
    public String onlyProdNameInCartPage ;
    public String onlyProdNameInProductListPage ;
    public  TestContextSetup testBase;
    public PageObjectManager pageObjManager;
    public GenericUtils genericUtils;
    public TestContextSetup()
    {
//            testBase = new TestContextSetup();
//        pageObjManager = new PageObjectManager(testBase.WebDriverManager());
//        genericUtils = new GenericUtils(testBase.WebDriverManager());

    }
}
