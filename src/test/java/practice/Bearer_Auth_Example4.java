package practice;

import java.io.File;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Bearer_Auth_Example4 {

	@Test
	public void bearerToken2() {

		// Create a RestAssured Object
		RequestSpecification httpRequest = RestAssured.given();

		// Provide the URI into our request
		httpRequest.baseUri("https://gorest.co.in/public/v2/users");

		// Add authorization scheme in our request via header
		httpRequest.header("Authorization", "Bearer 34281b4d222f96441274c11184bafd027b6c85af1f68971056a57e497a67e4e2");
		
		httpRequest.header("Content-Type", "application/json");
		
		
		// Create Body to add into request
		JSONObject bodyParams = new JSONObject();
		bodyParams.put("name", "NTR3");
		bodyParams.put("gender", "male");
		bodyParams.put("email", "ntr3@gmail.com");
		bodyParams.put("status", "active");

//		String jsonBody = "{\"name\":\"NTR\", \"gender\":\"male\", \"email\":\"ntr@gmail.com\", \"status\":\"active\"}";
			
		
		File jsonFile = new File("C:\\Users\\91900\\eclipse-workspace\\QEdgeAPIBatch001\\src\\test\\resources\\TestDataFiles\\GoRestPostRequestData.json");
		
		
		// Add Body scheme into our request
//		httpRequest.body("{\r\n"
//				+ "    \"name\": \"NTR\",\r\n"
//				+ "    \"gender\": \"male\",\r\n"
//				+ "    \"email\": \"ntr@gmail.com\",\r\n"
//				+ "    \"status\": \"active\"\r\n"
//				+ "}");
		
//		httpRequest.body(jsonFile);
		
		httpRequest.body(bodyParams.toJSONString());
		
		// Send the request to GoRest Server and catch the response into a variable
		Response httpResponse = httpRequest.request(Method.POST);

		System.out.println(httpResponse.statusCode());
		System.out.println(httpResponse.statusLine());
		System.out.println(httpResponse.asPrettyString());

	}

}
