package CareerStepDefination;


import io.cucumber.java.en.*;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import utilities.PayloadUtil;

public class ApiStepDefinitions {

        Response response;
        RequestSpecification request;
    @Given("I send a GET request to {string}")
    public void i_send_a_get_request_to(String url) {
        response = given().log().all().get(url);
    }

        @Then("the response should contain path, ip, and headers")
        public void validate_get_response() {
            response.then().log().all()
                    .statusCode(200)
                    .body("path", notNullValue())
                    .body("ip", notNullValue())
                    .headers("Content-Type", notNullValue());
        }

    @Given("I send a POST request to {string} with order payload")
        public void i_send_a_post_request_to_with_payload(String url) {
            String payload = PayloadUtil.getOrderPayload();
            response = given()
                    .header("Content-Type", "application/json")
                    .body(payload)
                    .log().all()
                    .when()
                    .post(url);
        }

        @Then("the response should contain valid customer, payment, and product information")
        public void validate_post_response() {
            response.then().log().all()
                    .statusCode(anyOf(is(200), is(201)))
                    .body("customer.name", equalTo("Jane Smith"))
                    .body("payment.method", equalTo("credit_card"))
                    .body("items.size()", greaterThan(0));
        }



}

