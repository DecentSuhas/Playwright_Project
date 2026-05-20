package tests;

import api.APIClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

public class APITest {

    @Test
    public void verifyUserCreationFlow(){

        APIClient apiClient = new APIClient();

        Response response = apiClient.createUser("admin", "password123");

        int statusCode = response.getStatusCode();
        System.out.println(response.toString());
        Assert.assertEquals(statusCode, 200);
        // Add code to verify in UI

    }

}
