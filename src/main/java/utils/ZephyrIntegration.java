package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.JSONObject;
import static io.restassured.RestAssured.given;

public class ZephyrIntegration {

    private static final String BASE_URL = "https://nandakishoreg.atlassian.net";
    private static final String USERNAME = "nandakishoreg.2586@gmail.com";
    private static final String API_TOKEN = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJjb250ZXh0Ijp7ImJhc2VVcmwiOiJodHRwczovL25hbmRha2lzaG9yZWcuYXRsYXNzaWFuLm5ldCIsInVzZXIiOnsiYWNjb3VudElkIjoiNWQzOWM3Mzg3YTExNWEwYzQwMmE0M2IwIiwidG9rZW5JZCI6IjExNTVkZDZiLWU4MDEtNGQwNi1iZmYzLWJmOWVmNWY5OWVkNiJ9fSwiaXNzIjoiY29tLnRoZWQuemVwaHlyLmplIiwic3ViIjoiMzU0Y2MyYTMtYTZhMC0zOTY0LTg3YTUtMTE0M2ViMTAwODk4IiwiZXhwIjoxNzU5ODcwMTI3LCJpYXQiOjE3MjgzMzQxMjd9.RVPhR_zN9F9n6tmbr9s03w7Cx94Z9uB4Vui7R0V5kec";
    private static final String TEST_CYCLE_ID = "NK-R1"; // Replace with your test cycle ID
    //Automation Status Update

    // Headers for the API authentication
    private static String createAuthHeader() {
        return "Basic " + java.util.Base64.getEncoder().encodeToString((USERNAME + ":" + API_TOKEN).getBytes());
    }

    // Post the result to Jira Zephyr
    public static void postTestResult(String issueKey, String status) {
        RestAssured.baseURI = BASE_URL;

        // Create the request body
        JSONObject requestBody = new JSONObject();
        requestBody.put("status", status); // "PASS" or "FAIL"
        requestBody.put("issueKey", issueKey);
        requestBody.put("testCycleId", TEST_CYCLE_ID);

        // Make the REST call to Zephyr
        Response response = given()
                .header("Authorization", createAuthHeader())
                .header("Content-Type", "application/json")
                .body(requestBody.toString())
                .post("/rest/zephyr-scale/latest/executions");

        if (response.getStatusCode() == 200 || response.getStatusCode() == 201) {
            System.out.println("Test Result successfully reported to Jira Zephyr for issue: " + issueKey);
        } else {
            System.out.println("Failed to report test result. Status Code: " + response.getStatusCode());
        }
    }
}