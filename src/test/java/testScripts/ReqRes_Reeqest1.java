package testScripts;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ReqRes_Reeqest1 {

	public static void main(String[] args) {

		//Create a Request
		RestAssured.baseURI = "https://reqres.in/api/users?page=2";
		RequestSpecification httpRequest = RestAssured.given();
		Response httpResponse = httpRequest.request(Method.GET);

		String response = httpResponse.asString();
		System.out.println(response);

		int code = httpResponse.statusCode();
		System.out.println(code);

		String msg = httpResponse.statusLine();
		System.out.println(msg);

		String headName = httpResponse.getHeader("Content-Type");
		System.out.println(headName);

		Headers heads = httpResponse.getHeaders();
		for (Header head : heads) {
			System.out.println(head);
		}

	}

}
