package hotels.com.assesment.acmeCountryDataProviderApiTest;

import org.testng.annotations.DataProvider;

/**
 * Created by ${Femi} on ${07/03/2016}.
 */
public class CountryDataProvider {

    @DataProvider(name = "names")
    public static Object[][] names() {
        return new Object[][]{
                {"/country/get/all", "Afghanistan", "Anguilla"},
                {"/country/get/all", "China", "Jamaica"}};
    }

    @DataProvider(name = "alphacodes")
    public static Object[][] alphacodes() {
        return new Object[][]{
                {"/country/get/all", "IQ", "IMN"},
                {"/country/get/all", "JP", "KEN"}};
    }
}
