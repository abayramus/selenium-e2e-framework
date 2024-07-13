package stepdefinitions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.restassured.response.Response;
import pojos.dean_controller.DeanPostPojo;
import pojos.dean_controller.DeanPostResponsePojo;
import utilities.ConfigReader;

import java.util.List;
import java.util.Map;

import static base_url.BaseUrl.setUp;
import static base_url.BaseUrl.spec;
import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class DeanAPIStepDefinitions {

    static int userId;
    Response response;
    DeanPostPojo payload;
    DeanPostResponsePojo actualData;

    @Given("{string} yetkisi ile giris yapilir")
    public void yetkisi_ile_giris_yapilir(String profil) {
        if (profil.equalsIgnoreCase("admin")){
//            admin credentials lari ile giris yap
            setUp(ConfigReader.getProperty("username"),ConfigReader.getProperty("password"));
        }else if(profil.equalsIgnoreCase("mudur")){
//            admin credentials lari ile giris yap
            setUp(ConfigReader.getProperty("username_ahmet"),ConfigReader.getProperty("password_ahmet"));
        }else if(profil.equalsIgnoreCase("murvet")){
//            admin credentials lari ile giris yap
            setUp(ConfigReader.getProperty("username_murvet"),ConfigReader.getProperty("password_murvet"));
        }
    }


//    REQUEST TIPINE GORE ENDPOINT OLUSTURUYORUM
    @Given("Dean icin {string} URL olusturulur")
    public void dean_icin_url_olusturulur(String requestType) {
        switch (requestType.toLowerCase()) {
            case "get":
                spec.pathParams("first", "dean", "second", "getAll");
                break;
            case "post":
                spec.pathParams("first", "dean", "second", "save");
                break;
            case "put":
                spec.pathParams("first", "dean", "second", "update", "third", userId);
                break;
            case "delete":
                spec.pathParams("first", "dean", "second", "delete", "third", userId);
                break;
            case "getmanagerbyid":
                spec.pathParams("first", "dean", "second", "getManagerById", "third", userId);
                break;
            default:
                throw new IllegalArgumentException("Invalid request type: " + requestType);
        }
    }


    @Given("Dean icin {string} Request gonderilir ve Response alinir")
    public void dean_icin_request_gonderilir_ve_response_alinir(String requestType) {

        switch (requestType.toLowerCase()) {
            case "get":
                response = given()
                        .spec(spec) // Use existing spec for request setup
                        .when()
                        .get("{first}/{second}");
                System.out.println("Get Request Response body : " + response.asString());
                break;
            case "post":
                response = given(spec).body(payload).when().post("{first}/{second}");
                System.out.println("Post Request Response body : " + response.asString());
                actualData = response.as(DeanPostResponsePojo.class);
                System.out.println("Post Request Actual Data : " + actualData);
                break;
            case "put":
//                response = given(spec).body(payload).when().put("{first}/{second}/{userId}");
                response = given(spec).body(payload).when().put("{first}/{second}/{third}");
                System.out.println("Put Request Response body : " + response.asString());
                actualData = response.as(DeanPostResponsePojo.class);
                System.out.println("Put Request Actual Data : " + actualData);
                break;
            case "delete":
                response = given(spec).when().delete("{first}/{second}/{third}");
                System.out.println("Delete Request Response body : " + response.asString());
                break;
            default:
                throw new IllegalArgumentException("Invalid request type: " + requestType);
        }

        // Print response body (optional)
        System.out.println("Request Response body : "+response.asString());

    }
    @Then("Status kodunun {int} oldugu dogrulanir")
    public void status_kodunun_oldugu_dogrulanir(int expectedStatusCode) {
        System.out.println("Actual Status Code : "+response.statusCode());
        System.out.println("Expected Status Code : "+expectedStatusCode);
        assertEquals("actual", expectedStatusCode, response.statusCode());
    }

    @Then("dean olusturuldugu dogrulanir username {string}, ssn {string}, phone number {string} api")
    public void dean_olusturuldugu_dogrulanir_username_ssn_phone_number_api(String expectedUsername, String expectedSsn, String expectedPhoneNumber) {

        response = given()
                .spec(spec) // Use existing spec for request setup
                .when()
                .get("{first}/{second}");

        // Validate status code of the GET request
        assertEquals("Status code is not as expected!", response.getStatusCode(), 200);
        // Print response body for debugging (optional)
        System.out.println("Get Request Response body : " + response.asString());


//        //        // Retrieve the list of users from the response
//        List<Map<String, String>> users = response.jsonPath().getList("$");
//        // Initialize the boolean to false
//        boolean userFound = false;
//        // Iterate over the list of users
//        for (Map<String, String> user : users) {
//            // Check if the current user matches the expected criteria
//            if (expectedUsername.equals(user.get("username")) && expectedSsn.equals(user.get("ssn")) && expectedPhoneNumber.equals(user.get("phoneNumber"))) {
//                // If a matching user is found, set userFound to true and break the loop
//                userFound = true;
//                break;
//            }
//        }


        //OR WITH LAMBDA
        // Check if any user in the response matches expected criteria
        boolean userFound = response.body().jsonPath().getList("$").stream().anyMatch(
                user -> expectedUsername.equals(((Map<String, String>) user).get("username")) && expectedSsn.equals(((Map<String, String>) user).get("ssn")) && expectedPhoneNumber.equals(((Map<String, String>) user).get("phoneNumber"))
        );
        // Assert that user matching expected criteria is found
        assertEquals("Dean creation verification failed!", true, userFound);
    }
//    CLASS ENDS
}
