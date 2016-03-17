package hotels.com.assesment.suiteBase;

import hotels.com.assesment.hotelsApp.App;
import hotels.com.assesment.driver.DriverListener;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;

/**
 * Created by Femi on 07/03/2016.
 */

@Listeners(value= DriverListener.class)
public class BaseTest {

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
