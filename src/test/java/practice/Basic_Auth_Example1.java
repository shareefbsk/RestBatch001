package practice;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class Basic_Auth_Example1 {

	@Test
	public void basicAuth() {

		// Create a HTTP Request

		// provide uri to restassured
		RestAssured.baseURI = "https://the-internet.herokuapp.com/basic_auth";

		// Create a RestAssured Object for adding remaining schemes
		RequestSpecification httpRequest = RestAssured.given();
		
		//Add the authorization to our request
		httpRequest.auth().basic("admin", "admin");

		Response httpResponse = httpRequest.request(Method.GET);

		System.out.println(httpResponse.asPrettyString());
		System.out.println();
		System.out.println("==============================================");
		System.out.println();
		System.out.println(httpResponse.prettyPrint());
		System.out.println(httpResponse.statusCode());

	}

}
