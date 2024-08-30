package testNGExamples;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class TestExample2 {

	public RequestSpecification httpRequest2;
	public Response httpResponse2;

	@Test(priority = 0, enabled = true)
	public void jiraSetUp() {
		// Create RestAssured Request
		httpRequest2 = RestAssured.given();

		// Add the URI to RestAssured Request
		httpRequest2.baseUri("https://shareefsdet.atlassian.net/rest/api/3/project/search");

		// Add URI to our RestAssured Request
		httpRequest2.header("Authorization",
				"Basic c2hhcmVlZnNkZXRAZ21haWwuY29tOkFUQVRUM3hGZkdGMHduRXdSLWZYN05UZk5QWWR3Tl9HYWtSb2w0ZXY2RnU0ODZ4akh5OUxrbHltb1hOeWpNOGRtLUtlcnVsVDVDWDAwNE5PcmJaUGp0STdnLXJuY3FaLW4xQmpmamcwMTk4dDVTRGhZTzBYUld4WTJ5eHJJOTV5SFptQlJ4QTZxT25BSFJPSWtFaWhBTzAwdHJVYjEwLURqcEF3WGZXcGZKQm12M2swTHR1NVAzcz0xQ0E1NzYxMQ==");

		// Add headers to our RestAssured Request
		httpRequest2.header("Accept", "application/json");
		httpRequest2.header("Content-Type", "application/json");

	}

	@Test(priority = 1, enabled = true)
	public void sendRequest2() {
		httpResponse2 = httpRequest2.get();
	}

	@Test(priority = 2, enabled = true)
	public void verifyStatusCode2() {
		Assert.assertEquals(httpResponse2.statusCode(), 200);
		Reporter.log("StatusCode Matched Successfully");
	}

	@Test(priority = 3, enabled = true)
	public void verifyStatusLine2() {
		Assert.assertEquals(httpResponse2.statusLine(), "HTTP/1.1 200 OK");
		Reporter.log("StatusLine Matched Successfully");
	}

	@Test(priority = 4, enabled = true)
	public void verifyHeader2() {
		Assert.assertEquals(httpResponse2.getHeader("Content-Type"), "application/json;charset=UTF-8");
		Reporter.log("Content-Type Header Matched Successfully");
	}

	@Test(priority = 5, enabled = true)
	public void verifyBody2() {
		JsonPath jsonData = httpResponse2.jsonPath();
		Assert.assertEquals(jsonData.getList("values").size(), 20);
		Reporter.log("Response Body Matched Successfully");
	}

}
