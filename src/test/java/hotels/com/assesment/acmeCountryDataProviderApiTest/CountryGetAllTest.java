package hotels.com.assesment.acmeCountryDataProviderApiTest;

import hotels.com.assesment.acmeApi.country.AllCountry;
import hotels.com.assesment.suiteBase.BaseTest;
import org.testng.annotations.Test;

/**
 * Created by ${Femi} on ${07/03/2016}.
 */
public class CountryGetAllTest extends BaseTest {

    String url = "http://services.groupkt.com";
    AllCountry allcountry = new AllCountry(url);


    @Test(dataProvider = "names", dataProviderClass = CountryDataProvider.class)
    public void assertCountryNamesInAllCountry(String response, String name1, String name2) {
        allcountry.assertNameInAllCountry(response, name1, name2);
    }


    @Test(dataProvider = "alphacodes", dataProviderClass = CountryDataProvider.class)
    public void assertAlphaCodeInAllCountry(String response, String alpha2_code, String alpha3_code){
        allcountry.assertNAlphaCodeInAllCountry(response, alpha2_code, alpha3_code);
    }


}
