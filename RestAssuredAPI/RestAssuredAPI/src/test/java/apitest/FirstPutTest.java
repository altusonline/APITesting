package apitest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class FirstPutTest {
	
	@Test
	public void updateUser() {
		given()
		.contentType("application/json")
		.body(
				"{"+
				    "\"name\": \"morpheus\","+
				    "\"job\": \"zion resident\" "+
				"}"
				
			)
		.when()
			.put("https://reqres.in/api/users/2")
		
		.then()
			.statusCode(200)
			.and()
			.body("name", equalTo("morpheus"))
			.and()
			.body("job", equalTo("zion resident"));
	}

}
