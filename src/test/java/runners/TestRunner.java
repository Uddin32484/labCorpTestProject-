package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
features = {"src/test/resources/career.feature", "src/test/resources/api.feature"},
  //      features = "src/test/resources/api.feature",
        glue = "CareerStepDefination",                // ✅ your step def package
        plugin = {"pretty", "html:target/cucumber-report.html","io.qameta.allure.cucumber7jvm.AllureCucumber7Jvm"},
        monochrome = true
)
public class TestRunner extends AbstractTestNGCucumberTests {
}

//Note: This project was developed in just 3 hours. Given more time, I could have enhanced the framework further and added more assertions for comprehensive validation.

//Developed by: Yub Uddin
//Date: July 22, 2025
