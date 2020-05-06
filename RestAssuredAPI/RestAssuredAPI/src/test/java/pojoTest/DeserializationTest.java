package pojoTest;

import static io.restassured.RestAssured.given;
import java.util.List;
import org.testng.annotations.Test;
import pojo.Data;
import pojo.Request;

public class DeserializationTest {
	
	
	@Test
	public void getWeatherTest() {
		Request rq = given()
	                   .when()
	  	               .get("https://reqres.in/api/unknown").as(Request.class);	
	System.out.println(rq.getPage());
	System.out.println(rq.getData().get(1).getName());
	
	List<Data> name = rq.getData();
	for(int i=0; i<name.size(); i++) {
		if(name.get(i).getName().equals("blue turquoise")) {
			System.out.println(name.get(i).getYear());
		}
	}
	
}
	
}
