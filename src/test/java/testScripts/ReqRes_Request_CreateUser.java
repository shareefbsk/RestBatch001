package testScripts;

import org.json.simple.JSONObject;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class ReqRes_Request_CreateUser {

	public static void main(String[] args) {

		// Create a Request
		RestAssured.baseURI = "https://reqres.in/api/users";
		RequestSpecification httpRequest = RestAssured.given();

		// Provide Body params in request in JSON format
		JSONObject bodyParams = new JSONObject();
		bodyParams.put("name", "Shareef");
		bodyParams.put("job", "teacher");
		httpRequest.body(bodyParams.toJSONString());

		// Send the request to server
		Response httpResponse = httpRequest.request(Method.POST);

		// Validate status code
		int code = httpResponse.statusCode();
		System.out.println(code);

		String msg = httpResponse.statusLine();
		System.out.println(msg);

	}

}
