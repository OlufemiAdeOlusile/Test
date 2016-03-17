package hotels.com.assesment.acmeCountryCucumberApiTest;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import hotels.com.assesment.hotelsApp.App;
import org.junit.runner.RunWith;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Created by ${Femi} on ${07/03/2016}.
 */

@RunWith(Cucumber.class)
@CucumberOptions(
        monochrome = true,
        features = "src/resources/acmeFeatures/CountryApi.feature",
        plugin = {"pretty", "html:target/cucumber-html-report"},
        tags = " @ACMEExpediaAPI"
)


public class CountryApiRunnerTest extends AbstractTestNGCucumberTests {

        private App app;

        @BeforeClass
        public void setupTimer(){
                app = new App();
                app.start();
        }

        @AfterClass
        public void printTimer(){
                app.end();
                Reporter.log("Total time " + app.getTotalTime() + " in seconds", true);
        }

}
