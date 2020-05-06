package apitest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class FirstPostTest {
	
	@Test
	public void registerUser() {
		
		given()
			.contentType("application/json")
			.body(
					"{"+
					"\"name\":\"morpheus\"," +
					"\"job\": \"leader\" "+
					"}"
				)
		.when()
			.post("https://reqres.in/api/users")
		.then()
			.statusCode(201)
			.and()
			.body("name", equalTo("morpheus"))
			.and()
			.body("job", equalTo("leader"));
	}

}
