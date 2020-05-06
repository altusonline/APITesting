package apitest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class FirstGetTest {
	
	@Test
	public void getSingleUser() {		
		given()
		.when()
		 .get("https://reqres.in/api/users/2")
		 .then()
		 .statusCode(200)
		 .statusLine("HTTP/1.1 200 OK")
		 .assertThat().body("data.email", equalTo("janet.weaver@reqres.in")).and()
		 .body("data.first_name", equalTo("Janet")).and()
		 .body("data.last_name", equalTo("Weaver"))
		 .header("Content-Type","application/json; charset=utf-8");
	}
}
