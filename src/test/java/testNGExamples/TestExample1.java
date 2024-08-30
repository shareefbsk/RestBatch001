package testNGExamples;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;

import extentReports.ReporterManager;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//@Listeners(testNGExamples.Listeners.class)
public class TestExample1 {

	public RequestSpecification httpRequest1;
	public Response httpResponse1;
	public ExtentReports report = ReporterManager.createReport();

	@Test(priority = 0, enabled = true)
	public void createRestAssuredObject() {
		httpRequest1 = RestAssured.given();
		report.createTest("createRestAssuredObject");
	}

	@Test(priority = 1, enabled = true)
	public void addURI() {
		httpRequest1.baseUri("https://shareefsdet.atlassian.net/rest/api/3/project/search");
		report.createTest("addURI");
	}

	@Test(priority = 2, enabled = true)
	public void addAuthorization() {
		httpRequest1.header("Authorization",
				"Basic c2hhcmVlZnNkZXRAZ21haWwuY29tOkFUQVRUM3hGZkdGMHduRXdSLWZYN05UZk5QWWR3Tl9HYWtSb2w0ZXY2RnU0ODZ4akh5OUxrbHltb1hOeWpNOGRtLUtlcnVsVDVDWDAwNE5PcmJaUGp0STdnLXJuY3FaLW4xQmpmamcwMTk4dDVTRGhZTzBYUld4WTJ5eHJJOTV5SFptQlJ4QTZxT25BSFJPSWtFaWhBTzAwdHJVYjEwLURqcEF3WGZXcGZKQm12M2swTHR1NVAzcz0xQ0E1NzYxMQ==");
		report.createTest("addAuthorization");
	}

	@Test(priority = 3, enabled = true)
	public void addHeaders() {
		httpRequest1.header("Accept", "application/json");
		httpRequest1.header("Content-Type", "application/json");
		report.createTest("addHeaders");
	}

	@Test(priority = 4, enabled = true)
	public void sendRequest() {
		httpResponse1 = httpRequest1.get();
		report.createTest("sendRequest");
	}

	@Test(priority = 5, enabled = true)
	public void verifyStatusCode() {
		Assert.assertEquals(httpResponse1.statusCode(), 200);
		Reporter.log("StatusCode Matched Successfully");
		report.createTest("verifyStatusCode");
	}

	@Test(priority = 6, enabled = true)
	public void verifyStatusLine() {
		Assert.assertEquals(httpResponse1.statusLine(), "HTTP/1.1 200 OK");
		Reporter.log("StatusLine Matched Successfully");
		report.createTest("verifyStatusLine");
	}

	@Test(priority = 7, enabled = true)
	public void verifyHeader() {
		Assert.assertEquals(httpResponse1.getHeader("Content-Type"), "application/json;charset=UTF-8");
		Reporter.log("Content-Type Header Matched Successfully");
		report.createTest("verifyHeader");
	}

	@Test(priority = 8, enabled = true)
	public void verifyBody() {
		JsonPath jsonData = httpResponse1.jsonPath();
		Assert.assertEquals(jsonData.getList("values").size(), 20);
		Reporter.log("Response Body Matched Successfully");
		report.createTest("verifyBody");
	}
	
	@AfterSuite
	public void tearDown() {
		report.flush();
	}

}
