package testScripts;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class JiraRequest {

	public static void main(String[] args) throws Exception {

		// Create a Request
		RestAssured.baseURI = "https://shareefsdet.atlassian.net/rest/api/3/project/search";

		RequestSpecification httpRequest = RestAssured.given();

		httpRequest.queryParam("maxResults", 50).queryParam("startAt", 0);

		httpRequest.header("Authorization",
				"Basic c2hhcmVlZnNkZXRAZ21haWwuY29tOkFUQVRUM3hGZkdGMHduRXdSLWZYN05UZk5QWWR3Tl9HYWtSb2w0ZXY2RnU0ODZ4akh5OUxrbHltb1hOeWpNOGRtLUtlcnVsVDVDWDAwNE5PcmJaUGp0STdnLXJuY3FaLW4xQmpmamcwMTk4dDVTRGhZTzBYUld4WTJ5eHJJOTV5SFptQlJ4QTZxT25BSFJPSWtFaWhBTzAwdHJVYjEwLURqcEF3WGZXcGZKQm12M2swTHR1NVAzcz0xQ0E1NzYxMQ==");

		httpRequest.header("Accept", "application/json");

		httpRequest.header("Content-Type", "application/json");

		Response httpResponse = httpRequest.request(Method.GET);

		System.out.println(httpResponse.statusCode());

//		System.out.println(httpResponse.asPrettyString());

		JsonPath jsonData = httpResponse.jsonPath();

//		int start = jsonData.getInt("startAt");
//
//		System.out.println(start);
//
//		System.out.println(jsonData.getString("values[0].name"));
//
//		System.out.println(jsonData.getList("values.name"));
//
//		System.out.println(jsonData.getList("values.id"));
//
//		System.out.println(jsonData.getList("values.findAll{it.projectTypeKey=='software'}.id"));
//
//		String proId = jsonData.getString("values.findAll{it.name=='APIBatch001'}.id");
//
//		System.out.println(proId.substring(1, proId.length() - 1));
//		
//		
//		Map firstVal = jsonData.getMap("values[0]");
//		
//		
//		System.out.println(firstVal);
		
		
		
//		JsonPath jsonData = httpResponse.jsonPath();
//		System.out.println(jsonData.getBoolean("isLast"));
//		System.out.println(jsonData.getInt("total"));
//		System.out.println(jsonData.getList("values"));
//		System.out.println(jsonData.getString("values[0].name"));
//		System.out.println(jsonData.getString("values[0].avatarUrls.48x48"));
//		System.out.println(jsonData.getList("values.name"));
//		System.out.println(jsonData.getList("values.id"));
//		System.out.println(jsonData.getString("values.find{it.name=='EveningBatch'}.id"));
//		System.out.println(jsonData.getList("values.findAll{it.projectTypeKey=='software'}.name"));
//		System.out.println(jsonData.getList("values.findAll{it.projectTypeKey=='software'}.name").size());
//
//		Object val = jsonData.getJsonObject("values[0]");
//		System.out.println(val);

//		System.out.println(jsonData.peek());
//		System.out.println(jsonData.prettyPeek());
//		System.out.println(jsonData.prettify());
//		System.out.println(jsonData.prettyPrint());
				
//		List allValues = jsonData.getList("values");
//		for (int i = 0; i < allValues.size(); i++) {
//			UUID uuid = jsonData.getUUID("values[" + i + "].uuid");
//			System.out.println(i + "	" + uuid);
//		}
		
//		Map avatars = jsonData.getMap("values[0].avatarUrls");
//		System.out.println(avatars);
//		
//		
//		ObjectMapper objMap = new ObjectMapper();
//		String ava = objMap.writerWithDefaultPrettyPrinter().writeValueAsString(avatars);
//		System.out.println(ava);
		
		

	}

}
