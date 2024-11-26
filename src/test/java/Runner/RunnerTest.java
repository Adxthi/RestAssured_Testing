package Runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/java/Features/",
        glue = "StepDefinition",
        //tags = "@Delete",
        plugin = {
                "pretty", // Prints the results to the console
                "html:target/Destination/html", // Generates HTML report
                "json:target/Destination/Json" ,// Generates JSON report
                "junit:target/Destination/cucumber.xml"
        },
        monochrome = true,
        dryRun = false)
public class RunnerTest {
}
