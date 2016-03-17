package hotels.com.assesment.prestigeScripts.seleniumWebsiteTest;

import hotels.com.assesment.pom.SeleniumWebdriverPage;
import hotels.com.assesment.pom.GoogleListPage;
import hotels.com.assesment.pom.GoogleSearchPage;
import hotels.com.assesment.suiteBase.BaseTest;
import hotels.com.assesment.driver.DriverManager;
import hotels.com.assesment.driver.Browser;
import org.junit.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

/**
 * Created by ${Femi} on ${07/03/2016}.
 */
public class MySecondTest extends BaseTest {

    Browser browser = DriverManager.getinstance();
    GoogleListPage googlelist =  new GoogleListPage(browser);
    GoogleSearchPage googlesearch = new GoogleSearchPage(browser);
    SeleniumWebdriverPage seleniumpage = new SeleniumWebdriverPage(browser);

    public static final int waittime = 6;

    @Test
    public void MySecondTestMethod() {

        String googleBoxKey = "gsfi";
        String inputGoogleBoxText = "Selenium WebDriver";
        String documentationText = "Documentation";
        String selKey = "#selenium-documentation > div:nth-child(3) > ul > li:nth-child(3) > ul > li:nth-child(2) > a";


        googlesearch.navigateToGoogleSearchPage();

        browser.waitHTMLClass(googleBoxKey);

        googlesearch.inputIntoGoogleSearchBox(inputGoogleBoxText, googleBoxKey);

        browser.waitHTMLLinkedText(inputGoogleBoxText);

        googlelist.inputIntoGoogleSearchBox(inputGoogleBoxText);

        browser.waitHTMLLinkedText(documentationText);

        seleniumpage.clickOnAnItemInSeleniumPage(documentationText);

        browser.waitHTMLCSS(selKey);

        browser.getAllElement("Explicit and Implicit Waits").click();

        browser.waitSeconds(waittime);

        String expectedResult = "http://www.seleniumhq.org/docs/04_webdriver_advanced.jsp#explicit-and-implicit-waits";
        Assert.assertEquals(expectedResult,
                browser.getDriver().getCurrentUrl());

        Reporter.log("Second Test Passed", true);
    }
}
