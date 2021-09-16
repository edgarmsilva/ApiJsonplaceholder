package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(

        plugin = {"usage:target/usage", "pretty", "summary",
                "json:target/cucumber.json",
                "html:target/html/cucumber-report.html",
                "junit:target/cucumber-reports/Cucumber.xml"}
        , features = {"src/test/resources/features/"}
        , glue = {"stepDefinitions"}
        , monochrome = false
        , publish = false
//        , tags = "@test"
)

public class TestRunner {

}
