package hotels.com.assesment.acmeApi.country;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;
import org.junit.Test;
import org.testng.Assert;
import org.testng.Reporter;

import java.util.ArrayList;
import java.util.List;

import static com.jayway.restassured.RestAssured.given;
import static com.jayway.restassured.RestAssured.when;

import static org.hamcrest.Matchers.*;

/**
 * Created by ${Femi} on ${07/03/2016}.
 */

public class AllCountry {



    String url = "http://services.groupkt.com";

    public AllCountry(String url) {
        this.url = url;
    }


    public Response allCountryResponse(String response) {
        RestAssured.baseURI = url;
        return when().
                get(response);

    }



    public ValidatableResponse assertNameInAllCountry(String request, String name1, String name2) {

        return allCountryResponse(request)
                .then().
                        body("", is(notNullValue())).
                        body("RestResponse.result.name", hasItems(name1, name2));

    }


    public ValidatableResponse assertNAlphaCodeInAllCountry(String request, String alpha2_code, String alpha3_code) {

        return allCountryResponse(request)
                .then().
                        body("", is(notNullValue())).
                        body("RestResponse.result.alpha2_code", hasItems(alpha2_code)).
                        body("RestResponse.result.alpha3_code", hasItems(alpha3_code));

    }


    public void assertPathForAllCountry(String request, String message1, String message2) {
        List<String> expectedPath = new ArrayList<String>();
        expectedPath.add(message1);
        expectedPath.add(message2);

        List<String> actualPath = allCountryResponse(request).then()
                .extract()
                .path("RestResponse.messages");

        Assert.assertEquals(expectedPath, actualPath);


    }
}

