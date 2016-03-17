package hotels.com.assesment.acmeCountryCucumberApiTest;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import hotels.com.assesment.acmeApi.country.AllCountry;
import hotels.com.assesment.acmeApi.country.SearchByIsoCode;

/**
 * Created by ${Femi} on ${07/03/2016}.
 */


public class CountryApiStepDefinitionTest {
    String url = "http://services.groupkt.com";
    AllCountry test = new AllCountry(url);
    SearchByIsoCode isocode = new SearchByIsoCode(url);
    private int wait = 200;

    @When("^the user requests resource \"([^\"]*)\"$")
    public void the_user_requests_resource(String resource) throws Throwable {
        Thread.sleep(wait);
        test.allCountryResponse(resource);
    }

    @And("^I validate alphacode assertions\"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void i_validate_alphacode_assertions(String resource, String alpha2_code1, String alpha3_code2) throws Throwable {
        Thread.sleep(wait);
        test.assertNAlphaCodeInAllCountry(resource, alpha2_code1, alpha3_code2);
    }

    @Then("^I validate name assertions \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void i_validate_name_assertions(String resource, String name1, String name2) throws Throwable {
        Thread.sleep(wait);
        test.assertNameInAllCountry(resource, name1, name2);
    }

    @And("^I validate message assertions \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void i_validate_message_assertions(String resource, String message1, String message2) throws Throwable {
        Thread.sleep(wait);
        test.assertPathForAllCountry(resource, message1, message2);
    }

    @Then("^I validate ISO name assertions \"([^\"]*)\" \"([^\"]*)\"$")
    public void i_validate_ISO_name_assertions(String resource, String name1) throws Throwable {
        Thread.sleep(wait);
        isocode.assertNameOfIsoCodeCountry(resource, name1);
    }

    @And("^I validate ISO alphacode assertions \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void i_validate_ISO_alphacode_assertions(String resource, String alpha2_code1, String alpha3_code2) throws Throwable {
        Thread.sleep(wait);
        isocode.assertNAlphaCodeOfIsoCodeCountry(resource, alpha2_code1, alpha3_code2);
    }

    @And("^I validate ISO message assertions \"([^\"]*)\" \"([^\"]*)\"$")
    public void i_validate_ISO_message_assertions(String resource, String message1) throws Throwable {
        Thread.sleep(wait);
        isocode.assertMessagePathForIsoCodeCountry(resource, message1);
    }

}
