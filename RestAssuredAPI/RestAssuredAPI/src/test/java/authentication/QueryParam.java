package authentication;

import org.testng.annotations.Test;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class QueryParam {
	
	// REST APIs have four types of parameters:
	
	// 1. Header parameters:Parameters included in the request header, usually related to authorization.
			// URL - https://gorest.co.in/public-api/comments
			// Authorization  -  Bearer cTqbk5U88Tml8pCVyICn4E_ctGmrRgC7JJos
		
	// 2. Path parameters: Parameters within the path of the endpoint, 
	//                     before the query string (?). These are usually set off within curly braces.
			// http://api.zippopotam.us/{country}/{zipcode}

	// 3. QUery string parameters: Parameters in the query string of the endpoint, after the ?.
			//http://www.omdbapi.com/?t=Game of Thrones&Season=1&apikey=thewdb
	
	// 4. Request body parameters: Parameters included in the request body. Usually submitted as JSON.
	/*         {
			  		"name":"John"
			 		"job":"Lead"
			   } 
	*/
	
	@Test
	public void createPlaceAPI() {
		RestAssured.baseURI = "http://216.10.245.166";
//		String place = "0ff4bfb359da4f0d9ccba0ad796ac0cf";
		given()
		   .queryParam("key","qaclick123")
		   .body("{" +		          
					"\"location\":{" +
		        	"\"lat\" : -33.8669713,"+
		        	"\"lng\" : 151.1958750"+
		    		"},"+
					"\"accuracy\":50,"+
					"\"name\":\"Frontline house\","+
					"\"phone_number\":\"(+91) 983 893 3937\","+
					"\"address\" : \"29, side layout, cohen 09\","+
					"\"types\": [\"shoe park\",\"shop\"],"+
				    "\"website\" : \"http://google.com\","+
				    "\"language\" : \"French-IN\""+
				"}"
                )
	   .when().log().all()
		   	.post("/maps/api/place/add/json")	 
	   .then().log().all()
	       .assertThat().statusCode(200)
	       .and().contentType(ContentType.JSON)
	       .and().body("status",equalTo("OK"))
		   .extract().response();	
	}
	
	
	
					
	@Test
	public void deletePlaceAPI() {
		RestAssured.baseURI = "http://216.10.245.166";
		String place = "4f4c045cd87dd1cc57eb9e2fc1e334d9";
		given()
		   .queryParam("key","qaclick123")
		   .body("{" +
		          "\"place_id\":\""+place+"\"" +
		         "}")
		.when().log().all()
		   .post("/maps/api/place/delete/json")	 
	    .then().log().all()
	       .assertThat().statusCode(200)
	       .and().contentType(ContentType.JSON)
	       .and().body("status",equalTo("OK"));
	}

}











