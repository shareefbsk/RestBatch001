package testScripts;

import org.json.simple.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import testDataUtility.PlainOldJavaObject;

public class CreateRequestJira {

	public static void main(String[] args) throws Exception {

		String key = "ATATT3xFfGF0wnEwR-fX7NTfNPYdwN_GakRol4ev6Fu486xjHy9LklymoXNyjM8dm-KerulT5CX004NOrbZPjtI7g-rncqZ-n1Bjfjg0198t5SDhYO0XRWxY2yxrI95yHZmBRxA6qOnAHROIkEihAO00trUb10-DjpAwXfWpfJBmv3k0Ltu5P3s=1CA57611";

		// Create a Request
		RestAssured.baseURI = "https://shareefsdet.atlassian.net/rest/api/3/project";
		
		RequestSpecification httpRequest = RestAssured.given();
		
		// Add auth details to request
		httpRequest.header("Authorization", "Basic c2hhcmVlZnNkZXRAZ21haWwuY29tOkFUQVRUM3hGZkdGMHduRXdSLWZYN05UZk5QWWR3Tl9HYWtSb2w0ZXY2RnU0ODZ4akh5OUxrbHltb1hOeWpNOGRtLUtlcnVsVDVDWDAwNE5PcmJaUGp0STdnLXJuY3FaLW4xQmpmamcwMTk4dDVTRGhZTzBYUld4WTJ5eHJJOTV5SFptQlJ4QTZxT25BSFJPSWtFaWhBTzAwdHJVYjEwLURqcEF3WGZXcGZKQm12M2swTHR1NVAzcz0xQ0E1NzYxMQ==");

		// Add header details to request
		httpRequest.header("Accept", "application/json");
		httpRequest.header("Content-Type", "application/json");
		
//		// add body to request in JSON format
//		JSONObject bodyParams = new JSONObject();
//		bodyParams.put("assigneeType", "PROJECT_LEAD");
//		bodyParams.put("key", "BATTESTING");
//		bodyParams.put("leadAccountId", "712020:c297c3b0-a47d-4d03-833f-d4345e53836d");
//		bodyParams.put("name", "Test345");
//		bodyParams.put("projectTypeKey", "business");
//		httpRequest.body(bodyParams.toJSONString());
		
		PlainOldJavaObject pojo = new PlainOldJavaObject();
		pojo.setAssigneeType("PROJECT_LEAD");
		pojo.setKey("POJOCLASSE");
		pojo.setLeadAccountId("712020:c297c3b0-a47d-4d03-833f-d4345e53836d");
		pojo.setName("Pojo Class Example 2");
		pojo.setProjectTypeKey("software");
		
		System.out.println(pojo);
		
		ObjectMapper objMap = new ObjectMapper();
		String jsonData = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(pojo);
		System.out.println(jsonData);
		
		httpRequest.body(jsonData);

		Response httpResponse = httpRequest.request(Method.POST);

		int val = httpResponse.statusCode();

		System.out.println(val);

		System.out.println(httpResponse.statusLine());
		
		PlainOldJavaObject pojo2 = objMap.readValue(jsonData, PlainOldJavaObject.class);
		
		System.out.println(pojo2);

	}

}
