package apitest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class SecondGetTest {
	
	@Test
	public void getListOfUser() {
		given()
		.when()
		.get("https://reqres.in/api/users?page=2")
		.then()
		.statusCode(200)
		.assertThat()
		.body("data[0].id", equalTo(7))
		.and().body("data[0].first_name", equalTo("Michael"))
		.and().body("data[4].id", equalTo(11))
		.and().body("data[4].first_name", equalTo("George"));		
	}
}
