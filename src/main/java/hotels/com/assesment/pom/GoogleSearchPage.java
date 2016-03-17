package hotels.com.assesment.pom;

import hotels.com.assesment.driver.Browser;

/**
 * Created by ${Femi} on ${07/03/2016}.
 */
public class GoogleSearchPage {
    Browser browser;


    public GoogleSearchPage(Browser browser) {
        this.browser = browser;
    }


    public void navigateToGoogleSearchPage(){

        String url = "http://www.google.com";
        browser.getDriver().get(url);
    }

    public void inputIntoGoogleSearchBox(String input, String key){
        browser.mySendkeys(input, key);
    }


}
