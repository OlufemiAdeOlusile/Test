package hotels.com.assesment.acmeApi.country;

import com.jayway.restassured.RestAssured;
import com.jayway.restassured.response.Response;
import com.jayway.restassured.response.ValidatableResponse;
import org.junit.Test;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

import static com.jayway.restassured.RestAssured.when;
import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by ${Femi} on ${07/03/2016}.
 */
public class SearchByIsoCode {

    String url = "http://services.groupkt.com";

    public SearchByIsoCode(String url) {
        this.url = url;
    }

    public Response isoCodeResponse(String response) {
        RestAssured.baseURI = url;
        return when().
                get(response);

    }

    public ValidatableResponse assertNameOfIsoCodeCountry(String request, String name1) {

        return isoCodeResponse(request)
                .then().
                        body("", is(notNullValue())).
                        assertThat().body("RestResponse.result.name", equalTo(name1));

    }


    public ValidatableResponse assertNAlphaCodeOfIsoCodeCountry(String request, String alpha2_code, String alpha3_code) {

        return isoCodeResponse(request)
                .then().
                        body("", is(notNullValue())).
                        body("RestResponse.result.alpha2_code", equalTo(alpha2_code)).
                        body("RestResponse.result.alpha3_code", equalTo(alpha3_code));


    }


    public void assertMessagePathForIsoCodeCountry(String request, String message1) {
        List<String> expectedPath = new ArrayList<String>();
        expectedPath.add("More webservices are available at http://www.groupkt.com/post/f2129b88/services.htm");
        expectedPath.add(message1);
        List<String> actualPath = isoCodeResponse(request).then()
                .extract()
                .path("RestResponse.messages");

        Assert.assertEquals(expectedPath, actualPath);

    }

}






