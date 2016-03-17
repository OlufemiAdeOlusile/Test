package hotels.com.assesment.pom;

import hotels.com.assesment.driver.Browser;

/**
 * Created by ${Femi} on ${07/03/2016}.
 */
public class SeleniumWebdriverPage {


    Browser browser;


    public SeleniumWebdriverPage(Browser browser) {
        this.browser = browser;
    }

    public void clickOnAnItemInSeleniumPage(String input) {
        browser.getAllElement(input).click();
    }

}
