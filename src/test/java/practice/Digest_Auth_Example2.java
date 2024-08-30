package practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Digest_Auth_Example2 {

	@Test
	public void digestAuth() {

		// Create a RestAssured Object
		RequestSpecification httpRequest = RestAssured.given();

		// Provide the URI into the request
		httpRequest.baseUri("https://the-internet.herokuapp.com/digest_auth");

		// Provide the Authorization into the request
		httpRequest.auth().digest("admin", "admin");
		
		// Send the GET request to the server and catch the response into a variable
		Response httpResponse = httpRequest.request(Method.GET);
		
		//Capture the status code from the entire response
		int code = httpResponse.statusCode();
		
		//Capture the status line from the entire response
		String line = httpResponse.statusLine();
		
		System.out.println("Status Code is : "+code);
		System.out.println("Status Line is : "+line);

	}

}
