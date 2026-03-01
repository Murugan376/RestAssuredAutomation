package StepDefinition;

import Utils.APIResources;
import Utils.SpecBuilder;
import Utils.TestData;
import Utils.Util;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import jdk.jfr.Name;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class StepDefinitions {

    TestData data = new TestData();

    public RequestSpecification req;
    public Response res;
    public static String place_id;

    @Name("add payload method without arguments")
    @Given("Add place payload")
    public RequestSpecification add_place_payload() throws IOException {
        req = given().spec(SpecBuilder.requestBuilder()).body(data.addPlacePayload());
        return req;
    }

    @Name("add payload method with arguments")
    @Given("Add place payload with {string},{string},{string}")
    public void add_place_payload_with_multiple_testcases(String name, String language, String address) throws IOException {
        req = given().spec(SpecBuilder.requestBuilder()).body(data.addPlacePayloadWithParamter(name,language,address));
    }

    @Name("user calling the resource with enum class and put the method also using java conditions")
    @When("User calls {string} with {string} http request")
    public void user_Calls_With_Http_Request(String resource, String method) {

        /*passing the resourcename from cucumber file to enum class
        based on the name of the cucumber which same name data get from the enum class to step def class
        pass that value to the method using arguments - it is nothing but encapsulation*/

        //enum
        APIResources resourcename = APIResources.valueOf(resource);


        if(method.equalsIgnoreCase("post")) {
            res = req.when().post(resourcename.getresourcename());
        } else if(method.equalsIgnoreCase("get")) {
            res = req.when().get(resourcename.getresourcename());
        } else if(method.equalsIgnoreCase("delete")) {
            res = req.when().delete(resourcename.getresourcename());
        } else if(method.equalsIgnoreCase("put")) {
            res = req.when().put(resourcename.getresourcename());
        }
    }

    @Name("Validated the success code of the request initiated")
    @Then("the API call got success with status code {int}")
    public void the_api_call_got_success_with_status_code(int statuscode) {
        assertEquals(statuscode, res.getStatusCode());
    }

    @Name("Validated the response using util jsonpath method along with key and value")
    @And("{string} in response body is {string}")
    public void in_response_body_is(String key, String value) {
        assertEquals(Util.getJsonPath(res,key),value);
    }

    @Name("Verify the added place for the person using get method")
    @And("Verify {string} created maps to {string} using {string}")
    public void verify_Created_Maps_To_Using(String placeid, String name, String resource) throws IOException {
        place_id = Util.getJsonPath(res,placeid);
        req = given().spec(SpecBuilder.requestBuilder()).queryParam("place_id", place_id);
        System.out.println(place_id + " for the " + name + " of the person using the " + resource);
    }

    //section 88
    @Given("Get the user place payload using get method with {string} value from {string} response")
    public void get_the_user_place_payload_using_get_method_with_value_from_response(String placeid, String resource) throws IOException {
        add_place_payload();
        user_Calls_With_Http_Request(resource,"post");
        place_id = Util.getJsonPath(res,placeid);
        req = given().spec(SpecBuilder.requestBuilder()).queryParam("place_id", place_id);
    }

    //section 89
    @Given("Delete place payload using place_id value from AddPlaceAPI response from previous tescase")
    public void delete_place_payload_using_place_id_value_from_add_place_api_response_from_previous_tescase() throws IOException {
        req = given().spec(SpecBuilder.requestBuilder()).body(data.deletePlace(place_id));
    }





}
