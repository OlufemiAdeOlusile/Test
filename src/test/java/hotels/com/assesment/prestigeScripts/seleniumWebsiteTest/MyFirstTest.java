package hotels.com.assesment.prestigeScripts.seleniumWebsiteTest;

import hotels.com.assesment.suiteBase.BaseTest;
import hotels.com.assesment.driver.DriverManager;
import hotels.com.assesment.driver.Browser;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;


public class MyFirstTest extends BaseTest {

    Browser browser = DriverManager.getinstance();

    public static final int waittime = 6;

    @Test
    public void MyFirstTestMethod() {

        String url = "http://www.google.co.uk";
        String googleBoxKey = "lst-ib";
        String inputGoogleBoxText = "Selenium WebDriver";
        String documentationText = "Documentation";
        String selKey = "#selenium-documentation > div:nth-child(3) > ul > li:nth-child(3) > ul > li:nth-child(2) > a";
        String expectedResult = "http://www.seleniumhq.org/docs/04_webdriver_advanced.jsp#explicit-and-implicit-waits";

        browser.getDriver().get(url);

        browser.waitHTMLID(googleBoxKey);

        browser.mySendkeys(inputGoogleBoxText, googleBoxKey);

        browser.waitHTMLLinkedText(inputGoogleBoxText);

        browser.getAllElement(inputGoogleBoxText).click();

        browser.waitHTMLLinkedText(documentationText);

        browser.getAllElement(documentationText).click();

        browser.waitHTMLCSS(selKey);

        browser.getAllElement("Explicit and Implicit Waits").click();

        browser.waitSeconds(waittime);


        Assert.assertEquals(expectedResult,
                browser.getDriver().getCurrentUrl());

        Reporter.log("First Test Passed", true);
    }
}
