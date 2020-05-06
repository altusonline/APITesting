package authentication;

import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import org.testng.annotations.Test;

public class AuthenticationApi {
	
	 //4 Most Used Authentication Methods
		//1. HTTP Authentication Schemes - Basic, Bearer 
		//2. API Keys
		//3. OAuth (2.0)
		//4. OpenID Connect
	
	@Test
	public void basic_authentication() {
		given()
			.auth()
			.preemptive()
			.basic("admin", "admin")
		.when().log().all()
			.get("http://the-internet.herokuapp.com/basic_auth")
		.then().log().all()
			.statusCode(200);
	}
	
	
	@Test
	public void oath_authentication() {	
		given()
			.auth()
			 .oauth2("_FWTKt73f0EeVrfWj7d3sKoLMnw_9dqVcs0k")
		.when().log().all()
			.get("https://gorest.co.in/public-api/users?first_name=Elva")
		.then().log().all()
			.statusCode(200);		
	}
	
	
	
	@Test
	public void Outh_Header_Test() {
		given()
			.contentType("application/json")
			.header("Authorization", "Bearer 0/f06f332c9759b37576ffe987a835f6d0")
		.when()
			.get("https://app.asana.com/api/1.0/workspaces")
			.then().log().all()
			.statusCode(200);
	}
	
	
}













