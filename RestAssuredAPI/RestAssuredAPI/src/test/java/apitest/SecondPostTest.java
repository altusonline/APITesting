package apitest;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.HashMap;

public class SecondPostTest {
	
	public static HashMap map = new HashMap();
	
	@BeforeMethod
	public void postData() {
		map.put("FirstName", Util.getFirstName());
		map.put("LastName", Util.getLastName());
		map.put("UserName", Util.getUserName());
		map.put("Password", Util.getPassword());
		map.put("Email", Util.getEmail());
	}
		
	@Test
	public void registerUser() {
		given()
		.contentType("application/json")
		.body(map)
//		.body(
//				"{" +				
//				"\"FirstName\":\"Johnasen\","+
//				"\"LastName\":\"Mattat\","+
//				"\"UserName\":\"M.Johnasen\","+
//				"\"Password\":\"Password12345\","+
//				"\"Email\":\"maatt.ja@fakemail.com\" "+				
//				"}"
//			)
		.when()
			.post("http://restapi.demoqa.com/customer/register")
		.then()
			.statusCode(201)
			.body("SuccessCode", equalTo("OPERATION_SUCCESS"))
			.and().body("Message", equalTo("Operation completed successfully"));
	}

}
