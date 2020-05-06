package authentication;

import org.testng.annotations.Test;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class ExtractValueFromResponse {
	
//	https://reqres.in/api/unknown
	
	@Test
	public void getResponseValue() {
		
	Response response =	given()
						.when()
						.get("https://reqres.in/api/unknown")
						.then()
						.extract()
						.response();	
	String responseString = response.asString();
	//System.out.println(responseString);
	JsonPath jsp = new JsonPath(responseString);
	String name = jsp.get("data[3].name");
	System.out.println("Name is: "+name);
	}
}
