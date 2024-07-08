package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.TestContextSetup;

import java.io.File;
import java.io.IOException;

public class Hooks {
    TestContextSetup testContextSetup;
    WebDriver driver;

    public Hooks(WebDriver driver)
    {
        this.driver = driver;
    }
    @After
    public void AfterScenario()
    {
        driver.quit();
    }
    @AfterStep
    public void AddScreenshot(Scenario scenario) throws IOException {
//       WebDriver driver= testContextSetup.testBase.WebDriverManager();
        if(scenario.isFailed())
        {
            File sourcePath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(sourcePath);
            scenario.attach(fileContent,"image/png", "image");

        }
    }
}
