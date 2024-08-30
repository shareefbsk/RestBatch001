package testScripts;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class DeleteRequest {

	public static void main(String[] args) {

		// Create a Object to RestAssured
		RequestSpecification httpRequest = RestAssured.given();

		// Add the base uri to our request
		httpRequest.baseUri("https://shareefsdet.atlassian.net/rest/api/3/project");

		// Add the authorization to our request
		httpRequest.header("Authorization",
				"Basic c2hhcmVlZnNkZXRAZ21haWwuY29tOkFUQVRUM3hGZkdGMHduRXdSLWZYN05UZk5QWWR3Tl9HYWtSb2w0ZXY2RnU0ODZ4akh5OUxrbHltb1hOeWpNOGRtLUtlcnVsVDVDWDAwNE5PcmJaUGp0STdnLXJuY3FaLW4xQmpmamcwMTk4dDVTRGhZTzBYUld4WTJ5eHJJOTV5SFptQlJ4QTZxT25BSFJPSWtFaWhBTzAwdHJVYjEwLURqcEF3WGZXcGZKQm12M2swTHR1NVAzcz0xQ0E1NzYxMQ==");

		// Add the Content-Type header to our request
		httpRequest.header("Content-Type", "application/json");

		Response httpResponse = httpRequest.request(Method.DELETE, "TESTINGBAT");

		System.out.println(httpResponse.statusLine());

		System.out.println(httpResponse.statusCode());

	}

}
