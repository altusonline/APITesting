package apitest;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class GetUsingDataProvider {
	
	@DataProvider(name = "zipcodes")
	public String[][] createZipCodeTestData() {
	        
	  return new String[][] {
	    {"us","75075","Plano"},
	    {"us","12345","Schenectady"},
	    {"us","22312","Alexandria"},
	    {"us","56273","New London"},
	    {"us","22222","Arlington"}
	  };
	}
	

	@Test(dataProvider = "zipcodes")
	public void getZipCodeTest(String country, String zipcode, String city) {
	        
	  given()
	    .pathParam("country",country)
	    .pathParam("zipcode",zipcode)
	  .when()
	    .get("http://api.zippopotam.us/{country}/{zipcode}")
	  .then()
	  	.statusCode(200).and()
	    .assertThat()
	    .body("places[0].'place name'",equalTo(city));
	}
}
