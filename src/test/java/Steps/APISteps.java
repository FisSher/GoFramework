package Steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.*;



/*
* - Creating a new user, post, comment and to do.
*  Test for success scenarios and also for when some mandatory fields are missing.
- Test if you can create two users with the same email address.
- Test if the endpoints allow you to create new entries with invalid email address formats.
- Fetch the entries that you created, test that the returned data matches your input.
* */

public class APISteps {


    private static RequestSpecification request;
    private Response response;
    private ValidatableResponse json;
    private static final String bearerToken = "71c7953fd5291030f6ad6846972eb5eb66383edbd9bc1a431ea110f8751be90e";


    @Given("^a GET request is sent to the (.+) endpoint$")
    public void setBaseUri(String URI) {
        request =  given()
                .headers(
                        "Authorization",
                        "Bearer " + bearerToken,
                        "Content-Type",
                        ContentType.JSON)
                .baseUri(URI);
    }

    @Then("^a (\\d+) status code is received$")
    public void validateResponseCode(int expecteStatusCode) {
        response = request
                .when()
                .get("users");
        json = response.then().statusCode(expecteStatusCode);
    }


}
