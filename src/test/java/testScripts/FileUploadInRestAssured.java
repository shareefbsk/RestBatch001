package testScripts;

import java.io.File;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class FileUploadInRestAssured {

	public static void main(String[] args) {

		// Create a Object to RestAssured
		RequestSpecification httpRequest = RestAssured.given();

		// Add the base uri to our request
		httpRequest.baseUri("https://the-internet.herokuapp.com/upload");

		// Create a File Object
		File fileObj = new File("C:\\Users\\91900\\Desktop\\WS-Image.jpg");
		File fileObj2 = new File("C:\\Users\\91900\\Desktop\\Agile.jpg");
		// upload a file to our request
		httpRequest.multiPart("file", fileObj);
		httpRequest.multiPart("file", fileObj2);
		
//		httpRequest.header("Content-Type", "multipart/form-data");

		// Send the Request to the server
		Response httpResponse = httpRequest.post();

		System.out.println(httpResponse.statusCode());

	}

}
