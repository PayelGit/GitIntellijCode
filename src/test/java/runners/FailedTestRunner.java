package runners;

import io.cucumber.testng.CucumberOptions;


@CucumberOptions(features = "src/test/java/features", glue="stepDefinitions", monochrome = true, tags = "@TC_01 or @TC_02",
        plugin = {"html:target/cucumber.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
               })

public class FailedTestRunner {
}
