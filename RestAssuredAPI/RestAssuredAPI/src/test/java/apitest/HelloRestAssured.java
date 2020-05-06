package apitest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;

public class HelloRestAssured {
	
	@Test
	public void HiGoogle() {
		given().log().all()
		.when()
		.get("http://www.google.com")
		.then().log().all()
		.statusCode(200);
	}
}






