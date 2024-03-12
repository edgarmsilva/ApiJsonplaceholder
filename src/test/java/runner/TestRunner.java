package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)

@CucumberOptions(

        plugin = {"usage:target/usage",
                "pretty",
                "summary",
                "html:target/report/index.html"}
        , features = {"src/test/resources/features/"}
        , glue = {"stepDefinitions"}
//        , tags = "@testes"
)

public class TestRunner {

}
