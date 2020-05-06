package apitest;

import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class ThirdGetTest {
	
	@Test
	public void getCityByZipCode() {
		
		given()
		.pathParam("country", "us")
		.pathParam("zipcode", "75075")
		.when()
		.get("http://api.zippopotam.us/{country}/{zipcode}")
		.then()
		.statusCode(200)
		.assertThat()
		.body("places[0].'place name'", equalTo("Plano"));
		
	}
	
	

}
