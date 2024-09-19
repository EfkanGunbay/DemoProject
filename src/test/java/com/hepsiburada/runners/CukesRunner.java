package com.hepsiburada.runners;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import com.hepsiburada.utilities.Driver;
import java.util.concurrent.TimeUnit;
import com.hepsiburada.utilities.ConfigReader;


@CucumberOptions(
        plugin ={"pretty","html:target/cucumber.html","json:target/cucumber.json"},
        glue = "com/hepsiburada/step_definitions",
        features = "src/test/resources/Features",
        publish = true,
        tags="@Login"
)
public class CukesRunner extends AbstractTestNGCucumberTests {


}
