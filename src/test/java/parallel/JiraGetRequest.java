package parallel;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JiraGetRequest {

	public RequestSpecification httpGetRequest;
	public Response httpGetResponse;

	@BeforeTest
	public void setUp() {
		// Create RestAssured Request
		httpGetRequest = RestAssured.given();

		// Add the URI to RestAssured Request
		httpGetRequest.baseUri("https://shareefsdet.atlassian.net/rest/api/3/project/search");

		// Add URI to our RestAssured Request
		httpGetRequest.header("Authorization",
				"Basic c2hhcmVlZnNkZXRAZ21haWwuY29tOkFUQVRUM3hGZkdGMHduRXdSLWZYN05UZk5QWWR3Tl9HYWtSb2w0ZXY2RnU0ODZ4akh5OUxrbHltb1hOeWpNOGRtLUtlcnVsVDVDWDAwNE5PcmJaUGp0STdnLXJuY3FaLW4xQmpmamcwMTk4dDVTRGhZTzBYUld4WTJ5eHJJOTV5SFptQlJ4QTZxT25BSFJPSWtFaWhBTzAwdHJVYjEwLURqcEF3WGZXcGZKQm12M2swTHR1NVAzcz0xQ0E1NzYxMQ==");

		// Add headers to our RestAssured Request
		httpGetRequest.header("Accept", "application/json");
		httpGetRequest.header("Content-Type", "application/json");

	}

	@Test
	public void sendGetRequest() {
		httpGetResponse = httpGetRequest.get();
	}

	@Test(priority = 2, enabled = true)
	public void verifyStatusCode() {
		Assert.assertEquals(httpGetResponse.statusCode(), 200);
		Reporter.log("StatusCode Matched Successfully");
	}

	@Test(priority = 3, enabled = true)
	public void verifyStatusLine() {
		Assert.assertEquals(httpGetResponse.statusLine(), "HTTP/1.1 200 OK");
		Reporter.log("StatusLine Matched Successfully");
	}

	@Test(priority = 4, enabled = true)
	public void verifyHeader() {
		Assert.assertEquals(httpGetResponse.getHeader("Content-Type"), "application/json;charset=UTF-8");
		Reporter.log("Content-Type Header Matched Successfully");
	}

	@Test(priority = 5, enabled = true)
	public void verifyBody() {
		JsonPath jsonData = httpGetResponse.jsonPath();
		Assert.assertEquals(jsonData.getList("values").size(), 18);
		Reporter.log("Response Body Matched Successfully");
	}

}
