package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(features = "src/test/java/features", glue="stepDefinitions", monochrome = true, tags = "@TC_01 or @TC_02",
plugin = {"html:target/cucumber.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
"rerun:target/Failed.txt"})
public class testRunner extends AbstractTestNGCucumberTests
{
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios()
    {
        return super.scenarios();
    }



}
