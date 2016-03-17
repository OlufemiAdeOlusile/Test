package hotels.com.assesment.pom;

import hotels.com.assesment.driver.Browser;

/**
 * Created by ${Femi} on ${07/03/2016}.
 */
public class GoogleListPage {
    public GoogleListPage(Browser browser) {
        this.browser = browser;
    }

    Browser browser;


    public void inputIntoGoogleSearchBox(String input){
        browser.getAllElement(input).click();
    }
}
