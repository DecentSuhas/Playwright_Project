package api;

import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class APIClient {

    public Response createUser(
            String username,
            String password){

        return given()
                .header(
                        "Content-Type",
                        "application/json")
                .body(
                        "{ \"username\": \"" + username + "\", \"password\": \"" + password + "\"}")
                .post(
                        "https://restful-booker.herokuapp.com/auth");

    }
}

